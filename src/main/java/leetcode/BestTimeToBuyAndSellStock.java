package leetcode;

/**
 * Created by yonney.yang on 2015/3/30.
 */
public class BestTimeToBuyAndSellStock {
    /**
     * buy lower, sell max
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int low = prices[0];
        int profit = 0;

        /* for(int i = 0; i < prices.length; ++i){
            if(prices[i] > low){
                profit = Math.max(profit,prices[i]-low);
            }else{
                low = prices[i];
            }
        }*/

        for(int i = 1; i < prices.length; i++){
            low = Math.min(low,prices[i-1]);
            profit = Math.max(profit,prices[i]-low);
        }
        return profit;
    }


}
