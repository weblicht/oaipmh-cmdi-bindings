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
public class AnnotationType extends AbstractDescribedComponent {

    @XmlElement(name = "AnnotationLevelType", required = true)
    private List<CMDString> annotationLevelTypes;
    @XmlElement(name = "AnnotationMode")
    private List<CMDString> annotationModes;
    @XmlElement(name = "TagsetInfo")
    private TagsetInfo tagsetInfo;

    private AnnotationType() {
    }

    public List<CMDString> getAnnotationLevelTypes() {
        return annotationLevelTypes;
    }

    public List<CMDString> getAnnotationModes() {
        return annotationModes;
    }

    public TagsetInfo getTagsetInfo() {
        return tagsetInfo;
    }

    @Override
    public AnnotationType copy() {
        AnnotationType annotationType = (AnnotationType) super.copy();
        annotationType.annotationLevelTypes = shallowCopy(annotationLevelTypes);
        annotationType.annotationModes = shallowCopy(annotationModes);
        annotationType.tagsetInfo = copy(tagsetInfo);
        return annotationType;
    }
}
