#include <stdio.h>

typedef struct {
    int flag;      // 标志
    int arr[100];  // 排序后的数组
} Result;

Result quickSortSinglePass(int arr[], int low, int high, int pivot) {
    Result result;
    int i = low;  // i 用于遍历数组
    int j = high; // j 用于遍历数组

    // 初始化结果结构
    result.flag = 1; // 默认标志为 1

    // 检查边界条件
    if (low > high) {
        result.flag = -1; // low 大于 high
        return result;
    }
    if (low == high) {
        result.flag = 0; // low 等于 high
        result.arr[low] = arr[low]; // 直接返回当前元素
        return result;
    }

    // 单趟排序，实现分区
    while (i <= j) {
        // 从左边找到第一个大于等于 pivot 的值
        while (arr[i] < pivot && i <= high) {
            i++;
        }
        // 从右边找到第一个小于等于 pivot 的值
        while (arr[j] > pivot && j >= low) {
            j--;
        }
        // 交换 arr[i] 和 arr[j]
        if (i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    // 复制结果到 result.arr
    for (int k = low; k <= high; k++) {
        result.arr[k] = arr[k];
    }

    // 返回结果
    return result;
}

int main() {
    int arr[] = {10, 7, 8, 9, 1, 5}; // 示例数组
    int low = 0; // 起始索引
    int high = 5; // 结束索引
    int pivot = 5; // 基准值

    // 调用单趟排序函数
    Result res = quickSortSinglePass(arr, low, high, pivot);

    // 输出结果
    printf("标志: %d\n", res.flag);
    printf("排序后的数组:\n");
    for (int i = low; i <= high; i++) {
        printf("%d ", res.arr[i]);
    }
    printf("\n");

    return 0;
}