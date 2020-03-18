package cn.lizhi.algorithm.dp;

/**
 * 股票最大收益值问题
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 种花家的兔子
 * @version v1.0
 * @date 2019年11月17日
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }
    
    /**
     * 动态规划求解：
     * 1、定义状态：第几天，交易次数，是否持有股票
     * 2、推导出状态转移方程
     * 3、定义初始状态：即第一天0到k此交易次数，持有和不持有股票时的收益
     *
     * @param k
     * @param prices
     * @return
     */
    private static int maxProfit(int k, int[] prices) {
        if (prices.length < 2) {
            return 0;
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
