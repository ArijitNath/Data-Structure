package datastructure.array.interviewtodo;

/*
 * https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0
 * */
public class LargestSunContiguousSubarray {

	public static void main(String[] args) {
		int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3}; 
		System.out.println(new KadaneAlgo().findMaxSum(arr));
	}
}

class KadaneAlgo {
	public int findMaxSum(int[] arr) {
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
		
		for(int  i = 0; i < arr.length; i++) {
			max_ending_here = max_ending_here + arr[i];
			
			if(max_so_far < max_ending_here)
				max_so_far = max_ending_here;
			if(max_ending_here < 0)
				max_ending_here = 0;
		}
		
		return max_so_far;
	}
}
