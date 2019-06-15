package filesprocessing.operations.substringopreations;

import filesprocessing.FileDelegate;
import filesprocessing.errorhandlers.ErrorHandler;
import filesprocessing.operations.FilterOperation;

public class Filter_prefix extends Filter_file {


    /**
     * the Operation constructor,
     * @param command the command line input splited to array.
     * @throws ErrorHandler, throw a type I error in case the initialized fail.
     */
    public Filter_prefix(String[] command) throws ErrorHandler {
        super(command);
    }

    /**
     * return true if the argument ( in the input line, right after the
     * filter_prefix ) is prefix of the file name.
     * @param fileDelegate - the file which will be examined.
     * @return true if the argument ( in the input line, right after the
     *  filter_prefix ) is prefix of the file name. otherwise false.
     */
    @Override
    public boolean filter(FileDelegate fileDelegate) {
        return fileDelegate.Prefix(this.filename);
    }
}
