package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.cmd.CMDString;
import javax.xml.bind.annotation.*;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
public abstract class AbstractParameterGroup extends AbstractNamedComponent {

    @XmlElement(name = "MIMEType")
    private CMDString mimeType;
    @XmlElement(name = "DataType")
    private CMDString dataType;
    @XmlElement(name = "DataCategory")
    @XmlSchemaType(name = "anyURI")
    private String dataCategory;
    @XmlElement(name = "SemanticType")
    private CMDString semanticType;

    protected AbstractParameterGroup() {
    }

    protected AbstractParameterGroup(CMDString name) {
        super(name);
    }

    public CMDString getMIMEType() {
        return mimeType;
    }

    public CMDString getDataType() {
        return dataType;
    }

    public String getDataCategory() {
        return dataCategory;
    }

    public CMDString getSemanticType() {
        return semanticType;
    }
}
