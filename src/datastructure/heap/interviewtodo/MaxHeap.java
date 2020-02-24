package datastructure.heap.interviewtodo;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {

	public static void main(String[] args) {
		MaxHeapImpl maxHeap = new MaxHeapImpl();
		/*
		 * maxHeap.insert(50); maxHeap.insert(30); maxHeap.insert(20);
		 * 
		 * 
		 * maxHeap.insert(15); maxHeap.insert(10); maxHeap.insert(8);
		 * maxHeap.insert(16);
		 * 
		 * maxHeap.insert(60);
		 * 
		 * maxHeap.displayMaxHeap();
		 */
		
		/*
		 * maxHeap.delete(); maxHeap.displayMaxHeap();
		 */
		
		/*
		 * int arr[] = {60, 50, 20, 30, 10, 8, 16, 15}; maxHeap.heapSort(arr);
		 * maxHeap.displayMaxHeap();
		 */
		
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(10);
		arr.add(20);
		arr.add(15);
		arr.add(12);
		arr.add(40);
		arr.add(25);
		arr.add(18);
		
		System.out.println(maxHeap.heapify(arr));
	}
}

class MaxHeapImpl {
	private List<Integer> maxHeap;
	private int size;
	
	public MaxHeapImpl() {
		maxHeap = new ArrayList<>();
		size = 0;
	}
	
	/**
	 * while inserting data into a Heap, always insert the element at the left most empty leaf in the heap and process the heap based on the value inserted
	 * 
	 * */
	public void insert(int num) {
		boolean set = Boolean.FALSE;
		maxHeap.add(num);
		int index = maxHeap.size() - 1;
		
		while( !set ) {
			if( num > maxHeap.get(this.parentIndex(index)) ) {
				this.swap(index, this.parentIndex(index), maxHeap);				
				index = this.parentIndex(index);
			}
			else 
				set = true;
		}
		
		size = maxHeap.size();
	}
	
	/**
	 * Deletion from Heap always happens from the root. Then the heap is adjusted by check the greatest child and moving it upwards.
	 * 
	 * */
	public void delete() {
		int lastIndex = size - 1;
		this.swap(0, lastIndex, maxHeap);
		this.size--;
		
		boolean set = false;
		int parentIndex = 0;
		
		while ( !set ) {
			int leftChild = this.leftChildIndex(parentIndex);
			int rightChild = this.rightChildIndex(parentIndex);
			int rightChildValue = Integer.MIN_VALUE;
			
			if(leftChild >= size && rightChild >= size ) {
				break;
			}
			else if ( rightChild < size ) {
				rightChildValue = maxHeap.get(rightChild);
			}			
			
			int greaterIndex = ( maxHeap.get(leftChild) > rightChildValue ) ? leftChild : rightChild;
			boolean permitSwap =  ( maxHeap.get(greaterIndex) > maxHeap.get(parentIndex) ) ? true : false;
					
			if(parentIndex != greaterIndex && permitSwap) {
				this.swap(parentIndex, greaterIndex, maxHeap);
				parentIndex = greaterIndex;
			}
			else 
				set = true;			
		}
	}
	
	public void heapSort(int[] arr) {
		for(int num : arr) {
			this.insert(num);
		}
		
		System.out.println(this.maxHeap);
		int maxHeapSize = size;
		
		for(int i = 0; i < maxHeapSize; i++) {
			this.delete();
		}
	}
	
	public List<Integer> heapify(List<Integer> arr) {
		for(int i = arr.size() - 1; i >= 0; i--) {
			boolean set = false;
			int parentIndex = i;
			
			while ( !set ) {
				int leftChild = this.leftChildIndex(parentIndex);
				int rightChild = this.rightChildIndex(parentIndex);
				int rightChildValue = Integer.MIN_VALUE;
				
				if(leftChild >= arr.size() && rightChild >= arr.size() ) {
					break;
				}
				else if ( rightChild < arr.size() ) {
					rightChildValue = arr.get(rightChild);
				}			
				
				int greaterIndex = ( arr.get(leftChild) > rightChildValue ) ? leftChild : rightChild;
				boolean permitSwap =  ( arr.get(greaterIndex) > arr.get(parentIndex) ) ? true : false;
						
				if(parentIndex != greaterIndex && permitSwap) {
					this.swap(parentIndex, greaterIndex, arr);
					parentIndex = greaterIndex;
				}
				else 
					set = true;			
			}			
		}
		
		return arr;
	}
	
	public void displayMaxHeap() {
		System.out.println(maxHeap);
	}
	
	private void swap (int index1, int index2, List<Integer> maxHeap) {
		int temp = maxHeap.get(index1);
		maxHeap.set(index1, maxHeap.get(index2));
		maxHeap.set(index2, temp);
	}
	
	private int leftChildIndex(int index) {
		return (2 * index) + 1;
	}
	
	private int rightChildIndex(int index) {
		return 2 * (index + 1);
	}
	
	private int parentIndex(int index) {
		return (index == 0) ? 0 : (int) Math.ceil((double)index / 2) - 1;
	}
}
