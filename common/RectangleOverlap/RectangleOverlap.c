#include <stdio.h>

double rectangles_overlap_area(int rect1[4], int rect2[4]) {
    // rect1 和 rect2 的格式为 [left, bottom, right, top]

    // 检查是否不重叠
    if (rect1[2] < rect2[0] || rect1[0] > rect2[2] ||
        rect1[3] < rect2[1] || rect1[1] > rect2[3]) {
        return 0.0; // 不重叠
    }

    // 检查是否相邻
    if (rect1[2] == rect2[0] || rect1[0] == rect2[2] ||
        rect1[3] == rect2[1] || rect1[1] == rect2[3]) {
        return 0.0; // 相邻
    }

    // 计算重叠区域的边界
    int overlapLeft = rect1[0] > rect2[0] ? rect1[0] : rect2[0];
    int overlapBottom = rect1[1] > rect2[1] ? rect1[1] : rect2[1];
    int overlapRight = rect1[2] < rect2[2] ? rect1[2] : rect2[2];
    int overlapTop = rect1[3] < rect2[3] ? rect1[3] : rect2[3];

    // 计算重叠面积
    double overlapWidth = overlapRight - overlapLeft;
    double overlapHeight = overlapTop - overlapBottom;

    // 返回重叠面积
    return overlapWidth * overlapHeight;
}

int main() {
    int rect1[] = {0, 0, 2, 2}; // 第一个矩形
    int rect2[] = {2, 2, 3, 3}; // 第二个矩形，相邻
    printf("%.2f\n", rectangles_overlap_area(rect1, rect2));  // 输出: 0.00
    return 0;
}