
#根据接收到的光照传感器值，控制LED灯的亮灭
'''
if(ad_readFlag)
    {
      uint16_t ad_value = HAL_ADC_Read();
      //0-4096对应0-3.3V
			printf("Adc_value = %.2f\r\n",ad_value*3.3/4095);
			double Switch=ad_value*3.3/4095;
			if(Switch>=2.57 && !mode)
			{
				HAL_GPIO_WritePin(GPIOA, LED_Pin, GPIO_PIN_SET);
			}
			else if ( Switch < 2.57 && !mode)
			{
				HAL_GPIO_WritePin(GPIOA, LED_Pin, GPIO_PIN_RESET);
      }
      //HAL_LED_Blink(200,10,1);
    }
'''
def SetLedByLight(ad_readFlag,ad_value,mode):
    if(ad_readFlag):
        #0-4096对应0-3.3V
        print("Adc_value = %.2f" % (ad_value*3.3/4095))
        Switch=ad_value*3.3/4095
        if(Switch>=2.57 and not mode):
            return True
        elif ( Switch < 2.57 and not mode):
            return False
    return None
if __name__ == "__main__":
    ad_readFlag = bool(input("请输入ad_readFlag："))
    ad_value = int(input("请输入ad_value："))
    mode = bool(input("请输入mode："))
    SetLedByLight(ad_readFlag,ad_value,mode)