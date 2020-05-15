//Best Time to Buy and Sell Stock II
public class P122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1)
            return 0;
        int buy = 0;
        int sell = 1;
        int profit = 0;
        while (buy < prices.length && sell < prices.length) {
            if (prices[sell] < prices[buy]) {
                buy = sell;
                sell++;
            } else {
                while (sell + 1 < prices.length && prices[sell] < prices[sell + 1]) {
                    sell++;
                }
                profit += prices[sell] - prices[buy];
                buy = sell + 1;
                sell = sell + 2;
            }
        }
        return profit;
    }
}