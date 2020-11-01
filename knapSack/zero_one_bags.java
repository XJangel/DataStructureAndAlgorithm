package knapSack;

/*
 * 0-1背包问题
 * dp[i][j]代表前i个物品在总体积为j的条件下的最大价值
 * dp[i][j]=①不放第i个物品：dp[i-1][j]
 * ②放第i个物品：dp[i-1][j-v[i]+w[i]
 * dp[i][j]=max(①，②)
 * 
 */

public class zero_one_bags {

    // 优化前
    public static int one_zero_bag(int[][] goods, int V) {
        int[][] dp = new int[goods.length + 1][V + 1];

        for (int i = 1; i <= goods.length; i++) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= goods[i][0]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - goods[i][0]] + goods[i][1]);
                }
            }
        }

        return dp[goods.length][V];

    }

    // 优化后
    // 若是想dp[i][j]代表总体积刚好为j时的物体的最大体积，那么在初始化dp时，只有dp[0]初始化为0，其余都为负无穷
    public static int one_zero_bag_better(int[][] goods, int V) {
        int[] dp = new int[V + 1];

        for (int i = 1; i <= goods.length; i++) {
            for (int j = V; j >= goods[i][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - goods[i][0]] + goods[i][1]);
            }
        }

        return dp[V];
    }

}
