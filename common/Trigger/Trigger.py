def calculate_q(J, K):
    Q = 0  # 初始化 Q

    if J == 0 and K == 0:
        # J=0, K=0 -> Q 保持不变
        print(f"J=0, K=0 -> Q保持不变: {Q}")
    elif J == 0 and K == 1:
        # J=0, K=1 -> Q = 0
        Q = 0
        print("J=0, K=1 -> Q = 0")
    elif J == 1 and K == 0:
        # J=1, K=0 -> Q = 1
        Q = 1
        print("J=1, K=0 -> Q = 1")
    elif J == 1 and K == 1:
        # J=1, K=1 -> Q 反转
        Q = 1 - Q  # 如果 Q 是 0 则变为 1，反之亦然
        print(f"J=1, K=1 -> Q 反转: {Q}")

# 输入 J 和 K 的值
J = int(input("Enter value for J (0 or 1): "))
K = int(input("Enter value for K (0 or 1): "))

# 调用计算函数
calculate_q(J, K)