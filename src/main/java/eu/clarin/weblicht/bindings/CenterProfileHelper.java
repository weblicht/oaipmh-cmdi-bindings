package eu.clarin.weblicht.bindings;

import javax.xml.transform.Result;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class CenterProfileHelper {
    public static final String CENTER_PROFILE_2_NS = ":p_1583768728295";
    public static final String CENTER_PROFILE_1_NS = ":p_1320657629667";

    public static InputStream updateToCmdi12AndCenterProfile2(InputStream input) throws TransformerException {
        byte[] data;
        {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Result outputTarget = new StreamResult(outputStream);
            Templates templates = CMDITemplateFactory.getTemplates();
            Transformer transformer = templates.newTransformer();
            transformer.transform(new StreamSource(input), outputTarget);
            data = outputStream.toByteArray();
        }

        // For center profile: Replace the declared schema location with the
        // one of the previous version, so that the same classes can be used
        // for unmarshalling.
        // There is just a small difference in schema: the addition of
        // Metadata/OaiPmhSets and removal of Metadata/MetadataScheme,
        // Metadata/WebServicesSet and Metadata/WebServiceType
        {
            String s = new String(data, StandardCharsets.UTF_8);
            s = s.replaceAll(CENTER_PROFILE_2_NS, CENTER_PROFILE_1_NS);
            data = s.getBytes(StandardCharsets.UTF_8);
        }

        return new ByteArrayInputStream(data);
    }
}
