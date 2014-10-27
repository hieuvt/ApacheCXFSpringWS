package com.imipgroup.hieuvt;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by hieu.vutrong on 10/26/2014.
 */
public class BirthdayCalendarImpl implements BirthdayCalendar {
    private List<BirthdayImpl> birthdays = new ArrayList<BirthdayImpl>();

    public synchronized void addBirthday(String name, Date date) {
        birthdays.add(new BirthdayImpl(name, date));
    }

    public synchronized Birthday[] getBirthdaysInMonth(int month) {
        List<Birthday> results = new ArrayList<Birthday>();
        BirthdayImpl[] bs = birthdays.toArray(new BirthdayImpl[birthdays.size()]);
        for (BirthdayImpl b : bs) {
            if (b.getMonth() == month) results.add(b);
        }
        return results.toArray(new Birthday[results.size()]);
    }

    public static class BirthdayImpl implements Birthday {

        private String name;
        private int dayOfMonth;
        private int month;

        public BirthdayImpl(String name, Date birthDay) {
            this.name = name;
            Calendar c = Calendar.getInstance();
            c.setTime(birthDay);
            dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
            month = c.get(Calendar.MONTH) + 1; // 1..12
        }

        public int getMonth() {
            return month;
        }

        public int getDayOfMonth() {
            return dayOfMonth;
        }

        public String getName() {
            return name;
        }
    }
}
