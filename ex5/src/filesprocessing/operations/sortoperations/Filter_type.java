package filesprocessing.operations.sortoperations;

import filesprocessing.FileDelegate;
import filesprocessing.errorhandlers.ErrorHandler;

import java.util.Comparator;

public class Filter_type extends SortOperation {

    protected static Comparator<FileDelegate> typeComparator = new Comparator<FileDelegate>() {

        /**
         * type Compering. ( lex )
         * @param fileDelegate - the first given file.
         * @param otherfileDelegate - the second given file.
         * @return 1, 0, -1 depends on the type of the first file in the dictionary
         * relative to the second file's tpye.
         */
        @Override
        public int compare(FileDelegate fileDelegate, FileDelegate otherfileDelegate) {
            int ret = fileDelegate.getType().
                    compareTo(otherfileDelegate.getType());
            if (ret != 0)
                return ret;
            else
                return Filter_abs.AbsComparator.
                        compare(fileDelegate, otherfileDelegate);
        }
    };

    /**
     * the Operation constructor,
     * @param command the command line input splited to array.
     * @throws ErrorHandler, throw a type I error in case the initialized fail.
     */
    public Filter_type(String[] command) throws ErrorHandler {
        super(Filter_type.typeComparator , command);
    }
}
