package datastructure.array.interviewtodo;

public class BinarySerachRotatedArray {

	public static void main(String[] args) {
		int[] arr = {6,7,1,2,3,4,5};
		
		System.out.println(new BinarySerachRotatedArrayImpl().search(arr, 0, arr.length - 1, 5));
	}
}

class BinarySerachRotatedArrayImpl {
	public int search(int[] arr, int low, int high, int key) {
		if(low > high) return -1;
		
		int mid = (low + high) / 2;
		
		if(arr[mid] == key ) return mid;
		
		if( arr[low] <= arr[mid] ) {
			if(key >= arr[low] && key <= arr[mid]) {
				return search(arr, low, mid - 1, key);
			}
			
			return search(arr, mid + 1, high, key);
		}
		
		if( key >= arr[mid] && key <= arr[high] ) {
			return search(arr, mid + 1, high, key); 
		}
		
		return search(arr, low, mid - 1, key);
	}
}
