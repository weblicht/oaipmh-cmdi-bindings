package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.cmd.CMDString;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
public class DeploymentToolInfo extends AbstractToolInfo {

    @XmlElement(name = "DeploymentTool")
    private List<CMDString> deploymentTools;

    private DeploymentToolInfo() {
    }

    public List<CMDString> getDeploymentTools() {
        return this.deploymentTools;
    }

    @Override
    public DeploymentToolInfo copy() {
        DeploymentToolInfo deploymentToolInfo = (DeploymentToolInfo) super.copy();
        deploymentToolInfo.deploymentTools = shallowCopy(deploymentTools);
        return deploymentToolInfo;
    }
}
