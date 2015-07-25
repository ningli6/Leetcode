import java.util.*;

public class Solution {
    static char[] symbol = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int divisor = 1000;
        while (index < 7) {
        	int quotient = num / divisor;
        	if (quotient > 0) {
        		if (quotient <= 3) {
        			for (int j = 0; j < quotient; j++) sb.append(symbol[index]);
        		}
	        	else if (quotient == 4) {
	        		sb.append(symbol[index]);
	        		sb.append(symbol[index - 1]);
	        	}
	        	else if (quotient == 5) {
	        		sb.append(symbol[index - 1]);
	        	}
	        	else if (quotient == 6) {
	        		sb.append(symbol[index - 1]);
	        		sb.append(symbol[index]);
	        	}
	        	else if (quotient > 6 && quotient < 9) {
	        		sb.append(symbol[index - 1]);
	        		num = num - divisor * 5;
	        		continue;
	        	}
	        	else {
	        		sb.append(symbol[index]);
	        		sb.append(symbol[index - 2]);
	        	}
        	}
        	num = num - divisor * quotient;
        	divisor /= 10;
        	index += 2;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.intToRoman(99));
    	// System.out.println(sol.intToRoman(2));
    	// System.out.println(sol.intToRoman(3));
    	// System.out.println(sol.intToRoman(4));
    	// System.out.println(sol.intToRoman(5));
    	// System.out.println(sol.intToRoman(6));
    	// System.out.println(sol.intToRoman(7));
    	// System.out.println(sol.intToRoman(8));
    	// System.out.println(sol.intToRoman(9));
    	// System.out.println(sol.intToRoman(10));
    }
}