package processing.textStructure;

import processing.parsingRules.IparsingRule;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * This class represents a single file within a Corpus
 */
public class Entry implements Iterable<Block>, Serializable {
	public static final long serialVersionUID = 1L;
	private List<Block> blocks;

	/**
	 * construct an Entry Object.
	 * @param filePath the path of given file.
	 * @param parseRule the method which will used to parsing.
	 */
    public Entry(String filePath, IparsingRule parseRule) {
		try {
			System.out.println(filePath);
			this.blocks = parseRule.parseFile(
					new RandomAccessFile( filePath,"r"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Iterate over Block objects in the Entry
	 * @return a block iterator
	 */
	@Override
    public Iterator<Block> iterator() {
    	return this.blocks.iterator();
    }

	
}
