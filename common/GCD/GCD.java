public class GCDCalculator {
    public static void main(String[] args) {
        int a = 48; // 示例数值
        int b = 18;
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b));
    }

    public static int gcd(int a, int b) {
        // 确保输入非负
        a = Math.abs(a);
        b = Math.abs(b);

        // 使用欧几里得算法
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
