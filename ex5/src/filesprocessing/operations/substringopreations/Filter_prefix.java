package filesprocessing.operations.substringopreations;

import filesprocessing.FileDelegate;
import filesprocessing.operations.FilterOperation;

public class Filter_prefix extends Filter_file {


    public Filter_prefix(String[] command) {
        super(command);
    }

    @Override
    public boolean filter(FileDelegate fileDelegate) {
        return fileDelegate.Prefix(this.filename);
    }
}
