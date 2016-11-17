package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.cmd.Copyable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlRootElement(name = "cmd", namespace = "http://www.clarin.eu/cmd/1/")
public class Components extends Copyable {

    @XmlElement(name = "WebLichtWebService", required = true)
    private WebLichtWebService webLichtWebService;

    private Components() {
    }

    Components(Object proxyId) {
        webLichtWebService = new WebLichtWebService(proxyId);
    }

    public WebLichtWebService getWebLichtWebService() {
        return webLichtWebService;
    }

    @Override
    public Components copy() {
        Components components = (Components) super.copy();
        components.webLichtWebService = copy(webLichtWebService);
        return components;
    }
}
