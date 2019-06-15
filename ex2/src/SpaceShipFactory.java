import oop.ex2.*;

import java.util.ArrayList;
import java.util.LinkedList;


public class SpaceShipFactory {
    /**
     * Creates a new game.
     *
     * @param args the command line arguments that indicate which types of
     * spaceships to add to the game.
     * @return returns instances of the ships.
     */
    public static SpaceShip[] createSpaceShips(String[] args) {

        LinkedList<SpaceShip> ships = new LinkedList<SpaceShip>();

        for ( String type : args ) {

            switch ( type ){
                case "h" : ships.add( new HumanShip() ); break;
                case "d" : ships.add( new DrunkardShip() ); break;
                case "r" : ships.add( new RunnerShip() ); break;
                case "a" : ships.add( new AggressiveShip() ); break;
                case "b" : ships.add( new BasherShip() ); break;
                case "s" : ships.add( new SpecialShip()); break;
            }
        }

        SpaceShip[] returnArray = new SpaceShip[ ships.size() ];

        for ( int i = 0 ; i < returnArray.length ; i++ ) {
            returnArray[i] = ships.pollLast();

        }

        return returnArray;
    }
}
