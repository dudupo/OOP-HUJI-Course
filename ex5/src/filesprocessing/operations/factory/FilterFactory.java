package filesprocessing.operations.factory;

import filesprocessing.errorhandlers.ErrorHandler;
import filesprocessing.operations.Filter_all;
import filesprocessing.operations.Operation;
import filesprocessing.operations.propertyopreations.Filter_executable;
import filesprocessing.operations.propertyopreations.Filter_hidden;
import filesprocessing.operations.propertyopreations.Filter_writable;
import filesprocessing.operations.rangeoperators.Filter_between;
import filesprocessing.operations.rangeoperators.Filter_greater_than;
import filesprocessing.operations.rangeoperators.Filter_smaller_than;
import filesprocessing.operations.sortoperations.Filter_abs;
import filesprocessing.operations.sortoperations.Filter_size;
import filesprocessing.operations.sortoperations.Filter_type;
import filesprocessing.operations.substringopreations.Filter_contains;
import filesprocessing.operations.substringopreations.Filter_file;
import filesprocessing.operations.substringopreations.Filter_prefix;
import filesprocessing.operations.substringopreations.Filter_suffix;

/**
 * FilterFactory - responsible to generate operators,
 * by given line input.
 */
public class FilterFactory {


    /**
     * OPERATORS - enum, which given id's to
     *    the operators.
     */
    public enum OPERATORS {
        greater_than,
        between,
        smaller_than,
        file,
        contains,
        prefix,
        suffix,
        writable,
        executable,
        hidden,
        all,
        abs,
        type,
        size;
    }


    /**
     * isOperator - return the matched operator name, by given input.
     * @param operator - the string, which suspected as the operator name.
     * @return the operator id or null if not represents any.
     */
    public static OPERATORS isOperator( String operator ) {
        for ( OPERATORS temp : OPERATORS.values() )
            if (operator.equals(temp.name()))
                return temp;
        return null;
    }

    /**
     * create a Filter Operator by given line.
     * @param params  - the input line splinted to array.
     * @return matched Filter Operation.
     * @throws ErrorHandler - if the initialized fail.
     */
    public static Operation createInstanceFilter(String... params) throws ErrorHandler {

        OPERATORS operator = FilterFactory.isOperator(
                params[0]);

        if ( operator != null) {

            switch (operator) {

                case greater_than:
                    return new Filter_greater_than(params);

                case between:
                    return new Filter_between(params);

                case smaller_than:
                    return new Filter_smaller_than(params);

                case file:
                    return new Filter_file(params);

                case contains:
                    return new Filter_contains(params);

                case prefix:
                    return new Filter_prefix(params);
                case suffix:
                    return new Filter_suffix(params);

                case writable:
                    return new Filter_writable(params);

                case executable:
                    return new Filter_executable(params);

                case hidden:
                    return new Filter_hidden(params);

                case all:
                    return new Filter_all(params);
            }

        }

        // TODO throw exception.
        throw new ErrorHandler();

    }


    /**
     * create a Sorter Operator by given line.
     * @param params  - the input line splinted to array.
     * @return matched Sorted Operation.
     * @throws ErrorHandler - if the initialized fail.
     */
    public static Operation createInstanceSorter(String... params) throws ErrorHandler {

        OPERATORS operator = FilterFactory.isOperator(
                params[0]);


        if ( operator != null) {

            switch (operator) {

                case type:
                    return new Filter_type(params);
                case size:
                    return new Filter_size(params);
                case abs:
                    return new Filter_abs(params);
            }

        }

        // TODO throw exception.
        throw new ErrorHandler();

    }



}
