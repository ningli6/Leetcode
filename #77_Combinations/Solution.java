import java.util.List;
import java.util.LinkedList;
import java.util.Set;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (n < 1) return result;
        if (n == 1) {
            if (k == 1) {
            	List tmp = new LinkedList<Integer>();
            	tmp.add(1);
            	result.add(tmp);
            }
            return result;
        }
        if (k <= 0 || k > n) return result;
        for (int i = 1; i <= n; i++) {
        	List<Integer> set = new LinkedList<Integer>();
        	backtrace(result, set, i, n, k);
        }
        return result;
    }

    private void backtrace(List<List<Integer>> result, List<Integer> set, int start, int n, int k) {
    	if (n - start + 1 < k) return;
    	set.add(start);
        if (k - 1 == 0) {
            List<Integer> hit = new LinkedList<Integer>(set);
            result.add(hit);
            set.remove(set.size()-1);
            return;
        }
    	for (int i = start + 1; i <= n; i++) backtrace(result, set, i, n, k - 1);
        set.remove(set.size()-1);
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<List<Integer>> result = sol.combine(4, 2);
    	for (List<Integer> ls : result) {
    		for (Integer t : ls) {
    			System.out.print(t + " ");
    		}
    		System.out.println();
    	}
    }
}