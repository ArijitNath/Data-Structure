package datastructure.array.arrangement;

import java.util.Arrays;

public class MoveAllZerosToEnd {

	public static void main(String[] args) {
		int[] arr = {0,1,0,2,0,3,0,4,0,5,0,6,0,7,0,8,0,9};
		
		MoveZeros.move(arr);
		System.out.println(Arrays.toString(arr));
	}
}

class MoveZeros {
	public static void move(int[] arr) {
		int count = 0;
		
		for(int  i= 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}
		
		while(count < arr.length) {
			arr[count++] = 0;
		}
	}
}
