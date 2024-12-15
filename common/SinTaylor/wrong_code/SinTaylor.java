import java.util.Scanner;

public class SinTaylor {
    public static int findSinNthTerm(double x, double precision) {
        // 检查非法输入
        if (precision <= 0) {
            return -1; // 返回 -1 表示 "none"
        }

        int n = 0; // 第 n 项
        double term = x; // 泰勒展开的第 0 项
        double factorial = 1; // 阶乘值，用于计算

        while (Math.abs(term) >= precision) {
            n++;
            // 计算下一项
            factorial *= (2 * n) * (2 * (n + 1)); // 更新阶乘值 wrong_code
            term = -term * x * x / factorial; // 更新第 n 项
        }

        return n; // 返回满足条件的最小 n
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入角度 x（弧度）和精度
        System.out.print("请输入角度 x (弧度): ");
        double x = scanner.nextDouble();
        System.out.print("请输入精度: ");
        double precision = scanner.nextDouble();

        // 调用方法计算
        int result = findSinNthTerm(x, precision);

        // 输出结果
        if (result == -1) {
            System.out.println("结果: none");
        } else {
            System.out.println("满足条件的最小 n 为: " + result);
        }

        scanner.close();
    }
}
