package datastructure.stackqueue.interviewtodo;

import java.util.Stack;

public class QueueWithTwoStack {

	public static void main(String[] args) {
		/*
		 * QueueWithTwoStackEnqueueHeavyImpl q = new
		 * QueueWithTwoStackEnqueueHeavyImpl(); q.enQueue(1); q.enQueue(2);
		 * q.enQueue(3); q.enQueue(4);
		 * 
		 * System.out.println(q.deQueue()); System.out.println(q.deQueue());
		 * System.out.println(q.deQueue()); System.out.println(q.deQueue());
		 */
		
		QueueWithTwoStackDequeueHeavyImpl q = new QueueWithTwoStackDequeueHeavyImpl();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		
	}
}

class QueueWithTwoStackEnqueueHeavyImpl {
	private Stack<Integer> stack1, stack2;
	
	public QueueWithTwoStackEnqueueHeavyImpl() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	public void enQueue(int x) {
		while( !stack1.isEmpty() ) {
			stack2.push( stack1.pop() );
		}
		
		stack1.push(x);
		
		while( !stack2.isEmpty() ) {
			stack1.push( stack2.pop() );
		}
	}
	
	public int deQueue() {
		int num = stack1.pop();
		return num;
	}
}

class QueueWithTwoStackDequeueHeavyImpl {
	private Stack<Integer> stack1, stack2;
	
	public QueueWithTwoStackDequeueHeavyImpl() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	public void enQueue(int x) {
		stack1.push(x);
	}
	
	public int deQueue() {
		while( !stack1.isEmpty() ) {
			stack2.push( stack1.pop() );
		}
		
		return stack2.pop();
	}
}