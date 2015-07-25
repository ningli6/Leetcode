public class Solution {
    // you need treat n as an unsigned value
	public int reverseBits(int n) {
		for (int i = 0; i < 16; i++) {
			int lower = (n & (1 << i));
			int higher = (n & (1 << (31 - i)));
			if ((lower != 0 && higher == 0) || (lower == 0 && higher != 0)) {
				n = n ^ (1 << i);
				n = n ^ (1 << (31 - i));
			}
		}
		return n;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.reverseBits(43261596));
    }
}