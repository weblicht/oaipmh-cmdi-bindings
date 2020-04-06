package eu.clarin.weblicht.bindings.cmd.cp;

import eu.clarin.weblicht.bindings.CenterProfileHelper;
import eu.clarin.weblicht.bindings.cmd.ws.ServiceCMD;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.TransformerException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by wqiu on 14/07/16.
 */
public class CenterProfileTest {
    public static CenterProfileCMD unmarshallCenterProfileCMD(String resourceName) throws TransformerException, JAXBException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream(resourceName);
        input = CenterProfileHelper.updateToCmdi12AndCenterProfile2(input);

        JAXBContext ex = JAXBContext.newInstance(CenterProfileCMD.class);
        Unmarshaller unmarshaller = ex.createUnmarshaller();
        unmarshaller.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());
        return (CenterProfileCMD) unmarshaller.unmarshal(input);
    }

    @Test
    public void testCmdi11() throws Exception {
        CenterProfileCMD centerProfileCMD = unmarshallCenterProfileCMD("centerProfile.xml");
        String name = centerProfileCMD.getComponents().getCenterProfile().getCenterBasicInformation().getName().get(0).getValue();
        assertEquals("Bayerisches Archiv für Sprachsignale", name);
    }

    @Test
    public void testCmdi12() throws Exception {
        JAXBContext context = JAXBContext.newInstance(ServiceCMD.class, CenterProfileCMD.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        unmarshaller.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream cmdi12 = classLoader.getResourceAsStream("centerProfile_12.xml");
        CenterProfileCMD centerProfileCMD = (CenterProfileCMD) unmarshaller.unmarshal(cmdi12);

        String name = centerProfileCMD.getComponents().getCenterProfile().getCenterBasicInformation().getName().get(0).getValue();
        assertEquals("Bayerisches Archiv für Sprachsignale", name);
    }
}
