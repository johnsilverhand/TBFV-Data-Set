public class IsPrime {
    public static int isPrime(int n) {
        if (n < 2 || (n != 2 && n % 2 == 0)) {
            return 0;  // 如果 n 小于 2 或 n 是不等于 2 的偶数，则 n 不是素数
        } else {
            int m = n / 2;  // 范围优化为 n/2
            for (int i = 3; i < m; i += 2) {  // 从 3 开始，步长为 2，只检查奇数
                if (n % i == 0) {
                    return 0;
                }
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        // 示例测试
        System.out.println(isPrime(1));  // 输出：0
        System.out.println(isPrime(2));  // 输出：1
        System.out.println(isPrime(15)); // 输出：0
        System.out.println(isPrime(17)); // 输出：1
    }
}
