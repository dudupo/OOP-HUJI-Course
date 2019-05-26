package filesprocessing.operations.propertyopreations;

import filesprocessing.FileDelegate;

public class Filter_hidden extends Filter_property {

    public Filter_hidden(String[] command) {
        super(command);
    }

    @Override
    public boolean filter(FileDelegate fileDelegate) {
        return fileDelegate.Hidden();
    }
}
