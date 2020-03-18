package cn.lizhi.algorithm.dp;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 种花家的兔子
 * @version v1.0
 * @date 2019年11月18日
 */
public class MaxProfit3 {
    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }
    
    private static int maxProfit(int k, int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        
        // 交易次数大于prices.length/2相当于不限次数
        if (k > prices.length / 2) {
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            
            return maxProfit;
        }
        
        int[][][] dp = new int[prices.length][k + 1][2];
        
        for (int i = 0; i < prices.length; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    // 定义初始值
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[0];
                    continue;
                }
                
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        
        return dp[prices.length - 1][k][0];
    }
}
