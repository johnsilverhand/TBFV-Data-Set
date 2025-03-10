def hanoi_steps():
    # 输入盘子数量 n 和最大步数 N
    n = int(input("请输入盘子数量 n: "))
    N = int(input("请输入最大步数 N: "))

    # 计算最少步骤数 s
    s = 1  # 初始步数，表示 1 个盘子时的步骤数

    # 使用 while 循环，根据递推公式计算最少步骤数
    i = 2  # 从 2 个盘子开始
    while i <= n:
        s = 2 * s + 1  # 更新 s，表示当前盘子数量时的步骤数
        i += 1  # 增加盘子数量

    # 判断是否能在最大步数 N 内完成汉诺塔
    if s <= N:
        print(f"最少步骤数: {s}")
    else:
        print("0")  # 如果无法在最大步数内完成汉诺塔，输出 0

# 调用函数
hanoi_steps()
