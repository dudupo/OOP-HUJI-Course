public class AggressiveShip extends PursuesShip {

    private static final double FIREEANGE = 0.21;


    public AggressiveShip() {
        super(AggressiveShip.FIREEANGE);
    }

    /**
     * shouting, when entering combat range.
     * @param game the game object.
     */
    @Override
    public void criticalRange(SpaceWars game) {
        this.fire( game );
    }
}
