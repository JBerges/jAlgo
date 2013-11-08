package es.inetb.jalgo.sort;

import java.util.Collection;

/**
 * This interface defines a Sort Algorithm.
 * 
 * The important method is sort, but getName is a helper to deal with algorigthms
 * 
 * @author jberges
 *
 */
public interface SortAlgo {

	/**
	 * All SortAlgo implementations gets a Collection and sorts it. Collection is 
	 * using also Generics to be able to sort any kind of items that implements comparable.
	 * 
	 * @param items Collection of Comparable items
	 * 
	 * @return A sorted collection with items content
	 */
	public <E extends Comparable<? super E>> Collection<E> sort(Collection<E> items);
	
	/**
	 * Just return this algorith name. Not functional use, but helper if we want to log something
	 * 
	 * @return Algorithm name.
	 */
    public String getName();
}
