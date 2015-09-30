import java.util.*;

class KeyPoint implements Comparable<KeyPoint> {
	int index;
	int height;
	KeyPoint startPoint;

	KeyPoint(int ind, int ht) {
		this.index = ind;
		this.height = ht;
		this.startPoint = null;
	}

	KeyPoint(int ind, int ht, KeyPoint kp) {
		this.index = ind;
		this.height = ht;
		this.startPoint = kp;
	}

	public int compareTo(KeyPoint kp) {
		return this.height - kp.height;
	}
}

public class Solution2 {
	public List<int[]> getSkyline(int[][] buildings) {
		if (buildings == null || buildings.length == 0) {
			return new LinkedList<int[]>();
		}
		List<int[]> result = new LinkedList<int[]>();
		KeyPoint[] kpList = new KeyPoint[buildings.length * 2];
		for (int i = 0; i < buildings.length; i++) {
			kpList[2 * i] = new KeyPoint(buildings[i][0], buildings[i][2]);
			kpList[2 * i + 1] = new KeyPoint(buildings[i][1], buildings[i][2], kpList[2 * i]);
		}
		Arrays.sort(kpList, new Comparator<KeyPoint>() {
			public int compare(KeyPoint kp1, KeyPoint kp2) {
				if (kp1.index != kp2.index) {
					return kp1.index - kp2.index;
				}
				if (kp1.startPoint == null && kp2.startPoint == null) {
					return kp2.height - kp1.height;
				}
				if (kp1.startPoint != null && kp2.startPoint != null) {
					return kp1.height - kp2.height;
				}
				if (kp1.startPoint != null && kp2.startPoint == null) {
					return 1;
				}
				return -1;
			}
		});
		PriorityQueue<KeyPoint> pq = new PriorityQueue<KeyPoint>(kpList.length, Collections.reverseOrder());
		for (KeyPoint kp : kpList) {
			if (kp.startPoint == null) { // starting point
				if (pq.peek() == null || (pq.peek().height < kp.height)) {
					int[] newPoint = new int[2];
					newPoint[0] = kp.index;
					newPoint[1] = kp.height;
					result.add(newPoint);
				}
				pq.add(kp);
			}
			else if (kp.startPoint != null) { // ending point
				pq.remove(kp.startPoint);
				if (!pq.isEmpty() && pq.peek().height < kp.height) {
					int[] newPoint = new int[2];
					newPoint[0] = kp.index;
					newPoint[1] = pq.peek().height;
					result.add(newPoint);
				}
				else if (pq.isEmpty()) {
					int[] newPoint = new int[2];
					newPoint[0] = kp.index;
					newPoint[1] = 0;
					result.add(newPoint);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[][] buildings = {
			{1, 4, 3}, {1, 9, 5}
		};
		List<int[]> re = sol.getSkyline(buildings);
		for (int[] intPair : re) {
			System.out.println(intPair[0] + ", " + intPair[1]);
		}
	}
}