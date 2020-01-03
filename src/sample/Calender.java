package sample;

import java.util.Calendar;

//获取日期
//年 月 当前日期
//自动更新

public class Calender {
    // 日期 和 工作日
    private Integer[] arrayDay;
    private String[] arrayWorkTerm;

    private static String[] WEEK={"日","一","二","三","四","五","六"};

    private Integer theFirstDayOfWeek;//第一天位置

    private Integer year;// 年
    private Integer month;//月
    private Integer monthDays;//周天数
    private Integer day;//日

    private Integer arrayCount ;

    public Calender(){
        Calendar c = Calendar.getInstance();//获得本年
        year = c.get(Calendar.YEAR);//获得本月
        month = c.get(Calendar.MONTH)+1;//获得本日
        day = c.get(Calendar.DATE);//将日期设为第一天，获取本月第一天周几
        monthDays=c.getActualMaximum(Calendar.DAY_OF_MONTH);
        c.set(Calendar.DATE,1);
        theFirstDayOfWeek = c.get(Calendar.DAY_OF_WEEK);//获得本月有多少天

        arrayCount = theFirstDayOfWeek+monthDays-1;//通过多余的天数加上月天数来排出日历表
        arrayDay = new Integer[arrayCount];
        arrayWorkTerm = new String[arrayCount];
        for(int i = 0; i < arrayCount; i++){
            arrayDay[i] =0;
            arrayWorkTerm[i] = "  ";
        }
    }

    @Override
    public String toString() {
        return "calender{" +
                "theFirstDay=" + theFirstDayOfWeek +
                ", year=" + year +
                ", month=" + month +
                ", monthDays=" + monthDays +
                ", day=" + day +
                '}';
    }

    public Integer[] MakeArrayDay(){
        for(Integer i = theFirstDayOfWeek, n = 1; i<= arrayCount; i++){
            arrayDay[i-1]= Integer.valueOf(String.valueOf(n));
            n++;
        }
        return arrayDay;
    }










    public Integer[] getArrayDay() {
        return arrayDay;
    }

    public void setArrayDay(Integer[] arrayDay) {
        this.arrayDay = arrayDay;
    }

    public String[] getArrayWorkTerm() {
        return arrayWorkTerm;
    }

    public void setArrayWorkTerm(String[] arrayWorkTerm) {
        this.arrayWorkTerm = arrayWorkTerm;
    }

    public static String[] getWEEK() {
        return WEEK;
    }

    public static void setWEEK(String[] WEEK) {
        Calender.WEEK = WEEK;
    }

    public Integer getTheFirstDayOfWeek() {
        return theFirstDayOfWeek;
    }

    public void setTheFirstDayOfWeek(Integer theFirstDayOfWeek) {
        this.theFirstDayOfWeek = theFirstDayOfWeek;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getMonthDays() {
        return monthDays;
    }

    public void setMonthDays(Integer monthDays) {
        this.monthDays = monthDays;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getArrayCount() {
        return arrayCount;
    }

    public void setArrayCount(Integer arrayCount) {
        this.arrayCount = arrayCount;
    }
}
