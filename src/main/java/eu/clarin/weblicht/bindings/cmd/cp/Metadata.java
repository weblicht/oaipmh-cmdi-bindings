package eu.clarin.weblicht.bindings.cmd.cp;

import eu.clarin.weblicht.bindings.cmd.AbstractRefBinding;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"metadataScheme", "webServicesSet", "webServiceType", "oaiAccessPoint", "oaiPmhSets"})
public class Metadata extends AbstractRefBinding {

    @XmlElement(name = "MetadataScheme")
    private List<MetadataScheme> metadataScheme;
    @XmlElement(name = "WebServicesSet")
    private String webServicesSet;
    @XmlElement(name = "WebServiceType")
    private List<WebServiceType> webServiceType;
    @XmlElement(name = "OaiAccessPoint", required = true)
    @XmlSchemaType(name = "anyURI")
    private URI oaiAccessPoint;
    @XmlElement(name = "OaiPmhSets")
    protected OaiPmhSets oaiPmhSets;

    public List<MetadataScheme> getMetadataScheme() {
        if (metadataScheme == null) {
            metadataScheme = new ArrayList<MetadataScheme>();
        }
        return this.metadataScheme;
    }

    public String getWebServicesSet() {
        return webServicesSet;
    }

    public List<WebServiceType> getWebServiceType() {
        if (webServiceType == null) {
            webServiceType = new ArrayList<WebServiceType>();
        }
        return this.webServiceType;
    }

    public URI getOaiAccessPoint() {
        return oaiAccessPoint;
    }

    public OaiPmhSets getOaiPmhSets() {
        return oaiPmhSets;
    }
}
