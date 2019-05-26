package filesprocessing.operations;

import filesprocessing.FileDelegate;

public class Filter_all extends FilterOperation {

    public Filter_all(String[] command) {
        super(command);
    }

    @Override
    public boolean filter(FileDelegate fileDelegate) {
        return true;
    }
}
