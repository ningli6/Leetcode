public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        int alen = a.length();
        int blen = b.length();
        StringBuilder sb = new StringBuilder();
        boolean carry = false;
        int i = 0;
        for (; i < alen && i < blen; i++) {
        	char ac = a.charAt(alen - i - 1);
        	char bc = b.charAt(blen - i - 1);
        	if (ac == '1' && bc == '1') {
        		if (carry) sb.append(1);
        		else sb.append(0);
        		carry = true;
        	}
        	else if (ac == '0' && bc == '0') {
        		if (carry) sb.append(1);
        		else sb.append(0);
        		carry = false;
        	}
        	else {
        		if (carry) {
        			sb.append(0);
        			carry = true;
        		}
        		else sb.append(1);
        	}
        }
        while (i < alen) {
        	char ac = a.charAt(alen - i - 1);
        	if (carry) {
        		if (ac == '0') {
        			sb.append(1);
        			carry = false;
        		}
        		else if (ac == '1') sb.append(0);
        	}
        	else sb.append(ac);
        	i++;
        }
        while (i < blen) {
        	char bc = b.charAt(blen - i - 1);
        	if (carry) {
        		if (bc == '0') {
        			sb.append(1);
        			carry = false;
        		}
        		else if (bc == '1') sb.append(0);
        	}
        	else sb.append(bc);
        	i++;
        }
        if (carry) sb.append(1);    
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.addBinary("11", "1"));
    }
}