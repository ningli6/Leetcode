import java.util.HashMap;

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;
        if (n % 2 == 0) {
	        double tmp = myPow(x, n / 2);
	        return tmp * tmp;
        }
        double tmp = myPow(x, n / 2);
        if (n > 0) return tmp * tmp * x;
        return tmp * tmp * 1 / x;
	}

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.myPow(2, 11));
    }
}