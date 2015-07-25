/* use only two array for dp */
public class Improved_2 {
    public int numDistinct(String s, String t) {
    	int slen = s.length();
    	int tlen = t.length();
    	/* both empty */
    	if (slen == 0 && tlen == 0) return 1;
    	/* s is empty but t is not */
    	if (slen == 0) return 0;
    	/* t is empty but s is not */
    	if (tlen == 0) return 1;
    	/* both not empty */
        int[] preCol = new int[slen + 1];
        int[] col = new int[slen + 1];
    	/* initialize */
    	for (int j = 0; j < slen + 1; j++) preCol[j] = 1;
    	/* begin dp */
    	for (int i = 1; i < tlen + 1; i++) {
    		for (int j = i; j < slen + 1; j++) {
    			if (t.charAt(i - 1) != s.charAt(j - 1)) col[j] = col[j - 1];
    			else col[j] = col[j - 1] + preCol[j - 1];
    		}
            preCol = col;
            col = new int[slen + 1];
    	}
    	return preCol[slen];
    }

    public static void main(String[] args) {
        Improved_2 sol = new Improved_2();
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(sol.numDistinct(s, t));
    }
}