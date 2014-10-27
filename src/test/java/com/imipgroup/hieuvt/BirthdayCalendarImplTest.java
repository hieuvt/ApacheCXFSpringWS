package com.imipgroup.hieuvt;

import junit.framework.TestCase;
import org.apache.cxf.aegis.databinding.AegisDatabinding;
import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.apache.cxf.frontend.ServerFactoryBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BirthdayCalendarImplTest extends TestCase {
    static {
        //
        ServerFactoryBean svrFactory = new ServerFactoryBean();
        svrFactory.getServiceFactory().setDataBinding(new AegisDatabinding());
        svrFactory.setServiceClass(BirthdayCalendar.class);
        svrFactory.setAddress("http://localhost:8081/Birthday");
        svrFactory.setServiceBean(new BirthdayCalendarImpl());
        svrFactory.create();
        //
    }

    protected BirthdayCalendar newBirthdayClient() {
        ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
        factory.setServiceClass(BirthdayCalendar.class);
        factory.getServiceFactory().setDataBinding(new AegisDatabinding());
        factory.setAddress("http://localhost:8081/Birthday");
        return (BirthdayCalendar) factory.create();
    }

    public void testService() throws ParseException {
        BirthdayCalendar bc=newBirthdayClient();
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        bc.addBirthday("Erik",sdf.parse("21-02-1971"));
        BirthdayCalendar.Birthday[] b=bc.getBirthdaysInMonth(2);
        assertEquals(1,b.length);
        assertEquals("Erik",b[0].getName());
        assertEquals(21,b[0].getDayOfMonth());
    }
}