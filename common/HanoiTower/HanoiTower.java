import java.util.Scanner;

public class HanoiTower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入盘子数量 n 和最大步数 N
        System.out.print("请输入盘子数量 n: ");
        int n = scanner.nextInt();
        System.out.print("请输入最大步数 N: ");
        int N = scanner.nextInt();

        // 计算最少步骤数 s
        long s = 1;  // 递推公式的初始值，表示1个盘子的步骤数

        // 使用 while 循环，根据递推公式计算最少步骤数
        int i = 2;  // 变量 i 用于表示当前正在计算的盘子的数量，从2开始
        while (i <= n) {  // 当 i 小于等于 n 时，继续递推
            s = 2 * s + 1;  // 更新 s，表示根据递推公式计算出当前盘子的步骤数
            i++;  // 将 i 的值增加，继续计算下一个盘子数量
        }

        // 判断是否能在最大步数 N 内完成汉诺塔
        if (s <= N) {
            System.out.println("最少步骤数: " + s);
        } else {
            System.out.println("0");  // 如果无法在最大步数内完成汉诺塔，输出 0
        }

        scanner.close();
    }
}
