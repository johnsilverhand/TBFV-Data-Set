import java.util.Scanner;

public class DecayProcess {

    // 计算衰减过程的公式 A(t) = A0 * e^(-λt)
    public static double calculateDecay(double A0, double lambda, double t) {
        return A0 * Math.exp(-lambda * t);
    }

    // 找到最小的时间 t，使得 A(t) < A_target
    public static double findDecayTime(double A0, double lambda, double A_target) {
        if (A0 <= 0 || lambda <= 0 || A_target <= 0) {
            throw new IllegalArgumentException("Initial amount, decay rate, and target amount must be positive.");
        }

        double t = 0;  // 时间从0开始
        double A_t = A0;  // 初始的物质量

        // 迭代计算直到 A(t) 小于目标值
        while (A_t >= A_target) {
            t += 0.1;  // 逐步增加时间
            A_t = calculateDecay(A0, lambda, t);
        }

        return t;  // 返回最小时间 t
    }

    public static void main(String[] args) {
        // 获取用户输入
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入初始物质量 A0: ");
        double A0 = scanner.nextDouble();

        System.out.print("请输入衰减常数 λ: ");
        double lambda = scanner.nextDouble();

        System.out.print("请输入目标物质量 A_target: ");
        double A_target = scanner.nextDouble();

        // 找到最小时间 t
        double time = findDecayTime(A0, lambda, A_target);

        // 输出结果
        System.out.println("物质的量将小于 " + A_target + " 在时间 t = " + time + " 时发生。");
    }
}
