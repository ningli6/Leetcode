import java.util.*;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) dp[i] = Integer.MAX_VALUE;
        for (List<Integer> row : triangle) {
        	if (row.size() == 1) {
        		dp[1] = row.get(0);
        	}
        	else {
        		int index = 1;
        		int prev = dp[index - 1];
        		for (Integer it : row) {
        			int tmp = dp[index];
        			dp[index] = Math.min(dp[index], prev) + it;
        			prev = tmp;
        			index++;
        		}
        	}
        }
        int min = Integer.MAX_VALUE;
        for (Integer it : dp) {
        	min = Math.min(it, min);
        }
        return min;
    }
}