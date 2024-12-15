public class PlaneRelation {
    public static String judgePlaneRelation(double A1, double B1, double C1, double D1,
                                             double A2, double B2, double C2, double D2) {
        if ((A1 * B2 - A2 * B1) == 0 &&
            (A1 * C2 - A2 * C1) == 0 &&
            (B1 * C2 - B2 * C1) == 0) {
            if (D1 != D2) {
                return "平行";
            } else {
                return "重合";
            }
        } else if (A1 * A2 + B1 * B2 + C1 * C2 == 0) {
            return "垂直";
        } else {
            return "相交";
        }
    }

    public static void main(String[] args) {
        System.out.println(judgePlaneRelation(1, 2, 3, 4, 2, 4, 6, 8)); // 示例用法
    }
}