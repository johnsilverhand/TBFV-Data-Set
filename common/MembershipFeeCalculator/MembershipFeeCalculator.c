#include <stdio.h>
#include <math.h>

int calculateN(double a, double b, double c) {
    if (a <= 0 || b <= 0 || c <= 0) {
        return -1;  // Invalid input, return -1
    }

    // If ac >= b, then n = 1
    if (a * c >= b) {
        return 1;
    }

    int n = 2;
    while (1) {
        // Calculate revenue for year n-2 and n-1
        double revenueNMinus2 = c * (a * pow(1 + c, n - 2) +
            (b * (1 + c) / pow(c, 2)) * (pow(1 + c, n - 2) - 1) -
            (n - 2) * b / c);

        double revenueNMinus1 = c * (a * pow(1 + c, n - 1) +
            (b * (1 + c) / pow(c, 2)) * (pow(1 + c, n - 1) - 1) -
            (n - 1) * b / c);

        if (revenueNMinus2 < b * (n - 1) && revenueNMinus1 >= b * n) {
            printf("%d年末资金: %.2f -> %d年收益/会费: %.2f/%.2f\n", n - 2, revenueNMinus2 / c, n - 1, revenueNMinus2, b * (n - 1));
            printf("%d年末资金: %.2f -> %d年收益/会费: %.2f/%.2f\n", n - 1, revenueNMinus1 / c, n, revenueNMinus1, b * n);
            return n;  // Found the satisfying n
        }
        n++;  // Increase n
    }
}

int main() {
    double a = 100;  // Initial funds
    double b = 20;   // Annual fee coefficient
    double c = 0.05; // Annual interest rate

    int result = calculateN(a, b, c);
    printf("第 %d 年首次实现收益不少于该年年末的会费\n", result);
    return 0;
}