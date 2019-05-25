import java.util.Random;

public class DrunkardShip extends SpaceShip  {


    /**
     *  opcode for each opreation.
     */
    private static final int operations = 4;
    private static final int left = 0;
    private static final int right = 1;
    private static final int attack = 2;
    private static final int shield = 3;

    /**
     * Does the actions of this ship for this round.
     * This is called once per round by the SpaceWars game driver.
     * @param game the game object to which this ship belongs.
     */

    @Override
    public void doAction(SpaceWars game) {
        super.doAction(game);

        // choosing a randomize action.
        switch (new Random().nextInt(this.operations)) {
            case left : this.getPhysics().move(false , 1);break;
            case right : this.getPhysics().move(false , -1);break;
            case attack : this.fire(game);break;
            case shield : this.shieldOn();break;
        }

    }
}
