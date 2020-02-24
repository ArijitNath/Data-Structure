package datastructure.stackqueue.interviewtodo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParenthesisChecker {

	public static void main(String[] args) throws IOException {
		ParenthesisCheckerImpl p = new ParenthesisCheckerImpl();
		p.input();
	}
}

class ParenthesisCheckerImpl {
	private String openingBrackets = "({[";
	private String closingBrackets = ")}]";
	private Stack<String> stack;
	
	private int N;
	private List<String> expressionList;
	
	public ParenthesisCheckerImpl() { 
		stack = new Stack<>();
		expressionList = new ArrayList<>();
	}
	
	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader ( System.in ));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String exp = br.readLine();
			expressionList.add(exp);
		}
		
		for(String exp : expressionList) {
			System.out.println(this.check(exp));
		}
	}
	
	public String check(String expression) {
		for(int  i = 0; i< expression.length(); i++) {
			char ch = expression.charAt(i);
			String character = String.valueOf(ch);
			
			if( openingBrackets.contains(character) ) {
				stack.push(character);
			}
			else if ( closingBrackets.contains(character) && ( closingBrackets.indexOf(ch) == openingBrackets.indexOf(stack.peek()) ) ) {
				stack.pop();
			}
			else {
				break;
			}
		}
		
		if(stack.size() == 0)
			return "balanced";
			
		return "not balanced";
	}
}