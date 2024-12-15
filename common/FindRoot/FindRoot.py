import math

def find_root(user_input):  
    a, b, c = map(float, user_input.split())
    
    if a == 0:
        Error =  -1
        return Error
    discriminant = b ** 2 - 4 * a * c
    
    if discriminant > 0:
        root1 = (-b + math.sqrt(discriminant)) / (2 * a)
        root2 = (-b - math.sqrt(discriminant)) / (2 * a)
        return root1, root2
    elif discriminant == 0:
        root1 = -b / (2 * a)
        return root1
    else:
        realPart = -b / (2 * a)
        imaginaryPart = math.sqrt(-discriminant) / (2 * a)
        return realPart, imaginaryPart
    

# 示例调用
if __name__ == "__main__":
    print("请输入系数 a, b 和 c : ")
    user_input = input()  
    print(find_root(user_input))
