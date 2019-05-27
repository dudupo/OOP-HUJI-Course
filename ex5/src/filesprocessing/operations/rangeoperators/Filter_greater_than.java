package filesprocessing.operations.rangeoperators;

import filesprocessing.FileDelegate;
import filesprocessing.errorhandlers.ErrorHandler;

public class Filter_greater_than extends Filter_range {


    public Filter_greater_than(String[] command) throws ErrorHandler {
        super(command);
    }

    @Override
    public boolean filter(FileDelegate fileDelegate) {
        return Filter_range.filter(fileDelegate, this.size, true);
    }
}
