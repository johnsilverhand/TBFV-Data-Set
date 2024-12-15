import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValueCheck {

    // 定义正则表达式
    private static final String NUMBER_PATTERN = "^-?\\d+(\\.\\d+)?$";

    // 实现 value 方法
    public static Object[] value(String cellValue) {
        // 如果 cellValue 为 null 或为空白
        if (cellValue == null || cellValue.trim().isEmpty()) {
            return new Object[]{null, String.class};
        }

        try {
            // 转为字符串处理
            cellValue = cellValue.trim();
            Pattern pattern = Pattern.compile(NUMBER_PATTERN);
            Matcher matcher = pattern.matcher(cellValue);

            if (matcher.matches()) {
                // 如果是数字，尝试解析为浮点数和整数
                double floatValue = Double.parseDouble(cellValue);
                int intValue = (int) floatValue;

                // 检查小数部分是否为零
                if (floatValue - intValue == 0) {
                    return new Object[]{intValue, Integer.class};
                } else {
                    return new Object[]{cellValue, String.class};
                }
            } else {
                // 非数字，返回字符串
                return new Object[]{cellValue, String.class};
            }
        } catch (NumberFormatException e) {
            // 异常时，返回原值和字符串类型
            return new Object[]{cellValue, String.class};
        }
    }

    // 主方法，用于测试 value 函数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入一个值：");
        String input = scanner.nextLine();

        Object[] result = value(input);
        System.out.println("返回值: " + result[0]);
        System.out.println("返回类型: " + ((Class<?>) result[1]).getName());

        scanner.close();
    }
}
