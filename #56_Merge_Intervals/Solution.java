import java.util.List;
import java.util.LinkedList;

class Interval {
	int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return new LinkedList<Interval>();
        int len = intervals.size();
        Interval[] array = new Interval[len];
        Interval[] aux = new Interval[len];
        int index = 0;
        for (Interval it : intervals) {
        	array[index] = it;
        	index++;
        }
        mergeSort(array, aux, 0, len - 1);
        return merge(array);
    }

    private void mergeSort(Interval[] a, Interval[] aux, int lo, int hi) {
    	if (lo >= hi) return;
    	int mid = (lo + hi) / 2;
    	mergeSort(a, aux, lo, mid);
    	mergeSort(a, aux, mid + 1, hi);
    	for (int i = lo; i <= hi; i++) {
    		aux[i] = a[i];
    	}
    	int ptr = lo;
    	int p1 = lo; int p2 = mid + 1;
    	while (p1 <= mid && p2 <= hi) {
    		if (aux[p1].start < aux[p2].start) {
    			a[ptr++] = aux[p1++];
    		}
    		else {
    			a[ptr++] = aux[p2++];
    		}
    	}
    	while (p1 <= mid) a[ptr++] = aux[p1++];
    	while (p2 <= hi) a[ptr++] = aux[p2++];
    }

    private List<Interval> merge(Interval[] a) {
        List<Interval> result = new LinkedList<Interval>();
        for (Interval it: a) {
        	result.add(it);
        }
        if (a.length == 1) return result;
        int iter = 0;
        int size = result.size();
        while (iter < size - 1) {
        	Interval cur = result.get(iter);
        	Interval next = result.get(iter + 1);
        	if (overlap(cur, next)) {
        		result.remove(next);
        		mergeInterval(cur, next);
        		size = result.size();
        		continue;
        	}
        	iter++;
        }
        return result;
    }

    private boolean overlap(Interval a, Interval b) {
    	if (a.start == b.start) return true;
    	return a.end >= b.start;
    }

    private void mergeInterval(Interval a, Interval b) {
    	a.start = (a.start < b.start) ? a.start : b.start;
    	a.end = (a.end > b.end) ? a.end : b.end;
    }

    public static void main(String[] args) {
    	List<Interval> list = new LinkedList<Interval>();
    	Interval in0 = new Interval(1, 3);
    	// Interval in1 = new Interval(2, 6);
    	// Interval in2 = new Interval(8, 10);
    	// Interval in3 = new Interval(15, 18);
    	list.add(in0);
    	// list.add(in3);
    	// list.add(in0);
    	// list.add(in2);
    	Solution sol = new Solution();
    	List<Interval> res = sol.merge(list);
    	for (Interval it: res) {
    		System.out.println(it.start + ", " + it.end);
    	}
    }
}