public class PerfectNumber {

    public static boolean isPerfectNumber(int num) {
        // 完全数必须是正整数
        if (num <= 1) {
            return false;
        }

        // 判断num是否为偶数
        if (num % 2 == 1) {
            return false;
        }

        // 寻找p使得num = 2^(p-1) * (2^p - 1)
        for (int p = 2; p < 32; p++) { // p 的值需要小于32以避免溢出
            if (isPrime(p) && (Math.pow(2, p) - 1) % 2 == 1) {
                int perfectCandidate = (int) (Math.pow(2, p - 1) * (Math.pow(2, p) - 1));
                if (perfectCandidate == num) {
                    return true;
                }
            }
        }

        return false;
    }

    // 判断是否为素数
    private static boolean isPrime(int p) {
        for (int i = 2; i <= Math.sqrt(p); i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return p > 1; // p 必须大于1
    }

    public static void main(String[] args) {
        int num = 28;
        if (isPerfectNumber(num)) {
            System.out.println(num + " 是完全数。");
        } else {
            System.out.println(num + " 不是完全数。");
        }
    }
}