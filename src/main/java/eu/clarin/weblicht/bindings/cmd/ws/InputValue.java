package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.cmd.CMDString;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
public class InputValue extends AbstractValue {

    @XmlElement(name = "WebServiceArgValue")
    private CMDString webServiceArgValue;

    private InputValue() {
    }

    InputValue(CMDString value, CMDString webServiceArgValue) {
        super(value);
        this.webServiceArgValue = webServiceArgValue;
    }

    public CMDString getWebServiceArgValue() {
        return webServiceArgValue;
    }

    @Override
    public String toString() {
        if (webServiceArgValue != null) {
            return getValue() + "(param=" + webServiceArgValue + ")";
        } else {
            return getValue().toString();
        }
    }
}
