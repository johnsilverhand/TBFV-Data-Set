public class StudioFundsCalculator {
    public static void main(String[] args) {
        double initialCapital = 100; // 初始资金/万元
        double annualRate = 0.10; // 年收益率 10%
        double membershipFee = 2; // 会员续费额/万元，从第二年开始每年增加2i万元
        double targetAmount = 424; // 目标资金/万元

        int year = calculateYearsUntilTarget(initialCapital, annualRate, membershipFee, targetAmount);
        System.out.println("需要的年数: " + year);
    }

    public static int calculateYearsUntilTarget(double initialCapital, double annualRate, double membershipFee, double targetAmount) {
        if (targetAmount <= initialCapital) {
            return 0; // 如果目标资金小于等于初始资金，返回0年
        }

        double currentCapital = initialCapital;
        int year = 0;

        while (currentCapital < targetAmount) {
            year++;
            // 计算年末资金
            currentCapital = currentCapital * (1 + annualRate) + membershipFee * year;
            System.out.println(String.format("%d年末 的金额: %.2f", year, currentCapital));
        }

        return year;
    }
}