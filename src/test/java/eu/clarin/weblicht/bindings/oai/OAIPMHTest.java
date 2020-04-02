package eu.clarin.weblicht.bindings.oai;

import eu.clarin.weblicht.bindings.CMDITemplateFactory;
import eu.clarin.weblicht.bindings.cmd.cp.CenterProfileCMD;
import eu.clarin.weblicht.bindings.cmd.ws.ServiceCMD;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by wqiu on 06/12/16.
 */
public class OAIPMHTest {
    @Test
    public void test() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream cmdi11 = classLoader.getResourceAsStream("OAIMPH.xml");
        StreamSource source = new StreamSource(cmdi11);

        JAXBContext ex = JAXBContext.newInstance(ServiceCMD.class, CenterProfileCMD.class, OAIPMH.class);
        Unmarshaller unmarshaller = ex.createUnmarshaller();
        JAXBResult jaxbResult = new JAXBResult(unmarshaller);

        Transformer transformer = CMDITemplateFactory.getTemplates().newTransformer();
        transformer.transform(source, jaxbResult);

        OAIPMH oaipmh = (OAIPMH) jaxbResult.getResult();
        assertEquals("MaltParser",
                oaipmh.getListRecords().getRecords().get(0).getCMD().getComponents().getWebLichtWebService().getService().getName().getValue());
    }
}