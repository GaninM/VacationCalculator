package com.neo.task.vacationcalculator.utils;

import java.sql.Date;
import java.util.*;

public class Constants {

    public static final double AVERAGE_CALENDAR_DAYS_IN_MONTH = 29.3;
    public static final int MONTHS_IN_THE_YEAR = 12;
    public static final double AVERAGE_CALENDAR_DAYS_IN_YEAR = AVERAGE_CALENDAR_DAYS_IN_MONTH * MONTHS_IN_THE_YEAR;

    public static List<Date> HOLIDAYS_IN_2022 = new ArrayList<>();

    static {
        HOLIDAYS_IN_2022.add(new Date(2022 - 1900, 0, 1));
        HOLIDAYS_IN_2022.add(new Date(2022 - 1900, 0, 2));
        HOLIDAYS_IN_2022.add(new Date(2022 - 1900, 0, 3));
        HOLIDAYS_IN_2022.add(new Date(2022 - 1900, 0, 4));
        HOLIDAYS_IN_2022.add(new Date(2022 - 1900, 0, 5));
        HOLIDAYS_IN_2022.add(new Date(2022 - 1900, 0, 6));
        HOLIDAYS_IN_2022.add(new Date(2022 - 1900, 0, 7));
        HOLIDAYS_IN_2022.add(new Date(2022 - 1900, 0, 8));
        HOLIDAYS_IN_2022.add(new Date(2022 - 1900, 2, 8));
        HOLIDAYS_IN_2022.add(new Date(2022 - 1900, 4, 1));
        HOLIDAYS_IN_2022.add(new Date(2022 - 1900, 4, 9));
        HOLIDAYS_IN_2022.add(new Date(2022 - 1900, 5, 12));
        HOLIDAYS_IN_2022.add(new Date(2022 - 1900, 10, 4));
    }

}
