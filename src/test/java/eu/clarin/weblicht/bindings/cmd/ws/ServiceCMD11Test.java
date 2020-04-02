package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.CMDITemplateFactory;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBResult;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by wqiu on 06/07/16.
 */
public class ServiceCMD11Test {
    @Test
    public void test() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream cmdi11 = classLoader.getResourceAsStream("9_1.xml");
        StreamSource source = new StreamSource(cmdi11);

        JAXBContext context = JAXBContext.newInstance(ServiceCMD.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        JAXBResult jaxbResult = new JAXBResult(unmarshaller);

        Templates templates = CMDITemplateFactory.getTemplates();
        Transformer transformer = templates.newTransformer();
        transformer.transform(source, jaxbResult);

        ServiceCMD serviceCMD = (ServiceCMD) jaxbResult.getResult();

        assertEquals("1.2", serviceCMD.getCMDVersion());
        assertEquals("Jitar POS Tagger", serviceCMD.extractService().getName().getValue());
    }
}
