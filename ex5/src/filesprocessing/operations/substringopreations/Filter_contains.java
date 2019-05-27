package filesprocessing.operations.substringopreations;

import filesprocessing.FileDelegate;
import filesprocessing.operations.FilterOperation;

public class Filter_contains extends Filter_file {

    protected String filename;

    public Filter_contains(String[] command) {
        super(command);
    }

    @Override
    public boolean filter(FileDelegate fileDelegate) {
        return fileDelegate.Contains( this.filename );
    }
}
