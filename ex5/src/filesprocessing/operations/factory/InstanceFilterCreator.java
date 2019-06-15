package filesprocessing.operations.factory;

import filesprocessing.errorhandlers.ErrorHandler;
import filesprocessing.operations.Filter_all;
import filesprocessing.operations.Operation;
import filesprocessing.operations.sortoperations.Filter_abs;

/**
 *  InstanceFilterCreator - the creator of the Filter operations.
 */
public class InstanceFilterCreator extends InstanceCreator {

    /**
     * creating the default Filter operation, which
     * returns all files.
     * @return filter_all.
     */
    public static Operation getAllOperation() {

        try {
            return new Filter_all();
        } catch (ErrorHandler errorHandler) {
            errorHandler.printStackTrace();
        }
        System.err.println(  " i was here " );
        return null;
    }


    // store the DefaultOperator.
    private static Operation allOperation = getAllOperation();


    /**
     * the method which call the operator factory.
     * @param params - the line input.
     * @return the matched operation which thee factory,
     * returns from parsing the line.
     * @throws ErrorHandler - when the initialized fail.
     */
    @Override
    Operation InstanceConstructor(String[] params) throws ErrorHandler {
        return FilterFactory.createInstanceFilter(params);
    }
    /**
     * getDefaultOperator - responsible to return the default operation.
     * @return DefaultOperator, in this case the filter_all.
     */
    @Override
    Operation getDefaultOperator() {
        return getAllOperation();
    }
}
