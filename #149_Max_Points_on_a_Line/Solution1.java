/* HashTable based solution, O(n) time */
import java.util.*;

public class Solution1 {
	public int maxPoints(Point[] points) {
		if (points == null) return 0;
		if (points.length < 3) return points.length;
		Map<Integer, Map<Integer, Integer>> map = new HashMap();
		int result = 0;
		for (int i = 0; i < points.length - 1; i++) {
			map.clear();
			int max = 0; int overlap = 0;
			for (int j = i + 1; j < points.length; j++) {
				int dx = points[j].x - points[i].x;
				int dy = points[j].y - points[i].y;
				if (dx == 0 && dy == 0) {
					overlap++;
					continue;
				}
				int gcd = GCD(dx, dy);
				dx /= gcd;
				dy /= gcd;
				if (map.containsKey(dx)) {
					if (map.get(dx).containsKey(dy)) {
						map.get(dx).put(dy, map.get(dx).get(dy) + 1);
					}
					else {
						map.get(dx).put(dy, 1);
					}
				}
				else {
					Map<Integer, Integer> nm = new HashMap();
					nm.put(dy, 1);
					map.put(dx, nm);
				}
				max = Math.max(max, map.get(dx).get(dy));
			}
			result = Math.max(result, max + 1 + overlap);
		}
		return result;
	}

	private int GCD(int a, int b) {
		if (b == 0) return a;
		return GCD(b, a % b);
	}

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		Point[] ps = new Point[3];
		ps[0] = new Point(0, 0);
		ps[1] = new Point(1, 1);
		ps[2] = new Point(0, 0);
		System.out.println(sol.maxPoints(ps));
	}
}