package datastructure.basic.interviewtodo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortHashMapByValue {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("Arijit", 100);
		map.put("Ritchie", 90);
		map.put("Ari", 80);
		map.put("Nath", 70);
		
		System.out.println(new SortHashMapByValueImpl().sort(map));
	}
}

class SortHashMapByValueImpl {
	public Map<String, Integer> sort(Map<String, Integer> map) {
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				//return e2.getValue().compareTo(e1.getValue());
				return e2.getValue() - e1.getValue();
			}
		});
		
		Map<String, Integer> newMap = new LinkedHashMap<String, Integer>();
		
		for(Map.Entry<String, Integer> entry : list) {
			newMap.put(entry.getKey(), entry.getValue());
		}
		
		return newMap;
	}
	
	
}
