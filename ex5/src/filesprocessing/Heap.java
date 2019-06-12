package filesprocessing;

import java.util.Comparator;
import java.util.LinkedList;

public class Heap {

    // the left child of the node
    protected Heap Left;
    // the right child of the node
    protected Heap Right;
    // pointer to the file.
    private FileDelegate root;
    // comparator which will used compare between two files, while sorting.
    private Comparator<FileDelegate> comparator;

    /**
     * The Sort method, getting array of files,
     * and comparator, and returns a sorted list of those files
     * using en heap sort algorithm.
     * @param array - the given files.
     * @param comparator - the comparator which will used compare between
     *                  two files
     * @return a sorted list of those files.
     */
    public static FileDelegate[] Sort( FileDelegate [] array, Comparator<FileDelegate> comparator) {

        if(array.length == 0)
            return new FileDelegate[]{};


        Heap heap = new Heap(array, 0, array.length, comparator);
        FileDelegate [] sorted = new FileDelegate [array.length];

        for (int i = 0; i < array.length ; i++) {
            sorted[i] = heap.pop();
        }
        return sorted;
    }

    /**
     * constructor, a linear algorithm in time for creating
     * a heap, each time dividing the array to two parts,
     * and than by the master theorem we get :
     *    T(n) =  2T(n/2) + T ( heapify )
     *      => T(n) = 2T(n/2) + O(log(n))
     *        => T(n) = O(n)

     * @param array - the given files.
     * @param start - the first index of the files, which are part of the
     *              current heap.
     * @param end - the last index of the files, which are part of the
     *              current heap.
     * @param comparator - the comparator which will used compare between
     *      *                  two files
     */
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

    /**
     * swapping between two values of nodes in the heap.
     * @param heap1 the first node.
     * @param heap2 the second node.
     */
    private static void swap(Heap heap1, Heap heap2) {
        FileDelegate temp = heap1.root;
        heap1.root = heap2.root;
        heap2.root = temp;
    }

    /**
     * getting the value max between given value, and the value of given
     * node.
     * @param maxvalue - the first given value.
     * @param child - the given node, which it's value will be compared
     *              to the maxvalue.
     * @return the greater value.
     */
    private FileDelegate getMax(FileDelegate maxvalue, Heap child ) {
        if (maxvalue == null)
            return child != null ? child.root : null;

        return (child != null && child.root != null &&
                        this.comparator.compare(maxvalue, child.root ) < 0 ) ? child.root : maxvalue;
    }

    /**
     * checking if some node, should be swap it's value with it's child.
     * in this case, than executing the swapping.
     * @param maxvalue the value of the node.
     * @param child the matched child.
     */
    private void swapIfNeeded( FileDelegate maxvalue, Heap child ) {
        if ( child != null && child.root != null &&
                comparator.compare( maxvalue , child.root) == 0 ) {
            Heap.swap(this, child);
            child.heapify();
        }
    }

    /**
     *  rooters dawn the root of heap.
     */
    private void heapify( ){

        FileDelegate maxvalue = this.root;
        maxvalue = this.getMax( maxvalue, this.Left );
        maxvalue = this.getMax( maxvalue, this.Right );

        if(maxvalue != null) {
            swapIfNeeded(maxvalue, this.Left );
            swapIfNeeded(maxvalue, this.Right);
        }
    }

    /**
     * extracting the maximal value from the heap.
     * @return the maximal value from the heap.
     */
    public FileDelegate pop(){
        FileDelegate ret = this.root;
        this.root = null;
        this.heapify();
        return ret;
    }


}
