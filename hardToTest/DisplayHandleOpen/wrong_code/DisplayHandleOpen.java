public class DisplayHandleOpen {
    // 模拟 DisplayFunctionTable
    interface GetTypeFunction {
        int getType();
    }

    interface OpenFunction {
        boolean open(DisplayConfig handle, DisplayParams params);
    }

    static class DisplayFunctionTable {
        GetTypeFunction getTypeFxn;
        OpenFunction openFxn;

        public DisplayFunctionTable(GetTypeFunction getTypeFxn, OpenFunction openFxn) {
            this.getTypeFxn = getTypeFxn;
            this.openFxn = openFxn;
        }
    }

    // 模拟 DisplayConfig
    static class DisplayConfig {
        DisplayFunctionTable fxnTablePtr;

        public DisplayConfig(DisplayFunctionTable fxnTablePtr) {
            this.fxnTablePtr = fxnTablePtr;
        }
    }

    // 模拟 DisplayParams
    static class DisplayParams {}

    // 默认参数
    static DisplayParams Display_defaultParams = new DisplayParams();

    // 配置数组
    static DisplayConfig[] Display_config = {
            new DisplayConfig(new DisplayFunctionTable(
                    () -> 1, // 示例类型
                    (handle, params) -> params != null // 模拟成功打开的条件
            )),
            new DisplayConfig(new DisplayFunctionTable(
                    () -> 1, // 示例类型
                    (handle, params) -> params != null // 模拟成功打开的条件
            )),
            null // 表示结束
    };

    public static DisplayConfig Display_doOpen(int id, DisplayParams params) {
        if (params == null) {
            params = Display_defaultParams;
        }

        // 遍历配置数组
        for (int i = 0; i < Display_config.length; i++) {
            DisplayConfig config = Display_config[i];
            if (config == null || config.fxnTablePtr == null) {
                break;
            }

            // 判断是否匹配 id 或类型
            if (id == i || (config.fxnTablePtr.getTypeFxn.getType() & id) != 0) {
                if (!config.fxnTablePtr.openFxn.open(config, params)) {
                    //continue; // 尝试下一个
                    break; // wrong code
                } else {
                    return config; // 成功打开返回
                }
            }
        }

        // 未能打开任何驱动
        return null;
    }

    public static void main(String[] args) {
        DisplayParams params = new DisplayParams();
        DisplayConfig result = Display_doOpen(0, params);
        if (result != null) {
            System.out.println("Successfully opened: " + result);
        } else {
            System.out.println("Failed to open.");
        }
    }
}
