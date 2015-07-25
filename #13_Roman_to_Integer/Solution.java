import java.util.HashMap;

public class Solution {
    public static HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    public Solution() {
	    map.put('I', 1); map.put('V', 5); map.put('X', 10);
	    map.put('L', 50); map.put('C', 100);
	    map.put('D', 500); map.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int sum = 0;
        for (int i = 0; i < len; i++) {
        	int fweight = map.get(s.charAt(i));
        	int sweight = fweight;
        	if (i + 1 < len) sweight = map.get(s.charAt(i + 1));
        	if (sweight / fweight == 10 || sweight / fweight == 5) {
        		sum += sweight - fweight;
        		i++;
        	}
        	else {
        		sum += fweight;
        	}
        }
        return sum;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.romanToInt("DI"));
    	System.out.println(sol.romanToInt("DL"));
    	System.out.println(sol.romanToInt("DXXX"));
    	System.out.println(sol.romanToInt("DCCVII"));
    	System.out.println(sol.romanToInt("DCCCXC"));
    	System.out.println(sol.romanToInt("MD"));
    	System.out.println(sol.romanToInt("MDCCC"));
    	System.out.println(sol.romanToInt("CM"));
    	// System.out.println(sol.romanToInt("IX"));
    	// System.out.println(sol.romanToInt("X"));
    }
}