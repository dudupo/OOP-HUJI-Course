package filesprocessing.operations.sortoperations;

import filesprocessing.FileDelegate;

import java.util.Comparator;

public class Filter_size extends SortOperation {

    protected static Comparator<FileDelegate> sizeComparator = new Comparator<FileDelegate>() {

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

    public Filter_size(String[] params) {
        super(Filter_size.sizeComparator , params);
    }
}
