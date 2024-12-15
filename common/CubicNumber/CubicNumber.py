def calculate_containers():
    # 获取沙子的体积S
    S = int(input("请输入沙子的体积（立方米）："))

    n = 0  # 记录使用的容器数
    current_volume = 1  # 从1立方米的容器开始

    # 使用容器逐步装沙子
    while S > 0:
        container_volume = current_volume ** 3  # 当前容器的体积

        # 如果当前容器能够装下沙子
        if S >= container_volume:
            S -= container_volume  # 使用一个容器并减少沙子的体积
            n += 1  # 增加容器数

        # 每种容器只能使用一次，增加边长
        current_volume += 1

    # 返回容器数量n
    return n
