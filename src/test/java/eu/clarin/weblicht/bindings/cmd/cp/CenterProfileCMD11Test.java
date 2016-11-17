package eu.clarin.weblicht.bindings.cmd.cp;

import eu.clarin.weblicht.bindings.CMDITemplateFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wqiu on 14/07/16.
 */
public class CenterProfileCMD11Test {
    @Before
    public void setUp() throws Exception {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Transformer transformer = CMDITemplateFactory.getTemplates().newTransformer();

        Map<String, Object> properties = new HashMap<String, Object>();


        InputStream cmdi11 = classLoader.getResourceAsStream("centerProfile.xml");
        StreamSource source = new StreamSource(cmdi11);
        JAXBContext ex = JAXBContext.newInstance(new Class[]{ CenterProfileCMD.class}, properties);
        Unmarshaller unmarshaller = ex.createUnmarshaller();
        JAXBResult jaxbResult = new JAXBResult(unmarshaller);
        transformer.transform(source, jaxbResult);
        CenterProfileCMD centerProfileCMD = (CenterProfileCMD) jaxbResult.getResult();
        System.out.println(centerProfileCMD);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getComponents() throws Exception {

    }

}