package filesprocessing;

import java.io.File;
import java.util.LinkedList;

public class Section {

    // the operations which will executed for each section.
    LinkedList<Operation> operations;

    // delegates to the files, in the given directory.
    LinkedList<FileDelegate> files;

    public Section( LinkedList<Operation> operations, LinkedList<FileDelegate> files) {
        this.operations = operations;
        this.files = files;
    }


    public void run(  ) {

        LinkedList<FileDelegate> shallowcopy =  (  LinkedList<FileDelegate>  ) this.files.clone();

        for(Operation operation : this.operations) {
            shallowcopy = operation.execute( shallowcopy );
        }

        for(FileDelegate delegate : shallowcopy ) {
            System.out.println( delegate.getName() );
        }
    }



}
