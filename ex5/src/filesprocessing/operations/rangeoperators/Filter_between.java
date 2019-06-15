package filesprocessing.operations.rangeoperators;

import filesprocessing.FileDelegate;
import filesprocessing.errorhandlers.ErrorHandler;

import java.util.LinkedList;

public class Filter_between extends Filter_range {

    // the upper bound of the desirable range.
    private double upperbound;

    /**
     * the Operation constructor,
     * @param command the command line input splited to array.
     * @throws ErrorHandler, throw a type I error in case the initialized fail.
     */
    public Filter_between(String[] command) throws ErrorHandler {
        super(command);

        // note that the upperbound initialized in
        // the inputValidator method.
        this.upperbound *= Filter_range.KBYTE;

    }

    /**
     * checking if the file is inside the range.
     * @param fileDelegate - the file which will be examined.
     * @return true, if the size of the file is in the given range.
     */
    @Override
    public boolean filter(FileDelegate fileDelegate) {
        return fileDelegate.getSize() >= this.size &&
                fileDelegate.getSize() <= this.upperbound;
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
        if ( super.inputValidator( stack ) ) {
            try {

                this.upperbound = isDouble(stack.pollFirst());
                return (!Double.isNaN(this.upperbound)) && this.upperbound >= this.size;

            } catch (NumberFormatException e) { }
        }

        return false;

    }
}
