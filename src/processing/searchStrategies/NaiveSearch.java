package processing.searchStrategies;

import processing.textStructure.Corpus;
import processing.textStructure.Entry;
import processing.textStructure.WordResult;
import processing.textStructure.Block;
import java.util.Iterator;
import java.util.List;

public class NaiveSearch implements processing.searchStrategies.IsearchStrategy {

	 /**
	  * A field holding the given corpus to search over.
	  **/
	private Corpus origin;

	/**
	 * aA constructor for NaiceSearch instances.
	 * @param origin - The Corpus (collection of files) to search over.
	 */
	public NaiveSearch(Corpus origin) {
		this.origin = origin;
	}

	/**
	 * This method implements the search method of the functional interface IsearchStrategy.
	 * @param query - The word or sentence to look for.
	 * @return - return a List containing WordResult objects which represent each appearance of
	 * the queried item.
	 */
	@Override
	public List<WordResult> search(String query) {
		Iterator<Entry> entryIterator = this.origin.iterator();
		return null;
	}



}
