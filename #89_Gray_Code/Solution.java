import java.util.List;
import java.util.LinkedList;
import java.util.HashSet;

public class Solution {
    public List<Integer> grayCode(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (n <= 0) {
        	list.add(0);
        	return list;
        }
        int prev = 0;
        for (int count = 0; count < Math.pow(2, n); count++) {
        	if (count == 0) {
        		list.add(prev); 
        		set.add(prev);
        		continue;
        	}
	        for (int i = 0; i < n; i++) {
	        	int var = flipbit(prev, i);
	        	if (!set.contains(var)) {
	        		prev = var;
	        		list.add(prev); 
	        		set.add(prev);
	        		break;
	        	}
	        }
        }
        return list;
    }

    private int flipbit(int origin, int index) {
    	int mask = 1 << index;
    	return origin ^= mask;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<Integer> rslt = sol.grayCode(3);
    	for (Integer it: rslt) {
    		System.out.print(it + " ");
    	}
    	System.out.println();
    }
}