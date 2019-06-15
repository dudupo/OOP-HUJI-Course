package processing.textStructure;

import processing.parsingRules.IparsingRule;
import processing.parsingRules.SimpleParsingRule;
import utils.MD5;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a body of works - anywhere between one and thousands of documents sharing the same structure and that can be parsed by the same parsing rule.
 */
public class Corpus implements Iterable<Entry>, Serializable {
	public static final long serialVersionUID = 1L;
    private List<Entry> entryList;
    private IparsingRule parsingRule;
    private String corpusPath;

    public Corpus(String path, String parserName) throws IOException {
   		this.corpusPath = path;

   		// TODO : currently the chosen of the list type is arbitrary.
   		this.entryList = new LinkedList<>();

   		if (Files.isDirectory(Paths.get(path)))
			for ( String entrypath : new File(path).list())
				this.pushEntry( entrypath );

   		else
			this.pushEntry( path );

    }

	/**
	 * adding one entry to the end of the list.
	 * @param entrypath the path to the entry. should be a valid File.
	 */
    private void pushEntry( String entrypath ){
    	// TODO generalize for different Parsing rules.
		entryList.add(new Entry(  this.corpusPath + "/" + entrypath , new SimpleParsingRule()));
	}

	/**
	 * This method populates the Block lists for each Entry in the corpus.
	 */
	public void populate(){
    
    }
    

	/**
	 * The path to the corpus folder
	 * @return A String representation of the absolute path to the corpus folder
	 */
	public String getPath() {
		return this.corpusPath;
    }

	/**
	 * Iterate over Entry objects in the Corpus
	 * @return An entry iterator
	 */
	@Override
    public Iterator<Entry> iterator() {
        return this.entryList.iterator();
    }

	/**
	 * Return the checksum of the entire corpus. This is an MD5 checksum which represents all the files in the corpus.
	 * @return A string representing the checksum of the corpus.
	 * @throws IOException if any file is invalid.
	 */
	public String getChecksum() throws IOException {
		return null;
    }

	/**
	 * Return the parsing rule used for this corpus
	 * @return the parsing rule used for this corpus
	 */
	public IparsingRule getParsingRule() {
        return this.parsingRule;
    }

	/**
	 * Update the RandomAccessFile objects for the Entries in the corpus, if it was loaded from cache.
	 */
	public void updateRAFs() {
	
	}
}
