public class Solution {
	public int removeDuplicates(int[] nums) {
		int length = nums.length;
		int srt = 0;
		int lng = 1;
		int dup = 0;
		while (lng < nums.length) {
			if (nums[lng] > nums[srt]) {
				exch(nums, lng - dup, lng);
				srt++;
				lng++;
			}
			else {
				dup++;
				while (lng < nums.length - 1 && nums[lng + 1] == nums[srt]) {
					lng++;
					dup++;
				}
				if (lng == nums.length - 1) break;
				lng++;
				exch(nums, lng - dup, lng);
				srt = lng - dup;
				lng++;
			}
		}
		return length - dup;
	}

	private void exch(int[] nums, int i, int j) {
		if (i == j) return;
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		// int[] array = {1, 2, 3, 3, 3, 6, 6, 6, 7, 8, 9};
		int[] array = {1, 1};
		System.out.println(sol.removeDuplicates(array));
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}