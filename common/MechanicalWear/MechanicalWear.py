# Function to calculate efficiency: E(t) = E0 * (1 - t / T)
def calculate_efficiency(E0, T, t):
    return E0 * (1 - t / T)


# Function to find the minimum time t such that E(t) < E_target
def find_wear_time(E0, T, E_target):
    if E0 <= 0 or T <= 0 or E_target <= 0:
        raise ValueError("Initial efficiency, total life, and target efficiency must be positive.")

    t = 0  # Start time from 0
    E_t = E0  # Initial efficiency

    # Iteratively calculate until E(t) is less than the target efficiency
    while E_t >= E_target:
        t += 0.1  # Increment time by 0.1
        E_t = calculate_efficiency(E0, T, t)

    return t  # Return the minimum time t


# Main function to get user input and calculate the wear time
def main():
    # Get user input
    E0 = float(input("请输入初始效率 E0: "))
    T = float(input("请输入设备总寿命 T: "))
    E_target = float(input("请输入目标效率 E_target: "))

    # Find the minimum wear time
    time = find_wear_time(E0, T, E_target)

    # Output the result
    print(f"设备的效率将小于 {E_target} 在时间 t = {time} 时发生。")


# Run the main function
if __name__ == "__main__":
    main()
