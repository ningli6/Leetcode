public class Solution {
    public int mySqrt(int x) {
    	if (x < 0) throw new IllegalArgumentException();
        if (x == 0) return 0;
        if (x == 1) return 1;
        return (int) sqrt(x, 1, x - 1);
    }

    private long sqrt(int target, long lo, long hi) {
    	if (lo == hi) return lo;
    	if (lo == hi - 1) {
    		if (hi * hi == target) return hi;
    		if (lo * lo == target) return lo;
    		if (target > hi * hi) return hi;
    		return lo;
    	}
    	long sum = lo + hi;
    	long mid = sum / 2;
    	/* careful for overflow */
    	if (mid == target / mid) return mid;
    	/* can't skip mid here */
    	if (mid < target / mid) return sqrt(target, mid, hi);
    	if (mid > target / mid) return sqrt(target, lo, mid);
    	return -1;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.mySqrt(8));
    }
}