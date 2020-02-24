package datastructure.array.interviewtodo;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		System.out.println(new BinarySearchImpl().search(arr, 0, arr.length-1, 8));
	}
}

class BinarySearchImpl {
	public int search(int[] arr, int low, int high, int key) {
		int mid = (low + high) / 2;
		
		if( low > high ) return -1; 
		
		if(key > arr[mid]) {
			return search(arr, mid + 1, high, key);
		}
		else if( key < arr[mid] ) {
			return search(arr, low, mid - 1, key);
		}

		return mid;
	}
}
