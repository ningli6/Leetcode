/* This naive solution exceeds time limit */

public class Solution {
    public int countPrimes(int n) {
    	/* a non-negative number n */
    	if (n < 0) throw new IllegalArgumentException();
        if (n <= 1) return 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
        	if (isPrime(i)) count++;
        }
        return count;
    }
    /* judge if a number is prime */
    public boolean isPrime(int p) {
    	if (p == 0) return false;
    	if (p == 1 || p == 2) return true;
    	if (p % 2 == 0) return false;
    	for (int i = 2; i < p; i++) {
    		if (p % i == 0) return false;
    	}
    	return true;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.isPrime(11));
    }
}