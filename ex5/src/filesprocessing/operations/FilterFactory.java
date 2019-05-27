package filesprocessing.operations;

import filesprocessing.errorhandlers.ErrorHandler;
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


public class FilterFactory {

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
        size,
        filter,
        order;
    }

    public static OPERATORS isOperator( String operator ) {
        for ( OPERATORS temp : OPERATORS.values() )
            if (operator.equals(temp.name()))
                return temp;
        return null;
    }

    public static Operation createInstance(String... params) throws ErrorHandler {

       // System.err.println(params[0]);


        OPERATORS operator = FilterFactory.isOperator(
                params[0].toLowerCase());


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

                case size:
                    return new Filter_size(params);

                case abs:
                    return new Filter_abs(params);

                case type:
                    return new Filter_type(params);
                case filter:
                    return null;
                case order:
                    return null;
            }

        }

        // TODO throw exception.
        throw new ErrorHandler();

    }



}
