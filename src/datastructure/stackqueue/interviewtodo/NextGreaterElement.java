package datastructure.stackqueue.interviewtodo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int[] arr = {1,3,2,4};
		int[] arr1 = {4,3,2,1};
		System.out.println(new NextGreaterElementImpl().find(arr));
		System.out.println(new NextGreaterElementImpl().find(arr1));
	}
}

class NextGreaterElementImpl {
	
	private List<Integer> arr;
	private Stack<Integer> stack;
	
	public NextGreaterElementImpl() {
		arr = new ArrayList<>();
		stack = new Stack<>();
	}
	
	public List<Integer> find(int[] arrData) {
		
		for(int a : arrData) {
			
			if( !stack.isEmpty() && a > stack.peek() ) {
				
				while(!stack.isEmpty()) {
					if( a > stack.peek() ) {
						arr.add(a);
						stack.pop();
					}
				}			
			}
						
			stack.push(a);			
		}
		
		while(!stack.isEmpty()) {
			arr.add(-1);
			stack.pop();
		}
		
		return arr;		
	}
}
