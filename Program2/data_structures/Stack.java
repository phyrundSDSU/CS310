/*  Stack.java
    CS310 Fall 2013
	Rohan ID: masc0341
    Phyrun Diep
    This is the Stack class implementation
*/

package data_structures;

import java.util.Iterator;

public class Stack<E> implements Iterable<E> {
	
	private LinkedListDS<E> list = new LinkedListDS<E>();
	
	// adds an object onto the stack
	public void push(E obj){
		list.addFirst(obj);
	}
	
	// removes an object from the stack
	public void pop(){
		list.removeLast();
	}
	
	// returns the number of elements currently in the stack
    public int size(){
    	return list.size();
    } 
    
    // return true if the stack is empty, otherwise false
    public boolean isEmpty() {
    	return list.isEmpty();
    }       
    
    // returns but does not remove the element on the top of the stack    
    public E peek() {
    	return list.peekLast();
    }
     
    // returns true if the object obj is in the stack,
    // otherwise false   
    public boolean contains(E obj){
    	list.find(obj);
		return false;
    } 
    
    // returns the stack to an empty state    
    public void makeEmpty(){
    	list.makeEmpty();
    }
    
    // removes the Object obj if it is in the stack and
    // returns true, otherwise returns false.
    public boolean remove(E obj){
    	return list.remove(obj);
    }    
    
    // returns a iterator of the elements in the stack.  The elements
    // must be in the same sequence as pop() would return them.    
    public Iterator<E> iterator() {
    	return list.iterator();
    }

}
