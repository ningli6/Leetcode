import java.util.*;

/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int num = 0;       // char read from last read4 call
    int bufferPtr = 0; // char need to be read starting from bufferPtr in buffer
    char[] buffer = new char[4];
    public int read(char[] buf, int n) {
    	if (n == 0) return 0;
        int count = 0; // how many char read in this call
        while (count < n) {
        	// no char left in buffer, call read4
        	if (bufferPtr == 0) num = read4(buffer);
        	// EOF
        	if (num == 0) break;
        	while (count < n && bufferPtr < num) {
        		// always start filling buf from beginning
        		// take chars left in buffer before call read4
        		buf[count++] = buffer[bufferPtr++];
        	}
        	if (bufferPtr == num) bufferPtr = 0;
        }
        return count;
    }
}