def calculate_binary_length(n):
    # 如果 n 小于等于 0，则返回 -1
    if n <= 0:
        return -1

    # 初始化幂次变量 k
    k = 0
    power_of_two = 1  # 从 2^0 开始

    # 迭代直到 2^k 大于 n
    while power_of_two <= n:
        k += 1
        power_of_two = 2 ** k

    return k

# 输入一个正整数 n
n = int(input("请输入一个正整数 n："))

# 调用函数并输出结果
s = calculate_binary_length(n)
print("s =", s)
