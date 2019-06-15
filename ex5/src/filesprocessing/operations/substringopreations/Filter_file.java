package filesprocessing.operations.substringopreations;

import filesprocessing.FileDelegate;
import filesprocessing.errorhandlers.ErrorHandler;
import filesprocessing.operations.FilterOperation;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class Filter_file extends FilterOperation {

    // store the argument, which given. should be a substring ( in
    // this case the all file name ). of the file name.
    protected String filename;


    /**
     * the Operation constructor,
     * @param command the command line input splited to array.
     * @throws ErrorHandler, throw a type I error in case the initialized fail.
     */
    public Filter_file(String[] command) throws ErrorHandler {
        super(command);

    }

    /**
     * return true if the file name equal to the argument which given.
     * @param fileDelegate - the file which will be examined.
     * @return return true if the file name equal to the argument which given.
     *          otherwise false.
     */
    @Override
    public boolean filter(FileDelegate fileDelegate) {
        return fileDelegate.getName().equals( this.filename );
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

        if (  super.inputValidator(stack) ) {
            if (!stack.isEmpty()) {
                this.filename = stack.pollFirst();
                return Pattern.matches("[A-Za-z0-9/._\\- ]*" , this.filename);
            }
        }
        return false;

    }

    /**
     * applying Validation actions, in dawn-top order.
     * which mean that, each of the sub classes, first
     * doing some self Validation and only after that,
     * call to the super.inputValidator
     * @param stack - stack of tokens, each represents,
     *              one parameter from the input line, originally
     *              there were the word between the sharps - x#y#w
     * @return true or false depend on the Validity of the input.
     */
    @Override
    public boolean inputValidatorReverse(LinkedList<String> stack) {
        return super.inputValidatorReverse(stack);
    }
}
