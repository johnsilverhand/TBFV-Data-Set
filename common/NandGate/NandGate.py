def nand_gate():
    # 获取用户输入的 x 和 y
    x = int(input("Enter the value for x (0 or 1): "))
    y = int(input("Enter the value for y (0 or 1): "))

    # 第一步：执行与运算（AND）
    and_result = x & y  # 按位与运算

    # 第二步：执行非运算（NOT），即对与运算的结果取反
    nand_result = 0 if and_result == 1 else 1  # 如果与运算结果是1，取反为0，否则取反为1

    # 输出中间步骤的结果
    print(f"Step 1 - AND Result: {and_result}")  # 打印与运算的中间结果
    print(f"Step 2 - NAND Result (NOT AND): {nand_result}")  # 打印最终的与非门结果

    # 返回最终结果
    return nand_result

def main():
    # 调用 nand_gate 函数，获取与非门结果并输出
    result = nand_gate()

    # 输出最终的与非门结果
    print(f"Final NAND result: {result}")

if __name__ == "__main__":
    main()