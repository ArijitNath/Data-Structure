package datastructure.array.interviewtodo;
/*
 * https://practice.geeksforgeeks.org/problems/missing-number-in-array/0
 * */
public class FindMissingNumber {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 10};
		System.out.println(new MissingNumber().find(arr, 10));
	}
}

class MissingNumber {
	public int find(int[] arr, int N) {
		int totalSum = N * (N+1) /2;
		int sum = 0;
		for(int a : arr) {
			sum += a; 
		}
		
		return totalSum - sum;
	}
}
