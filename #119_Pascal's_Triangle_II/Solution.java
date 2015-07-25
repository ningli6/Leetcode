import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
    	int index = rowIndex + 1;
        int[] a = new int[index];
        for (int i = 0; i < index; i++) {
	        if (i == 0) a[i] = 1;
	        if (i == 1) a[i] = 1;
	        int prev = a[0];
	        for (int j = 1; j < i; j++) {
	        	int tmp = a[j];
	        	a[j] = a[j] + prev;
	        	prev = tmp;
	        }
            a[i] = 1;
        }
        List<Integer> resList = new ArrayList<Integer>();
        for (int i = 0; i < index; i++) {
        	resList.add(a[i]);
        }
        return resList;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<Integer> res = sol.getRow(3);
    	for (Integer it : res) {
    		System.out.print(it + " ");
    	}
    	System.out.println();
    }
}