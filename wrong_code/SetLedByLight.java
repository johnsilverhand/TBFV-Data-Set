import java.util.Scanner;

public class SetLedByLight {
    
    // 控制 LED 的方法
    public static Boolean setLedByLight(boolean adReadFlag, int adValue, boolean mode) {
        if (adReadFlag) {
            // 0-4096对应0-3.3V，计算并输出电压值
            double switchValue = adValue * 3.3 / 4096;// 4095;
            System.out.printf("Adc_value = %.2f\n", switchValue);

            // 判断是否符合亮灯条件
            if (switchValue >= 2.57 && !mode) {
                return true;
            } else if (switchValue < 2.57 && !mode) {
                return false;
            }
        }
        return false; // 如果不满足条件，返回 null
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入
        System.out.print("请输入ad_readFlag (true/false)：");
        boolean adReadFlag = Boolean.parseBoolean(scanner.nextLine());

        System.out.print("请输入ad_value (0-4095)：");
        int adValue = Integer.parseInt(scanner.nextLine());

        System.out.print("请输入mode (true/false)：");
        boolean mode = Boolean.parseBoolean(scanner.nextLine());

        // 调用函数并输出结果
        Boolean result = setLedByLight(adReadFlag, adValue, mode);
        System.out.println("返回结果: " + result);

        scanner.close();
    }
}
