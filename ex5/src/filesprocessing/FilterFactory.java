package filesprocessing;

import java.util.Comparator;

public class FilterFactory {

    private static final String NEGFLAG = "NOT";
    private static final String REVERSE  = "REVERSE";
    private static final String YESFLAG  = "YES";
    private static final String NOFLAG   = "NO";

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

    public static Operation createInstance( String... params) {

        OPERATORS operator = FilterFactory.isOperator(params[0]);
        String param = params.length > 1 ? params[1] : null;

        boolean negflag = includeOrExclude(params);
        boolean reverseflag = !reversreOrder(params);

        if ( operator != null) {

            switch (operator) {

                case greater_than:
                    return new FilterOperation(negflag) {

                        @Override
                        public boolean filter(FileDelegate fileDelegate) {
                            return fileDelegate.getSize() > Integer.parseInt(param);
                        }

                    };

                case between:
                    return new FilterOperation(negflag) {

                        // TODO : end case...
                        @Override
                        public boolean filter(FileDelegate fileDelegate) {
                            return fileDelegate.getSize() < Integer.parseInt(params[3]) &&
                                    fileDelegate.getSize() > Integer.parseInt(params[2]);
                        }

                    };

                case smaller_than:
                    return new FilterOperation(negflag) {

                        @Override
                        public boolean filter(FileDelegate fileDelegate) {
                            return fileDelegate.getSize() < Integer.parseInt(param);
                        }

                    };

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
                    return new FilterOperation(negflag) {

                        @Override
                        public boolean filter(FileDelegate fileDelegate) {
                            return fileDelegate.Writable();
                        }

                    };

                case executable:
                    return new FilterOperation(negflag) {

                        @Override
                        public boolean filter(FileDelegate fileDelegate) {
                            return fileDelegate.Executable();
                        }

                    };

                case hidden:
                    return new FilterOperation(negflag) {

                        @Override
                        public boolean filter(FileDelegate fileDelegate) {
                            return fileDelegate.Hidden();
                        }

                    };

                case all:
                    return new FilterOperation(negflag) {

                        @Override
                        public boolean filter(FileDelegate fileDelegate) {
                            return true;
                        }

                    };

                case size:
                    return new SortOperation(

                            new Comparator<FileDelegate>() {

                                @Override
                                public int compare(FileDelegate fileDelegate, FileDelegate otherfileDelegate) {
                                    int ret = Long.compare(fileDelegate.getSize(), otherfileDelegate.getSize());
                                    if (ret != 0)
                                        return ret;
                                    else
                                        return fileDelegate.getPath().compareTo(otherfileDelegate.getPath());
                                }
                            }
                    , reverseflag);

                case abs:
                    return new SortOperation(

                            new Comparator<FileDelegate>() {

                                @Override
                                public int compare(FileDelegate fileDelegate, FileDelegate otherfileDelegate) {
                                    return fileDelegate.getPath().compareTo(otherfileDelegate.getPath());
                                }
                            }
                    ,reverseflag);

                case type:
                    return new SortOperation(

                            new Comparator<FileDelegate>() {

                                @Override
                                public int compare(FileDelegate fileDelegate, FileDelegate otherfileDelegate) {

                                    int ret = fileDelegate.getType().compareTo(otherfileDelegate.getType());
                                    if (ret != 0)
                                        return ret;
                                    else
                                        return fileDelegate.getPath().compareTo(otherfileDelegate.getPath());
                                }
                            }
                    , reverseflag);
            }

        }

        // TODO throw exception.
        return null;

    }



}
