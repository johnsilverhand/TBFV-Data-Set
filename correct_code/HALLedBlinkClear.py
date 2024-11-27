# 模拟全局变量
LED_INDEX_0 = 0
LED_INDEX_2 = 2
HAL_LED_BLINK = 0b01  # 假设 BLINK 模式对应位掩码
NBEK_Led = [{"led_mode": 0} for _ in range(3)]  # 初始化三个 LED 模式
highPriority = LED_INDEX_0  # 当前最高优先级

def HAL_LedBlinkClear(ledStatus):
    global highPriority, NBEK_Led

    # 状态指示值超出范围，直接返回
    if ledStatus > LED_INDEX_2:
        print(f"Error: ledStatus {ledStatus} 超出范围")
        return

    # 清除当前 LED 的模式
    NBEK_Led[ledStatus]["led_mode"] = 0
    high = LED_INDEX_0

    # 如果当前优先级为清除的 LED
    if highPriority == ledStatus:
        for i in range(LED_INDEX_2 + 1):
            # 检查是否有 BLINK 模式的 LED
            if (NBEK_Led[i]["led_mode"] & HAL_LED_BLINK) > 0:
                if i > high:
                    high = i
                    break
        highPriority = high  # 更新最高优先级

    print(f"当前优先级: {highPriority}, LED 状态: {NBEK_Led}")

# 示例调用
if __name__ == "__main__":
    # 初始化示例状态
    NBEK_Led[1]["led_mode"] = HAL_LED_BLINK
    NBEK_Led[2]["led_mode"] = HAL_LED_BLINK

    print("初始状态:", NBEK_Led)
    HAL_LedBlinkClear(1)
    HAL_LedBlinkClear(2)
    HAL_LedBlinkClear(3)  # 超出范围测试

'''
static void HAL_LedBlinkClear(uint8_t ledStatus)
{
  uint8_t high;
  
  if(ledStatus > LED_INDEX_2 )
  {
      //表示状态指示值超出设定的范围
      return ;
  }
  
  NBEK_Led[ledStatus].led_mode = 0;
  high = LED_INDEX_0;
  
  if(highPriority == ledStatus)
  {
    for(uint8_t i = 0 ; i <= LED_INDEX_2 ; i++)
    {
      if((NBEK_Led[i].led_mode & HAL_LED_BLINK) > 0)
      {
        if(i > high)
        {
          high = i;
          break;
        }
      }
    }
    highPriority = high;
  }
}
'''