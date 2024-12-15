public class MembershipFeeCalculator {

    public static int calculateN(double a, double b, double c) {
        
        if (a <= 0 || b <= 0 || c <= 0) {
            return -1;  // 无效输入，返回-1
        }

        // ac >= b 时，n=1
        if (a * c >= b) {
            return 1;
        }

        int n = 2;
        while (true) {
            // 计算第n-2年和第n-1年的收益
            double revenueNMinus2 = c*(a * Math.pow(1 + c, n - 2) + 
                (b * (1 + c) / Math.pow(c, 2)) * (Math.pow(1 + c, n - 2) - 1) - 
                (n - 2) * b / c);

            double revenueNMinus1 = c*(a * Math.pow(1 + c, n - 1) + 
                (b * (1 + c) / Math.pow(c, 2)) * (Math.pow(1 + c, n - 1) - 1) - 
                (n - 1) * b / c);

            if (revenueNMinus2 < b * (n - 1) && revenueNMinus1 >= b * n) {
                System.out.printf("%d年末资金:%.2f->%d年收益/会费:%.2f/%.2f,%n",n-2,revenueNMinus2/c,n-1,revenueNMinus2,b*(n-1));
                System.out.printf("%d年末资金:%.2f->%d年收益/会费:%.2f/%.2f,%n",n-1,revenueNMinus1/c,n,revenueNMinus1,b*n);
                return n;  // 找到满足条件的n
            }
            n++;  // 增加n
        }
    }

    public static void main(String[] args) {
        double a = 100;  // 初始资金
        double b = 20;   // 每年的会费系数
        double c = 0.05;  // 年收益率

        int result = calculateN(a, b, c);
        System.out.println("第"+result+"年首次实现收益不少于该年年末的会费" );
    }
}