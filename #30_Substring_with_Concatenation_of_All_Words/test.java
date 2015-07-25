import java.util.HashSet;

public class test {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		HashSet<String> set2 = new HashSet<String>();
		set.add("Good");
		set.add("King");
		set2.add("King");
		set2.add("Good");
		System.out.println(set.equals(set2));
	}
}