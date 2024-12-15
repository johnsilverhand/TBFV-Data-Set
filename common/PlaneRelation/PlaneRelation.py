def judge_plane_relation(A1, B1, C1, D1, A2, B2, C2, D2):
    if (A1 * B2 - A2 * B1) == 0 and (A1 * C2 - A2 * C1) == 0 and (B1 * C2 - B2 * C1) == 0:
        if D1 != D2:
            return "平行"
        else:
            return "重合"
    elif A1 * A2 + B1 * B2 + C1 * C2 == 0:
        return "垂直"
    else:
        return "相交"

# 示例用法
print(judge_plane_relation(1, 2, 3, 4, 2, 4, 6, 8))