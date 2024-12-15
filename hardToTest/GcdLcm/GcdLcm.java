public class GcdLcm {
    public static void gcdLcm(int a, int b) {
        if (a <= 0 || b <= 0) {
            System.out.println("GCD: null, LCM: null");
            return;
        }

        int x = a, y = b;
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        int gcd = x;
        int lcm = (a * b) / gcd;

        System.out.println("GCD: " + gcd + ", LCM: " + lcm);
    }

    public static void main(String[] args) {
        int a = 15, b = 20;
        gcdLcm(a, b);
    }
}