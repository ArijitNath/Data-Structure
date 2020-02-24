package datastructure.stackqueue.interviewtodo;

import java.util.Arrays;

public class CircularQueue {

	public static void main(String[] args) {
		CircularQueueImpl cq = new CircularQueueImpl(5);
		
		cq.enQueue(1);
		cq.enQueue(2);
		cq.enQueue(3);
		cq.enQueue(4);
		cq.enQueue(5);
		cq.display();
		
		cq.enQueue(6);
		
		System.out.println(cq.deQueue());
		cq.display();
	}
}

class CircularQueueImpl {
	private int[] queue;
	private int front, rear;
	private int capacity;
	
	public CircularQueueImpl(int capacity) {
		this.capacity = capacity;
		front = -1;
		rear = -1;
		queue = new int[capacity];
	}
	
	public void enQueue(int num) {
		if( (front == 0 && rear == capacity - 1) || ( rear == (front - 1) % (capacity - 1) ) ) {
			System.out.println("Queue Overflow !");
			return;
		}
		
		if( front == -1) {
			front = rear = 0;
		}
		else if( rear == capacity - 1 && front != 0) {
			rear = rear % (capacity - 1);
		}
		else {
			rear++;
		}
		
		queue[rear] = num;
	}
	
	public int deQueue() {
		if(front == -1) {
			System.out.println("Queue Underflow !");
			return	-1;
		}
		
		int data = queue[front++];
		
		if(front == rear) {
			front = rear = -1;
		}
		
		else if( front == capacity - 1) {
			front = 0;
		}
		
		return data;
	}
	
	public void display() {
		for(int i = front; i <= rear; i++) {
			
		}
		System.out.println(Arrays.toString(queue));
	}
}