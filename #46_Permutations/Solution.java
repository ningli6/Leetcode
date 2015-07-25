import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> result = new LinkedList<List<Integer>>();
    	if (nums.length == 0) return result;
        Deque<List<Integer>> queue = new LinkedList<List<Integer>>();
        List<Integer> list = new LinkedList<Integer>();
        list.add(nums[0]);
        queue.push(list);
        while(!queue.isEmpty()) {
        	List<Integer> lst = queue.pop();
        	if (lst.size() == nums.length) {
        		result.add(lst);
        		continue;
        	}
        	int newInt = nums[lst.size()];
        	for (int i = 0; i <= lst.size(); i++) {
        		List<Integer> newList = new LinkedList<Integer>(lst);
        		newList.add(i, newInt);
        		queue.push(newList);
        	}
        }
        return result;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] t = {1, 2};
    	List<List<Integer>> result = sol.permute(t);
    	for(List<Integer> ls : result) {
    		for (Integer it : ls) {
    			System.out.print(it + " ");
    		}
    		System.out.println();
    	}
    }
}