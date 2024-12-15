def calculate_years_until_target(initial_capital, annual_rate, membership_fee, target_amount):
    if target_amount <= initial_capital:
        return 0  # If the target amount is less than or equal to the initial capital, return 0 years

    current_capital = initial_capital
    year = 0

    while current_capital < target_amount:
        year += 1
        # Calculate end-of-year capital
        current_capital = current_capital * (1 + annual_rate) + membership_fee * year
        print(f"{year}年末 的金额: {current_capital:.2f}")

    return year

if __name__ == "__main__":
    initial_capital = 100  # Initial capital in ten thousand
    annual_rate = 0.10     # Annual interest rate of 10%
    membership_fee = 2     # Membership renewal fee in ten thousand, increasing by 2i from the second year
    target_amount = 424     # Target funds in ten thousand

    years_needed = calculate_years_until_target(initial_capital, annual_rate, membership_fee, target_amount)
    print(f"需要的年数: {years_needed}")