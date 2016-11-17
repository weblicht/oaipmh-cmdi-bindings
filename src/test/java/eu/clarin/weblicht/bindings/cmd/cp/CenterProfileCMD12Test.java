package eu.clarin.weblicht.bindings.cmd.cp;

import eu.clarin.weblicht.bindings.cmd.ws.ServiceCMD;
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
 * Created by wqiu on 14/07/16.
 */
public class CenterProfileCMD12Test {
    @Before
    public void setUp() throws Exception {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        List<Object> streamList = new ArrayList<Object>();

        Map<String, Object> properties = new HashMap<String, Object>();

        JAXBContext ex = JAXBContext.newInstance(new Class[]{ ServiceCMD.class, CenterProfileCMD.class}, properties);
        Unmarshaller unmarshaller = ex.createUnmarshaller();
        InputStream cmdi12 = classLoader.getResourceAsStream("centerProfile_12.xml");
        CenterProfileCMD centerProfileCMD = (CenterProfileCMD) unmarshaller.unmarshal(cmdi12);
        System.out.println(centerProfileCMD);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getComponents() throws Exception {

    }

}