package filesprocessing.operations;

import filesprocessing.FileDelegate;
import filesprocessing.errorhandlers.ErrorHandler;
import filesprocessing.operations.Operation;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 *  abstract class which is the ancestor for all the
 *  filter operation, operations which returns list of files
 *  which passes a specific test.
 */
public abstract class FilterOperation extends Operation {


    // the Token, which indecent that filter is
    // in fact a dropper.
    private static final String NEGFLAG = "NOT";

    // true if the operation is fill the returned list
    // by the objects which pass the filter, false if the operation drop
    // the files which pass the filter.
    protected boolean positive;

    /**
     * the Operation constructor,
     * @param command the command line input splited to array.
     * @throws ErrorHandler
     */
    public FilterOperation (String [] command) throws ErrorHandler {
        super(command);


        //System.out.println( this.positive );
    }
    /**
     * execute - the core method, which get a list of files, and than, filters
     * the list.
     * @param inputFilesList - the file which should manipulate.
     * @return filtered list.
     */
    @Override
    public LinkedList<FileDelegate> execute(LinkedList<FileDelegate> inputFilesList) {

        LinkedList<FileDelegate> filtered = new LinkedList<>();

        for ( FileDelegate fileDelegate : inputFilesList )
            if (this.filter( fileDelegate )  == this.positive)
                filtered.addLast(fileDelegate);

        return filtered;
    }

    /**
     * filter - examine a single file, if returns true,
     * than the file will inserted to the filtered list ( or
     * dropped in case that the "NOT" had given.
     * @param fileDelegate - the file which will be examined.
     * @return true, if the file passed the test, otherwise false.
     */
    public abstract boolean filter(FileDelegate fileDelegate);

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
    public boolean inputValidator( LinkedList<String> stack)  {
        if(super.inputValidator(stack)){
            return true;
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

        if (!stack.isEmpty()){
            if ( !NEGFLAG.equals( stack.pollLast() ) )
                return false;

            this.positive = false;
        }
        else
            this.positive = true;

        return super.inputValidatorReverse(stack);
    }

}

