package eu.clarin.weblicht.bindings.cmd.chains;

import eu.clarin.weblicht.bindings.cmd.AbstractDescribedComponent;
import eu.clarin.weblicht.bindings.cmd.Descriptions;
import eu.clarin.weblicht.bindings.cmd.CMDString;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"resourceName", "resourceTitle", "resourceClass", "pid", "version", "lifeCycleStatus", "startYear", "completionYear", "publicationDate", "lastUpdate", "timeCoverage", "legalOwner", "location"})
public class GeneralInfo extends AbstractDescribedComponent {

    @XmlElement(name = "ResourceName")
    private List<CMDString> resourceName;
    @XmlElement(name = "ResourceTitle")
    private List<CMDString> resourceTitle;
    @XmlElement(name = "ResourceClass", required = true)
    private List<ResourceClass> resourceClass;
    @XmlElement(name = "PID")
    private CMDString pid;
    @XmlElement(name = "Version")
    private List<CMDString> version;
    @XmlElement(name = "LifeCycleStatus")
    private LifeCycleStatus lifeCycleStatus;
    @XmlElement(name = "StartYear")
    @XmlSchemaType(name = "gYear")
    private XMLGregorianCalendar startYear;
    @XmlElement(name = "CompletionYear")
    @XmlSchemaType(name = "gYear")
    private XMLGregorianCalendar completionYear;
    @XmlElement(name = "PublicationDate")
    private CMDString publicationDate;
    @XmlElement(name = "LastUpdate")
    private CMDString lastUpdate;
    @XmlElement(name = "TimeCoverage")
    private List<CMDString> timeCoverage;
    @XmlElement(name = "LegalOwner")
    private List<CMDString> legalOwner;
    @XmlElement(name = "Location")
    private Location location;

    private GeneralInfo() {
    }

    public GeneralInfo(SimpleResourceClass resourceClass, CMDString resourceName, Descriptions descriptions) {
        super(descriptions);
        this.resourceClass = Collections.singletonList(new ResourceClass(resourceClass));
        this.resourceName = Collections.singletonList(resourceName);
    }

    public List<CMDString> getResourceName() {
        return this.resourceName;
    }

    public List<CMDString> getResourceTitle() {
        return this.resourceTitle;
    }

    public List<ResourceClass> getResourceClass() {
        return this.resourceClass;
    }

    public CMDString getPID() {
        return pid;
    }

    public List<CMDString> getVersion() {
        return this.version;
    }

    public LifeCycleStatus getLifeCycleStatus() {
        return lifeCycleStatus;
    }

    public XMLGregorianCalendar getStartYear() {
        return startYear;
    }

    public XMLGregorianCalendar getCompletionYear() {
        return completionYear;
    }

    public CMDString getPublicationDate() {
        return publicationDate;
    }

    public CMDString getLastUpdate() {
        return lastUpdate;
    }

    public List<CMDString> getTimeCoverage() {
        return this.timeCoverage;
    }

    public List<CMDString> getLegalOwner() {
        return this.legalOwner;
    }

    public Location getLocation() {
        return location;
    }
}
