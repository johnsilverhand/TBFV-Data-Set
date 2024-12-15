import java.util.Scanner;

public class PerfectSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入正整数 n
        System.out.println("请输入一个正整数 n：");
        int n = scanner.nextInt();
        scanner.close();

        // 检查输入是否为正整数
        if (n <= 0) {
            System.out.println("g = -1");  // 输入无效，输出 -1
            return;
        }

        // 牛顿迭代法计算平方根
        double g = n / 2.0;  // 初始猜测值

        // 进行迭代直到结果足够精确
        while (Math.abs(g * g - n) > 1e-6) {
            g = (g + n / g) / 2.0;
        }

        // 判断g是否为整数并判断其平方是否等于n
        if (g == (int)g && g * g == n) {
            System.out.println("g = " + (int)g);  // 是完全平方数，输出整数g
        } else {
            System.out.println("g = 0");  // 不是完全平方数
        }
    }
}
