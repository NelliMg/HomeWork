package enumMonth;

public class Main {
    public static void main(String[] args) {
        Month m = Month.MARCH;
        System.out.println(String.format("%s has %d days", m.toString(), m.getDaysInAMonth()));

        System.out.println("\nAll months of the Year");
        for (Month month : Month.values()) {
            System.out.println(month.toString());
        }

        System.out.println("\nHolidays in April");
        Month.APRIL.printHolidays();

        System.out.println();
        try {
            Month.checkIfHoliday("March 21");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Month.checkIfHoliday("March 8");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
