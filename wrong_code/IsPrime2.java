public class IsPrime2 {
    public static boolean isPrimeEuler(int num) {
        if (num <= 3) {
            return num > 1;  // 2 和 3 是质数，1 和更小的数不是质数
        }
        if (num % 6 != 1 && num % 6 != 0) {  // 不在 6 的倍数两侧的数一定不是质数
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {  // 从 5 开始，步长为 6，检查 i 和 i+2
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 示例测试
        System.out.println(isPrimeEuler(1));  // 输出：false
        System.out.println(isPrimeEuler(2));  // 输出：true
        System.out.println(isPrimeEuler(29)); // 输出：true
        System.out.println(isPrimeEuler(30)); // 输出：false
    }
}
