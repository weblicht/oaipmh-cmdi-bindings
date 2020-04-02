package eu.clarin.weblicht.bindings.cmd.cp;

import eu.clarin.weblicht.bindings.cmd.ws.ServiceCMD;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by wqiu on 14/07/16.
 */
public class CenterProfileCMD12Test {
    @Test
    public void test() throws Exception {
        JAXBContext context = JAXBContext.newInstance(ServiceCMD.class, CenterProfileCMD.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream cmdi12 = classLoader.getResourceAsStream("centerProfile_12.xml");

        CenterProfileCMD centerProfileCMD = (CenterProfileCMD) unmarshaller.unmarshal(cmdi12);

        String name = centerProfileCMD.getComponents().getCenterProfile().getCenterBasicInformation().getName().get(0).getValue();
        assertEquals("Bayerisches Archiv für Sprachsignale", name);
    }
}