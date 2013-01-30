package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.cmd.AbstractComponent;
import eu.clarin.weblicht.bindings.cmd.CMDString;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Keys extends AbstractComponent {

    @XmlElement(name = "Key", required = true)
    private List<CMDString> keys;

    private Keys() {
    }

    public List<CMDString> getKeys() {
        return keys;
    }

    @Override
    public Keys copy() {
        Keys k = (Keys) super.copy();
        k.keys = shallowCopy(keys);
        return k;
    }
}
