package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.cmd.AbstractDescribedComponent;
import eu.clarin.weblicht.bindings.cmd.CMDString;
import java.util.List;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Derivation extends AbstractDescribedComponent {

    @XmlElement(name = "Organisation")
    private List<CMDString> organisations;
    @XmlElement(name = "DerivationDate")
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar derivationDate;
    @XmlElement(name = "DerivationMode")
    private List<CMDString> derivationModes;
    @XmlElement(name = "DerivationType")
    private List<CMDString> derivationTypes;
    @XmlElement(name = "DerivationWorkflow")
    private List<CMDString> derivationWorkflows;
    @XmlElement(name = "DerivationToolInfo")
    private List<DerivationToolInfo> derivationToolInfos;

    public List<CMDString> getOrganisations() {
        return organisations;
    }

    public XMLGregorianCalendar getDerivationDate() {
        return derivationDate;
    }

    public List<CMDString> getDerivationModes() {
        return derivationModes;
    }

    public List<CMDString> getDerivationTypes() {
        return derivationTypes;
    }

    public List<CMDString> getDerivationWorkflows() {
        return derivationWorkflows;
    }

    public List<DerivationToolInfo> getDerivationToolInfos() {
        return derivationToolInfos;
    }

    @Override
    public Derivation copy() {
        Derivation derivation = (Derivation) super.copy();
        derivation.organisations = shallowCopy(organisations);
        if (derivationDate != null) {
            derivation.derivationDate = (XMLGregorianCalendar) derivationDate.clone();
        }
        derivation.derivationModes = shallowCopy(derivationModes);
        derivation.derivationTypes = shallowCopy(derivationTypes);
        derivation.derivationWorkflows = shallowCopy(derivationWorkflows);
        derivation.derivationToolInfos = copy(derivationToolInfos);
        return derivation;
    }
}
