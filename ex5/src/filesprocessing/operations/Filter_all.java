package filesprocessing.operations;

import filesprocessing.FileDelegate;
import filesprocessing.errorhandlers.ErrorHandler;
import filesprocessing.operations.factory.FilterFactory;

/**
 * filter which returns the all files.
 */
public class Filter_all extends FilterOperation {


    /**
     * constructor, getting the input line, and construct the object.
     * @param command - the input line splinted to array.
     * @throws ErrorHandler - exception which invoked when the initialized fail.
     */
    public Filter_all(String[] command) throws ErrorHandler {
        super(command);
    }

    /**
     * constructor, will allow us to create default filter, when
     * without passing an input line.
     * @throws ErrorHandler
     */
    public Filter_all() throws ErrorHandler {
        super( new String [] { FilterFactory.OPERATORS.all.name() }  );
    }

    /**
     * the filter method. return true for any file.
     * @param fileDelegate - Delegate which warp the given file.
     * @return true, for any file.
     */
    @Override
    public boolean filter(FileDelegate fileDelegate) {
        return true;
    }
}
