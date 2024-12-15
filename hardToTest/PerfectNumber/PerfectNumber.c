#include <stdio.h>
#include <math.h>
#include <stdbool.h>

bool isPrime(int p) {
    for (int i = 2; i <= sqrt(p); i++) {
        if (p % i == 0) {
            return false;
        }
    }
    return p > 1; // p must be greater than 1
}

bool isPerfectNumber(int num) {
    // Perfect numbers must be positive integers
    if (num <= 1) {
        return false;
    }

    // Check if num is even
    if (num % 2 == 1) {
        return false;
    }

    // Find p such that num = 2^(p-1) * (2^p - 1)
    for (int p = 2; p < 32; p++) { // p needs to be less than 32 to avoid overflow
        if (isPrime(p) && (pow(2, p) - 1) != 0) {
            int perfectCandidate = (int)(pow(2, p - 1) * (pow(2, p) - 1));
            if (perfectCandidate == num) {
                return true;
            }
        }
    }

    return false;
}

int main() {
    int num = 28;
    if (isPerfectNumber(num)) {
        printf("%d 是完全数。\n", num);
    } else {
        printf("%d 不是完全数。\n", num);
    }
    return 0;
}