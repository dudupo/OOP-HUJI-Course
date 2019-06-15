public class RunnerShip extends SpaceShip  {

    private static final double ESCAPERANGE = 0.25;
    private static final double ESACPEANGLE = 0.23;

    @Override
    public void doAction(SpaceWars game) {
        super.doAction(game);

        // boolean haveBeenTelported = false;

        SpaceShip closest =  game.getClosestShipTo(  this );

        if (  this.physicsInstance.angleTo( closest.getPhysics() ) < Math.PI  )
            this.physicsInstance.move(true , 1);

        else if ( this.physicsInstance.angleTo( closest.getPhysics() ) >   Math.PI   )
            this.physicsInstance.move(true , -1);
        else
            this.physicsInstance.move(true ,  1);

        if ( this.physicsInstance.distanceFrom( closest.getPhysics() ) < RunnerShip.ESCAPERANGE ){
            if ( this.physicsInstance.angleTo(  closest.getPhysics() ) < RunnerShip.ESACPEANGLE ) {
                this.teleport();
            }
        }
    }
}
