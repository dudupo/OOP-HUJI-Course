package filesprocessing;

import java.util.LinkedList;

public interface Operation {

    abstract LinkedList<FileDelegate> execute( LinkedList<FileDelegate>  inputFilesList );

}
