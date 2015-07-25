public class Attempt2 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int len = nums.length;
        int[] robfirst = new int[len + 1];
        int[] skipfirst = new int[len + 1];
        for (int i = 0; i < len; i++) {
        	if (i == 0) {
        		robfirst[i + 1] = nums[i];
        		skipfirst[i + 1] = 0;
        	}
        	else {
        		if (i == len - 1) {
		        	robfirst[i + 1] = robfirst[i];
	        		int last = skipfirst[i - 1] + nums[i];
		        	skipfirst[i + 1] = (skipfirst[i] > last) ? skipfirst[i] : last;
        		}
        		else {
	        		int possible = robfirst[i - 1] + nums[i];
		        	robfirst[i + 1] = (robfirst[i] > possible) ? robfirst[i] : possible;
	        		possible = skipfirst[i - 1] + nums[i];
		        	skipfirst[i + 1] = (skipfirst[i] > possible) ? skipfirst[i] : possible;
		        }
        	}
        }
        return (robfirst[robfirst.length - 1] > skipfirst[skipfirst.length - 1]) ? robfirst[robfirst.length - 1] : skipfirst[skipfirst.length - 1];
    }

    public static void main(String[] args) {
    	int[] test = {1, 1, 1};
    	Attempt2 sol = new Attempt2();
    	System.out.println(sol.rob(test));
    }
}