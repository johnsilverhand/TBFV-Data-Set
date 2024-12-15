import math

def is_prime(p):
    for i in range(2, int(math.sqrt(p)) + 1):
        if p % i == 0:
            return False
    return p > 1  # p must be greater than 1

def is_perfect_number(num):
    # Perfect numbers must be positive integers
    if num <= 1:
        return False

    # Check if num is even
    if num % 2 == 1:
        return False

    # Find p such that num = 2^(p-1) * (2^p - 1)
    for p in range(2, 32):  # p needs to be less than 32 to avoid overflow
        if is_prime(p) and (2 ** p - 1) % 2 == 1:
            perfect_candidate = (2 ** (p - 1)) * (2 ** p - 1)
            if perfect_candidate == num:
                return True

    return False

if __name__ == "__main__":
    num = 28
    if is_perfect_number(num):
        print(f"{num} 是完全数。")
    else:
        print(f"{num} 不是完全数。")