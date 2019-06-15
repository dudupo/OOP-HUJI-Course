public abstract class PursuesShip extends SpaceShip {


    protected double CRITICALRANGE;

    public PursuesShip(double CRITICALRANGE) {
        this.CRITICALRANGE = CRITICALRANGE;
    }

    /**
     *
     * @param game the game object to which this ship belongs.
     */
    @Override
    public void doAction(SpaceWars game) {
        super.doAction(game);

        SpaceShip closest =  game.getClosestShipTo(  this );

        double angleto =  this.physicsInstance.angleTo( closest.getPhysics() );

        if (  angleto > Math.PI && angleto < Math.PI * 2 )
            this.physicsInstance.move(true , -1);

        else if ( angleto >  0 )
            this.physicsInstance.move(true , 1);
        // the case that the angle is
        else
            this.physicsInstance.move(false ,  0);


        if ( this.physicsInstance.distanceFrom( closest.getPhysics() ) < this.CRITICALRANGE ){
            this.criticalRange( game );
        }
    }

    /**
     * calling when the ship enter to combat range with the closest ship.
     * the fighting technique should implemented by the subclasses.
     * @param game
     */
    public abstract void criticalRange( SpaceWars game ) ;

}
