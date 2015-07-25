/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (buf == null || buf.length == 0) return 0;
        if (n == 0) return 0;
        int count = 0;
        char[] buffer = new char[4];
        while (true) {
        	int num = read4(buffer);
        	for (int i = 0; i < num; i++) {
        		buf[count++] = buffer[i];
        		if (count >= n) return count; // exceed limit
        	}
	        if (num < 4) break; // end of file
        }
        return count;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	char[] c = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2'};
    	System.out.println(sol.read(c, 16));
    }
}