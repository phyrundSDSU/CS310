/*  LinkedListDS.java
    CS310 Fall 2013
	Rohan ID: masc0341
    Phyrun Diep
    This is the LinkedList class implementation
*/

package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;
import java.util.Comparator;

public class LinkedListDS<E> implements ListADT<E>{
	
// Inner Class Node
    public class Node<E> implements Comparable<E>{
			E data;
			Node<E> next;

			public Node(E obj){
			    data = obj;
				next = null;
			}

	public int compareTo(E obj) {
	    return ((Comparable<E>)data).compareTo(obj);
	}
	
    }
// IteratorHelper inner class
    class IteratorHelper implements Iterator<E>{
	    Node<E> index;
 
		public IteratorHelper(){
		    index = head;
		}
		
		public boolean hasNext(){
			return index != null;
		}
		
		public E next(){
		    if(!hasNext()){
			    throw new NoSuchElementException();
			}
				E temp = index.data;
				index = index.next;	
				return temp;		
		}

		public void remove(){
		    throw new UnsupportedOperationException();	
		}	
			
	}
//Fields from class LinkedList	
    private Node<E> head, tail;
    private int currentSize;
		
	
    public LinkedListDS(){
	    head = tail = null;
		currentSize = 0;
	}
		
		
//Method definitions	
    

    public boolean isEmpty(){return (this.size() == 0);}
    

	public boolean isFull(){return false;}

	public int size(){return currentSize;}
	
	public void addFirst(E obj){
	    Node<E> newNode = new Node<E> (obj);
		newNode.next = head;
		head = newNode;
//		    if(tail == null)
//			    tail = head; 
		currentSize++;
	}

	
	public void addLast(E obj){
	    Node<E> newNode = new Node<E> (obj);
		    if(tail == null){
			    tail = newNode;
				if(head == null)
				    head = tail;
			    currentSize++;
			}
			else{
				tail.next = newNode;
				tail = newNode;
				currentSize++;
			}
	}
	
	public E removeFirst(){ 
	    if(head == null)
		    return null;
			
	    E tmp;
		tmp = head.data;
		head = head.next;
		if(currentSize == 1)
			tail = null;
		currentSize--;
		return tmp;
	}
	

	public E removeLast(){
	    Node<E> current = head, previous = null;
	    
		    if(head == null) // If list is empty return null
			    return null;
			if(head.next == null) // If there is one item remove first
				return removeFirst();
			
			while(current.next != null){ // Traverse through list until current.next == null
				previous = current;
				current = current.next;
			}
			previous.next = null;
			tail = previous;
			currentSize--;
			return current.data; 			
	}

	
	public E peekFirst(){
	    return head.data;
	}

	public E peekLast(){
	    return tail.data;
	}


	public void makeEmpty(){
	    head = null;
		tail = null;
		currentSize = 0;
	}

	public boolean contains(E obj){
	    Node<E> tmp = head;
		   while(tmp != null){
		       if(tmp.compareTo(obj) == 0)
			       return true;
		       tmp = tmp.next;
		   }
		return false;
	}
	
	// Delete function
	public boolean remove(E obj){
		Node<E> previous = null, current = head;
		while(current != null && ((Comparable<E>)obj).compareTo(current.data) != 0){
			previous = current;
			current = current.next;
		}
		// if current != null, then node was found
		if(current == null)
			return false;
		if(current == head)
			head = head.next;
		else if(current == tail){
			previous.next = null;
			tail = previous;
			currentSize--;
		}
		else // node to remove is in the middle
			previous.next = current.next;
			currentSize--;
		if(head == null) // adjust tail pointer
			tail = null;
		return true;
	}
	
	public E find(E obj){
		Node<E> tmp = head;
		while(tmp != null){
			if(tmp.data == obj)
				return obj;
			tmp = tmp.next;
		}
		return null;
	}
	
	public Iterator<E> iterator(){	
	    return new IteratorHelper();
	}

	
}