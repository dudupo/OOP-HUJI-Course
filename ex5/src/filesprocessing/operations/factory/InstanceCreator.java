package filesprocessing.operations.factory;

import filesprocessing.errorhandlers.ErrorHandler;
import filesprocessing.operations.Operation;

import java.util.Scanner;

/**
 *  InstanceCreator is the interface which connected between the Parser,
 *  and the factory, it include two sub class, the InstanceFilterCreator,
 *  InstanceSorterCreator each responsible to construct the matched class.
 */
public abstract class InstanceCreator {

    public static final String PARAMSDELIMITER = "#";


    /**
     * createInstance - the core of the class, pulling the next line from
     * the scanner and crating the matched filter. also responsible to return
     * the default operation if needed.
     * @param scanner - the given scanner.
     * @param line - the number of the current line.
     * @return  the matched operation.
     */
    public Operation createInstance(Scanner scanner, int line) {
        Operation operation = null;

        try {
            if (scanner.hasNext())
                operation = this.InstanceConstructor (
                        scanner.nextLine().split(PARAMSDELIMITER));
            else
                operation = this.getDefaultOperator();

        } catch (ErrorHandler errorHandler) {
            System.err.println("Warning in line " + line);
            operation = this.getDefaultOperator();
        }

        return operation;
    }

    /**
     * the method which call the operator factory.
     * @param params - the line input.
     * @return the matched operation which thee factory,
     * returns from parsing the line.
     * @throws ErrorHandler - when the initialized fail.
     */
    abstract Operation InstanceConstructor(String [] params) throws ErrorHandler;

    /**
     * getDefaultOperator - responsible to return the default operation.
     * @return DefaultOperator, depends on the sub class.
     */
    abstract Operation getDefaultOperator( );





}
