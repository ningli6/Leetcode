public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) return m;
        if (m == 0) return 0;
        int shift = 0;
        while (m != n) {
        	m >>= 1;
        	n >>= 1;
        	shift++;
        }
        return m << shift;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.rangeBitwiseAnd(5, 7));
    }
}