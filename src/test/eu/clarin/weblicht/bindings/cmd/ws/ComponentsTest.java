package eu.clarin.weblicht.bindings.cmd.ws;

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

/**
 * Created by wqiu on 05/07/16.
 */
public class ComponentsTest {
    Components components;

    @Before
    public void setUp() throws Exception {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream1 = classLoader.getResourceAsStream("eu/clarin/weblicht/bindings/cmd/ws/v12.xml");
        InputStream inputStream2 = classLoader.getResourceAsStream("eu/clarin/weblicht/bindings/cmd/v12.xml");

        List<Object> streamList = new ArrayList<Object>();
        streamList.add(inputStream1);
        streamList.add(inputStream2);

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(JAXBContextProperties.OXM_METADATA_SOURCE, streamList);

        JAXBContext ex = JAXBContext.newInstance(new Class[]{ServiceCMD.class}, properties);
        System.out.println(ex);
        Unmarshaller unmarshaller = ex.createUnmarshaller();
        File cmdi12 = new File("/Users/wqiu/Projects/clarind/oaipmh-cmdi-bindings/src/main/resources/components.xml");
        components= (Components) unmarshaller.unmarshal(cmdi12);

    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void testComponents() throws Exception {

    }


}