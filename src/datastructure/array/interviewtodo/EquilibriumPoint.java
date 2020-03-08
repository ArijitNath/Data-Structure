package datastructure.array.interviewtodo;

public class EquilibriumPoint {

	public static void main(String[] args) {
		int[] arr = {-7, 1 ,5, 2, -4, 3, 0};
		
		System.out.println(new EquilibriumPointImpl().find(arr));		
	}
}

class EquilibriumPointImpl {
	public int find(int[] arr) {
		int sum = 0, leftSum = 0;
		
		for(int num : arr) {
			sum += num;
		}
		
		for(int i = 0; i < arr.length; i++) {
			sum -= arr[i];
			
			if(leftSum == sum)
				return i;
			
			leftSum += arr[i];
		}
		
		return -1;
	}
}