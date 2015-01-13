// STAR-CCM+ macro: mac_in_mac.java
package macro;

import java.util.*;

import star.common.*;

public class mac_in_mac extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    new StarScript(getActiveSimulation(),

                   new java.io.File(resolvePath("Windows.Documents/My Documents/mac_harmless.java"))).play();

  }
}
