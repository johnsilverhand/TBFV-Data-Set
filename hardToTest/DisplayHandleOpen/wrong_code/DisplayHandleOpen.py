class DisplayFunctionTable:
    def __init__(self, get_type_fn, open_fn):
        self.getTypeFxn = get_type_fn  # 获取类型的函数
        self.openFxn = open_fn  # 打开驱动的函数

class DisplayConfig:
    def __init__(self, fxn_table):
        self.fxnTablePtr = fxn_table

class DisplayParams:
    pass

# 模拟全局数据
Display_defaultParams = DisplayParams()

# 模拟配置数组
def get_type_fn():
    return 1  # 示例类型，假设类型为 1

def open_fn(handle, params):
    if params:  # 模拟成功打开的条件
        return handle
    return None

# 初始化配置数组
Display_config = [
    DisplayConfig(DisplayFunctionTable(get_type_fn, open_fn)),
    DisplayConfig(DisplayFunctionTable(get_type_fn, open_fn)),
    DisplayConfig(None),  # 空的表示结束
]

def Display_doOpen(id, params):
    global Display_config
    # 如果参数为空，使用默认参数
    if params is None:
        params = Display_defaultParams

    # 遍历配置数组
    for i, config in enumerate(Display_config):
        if config.fxnTablePtr is None:
            break

        handle = config

        # 判断是否匹配 id 或类型
        if id == i or (config.fxnTablePtr.getTypeFxn() ):#wrong code
            if config.fxnTablePtr.openFxn(handle, params) is None:
                continue  # 尝试下一个
            else:
                return handle  # 成功打开返回

    # 未能打开任何驱动
    return None

# 示例调用
if __name__ == "__main__":
    params = DisplayParams()
    result = Display_doOpen(0, params)
    if result:
        print("Successfully opened:", result)
    else:
        print("Failed to open.")

'''
Display_Handle Display_doOpen(uint32_t id, Display_Params *params)
{
    Display_Handle handle;
    if (params == NULL)
    {
        params = (Display_Params *)&Display_defaultParams;
    }

    /* Call each driver's open function */
    uint32_t i;
    for (i = 0; Display_config[i].fxnTablePtr != NULL; i++)
    {
        handle = (Display_Handle) & Display_config[i];

        /* Open if id matches, or if meta-type matches */
        if (id == i || (handle->fxnTablePtr->getTypeFxn() & id))
        {
            if (NULL == handle->fxnTablePtr->openFxn(handle, params))
            {
                // Couldn't open. Continue trying to open in case a type was
                // provided and there's more than one of the type.
                continue;
            }
            else
            {
                // Return first matching
                return handle;
            }
        }
    }
    // Couldn't open.

    return NULL;
}
'''