public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	int a = Math.max(A, E);
    	int b = Math.max(B, F);
    	int c = Math.min(C, G);
    	int d = Math.min(D, H);
        return area(A, B, C, D) + area(E, F, G, H) - area(a, b, c, d);
    }

    private boolean isValid(int a, int b, int c, int d) {
    	return a < c && b < d;
    }

    private int area(int a, int b, int c, int d) {
    	return (isValid(a, b, c, d)) ? (c - a) * (d - b) : 0;
    }
}