package filesprocessing.operations;

import filesprocessing.FileDelegate;

import java.util.LinkedList;

public abstract class Operation {

    public abstract LinkedList<FileDelegate> execute(LinkedList<FileDelegate> inputFilesList);

    protected String [] command;

    public Operation(String... command) {

        this.command = command;

    }

    protected boolean isturnOn ( String flag ) {
        for ( String param : this.command)
            if ( param.equals( flag ))
                return true;

        return false;
    }

}
