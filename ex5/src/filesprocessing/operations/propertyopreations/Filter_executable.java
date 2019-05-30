package filesprocessing.operations.propertyopreations;

import filesprocessing.FileDelegate;
import filesprocessing.errorhandlers.ErrorHandler;
import filesprocessing.operations.FilterOperation;

public class Filter_executable extends Filter_property {
    /**
     * the Operation constructor,
     * @param command the command line input splited to array.
     * @throws ErrorHandler, throw a type I error in case the initialized fail.
     */
    public Filter_executable(String[] command) throws ErrorHandler {
        super(command);
    }

    /**
     * the implementation of the filter.
     * @param fileDelegate - the file which will be examined.
     * @return return true if -
     *      the file is executable and the "YES" token had given,
     *      or in the case that the file is not executable but also the
     *      "NO" token had given.
     *      otherwise return false.
     */
    @Override
    public boolean filter(FileDelegate fileDelegate) {
        return fileDelegate.Executable() == this.positiveProperty;
    }
}
