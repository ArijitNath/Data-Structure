package datastructure.array.interviewtodo;

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] arr = {3,0,0,2,0,4};
		System.out.println(new TrappingRainWaterImpl().find(arr));
	}
}

class TrappingRainWaterImpl {
	public int find(int[] arr) {
		int n = arr.length;
		int low = 0, high = n - 1;
		int left_max = 0, right_max = 0;
		int result = 0;
		
		while( low <= high ) {
			if( arr[low] < arr[high] ) {
				if(arr[low] > left_max) {
					left_max = arr[low];
				}
				else {
					result += left_max - arr[low];
				}
				
				low++;
			}
			else {
				if(arr[high] > right_max) {
					right_max = arr[high];
				}
				else {
					result += right_max - arr[high];
				}
				
				high--;
			}
		}
		
		return result;
	}
}