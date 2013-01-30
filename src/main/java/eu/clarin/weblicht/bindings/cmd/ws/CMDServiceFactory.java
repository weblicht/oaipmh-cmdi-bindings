package eu.clarin.weblicht.bindings.cmd.ws;

import eu.clarin.weblicht.bindings.cmd.CMDString;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author akislev
 */
public class CMDServiceFactory {

    public static InputParameter newInputParameter(String name, String arg, boolean required) {
        return new InputParameter(new CMDString(name), new CMDString(arg), required);
    }

    public static InputValue newInputValue(String name, String arg) {
        CMDString argBiniding = (arg == null || arg.isEmpty()) ? null : new CMDString(arg);
        return new InputValue(new CMDString(name), argBiniding);
    }

    public static OutputParameter newOutputParameter(String name, String ref) {
        CMDString refBiniding = (ref == null || ref.isEmpty()) ? null : new CMDString(ref);
        return new OutputParameter(new CMDString(name), refBiniding);
    }

    public static OutputValue newOutputValue(String name, Collection<String> refs) {
        List<CMDString> bindings = null;
        if (refs != null) {
            bindings = new ArrayList<CMDString>(refs.size());
            for (String ref : refs) {
                bindings.add(new CMDString(ref));
            }
        }
        return new OutputValue(new CMDString(name), bindings);
    }

    public static ServiceCMD newServiceCMD(URI wadlLocation) {
        return new ServiceCMD(wadlLocation);
    }
}
