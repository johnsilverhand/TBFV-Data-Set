import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        // 获取输入的正整数
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        // 判断 num 是否为素数
        if (num <= 1) {
            System.out.println("No");  // 1 或负数不是素数
        } else {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
