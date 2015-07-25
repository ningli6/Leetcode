public class Solution {
	public int divide(int dividend, int divisor) {
		int result = divideLong(dividend, divisor);
		return result;
	}

    private int divideLong(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        if (dividend == 0) return 0;
        if (dividend < 0 && divisor > 0) return ~divideLong(~dividend + 1, divisor) + 1;
        if (dividend > 0 && divisor < 0) return ~divideLong(dividend, ~divisor + 1) + 1;
        if (dividend < 0 && divisor < 0) return divideLong(~dividend + 1, ~divisor + 1);
        if (divisor > dividend) return 0;
        int sum = divisor;
        int result = 1;
        while (sum + sum <= dividend) {
        	sum += sum;
        	result += result;
        }
        return result + divideLong(dividend - sum, divisor);
    }
}