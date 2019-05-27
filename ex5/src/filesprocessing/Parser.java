package filesprocessing;

import filesprocessing.errorhandlers.ErrorHandler;
import filesprocessing.operations.FilterFactory;
import filesprocessing.operations.Filter_all;
import filesprocessing.operations.Operation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;




public class Parser {

    public static final String SECTIONDELIMITER = "FILTER\n";
    public static final String FEEDLINEDELIMITER = "\n";
    public static final String PARAMSDELIMITER = "#";
    public static final int LIMITSPLIT = 2;


    public static Section EmptySection ( LinkedList<FileDelegate> files ) {

        LinkedList<Operation> operations = new LinkedList<Operation>( );

        operations.add(
                new Filter_all(
                    new String[]{
                            FilterFactory.OPERATORS.all.name()
                    }
                )
        );


        return new Section(operations, files);
    }

    public static LinkedList<Section> parserSections(File commandFile, File sourceFile )
            throws FileNotFoundException {

        LinkedList<FileDelegate> fileDelegates = new LinkedList<FileDelegate>();

        for (File file : sourceFile.listFiles()){
            fileDelegates.addLast( new FileDelegate(file) );
        }
        return Parser.getSections(commandFile, fileDelegates);
    }

    public static LinkedList<Section> getSections(File commandFile, LinkedList<FileDelegate> files)
            throws FileNotFoundException {

        LinkedList<Section> sections = new LinkedList<>();

        Scanner scanner = new Scanner(commandFile);
        scanner.useDelimiter(Parser.SECTIONDELIMITER);
        int line = 0;
        while (scanner.hasNext()) {
            Scanner section_scanner = new Scanner(scanner.next());
            section_scanner.useDelimiter(Parser.FEEDLINEDELIMITER);

            LinkedList<Operation> operations = new LinkedList<>();
            if ( section_scanner.hasNext()  )

            while(section_scanner.hasNext()){
                line++;
                Operation operation = null;
                try {
                    operation = FilterFactory.createInstance(
                            section_scanner.nextLine().split( Parser.PARAMSDELIMITER ));
                } catch (ErrorHandler errorHandler) {
                    System.err.println( "Warning in line " + line );
                    //errorHandler.printStackTrace();

                }

                if (operation != null)
                    operations.addLast( operation );
            }

            if (!operations.isEmpty())
                sections.addLast(new Section(operations, files ));
        }

        if(sections.isEmpty())
            sections.add( EmptySection(files) );


        return sections;
    }

    public static String [] extractFunctionAndParams (String line) {
        return line.split( "#"  , 2 );
    }





}
