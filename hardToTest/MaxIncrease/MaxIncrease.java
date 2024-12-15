public class MaxIncrease {
    public static int maxIncrease(int[] sales) {
        int n = sales.length;
        int maxIncrease = 0;  // 初始最大增幅为0

        // 遍历所有可能的 x 和 y，计算 A[y] - A[x]
        for (int x = 0; x < n - 1; x++) {
            for (int y = x + 1; y < n; y++) {
                // 如果 A[y] - A[x] 更大，更新最大增幅
                int increase = sales[y] - sales[x];
                if (increase > maxIncrease) {
                    maxIncrease = increase;
                }
            }
        }
        return maxIncrease;  // 返回最大增幅
    }
