package enumMonth;

public enum Month {
    JANUARY(31, 1, 2, 3, 6, 28),
    FEBRUARY(29),
    MARCH(31, 8),
    APRIL(30),
    MAY(31, 1, 8, 9, 28),
    JUNE(30, 1),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30, 21),
    OCTOBER(31, 31),
    NOVEMBER(30),
    DECEMBER(31, 31);


    private int[] holidays;
    private int daysInAMonth;

    Month(int daysInAMonth, int... holidays) {
        if (daysInAMonth > 31 || daysInAMonth < 27) {
            throw new IllegalArgumentException();
        }
        this.daysInAMonth = daysInAMonth;
        this.holidays = new int[holidays.length];
        for (int i = 0; i < holidays.length; i++) {
            if (holidays[i] < 0 || holidays[i] > daysInAMonth) {
                throw new IllegalArgumentException();
            }
            this.holidays[i] = holidays[i];
        }
    }

    private boolean dayExistsInHolidays(int day) {
        for (int i = 0; i < this.holidays.length; i++) {
            if (day == this.holidays[i]) {
                return true;
            }
        }
        return false;
    }


    public static void checkIfHoliday(String date) {
        String[] monthAndDay = new String[2];
        try {
            monthAndDay = date.split(" ");
        } catch (Exception e) {
            throw new IllegalArgumentException("The date was nor given with the correct format, no Space was found");
        }
        monthAndDay[0] = monthAndDay[0].trim();
        monthAndDay[1] = monthAndDay[1].trim();
        int day = 0;
        try {
            day = Integer.parseInt(monthAndDay[1]);
        } catch (Exception e) {
            throw new IllegalArgumentException(" Could not find the date after splitting");
        }
        for (Month m : Month.values()) {
            if (m.name().equalsIgnoreCase(monthAndDay[0])) {
                if (m.dayExistsInHolidays(day)) {
                    System.out.println(String.format("%s is a public holiday", date));
                } else {
                    System.out.println(String.format("%s is not a public holiday", date));
                }
                break;
            }
        }
    }

    public int getDaysInAMonth() {
        return daysInAMonth;
    }

    public void printHolidays() {
        if (this.holidays.length == 0) {
            System.out.println(String.format("No Holidays in %s", this.name()));
        } else {
            for (int i = 0; i < holidays.length; i++) {
                System.out.println(String.format("%s %d is a public Holiday", this, holidays[i]));
            }
        }
    }
}

