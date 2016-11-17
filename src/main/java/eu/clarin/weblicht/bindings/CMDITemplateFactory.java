package eu.clarin.weblicht.bindings;


import net.sf.saxon.TransformerFactoryImpl;

import javax.xml.transform.Templates;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;

/**
 * Created by wqiu on 05/12/16.
 */
public class CMDITemplateFactory {
    private final static String resourceURL = "cmd-record-1_1-to-1_2.xsl";

    private static Templates templates = null;

    public static Templates getTemplates() throws TransformerConfigurationException {
        if (templates != null) {
            return templates;
        }  else {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream xsltStream = classLoader.getResourceAsStream(resourceURL);
            StreamSource xslt = new StreamSource(xsltStream);
            TransformerFactory tf = new TransformerFactoryImpl();
            return  tf.newTemplates(xslt);
        }
    }
}
