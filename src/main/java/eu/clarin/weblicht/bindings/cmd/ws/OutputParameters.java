package eu.clarin.weblicht.bindings.cmd.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author akislev
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
public class OutputParameters extends AbstractParameters<OutputParameter> {

    @XmlElement(name = "Parameter", required = true)
    private List<OutputParameter> parameters;

    OutputParameters() {
    }

    @Override
    protected List<OutputParameter> getParameters() {
        return parameters;
    }

    public boolean add(OutputParameter parameter) {
        if (parameters == null) {
            parameters = new ArrayList<OutputParameter>();

        }
        return parameters.add(parameter);
    }

    @Override
    public OutputParameters copy() {
        OutputParameters params = (OutputParameters) super.copy();
        params.parameters = copy(parameters);
        return params;
    }
}
