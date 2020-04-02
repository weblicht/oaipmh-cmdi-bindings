package eu.clarin.weblicht.bindings.cmd.ws;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by wqiu on 06/07/16.
 */
public class ServiceCMD12Test {
    @Test
    public void test() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream cmdi12 = classLoader.getResourceAsStream("9_1_trans.xml");

        JAXBContext ex = JAXBContext.newInstance(ServiceCMD.class);
        Unmarshaller unmarshaller = ex.createUnmarshaller();
        unmarshaller.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());

        ServiceCMD serviceCMD = (ServiceCMD) unmarshaller.unmarshal(cmdi12);

        assertEquals("Jitar POS Tagger", serviceCMD.getComponents().getWebLichtWebService().getService().getName().getValue());
    }
}
