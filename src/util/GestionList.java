package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GestionList {
    private static List<LocalDate> dates;
    private static List<LocalTime> times;
    private static List<LocalDateTime> dateTimes;

    public static List<LocalDate> getDates() {
        return dates;
    }

    public static void setDates(List<LocalDate> dates) {
        GestionList.dates = dates;
    }

    public static List<LocalTime> getTimes() {
        return times;
    }

    public static void setTimes(List<LocalTime> times) {
        GestionList.times = times;
    }

    public static List<LocalDateTime> getDateTimes() {
        return dateTimes;
    }

    public static void setDateTimes(List<LocalDateTime> dateTimes) {
        GestionList.dateTimes = dateTimes;
    }

    private GestionList() {
        dates = new ArrayList<>();
        times = new ArrayList<>();
        dateTimes = new ArrayList<>();
    }

    public static void init(){
        GestionList single = new GestionList();
    }

    public static void fillDates(){
        dates.add(LocalDate.of(1993,12,25));
        dates.add(LocalDate.of(1997,4,11));
        dates.add(LocalDate.of(2006,6,14));
        dates.add(LocalDate.of(2006,6,15));
        dates.add(LocalDate.of(1993,3,2));
        dates.add(LocalDate.of(1998,11,13));
    }

    public static void fillTimes(){
        times.add(LocalTime.of(8,50,0));
        times.add(LocalTime.of(6,40,50));
        times.add(LocalTime.of(9,30,30));
        times.add(LocalTime.of(15,30,20));
        times.add(LocalTime.of(19,50,19));
        times.add(LocalTime.of(15,50,12));

    }
}
