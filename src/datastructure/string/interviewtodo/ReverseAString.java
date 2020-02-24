package datastructure.string.interviewtodo;

/*
 * https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0
 * */
public class ReverseAString {

	public static void main(String[] args) {
		System.out.println(Reverse.doit("i.like.this.program.very.much"));
	}
}

class Reverse {
	public static String doit(String revStr) {
		int len = revStr.length();
		String finalStr = "", str = "";
		for(int  i = len - 1; i >= 0; i--) {
			char eachChar = revStr.charAt(i);
						
			if(eachChar == '.' || i == 0) {
				finalStr += str + eachChar;
				str = "";
				continue;
			}
			
			str = eachChar + str;
		}
		
		return finalStr;
	}
}