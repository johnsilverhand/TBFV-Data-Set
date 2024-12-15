import java.util.Scanner;

public class JKFlipFlop {

    // 计算并输出 Q 的值
    public static void calculateQ(int J, int K) {
        int Q = 0; // 初始化 Q

        if (J == 0 && K == 0) {
            // J=0, K=0 -> Q 保持不变
            System.out.println("J=0, K=0 -> Q保持不变: " + Q);
        } else if (J == 0 && K == 1) {
            // J=0, K=1 -> Q = 0
            Q = 0;
            System.out.println("J=0, K=1 -> Q = 0");
        } else if (J == 1 && K == 0) {
            // J=1, K=0 -> Q = 1
            Q = 1;
            System.out.println("J=1, K=0 -> Q = 1");
        } else if (J == 1 && K == 1) {
            // J=1, K=1 -> Q 反转
            Q = 1 - Q; // 如果 Q 是 0 则变为 1，反之亦然
            System.out.println("J=1, K=1 -> Q 反转: " + Q);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入 J 和 K 的值
        System.out.print("Enter value for J (0 or 1): ");
        int J = scanner.nextInt();
        System.out.print("Enter value for K (0 or 1): ");
        int K = scanner.nextInt();

        // 调用计算函数
        calculateQ(J, K);
    }
}