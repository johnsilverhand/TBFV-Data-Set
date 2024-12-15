class Result {
    int flag;      // 标志
    int[] arr;     // 排序后的数组

    public Result(int size) {
        arr = new int[size];
    }
}

public class QuickSortSinglePass {
    public static Result quickSortSinglePass(int[] arr, int low, int high, int pivot) {
        Result result = new Result(arr.length);
        int i = low;  // 左指针
        int j = high; // 右指针

        // 初始化结果标志
        result.flag = 1;

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

        // 单趟排序实现
        while (i <= j) {
            while (arr[i] < pivot && i <= high) {
                i++;
            }
            while (arr[j] > pivot && j >= low) {
                j--;
            }
            if (i <= j) {
                // 交换 arr[i] 和 arr[j]
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

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5}; // 示例数组
        int low = 0; // 起始索引
        int high = arr.length - 1; // 结束索引
        int pivot = 5; // 基准值

        // 调用单趟排序函数
        Result res = quickSortSinglePass(arr, low, high, pivot);

        // 输出结果
        System.out.println("标志: " + res.flag);
        System.out.print("排序后的数组: ");
        for (int i = low; i <= high; i++) {
            System.out.print(res.arr[i] + " ");
        }
        System.out.println();
    }
}