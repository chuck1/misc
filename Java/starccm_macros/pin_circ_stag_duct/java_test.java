// STAR-CCM+ macro: java_test.java
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.meshing.*;

public class java_test extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    CompositePart compositePart_0 = 
      ((CompositePart) simulation_0.get(SimulationPartManager.class).getPart("Assembly 1"));

    CadPart cadPart_0 = 
      ((CadPart) compositePart_0.getChildParts().getPart("pin_duct"));

    cadPart_0.setPresentationName("fluid");
  }
}
