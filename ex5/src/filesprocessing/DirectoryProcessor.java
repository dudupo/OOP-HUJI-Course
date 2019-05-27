package filesprocessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.LinkedList;

public class DirectoryProcessor {

    public static void main(String[] args) {

        String sourcedir = args[0] ,commandfile = args[1];

        try {

            for (Section section : Parser.parserSections(new File(commandfile), new File(sourcedir))) {
                section.run();
            }


        } catch ( FileNotFoundException e ) {

        }

        //System.out.println("hi");



    }


}
