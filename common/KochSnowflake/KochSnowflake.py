def koch_snowflake():
    # 手动输入初始边长L和目标边长N
    l = float(input("请输入初始等边三角形的边长 L："))
    L = float(input("请输入目标边长 N："))

    n = 0
    current_length = l

    # 循环计算每次迭代后的边长，直到达到或超过N
    while current_length < L:
        current_length *= 4.0 / 3.0  # 边长增长4/3倍
        n += 1  # 迭代次数加1

    return n

# 调用函数并输出结果
print("至少需要", koch_snowflake(), "次迭代才能使科赫雪花的边长不小于目标值N")
