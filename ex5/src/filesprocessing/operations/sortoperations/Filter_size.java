package filesprocessing.operations.sortoperations;

import filesprocessing.FileDelegate;
import filesprocessing.errorhandlers.ErrorHandler;

import java.util.Comparator;

public class Filter_size extends SortOperation {

    protected static Comparator<FileDelegate> sizeComparator = new Comparator<FileDelegate>() {

        /**
         * size Compering.
         * @param fileDelegate - the first given file.
         * @param otherfileDelegate - the second given file.
         * @return 1, 0, -1 depends on the size of the first file in the dictionary
         * relative to the second file's size.
         */
        @Override
        public int compare(FileDelegate fileDelegate, FileDelegate otherfileDelegate) {
            int ret = Long.
                    compare(fileDelegate.getSize(), otherfileDelegate.getSize());
            if (ret != 0)
                return ret;

            else
                return Filter_abs.AbsComparator.
                        compare(fileDelegate, otherfileDelegate );
        }
    };

    /**
     * the Operation constructor,
     * @param command the command line input splited to array.
     * @throws ErrorHandler, throw a type I error in case the initialized fail.
     */
    public Filter_size(String[] command) throws ErrorHandler {
        super(Filter_size.sizeComparator , command);
    }
}
