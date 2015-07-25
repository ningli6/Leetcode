import java.util.*;

class Pair implements Comparable<Pair> {
	int a;
	int b;
	int ia;
	int ib;
	int val;
	Pair(int a, int ia, int b, int ib) {
		this.a = a; 
		this.ia = ia;
		this.b = b; 
		this.ib = ib;
		this.val = a + b;}
	@Override
	public int compareTo(Pair p) {
		return val - p.val;
	}
	public void print() {
		System.out.println("a : " + a + " ia: " + ia + " b: " + b + " ib: " + ib);
	}
}

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList();
        List<Pair> cmpList = new ArrayList();
        Set<List<Integer>> set = new HashSet();
        if (nums == null || nums.length < 4) return result;
        for (int i = 0; i < nums.length - 1; i++) {
        	for (int j = i + 1; j < nums.length; j++) {
        		cmpList.add(new Pair(nums[i], i, nums[j], j));
        	}
        }
        int len = cmpList.size();
        Collections.sort(cmpList);
        int s = 0; int e = len - 1;
        while (s < e) {
        	int sum = cmpList.get(s).val + cmpList.get(e).val;
        	if (sum > target) e--;
        	else if (sum < target) s++;
        	else {
        		int end = e; int endval = cmpList.get(end).val;
        		while (end > s && cmpList.get(end).val == endval) {
        			Pair p1 = cmpList.get(s);
        			Pair p2 = cmpList.get(end);
        			if (isValid(p1, p2)) { // check wheather an element is used twice
        				List<Integer> r = new LinkedList();
        				r.add(p1.a);
        				r.add(p1.b);
        				r.add(p2.a);
        				r.add(p2.b);
        				Collections.sort(r);
        				if (!set.contains(r)) {
        					result.add(r);
        					set.add(r);
        				}
        			}
        			end--;
        		}
        		s++;
        	}
        }
        return result;
    }

    private boolean isValid(Pair p1, Pair p2) {
    	if (p1.a == p2.a && p1.ia == p2.ia) return false;
    	if (p1.b == p2.b && p1.ib == p2.ib) return false;
    	if (p1.a == p2.b && p1.ia == p2.ib) return false;
    	if (p1.b == p2.a && p1.ib == p2.ia) return false;
    	return true;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {2, 1, 0, -1};
    	List<List<Integer>> result = sol.fourSum(t, 2);
    	for (List<Integer> ls : result) {
    		for (Integer it : ls) {
    			System.out.print(it + " ");
    		}
    		System.out.println();
    	}
    }
}