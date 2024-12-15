#include <stdio.h>

int calculateYearsUntilTarget(double initialCapital, double annualRate, double membershipFee, double targetAmount) {
    if (targetAmount <= initialCapital) {
        return 0; // If the target amount is less than or equal to the initial capital, return 0 years
    }

    double currentCapital = initialCapital;
    int year = 0;

    while (currentCapital < targetAmount) {
        year++;
        // Calculate end-of-year capital
        currentCapital = currentCapital * (1 + annualRate) + membershipFee * year;
        printf("%d年末 的金额: %.2f\n", year, currentCapital);
    }

    return year;
}

int main() {
    double initialCapital = 100; // Initial capital in ten thousand
    double annualRate = 0.10;    // Annual interest rate of 10%
    double membershipFee = 2;     // Membership renewal fee in ten thousand, increasing by 2i from the second year
    double targetAmount = 424;     // Target funds in ten thousand

    int yearsNeeded = calculateYearsUntilTarget(initialCapital, annualRate, membershipFee, targetAmount);
    printf("需要的年数: %d\n", yearsNeeded);
    return 0;
}