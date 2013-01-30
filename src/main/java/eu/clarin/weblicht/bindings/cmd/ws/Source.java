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
@XmlAccessorType(XmlAccessType.FIELD)
public class Source extends AbstractDescribedComponent {

    @XmlElement(name = "OriginalSource")
    private List<CMDString> originalSources;
    @XmlElement(name = "SourceType")
    private List<CMDString> sourceTypes;
    @XmlElement(name = "MediaFiles")
    private MediaFiles mediaFiles;
    @XmlElement(name = "Derivation")
    private Derivation derivation;

    private Source() {
    }

    public List<CMDString> getOriginalSources() {
        return this.originalSources;
    }

    public List<CMDString> getSourceTypes() {
        return this.sourceTypes;
    }

    public MediaFiles getMediaFiles() {
        return mediaFiles;
    }

    public Derivation getDerivation() {
        return derivation;
    }

    @Override
    public Source copy() {
        Source source = (Source) super.copy();
        source.originalSources = shallowCopy(originalSources);
        source.sourceTypes = shallowCopy(sourceTypes);
        source.mediaFiles = copy(mediaFiles);
        source.derivation = copy(derivation);
        return source;
    }
}
