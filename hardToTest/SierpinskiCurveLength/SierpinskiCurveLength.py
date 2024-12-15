def calculate_iterations(L_0, L_target):
    # T1: 检查输入条件是否有效
    if L_0 <= 0 or L_target <= 0 or L_0 > L_target:
        return 0  # D1: 如果输入不合法，返回最小递归次数0

    n = 0  # 初始化递归次数
    current_length = 4 * L_0  # 初始的线段长度

    # T2: 当当前线段长度小于目标长度时，继续迭代
    while current_length < L_target:
        n += 1  # 增加递归深度
        current_length = 4 * (3 ** n) * L_0  # 计算当前递归深度的线段长度
        # D2: 递归结束时，current_length >= L_target，满足目标条件

    return n  # 返回递归次数

def main():
    L_0 = 1.0  # 初始正方形的边长
    L_target = 1000.0  # 目标线段长度

    # 计算所需的递归次数
    iterations = calculate_iterations(L_0, L_target)

    # 输出最小递归次数
    print(f"最小递归次数，直到线段长度达到或超过 {L_target} 是: {iterations}")

if __name__ == "__main__":
    main()
