package filesprocessing;

import java.util.LinkedList;

public abstract class FilterOperation implements Operation {

    boolean include = true;

    public FilterOperation (boolean include) {
        this.include = include;
    }

    @Override
    public LinkedList<FileDelegate> execute(LinkedList<FileDelegate> inputFilesList) {

        LinkedList<FileDelegate> filtered = new LinkedList<>();

        for ( FileDelegate fileDelegate : inputFilesList )
            if (this.filter( fileDelegate )  == include)
                filtered.addLast(fileDelegate);

        return filtered;
    }

    abstract boolean filter( FileDelegate fileDelegate );


}

