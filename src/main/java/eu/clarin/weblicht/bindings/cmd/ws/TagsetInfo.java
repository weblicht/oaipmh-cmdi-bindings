package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.cmd.AbstractDescribedComponent;
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
public class TagsetInfo extends AbstractDescribedComponent {

    @XmlElement(name = "Tagset")
    private List<CMDString> tagsets;

    private TagsetInfo() {
    }

    public List<CMDString> getTagset() {
        return tagsets;
    }

    @Override
    public TagsetInfo copy() {
        TagsetInfo tagsetInfo = (TagsetInfo) super.copy();
        tagsetInfo.tagsets = shallowCopy(tagsets);
        return tagsetInfo;
    }
}
