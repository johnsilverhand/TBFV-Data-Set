public class RectangleOverlap {
    public static Object rectanglesOverlapArea(int[] rect1, int[] rect2) {
        // rect1 和 rect2 的格式为 [left, bottom, right, top]

        // 检查是否不重叠
        if (rect1[2] < rect2[0] || rect1[0] > rect2[2] ||
            rect1[3] < rect2[1] || rect1[1] > rect2[3]) {
            return false; // 不重叠
        }

        // 检查是否相邻
        if (rect1[2] == rect2[0] || rect1[0] == rect2[2] ||
            rect1[3] == rect2[1] || rect1[1] == rect2[3]) {
            return false; // 相邻
        }

        // 计算重叠区域的边界
        int overlapLeft = Math.max(rect1[0], rect2[0]);
        int overlapBottom = Math.max(rect1[1], rect2[1]);
        int overlapRight = Math.min(rect1[2], rect2[2]);
        int overlapTop = Math.min(rect1[3], rect2[3]);

        // 计算重叠面积
        int overlapWidth = overlapRight - overlapLeft;
        int overlapHeight = overlapTop - overlapBottom;

        // 返回重叠面积
        return overlapWidth * overlapHeight;
    }

    public static void main(String[] args) {
        int[] rect1 = {0, 0, 2, 2}; // 第一个矩形
        int[] rect2 = {2, 2, 3, 3}; // 第二个矩形，相邻
        System.out.println(rectanglesOverlapArea(rect1, rect2));  // 输出: false
    }
}