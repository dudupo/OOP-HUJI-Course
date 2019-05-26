package filesprocessing.operations.sortoperations;

import filesprocessing.FileDelegate;

import java.util.Comparator;

public class Filter_type extends SortOperation {

    protected static Comparator<FileDelegate> typeComparator = new Comparator<FileDelegate>() {

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

    public Filter_type(String[] params) {
        super(Filter_type.typeComparator , params);
    }
}
