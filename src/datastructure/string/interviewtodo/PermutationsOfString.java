package datastructure.string.interviewtodo;

public class PermutationsOfString {

	public static void main(String[] args) {
		Permutations.permute("AAB", "");
	}
}

class Permutations {
	public static void permute(String rotation, String answer) {
		if(rotation.length() == 0) {
			System.out.println(answer + " ");
			return;
		}
		
		for(int i = 0; i < rotation.length(); i++) {
			char ch = rotation.charAt(i);
			String ros = rotation.substring(0, i) + rotation.substring(i + 1);
			
			permute(ros, answer + ch);
		}
	}
}