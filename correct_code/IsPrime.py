def is_prime(n):
    if n < 2 or (n != 2 and n % 2 == 0):  # 如果 n 小于 2 或 n 是不等于 2 的偶数，则 n 不是素数
        return 0
    else:
        m = n // 2  # 范围优化为 n/2
        for i in range(3, m, 2):  # 从 3 开始，步长为 2，只检查奇数
            if n % i == 0:
                return 0
        return 1

# 示例测试
if __name__ == "__main__":
    print(is_prime(int(input('输入一个数'))))  # 输出：0
    
