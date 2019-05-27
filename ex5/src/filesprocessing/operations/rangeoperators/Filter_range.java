package filesprocessing.operations.rangeoperators;

import filesprocessing.FileDelegate;
import filesprocessing.errorhandlers.ErrorHandler;
import filesprocessing.operations.FilterOperation;

public abstract class Filter_range extends FilterOperation {


    protected double size = 0;

    public Filter_range(String[] command) throws ErrorHandler {
        super(command);

        if ( command.length > 1 ) {
            this.size = Double.parseDouble(command[1]);

            if (this.size < 0)
                throw new ErrorHandler();
        }

        else
            throw new ErrorHandler();


        //this.size *= 1024;

    }


    protected static boolean filter(FileDelegate fileDelegate, double size, boolean greater) {
        return (fileDelegate.getSize() >= size) == greater;
    }

}
