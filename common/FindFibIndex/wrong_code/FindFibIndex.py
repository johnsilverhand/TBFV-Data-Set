def find_fibonacci_index(x):
    if x < 0:
        return "none"  # 输入非法
    elif x == 0:
        return 0  # 输入为 0
    else:
        a, b = 0, 1  # 初始斐波那契数列
        n = 2# wrong code
        while b < x:
            a, b = b, a + b  # 更新斐波那契数
            n += 1
        return n  # 返回满足条件的最小索引

# 示例调用
if __name__ == "__main__":
    x = int(input("请输入一个数 x: "))
    result = find_fibonacci_index(x)
    print("Result:", result)
