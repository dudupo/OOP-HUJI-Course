package filesprocessing.operations.sortoperations;

import filesprocessing.FileDelegate;
import filesprocessing.errorhandlers.ErrorHandler;
import filesprocessing.operations.factory.FilterFactory;

import java.util.Comparator;

public class Filter_abs extends SortOperation {


    /**
     * Lex Comparator.
     */
    protected static Comparator<FileDelegate> AbsComparator = new Comparator<FileDelegate>() {
        /**
         * Lex Compering.
         * @param fileDelegate - the first given file.
         * @param otherfileDelegate - the second given file.
         * @return 1, 0, -1 depends on the position of the first path in the dictionary
         * relative to the second path.
         */
        @Override
        public int compare(FileDelegate fileDelegate, FileDelegate otherfileDelegate) {
            return fileDelegate.getPath().compareTo(
                    otherfileDelegate.getPath());
        }
    };

    /**
     * the Operation constructor,
     * @param command the command line input splited to array.
     * @throws ErrorHandler, throw a type I error in case the initialized fail.
     */
    public Filter_abs(String[] command) throws ErrorHandler {
        super( Filter_abs.AbsComparator  , command);
    }

    /**
     * the default constructor which will allow us to construct a lex sorter
     * without passing arguments. will be useful while the initialization of
     * other file have been fail.
     * @throws ErrorHandler -  throw a type I error in case the initialized fail.
     */
    public Filter_abs ( ) throws ErrorHandler {

        super(Filter_abs.AbsComparator,
                new String [] {FilterFactory.OPERATORS.abs.name()});
    }
}
