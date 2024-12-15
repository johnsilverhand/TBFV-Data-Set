#include <stdio.h>
#include <math.h>

int main() {
    double a, b, c;
    printf("请输入 a, b, c 的值: ");
    scanf("%lf %lf %lf", &a, &b, &c);

    double discriminant = b * b - 4 * a * c;

    if (discriminant > 0) {
        double root1 = (-b + sqrt(discriminant)) / (2 * a);
        double root2 = (-b - sqrt(discriminant)) / (2 * a);
        printf("两个实数根: %lf, %lf\n", root1, root2);
    } else if (discriminant == 0) {
        double root = -b / (2 * a);
        printf("一个实数根: %lf\n", root);
    } else {
        printf("两个虚根\n");
    }

    return 0;
}