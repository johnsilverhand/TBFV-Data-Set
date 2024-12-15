import java.util.Scanner;

public class WhatDay {

    // 判断是否为闰年
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // 计算某年某月1号是星期几
    public static int whatDay(int year, int month) {
        // 计算从公元1年1月1日到目标年的1月1日的总天数
        int totalDays = 0;

        // 累计年份的天数
        for (int i = 1; i < year; i++) {
            totalDays += isLeapYear(i) ? 366 : 365;
        }

        // 每月的天数数组
        int[] daysInMonth = {0, 31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 累计目标年内的月份天数
        for (int i = 1; i < month; i++) {
            totalDays += daysInMonth[i];
        }

        // 加上目标月的1号
        totalDays += 1;

        // 计算星期几 (1: 星期一, ..., 7: 星期日)
        int dayOfWeek = (totalDays % 7);
        return dayOfWeek == 0 ? 7 : dayOfWeek;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份:");
        int year = scanner.nextInt();
        System.out.println("请输入月份:");
        int month = scanner.nextInt();

        int dayOfWeek = whatDay(year, month);

        System.out.print(year + "年" + month + "月1日是星期");
        if (dayOfWeek == 7) {
            System.out.println("日");
        } else {
            System.out.println(dayOfWeek);
        }
    }
}
