//有一个机械装置，随着使用时间的增加，装置的效率会下降。可以通过一个公式来模拟其磨损，并计算出需要多少时间才能达到设定的效率水平
import java.util.Scanner;

public class MechanicalWear {

    // 计算磨损后的效率公式 E(t) = E0 * (1 - t / T)
    public static double calculateEfficiency(double E0, double T, double t) {
        return E0 * (1 - t / T);
    }

    // 找到最小的时间 t，使得 E(t) < E_target
    public static double findWearTime(double E0, double T, double E_target) {
        if (E0 <= 0 || T <= 0 || E_target <= 0) {
            throw new IllegalArgumentException("Initial efficiency, total life, and target efficiency must be positive.");
        }

        double t = 0;  // 时间从0开始
        double E_t = E0;  // 初始效率

        // 迭代计算直到 E(t) 小于目标值
        while (E_t >= E_target) {
            t += 0.1;  // 逐步增加时间
            E_t = calculateEfficiency(E0, T, t);
        }

        return t;  // 返回最小时间 t
    }

    public static void main(String[] args) {
        // 获取用户输入
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入初始效率 E0: ");
        double E0 = scanner.nextDouble();

        System.out.print("请输入设备总寿命 T: ");
        double T = scanner.nextDouble();

        System.out.print("请输入目标效率 E_target: ");
        double E_target = scanner.nextDouble();

        // 找到最小时间 t
        double time = findWearTime(E0, T, E_target);

        // 输出结果
        System.out.println("设备的效率将小于 " + E_target + " 在时间 t = " + time + " 时发生。");
    }
}
