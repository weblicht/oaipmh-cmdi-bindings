package eu.clarin.weblicht.bindings.cmd.cp;

import eu.clarin.weblicht.bindings.CMDITemplateFactory;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by wqiu on 14/07/16.
 */
public class CenterProfileCMD11Test {
    @Test
    public void test() throws Exception {
        Transformer transformer = CMDITemplateFactory.getTemplates().newTransformer();

        StreamSource source;
        {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream cmdi11 = classLoader.getResourceAsStream("centerProfile.xml");
            source = new StreamSource(cmdi11);
        }

        JAXBResult jaxbResult;
        {
            JAXBContext ex = JAXBContext.newInstance(CenterProfileCMD.class);
            Unmarshaller unmarshaller = ex.createUnmarshaller();
            jaxbResult = new JAXBResult(unmarshaller);
        }

        transformer.transform(source, jaxbResult);
        CenterProfileCMD centerProfileCMD = (CenterProfileCMD) jaxbResult.getResult();

        String name = centerProfileCMD.getComponents().getCenterProfile().getCenterBasicInformation().getName().get(0).getValue();
        assertEquals("Bayerisches Archiv für Sprachsignale", name);
    }
}