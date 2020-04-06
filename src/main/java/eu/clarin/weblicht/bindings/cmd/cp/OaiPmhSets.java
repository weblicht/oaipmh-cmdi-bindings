package eu.clarin.weblicht.bindings.cmd.cp;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "set"
})
public class OaiPmhSets {

    @XmlElement(name = "Set", required = true)
    protected List<OaiPmhSets.Set> set;
    @XmlAttribute(name = "ref")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected List<Object> ref;

    public List<OaiPmhSets.Set> getSet() {
        if (set == null) {
            set = new ArrayList<OaiPmhSets.Set>();
        }
        return this.set;
    }

    public List<Object> getRef() {
        if (ref == null) {
            ref = new ArrayList<Object>();
        }
        return this.ref;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "setSpec",
        "setType"
    })
    public static class Set {

        @XmlElement(name = "SetSpec", required = true)
        protected String setSpec;
        @XmlElement(name = "SetType", required = true)
        protected String setType;
        @XmlAttribute(name = "ref")
        @XmlIDREF
        @XmlSchemaType(name = "IDREFS")
        protected List<Object> ref;

        public String getSetSpec() {
            return setSpec;
        }

        public void setSetSpec(String value) {
            this.setSpec = value;
        }

        public String getSetType() {
            return setType;
        }

        public void setSetType(String value) {
            this.setType = value;
        }

        public List<Object> getRef() {
            if (ref == null) {
                ref = new ArrayList<Object>();
            }
            return this.ref;
        }

    }

}
