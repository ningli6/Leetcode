/* 1 time traversal */

public class Improved {
    public int trap(int[] height) {
        int len = height.length;
        int ptra = 0; 
        int ptrb = len - 1;
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;
        while (ptra <= ptrb) {
            leftMax = Math.max(leftMax, height[ptra]);
            rightMax = Math.max(rightMax, height[ptrb]);
            if (leftMax < rightMax) {
                sum += leftMax - height[ptra++];
            }
            else {
                sum += rightMax - height[ptrb--];
            }
        }
	    return sum;
    }

    public static void main(String[] args) {
    	Improved sol = new Improved();
    	int[] s = {0,1,0,2,1,0,1,3,2,1,2,1};
    	System.out.println(sol.trap(s));
    }
}