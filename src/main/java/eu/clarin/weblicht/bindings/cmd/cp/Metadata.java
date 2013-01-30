package eu.clarin.weblicht.bindings.cmd.cp;

import eu.clarin.weblicht.bindings.cmd.AbstractRefBinding;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"metadataScheme", "webServicesSet", "webServiceType", "oaiAccessPoint"})
public class Metadata extends AbstractRefBinding {

    @XmlElement(name = "MetadataScheme", required = true)
    private List<ComplextypeMetadataScheme> metadataScheme;
    @XmlElement(name = "WebServicesSet")
    private String webServicesSet;
    @XmlElement(name = "WebServiceType")
    private List<ComplextypeWebServiceType> webServiceType;
    @XmlElement(name = "OaiAccessPoint", required = true)
    @XmlSchemaType(name = "anyURI")
    private String oaiAccessPoint;

    public List<ComplextypeMetadataScheme> getMetadataScheme() {
        if (metadataScheme == null) {
            metadataScheme = new ArrayList<ComplextypeMetadataScheme>();
        }
        return this.metadataScheme;
    }

    public String getWebServicesSet() {
        return webServicesSet;
    }

    public List<ComplextypeWebServiceType> getWebServiceType() {
        if (webServiceType == null) {
            webServiceType = new ArrayList<ComplextypeWebServiceType>();
        }
        return this.webServiceType;
    }

    public String getOaiAccessPoint() {
        return oaiAccessPoint;
    }
}
