package knapSack;

public class CompletePack {
    

    // 优化后
    public static int completePack(int[][] goods, int V) {
        int[] dp = new int[V + 1];
        for (int i = 1; i <= goods.length; i++) {
            for (int j = goods[i][0]; j <= V; j++) {
                dp[j] = Math.max(dp[j], dp[j - goods[i][0]] + goods[i][1]);
            }
        }
        return dp[V];
    }

}
