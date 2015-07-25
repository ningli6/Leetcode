// O(n^2) time
// this problem can be O(n)
public class naive {
	public void nextPermutation(int[] num) {
        if (num == null || num.length == 0) return;
        int m = num.length - 1;
        for (int i = num.length - 2; i >= 0; i--) {
        	if (num[i] >= num[m]) bubbleSort(num, i); // don't foget equal
        	else { // don't foget else!!!
        	    int j = i + 1;
        	    while (num[i] >= num[j] && j < num.length) j++;
        	    exch(num, i, j);
        		break;
        	}
        }
        return;
    }

    private void bubbleSort(int[] num, int index) {
    	if (index < 0 || index >= num.length) throw new IndexOutOfBoundsException();
    	while (index < num.length - 1 && num[index] > num[index + 1]) { // careful for <>
    		exch(num, index, index + 1);
    		index++;
    	}
    }

    private void exch(int[] num, int i, int j) {
    	if (i < 0 || i >= num.length || j < 0 || j >= num.length) throw new IndexOutOfBoundsException();
    	int tmp = num[i];
    	num[i] = num[j];
    	num[j] = tmp;
    }

    public static void main(String[] args) {
    	naive na = new naive();
    	int[] test = new int[] {2,2,7,5,4,3,2,2,1};
    	na.nextPermutation(test);
    	for (int i : test) System.out.print(i + " ");
    	System.out.println();
    }
}