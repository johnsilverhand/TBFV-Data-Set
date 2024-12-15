def calculate_n(a, b, c):
    if a <= 0 or b <= 0 or c <= 0:
        return -1  # Invalid input, return -1

    # If ac >= b, then n = 1
    if a * c >= b:
        return 1

    n = 2
    while True:
        # Calculate revenue for year n-2 and n-1
        revenue_n_minus_2 = c * (a * (1 + c)**(n - 2) +
                                   (b * (1 + c) / c**2) * ((1 + c)**(n - 2) - 1) -
                                   (n - 2) * b / c)

        revenue_n_minus_1 = c * (a * (1 + c)**(n - 1) +
                                   (b * (1 + c) / c**2) * ((1 + c)**(n - 1) - 1) -
                                   (n - 1) * b / c)

        if revenue_n_minus_2 < b * (n - 1) and revenue_n_minus_1 >= b * n:
            print(f"{n - 2}年末资金: {revenue_n_minus_2/c:.2f} -> {n - 1}年收益/会费: {revenue_n_minus_2:.2f}/{b * (n - 1):.2f}")
            print(f"{n - 1}年末资金: {revenue_n_minus_1/c:.2f} -> {n}年收益/会费: {revenue_n_minus_1:.2f}/{b * n:.2f}")
            return n  # Found the satisfying n
        n += 1  # Increase n

if __name__ == "__main__":
    a = 100  # Initial funds
    b = 20   # Annual fee coefficient
    c = 0.05  # Annual interest rate

    result = calculate_n(a, b, c)
    print(f"第 {result} 年首次实现收益不少于该年年末的会费")