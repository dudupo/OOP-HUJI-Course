package filesprocessing.operations.rangeoperators;

import filesprocessing.FileDelegate;

public class Filter_between extends Filter_range {

    private double upperbond = 0;

    public Filter_between(String[] command) {
        super(command);

        if ( command.length > 2){
            this.upperbond = Double.parseDouble(command[2]);
        }

    }

    @Override
    public boolean filter(FileDelegate fileDelegate) {
        return Filter_range.filter(fileDelegate, this.size, true) &&
                Filter_range.filter(fileDelegate, this.upperbond, false);

    }
}
