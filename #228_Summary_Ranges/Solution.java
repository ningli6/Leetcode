import java.util.*;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
    	List<String> re = new LinkedList();
        if (nums == null || nums.length == 0) return re;
        int len = nums.length;
        int s = 0;
        int e = 1;
        while (s < len && e < len) {
        	while (e < len && nums[e] == 1 + nums[e - 1]) e++;
        	re.add(range(nums[s], nums[e - 1]));
        	s = e;
        	e = s + 1;
        }
        if (s < len) re.add(range(nums[s], nums[e - 1]));
        return re;
    }

    private String range(int a, int b) {
    	if (a == b) return String.valueOf(a);
    	StringBuilder sb = new StringBuilder();
    	sb.append(a);
    	sb.append("->");
    	sb.append(b);
    	return sb.toString();
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {0,1,2,4,5,7};
    	List<String> re = sol.summaryRanges(t);
    	for (String s : re) {
    		System.out.println(s);
    	}
    	// System.out.println();
    }
}