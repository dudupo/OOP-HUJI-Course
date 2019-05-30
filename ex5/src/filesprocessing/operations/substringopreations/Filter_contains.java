package filesprocessing.operations.substringopreations;

import filesprocessing.FileDelegate;
import filesprocessing.errorhandlers.ErrorHandler;

public class Filter_contains extends Filter_file {


    /**
     * the Operation constructor,
     * @param command the command line input splited to array.
     * @throws ErrorHandler, throw a type I error in case the initialized fail.
     */
    public Filter_contains(String[] command) throws ErrorHandler {
        super(command);
    }

    /**
     * return true if the argument is substring of the file name.
     * @param fileDelegate - the file which will be examined.
     * @return true if the argument ( in the input line, right after the
     *  filter_contains ) is substring  of the file name. otherwise false.
     */
    @Override
    public boolean filter(FileDelegate fileDelegate) {
        return fileDelegate.Contains( this.filename );
    }
}
