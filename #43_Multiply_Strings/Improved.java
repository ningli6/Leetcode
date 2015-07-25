/* time complexity: O(num1.length() * num2.length()) */

public class Improved {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int index = i + j;
                int d = (num1.charAt(num1.length() - 1 -i) - '0') * (num2.charAt(num2.length() - 1 - j) - '0') + result[index];
                // System.out.println("d: " + d);
                result[index] = d % 10;
                result[index + 1] += d / 10;
            }
        }
        // for (int i = 0; i < result.length; i++) {
        //     System.out.print(result[i] + " ");
        // }
        // System.out.println();
        StringBuilder sb = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            // System.out.println("i: " + i);
            if (i == (result.length - 1) && result[i] == 0) continue;
            sb.append(result[i]);
            // System.out.println("Str: " + sb.toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    	String a = "99"; String b = "99";
    	Improved sol = new Improved();
    	System.out.println(sol.multiply(a, b));
    	// System.out.println(Solution.plus("6888", "49200"));
    }
}