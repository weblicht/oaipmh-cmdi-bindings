package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.cmd.AbstractComponent;
import eu.clarin.weblicht.bindings.cmd.Description;
import eu.clarin.weblicht.bindings.cmd.CMDString;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.*;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Service extends AbstractComponent {

    @XmlTransient
    private static final String SHORT = "short";
    private static final CMDString RESTFULL = new CMDString("RESTfull");
    private static final CMDString DEVELOPMENT = new CMDString("development");
    @XmlElement(name = "Name", required = true)
    private CMDString name;
    @XmlElement(name = "Description", required = true)
    private List<Description> descriptions;
    @XmlTransient
    private int descriptionIndex = -1;
    @XmlTransient
    private int shortDescriptionIndex = -1;
    @XmlElement(name = "TypeOfWebservice")
    private CMDString typeOfWebservice;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    private URI url;
    @XmlElement(name = "LifeCycleStatus", required = true)
    private CMDString lifeCycleStatus;
    @XmlElement(name = "PublicationDate", required = true)
    private Calendar publicationDate;
    @XmlElement(name = "LastUpdate", required = true)
    private Calendar lastUpdate;
    @XmlElement(name = "ServiceDescriptionLocation", required = true)
    private ServiceDescriptionLocation serviceDescriptionLocation;
    @XmlElement(name = "Contact", required = true)
    private Contact contact;
    @XmlElement(name = "Creation", required = true)
    private Creation creation;
    @XmlElement(name = "Operations", required = true)
    private Operations operations;

    private Service() {
    }

    Service(Object proxyId) {
        this.typeOfWebservice = RESTFULL;
        this.lifeCycleStatus = DEVELOPMENT;
        this.publicationDate = new GregorianCalendar();
        this.serviceDescriptionLocation = new ServiceDescriptionLocation(Collections.singletonList(proxyId));
    }

    public CMDString getName() {
        return name;
    }

    public void setName(CMDString name) {
        this.name = name;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public Description getDescription() {
        if (descriptionIndex == -1) {
            initDescriptions();
        }
        return descriptions.get(descriptionIndex);
    }

    public void setDescription(String description) {
        if (descriptionIndex == -1) {
            initDescriptions();
        }
        descriptions.set(descriptionIndex, new Description(description));
    }

    public Description getShortDescription() {
        if (shortDescriptionIndex == -1) {
            initDescriptions();
        }
        return descriptions.get(shortDescriptionIndex);
    }

    public void setShortDescription(String shortDescription) {
        if (shortDescriptionIndex == -1) {
            initDescriptions();
        }
        descriptions.set(shortDescriptionIndex, new Description(SHORT, shortDescription));
    }

    private void initDescriptions() {
        if (descriptions == null) {
            descriptions = new ArrayList<Description>(2);
        } else {
            for (int i = 0; i < descriptions.size(); i++) {
                String type = descriptions.get(i).getType();
                if (type == null) {
                    descriptionIndex = i;
                } else if (type.equals(SHORT)) {
                    shortDescriptionIndex = i;
                }
            }
        }
        if (descriptionIndex == -1) {
            descriptionIndex = descriptions.size();
            descriptions.add(new Description());
        }
        if (shortDescriptionIndex == -1) {
            shortDescriptionIndex = descriptions.size();
            descriptions.add(new Description());
        }
    }

    public CMDString getTypeOfWebservice() {
        return typeOfWebservice;
    }

    public URI getUrl() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }

    public CMDString getLifeCycleStatus() {
        return lifeCycleStatus;
    }

    public void setLifeCycleStatus(CMDString lifeCycleStatus) {
        this.lifeCycleStatus = lifeCycleStatus;
    }

    public Calendar getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate() {
        publicationDate = new GregorianCalendar();
    }

    public Calendar getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate() {
        lastUpdate = new GregorianCalendar();
    }

    public ServiceDescriptionLocation getServiceDescriptionLocation() {
        return serviceDescriptionLocation;
    }

    public Contact getContact() {
        if (contact == null) {
            contact = new Contact();
        }
        return contact;
    }

    public Creation getCreation() {
        if (creation == null) {
            creation = new Creation();
        }
        return creation;
    }

    public Operations getOperations() {
        if (operations == null) {
            operations = new Operations();
        }
        return operations;
    }

    @Override
    public String toString() {
        return "Service{" + "name=" + name + ", description=" + descriptions + ", uri=" + url + ", status=" + lifeCycleStatus + ", published=" + DatatypeConverter.printDateTime(publicationDate) + ", updated=" + DatatypeConverter.printDateTime(lastUpdate) + ", contact=" + contact + " " + operations + '}';
    }

    @Override
    public Service copy() {
        Service service = (Service) super.copy();
        service.descriptions = shallowCopy(descriptions);
        service.serviceDescriptionLocation = copy(serviceDescriptionLocation);
        service.contact = copy(contact);
        service.creation = copy(creation);
        service.operations = copy(operations);
        return service;
    }
}
