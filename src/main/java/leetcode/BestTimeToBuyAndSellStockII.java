package leetcode;

/**
 * Created by yonney.yang on 2015/3/30.
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int length = prices.length;
        int profit = 0;
        for(int i = 0; i < length -1; i++){
            if(prices[i+1]-prices[i] > 0){
                profit += prices[i+1]-prices[i];
            }
        }
        return profit;
    }
}
