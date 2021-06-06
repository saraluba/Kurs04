package enums;

public class DayOdWeekDemo {
    public static void main(String[] args) {
        System.out.println(DayOfWeek.getWeekends());
        System.out.println(DayOfWeek.getWorkingDays());
        System.out.println(DayOfWeek.isWeekend(DayOfWeek.WEDNESDAY));
        System.out.println(DayOfWeek.isWeekend(DayOfWeek.SUNDAY));
        System.out.println(DayOfWeek.fromEnglishName("Thursday"));
        System.out.println(DayOfWeek.fromPolishName("Czwartek"));

    }
}
