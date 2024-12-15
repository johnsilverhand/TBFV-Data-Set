import java.util.Scanner;

public class FindMinPowOfThree {
    public static int findMinPowerOfThree(int x) {
        // 检查非法输入
        if (x <= 0) {
            return -1; // 返回 "none" 表示输入非法
        } else if (x == 0) {
            return 0; // 输入为0，返回n=0
        } else {
            int n = 1;
            while (Math.pow(3, n) < x) {
                n++; // 增加n
            }
            return n; // 返回满足条件的最小整数n
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入数值x
        System.out.print("请输入一个数 x: ");
        int x = scanner.nextInt();

        // 调用方法计算
        Object result = findMinPowerOfThree(x);

        // 输出结果
        System.out.println("Result: " + result);

        scanner.close();
    }
}
