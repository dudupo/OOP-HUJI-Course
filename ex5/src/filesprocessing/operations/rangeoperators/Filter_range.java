package filesprocessing.operations.rangeoperators;

import filesprocessing.FileDelegate;
import filesprocessing.operations.FilterOperation;

public abstract class Filter_range extends FilterOperation {


    protected double size = 0;

    public Filter_range(String[] command) {
        super(command);

        if ( command.length > 1 )
            this.size =  Double.parseDouble( command[1] );


    }


    protected static boolean filter(FileDelegate fileDelegate, double size, boolean greater) {
        return (fileDelegate.getSize() >= size) == greater;
    }

}
