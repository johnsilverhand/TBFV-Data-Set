def find_integer_root():
    n = int(input("请输入一个整数 n："))
    k = int(input("请输入一个正整数 k："))

    # 判断非法输入
    if n <= 0 or k <= 0:
        g = -1  # n 或 k 非正，直接输出 g = -1
        print(f"g = {g}")
        return

    guess = 1  # 初始猜测值

    # 牛顿迭代计算
    while guess**k < n:
        power = guess**(k - 1)  # 计算 guess^(k-1)
        fraction = n // power  # 整数除法替代 n / guess^(k-1)
        guess = (guess + fraction) // 2  # 更新猜测值

    # 判断结果
    if guess**k == n:
        g = guess  # 存在整数根
    elif guess**k > n:
        g = 0  # 不存在整数根

    print(f"g = {g}")


# 调用函数
find_integer_root()
