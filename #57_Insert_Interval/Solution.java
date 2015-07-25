import java.util.List;
import java.util.LinkedList;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
 
 public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	if (newInterval == null) return intervals;
    	List<Interval> result = new LinkedList<Interval>();
    	boolean inserted = false;
    	Interval prev = null;
    	/* if intervals is empty */
    	if (intervals == null || intervals.isEmpty()) {
    		result.add(newInterval);
    		return result;
    	}
    	for (Interval it : intervals) {
    		/* before insertion */
    		if (!inserted) {
	    		if (isOverlap(it, newInterval)) {
	    			Interval nit = new Interval(it.start, it.end);
	    			merge(nit, newInterval);
	    			result.add(nit);
	    			inserted = true;
	    			prev = nit;
	    			continue;
	    		}
	    		/* corner case: */
	    		if (it.start > newInterval.end) {
	    			result.add(newInterval);
	    			Interval nit = new Interval(it.start, it.end);
	    			result.add(nit);
	    			inserted = true;
	    			prev = nit;
	    			continue;
	    		}
	    		Interval nit = new Interval(it.start, it.end);
	    		result.add(nit);
	    		prev = nit;
    		}
    		/* after insertion */
    		else {
    			if (isOverlap(prev, it)) {
    				merge(prev, it);
    			}
    			else {
		    		Interval nit = new Interval(it.start, it.end);
		    		result.add(nit);
		    		prev = nit;
    			}
    		}
    	}
    	/* corner case: */
    	if (!inserted) {
			if (isOverlap(prev, newInterval)) {
				merge(prev, newInterval);
			}
			else {
	    		result.add(newInterval);
			}
    	}
    	return result;
    }

    private boolean isOverlap(Interval a, Interval b) {
    	if (a == null || b == null) return false;
    	if (a.start == b.start) return true;
    	Interval smaller = (a.start < b.start) ? a : b;
    	Interval bigger = (smaller == a) ? b : a;
    	return smaller.end >= bigger.start;
    }

    private void merge(Interval main, Interval sub) {
    	main.start = (main.start < sub.start) ? main.start : sub.start;
    	main.end = (main.end > sub.end) ? main.end : sub.end;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<Interval> list = new LinkedList<Interval>();
    	list.add(new Interval(1, 3));
    	list.add(new Interval(6, 9));
    	List<Interval> result = sol.insert(list, new Interval(2, 5));
    	for (Interval it :result) {
    		System.out.println(it.start + ", " + it.end);
    	}
    }
}