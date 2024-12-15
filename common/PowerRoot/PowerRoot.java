import java.util.Scanner;

public class IntegerRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数 n 和一个正整数 k（以空格分隔）：");
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();

        int g; // 定义最终输出的 g 值

        if (n <= 0 || k <= 0) {
            g = -1; // 输入非法，设置 g 为 -1
            System.out.println("g = " + g);
            return;
        }

        int guess = 1; // 初始猜测值
        while (Math.pow(guess, k) < n) {
            int power = (int) Math.pow(guess, k - 1); // 计算当前 guess^(k-1)
            int fraction = n / power;               // 计算 n / guess^(k-1)
            guess = (guess + fraction) / 2;         // 更新猜测值
        }

        if (Math.pow(guess, k) == n) {
            g = guess; // 存在整数根，g 为当前值
        }
        if (Math.pow(guess, k) > n) {
            g = 0; // 不存在整数根，g 为 0
        }

        System.out.println("g = " + g);
    }
}
