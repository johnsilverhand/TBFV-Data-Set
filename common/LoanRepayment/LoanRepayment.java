//根据贷款金额、利率和还款周期，计算满足某个目标偿还金额时所需的时间。
import java.util.Scanner;

public class LoanRepayment {

    // 计算贷款余额 P(t) = P0 * (1 + r)^t
    public static double calculateLoanBalance(double P0, double r, double t) {
        return P0 * Math.pow((1 + r), t);
    }

    // 找到最小的时间 t，使得 P(t) < P_target
    public static double findRepaymentTime(double P0, double r, double P_target) {
        if (P0 <= 0 || r <= 0 || P_target <= 0) {
            throw new IllegalArgumentException("Initial loan amount, interest rate, and target balance must be positive.");
        }

        double t = 0;  // 时间从0开始
        double P_t = P0;  // 初始贷款余额

        // 迭代计算直到 P(t) 小于目标值
        while (P_t >= P_target) {
            t += 1;  // 逐步增加时间
            P_t = calculateLoanBalance(P0, r, t);
        }

        return t;  // 返回最小时间 t
    }

    public static void main(String[] args) {
        // 获取用户输入
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入初始贷款金额 P0: ");
        double P0 = scanner.nextDouble();

        System.out.print("请输入月利率 r (例如 0.01 表示 1%): ");
        double r = scanner.nextDouble();

        System.out.print("请输入目标余额 P_target: ");
        double P_target = scanner.nextDouble();

        // 找到最小时间 t
        double time = findRepaymentTime(P0, r, P_target);

        // 输出结果
        System.out.println("贷款余额将小于 " + P_target + " 在时间 t = " + time + " 月时发生。");
    }
}
