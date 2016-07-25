package eu.clarin.weblicht.bindings.cmd.cp;

import eu.clarin.weblicht.bindings.cmd.ws.Service;
import eu.clarin.weblicht.bindings.cmd.ws.ServiceCMD;
import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by wqiu on 14/07/16.
 */
public class CenterProfileCMDTest {
    @Before
    public void setUp() throws Exception {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream1 = classLoader.getResourceAsStream("eu/clarin/weblicht/bindings/cmd/ws/v11.xml");
        InputStream inputStream2 = classLoader.getResourceAsStream("eu/clarin/weblicht/bindings/cmd/cp/v11.xml");
        InputStream inputStream3 = classLoader.getResourceAsStream("eu/clarin/weblicht/bindings/cmd/v11.xml");

        List<Object> streamList = new ArrayList<Object>();
        streamList.add(inputStream1);
        streamList.add(inputStream2);
        streamList.add(inputStream3);

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(JAXBContextProperties.OXM_METADATA_SOURCE, streamList);

        JAXBContext ex = JAXBContext.newInstance(new Class[]{ServiceCMD.class, CenterProfileCMD.class}, properties);
        System.out.println(ex);
        Unmarshaller unmarshaller = ex.createUnmarshaller();
        File cmdi11 = new File("/Users/wqiu/Projects/clarind/oaipmh-cmdi-bindings/src/main/resources/centerProfile.xml");
        CenterProfileCMD centerProfileCMD = (CenterProfileCMD) unmarshaller.unmarshal(cmdi11);
        System.out.println(centerProfileCMD);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getComponents() throws Exception {

    }

}