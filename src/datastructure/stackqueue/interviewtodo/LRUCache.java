package datastructure.stackqueue.interviewtodo;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	public static void main(String[] args) {
		LRUCacheImpl lru = new LRUCacheImpl(5);
		lru.set(1);
		lru.set(2);
		lru.set(3);
		lru.set(4);
		lru.displayLRU();
		
		lru.get(2);
		lru.displayLRU();
		
		lru.get(1);
		lru.displayLRU();
		
		lru.get(1);
		lru.displayLRU();
		
		lru.set(5);
		lru.displayLRU();
		
		lru.get(3);
		lru.displayLRU();
		
		lru.set(6);
		lru.displayLRU();
		
		lru.get(1);
		lru.displayLRU();
		
		lru.set(7);
		lru.displayLRU();
	}
}

class LRUCacheImpl {
	
	private int capacity;
	private int size;
	private Node lruCacheHead, lruCacheTail;
	private Map<Integer,Node> lruCacheReference;
	
	public LRUCacheImpl(int capacity) {
		this.capacity = capacity;
		lruCacheReference = new HashMap<>(capacity);
	}
	
	public void set(int value) {
		if( !lruCacheReference.containsKey(value) ) {
			Node newNode = this.addNodeAtHead(value);
			lruCacheReference.put(value, newNode);
		}
		else {
			Node getReference = lruCacheReference.get(value);
			bringNodeToFront(getReference);
		}
	}
	
	public int get(int value) {
		if( !lruCacheReference.containsKey(value) ) {
			System.out.println("Value not present in cache !");
			return -1;
		}
		else {
			Node getReference = lruCacheReference.get(value);
			bringNodeToFront(getReference);
			return getReference.getData();
		}
	}	
	
	public void displayLRU() {
		Node temp = lruCacheHead;
		
		while( temp != null ) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}
	
	private Node addNodeAtHead(int value) {
		Node newNode = new Node(value);
		
		if(lruCacheHead == null) {
			lruCacheHead = newNode;
			lruCacheTail = newNode;
		}
		else {
			newNode.setNext(lruCacheHead);
			lruCacheHead.setPrevious(newNode);
			lruCacheHead = newNode;
		}
			
		if(size >= capacity) {
			lruCacheTail = lruCacheTail.getPrevious();
			lruCacheTail.setNext(null);
		}
		
		size++;
		
		return newNode;
	}
	
	private void bringNodeToFront(Node reference) {
		if(lruCacheHead == reference)
			return;
		
		if(reference.getPrevious() != null)
			reference.getPrevious().setNext(reference.getNext());
		
		if(reference.getNext() != null)
			reference.getNext().setPrevious(reference.getPrevious());
		else {
			lruCacheTail = lruCacheTail.getPrevious();
			lruCacheTail.setNext(null);
		}
		
		reference.setPrevious(null);
		reference.setNext(lruCacheHead);
		lruCacheHead.setPrevious(reference);
		lruCacheHead = reference;
	}
	
	class Node {
		private int data;
		private Node next;
		private Node previous;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
			this.previous = null;
		}
		
		public Node(int data, Node next, Node previous) {
			this.data = data;
			this.next = next;
			this.previous = previous;
		}

		public int getData() { return data; }
		public void setData(int data) { this.data = data; }
		public Node getNext() { return next; }
		public void setNext(Node next) { this.next = next; }
		public Node getPrevious() { return previous; }
		public void setPrevious(Node previous) { this.previous = previous; }
		
	}
}


