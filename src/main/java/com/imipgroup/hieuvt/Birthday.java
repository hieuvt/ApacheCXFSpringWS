package com.imipgroup.hieuvt;

import javax.xml.bind.annotation.XmlType;
import java.util.Calendar;
import java.util.Date;

/**
* Created by hieu.vutrong on 10/27/2014.
*/

@XmlType
public class Birthday {

    private String name;
    private int dayOfMonth;
    private int month;

    public Birthday() {
    }

    public Birthday(String name, Date birthDay) {
        this.name = name;
        Calendar c = Calendar.getInstance();
        c.setTime(birthDay);
        dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        month = c.get(Calendar.MONTH) + 1; // 1..12
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
