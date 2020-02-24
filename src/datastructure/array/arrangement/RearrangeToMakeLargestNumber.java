package datastructure.array.arrangement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RearrangeToMakeLargestNumber {

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();		
		arr.add(54); 
        arr.add(546); 
        arr.add(548); 
        arr.add(60);
                
        LargestNumber.largest(arr);
        
        arr.stream()
        	.forEach((a) -> System.out.print(a));
	}
}

class LargestNumber {
	public static void largest(List<Integer> arr) {
		Collections.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
				String si1 = String.valueOf(i1);
				String si2 = String.valueOf(i2);
				
				String XY = si1 + si2;
				String YX = si2 + si1;
				
				return (XY.compareTo(YX) > 0 ? -1 : 1);
			}
		});
	}
}
