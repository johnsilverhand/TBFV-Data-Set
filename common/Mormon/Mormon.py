def majority_gate():
    # 提示用户输入 a, b 和 c 的值
    a = int(input("Enter value for a (0 or 1): "))
    b = int(input("Enter value for b (0 or 1): "))
    c = int(input("Enter value for c (0 or 1): "))

    # 计算 a, b, c 中为 1 的数量
    sum_ones = a + b + c

    # 如果为 1 的数量大于等于 2，输出 1；否则输出 0
    if sum_ones >= 2:
        return 1
    else:
        return 0

# 调用 majority_gate 方法，获取摩尔门的输出结果
result = majority_gate()

# 输出最终结果
print("Majority result:", result)