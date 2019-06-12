package filesprocessing.operations;

import filesprocessing.FileDelegate;
import filesprocessing.errorhandlers.ErrorHandler;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 *  represent abstraction of operation, the common ancestor to
 *  the filter and the sorter operation.
 */
public abstract class Operation {


    /**
     * execute - the method, which get a list of files, and than, filters or sorters
     * the list depend on the type of the subclass.
     * @param inputFilesList - the file which should manipulate.
     * @return list of file, which is the result of the manipulation.
     */
    public abstract LinkedList<FileDelegate> execute(LinkedList<FileDelegate> inputFilesList);


    // store the line, which invoked the operation.
    protected String [] command;

    /**
     * the Operation constructor,
     * @param command the command line input splited to array.
     * @throws ErrorHandler, throw a type I error in case the initialized fail.
     */
    protected Operation(String [] command) throws ErrorHandler {


        LinkedList<String> stack = new LinkedList<>();
        Collections.addAll(stack, command);

        /**
         *  applying Validation actions, in top-dawn order.
         *  extracting the parameters from the line in linear
         *  order. left to right.
         */
        if (!this.inputValidator(stack))
            throw new ErrorHandler();

        /**
         *  applying Validation actions, in !*dawn-top*! order.
         */
        if(!this.inputValidatorReverse(stack))
            throw new ErrorHandler();

        this.command = command;

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
    public boolean inputValidator( LinkedList<String> stack ) {

        stack.pollFirst();

        return true;
    }

    /**
     * applying Validation actions, in dawn-top order.
     * which mean that, each of the sub classes, first
     * doing some self Validation and only after that,
     * call to the super.inputValidatorReverse
     * @param stack - stack of tokens, each represents,
     *              one parameter from the input line, originally
     *              there were the word between the sharps - x#y#w
     * @return true or false depend on the Validity of the input.
     */
    public boolean inputValidatorReverse( LinkedList<String> stack ) {
        // check, that there is not, excessive parameters.
        return stack.isEmpty();
    }


}
