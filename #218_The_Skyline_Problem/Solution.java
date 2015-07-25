import java.util.*;

class Pair implements Comparable<Pair> {
    int index;
    int height;
    Pair(int i, int h) {
        this.index = i;
        this.height = h;
    }

    public int compareTo(Pair p) {
        if (this.index != p.index) return this.index - p.index;
        if (p.height * this.height < 0) return this.height - p.height;
        if (this.height < 0 && p.height < 0) return Math.abs(p.height) - Math.abs(this.height);
        return Math.abs(this.height) - Math.abs(p.height);
    }

}

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new LinkedList();
        if (buildings == null || buildings.length == 0) return result;
        int len = buildings.length;
        Pair[] pairs = new Pair[2 * len];
        for (int i = 0; i < len; i++) {
            pairs[2 * i] = new Pair(buildings[i][0], -buildings[i][2]);
            pairs[2 * i + 1] = new Pair(buildings[i][1], buildings[i][2]);
        }
        Arrays.sort(pairs);
        int height = 0;
        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(len, Collections.reverseOrder());
        for (Pair p: pairs) {
            if (p.height < 0) {
                System.out.println("add");
                maxPQ.add(-p.height);
            }
            else maxPQ.remove(p.height);
            int newH = (maxPQ.peek() == null) ? 0 : maxPQ.peek();
            if (newH != height) {
                height = newH;
                int[] re = new int[2];
                re[0] = p.index;
                re[1] = height;
                result.add(re);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] t = {
            {1, 5, 10}, {3, 9, 10}
        };
        List<int[]> result = sol.getSkyline(t);
        for (int[] tt : result) {
            System.out.println(tt[0] + ", " + tt[1]);
        }
    }
}