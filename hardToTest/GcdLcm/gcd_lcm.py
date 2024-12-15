def gcd_lcm(a, b):
    if a <= 0 or b <= 0:
        return None, None
    
    # 计算 GCD 和 LCM
    x, y = a, b
    while y:
        x, y = y, x % y
    gcd = x
    lcm = (a * b) // gcd
    return gcd, lcm

# 示例
a = 15
b = 20
gcd, lcm = gcd_lcm(a, b)
print(f"GCD: {gcd}, LCM: {lcm}")