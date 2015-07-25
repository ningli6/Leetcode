/* assume that one number only appear once */

public class Improved {

	public int singleNumber(int[] nums) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int j = 0; j < nums.length; j++) {
				if(((nums[j] >> i) & 1) == 1) count++;
			}
			result |= ((count % 3) << i);
		}
		return result;
	}

	public static void main(String[] args) {
		// System.out.println("Start!");
    	int[] test = {1, 2, 3, 1, 2, 3, 1, 2, 3, 4};
    	Improved sol = new Improved();
    	System.out.println(sol.singleNumber(test));
	}
}