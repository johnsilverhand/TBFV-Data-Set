import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 创建Scanner对象获取用户输入
        Scanner scanner = new Scanner(System.in);

        // 输入 y 的值
        System.out.print("请输入 y 的值: ");
        double y = scanner.nextDouble();

        int x = 0;
        int n = 0;  // 用 n 来表示满足条件的最大值 (x-1)

        // 使用无限循环
        while (true) {
            // 判断是否满足条件
            if (Math.pow(2, x) + Math.pow(3, x) >= y) {
                break;  // 如果不满足条件，跳出循环
            }
            n = x;  // 如果满足条件，则更新 n 为 x
            x++;  // 增加 x
        }

        // 输出满足条件的最大 x
        System.out.println("最大 x 的值是: " + n);

        // 关闭扫描器
        scanner.close();
    }
}
