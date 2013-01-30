package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.cmd.CMDString;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
public class AnnotationToolInfo extends AbstractToolInfo {

    @XmlElement(name = "AnnotationTool")
    private List<CMDString> annotationTools;

    private AnnotationToolInfo() {
    }

    public List<CMDString> getAnnotationTools() {
        return annotationTools;
    }

    @Override
    public AnnotationToolInfo copy() {
        AnnotationToolInfo annotationToolInfo = (AnnotationToolInfo) super.copy();
        annotationToolInfo.annotationTools = shallowCopy(annotationTools);
        return annotationToolInfo;
    }
}
