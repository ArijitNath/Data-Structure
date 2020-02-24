package datastructure.array.interviewtodo;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays/0/
 * */
public class MergeTwoSortedArrayNoExtraSpace {

	public static void main(String[] args) {
		int arr1[] = new int[]{1, 5, 9, 10, 15, 20}; 
	    int arr2[] = new int[]{2, 3, 8, 13};
	    
	    System.out.print(Arrays.toString(arr1));
	    System.out.println(Arrays.toString(arr2));
	    
	    new MergeArray().merge(arr1, arr2);
	    
	    System.out.print(Arrays.toString(arr1));
	    System.out.println(Arrays.toString(arr2));
	}
}

class MergeArray {
	public void merge(int[] arr1, int[] arr2) {
		int m = arr1.length;
		int n = arr2.length;
		
		for(int  i = n - 1; i >= 0; i--) {
			int last = arr1[m -1], j;
			for(j = m - 2; j >= 0 && arr1[j] > arr2[i]; j-- ) {
				arr1[j+1] = arr1[j];
			}
			
			if(j != (m-2) && arr2[i] < last) {
				arr1[j + 1] = arr2[i];
				arr2[i] = last;
			}
		}
	}
}
