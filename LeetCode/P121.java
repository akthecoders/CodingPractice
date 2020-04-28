// Best Time to Buy and Sell Stock
public class P121 {
    public int maxProfit(int[] prices) {
        int minBuyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minBuyPrice) {
                minBuyPrice = prices[i];
            } else if (maxProfit < prices[i] - minBuyPrice) {
                maxProfit = prices[i] - minBuyPrice;
            }
        }

        return maxProfit;
    }
}