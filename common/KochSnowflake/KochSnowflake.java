import java.util.Scanner;

public class KochSnowflake {
    public static void main(String[] args) {
        // 创建Scanner对象，读取输入
        Scanner scanner = new Scanner(System.in);

        // 输入初始边长L和最大边长N
        double l = scanner.nextDouble();  // 输入初始等边三角形的边长 L
        double L = scanner.nextDouble();  // 输入最大边长 N

        // 输入值检查
        if (l <= 0 || L <= 0) {
            System.out.println("边长L和N必须为正数！");
            return;
        }

        // 初始化迭代次数
        int n = 0;
        double currentLength = l;

        // 循环计算每次迭代后的边长，直到达到或超过L
        while (currentLength < L) {
            currentLength *= 4.0 / 3.0;  // 边长增长4/3倍
            n++;  // 迭代次数加1
        }

        // 输出迭代次数
        System.out.println(n);
    }
}
