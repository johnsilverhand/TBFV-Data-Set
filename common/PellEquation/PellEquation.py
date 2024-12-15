def find_max_pell_solution(N):
    # 基本解 (x1, y1)
    x, y = 3, 2
    X = 0  # 用于记录最大解的 x
    Y = 0  # 用于记录最大解的 y

    # 不断生成下一个解，直到 x > N
    while x <= N:
        X = x  # 更新最大 x
        Y = y  # 更新对应的 y

        # 递推生成下一个解
        next_x = 3 * x + 4 * y
        next_y = 2 * x + 3 * y

        x, y = next_x, next_y

    return X, Y

# 主程序
if __name__ == "__main__":
    try:
        N = int(input("请输入一个正整数 N："))
        if N <= 0:
            print("N 必须是正整数！")
        else:
            result_x, result_y = find_max_pell_solution(N)
            print(f"不超过 N 的最大整数解 x 为：{result_x}")
            print(f"对应的 y 值为：{result_y}")
    except ValueError:
        print("请输入一个有效的正整数！")
