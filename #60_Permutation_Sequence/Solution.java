import java.util.*;

/* time O(n ^ 2) */

public class Solution {
    public String getPermutation(int n, int k) {
    	List<Integer> list = new LinkedList();
    	for (int i = 1; i <= n; i++) list.add(i);
        StringBuilder sb = new StringBuilder();
	    int start = 0; // inclusive
	    int kth = k - start;
	    /* O(n) */
        for (int i = 0; i < n; i++) {
        	/* O(n) */
        	int fac = factorial(n - i - 1);
        	int count = (kth - 1) / fac;
        	/* O(n) */
        	sb.append(list.remove(count));
        	start = count * fac;
        	kth = kth - start;
        }
        return sb.toString();
    }

    private int factorial(int n) {
    	int result = 1;
    	while (n > 0) {
    		result *= n;
    		n--;
    	}
    	return result;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.getPermutation(1, 1));
    	// System.out.println(sol.getPermutation(4, 2));
    	// System.out.println(sol.getPermutation(4, 3));
    	// System.out.println(sol.getPermutation(4, 4));
    	// System.out.println(sol.getPermutation(4, 5));
    	// System.out.println(sol.getPermutation(4, 6));
    }
}