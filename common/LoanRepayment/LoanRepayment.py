import math


# Function to calculate loan balance: P(t) = P0 * (1 + r)^t
def calculate_loan_balance(P0, r, t):
    return P0 * math.pow((1 + r), t)


# Function to find the minimum time t such that P(t) < P_target
def find_repayment_time(P0, r, P_target):
    if P0 <= 0 or r <= 0 or P_target <= 0:
        raise ValueError("Initial loan amount, interest rate, and target balance must be positive.")

    t = 0  # Start time from 0
    P_t = P0  # Initial loan balance

    # Iteratively calculate until P(t) is less than the target balance
    while P_t >= P_target:
        t += 1  # Increment time by 1 month
        P_t = calculate_loan_balance(P0, r, t)

    return t  # Return the minimum time t


# Main function to get user input and calculate the repayment time
def main():
    # Get user input
    P0 = float(input("请输入初始贷款金额 P0: "))
    r = float(input("请输入月利率 r (例如 0.01 表示 1%): "))
    P_target = float(input("请输入目标余额 P_target: "))

    # Find the minimum repayment time
    time = find_repayment_time(P0, r, P_target)

    # Output the result
    print(f"贷款余额将小于 {P_target} 在时间 t = {time} 月时发生。")


# Run the main function
if __name__ == "__main__":
    main()
