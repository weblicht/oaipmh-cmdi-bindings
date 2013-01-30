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
public class InputParameters extends AbstractParameters<InputParameter> {

    @XmlElement(name = "Parameter", required = true)
    private List<InputParameter> parameters;

    InputParameters() {
    }

    @Override
    protected List<InputParameter> getParameters() {
        return parameters;
    }

    public boolean add(InputParameter parameter) {
        if (parameters == null) {
            parameters = new ArrayList<InputParameter>();

        }
        return parameters.add(parameter);
    }

    @Override
    public InputParameters copy() {
        InputParameters params = (InputParameters) super.copy();
        params.parameters = copy(parameters);
        return params;
    }
}
