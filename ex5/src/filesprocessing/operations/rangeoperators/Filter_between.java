package filesprocessing.operations.rangeoperators;

import filesprocessing.FileDelegate;
import filesprocessing.errorhandlers.ErrorHandler;

public class Filter_between extends Filter_range {

    private double upperbond = 0;

    public Filter_between(String[] command) throws ErrorHandler {
        super(command);

        if ( command.length > 2){
            this.upperbond = Double.parseDouble(command[2]);

            if ( this.upperbond < 0 )
                throw new ErrorHandler();
        }

        else
            throw new ErrorHandler();

        if ( this.size > this.upperbond)
            throw new ErrorHandler();

        //this.upperbond *=  1024;

    }

    @Override
    public boolean filter(FileDelegate fileDelegate) {
        return Filter_range.filter(fileDelegate, this.size, true) &&
                Filter_range.filter(fileDelegate, this.upperbond, false);

    }
}
