/* O(n ^2) algorithm 
 * Note that this problem can be solved in linear time
 */
public class Naive {
	public int maxProfit(int[] prices) {
        if (prices.length < 2 || prices == null) return 0;
        int maxprofit = 0;
        int i = 0;
        while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
        for (; i < prices.length - 1; i++) {
        	for (int j = i + 1; j < prices.length; j++) {
        		if ((prices[j] - prices[i]) > maxprofit)
        			maxprofit = prices[j] - prices[i];
        	}
        }
        return maxprofit;
    }
}