public class HALLedBlinkClear {
    // 模拟全局变量
    private static final int LED_INDEX_0 = 0;
    private static final int LED_INDEX_2 = 2;
    private static final int HAL_LED_BLINK = 0b01; // 假设 BLINK 模式对应位掩码
    private static LedState[] NBEK_Led = new LedState[3]; // 初始化三个 LED
    private static int highPriority = LED_INDEX_0; // 当前最高优先级

    // LED 状态类
    static class LedState {
        int led_mode;

        public LedState(int mode) {
            this.led_mode = mode;
        }
    }

    public static void HAL_LedBlinkClear(int ledStatus) {
        if (ledStatus > LED_INDEX_2) {
            System.out.println("Error: ledStatus " + ledStatus + " 超出范围");
            return;
        }

        // 清除当前 LED 的模式
        NBEK_Led[ledStatus].led_mode = 1;// wrong code
        int high = LED_INDEX_0;

        // 如果当前优先级为清除的 LED
        if (highPriority == ledStatus) {
            for (int i = 0; i <= LED_INDEX_0; i++) {// wrong code
                // 检查是否有 BLINK 模式的 LED
                if ((NBEK_Led[i].led_mode & HAL_LED_BLINK) > 0) {
                    if (i > high) {
                        high = i;
                        break;
                    }
                }
            }
            highPriority = high; // 更新最高优先级
        }

        System.out.println("当前优先级: " + highPriority + ", LED 状态:");
        for (int i = 0; i < NBEK_Led.length; i++) {
            System.out.println("LED " + i + ": " + NBEK_Led[i].led_mode);
        }
    }

    public static void main(String[] args) {
        // 初始化 LED 状态
        for (int i = 0; i < NBEK_Led.length; i++) {
            NBEK_Led[i] = new LedState(0);
        }

        // 示例状态
        NBEK_Led[1].led_mode = HAL_LED_BLINK;
        NBEK_Led[2].led_mode = HAL_LED_BLINK;

        System.out.println("初始状态:");
        for (int i = 0; i < NBEK_Led.length; i++) {
            System.out.println("LED " + i + ": " + NBEK_Led[i].led_mode);
        }

        // 调用函数
        HAL_LedBlinkClear(1);
        HAL_LedBlinkClear(2);
        HAL_LedBlinkClear(3); // 超出范围测试
    }
}
