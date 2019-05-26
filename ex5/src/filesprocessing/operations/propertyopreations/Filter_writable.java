package filesprocessing.operations.propertyopreations;

import filesprocessing.FileDelegate;

public class Filter_writable  extends Filter_property {

    public Filter_writable(String[] command) {
        super(command);
    }

    @Override
    public boolean filter(FileDelegate fileDelegate) {
        return fileDelegate.Writable();
    }
}
