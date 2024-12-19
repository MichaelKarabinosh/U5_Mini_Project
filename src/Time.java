/**
 * The Time class represents a military time of day in hours, minutes, and seconds.
 * It provides methods to increment time by one second, add another Time object,
 * and return a string representation of the time in HH:MM:SS format.
 */
public class Time {

    /**
     * The hour component of the time (0-23).
     */
    private int hour;

    /**
     * The minute component of the time (0-59).
     */
    private int minute;

    /**
     * The second component of the time (0-59).
     */
    private int second;

    /**
     * Constructor for the Time class. This creates a new instance of Time
     * with the specified hour, minute, and second.
     *
     * @param h the hour component (0-23)
     * @param m the minute component (0-59)
     * @param s the second component (0-59)
     */
    public Time(int h, int m, int s) {
        hour = h;
        minute = m;
        second = s;
    }

    /**
     * Advances the time by one second. If the seconds reach 60, they reset to 0,
     * and the minutes increment by 1. If the minutes reach 60, they reset to 0,
     * and the hours increment by 1. If the hours reach 24, they reset to 0.
     */
    public void tick() {
        second++;
        if (second == 60) {
            second = 0;
            minute++;
        }
        if (minute == 60) {
            hour++;
            minute = 0;
        }
        if (hour == 24) {
            hour = 0;
            minute = 0;
        }
    }

    /**
     * Adds the time from another Time object to this time.
     * The seconds, minutes, and hours are added separately. If the result exceeds
     * the valid range for seconds or minutes, they are rolled over, and the next
     * unit increments. If the result exceeds 24 hours, the hours roll over.
     *
     * @param t the Time object to add
     */
    public void add(Time t) {
        second += t.second;
        minute += t.minute;
        hour += t.hour;
        if (second >= 60) {
            second -= 60;
            minute++;
        }
        if (minute >= 60) {
            minute -= 60;
            hour++;
        }
        if (hour >= 24) {
            hour -= 24;
        }
    }

    /**
     * Returns a string representation of the time in the format HH:MM:SS.
     * Each component is padded with a zero to ensure two digits.
     *
     * @return a String representing the time in HH:MM:SS format
     */
    public String toString() {
        String a = "" + hour;
        String b = "" + minute;
        String c = "" + second;
        if (hour < 10) {
            a = "0" + hour;
        }
        if (minute < 10) {
            b = "0" + minute;
        }
        if (second < 10) {
            c = "0" + second;
        }
        return a + ":" + b + ":" + c;
    }
}
