package eu.clarin.weblicht.bindings.cmd.cp;

import eu.clarin.weblicht.bindings.cmd.AbstractComponent;
import eu.clarin.weblicht.bindings.cmd.CMDString;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"organisationName", "institution", "workingUnit", "code", "postAddress", "expertise"})
public class ClarinOrganisationInfo extends AbstractComponent {

    @XmlElement(name = "OrganisationName", required = true)
    private List<CMDString> organisationName;
    @XmlElement(name = "Institution", required = true)
    private List<CMDString> institution;
    @XmlElement(name = "WorkingUnit", required = true)
    private List<CMDString> workingUnit;
    @XmlElement(name = "Code", required = true)
    private String code;
    @XmlElement(name = "PostAddress", required = true)
    private String postAddress;
    @XmlElement(name = "Expertise", required = true)
    private String expertise;

    public List<CMDString> getOrganisationName() {
        return this.organisationName;
    }

    public List<CMDString> getInstitution() {
        return this.institution;
    }

    public List<CMDString> getWorkingUnit() {
        return this.workingUnit;
    }

    public String getCode() {
        return code;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public String getExpertise() {
        return expertise;
    }
}
