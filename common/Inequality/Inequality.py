def find_max_x():
    # 输入 y 的值
    y = float(input("请输入 y 的值: "))

    x = 0
    n = 0  # 用 n 来表示最大满足条件的 x-1

    # 使用无限循环
    while True:
        # 判断是否满足条件
        if 2**x + 3**x >= y:
            break  # 如果不满足条件，跳出循环
        n = x  # 如果满足条件，则更新 n 为 x
        x += 1  # 增加 x

    # 输出满足条件的最大 x
    print(f"最大 x 的值是: {n}")

# 调用函数
find_max_x()
