import java.util.*;

public class Solution {
	public List<Integer> diffWaysToCompute(String output) {
		if (output == null || output.length() == 0) {
			return null;
		}
		List<Integer> re = new LinkedList<Integer>();
		boolean singleNum = true;
		for (int i = 0; i < output.length(); i++) {
			if (isOperator(output.charAt(i))) {
				singleNum = false;
				List<Integer> left = diffWaysToCompute(output.substring(0, i));
				List<Integer> right = diffWaysToCompute(output.substring(i + 1));
				if (left == null) re.addAll(right);
				else if (right == null) re.addAll(left);
				else {
					for (int l : left) {
						for (int r : right) {
							if (output.charAt(i) == '+') re.add(l + r);
							else if (output.charAt(i) == '-') re.add(l - r);
							else re.add(l * r);
						}
					}
				}
			}
		}
		if (singleNum) {
			re.add(Integer.parseInt(output));
		}
		return re;
	}

	private boolean isOperator(Character c) {
		return c == '+' || c == '-' || c == '*';
	}

	public static void printList(List<Integer> list) {
		for (int i : list) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		List<Integer> re = sol.diffWaysToCompute("2*3-4*5");
		Solution.printList(re);
	}
}