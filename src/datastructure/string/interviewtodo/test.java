package datastructure.string.interviewtodo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;

public class test {
	public static void main(String args[]) {
		//System.out.println(encode("Open", "123"));
		//System.out.println(decode("Open", "1234"));
		List<String> a = new CopyOnWriteArrayList<String>();
		a.add("A");
		a.add("B");
		a.add("C");
		
		Iterator<String> i = a.iterator();
		
		while(i.hasNext()) {
			String s = i.next();
			
			System.out.println(s);
			i.remove();
		}
		
		System.out.println(a);
	}
	
	static String encode (String message, String key) {
        String result = "";
        for(int i = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i);
            int keyChar;
            try {
                keyChar = Integer.parseInt(String.valueOf(key.charAt(i)));
            }
            catch(StringIndexOutOfBoundsException e) {
                keyChar = 1;
            }

            for(int j = 0; j < keyChar; j++) {
                result += messageChar;
            }
        }

        return result;
    }
	
	static String decode (String message, String key) {
        String result = "";
        
        if(message.isEmpty() || key.isEmpty())
            return "-1";

        int counter = 0;
        for(int i = 0; i < key.length(); i++) {
            int keyChar = Integer.parseInt(String.valueOf(key.charAt(i)));

            String subResult = "";
            for(int j = counter; j < (counter + keyChar) && (counter + keyChar) <= message.length(); j++) {
                char subKey;
                subKey = message.charAt(j);
                
                if( !subResult.contains(String.valueOf(subKey)) ) {
                    subResult += subKey;
                }
            }

            counter += keyChar;
            result += subResult;
        }

        for(int i = counter ; i < message.length(); i++) {
            result += message.charAt(i); 
        }
        
        return result;
    }

}
