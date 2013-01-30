package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.cmd.AbstractRefBinding;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author akislev
 */
public abstract class AbstractParameters<P> extends AbstractRefBinding implements Iterable<P> {

    protected abstract List<P> getParameters();

    public void clear() {
        List<P> parameters = getParameters();
        if (parameters != null) {
            parameters.clear();
        }
    }

    public Iterator<P> iterator() {
        List<P> parameters = getParameters();
        if (parameters == null) {
            return Collections.<P>emptyList().iterator();
        }
        return parameters.iterator();
    }
}
