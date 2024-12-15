#include <stdio.h>
#include <math.h>

double function(double x) {
    // 计算函数 y = x^3 + x^2 + x + 1 的值
    return pow(x, 3) + pow(x, 2) + x + 1;
}

double calculateArea(int a) {
    // 计算三角形的面积
    double yA = function(a);
    return 0.5 * yA * a; // 面积 S_{ABC} = 0.5 * f(a) * a
}

int findClosestTriangle(double S) {
    // 如果面积小于 0，返回 0
    if (S < 0) {
        return 0;
    } else if (S < 2) {
        return 1; // 面积小于 2 时返回 1
    }

    int a = 1;

    while (1) {
        double area_a = calculateArea(a);
        double area_b = calculateArea(a + 1);
        double diff_a = fabs(area_a - S);
        double diff_b = fabs(area_b - S);
        
        // 输出当前 a 的面积和与目标面积的差值
        printf("a = %d: 面积 = %.2f, 与目标面积的差 = %.2f\n", a, area_a, diff_a);
        printf("a = %d: 面积 = %.2f, 与目标面积的差 = %.2f\n", a + 1, area_b, diff_b);

        if (area_a <= S && area_b > S) {
            if (diff_a > diff_b) {
                a += 1; // 如果 area_b 更接近目标面积，则增加 a
            }
            break; // 找到合适的 a，退出循环
        }
    }

    return a; // 返回最接近的 a 值
}

int main() {
    double S = 2; // 你可以修改这个值来测试不同的输入
    int result = findClosestTriangle(S);
    printf("最接近面积 %.2f 的三角形的结果: %d\n", S, result);
    return 0;
}