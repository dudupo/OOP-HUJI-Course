package filesprocessing.operations.rangeoperators;

import filesprocessing.FileDelegate;
import filesprocessing.errorhandlers.ErrorHandler;

public class Filter_greater_than extends Filter_range {

    /**
     * the Operation constructor,
     * @param command the command line input splited to array.
     * @throws ErrorHandler, throw a type I error in case the initialized fail.
     */
    public Filter_greater_than(String[] command) throws ErrorHandler {
        super(command);
    }

    /**
     * checking if the size of the file is greater than the given number.
     * @param fileDelegate - the file which will be examined.
     * @return true, if the size of the file is grater than the given number.
     */
    @Override
    public boolean filter(FileDelegate fileDelegate) {
        return fileDelegate.getSize() > this.size;
    }
}
