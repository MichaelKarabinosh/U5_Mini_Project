public class Time {
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public Time (int h, int m, int s)
    {
        hour = h;
        minute = m;
        second = s;
    }

    public void tick()
    {
        second++;
        if (second == 60)
        {
            second  = 0;
            minute++;
        }
        if (minute == 60)
        {
            hour++;
            minute = 0;
        }
        if (hour == 24)
        {
            hour = 0;
            minute = 0;
        }
    }

    public void add(Time t)
    {
        second += t.second;
        minute += t.minute;
        hour += t.hour;
        if (second >= 60)
        {
            second -= 60;
            minute++;
        }
        if (minute >= 60)
        {
            minute -= 60;
            hour++;
        }
        if (hour >= 24)
        {
            hour -= 24;
        }
    }

    public String toString()
    {
        String a = "" + hour;
        String b = "" + minute;
        String c = "" + second;
        if (hour < 10)
        {
            a = "0" + hour;
        }
        if (minute < 10)
        {
            b = "0" + minute;
        }
        if (second < 10)
        {
            c = "0" + second;
        }
        return a + ":" + b + ":" + c;
    }

}
