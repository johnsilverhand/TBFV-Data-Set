import math

def check_perfect_square(n):
    # 检查输入是否为正整数
    if n <= 0:
        return -1  # 输入无效，返回 -1

    # 牛顿迭代法计算平方根
    g = n / 2.0  # 初始猜测值
    epsilon = 1e-6  # 精度，用于判断收敛

    # 进行迭代直到结果足够精确
    while abs(g * g - n) > epsilon:
        g = (g + n / g) / 2.0

    # 判断g是否为整数并判断其平方是否等于n
    if g == int(g) and g * g == n:
        return int(g)  # 是完全平方数，返回整数g
    else:
        return 0  # 不是完全平方数

# 输入正整数 n
n = int(input("请输入一个正整数 n："))
result = check_perfect_square(n)

# 输出结果
print("g =", result)
