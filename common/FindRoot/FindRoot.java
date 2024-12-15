import java.util.Scanner;

public class FindRoot {
    //只对findRoot方法进行测试
    public static Object findRoot(String userInput) {
        String[] inputs = userInput.split(" ");
        double a = Double.parseDouble(inputs[0]);
        double b = Double.parseDouble(inputs[1]);
        double c = Double.parseDouble(inputs[2]);

        if (a == 0) {
            return -1; // Error: 非法输入，a 不能为 0
        }

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[]{root1, root2}; // 返回两个不同的实数根
        } else if (discriminant == 0) {
            double root1 = -b / (2 * a);
            return root1; // 返回一个相同的实数根
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            return new double[]{realPart, imaginaryPart}; // 返回复数根的实部和虚部
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入系数 a, b 和 c : ");
        String userInput = scanner.nextLine();

        Object result = findRoot(userInput);

        if (result instanceof Integer && (Integer) result == -1) {
            System.out.println("Error: 系数 a 不能为 0");
        } else if (result instanceof double[]) {
            double[] roots = (double[]) result;
            if (roots.length == 2 && roots[1] == 0.0) {
                System.out.printf("根是: %.2f 和 %.2f\n", roots[0], roots[1]);
            } else {
                System.out.printf("根是: %.2f + %.2fi 和 %.2f - %.2fi\n", roots[0], roots[1], roots[0], roots[1]);
            }
        } else if (result instanceof Double) {
            System.out.printf("根是: %.2f\n", (Double) result);
        }
    }
}
