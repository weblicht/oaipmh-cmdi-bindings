package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.cmd.AbstractComponent;
import eu.clarin.weblicht.bindings.cmd.Descriptions;
import eu.clarin.weblicht.bindings.cmd.CMDString;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author akislev
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "persons",
    "roles",
    "addresses",
    "emails",
    "departments",
    "organisations",
    "telephoneNumbers",
    "faxNumbers",
    "urls",
    "descriptions"
})
public class Contact extends AbstractComponent {

    @XmlElement(name = "Person")
    private List<CMDString> persons;
    @XmlElement(name = "Role")
    private List<CMDString> roles;
    @XmlElement(name = "Address")
    private List<CMDString> addresses;
    @XmlElement(name = "Email")
    private List<CMDString> emails;
    @XmlElement(name = "Department")
    private List<CMDString> departments;
    @XmlElement(name = "Organisation")
    private List<CMDString> organisations;
    @XmlElement(name = "TelephoneNumber")
    private List<CMDString> telephoneNumbers;
    @XmlElement(name = "FaxNumber")
    private List<CMDString> faxNumbers;
    @XmlElement(name = "Url")
    @XmlSchemaType(name = "anyURI")
    private List<URI> urls;
    @XmlElement(name = "Descriptions")
    private Descriptions descriptions;

    Contact() {
    }

    public List<CMDString> getPersons() {
        return persons;
    }

    public List<CMDString> getRoles() {
        return roles;
    }

    public List<CMDString> getAddresses() {
        return addresses;
    }

    public List<CMDString> getEmails() {
        return emails;
    }

    public CMDString getEmail() {
        if (emails != null && emails.size() > 0) {
            return emails.get(0);
        } else {
            return new CMDString();
        }
    }

    public void setEmail(CMDString email) {
        emails = Collections.singletonList(email);
    }

    public List<CMDString> getDepartments() {
        return departments;
    }

    public List<CMDString> getOrganisations() {
        return organisations;
    }

    public CMDString getOrganisation() {
        if (organisations != null && organisations.size() > 0) {
            return organisations.get(0);
        } else {
            return new CMDString();
        }
    }

    public void setOrganisation(CMDString organisation) {
        organisations = Collections.singletonList(organisation);
    }

    public List<CMDString> getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public List<CMDString> getFaxNumbers() {
        return faxNumbers;
    }

    public List<URI> getUrls() {
        return urls;
    }

    public Descriptions getDescriptions() {
        return descriptions;
    }

    @Override
    public String toString() {
        if (persons != null && persons.size() == 1) {
            return persons.get(0).getValue();
        } else if (emails != null && emails.size() == 1) {
            return emails.get(0).getValue();
        } else if (organisations != null && organisations.size() == 1) {
            return organisations.get(0).getValue();
        } else if (urls != null && urls.size() == 1) {
            return urls.get(0).toString();
        } else {
            return null;
        }
    }

    @Override
    public Contact copy() {
        Contact contact = (Contact) super.copy();
        contact.persons = shallowCopy(persons);
        contact.roles = shallowCopy(roles);
        contact.addresses = shallowCopy(addresses);
        contact.emails = shallowCopy(emails);
        contact.departments = shallowCopy(departments);
        contact.organisations = shallowCopy(organisations);
        contact.telephoneNumbers = shallowCopy(telephoneNumbers);
        contact.faxNumbers = shallowCopy(faxNumbers);
        contact.urls = shallowCopy(urls);
        contact.descriptions = copy(descriptions);
        return contact;
    }
}
