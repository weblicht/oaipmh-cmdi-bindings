package eu.clarin.weblicht.bindings.cmd.ws;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wqiu on 06/07/16.
 */
public class ServiceCMD12Test {
    private ServiceCMD serviceCMD;

    @Before
    public void setUp() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        List<Object> streamList = new ArrayList<Object>();

        Map<String, Object> properties = new HashMap<String, Object>();

        JAXBContext ex = JAXBContext.newInstance(new Class[]{ServiceCMD.class}, properties);
        Unmarshaller unmarshaller = ex.createUnmarshaller();
        unmarshaller.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());
        InputStream cmdi12 = classLoader.getResourceAsStream("9_1_trans.xml");
        serviceCMD = (ServiceCMD) unmarshaller.unmarshal(cmdi12);

    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void testMarshalling() throws Exception {
        System.out.println(serviceCMD);


    }
}
