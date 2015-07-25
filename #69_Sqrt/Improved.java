public class Improved {
    public int mySqrt(int x) {
    	double guess = x;
        double delta = 0.0001;
        double avg = guess;
        while (Math.abs(Math.pow(avg, 2) - x) > delta) {
            avg = (guess + x / guess) / 2;
            guess = avg;
        }
        return (int)avg;
    }

    public static void main(String[] args) {
    	Improved sol = new Improved();
    	System.out.println(sol.mySqrt(8));
    }
}