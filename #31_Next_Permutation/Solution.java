/* O(n) time algorithm */
public class Solution {
	public void nextPermutation(int[] num) {
		if (num == null || num.length == 0) return;
		int index = num.length - 1;
		while (index > 0 && num[index - 1] >= num[index]) index--;
		if (index == 0) reverse(num, 0, num.length - 1);
		else {
			index--;
			int pick = num.length - 1;
			while(pick > index && num[index] >= num[pick]) pick--;
			swap(num, index, pick);
			reverse(num, index + 1, num.length - 1);
		}
	}

	private void swap(int[] num, int i, int j) {
		if (num == null || num.length == 0) return;
		if (i < 0 || j < 0 || i >= num.length || j >= num.length) throw new IndexOutOfBoundsException();
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}

	private void reverse(int[] num, int head, int tail) {
		if (num == null || num.length == 0) return;
		if (head < 0 || tail < 0 || head >= num.length || tail >= num.length) throw new IndexOutOfBoundsException();
		if (head == tail) return;
		if (head > tail) throw new IllegalArgumentException();
		while (head <= tail) {
			swap(num, head++, tail--);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] test = new int[] {2, 2, 2, 3, 2, 2, 1};
		for (int i : test) System.out.print(i + " ");
		System.out.println();
		sol.nextPermutation(test);
		for (int i : test) System.out.print(i + " ");
		System.out.println();
	}
}