/* time complexity: O(num1.length() * num2.length()) */

public class Solution {
    public String multiply(String num1, String num2) {
    	if (num1.length() == 1 && num1.charAt(0) == '0') return "0";
    	if (num2.length() == 1 && num2.charAt(0) == '0') return "0";
    	String result = "0";
    	for (int i = 0; i < num2.length(); i++) {
    		char c = num2.charAt(num2.length() - 1 - i);
    		String tmp = addZeros(multiplebyOne(num1, c), i);
    		// System.out.println("tmp: " + tmp);
    		result = plus(result, tmp); 
    		// System.out.println("result: " + result);
    	}
        return result;
    }

    public static String plus(String num1, String num2) {
    	// System.out.println("Num1: " + num1 + " + Num2: " + num2);
    	boolean addon = false;
    	StringBuilder sb = new StringBuilder();
    	int i = 0;
    	for (i = 0; i < num1.length() && i < num2.length(); i++) {
    		int d = num1.charAt(num1.length() - 1 - i) - '0' + num2.charAt(num2.length() - 1 - i) - '0';
    		if (addon) {
    			addon = false;
    			d += 1;
    		}
    		if (d < 10) {
    			sb.append((char) (d + '0'));
    			addon = false;
    		}
    		else {
    			sb.append((char) (d - 10 + '0'));
    			addon = true;
    		}
    	}
    	while (i < num1.length()) {
    		int d = num1.charAt(num1.length() - 1 - i) - '0';
    		if (addon) d += 1;
    		if (d < 10) {
    			sb.append((char) (d + '0'));
    			addon = false;
    		}
    		else {
    			sb.append((char) (d - 10 + '0'));
    			addon = true;
    		} 
    		i++;
    	}
    	while (i < num2.length()) {
    		int d = num2.charAt(num2.length() - 1 - i) - '0';
    		if (addon) d += 1;
    		if (d < 10) {
    			sb.append((char)(d + '0'));
    			addon = false;
    		}
    		else {
    			sb.append((char)(d - 10 + '0'));
    			addon = true;
    		} 
    		i++;
    	}
    	if (addon) sb.append('1');
    	return sb.reverse().toString();
    }

    public static String multiplebyOne(String num, char c) {
    	int addon = 0;
    	StringBuilder sb = new StringBuilder();
    	int i = 0;
    	for (i = 0; i < num.length(); i++) {
    		int d = (num.charAt(num.length() - 1 - i) - '0') * (c - '0') + addon;
    		sb.append((char) (d % 10 + '0'));
    		addon = (d / 10);
    	}
    	if (addon > 0) sb.append((char) (addon + '0'));
    	return sb.reverse().toString();
    }

    public static String addZeros(String str, int zeros) {
    	if (zeros == 0) return str;
    	StringBuilder sb = new StringBuilder(str);
    	for (int i = 0; i < zeros; i++) sb.append('0');
    	return sb.toString();
    }

    public static void main(String[] args) {
    	String a = "123"; String b = "0";
    	Solution sol = new Solution();
    	System.out.println(sol.multiply(a, b));
    	// System.out.println(Solution.plus("6888", "49200"));
    }
}