import java.util.Arrays;

public class LongestPalindromeSubsequence {
	public static void main(String[] args) {
		System.out.println(longestPalindromeSubsequence("character"));
		System.out.println(longestPalindromeSubsequence("aibophobia"));
		System.out.println(longestPalindromeSubsequence("aibohphobia"));
	}
	
	/*
	 * Time complexity: Θ(n^2)
	 * Space complexity: Θ(n^2)
	 */
	public static String longestPalindromeSubsequence(String s) {
		int n = s.length();
		/*
		 * data[a][b] refers to the length of the longest
		 * palindrome subsequence between the indices (a, a + b).
		 * Note: b, is the offset from a.
		 * 
		 * choices[a][b] gives instructions on how to get the
		 * longest palindrome subsequence of the indices
		 * (a, a + b).
		 * 
		 * Suppose choices[a][b] = 1, this means s[a] and s[a + b]
		 * are part of it.
		 * 
		 * Suppose choices[a][b] = 2, this means look at the indices
		 * (a, a + b - 1) i.e. cut the last character off.
		 * 
		 * Suppose choices[a][b] = 3, this means look at the indices
		 * (a + 1, a + b) i.e. cut the first character off.
		 */
		int[][] data = new int[n][n];
		byte[][] choices = new byte[n][n];
		/*
		 * This just sets the longest palindomic sequence of a single
		 * character as 1.
		 */
		for(int i = 0; i < n; i++) {
			data[i][0] = 1;
			choices[i][0] = 1;
		}
		
		/*
		 * Having set the longest palindrome sequence of all length 1
		 * substrings, the algorithm iterates between 1 to (n - 1). For
		 * each value of l, the algorithm calculates the longest palindrome
		 * sequence contained for all substrings of length l.
		 */
		for(int l = 1; l < n; l++) {
			for(int i = 0; i < n - l; i++) {
				//System.out.println(i + " " + l + " " + s.charAt(i) + " " + s.charAt(i + l));
				/*
				 * The algorithm calculates the length of the longest palindrome 
				 * subsequence in the range (i, i + l). It checks if the first
				 * and last characters in this range equal each other, in which case
				 * they are part of that palindrome.
				 */
				if(s.charAt(i) == s.charAt(i + l)) {
					if(l == 1) {
						data[i][l] = 2;
					} else {
						data[i][l] = 2 + data[i + 1][l - 2];
					}
					choices[i][l] = 1;
				} else {
					if(l != 0) {
						if(data[i][l - 1] > data[i + 1][l - 1]) {
							data[i][l] = data[i][l - 1];
							choices[i][l] = 2;
						} else {
							data[i][l] = data[i + 1][l - 1];
							choices[i][l] = 3;
						}
					}
				}
			}
		}
		/*for(int[] m: data) {
			System.out.println(Arrays.toString(m));
		}*/
		/*
		 * ret is the value to be returned.
		 * The longest palindrome subsequence will be reconstructed here,
		 * from the choices array.
		 */
		char[] ret = new char[data[0][n - 1]];
		int i = 0;
		int len = n - 1;
		int indexStart = 0;
		while(len >= 0) {
			//System.out.println(choices[i][len] + " " + i + " " + len);
			if(choices[i][len] == 1) {
				ret[indexStart] = s.charAt(i);
				ret[ret.length - indexStart - 1] = s.charAt(i + len);
				i++;
				len -= 2;
				indexStart++;
			} else if(choices[i][len] == 2) {
				len--;
			} else if(choices[i][len] == 3) {
				i++;
				len--;
			}
		}
		return new String(ret);
	}
}
