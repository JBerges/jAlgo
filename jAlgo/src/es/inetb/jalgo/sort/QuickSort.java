package es.inetb.jalgo.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QuickSort implements SortAlgo{

	/**
	 * This method creates a new Collection with sorted elements of items.
	 * 
	 * @param items Original collection to sort
	 * @return A new Collection with sorted elements
	 */
	@Override
	public <E extends Comparable<? super E>> Collection<E> sort(
			Collection<E> items) {
		// if empty, return empty collection (better than null)
		if(items.isEmpty()){
            return new ArrayList<E>();
        }
		// Using ArrayList as implementation for better performance
		List<E> itemsSorted = new ArrayList<E>();
		
		// Copy all items to new List
		// We are adding performance problems, but also we are securing original data
		// and as we are using an ArrayList, get(i) will behave correctly (on performance side)
        itemsSorted.addAll(items);
        
        // If only 1 element, it's sorted!
        if(itemsSorted.size() == 1) {
            return itemsSorted;
        }
        
        // this is the real method, called recursively
        quickSort(itemsSorted, 0, items.size()-1);
        
        // return new Collection sorted
        return itemsSorted;
	}

	/**
	 * This method sorts recursively the collection items. It sorts not the full Collection
	 * but a piece (lowIndex -   
	 * 
	 * @param items Collection to sort 
	 * @param lowIndex Range sorted in this call from here
	 * @param highIndex Range sorted in this call to here
	 */
	private <E extends Comparable<? super E>> void quickSort(List<E> items, int lowIndex, int highIndex){
        if(lowIndex < highIndex){
        	// Get a pivot and put elements before or after it
            int pivot = partition(items, lowIndex, highIndex);
            
            // Call recursively to before pivot subarray
            quickSort(items, lowIndex, pivot-1);
            
            // Call recursively to after pivot subarray
            quickSort(items, pivot+1, highIndex);
        }
    }
	
	/**
     * We compare each item with pivot. Pivot is the last element
     * 
     * Firsthigh is used to point to the first element that is higher than pivot.
     * 
     * If element is lower than pivot, then change position with firstHigh element (so
     * that element is on higher positions) and increment firstHigh.
     * 
     * At the end, firstHigh is the position where the pivot goes, change with
     * firstHigh element.
     * 
     * @param <E> Generic type used 
     * @param items All data (we access to portion using indexes but we have all the data)
     * @param lowIndex we are using data FROM here
     * @param highIndex we are using data TO here
     * @return final position of the pivot
     * 
     */
    private <E extends Comparable<? super E>> int partition(List<E> items, int lowIndex, int highIndex){
        int pivotIndex = highIndex;
        int firstHigh = lowIndex;
        
        // Main bucle to recolocate items compared to pivot
        for(int i = lowIndex; i < highIndex; i++){
            if(items.get(i).compareTo(items.get(pivotIndex)) < 0){
                // Swap this element with FirstHigh
                swap(items, i, firstHigh);
                
                // firstHigh now has to increment
                firstHigh++;
            }
        }
        // Swap pivot with his real position
        swap(items, pivotIndex, firstHigh);
        
        // return pivot position (used to call recursively)
        return firstHigh;
        
    }
    
    /**
     * Just swap two items.
     * 
     * @param items Collection where the swap is done
     * @param first Index of one element to swap
     * @param second Index of the other element to swap
     */
    private <E extends Comparable<? super E>> void swap(List<E> items, int first, int second){
        if(first != second){
        	// Temp copy
            E temp = items.get(first);
            
            // Swap
            items.set(first, items.get(second));
            items.set(second, temp);
        }
    }
    
    /**
     * What's the name of this Algorithm ? QuickSort :-)
     */
	@Override
	public String getName() {
		return "QuickSort";
	}

}
