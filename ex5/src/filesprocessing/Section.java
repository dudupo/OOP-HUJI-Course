package filesprocessing;

import filesprocessing.operations.Operation;

import java.io.File;
import java.util.LinkedList;


/**
 *  Section, the object which responsible to
 *  execute the operation on the files.
 */
public class Section {

    // the operations which will executed for each section.
    LinkedList<Operation> operations;

    // delegates to the files, in the given directory.
    LinkedList<FileDelegate> files;

    /**
     * constructor
     * @param operations - the list of operations, which will be executed on the
     *                   files list.
     * @param files - the list of files in the directory which, will be filtered.
     */
    public Section( LinkedList<Operation> operations, LinkedList<FileDelegate> files) {
        this.operations = operations;
        this.files = files;
    }

    /**
     *  execute each operator on the file list, and than print the results.
     */
    public void run(  ) {

        LinkedList<FileDelegate> shallowcopy =  cloneFileList(this.files);

        for(Operation operation : this.operations) {
            shallowcopy = operation.execute( shallowcopy );
        }

        for(FileDelegate delegate : shallowcopy ) {
            System.out.println( delegate.getName() );
        }
    }

    /**
     * create a shallow copy of the files.
     * @param files - the original file list.
     * @return a shallow copy  of files.
     */
    public static LinkedList<FileDelegate> cloneFileList( LinkedList<FileDelegate>  files  ) {
        LinkedList<FileDelegate> copy = new LinkedList<>();

        for (FileDelegate delegate : files)
            copy.add( new FileDelegate( delegate ) );

        return files;
    }



}
