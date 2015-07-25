import java.util.*;

public class Solution {
    public int largestRectangleArea(int[] height) {
    	if (height == null || height.length == 0) return 0;
        int maxArea = 0;
        int[] h = Arrays.copyOf(height, height.length + 1); // padding with 0
        Deque<Integer> stack = new LinkedList();
        int i = 0;
        while(i < h.length) {
        	if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
        		stack.push(i++); // keep ascending elements in stack
        	}
        	else {
        		int t = stack.pop();
        		int minHeight = h[t];
        		int rightIndex = i;
        		int leftIndex = (stack.isEmpty()) ? -1 : stack.peek();
        		int tempArea = h[t] * (rightIndex - leftIndex - 1);
        		maxArea = Math.max(maxArea, h[t] * (rightIndex - leftIndex - 1));
        	}
        }
        return maxArea;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {2,1,5,6,2,3};
    	System.out.println(sol.largestRectangleArea(t));
    }
}