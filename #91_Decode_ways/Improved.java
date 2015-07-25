public class Improved {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        /* if string have two consecutive 0, can't be decoded */
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == '0' && s.charAt(i + 1) == '0') return 0;
        }
        /* if the first char is 0, can't be decoded */
        if (s.charAt(0) == '0') return 0;
        /* if string length is 1, return 1 */
        if (s.length() == 1) return 1;
        int[] a = new int[len];
        a[0] = 1;
        /* if first two is a number greater than 26 or multiple of 10, a[1] can only be 1 */
        if (Integer.parseInt(s.substring(0, 2)) > 26 && s.charAt(1) == '0') return 0;
        else if (Integer.parseInt(s.substring(0, 2)) > 26 || s.charAt(1) == '0') a[1] = 1;
        else a[1] = 2;
        /* start from the third char */
        for (int i = 2; i < len; i++) {
            /* if char is 0 */
            if (s.charAt(i) == '0') {
                if (Integer.parseInt(s.substring(i - 1, i + 1)) > 26) return 0;
                /* same as case before last case */
                a[i] = a[i - 2];
                continue;
            }
            /* do not increase */
            if (Integer.parseInt(s.substring(i - 1, i + 1)) > 26 || s.charAt(i - 1) == '0') a[i] = a[i - 1];
            /* increase */
            else a[i] = a[i - 1] + a[i - 2];
        }
        return a[len - 1];
    }

    public static void main(String[] args) {
    	Improved sol = new Improved();
    	System.out.println(sol.numDecodings("301"));
    }
}