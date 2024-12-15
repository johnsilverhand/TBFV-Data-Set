import java.util.Scanner;

public class FindMinSquare {  // 类名必须与文件名相同
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入一个数 x: ");
        int x = scanner.nextInt();

        if (x < 0) {
            System.out.println("Result: none"); // 输入非法
        } else if (x == 0) {
            System.out.println("Result: 0"); // 输入为 0
        } else {
            int n = 1;

            while (n * n < x) {
                n++; // 增加 n
            }

            System.out.println("Result: " + n); // 输出满足条件的最小整数
        }

        scanner.close();
    }
}
