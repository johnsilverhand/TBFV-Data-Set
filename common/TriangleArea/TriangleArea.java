public class TriangleArea {

    // 计算函数 y = x^3 + x^2 + x + 1 的值
    private static double function(double x) {
        return Math.pow(x, 3) + Math.pow(x, 2) + x + 1;
    }

    // 计算三角形的面积
    private static double calculateArea(int a) {
        double yA = function(a);
        return 0.5 * yA * a; // 面积 S_{ABC} = 0.5 * f(a) *a
    }

    public static int findClosestTriangle(double S) {
        // 如果面积小于 0，返回 0
        if (S < 0) {
            return 0;
        }else if(S<2) return 1;

        int a;
        double closestArea = Double.MAX_VALUE;
        double minDiff = Double.MAX_VALUE;

        // 从 a = 1 开始查找
        for (a = 1; ; a++) {
            double area_a = calculateArea(a);
            double area_b = calculateArea(a+1);
            double diff_a = Math.abs(area_a - S);
            double diff_b = Math.abs(area_b - S);
            // 输出当前 a 的面积和与目标面积的差值
            System.out.printf("a = %d: 面积 = %.2f, 与目标面积的差 = %.2f%n", a, area_a, diff_a);
            System.out.printf("a = %d: 面积 = %.2f, 与目标面积的差 = %.2f%n", a+1, area_b, diff_b);
            if(area_a <= S && area_b > S){
                if(diff_a>diff_b){
                    a = a + 1;
                }
                break;
            }
        }

        return a;
    }

    public static void main(String[] args) {
        double S = 2; // 你可以修改这个值来测试不同的输入
        int result = findClosestTriangle(S);
        System.out.println("最接近面积 " + S + " 的三角形的结果: " + result);
    }
}