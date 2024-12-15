import math

def solve_quadratic(a, b, c):
    discriminant = b ** 2 - 4 * a * c

    if discriminant > 0:
        root1 = (-b + math.sqrt(discriminant)) / (2 * a)
        root2 = (-b - math.sqrt(discriminant)) / (2 * a)
        return (root1, root2)
    elif discriminant == 0:
        root = -b / (2 * a)
        return (root,)
    else:
        return "两个虚根"

a = float(input("请输入 a, b, c 的值: "))
b = float(input())
c = float(input())

result = solve_quadratic(a, b, c)

if isinstance(result, tuple):
    if len(result) == 2:
        print(f"两个实数根: {result[0]}, {result[1]}")
    else:
        print(f"一个实数根: {result[0]}")
else:
    print(result)