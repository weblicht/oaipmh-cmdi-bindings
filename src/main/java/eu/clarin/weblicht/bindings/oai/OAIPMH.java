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
public class OAIPMH {

    @XmlElement
    private Calendar responseDate;
    @XmlElement
    private Request request;
    @XmlElement
    private String error;
    @XmlElementWrapper(name = "ListRecords")
    @XmlElement(name = "record")
    private List<Record> records;

    private OAIPMH() {
    }

    public OAIPMH(List<Record> records, URI url) {
        this.responseDate = new GregorianCalendar();
        this.request = new Request("ListRecords", "cmdi", url);
        this.records = records;
    }

    public List<Record> getRecords() {
        return records;
    }

    public String getError() {
        return error;
    }

    public Request getRequest() {
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
