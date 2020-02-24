package datastructure.array.rotation;

import java.util.Arrays;
/*4632
 * 4771
 * 4869
 * 4604
 * 4999
 *  = 4775
*/
public class RotateArray {

	public static void main(String[] args) {
		
		int[] arr = new int[200000];
		for(int i = 0; i< 200000; i++) {
			arr[i] = i;
		}
		long start = System.currentTimeMillis();
		Rotate r = new Rotate();
		r.doRotate(arr, 2);
		r.printArray(arr);
		
		System.out.println("Total Time = " + (System.currentTimeMillis() - start));

	}
}

class Rotate {
	public void doRotate(int[] arr, int d) {
		int n = arr.length;
		int gcd = GCD(n, d);
		
		for(int i = 0; i < gcd; i++) {
			int key = arr[i];
			int j = i;
			
			while(true) {
				int k = j + d;
				
				if ( k >= n) k = k - n;
				
				if( k == i) break;
				
				arr[j] = arr[k];
				j = k;
			}
			
			arr[j] = key;
		}
	}

	private int GCD(int a, int b) {
		if(b == 0)
			return a;
		return GCD(b, a%b);
	}
	
	public void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
}
