package eu.clarin.weblicht.bindings.oai;

import eu.clarin.weblicht.bindings.CMDITemplateFactory;
import eu.clarin.weblicht.bindings.cmd.cp.CenterProfileCMD;
import eu.clarin.weblicht.bindings.cmd.ws.ServiceCMD;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamSource;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by wqiu on 06/12/16.
 */
public class OAIPMHTest {
    @Before
    public void setUp() throws Exception {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Transformer transformer = CMDITemplateFactory.getTemplates().newTransformer();

        Map<String, Object> properties = new HashMap<String, Object>();


        InputStream cmdi11 = classLoader.getResourceAsStream("OAIMPH.xml");
        StreamSource source = new StreamSource(cmdi11);
        JAXBContext ex = JAXBContext.newInstance(new Class[]{ServiceCMD.class, CenterProfileCMD.class, OAIPMH.class}, properties);
        Unmarshaller unmarshaller = ex.createUnmarshaller();
        JAXBResult jaxbResult = new JAXBResult(unmarshaller);
        transformer.transform(source, jaxbResult);
        OAIPMH oaipmh= (OAIPMH) jaxbResult.getResult();
        System.out.println(oaipmh.getListRecords().getRecords().get(0));

    }

    @Test
    public void testGetListRecords() {

    }

}