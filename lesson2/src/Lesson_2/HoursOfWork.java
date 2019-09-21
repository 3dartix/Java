package Lesson_2;

class DayOff extends Exception {
    public DayOff(String message) {
        super(message);
    }
}

enum DaysOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

public class HoursOfWork {
    public static void main(String[] args) {
        try {
            System.out.println(GetRemainingHours(DaysOfWeek.SUNDAY.ordinal()));
        } catch (DayOff e) {
            System.out.println(e.getMessage());
        }
    }

    public static int GetRemainingHours (int day) throws DayOff{
        if (day > 4){
            throw new DayOff("Сегодня выходной");
        }
        int result = 0;
        for (int i = 0; i < (5 - day); i++){
            result += 8;
        }
        return result;
    }
}
