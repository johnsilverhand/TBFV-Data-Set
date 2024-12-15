import java.util.Scanner;

public class MajorityGate {

    // 实现摩尔门逻辑
    public static int majorityGate() {
        // 创建 Scanner 对象以接收用户输入
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入 a, b 和 c 的值
        System.out.print("Enter value for a (0 or 1): ");
        int a = scanner.nextInt();

        System.out.print("Enter value for b (0 or 1): ");
        int b = scanner.nextInt();

        System.out.print("Enter value for c (0 or 1): ");
        int c = scanner.nextInt();

        // 计算 a, b, c 中为 1 的数量
        int sum = a + b + c;

        // 如果为 1 的数量大于等于 2，输出 1；否则输出 0
        if (sum >= 2) {
            return 1;  // 输出 1
        } else {
            return 0;  // 输出 0
        }
    }

    public static void main(String[] args) {
        // 调用 majorityGate 方法，获取摩尔门的输出结果
        int result = majorityGate();

        // 输出最终结果
        System.out.println("Majority result: " + result);
    }
}