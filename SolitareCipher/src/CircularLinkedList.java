import java.util.Iterator;

public class CircularLinkedList<E> implements Iterable<E> {


	// Your variables
	Node<E> head;
	Node<E> tail;
	public int size;


	// implement this constructor

	public CircularLinkedList() {

		head = null;
		this.tail = null;
		size = 0;
	}



	// I highly recommend using this helper method
	// Return Node<E> found at the specified index
	// be sure to handle out of bounds cases
	private Node<E> getNode(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Not Valid");
		}
		Node<E> current = head;

		for (int i = 0; i < index; i++) {
			current = current.next;

		}
		return current;
	}


	// attach a node to the end of the list
	public boolean add(E item) {
		this.add(size,item);
		return true;

	}


	// Cases to handle
	// out of bounds
	// adding to empty list
	// adding to front
	// adding to "end"
	// adding anywhere else
	// REMEMBER TO INCREMENT THE SIZE
	public void add(int index, E item){
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index out of Bounds");
		}
		Node<E> add = new Node<>(item);
		if (size == 0){ // head is added as the first item
			this.head = add; // and tail is added as first item as well
			this.tail = add; // add points to both the head and tail (look at drawing)
			this.tail.next = head;
		} else if (index == 0){
			tail.next = add; // new head is added
			add.next = head;
			head = add;
		}
		else if (index == size ){
			tail.next = add;  //new tail gets added
			add.next = head;
			tail = add;
		} else {
			Node<E> t = this.getNode(index-1);
			add.next = t.next;
			t.next = add;
		}
		size++;



	}





	// remove must handle the following cases
	// out of bounds
	// removing the only thing in the list
	// removing the first thing in the list (need to adjust the last thing in the list to point to the beginning)
	// removing the last thing 
	// removing any other node
	// REMEMBER TO DECREMENT THE SIZE
	public E remove(int index) {
		E removed = head.item;
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of Bounds");
		}

		if (size==1){ //when index is one
			removed = head.item; //stores removed item in head
			head=null;
			tail=null;



		}
		else if (index ==0 ){
			removed = head.item; //tail.next points to next item in list
			head = head.next;
			tail.next = head;

		}
		else if (index == size-1){
			Node<E> before = getNode(index-1);//call node (as seen in video)
			removed = tail.item; // Removing Last item
			tail = before;
			tail.next = head;
		}
		else{
			Node<E> m = this.getNode(index-1);
			removed = m.next.item;
			m.next = m.next.next;
		}
		size --;
		return removed;

	}




	// Turns your list into a string
	// Useful for debugging
	public String toString(){
		Node<E> current =  head;
		StringBuilder result = new StringBuilder();
		if(size == 0){
			return "";
		}
		if(size == 1) {
			return head.item.toString();

		}
		else{
			do{
				result.append(current.item);
				result.append(" ==> ");
				current = current.next;
			} while(current != head);
		}
		return result.toString();
	}


	public Iterator<E> iterator() {
		return new ListIterator<E>();
	}


	public int size() {
		return size;

	}


	// provided code for different assignment
	// you should not have to change this
	// change at your own risk!
	// this class is not static because it needs the class it's inside of to survive!
	private class ListIterator<E> implements Iterator<E>{

		Node<E> nextItem;
		Node<E> prev;
		int index;

		@SuppressWarnings("unchecked")
		//Creates a new iterator that starts at the head of the list
		public ListIterator(){
			nextItem = (Node<E>) head;
			index = 0;
		}

		// returns true if there is a next node
		// this is always should return true if the list has something in it
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return size != 0;
		}

		// advances the iterator to the next item
		// handles wrapping around back to the head automatically for you
		public E next() {
			// TODO Auto-generated method stub
			prev =  nextItem;
			nextItem = nextItem.next;
			index =  (index + 1) % size;
			return prev.item;

		}

		// removed the last node was visted by the .next() call 
		// for example if we had just created a iterator
		// the following calls would remove the item at index 1 (the second person in the ring)
		// next() next() remove()
		public void remove() {
			int target;
			if(nextItem == head) {
				target = size - 1;
			} else{
				target = index - 1;
				index--;
			}
			CircularLinkedList.this.remove(target); //calls the above class
		}

	}

	// It's easiest if you keep it a singly linked list
	// SO DON'T CHANGE IT UNLESS YOU WANT TO MAKE IT HARDER
	private static class Node<E>{
		E item;
		Node<E> next;

		public Node(E item) {
			this.item = item;
		}

	}

	public  E get(int index){
		return this.getNode(index).item;
	}



	public static void main(String[] args) {

	}
}




	
	

