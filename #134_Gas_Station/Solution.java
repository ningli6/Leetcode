public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || gas.length == 0 || cost == null || cost.length == 0) return -1;
		int len = gas.length;
		// start from gas[0]
		int index = 0;
		while (index < len) {
			int cur = index;
			int r = 0;
			int step = 0;
			while (r + gas[cur] >= cost[cur]) {
				step++;
				if (step == len) return index;
				r = r + gas[cur] - cost[cur];
				cur++;
				if (cur == len) cur = 0;
			}
			if (index + step >= len) break;
			index += step + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] g = {4};
		int[] c = {5};
		System.out.println(sol.canCompleteCircuit(g, c));
	}
}