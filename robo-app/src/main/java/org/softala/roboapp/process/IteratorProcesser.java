/**
 * 
 */
package org.softala.roboapp.process;

import java.util.ArrayList;

/**
 * @author Tuomas Törmä
 * @param <T>	Class definition
 * 
 * Purpose of this class is to convert Iterable list to same type of ArrayList
 *
 */
public class IteratorProcesser<T> {
	
	/**
	 * Change Iteable to to ArrayList with T as class definition
	 * 
	 * @param iterable Iterable<T>
	 * @return ArrayList<T>
	 */
	public ArrayList<T> processToArrayList(Iterable<T> iterable){
		ArrayList<T> list = new ArrayList<>();
		
		for (T t : iterable) {
			list.add(t);
		}
		
		return list;
	}
}