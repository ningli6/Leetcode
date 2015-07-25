import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (numRows == 0) return result;
        List<Integer> prev = null;
        for (int i = 0; i < numRows; i++) {
        	List<Integer> row = new ArrayList<Integer>();
        	row.add(1);
	        if (i == 0) {
	        	result.add(row);
	        	prev = row;
	        	continue;
	        }	
        	for (int k = 1; k < i; k++) {
        		row.add(prev.get(k - 1) + prev.get(k));
        	}
        	row.add(1);
        	result.add(row);
        	prev = row;
        }
        return result;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
    	res = sol.generate(5);
    	for (List<Integer> list : res) {
    		for (Integer it : list) {
    			System.out.print(it + " ");
    		}
    		System.out.println();
    	}
    }
}