import java.util.*;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        long n = numerator;
        long d = denominator;
        StringBuilder sb = new StringBuilder();
        /* sign */
        if ((n > 0 && d < 0) || (n < 0 && d > 0)) sb.append("-");
        n = Math.abs(n);
        d = Math.abs(d);
        /* integral part */
        long integral = n / d;
        sb.append(Long.toString(integral));
        if (d * integral == n) return sb.toString();
        /* decimal part */
        sb.append(".");
        /* simulate divide process */
        Map<Long, Integer> map = new HashMap();
        long r = n - d * integral;
        while (r != 0) {
        	if (map.containsKey(r)) {
        		sb.insert(map.get(r), "(");
        		sb.append(")");
        		break;
        	}
        	map.put(r, sb.length());
        	r *= 10;
        	long newNum = r / d;
        	sb.append(Long.toString(newNum));
        	r = r - newNum * d;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.fractionToDecimal(-2147483648, -1));
    }
}