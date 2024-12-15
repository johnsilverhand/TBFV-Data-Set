import pandas as pd
import re
def value(cell_value):
        # 返回值修改成了如果是单独的整数型就返回整数型，否则返回字符串
        # 比如： 字段是 2007 就直接返回 int 型，字段是 1011;1012;1013 就还是返回原类型
        if cell_value is not None and cell_value != "" and cell_value != " ":
            try:
                cell_value = str(cell_value)
                number_pattern = r'^\d+(\.\d+)?$'#correct: number_pattern = r'^-?\d+(\.\d+)?$'
                if re.match(number_pattern, cell_value):
                    # 检查是否可以转换为浮点数
                    float_value = float(cell_value)
                    int_value = int(float_value)
                    # 检查小数部分是否为零
                    if float_value - int_value == 0:
                        return int_value,type(int_value)
                    else:
                        #wrong
                        return float_value,type(cell_value) #correct: return cell_value,type(cell_value)
                else:
                    return cell_value,type(cell_value)
            except ValueError:
                return cell_value,type(cell_value)
        else:
            return None,type(cell_value)

if __name__ == "__main__":
    print(value(input("请输入一个值：")))
    #print(value())