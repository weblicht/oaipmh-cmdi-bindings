package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.cmd.CMDString;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author akislev
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CreationToolInfo extends AbstractToolInfo {

    @XmlElement(name = "CreationTool")
    private List<CMDString> creationTools;

    private CreationToolInfo() {
    }

    public List<CMDString> getCreationTools() {
        return creationTools;
    }

    @Override
    public CreationToolInfo copy() {
        CreationToolInfo creationToolInfo = (CreationToolInfo) super.copy();
        creationToolInfo.creationTools = shallowCopy(creationTools);
        return creationToolInfo;
    }
}
