package eu.clarin.weblicht.bindings.cmd.cp;

import org.junit.Test;

import java.util.List;

import static eu.clarin.weblicht.bindings.cmd.cp.CenterProfileTest.unmarshallCenterProfileCMD;
import static org.junit.Assert.assertEquals;

public class CenterProfile2Test {
    @Test
    public void testCmdi11() throws Exception {
        CenterProfileCMD centerProfileCMD = unmarshallCenterProfileCMD("centerProfile2.xml");

        String name = centerProfileCMD.getComponents().getCenterProfile().getCenterBasicInformation().getName().get(0).getValue();
        assertEquals("Bayerisches Archiv für Sprachsignale", name);

        List<Metadata> metadata = centerProfileCMD.getComponents().getCenterProfile().getCenterExtendedInformation().getMetadata();
        for (Metadata md : metadata) {
            System.out.println("old: set=" + md.getWebServicesSet() + "; type=" + md.getWebServiceType());
            System.out.println("new: sets");
            md.getOaiPmhSets().getSet().forEach(s ->
                    System.out.println("\ttype: " + s.getSetType() + "; spec: " + s.getSetSpec()));
        }
    }
}
