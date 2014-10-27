package com.imipgroup.hieuvt;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;

/**
 * Created by hieu.vutrong on 10/26/2014.
 */
@WebService
public interface BirthdayCalendar {

    /**
     * Adds a birthday.
     * @param name the name of the person.
     * @param date the birthday.
     */
    @WebMethod
    void addBirthday(@WebParam(name = "name") String name, @WebParam(name = "date") Date date);

    /**
     * returns all the birthdays in one month.
     * @param month the month (1..12).
     * @return all the birthdays in that month.
     */

    @WebMethod
    Birthday[] getBirthdaysInMonth(@WebParam(name = "month") int month);
}
