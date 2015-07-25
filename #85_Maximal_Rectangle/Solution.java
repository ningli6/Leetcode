import java.util.*;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] height = new int[cols];
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
        		if (matrix[i][j] == '1') height[j] += 1;
        		else height[j] = 0;
        	}
        	maxArea = Math.max(maxArea, findMaxArea(height));
        }
        return maxArea;
    }

    private int findMaxArea(int[] height) {
    	if (height == null || height.length == 0) return 0;
    	int[] h = Arrays.copyOf(height, height.length + 1);
    	int maxArea = 0;
    	Deque<Integer> stack = new LinkedList();
    	int k = 0;
    	while (k < h.length) {
    		if (stack.isEmpty() || h[stack.peek()] <= h[k]) {
    			stack.push(k++);
    		}
    		else {
    			int t = stack.pop();
    			int leftIndex = (stack.isEmpty()) ? -1 : stack.peek();
    			int rightIndex = k;
    			int tmpArea = h[t] * (rightIndex - leftIndex - 1);
    			maxArea = Math.max(maxArea, tmpArea);
    		}
    	}
    	return maxArea;
    }

    public static void main(String[] args) {
    	char[][] t = {
    		{'0', '0', '1', '1', '0', '1'},
    		{'0', '1', '0', '0', '0', '0'},
    		{'1', '0', '1', '0', '1', '0'}
    	};
    	Solution sol = new Solution();
    	System.out.println(sol.maximalRectangle(t));
    }
}