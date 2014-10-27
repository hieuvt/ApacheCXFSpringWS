package com.imipgroup.hieuvt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hieu.vutrong on 10/26/2014.
 */
public class BirthdayCalendarImpl implements BirthdayCalendar {
    private List<com.imipgroup.hieuvt.Birthday> birthdays = new ArrayList<com.imipgroup.hieuvt.Birthday>();

    public synchronized void addBirthday(String name, Date date) {
        birthdays.add(new com.imipgroup.hieuvt.Birthday(name, date));
    }

    public synchronized Birthday[] getBirthdaysInMonth(int month) {
        List<Birthday> results = new ArrayList<Birthday>();
        com.imipgroup.hieuvt.Birthday[] bs = birthdays.toArray(new com.imipgroup.hieuvt.Birthday[birthdays.size()]);
        for (com.imipgroup.hieuvt.Birthday b : bs) {
            if (b.getMonth() == month) results.add(b);
        }
        return results.toArray(new Birthday[results.size()]);
    }

}
