package filesprocessing.operations;

import filesprocessing.FileDelegate;
import filesprocessing.operations.propertyopreations.Filter_executable;
import filesprocessing.operations.propertyopreations.Filter_hidden;
import filesprocessing.operations.propertyopreations.Filter_writable;
import filesprocessing.operations.rangeoperators.Filter_between;
import filesprocessing.operations.rangeoperators.Filter_greater_than;
import filesprocessing.operations.rangeoperators.Filter_smaller_than;
import filesprocessing.operations.sortoperations.Filter_abs;
import filesprocessing.operations.sortoperations.Filter_size;
import filesprocessing.operations.sortoperations.Filter_type;
import filesprocessing.operations.sortoperations.SortOperation;

import java.util.Comparator;

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
        size;
    }

    public static OPERATORS isOperator( String operator ) {
        for ( OPERATORS temp : OPERATORS.values() )
            if (operator.equals(temp.name()))
                return temp;
        return null;
    }

    public static String getLast( String ... params ) {
        if (params.length > 1 )
            return params[params.length - 1];
        else
            return null;
    }

//    public static boolean checklast( String ... params ) {
//        String last = FilterFactory.getLast(params);
//        return last == null || !last.equals(NEGFLAG);
//    }


    public static boolean includeOrExclude( String ... params ) {
        String last = FilterFactory.getLast(params);
        return last == null || !last.equals(NEGFLAG);
    }


    public static boolean reversreOrder ( String ... params ) {
        String last = FilterFactory.getLast(params);
        return last == null || !last.equals(REVERSE);
    }

    public static Operation createInstance(String... params) {

        OPERATORS operator = FilterFactory.isOperator(params[0]);
        String param = params.length > 1 ? params[1] : null;

        boolean negflag = includeOrExclude(params);
        boolean reverseflag = !reversreOrder(params);

        if ( operator != null) {

            switch (operator) {

                case greater_than:
                    return new Filter_greater_than(params);

                case between:
                    return new Filter_between(params);

                case smaller_than:
                    return new Filter_smaller_than(params);

                case file:
                    return new FilterOperation(negflag) {

                        @Override
                        public boolean filter(FileDelegate fileDelegate) {
                            return fileDelegate.getName().equals(param);
                        }

                    };

                case contains:
                    return new FilterOperation(negflag) {

                        @Override
                        public boolean filter(FileDelegate fileDelegate) {
                            return fileDelegate.Contains(param);
                        }

                    };

                case prefix:
                    return new FilterOperation(negflag) {

                        @Override
                        public boolean filter(FileDelegate fileDelegate) {
                            return fileDelegate.Prefix(param);
                        }

                    };

                case suffix:
                    return new FilterOperation(negflag) {

                        @Override
                        public boolean filter(FileDelegate fileDelegate) {
                            return fileDelegate.Suffix(param);
                        }

                    };

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
            }

        }

        // TODO throw exception.
        return null;

    }



}
