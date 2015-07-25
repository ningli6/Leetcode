import java.util.*;

public class Solution {
    public boolean isHappy(int n) {
    	if (n == 1) return true;
    	if (n == 0) return false;
        Set<Integer> set = new HashSet<Integer>();
        while (n != 1) {
        	if (set.contains(n)) return false;
        	set.add(n);
        	int result = 0;
        	while (n != 0) {
        		int m = n;
        		n = n / 10;
        		int rem = m - n * 10;
        		result += rem * rem;
        	}
        	n = result;
        }
        return true;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.isHappy(19));
    }
}