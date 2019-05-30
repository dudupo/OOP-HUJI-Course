package filesprocessing.operations.sortoperations;

import filesprocessing.FileDelegate;
import filesprocessing.Heap;
import filesprocessing.errorhandlers.ErrorHandler;
import filesprocessing.operations.Operation;

import java.util.Comparator;
import java.util.LinkedList;

public class SortOperation extends Operation {

    // the reverse token, which determinate the if the list will be sorted from
    // left to right or in right to left order.
    private static final String REVERSE  = "REVERSE";
    // the comparator which will used to compare files while sorting.
    Comparator<FileDelegate> comparator;
    // store, whether or not the REVERSE token had given.
    boolean reverse;

    /**
     * the Operation constructor,
     * @param command the command line input splited to array.
     * @throws ErrorHandler, throw a type I error in case the initialized fail.
     */
    public SortOperation( Comparator<FileDelegate> comparator, String [] command) throws ErrorHandler {

        super(command);
        this.comparator = comparator;
    }

    /**
     * execute - the method, which get a list of files, and than sorts
     * the list using heap sort method.
     * @param inputFilesList - the file which should manipulate.
     * @return list of sorted file.
     */
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

    /**
     * applying Validation actions, in top-dawn order.
     * which mean that, each of the sub classes, first
     * call to the super.inputValidator and only after
     * that, doing some self Validation.
     * @param stack - stack of tokens, each represents,
     *              one parameter from the input line, originally
     *              there were the word between the sharps - x#y#w
     * @return true or false depend on the Validity of the input.
     */
    @Override
    public boolean inputValidator(LinkedList<String> stack) {
        if (super.inputValidator(stack)) {
            if (!stack.isEmpty()) {
                if (stack.pollFirst().equals(REVERSE)) {
                    this.reverse = true;
                    return true;
                }
                else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
