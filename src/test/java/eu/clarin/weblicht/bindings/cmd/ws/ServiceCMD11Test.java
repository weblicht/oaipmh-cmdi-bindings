package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.CMDITemplateFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBResult;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wqiu on 06/07/16.
 */
public class ServiceCMD11Test {
    private ServiceCMD serviceCMD;

    @Before
    public void setUp() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Templates templates = CMDITemplateFactory.getTemplates();

        Transformer transformer = templates.newTransformer();

        Map<String, Object> properties = new HashMap<String, Object>();


        InputStream cmdi11 = classLoader.getResourceAsStream("9_1.xml");
        StreamSource source = new StreamSource(cmdi11);
        JAXBContext ex = JAXBContext.newInstance(new Class[]{ServiceCMD.class}, properties);
        Unmarshaller unmarshaller = ex.createUnmarshaller();
        JAXBResult jaxbResult = new JAXBResult(unmarshaller);
        transformer.transform(source, jaxbResult);
        serviceCMD = (ServiceCMD) jaxbResult.getResult();
        System.out.println(serviceCMD);

    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void testUnmarshalling() throws Exception {
        System.out.println(serviceCMD.getCMDVersion());
        System.out.println(serviceCMD.extractService().getDescription());


    }
}
