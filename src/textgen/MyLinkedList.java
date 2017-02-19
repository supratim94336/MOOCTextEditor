package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
	    head=tail;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{	
		if(element == null){
		throw new NullPointerException();
		}
		// TODO: Implement this method
		LLNode temp = new LLNode(element,null,tail);
		if(tail!=null){
			tail.setNext(temp);
		}
		tail = temp;
		if(head==null){
			head = temp;
		}
		size++;
		System.out.println("Added element " + element);
    	return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index){
		// TODO: Implement this method.
		if(index>size || index<0 || size==0){
			throw new IndexOutOfBoundsException();
		}
		LLNode cur = head.getNext();
		for(int i =0;i<index;i++){
			if(cur.getNext()==null){
				return null;
			}
			cur = cur.getNext();
		}		
		return (E) cur.getData();
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ){
		// TODO: Implement this method
		if(index>size || index<0){
			throw new IndexOutOfBoundsException();
		}
		if(element == null){
			throw new NullPointerException();
		}
		LLNode cur = head;
		for(int i=0;i<index;i++){
			cur = cur.getNext();
		}		
		LLNode temp = new LLNode(element);
		if(head == tail){
		    add(element);
		    return;
		}else{
		    temp.setNext(cur.getNext());
		    cur.getNext().setPrev(temp);
		}
		temp.setPrev(cur);
		cur.setNext(temp);
		size++;
	}

	public boolean isEmpty() {
	    return head == null;
	  }
	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{	
		if(index>size||index<0||size<=0){
			throw new IndexOutOfBoundsException();
		}
		LLNode cur = head;
	    for(int i=0;i<index;i++){
	    	cur = cur.getNext();
	    	if(cur==null){
	    		return null;
	    	}
	    }
	    if (cur == head){
	      head = cur.getNext();
	    }else{
	      cur.getPrev().setNext(cur.getNext());
	    }
	    if (cur == tail){
	      tail = cur.getPrev();
	    }else{
	      cur.getNext().setPrev(cur.getPrev());
	    }
	    size--;
	    return (E)cur;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{	
		if(element == null){
			throw new NullPointerException();
		}
		if(index>size || index<0){
			throw new IndexOutOfBoundsException();
		}
		LLNode cur = head;
		for(int i=0;i<index&&cur.getNext()!=null;i++){
			cur= cur.getNext();
		}		
		cur.setData(element);
		return element;
	}  
	
	public String toString(){
		if(size<=0){
			throw new NullPointerException();
		}
		LLNode cur = head; 
		String a= "[ ";
		for(int i=0;i<size;i++){
			a = a + (cur.getData()) + "  ";
			cur = cur.getNext();
		}
		a = a+"]";
		return a;
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	public LLNode(E data, LLNode next, LLNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
	public LLNode<E> getPrev() {
		return prev;
	}
	public void setPrev(LLNode<E> prev) {
		this.prev = prev;
	}
	public LLNode<E> getNext() {
		return next;
	}
	public void setNext(LLNode<E> next) {
		this.next = next;
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}

}
