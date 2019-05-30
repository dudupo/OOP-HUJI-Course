package filesprocessing;

import java.io.File;

public class DirectoryProcessor {

    // the prefix for type II errors.
    public static final String ERRORPREFIX = "ERROR: ";

    /**
     * the main function, passing the input to the
     * parser, getting for him the sections, than
     * executing them or print error if there were.
     * @param args - the path to the command file
     *             and to the directory.
     */
    public static void main(String[] args) {

        String sourcedir = args[0] ,commandfile = args[1];

        try {

            for (Section section : Parser.parserSections(
                    new File(commandfile), new File(sourcedir))) {
                section.run();
            }

        } catch ( Exception e ) {
            System.err.println( ERRORPREFIX + e.getMessage());
        }




    }


}
