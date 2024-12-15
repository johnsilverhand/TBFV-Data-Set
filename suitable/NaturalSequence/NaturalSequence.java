import java.util.Scanner;

public class SumFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入 x
        System.out.print("请输入一个数 x: ");
        int x = scanner.nextInt();
        int n;
        // 判断 x 是否小于 0
        if (x < 0) {
            n = -1;
            System.out.println("Result: none");  // 如果 x 小于 0，则输出 "none"
        } else if (x == 0) {
            n = 0;
            System.out.println("Result: 0");  // 如果 x 等于 0，则输出 0
        } else {
            int sum = 0;
            n = 1;

            // 累加自然数，直到累加和 >= x
            while (sum < x) {
                sum += n;
                n++;
            }

            // 在循环结束后，将 n 减去 1，使其符合条件
            n--; // 确保 n 是满足条件的最小值

            // 输出当前自然数 n
            System.out.println("Result: " + n);
        }

        scanner.close();  // 关闭 Scanner
    }
}