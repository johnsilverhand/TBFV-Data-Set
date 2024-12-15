import math

def prime_check(num):
    # 判断 num 是否为素数
    if num <= 1:
        print("No")  # 1 或负数不是素数
    else:
        is_prime = True
        for i in range(2, int(math.sqrt(num)) + 1):
            if num % i == 0:
                is_prime = False
                break
        if is_prime:
            print("Yes")
        else:
            print("No")

# 获取输入的正整数
num = int(input())

prime_check(num)
