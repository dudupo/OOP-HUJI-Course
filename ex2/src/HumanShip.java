import oop.ex2.GameGUI;

public class HumanShip extends SpaceShip  {

    /**
     *  constructor setting the Image to player`s spaceship Image.
     */



    public HumanShip() {

        this.shipImage = GameGUI.SPACESHIP_IMAGE;
        this.shipImageUnderShield = GameGUI.SPACESHIP_IMAGE_SHIELD;

    }

    /**
     * implementation of the action method, responsible to getting
     * input from the user.
     * @param game the game object to which this ship belongs.
     */
    @Override
    public void doAction(SpaceWars game) {
        super.doAction(game);

        if (game.getGUI().isShieldsPressed())
            this.shieldOn();

        if (game.getGUI().isLeftPressed()){
            this.physicsInstance.move(false,1);
        }

        if (game.getGUI().isRightPressed()){
            this.physicsInstance.move(false,-1);
        }

        if (game.getGUI().isUpPressed()){
            this.physicsInstance.move(true,0);
        }

        if (game.getGUI().isTeleportPressed()){
            this.teleport();
        }

        if (game.getGUI().isShotPressed()){
            this.fire(game);
        }

    }
}
