def irr_bisection(C0, C1, epsilon):
    # 检查输入合法性
    if epsilon <= 0 or C1 <= 0 or C0 >= 0:
        return -1  # 输入非法

    # 定义目标函数 f(r) = C0 + C1/(1+r)
    def f(r):
        return C0 + C1 / (1 + r)

    # 初始区间：r>=0假设从0开始搜索到较大值
    # 如果C0<0，C1>0，一般IRR会大于0
    low, high = 0.0, 1.0
    # 扩展搜索范围,直到f(high)*f(low)<0
    while f(low)*f(high) > 0:
        high *= 2
        if high > 1e10:  # 安全检查，防止无限扩大
            return -1

    # 二分法求解
    while f((low+high)/2) > epsilon:
        mid = (low + high)/2
        if f(mid) == 0:
            return mid
        elif f(mid)*f(low)<0:
            high = mid
        else:
            low = mid

    return (low+high)/2

# 示例调用
if __name__ == "__main__":
    C0 = float(input("请输入初始流出C0(负数): "))
    C1 = float(input("请输入一年后流入C1(正数): "))
    epsilon = float(input("请输入精度epsilon: "))
    result = irr_bisection(C0, C1, epsilon)
    if result == -1:
        print("输入非法或无法找到解")
    else:
        print("近似内部收益率:", result)
