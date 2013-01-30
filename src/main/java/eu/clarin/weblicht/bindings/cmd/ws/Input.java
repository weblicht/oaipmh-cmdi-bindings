package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.cmd.AbstractRefBinding;
import eu.clarin.weblicht.bindings.cmd.CMDString;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Input extends AbstractRefBinding {

    private static final CMDString GROUP_NAME = new CMDString("Input Parameters");
    @XmlElement(name = "ParameterGroup")
    private List<InputParameterGroup> parameterGroups;

    Input() {
    }

    public List<InputParameterGroup> getParameterGroups() {
        return parameterGroups;
    }

    public InputParameterGroup getFirstParameterGroup() {
        InputParameterGroup group;
        if (parameterGroups == null || parameterGroups.size() != 1) {
            group = new InputParameterGroup(GROUP_NAME);
            parameterGroups = Collections.singletonList(group);
        } else {
            group = parameterGroups.get(0);
        }
        return group;
    }

    @Override
    public Input copy() {
        Input input = (Input) super.copy();
        input.parameterGroups = copy(parameterGroups);
        return input;
    }
}
