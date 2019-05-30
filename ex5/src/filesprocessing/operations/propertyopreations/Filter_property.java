package filesprocessing.operations.propertyopreations;
import filesprocessing.errorhandlers.ErrorHandler;
import filesprocessing.operations.FilterOperation;

import java.util.LinkedList;

/**
 *   Filter_property, filter which filtering by specific property.
 */
public abstract class Filter_property  extends FilterOperation {

    // the token, which indicates that the property is desirable.
    private static final String YESFLAG  = "YES";
    // the token, which indicates that the property is not desirable.
    private static final String NOFLAG   = "NO";
    // store which of the flags ( YESFLAG , NOFLAG ) is turn on.
    protected boolean positiveProperty;

    /**
     * the Operation constructor,
     * @param command the command line input splited to array.
     * @throws ErrorHandler, throw a type I error in case the initialized fail.
     */
    public Filter_property(String[] command) throws ErrorHandler {
        super(command);

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
        if(super.inputValidator(stack)) {
            if (!stack.isEmpty()) {

                String flag = stack.pollFirst() ;
                if ( YESFLAG.equals( flag ) ) {
                    this.positiveProperty = true;
                    return true;

                } else if (NOFLAG.equals(flag)) {
                    this.positiveProperty = false;
                    return true;

                }
            }
        }
        return false;

    }

}
