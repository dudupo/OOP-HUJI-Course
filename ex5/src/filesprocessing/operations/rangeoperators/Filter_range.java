package filesprocessing.operations.rangeoperators;

import filesprocessing.errorhandlers.ErrorHandler;
import filesprocessing.operations.FilterOperation;

import java.util.LinkedList;

public abstract class Filter_range extends FilterOperation {

    // the factor to covert to kilo byte.
    public static final double KBYTE = 1024;
    // the size which we will filters relative to.
    protected double size;
    /**
     * the Operation constructor,
     * @param command the command line input splited to array.
     * @throws ErrorHandler, throw a type I error in case the initialized fail.
     */
    public Filter_range(String[] command) throws ErrorHandler {
        super(command);

        this.size *= Filter_range.KBYTE;

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
                this.size = isDouble( stack.pollFirst() );
                if (!Double.isNaN(this.size))
                    return true;
            }
        }


        return false;
    }
    /**
     * isDouble, validate if the argument can be parse as double.
     * @param number_input - the argument which should be parsed.
     * @return the number if the input is valid, otherwise Double.NaN.
     */
    public static double isDouble( String number_input ) {
        try {

            double ret = Double.parseDouble(number_input);


            if ( ret >= 0)
                return ret;


        } catch (  NumberFormatException e ) { }

        return Double.NaN;
    }

}
