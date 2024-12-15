def find_min_square(x):
    if x < 0:
        return "none"  # 输入非法
    elif x == 0:
        return 0  # 输入为 0
    else:
        n = 1
        while n * n < x:
            n += 1  # 增加 n
        return n-1  # 返回满足条件的最小整数 wrong code

# 示例调用
if __name__ == "__main__":
    x = int(input("请输入一个数 x: "))
    result = find_min_square(x)
    print("Result:", result)
