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
public class Position extends AbstractComponent {

    @XmlElement(name = "PositionType", required = true)
    private List<CMDString> positionTypes;
    @XmlElement(name = "StartPosition", required = true)
    private CMDString startPosition;
    @XmlElement(name = "EndPosition", required = true)
    private CMDString endPosition;

    public List<CMDString> getPositionTypes() {
        return positionTypes;
    }

    public CMDString getStartPosition() {
        return startPosition;
    }

    public CMDString getEndPosition() {
        return endPosition;
    }

    @Override
    public Position copy() {
        Position position = (Position) super.copy();
        position.positionTypes = shallowCopy(positionTypes);
        return position;
    }
}
