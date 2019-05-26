package filesprocessing.operations.propertyopreations;

import filesprocessing.FileDelegate;
import filesprocessing.operations.FilterOperation;

public class Filter_executable extends Filter_property {

    public Filter_executable(String[] command) {
        super(command);
    }

    @Override
    public boolean filter(FileDelegate fileDelegate) {
        return fileDelegate.Executable();
    }
}
