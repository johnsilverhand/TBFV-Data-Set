//雅可比迭代法用于求解线性方程组
//逐步更新未知数的值，直到收敛到解
public class JacobiMethod {

    // 雅可比迭代法
    public static double[] jacobiIteration(double[][] A, double[] b, double[] x, double tolerance, int maxIterations) {
        int n = A.length;  // 方程的个数，也就是矩阵A的行数
        double[] xNew = new double[n];  // 用于存储每次迭代后的新解
        double diff;  // 解的差异度，用于判断是否收敛
        int iterations = 0;  // 记录迭代次数

        // 开始迭代过程
        do {
            // 对每个方程进行迭代计算
            for (int i = 0; i < n; i++) {
                double sum = 0;
                // 计算除去当前项A[i][i] * x[i]之外的和
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        sum += A[i][j] * x[j];  // 对其他变量的贡献
                    }
                }
                // 使用雅可比公式更新xNew[i]
                xNew[i] = (b[i] - sum) / A[i][i];
            }

            // 计算新解与旧解的差异，用于判断是否收敛
            diff = 0;
            for (int i = 0; i < n; i++) {
                diff += Math.pow(xNew[i] - x[i], 2);  // 差的平方和
            }

            // 将新解xNew复制到x中，准备下一次迭代
            System.arraycopy(xNew, 0, x, 0, n);
            iterations++;  // 迭代次数加1

        } while (Math.sqrt(diff) > tolerance && iterations < maxIterations);  // 如果差异大于容差且未达到最大迭代次数，则继续迭代

        return xNew;  // 返回最终求得的解
    }

    public static void main(String[] args) {
        // 示例线性方程组：
        // 4x + y - z = 3
        // 3x + 5y + 2z = 10
        // x - 2y + 3z = 5

        double[][] A = {
            {4, 1, -1},
            {3, 5, 2},
            {1, -2, 3}
        };

        double[] b = {3, 10, 5};

        // 初始猜测解向量x，可以设置为零或其他值
        double[] x = {0, 0, 0};

        // 设置容差和最大迭代次数
        double tolerance = 1e-6;  // 收敛精度
        int maxIterations = 100;  // 最大迭代次数

        // 使用雅可比迭代法求解方程组
        double[] solution = jacobiIteration(A, b, x, tolerance, maxIterations);

        // 打印求得的解
        System.out.println("Solution:");
        for (double val : solution) {
            System.out.println(val);  // 打印每个变量的值
        }
    }
}
