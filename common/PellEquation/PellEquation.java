import java.util.Scanner;

public class PellEquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入一个正整数 N
        System.out.print("请输入一个正整数 N：");
        int N = scanner.nextInt();

        if (N <= 0) {
            System.out.println("N 必须是正整数！");
            return;
        }

        // 初始化基本解 (x1, y1) = (3, 2)
        long x = 3;
        long y = 2;
        long X = 0; // 用于记录最大解的 x
        long Y = 0; // 用于记录最大解的 y

        // 不断生成下一个解，直到 x > N
        while (x <= N) {
            X = x; // 更新最大 x
            Y = y; // 更新最大 y

            // 递推生成下一个解
            long nextX = 3 * x + 4 * y;
            long nextY = 2 * x + 3 * y;

            x = nextX;
            y = nextY;
        }

        // 输出结果
        System.out.println("不超过 N 的最大整数解 x 为：" + X);
        System.out.println("对应的 y 值为：" + Y);
    }
}
