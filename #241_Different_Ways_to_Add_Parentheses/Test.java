import java.util.*;

public class Test {
	public static void main(String[] args) {
		int i = 0;
		List<Integer> lista = new LinkedList<Integer>();
		List<Integer> listb = new LinkedList<Integer>();
		listb.add(1);
		listb.add(2);
		listb.add(3);
		for (int a : lista) {
			for (int b : listb) {
				System.out.println(++i);
			}
		}
		System.out.println(Integer.valueOf(""));
	}
}