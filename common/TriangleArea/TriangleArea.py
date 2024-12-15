def function(x):
    # 计算函数 y = x^3 + x^2 + x + 1 的值
    return x ** 3 + x ** 2 + x + 1

def calculate_area(a):
    # 计算三角形的面积
    yA = function(a)
    return 0.5 * yA * a  # 面积 S_{ABC} = 0.5 * f(a) * a

def find_closest_triangle(S):
    # 如果面积小于 0，返回 0
    if S < 0:
        return 0
    elif S < 2:
        return 1  # 面积小于 2 时返回 1

    a = 1

    while True:
        area_a = calculate_area(a)
        area_b = calculate_area(a + 1)
        diff_a = abs(area_a - S)
        diff_b = abs(area_b - S)
        
        # 输出当前 a 的面积和与目标面积的差值
        print(f"a = {a}: 面积 = {area_a:.2f}, 与目标面积的差 = {diff_a:.2f}")
        print(f"a = {a + 1}: 面积 = {area_b:.2f}, 与目标面积的差 = {diff_b:.2f}")

        if area_a <= S < area_b:
            if diff_a > diff_b:
                a += 1  # 如果 area_b 更接近目标面积，则增加 a
            break
    
    return a

if __name__ == "__main__":
    S = 2  # 你可以修改这个值来测试不同的输入
    result = find_closest_triangle(S)
    print(f"最接近面积 {S} 的三角形的结果: {result}")