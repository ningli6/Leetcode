public class Solution {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) return;
        /* reverse the array */
        int len = s.length;
        int i = 0, j = len - 1;
        while (i <= j) {
        	char tmp = s[j];
        	s[j] = s[i];
        	s[i] = tmp;
        	i++;
        	j--;
        }
        /* reverse word part, skip space */
        i = 0; j = 0;
        while (i < len && j < len) {
        	while(j + 1 < len && s[j + 1] != ' ') j++;
        	int start = i; int end = j;
        	while (start <= end) {
        		char tmp = s[end];
        		s[end] = s[start];
        		s[start] = tmp;
        		start++;
        		end--;
        	}
        	i = j + 2;
        	j = i;
        }
    }

    public static void main(String[] args) {
    	char[] t = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
    	Solution sol = new Solution();
    	sol.reverseWords(t);
    	for (char c : t) {
    		System.out.print(c);
    	}
    	System.out.println();
    }
}