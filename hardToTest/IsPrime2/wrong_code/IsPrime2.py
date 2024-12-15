import math

def is_prime_euler(num):
    if num <= 3:
        return num > 1  # 2 和 3 是质数，1 和更小的数不是质数
    if num % 6 != 1 and num % 6 != 0:  # 不在 6 的倍数两侧的数一定不是质数，wrong:num % 6 != 0
        return False
    sqrt = int(math.sqrt(num))
    for i in range(5, sqrt + 1, 6):  # 从 5 开始，步长为 6，检查 i 和 i+2
        if num % i == 0 or num % (i + 2) == 0:
            return False
    return True

# 示例测试
if __name__ == "__main__":
    print(is_prime_euler(int(input('输入一个数'))))  # 输出：0
