import math


# Function to calculate decay: A(t) = A0 * e^(-λt)
def calculate_decay(A0, lambda_, t):
    return A0 * math.exp(-lambda_ * t)


# Function to find the minimum time t such that A(t) < A_target
def find_decay_time(A0, lambda_, A_target):
    if A0 <= 0 or lambda_ <= 0 or A_target <= 0:
        raise ValueError("Initial amount, decay rate, and target amount must be positive.")

    t = 0  # Start time from 0
    A_t = A0  # Initial amount of substance

    # Iteratively calculate until A(t) is less than the target amount
    while A_t >= A_target:
        t += 0.1  # Increment time by 0.1
        A_t = calculate_decay(A0, lambda_, t)

    return t  # Return the minimum time t


# Main function to get user input and calculate the decay time
def main():
    # Get user input
    A0 = float(input("请输入初始物质量 A0: "))
    lambda_ = float(input("请输入衰减常数 λ: "))
    A_target = float(input("请输入目标物质量 A_target: "))

    # Find the minimum decay time
    time = find_decay_time(A0, lambda_, A_target)

    # Output the result
    print(f"物质的量将小于 {A_target} 在时间 t = {time} 时发生。")


# Run the main function
if __name__ == "__main__":
    main()
