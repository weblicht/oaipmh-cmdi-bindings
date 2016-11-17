package eu.clarin.weblicht.bindings.cmd.ws;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by wqiu on 05/07/16.
 */
public class ServiceCMDTest {
    ServiceCMD serviceCMD;
    @Before
    public void setUp() throws Exception {

//        JAXBContext ex = JAXBContext.newInstance(ServiceCMD.class);
//        Unmarshaller unmarshaller = ex.createUnmarshaller();
//        File cmdi11 = new File("/Users/wqiu/Projects/clarind/oaipmh-cmdi-bindings/src/main/resources/9_1.xml");
//        File cmdi12 = new File("/Users/wqiu/Projects/clarind/oaipmh-cmdi-bindings/src/main/resources/9.xml");
//        serviceCMD = (ServiceCMD) unmarshaller.unmarshal(cmdi11);

    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void getResources() throws Exception {

    }

    public void getComponents() throws Exception {
        Components components = serviceCMD.getComponents();
        System.out.println(serviceCMD.getComponents());

    }

    public void extractService() throws Exception {

    }

    public void setServiceDescriptionLocationId() throws Exception {

    }

}