package filesprocessing.operations.substringopreations;

import filesprocessing.FileDelegate;
import filesprocessing.operations.FilterOperation;

public class Filter_file extends FilterOperation {

    protected String filename;

    public Filter_file(String[] command) {
        super(command);

        if ( command.length > 1 )
            this.filename = command[1];

        else {
            // TODO : ---
        }
    }

    @Override
    public boolean filter(FileDelegate fileDelegate) {
        return fileDelegate.getName().equals( this.filename );
    }
}
