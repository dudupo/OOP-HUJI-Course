package filesprocessing.operations.sortoperations;

import filesprocessing.FileDelegate;

import java.util.Comparator;

public class Filter_abs extends SortOperation {


    protected static Comparator<FileDelegate> AbsComparator = new Comparator<FileDelegate>() {

        @Override
        public int compare(FileDelegate fileDelegate, FileDelegate otherfileDelegate) {
            return fileDelegate.getPath().compareTo(
                    otherfileDelegate.getPath());
        }
    };

    public Filter_abs(String[] params) {
        super( Filter_abs.AbsComparator  , params);
    }
}
