def find_min_n(n,x):
    if 3**n >= x and 3**(n-1) < x:
        return n
    else:
        return find_min_n(n + 1, x)
def FindMinPowOfThree(x):
    if x < 0:
        Error = -1
        return Error
    elif x == 0:
        return 0
    else:
        return find_min_n(0,x)
    
if __name__ == "__main__":
    x = int(input("请输入一个数 x: "))
    result = FindMinPowOfThree(x)
    if result == -1:
        print("输入非法")
    else:
        print("Result:", result)
