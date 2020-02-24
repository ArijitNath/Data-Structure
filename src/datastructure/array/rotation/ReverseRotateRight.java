package datastructure.array.rotation;

import java.util.Arrays;
/*4871
 * 4597
 * 4826
 * 4649
 * 4699
 *  = 4728.4
*/
public class ReverseRotateRight {

	public static void main(String[] args) {
		int[] arr = new int[7];
		for(int i = 1; i< 8; i++) {
			arr[i-1] = i;
		}
		long start = System.currentTimeMillis();
		int d = 2;
		
		d = d % arr.length; 
		new ReverseRotateR().rightRotate(arr, d);
		
		System.out.println(Arrays.toString(arr));
		
		System.out.println("Total Time = " + (System.currentTimeMillis() - start));
	}
}

class ReverseRotateR {
	void rightRotate(int[] arr, int d) {
		if(d == 0)
			return;
		int n = arr.length;
		
		reverseRotate(arr, n - d, (n - 1));
		reverseRotate(arr, 0, (n - 1) - d);
		reverseRotate(arr, 0, n - 1);
	}
	void reverseRotate(int[] arr, int start, int end) {
		int temp;
		while(start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}
 