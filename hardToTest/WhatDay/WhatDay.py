def what_day(year, month):
    q = 1
    m = month
    K = year % 100
    J = year // 100

    h = (q + (13 * (m + 1)) // 5 + K + K // 4 + J // 4 + 5 * J) % 7

    days = ["Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"]
    return days[h]


