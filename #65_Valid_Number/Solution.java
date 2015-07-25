public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        /* trim space on both sides */
        int start = 0; int end = s.length() - 1;
        while (start < s.length() && s.charAt(start) == ' ') {
        	start++;
        }
        while (end >= 0 && s.charAt(end) == ' ') {
        	end--;
        }
        if (start > end) return false;
        boolean sci = false;
        boolean decimal = false;
        double numBeforeE = 0;
        double scale = 1.0;
        for (int i = start; i <= end; i++) {
        	char c = s.charAt(i);
        	if (c == '+') {
        		if (i != start) return false;
        	}
        	else if (c == '-') {
        		if (i > 0 && s.charAt(i - 1) != 'e') return false;
        	}
        	else if (c == 'e') {
        		if (i == start || i == end) return false;
        		if (sci) return false;
        		sci = true;
        		if (numBeforeE != 0 && (numBeforeE >= 10 || numBeforeE < 1)) return false;
        		for (int k = i + 1; k <= end; k++) {
        			if (s.charAt(k) < '0' || s.charAt(k) > '9') return false;
        		}
        		return true;
        	}
        	else if (c == '.') {
        		if (i == end && i == start) return false;
        		if (decimal) return false;
        		decimal = true;
        	}
        	else if (c < '0' || c > '9') return false;
        	int num = c - '0';
        	if (decimal) scale *= 0.1;
        	numBeforeE = (decimal) ? numBeforeE + num * scale: numBeforeE * 10 + num;
        }
        return true;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.isNumber("+.8"));
    }
}