def gcd(a, b):
    a = abs(a)
    b = abs(b)
    while b != 0:
        a, b = b, a % b
    return a
a = 48
b = 18
print(f"GCD of {a} and {b} is: {gcd(a, b)}")
