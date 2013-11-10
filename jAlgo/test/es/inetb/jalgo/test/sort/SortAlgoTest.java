package es.inetb.jalgo.test.sort;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import es.inetb.jalgo.sort.SortAlgo;

public abstract class SortAlgoTest<T extends SortAlgo> {
		
	T instance;
	
	protected abstract T createInstance();

	private Collection<Integer> okCollection;
	@Before 
    public void setUp() {
    	instance = createInstance();
    	
    	// Random!
    	Random rand = new Random();
    	okCollection = new ArrayList<>();
    	for(int i = 0; i < 300; i++){
    		okCollection.add(rand.nextInt());                   
         }
    }

    private final Integer[] oneArray = {1},
    		sortedArray =  {1,2,3,4,5,6};	
    @Test
    public void testSort(){ 
    	
    	// Check empty
    	Collection<Integer> sortedList = instance.sort(new ArrayList<Integer>());
    	assertNotNull(sortedList);
    	assertTrue(sortedList.isEmpty());
    	
    	// Check one element
    	sortedList = instance.sort(new ArrayList<>(Arrays.asList(oneArray)));
    	assertNotNull(sortedList);
    	assertTrue(sortedList.size() == oneArray.length);
    	assertTrue(correctOrder(sortedList));
    	
    	// Check sorted list
    	sortedList = instance.sort(new ArrayList<>(Arrays.asList(sortedArray)));
    	assertNotNull(sortedList);
    	assertTrue(sortedList.size() == sortedArray.length);
    	assertTrue(correctOrder(sortedList));
    	
    	// Check 100 random elements list
    	sortedList = instance.sort(okCollection);
    	assertNotNull(sortedList);
    	assertTrue(sortedList.size() == okCollection.size());
    	assertTrue(correctOrder(sortedList));
    	
    }
    
    private <E extends Comparable<? super E>> boolean correctOrder(Collection<E> sortedItems){
        E prevItem = null;
        for(E item : sortedItems){
            if(prevItem != null && prevItem.compareTo(item) > 0){
                return false;
            }
        }
        return true;
    }

}
