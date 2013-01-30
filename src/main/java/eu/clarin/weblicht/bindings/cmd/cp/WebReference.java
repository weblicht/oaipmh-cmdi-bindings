package eu.clarin.weblicht.bindings.cmd.cp;

import eu.clarin.weblicht.bindings.cmd.AbstractComponent;
import eu.clarin.weblicht.bindings.cmd.CMDString;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"website", "description"})
public class WebReference extends AbstractComponent {

    @XmlElement(name = "Website", required = true)
    @XmlSchemaType(name = "anyURI")
    private String website;
    @XmlElement(name = "Description", required = true)
    private List<CMDString> description;

    public String getWebsite() {
        return website;
    }

    public List<CMDString> getDescription() {
        return description;
    }
}
