package filesprocessing.operations.factory;

import filesprocessing.errorhandlers.ErrorHandler;
import filesprocessing.operations.Operation;
import filesprocessing.operations.sortoperations.Filter_abs;

public class InstanceSorterCreator extends InstanceCreator {


    /**
     * creating the default Sorter operation, which
     * returns all files.
     * @return sort by abs comparator.
     */
    public static Operation getAbsOperation () {

        try {
            return new Filter_abs();
        } catch (ErrorHandler errorHandler) {
            errorHandler.printStackTrace();
        }
        System.err.println(  " i was here " );

        return null;
    }
    // store the DefaultOperator.

    private static Operation sortAbsOPeration = getAbsOperation();


    /**
     * the method which call the operator factory.
     * @param params - the line input.
     * @return the matched operation which thee factory,
     * returns from parsing the line.
     * @throws ErrorHandler - when the initialized fail.
     */
    @Override
    Operation InstanceConstructor(String[] params) throws ErrorHandler {
        return FilterFactory.createInstanceSorter(params);
    }
    /**
     * getDefaultOperator - responsible to return the default operation.
     * @return DefaultOperator, in this case the abs sorter.
     */
    @Override
    Operation getDefaultOperator() {
        return getAbsOperation();
    }
}
