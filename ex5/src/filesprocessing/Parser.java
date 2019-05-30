package filesprocessing;

import filesprocessing.errorhandlers.ErrorHandler;
import filesprocessing.operations.factory.FilterFactory;
import filesprocessing.operations.Operation;
import filesprocessing.operations.factory.InstanceFilterCreator;
import filesprocessing.operations.factory.InstanceSorterCreator;
import filesprocessing.operations.sortoperations.Filter_abs;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;




public class Parser {

    private static final String FILTERDEILIMTER = "FILTER";
    private static final String ORDERDEILIMTER = "ORDER";
    private static final String FILTERERROR = "FILTER subsection missing";
    private static final String ORDERERROR = "ORDER subsection missing";


    /**
     * iterating over the command file and the directory and
     * returns a list of sections objects.
     * @param commandFile - the command file.
     * @param sourceFile - the target dir to filter.
     * @return list of sections.
     * @throws Exception , type II errors, which will stop the process, and will be handled in
     * the main function.
     */
    public static LinkedList<Section> parserSections(File commandFile, File sourceFile )
            throws Exception {

        LinkedList<FileDelegate> fileDelegates = new LinkedList<FileDelegate>();

        for (File file : sourceFile.listFiles()){
            if (!file.isDirectory())
                fileDelegates.addLast( new FileDelegate(file) );
        }
        return Parser.getSections(commandFile, fileDelegates);
    }


    /**
     * constructs the sections, by initialing a filter list.
     * @param commandFile - the command file.
     * @param files - the given files list to filter.
     * @return list of sections.
     * @throws Exception  type II errors, which will stop the process, and will be handled in
     *      the main function.
     */
    public static LinkedList<Section> getSections(File commandFile, LinkedList<FileDelegate> files)
            throws Exception {

        LinkedList<Section> sections = new LinkedList<>();

        Scanner scanner = new Scanner(commandFile);
        int line = 1;


        InstanceFilterCreator FilterCreator = new InstanceFilterCreator();
        InstanceSorterCreator SorterCreator = new InstanceSorterCreator();


        while (scanner.hasNext()) {


            LinkedList<Operation> operations = new LinkedList<>();



            if ( !scanner.nextLine().equals( FILTERDEILIMTER ) )
            {
                throw new Exception(FILTERERROR);
            }

            line++;

            operations.addLast(FilterCreator.createInstance(scanner, line ));
            line++;

            if ( !scanner.nextLine().equals( ORDERDEILIMTER ) )
            {
                throw new Exception(ORDERERROR);
            }

            line++;
            /*
                  the purpose of the condition here, is to
                  give answer to a specific end-case:

                        [v] FILTER
                        [v] filter_all
                        [v] ORDER
                      ! [x] FILTER
                        [v] filter_all
                        [v] ORDER
                        [v] size
             */
            if (!scanner.hasNext( FILTERDEILIMTER )) {
                operations.addLast(SorterCreator.createInstance(scanner, line));
                line++;
            }

            else {
                operations.addLast(InstanceSorterCreator.getAbsOperation());
            }

            sections.addLast(new Section(operations, files));

        }

        return sections;
    }







}
