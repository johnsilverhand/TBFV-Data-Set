# 计算给定区间 [a, b] 内的目标函数值 f(x)
def func(x):
    # 假设我们要求解的是 f(x) = (x-2)^2，目标是找到最小值
    return (x - 2) ** 2

# 计算费波那契数列
def fibonacci(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fibonacci(n - 1) + fibonacci(n - 2)

# 费波那契迭代法进行数值优化
def fibonacci_search(a, b, n):
    k = 0
    # 计算最小的 Fibonacci 数，使得它大于或等于区间长度 (b - a)
    while fibonacci(k) < (b - a) / 0.0001:
        k += 1

    # 计算两个新的分割点
    x1 = a + (fibonacci(k - 2) / fibonacci(k)) * (b - a)
    x2 = a + (fibonacci(k - 1) / fibonacci(k)) * (b - a)

    # 迭代过程
    while k > 1:
        if func(x1) < func(x2):
            # 如果 x1 的函数值更小，则向右缩小区间
            b = x2
        else:
            # 否则，向左缩小区间
            a = x1
        k -= 1
        # 更新分割点
        x1 = a + (fibonacci(k - 2) / fibonacci(k)) * (b - a)
        x2 = a + (fibonacci(k - 1) / fibonacci(k)) * (b - a)

    # 返回区间的中点作为最优解
    return (a + b) / 2

# 主程序
if __name__ == "__main__":
    # 设置区间 [a, b] 和最大迭代次数（以确定 Fibbonacci 数列的长度）
    a = 0  # 区间左端
    b = 5  # 区间右端
    n = 20  # 选择一个较大的 Fibonacci 数列长度

    # 使用费波那契迭代法求解最优解
    result = fibonacci_search(a, b, n)

    # 输出结果
    print(f"最小值发生在 x = {result}")
    print(f"函数值为 f(x) = {func(result)}")
