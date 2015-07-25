import java.util.*;

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}

public class Solution {
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0) return 0;
		if (points.length == 1) return 1;
		if (points.length == 2) return 2;
		class POLARORDER implements Comparator<Point> {
			Point p;
			POLARORDER(Point point) {this.p = point;}
			@Override
			public int compare(Point p1, Point p2) {
				int dy1 = p1.y - p.y;
				int dy2 = p2.y - p.y;
				if (dy1 > 0 && dy2 < 0) return -1;
				if (dy1 < 0 && dy2 > 0) return 1;
				if (dy1 == 0 && dy2 == 0) return 0;
				// if (dy1 == 0) return -1;
				// if (dy2 == 0) return 1;
				return findAngle(p, p1, p2);
			}

			// dy1, dy2 have the same sign and none are 0
			private int findAngle(Point p, Point p1, Point p2) {
				double dy1 = p1.y - p.y;
				double dy2 = p2.y - p.y;
				double dx1 = p1.x - p.x;
				double dx2 = p2.x - p.x;
				if (dx1 == 0 && dx2 == 0) return 0;
				if (dx1 == 0) {
					if (dy1 > 0) return (dx2 > 0) ? 1 : -1;
					if (dy1 < 0) return (dx2 > 0) ? -1 : 1;
				}
				if (dx2 == 0) {
					if (dy1 > 0) return (dx1 > 0) ? -1 : 1;
					if (dy1 < 0) return (dx1 > 0) ? 1 : -1;
				}
				double tan1 = dy1 / dx1;
				double tan2 = dy2 / dx2;
				if (dy1 > 0) {
					if (tan1 > 0 && tan2 < 0) return -1;
					if (tan1 < 0 && tan2 > 0) return 1;
				}
				if (dy1 < 0) {
					if (tan1 > 0 && tan2 < 0) return -1;
					if (tan1 < 0 && tan2 > 0) return 1;
				}
				return (int) (tan1 - tan2);
			}
		}

		List<Point> list = Arrays.asList(points);
		int max = 2;
		for (Point p : list) {
			Arrays.sort(points, new POLARORDER(p));
			// for (Point pp : points) {
			//  System.out.println(pp.x + ", " + pp.y);
			// }
			int sum = 2;
			double dy = points[1].y - points[0].y;
			double dx = points[1].x - points[0].x;
			double tan;
			if (dx == 0) tan = Double.MAX_VALUE;
			else tan = dy / dx;
			// System.out.println("1: " + tan);
			for (int i = 2; i < points.length; i++) {
				dy = points[i].y - points[0].y;
				dx = points[i].x - points[0].x;
				double tmp;
				if (dx == 0) tmp = Double.MAX_VALUE;
				else tmp = dy / dx;
				// System.out.println("dy: " + dy + " dx: " + dx);
				// System.out.println(i + ": " + tmp);
				if (tmp == tan) {
					sum++;
					// System.out.println("sum: " + sum);
					if (sum > max) {
						max = sum;
						// System.out.println("max: " + max);
					}
				}
				else sum = 2;
				tan = tmp;
			}
			// System.out.println("max: " + max);
		}
		return max;
	}

	public static void main(String[] args) {
		Point[] ps = new Point[5];
		ps[0] = new Point(3, -1);
		ps[1] = new Point(-2, 2);
		ps[3] = new Point(3, -3);
		ps[4] = new Point(-4, 5);
		ps[2] = new Point(-2, 5);
		Solution sol = new Solution();
		System.out.println(sol.maxPoints(ps));
	}
}