package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.cmd.AbstractRefBinding;
import eu.clarin.weblicht.bindings.cmd.CMDString;
import java.net.URI;
import javax.xml.bind.annotation.*;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
public abstract class AbstractValue extends AbstractRefBinding {

    @XmlElement(name = "Value", required = true)
    private CMDString value;
    @XmlElement(name = "Description")
    private CMDString description;
    @XmlElement(name = "DataCategory")
    @XmlSchemaType(name = "anyURI")
    private URI dataCategory;

    protected AbstractValue() {
    }

    protected AbstractValue(CMDString value) {
        this.value = value;
    }

    public CMDString getValue() {
        return value;
    }

    public CMDString getDescription() {
        return description;
    }

    public URI getDataCategory() {
        return dataCategory;
    }
}
