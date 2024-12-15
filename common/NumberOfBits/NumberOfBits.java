import java.util.Scanner;

public class BinaryLength {
    public static void main(String[] args) {
        // 输入一个正整数 n
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个正整数 n：");
        int n = scanner.nextInt();
        scanner.close();

        // 如果 n 小于等于 0，则输出 s = -1
        if (n <= 0) {
            System.out.println("s = -1");
            return;
        }

        // 初始化幂次变量 k
        int k = 0;
        int powerOfTwo = 1; // 从 2^0 开始

        // 迭代直到 2^k 大于 n
        while (powerOfTwo <= n) {
            k++;
            powerOfTwo = (int) Math.pow(2, k);
        }

        // 输出结果 s 为 k
        System.out.println("s = " + k);
    }
}
