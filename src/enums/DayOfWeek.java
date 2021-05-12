package enums;

import java.util.ArrayList;

public enum DayOfWeek {
    MONDAY("Monday", "Poniedziałek", true),
    TUESDAY("Tuesday","Wtorek", true),
    WEDNESDAY("Wednesday", "Środa", true),
    THURSDAY("Thursday", "Czwartek", true),
    FRIDAY("Friday","Piątek", true),
    SATURDAY("Saturday", "Sobota", false),
    SUNDAY("Sunday","Niedziela", false);

    private final String englishName;
    private final String polishName;
    private boolean workingDay;

    DayOfWeek(String englishName, String polishName, boolean workingDay){
        this.englishName = englishName;
        this.polishName = polishName;
        this.workingDay = workingDay;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getPolishName() {
        return polishName;
    }

    public boolean isWorkingDay() {
        return workingDay;
    }

    public static DayOfWeek fromEnglishName(String englishName){
        for(DayOfWeek day: DayOfWeek.values()) {
            if(day.englishName.equals(englishName)){
                return day;
            }
        }
        throw new IllegalArgumentException("Day with English name \"" + englishName +"\" does not exist");
    }

    public static DayOfWeek fromPolishName(String polishName){
        for(DayOfWeek day: DayOfWeek.values()) {
            if(day.polishName.equals(polishName)){
                return day;
            }
        }
        throw new IllegalArgumentException("Day with Polish name \"" + polishName +"\" does not exist");
    }

    public static boolean isWeekend(DayOfWeek day){
        return !day.workingDay;
    }

    public static ArrayList<DayOfWeek> getWeekends(){
        ArrayList<DayOfWeek> weekend = new ArrayList<>();
        for(DayOfWeek day: DayOfWeek.values()){
            if(day.workingDay == false){
                weekend.add(day);
            }
        }
        return weekend;
    }

    public static ArrayList<DayOfWeek> getWorkingDays(){
        ArrayList<DayOfWeek> work = new ArrayList<>();
        for(DayOfWeek day: DayOfWeek.values()){
            if(day.workingDay == true){
                work.add(day);
            }
        }
        return work;
    }
}
