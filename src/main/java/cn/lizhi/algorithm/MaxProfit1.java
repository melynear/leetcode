package cn.lizhi.algorithm;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 种花家的兔子
 * @version v1.0
 * @date 2019年11月18日
 */
public class MaxProfit1 {
    public static void main(String[] args) {
        int[] prices = new int[]{};
        System.out.println(maxProfit(prices));
    }
    
    private static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        
        int valley = prices[0];
        int maxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < valley) {
                valley = prices[i];
            } else if (prices[i] > valley) {
                maxProfit = Math.max(maxProfit, prices[i] - valley);
            }
        }
        
        return maxProfit;
    }
    
    /**
     * 动态规划求解
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param prices
     * @return
     */
    private static int maxProfit1(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        
        // 定义状态0为当天持有股票，1为当天不持有股票
        int[][] dp = new int[prices.length][2];
        
        // 定义初始值
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        
        return dp[prices.length - 1][0];
    }
    
    /**
     * 动态规划求解
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param prices
     * @return
     */
    private static int maxProfit2(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        
        // 由于当前状态只和前一个状态有关，所以不需要保存所有的状态
        int dpPre_0 = 0;
        int dpPre_1 = -prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            //dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dpPre_0 = Math.max(dpPre_0, dpPre_1 + prices[i]);
            
            //dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dpPre_1 = Math.max(-prices[i], dpPre_1);
        }
        
        return dpPre_0;
    }
}
