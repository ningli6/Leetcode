import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

public class Improved {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target <= 0) return null;
        if (candidates == null || candidates.length == 0) return null;
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for (int i = 0; i < candidates.length; i++) {
            LinkedList<Integer> match = new LinkedList<Integer>();
            backtrace(candidates, target, i, res, match);
        }
        return res;
    }
    
    private void backtrace(int[] array, int target, int start, List<List<Integer>> res, LinkedList<Integer> local) {
        if (start < 0 || start >= array.length) throw new IllegalArgumentException();
        local.add(array[start]);
        if (array[start] > target) return;
        if (array[start] == target) {
            res.add(new LinkedList(local));
            return;
        }
        for (int i = start; i < array.length; i++) {
            backtrace(array, target - array[start], i, res, local);
            local.pollLast();
        }
    }

    public static void main(String[] args) {
        Improved sol = new Improved();
        int[] a = {2, 3, 6, 7};
        List<List<Integer>> res = sol.combinationSum(a, 7);
        for (List<Integer> list: res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}