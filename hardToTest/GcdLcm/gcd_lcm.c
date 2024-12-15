#include <stdio.h>

void gcd_lcm(int a, int b, int *gcd, int *lcm) {
    if (a <= 0 || b <= 0) {
        *gcd = *lcm = -1; // 错误指示
        return;
    }

    int x = a, y = b;
    while (y) {
        int temp = y;
        y = x % y;
        x = temp;
    }
    *gcd = x;
    *lcm = (a * b) / (*gcd);
}

int main() {
    int a = 15, b = 20, gcd, lcm;
    gcd_lcm(a, b, &gcd, &lcm);
    printf("GCD: %d, LCM: %d\n", gcd, lcm);
    return 0;
}