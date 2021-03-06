package eu.clarin.weblicht.bindings.cmd.cp;

import eu.clarin.weblicht.bindings.cmd.AbstractCMD;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "components"
})
@XmlRootElement(name = "CMD", namespace = "http://www.clarin.eu/cmd/1")
public class CenterProfileCMD extends AbstractCMD{

    @XmlElement(name = "Components", required = true, namespace = "http://www.clarin.eu/cmd/1")
    private Components components;

    public Components getComponents() {
        return components;
    }
}
