/**
 *  SpecialShip it's merging the behavior of aggressiveShip and the basherShip,
 *  it's decide between firing or activate shield, according the frome the closest ship.
 */
public class SpecialShip extends PursuesShip  {


    private static final double BASHRANGE = 0.13;
    private static final double FIREEANGE = 0.21;

    public SpecialShip() {
        super(FIREEANGE);
    }

    @Override
    public void criticalRange(SpaceWars game) {

        SpaceShip closest = game.getClosestShipTo(this);

        if ( this.physicsInstance.distanceFrom( closest.physicsInstance ) < BASHRANGE  ) {
            this.shieldOn();
        }
        else {
            // if not in the bashing range than shoot.
            this.fire(game);
        }


    }
}
