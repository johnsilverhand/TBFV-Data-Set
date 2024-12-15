import java.util.Scanner;

public class FindFibindex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入一个数 x: ");
        int x = scanner.nextInt();

        if (x < 0) {
            System.out.println("Result: none"); // 输入非法
        } else if (x == 0) {
            System.out.println("Result: 0"); // 输入为 0
        } else {
            int a = 0, b = 1, n = 1;

            while (b < x) {
                int temp = b;
                b = a + b; // 更新斐波那契数
                a = temp;
                n++;
            }

            System.out.println("Result: " + n); // 输出满足条件的最小索引
        }

        scanner.close();
    }
}
