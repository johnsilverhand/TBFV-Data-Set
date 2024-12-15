def max_increase(sales):
    n = len(sales)
    max_increase = 0

    for x in range(n - 1):
        for y in range(x + 1, n):
            increase = sales[y] - sales[x]
            if increase > max_increase:
                max_increase = increase

    return max_increase

