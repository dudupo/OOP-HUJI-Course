import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import oop.ex2.*;

/**
 * The API spaceships need to implement for the SpaceWars game. 
 * It is your decision whether SpaceShip.java will be an interface, an abstract class,
 *  a base class for the other spaceships or any other option you will choose.
 *  
 * @author oop
 */
public class SpaceShip{

    // The physical View of the object.
    protected SpaceShipPhysics physicsInstance;
    // the graphics while the shield down.
    protected Image shipImage = GameGUI.ENEMY_SPACESHIP_IMAGE;
    // the graphics while the shield activate.
    protected Image shipImageUnderShield = GameGUI.ENEMY_SPACESHIP_IMAGE_SHIELD;
    // boolean flag which indicate if the shield have turned-on.
    protected boolean shieldState = false;

    // the initial amount of energy capacity that given to ship, when the game start.
    public static final int INITALMAXIMALENERGY = 210;

    // the initial amount of energy that given to ship, when the game start.
    public static final int INITALENERGY = 190;

    // the limit of Energy, the ship can charges.
    private int maximalEnergy = SpaceShip.INITALENERGY;

    // the current Energy, that the ship holds.
    private int currentEnergy = maximalEnergy;

    // the amount of Energy which the ship accumulate every turn.
    public static final int fluxEnergy = 1;

    // the amount of Energy which should Consumed for activate shield.
    public static final int shieldConsuming = 3;
    // the amount of Energy which should Consumed for firing.
    public static final int fireConsuming = 19;
    // the amount of Energy which should Consumed for teleportion.
    public static final int teleportConsuming = 140;

    // the amount of the energy which reduced from maximal capacity of energy
    // when the ship has been hit.
    public static final int HITEDDAMEGE_MAX_ENERGY_REDUCE = 10;

    // the amount of the energy, which accumulated by hitting other ship, while the shield activated.
    public static final int BASHING_ACCUMULATION = 18;

    // the initial life which the spaceship have been initialized with.
    public static final int INITALHEALTH = 22;

    // the current health the ship has.
    private int shipHealth = SpaceShip.INITALHEALTH;

    // the amount of life which reduced from the health of the ship when hitted.
    public static final int HITEDDAMEGE = 1;


    // the number of rounds which require for pass, between adjacent-
    // -pair rounds.
    public static final int loadingTime = 7;


    // the number of rounds which, the spaceship should pass, before it could
    // shot again.
    private int shotinground  = 0;

    /**
     *  constractor
     */
    public SpaceShip() {
        this.physicsInstance = new SpaceShipPhysics();
    }

    /**
     * Does the actions of this ship for this round.
     * This is called once per round by the SpaceWars game driver.
     * 
     * @param game the game object to which this ship belongs.
     */
    public void doAction(SpaceWars game) {
        this.shieldState = false;

        if (this.currentEnergy <= this.maximalEnergy) {
            this.currentEnergy += SpaceShip.fluxEnergy;
        }

        if ( this.shotinground > 0 )
            this.shotinground -= 1;

        this.getPhysics().move(false, 0);
    }

    /**
     * This method is called every time a collision with this ship occurs 
     */
    public void collidedWithAnotherShip(){

        if ( this.shieldState ){
            this.maximalEnergy += SpaceShip.BASHING_ACCUMULATION;
            this.currentEnergy += SpaceShip.BASHING_ACCUMULATION;
        }
        else {
            this.shipHealth -= SpaceShip.HITEDDAMEGE;
        }
    }

    /** 
     * This method is called whenever a ship has died. It resets the ship's 
     * attributes, and starts it at a new random position.
     */
    public void reset(){
        this.physicsInstance = new SpaceShipPhysics();

        this.shipHealth = SpaceShip.INITALHEALTH;
        this.maximalEnergy = SpaceShip.INITALMAXIMALENERGY;
        this.currentEnergy = SpaceShip.INITALENERGY;

    }

    /**
     * Checks if this ship is dead.
     * 
     * @return true if the ship is dead. false otherwise.
     */
    public boolean isDead() {
        return this.shipHealth <= 0;
    }

    /**
     * Gets the physics object that controls this ship.
     * 
     * @return the physics object that controls the ship.
     */
    public SpaceShipPhysics getPhysics() {
        return this.physicsInstance;
    }

    /**
     * This method is called by the SpaceWars game object when ever this ship
     * gets hit by a shot.
     */
    public void gotHit() {
        this.maximalEnergy -= SpaceShip.HITEDDAMEGE_MAX_ENERGY_REDUCE;

        if ( !this.shieldState) {
            this.shipHealth -= SpaceShip.HITEDDAMEGE;
        }

    }

    /**
     * Gets the image of this ship. This method should return the image of the
     * ship with or without the shield. This will be displayed on the GUI at
     * the end of the round.
     *
     * @return the image of this ship.
     */
    public Image getImage(){
        return this.shieldState ? this.shipImageUnderShield : this.shipImage ;
    }

    /**
     *   Closures which getting the current energy and the required energy, and executing the function
     *   only if the ship has enough energy. than returns the new amount of energy which the ship holds after
     *   the action.
     */
    public abstract class EnergyActionConsumer {

        private int currentEnergy ;
        private int requiredEnergy ;

        /**
         * constructor.
         * @param currentEnergy - the amount of energy which the ship holds.
         * @param requiredEnergy - the amount of energy which the action consumes.
         */

        public EnergyActionConsumer( int currentEnergy, int requiredEnergy ) {
            this.currentEnergy = currentEnergy;
            this.requiredEnergy = requiredEnergy;

        }

        /**
         * executing the action if the ship has enough energy.
         * @return the new amount of energy which the ship holds after
         *          the action.
         */

        public int run() {
            int newEnergy = this.currentEnergy;

            if ( this.requiredEnergy <= this.currentEnergy ) {
                this.action();

                newEnergy = this.currentEnergy - this.requiredEnergy;
            }

            return newEnergy;
        }


        /**
         * the abstract action, should be implemented by case.
         */
        public abstract void action() ;
    }




    /**
     * Attempts to fire a shot.
     * 
     * @param game the game object.
     */
    public void fire(SpaceWars game) {

        if ( this.shotinground == 0 ) {

            this.currentEnergy = new EnergyActionConsumer(this.currentEnergy, SpaceShip.fireConsuming) {

                @Override
                public void action() {
                    game.addShot(physicsInstance);
                    shotinground = loadingTime;
                }

            }.run();
        }

    }

    /**
     * Attempts to turn on the shield.
     */
    public void shieldOn() {

        this.currentEnergy = new EnergyActionConsumer(this.currentEnergy ,SpaceShip.shieldConsuming) {

            @Override
            public void action() {
                shieldState = true;
            }

        }.run();


    }

    /**
     * Attempts to teleport.
     */
    public void teleport() {

        this.currentEnergy = new EnergyActionConsumer(this.currentEnergy ,SpaceShip.teleportConsuming) {

            @Override
            public void action() {
                physicsInstance = new SpaceShipPhysics();
            }

        }.run();
    }
    
}
