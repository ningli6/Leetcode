public class Solution {
    public static String countAndSay(int n) {
        if (n == 0) return null;
        StringBuilder str = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
        	StringBuilder sb = new StringBuilder();
        	int len = str.length();
        	int iter = 0;
        	while (iter < len) {
        		char c = str.charAt(iter);
        		int count = 1;
        		while ((iter + 1) < len && str.charAt(iter + 1) == c) {
        			count++;
        			iter++;
        		}
        		sb.append(count);
        		sb.append(c);
        		iter++;
        	}
        	str = sb;
        }
        return str.toString();
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.countAndSay(1));
    	System.out.println(sol.countAndSay(2));
    	System.out.println(sol.countAndSay(3));
    	System.out.println(sol.countAndSay(4));
    	System.out.println(sol.countAndSay(5));
    	System.out.println(sol.countAndSay(6));
    }
}