package datastructure.array.interviewtodo;

import java.util.Arrays;

public class SortArray012 {

	public static void main(String[] args) {
		int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		new SortArray012Impl().sort(arr);
	}
}

class SortArray012Impl {
	public void sort(int[] arr) {
		int low = 0, mid = 0, high = arr.length - 1;
		
		while( mid <= high ) {
			switch(arr[mid]) {
				case 0:
						int temp = arr[low];
						arr[low] = arr[mid];
						arr[mid] = temp;
						low++;
						mid++;
						break;
				case 1:
						mid++;
						break;
				case 2:
						int temp1 = arr[high];
						arr[high] = arr[mid];
						arr[mid] = temp1;
						high--;
						break;
			}			
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
