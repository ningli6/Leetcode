/* Note that we don't care about duplicating numbers, so just copy the latter one to previous positions 
will simplify the algorithm */
public class Improved {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int cur = 1, cp = 1;
		while (cur < nums.length) {
			if (nums[cur] != nums[cur - 1]) nums[cp++] = nums[cur];
			cur++;
		}
		return cp;
	}

	public static void main(String[] args) {
		Improved sol = new Improved();
		int[] t = {1, 1, 2, 2, 3};
		System.out.println(sol.removeDuplicates(t));
	}
}