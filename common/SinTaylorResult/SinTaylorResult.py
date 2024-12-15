import math

def sin_taylor(x, precision):
    if precision <= 0:
        return "none"  # 非法输入
    
    n = 0
    term = x  # 泰勒展开的第 0 项
    result = term  # 累加结果

    while abs(term) >= precision:
        n += 1
        term *= -x**2 / ((2 * n) * (2 * n + 1))  # 计算第 n 项
        result += term

    return result  # 返回满足精度条件的最小 n

# 示例调用
if __name__ == "__main__":
    x = float(input("请输入 x (弧度): "))
    precision = float(input("请输入精度: "))
    result = sin_taylor(x, precision)
    print(result)
