import java.util.Scanner;

public class SandFilling {

    // 计算需要多少个容器来装S立方米沙子，并直接返回容器数量
    public static int calculateContainers() {
        Scanner scanner = new Scanner(System.in);

        // 获取沙子的体积S
        System.out.print("请输入沙子的体积（立方米）：");
        int S = scanner.nextInt();

        int n = 0;  // 记录使用的容器数
        int currentVolume = 1;  // 从1立方米的容器开始

        // 使用容器逐步装沙子
        while (S > 0) {
            int containerVolume = currentVolume * currentVolume * currentVolume; // 容器体积

            // 如果当前容器能够装下沙子
            if (S >= containerVolume) {
                S -= containerVolume;  // 使用一个容器并减少沙子的体积
                n++;  // 增加容器数
            }

            // 每种容器只能使用一次，增加边长
            currentVolume++;
        }

        scanner.close(); // 关闭扫描器

        // 返回容器数量n
        return n;  // 直接返回容器数量
    }
}
