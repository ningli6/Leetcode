/* Implementation of Sieve of Eratosthenes */
/* Note that 1 is not a prime number */
import java.util.BitSet;

public class Improved {
    public int countPrimes(int n) {
    	BitSet bs = new BitSet(n);
        int count = 0;
        /* 0 and 1 are not prime */
        bs.set(0, 2);
        for (int i = 2; i < n; i++) {
            if (!bs.get(i)) {
                count++;
                for (int j = 2 * i; j < n; j += i) bs.set(j);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Improved sol = new Improved();
        System.out.println(sol.countPrimes(10));
    }
}