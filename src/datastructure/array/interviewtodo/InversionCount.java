package datastructure.array.interviewtodo;

public class InversionCount {

	public static void main(String[] args) {
		int[] arr = { 1, 20, 6, 4, 5 };
		
		System.out.println(new InversionCountImpl().count(arr));
	}
}

class InversionCountImpl {
	public int count(int[] arr) {
		int n = arr.length;
		boolean flag = false;
		int count = 0;
		for(int i = n-1; i > 0 ; i--) {
			for(int  j  = i -1; j >= 0; j--) {
				if(arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
					count++;
					flag = true;
				}
			}
			
			if(!flag) break;
		}
		
		return count;
	}
}