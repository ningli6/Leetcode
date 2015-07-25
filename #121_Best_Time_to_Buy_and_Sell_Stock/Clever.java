/* linear time algorithm */
public class Clever {
	public int maxProfit(int[] prices) {
        if (prices.length < 2 || prices == null) return 0;
        int maxprofit = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= min) min = prices[i];
            else {
                if ((prices[i] - min) > maxprofit) maxprofit = prices[i] - min;
            }
        }
        return maxprofit;
    }
}