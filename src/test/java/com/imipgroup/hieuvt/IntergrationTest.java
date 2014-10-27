package com.imipgroup.hieuvt;

import junit.framework.TestCase;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by hieu.vutrong on 10/27/2014.
 */
public class IntergrationTest extends TestCase {
    protected BirthdayCalendar newBirthdayClient() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(BirthdayCalendar.class);
        factory.setAddress("http://localhost:8080/birthday");
        return (BirthdayCalendar) factory.create();
    }

    public void testService() throws ParseException {
        BirthdayCalendar bc=newBirthdayClient();
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        Birthday[] br=bc.getBirthdaysInMonth(2);
        if (br==null||br.length==0) {
            bc.addBirthday("Erik",sdf.parse("21-02-1971"));
        }
        Birthday[] b=bc.getBirthdaysInMonth(2);
        assertEquals(1,b.length);
        assertEquals("Erik",b[0].getName());
        assertEquals(21,b[0].getDayOfMonth());
    }
}
