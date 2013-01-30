package eu.clarin.weblicht.bindings.cmd.chains;

import eu.clarin.weblicht.bindings.cmd.AbstractComponent;
import eu.clarin.weblicht.bindings.cmd.CMDString;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"address", "region", "continentName", "country"})
public class Location extends AbstractComponent {

    @XmlElement(name = "Address")
    private List<CMDString> address;
    @XmlElement(name = "Region")
    private List<CMDString> region;
    @XmlElement(name = "ContinentName")
    private List<CMDString> continentName;
    @XmlElement(name = "Country", required = true)
    private Country country;

    private Location() {
    }

    public List<CMDString> getAddress() {
        return this.address;
    }

    public List<CMDString> getRegion() {
        return this.region;
    }

    public List<CMDString> getContinentName() {
        return this.continentName;
    }

    public Country getCountry() {
        return country;
    }
}
