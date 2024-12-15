#include <stdio.h>

const char* judge_plane_relation(double A1, double B1, double C1, double D1,
                                  double A2, double B2, double C2, double D2) {
    if ((A1 * B2 - A2 * B1) == 0 &&
        (A1 * C2 - A2 * C1) == 0 &&
        (B1 * C2 - B2 * C1) == 0) {
        if (D1 != D2) {
            return "平行";
        } else {
            return "重合";
        }
    } else if (A1 * A2 + B1 * B2 + C1 * C2 == 0) {
        return "垂直";
    } else {
        return "相交";
    }
}

int main() {
    printf("%s\n", judge_plane_relation(1, 2, 3, 4, 2, 4, 6, 8)); // 示例用法
    return 0;
}