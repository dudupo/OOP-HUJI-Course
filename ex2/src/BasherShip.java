public class BasherShip extends PursuesShip  {

    private static final double BASHRANGE = 0.19;

    public BasherShip() {
        super( BasherShip.BASHRANGE );
    }

    /**
     * turn the shield on, when entering combat range.
     * @param  game the game object.
     */
    @Override
    public void criticalRange(SpaceWars game) {
        this.shieldOn();
    }
}
