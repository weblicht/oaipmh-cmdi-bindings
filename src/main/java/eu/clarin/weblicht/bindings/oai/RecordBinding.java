package eu.clarin.weblicht.bindings.oai;

import eu.clarin.weblicht.bindings.cmd.ws.ServiceCMD;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author akislev
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"header", "metadata"})
public class RecordBinding {

    @XmlElement
    private HeaderBinding header;
    @XmlElementWrapper(name = "metadata")
    @XmlElement(name = "CMD", namespace = "http://www.clarin.eu/cmd/")
    private List<ServiceCMD> metadata;

    protected RecordBinding() {
    }

    public RecordBinding(HeaderBinding header, ServiceCMD cmd) {
        this.header = header;
        this.metadata = Collections.singletonList(cmd);
    }

    public HeaderBinding getHeader() {
        return header;
    }

    public List<ServiceCMD> getMetadata() {
        return metadata;
    }

    public ServiceCMD getCMD() {
        return (metadata != null && metadata.size() == 1) ? metadata.get(0) : null;
    }

    @Override
    public String toString() {
        return "Record{" + "header=" + header + ", metadata=" + metadata + '}';
    }
}
