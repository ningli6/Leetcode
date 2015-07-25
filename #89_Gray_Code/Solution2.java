import java.util.List;
import java.util.ArrayList;

public class Solution2 {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (n <= 0) {
        	list.add(0);
        	return list;
        }
        list.add(0);
        for (int i = 0; i < n; i++) {
            int nb = 1 << i;
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add(nb + list.get(j));
            }
        }
        return list;
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	List<Integer> rslt = sol.grayCode(3);
    	for (Integer it: rslt) {
    		System.out.print(it + " ");
    	}
    	System.out.println();
    }
}