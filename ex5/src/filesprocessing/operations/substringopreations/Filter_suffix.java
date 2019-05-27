package filesprocessing.operations.substringopreations;

import filesprocessing.FileDelegate;

public class Filter_suffix extends Filter_file {

    public Filter_suffix(String[] command) {
        super(command);
    }

    @Override
    public boolean filter(FileDelegate fileDelegate) {
        return fileDelegate.Suffix( this.filename );
    }
}
