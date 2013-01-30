package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.cmd.AbstractComponent;
import eu.clarin.weblicht.bindings.cmd.CMDString;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
public abstract class AbstractNamedComponent extends AbstractComponent {

    @XmlElement(name = "Name", required = true)
    private CMDString name;
    @XmlElement(name = "Description")
    private CMDString description;

    protected AbstractNamedComponent() {
    }

    protected AbstractNamedComponent(CMDString name) {
        this.name = name;
    }

    public CMDString getName() {
        return name;
    }

    public CMDString getDescription() {
        return description;
    }
}
