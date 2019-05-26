package filesprocessing.operations;

import filesprocessing.FileDelegate;
import filesprocessing.operations.Operation;

import java.util.LinkedList;

public abstract class FilterOperation extends Operation {

    private static final String NEGFLAG = "NOT";


    protected boolean positive = true;

    public FilterOperation (String [] command)
    {
        super();
        this.positive =  ! this.isturnOn( FilterOperation.NEGFLAG );
    }

    @Override
    public LinkedList<FileDelegate> execute(LinkedList<FileDelegate> inputFilesList) {

        LinkedList<FileDelegate> filtered = new LinkedList<>();

        for ( FileDelegate fileDelegate : inputFilesList )
            if (this.filter( fileDelegate )  == this.positive)
                filtered.addLast(fileDelegate);

        return filtered;
    }

    public abstract boolean filter(FileDelegate fileDelegate);





}

