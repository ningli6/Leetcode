import java.util.*;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<Integer>();
    	if (matrix == null || matrix.length == 0) return result;
        int lo = 0; int hi = matrix.length - 1;
        int left = 0; int right = matrix[0].length - 1;
        while (lo <= hi && left <= right) {
        	for (int i = left; i <= right; i++) {
        		result.add(matrix[lo][i]);
        	}
        	for (int i = lo + 1; i <= hi; i++) {
        		result.add(matrix[i][right]);
        	}
        	if (lo != hi) {
        		// System.out.println("lo: " + lo);
        		// System.out.println("hi: " + hi);
	        	for (int i = right - 1; i >= left; i--) {
	        		result.add(matrix[hi][i]);
	        	}
        	}
        	if (left != right) {
	        	for (int i = hi - 1; i > lo; i--) {
	        		result.add(matrix[i][left]);
	        	}
        	}
        	lo += 1; hi -= 1;
        	left += 1; right -= 1;
        }
        return result;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[][] t = {
    		{1, 2, 3, 10, 11},
    		{4, 5, 6, 12, 13},
    		{7, 8, 9, 14, 15}
    	};
    	List<Integer> list = sol.spiralOrder(t);
    	for (Integer it : list) {
    		System.out.print(it + " ");
    	}
    	System.out.println();
    }
}