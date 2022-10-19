import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class DemoLocalDate {
  public static void main(String[] args) {
    // 获取当前日期
    LocalDate now = LocalDate.now();
    // 设置日期
    LocalDate now2 = LocalDate.of(2099, 2, 28);
    // 解析日期，格式必须是yyyy-MM-dd
    LocalDate now3 = LocalDate.parse("2018-01-12");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    String formatRs = now.format(dtf);
    // 取本月第一天
    LocalDate firstDay = now.with(TemporalAdjusters.firstDayOfMonth());
    LocalDate firstDay2 = now.withDayOfMonth(1);
    // 取本月第2天
    LocalDate secondDay = now.withDayOfMonth(2);
    LocalDate nextMonthDay = now.with(TemporalAdjusters.firstDayOfNextMonth());
    LocalDate nextYearDay = now.with(TemporalAdjusters.firstDayOfNextYear());
    // 明年的这一天
    LocalDate localDate = now.plusYears(1);
    // 当前日期加上往后推20天
    LocalDate plusDate = now.plus(20, ChronoUnit.DAYS);
    LocalDate plusYear = now.plus(10, ChronoUnit.YEARS);
    // 当前日期往前推10天
    LocalDate minusDay = now.minusDays(10);
    LocalDate minusYear = now.minus(10, ChronoUnit.YEARS);

    // 比较日期大小
    boolean b1 = now.equals(LocalDate.of(2018, 04, 27));
    boolean b2 = now.equals(LocalDate.of(2018, 04, 26));
    // 判断日期前后 -> false
    boolean b3 = now.isAfter(LocalDate.of(2018, 04, 26));
    boolean b4 = now.isAfter(LocalDate.of(2018, 04, 25));
    boolean b5 = now.isBefore(LocalDate.of(2018, 04, 26));
    boolean b6 = now.isBefore(LocalDate.of(2018, 04, 25));
    boolean b7 = now.isBefore(LocalDate.of(2018, 04, 27));
    // 计算两个日期之间的时间间隔 格式为：x年x月x天
    Period between = Period.between(now, LocalDate.of(2022, 05, 28));
    long betweenDays = ChronoUnit.DAYS.between(now, LocalDate.of(2022, 05, 28));
  }

}
