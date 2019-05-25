package filesprocessing;

import java.util.Comparator;
import java.util.LinkedList;

public class Heap {

    protected Heap Left;
    protected Heap Right;
    private FileDelegate root;
    private Comparator<FileDelegate> comparator;

    public Heap() {

    }

    public static FileDelegate[] Sort( FileDelegate [] array, Comparator comparator) {
        Heap heap = new Heap(array, 0, array.length, comparator);
        FileDelegate [] sorted = new FileDelegate [array.length];

        for (int i = 0; i < array.length ; i++) {
            sorted[i] = heap.pop();
        }
        return sorted;
    }


    public Heap(FileDelegate [] array, int start, int end, Comparator<FileDelegate> comparator) {

        int middle = (start + end)/2;
        this.root = array[middle];
        this.comparator = comparator;

        if ( start != middle)
            this.Left = new Heap(array, start, middle, comparator);
        if(middle+1 != end)
            this.Right = new Heap(array, middle+1, end, comparator);

        this.heapify();

    }


    private static void swap(Heap heap1, Heap heap2) {
        FileDelegate temp = heap1.root;
        heap1.root = heap2.root;
        heap2.root = temp;
    }


    private FileDelegate getMax(FileDelegate maxvalue, Heap child ) {
        if (maxvalue == null)
            return child != null ? child.root : null;

        return (child != null && child.root != null &&
                        this.comparator.compare(maxvalue, child.root ) < 0 ) ? child.root : maxvalue;
    }

    private void swapIfNeeded( FileDelegate maxvalue, Heap child ) {
        if ( child != null && child.root != null &&
                comparator.compare( maxvalue , child.root) == 0 ) {
            Heap.swap(this, child);
            child.heapify();
        }
    }

    private void heapify( ){

        FileDelegate maxvalue = this.root;
        maxvalue = this.getMax( maxvalue, this.Left );
        maxvalue = this.getMax( maxvalue, this.Right );

        if(maxvalue != null) {
            swapIfNeeded(maxvalue, this.Left );
            swapIfNeeded(maxvalue, this.Right);
        }
    }

    public FileDelegate pop(){
        FileDelegate ret = this.root;
        this.root = null;
        this.heapify();
        return ret;
    }


}
