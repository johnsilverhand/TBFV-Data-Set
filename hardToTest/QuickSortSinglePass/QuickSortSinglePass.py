class Result:
    def __init__(self, size):
        self.flag = 1  # 标志
        self.arr = [0] * size  # 排序后的数组

def quick_sort_single_pass(arr, low, high, pivot):
    result = Result(len(arr))
    i = low  # 左指针
    j = high  # 右指针

    # 检查边界条件
    if low > high:
        result.flag = -1  # low 大于 high
        return result
    if low == high:
        result.flag = 0  # low 等于 high
        result.arr[low] = arr[low]  # 直接返回当前元素
        return result

    # 单趟排序实现
    while i <= j:
        while i <= high and arr[i] < pivot:
            i += 1
        while j >= low and arr[j] > pivot:
            j -= 1
        if i <= j:
            # 交换 arr[i] 和 arr[j]
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1

    # 复制结果到 result.arr
    for k in range(low, high + 1):
        result.arr[k] = arr[k]

    return result

if __name__ == "__main__":
    arr = [10, 7, 8, 9, 1, 5]  # 示例数组
    low = 0  # 起始索引
    high = len(arr) - 1  # 结束索引
    pivot = 5  # 基准值

    # 调用单趟排序函数
    res = quick_sort_single_pass(arr, low, high, pivot)

    # 输出结果
    print(f"标志: {res.flag}")
    print("排序后的数组:", end=" ")
    for i in range(low, high + 1):
        print(res.arr[i], end=" ")
    print()