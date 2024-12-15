java 代码
import java.util.Scanner;

public class LogicGates {

    // 与非门（NAND gate），此时输入x和y是在函数内部获取的
    public static int nandGate() {
        // 创建 Scanner 对象以接收用户输入
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入x和y的值
        System.out.print("Enter the value for x (0 or 1): ");
        int x = scanner.nextInt(); // 获取用户输入的x值

        System.out.print("Enter the value for y (0 or 1): ");
        int y = scanner.nextInt(); // 获取用户输入的y值

        // 第一步：执行与运算（AND）
        int andResult = x & y; // 这里使用按位与运算符&，得到与门结果

        // 第二步：执行非运算（NOT），即对与运算的结果取反
        int nandResult = andResult == 1 ? 0 : 1; // 如果与运算结果是1，则取反为0，反之取反为1

        // 输出中间步骤的结果
        System.out.println("Step 1 - AND Result: " + andResult); // 打印与运算的中间结果
        System.out.println("Step 2 - NAND Result (NOT AND): " + nandResult); // 打印最终的与非门结果

        // 返回最终结果
        return nandResult;
    }
    public static void main(String[] args) {
        // 调用 nandGate 方法，获取与非门结果并输出
        int result = nandGate();

        // 输出最终的与非门结果
        System.out.println("Final NAND result: " + result);
    }
}