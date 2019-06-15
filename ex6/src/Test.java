import processing.parsingRules.SimpleParsingRule;
import processing.textStructure.Block;
import processing.textStructure.Corpus;
import processing.textStructure.Entry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.Scanner;

public class Test {



    public static void TestBlocks() {

        String [] args =  new String[] { "./Config Files/simple.conf" };

        try {
            Scanner scanner = new Scanner(new File( args[0] ));

            scanner.nextLine();

            List<Block> blocks =  new SimpleParsingRule().parseFile(
                    new RandomAccessFile(scanner.nextLine() , "r" ));

            for (Block block : blocks ){
                System.out.println(block.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void TestCorpus ( ) {
        String [] args =  new String[] { "./Config Files/movies.conf" };
        try {
            Scanner scanner = new Scanner(new File( args[0] ));

            scanner.nextLine();

            Corpus corpus = new Corpus(scanner.nextLine(), ""  );

            for (Entry entry : corpus ){
                //System.out.println(entry.toString());
                System.out.println("i was here");
                for (Block block : entry)
                    System.out.println( block );
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) { 
        //TestBlocks();
        TestCorpus();




    }
}
