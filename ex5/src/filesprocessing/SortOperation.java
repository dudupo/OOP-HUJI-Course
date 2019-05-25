package filesprocessing;

import java.util.Comparator;
import java.util.LinkedList;

public class SortOperation implements Operation {

    Comparator<FileDelegate> comparator;
    boolean reverse;

    public SortOperation( Comparator<FileDelegate> comparator, boolean reverse ) {
        this.comparator = comparator;
        this.reverse = reverse;
    }

    @Override
    public LinkedList<FileDelegate> execute(LinkedList<FileDelegate> inputFilesList) {
        FileDelegate [] array = new FileDelegate[ inputFilesList.size() ];
        inputFilesList.toArray( array );
        LinkedList<FileDelegate> ret = new LinkedList<>();
        for( FileDelegate fileDelegate : Heap.Sort(array, this.comparator)) {
            if( this.reverse)
                ret.addLast( fileDelegate );
            else
                ret.addFirst( fileDelegate );
        }
        return ret;
    }


}
