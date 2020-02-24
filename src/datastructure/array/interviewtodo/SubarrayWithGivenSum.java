package datastructure.array.interviewtodo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
 * */
public class SubarrayWithGivenSum {

	public static void main(String[] args) throws IOException {
		new SubarraySum().input();
	}
}

class SubarraySum {
	private int N;
	private int S;
	private List<Integer> numbers;
	
	public void input() throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		S = Integer.parseInt(br.readLine());
		
		numbers = new ArrayList<>(N);
		
		for(int  i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			numbers.add(num);
		}
		
		calculate();
	}
	
	public void calculate() {
		int count = 0;
		int sum = 0;
		int i;
		boolean flag = false;
		
		for(i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i);
				
			if(sum > S) {
				while(sum > S) {
					sum -= numbers.get(count);
					count++;
				}				
			}
			
			if(sum == S) {
				flag = true;
				break;
			}	
		}
		
		if(flag) {
			System.out.println((count+1) + " " + (i + 1));
		}
		else {
			System.out.println("-1");
		}
	}
}
