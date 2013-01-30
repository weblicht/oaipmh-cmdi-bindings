package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.cmd.AbstractDescribedComponent;
import eu.clarin.weblicht.bindings.cmd.CMDString;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
public abstract class AbstractToolInfo extends AbstractDescribedComponent {

    @XmlElement(name = "ToolType")
    private List<CMDString> toolTypes;
    @XmlElement(name = "Version")
    private List<CMDString> versions;
    @XmlElement(name = "Url")
    @XmlSchemaType(name = "anyURI")
    private List<URI> urls;

    protected AbstractToolInfo() {
    }

    public List<CMDString> getToolTypes() {
        return toolTypes;
    }

    public List<CMDString> getVersions() {
        return versions;
    }

    public List<URI> getUrls() {
        return urls;
    }

    @Override
    public AbstractToolInfo copy() {
        AbstractToolInfo toolInfo = (AbstractToolInfo) super.copy();
        toolInfo.toolTypes = shallowCopy(toolTypes);
        toolInfo.versions = shallowCopy(versions);
        if (toolInfo.urls != null) {
            toolInfo.urls = new ArrayList<URI>(urls);
        }
        return toolInfo;
    }
}
