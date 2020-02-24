package datastructure.string.interviewtodo;

public class LongestPalindromeSequence {

	public static void main(String[] args) {
		System.out.println(LPS.lps("BABCBAB"));
	}

}

class LPS {
	public static int lps(String str) {
		int n = str.length();
		int table[][] = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			table[i][i] = 1;
		}
		
		for(int c = 2; c <= n; c++) {
			for(int i = 0; i < n-c+1; i++) {
				int j = i + c -1;
				
				if(str.charAt(i) == str.charAt(j) && c == 2) {
					table[i][j] = 2;
				}
				else if(str.charAt(i) == str.charAt(j)) {
					table[i][j] = table[i+1][j-1] + 2;
				}
				else {
					table[i][j] = Math.max(table[i][j-1], table[i+1][j]);
				}
			}
		}
		
		return table[0][n-1];
	}
}