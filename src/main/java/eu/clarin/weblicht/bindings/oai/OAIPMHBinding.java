package eu.clarin.weblicht.bindings.oai;

import java.net.URI;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author akislev
 */
@XmlRootElement(name = "OAI-PMH")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"responseDate", "request", "error", "records"})
public class OAIPMHBinding {

    @XmlElement
    private Calendar responseDate;
    @XmlElement
    private RequestBinding request;
    @XmlElement
    private String error;
    @XmlElementWrapper(name = "ListRecords")
    @XmlElement(name = "record")
    private List<RecordBinding> records;

    private OAIPMHBinding() {
    }

    public OAIPMHBinding(List<RecordBinding> records, URI url) {
        this.responseDate = new GregorianCalendar();
        this.request = new RequestBinding("ListRecords", "cmdi", url);
        this.records = records;
    }

    public List<RecordBinding> getRecords() {
        return records;
    }

    public String getError() {
        return error;
    }

    public RequestBinding getRequest() {
        return request;
    }

    public Calendar getResponseDate() {
        return responseDate;
    }

    @Override
    public String toString() {
        return "OAI-PMH{" + "responseDate=" + responseDate + ", request=" + request + ", records=" + records + '}';
    }
}
