package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.cmd.AbstractDescribedComponent;
import eu.clarin.weblicht.bindings.cmd.CMDString;
import java.net.URI;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Access extends AbstractDescribedComponent {

    @XmlElement(name = "Availability")
    private List<CMDString> availabilities;
    @XmlElement(name = "DistributionMedium")
    private List<CMDString> distributionMedia;
    @XmlElement(name = "CatalogueLink")
    @XmlSchemaType(name = "anyURI")
    private List<URI> catalogueLinks;
    @XmlElement(name = "Price")
    private List<CMDString> prices;
    @XmlElement(name = "DeploymentToolInfo")
    private List<DeploymentToolInfo> deploymentToolInfos;
    @XmlElement(name = "Contact", required = true)
    private List<Contact> contacts;

    private Access() {
    }

    public List<CMDString> getAvailabilities() {
        return availabilities;
    }

    public List<CMDString> getDistributionMedia() {
        return distributionMedia;
    }

    public List<URI> getCatalogueLinks() {
        return catalogueLinks;
    }

    public List<CMDString> getPrices() {
        return prices;
    }

    public List<DeploymentToolInfo> getDeploymentToolInfos() {
        return deploymentToolInfos;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public Access copy() {
        Access access = (Access) super.copy();
        access.availabilities = shallowCopy(availabilities);
        access.distributionMedia = shallowCopy(distributionMedia);
        access.catalogueLinks = shallowCopy(catalogueLinks);
        access.prices = shallowCopy(prices);
        access.deploymentToolInfos = copy(deploymentToolInfos);
        access.contacts = copy(contacts);
        return access;
    }
}
