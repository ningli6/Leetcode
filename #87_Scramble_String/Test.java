import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		String s1 = "good";
		String s2 = "doog";
        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        Arrays.sort(sc1);
        Arrays.sort(sc2);
        System.out.println(sc1 == sc2);
        System.out.println(sc1.equals(sc2));
        String ns1 = new String(sc1);
        String ns2 = new String(sc2);
        System.out.println(ns1 == ns2);
        System.out.println(ns1.equals(ns2));
        // System.out.println(ns1);
        // System.out.println(ns2);
	}
}