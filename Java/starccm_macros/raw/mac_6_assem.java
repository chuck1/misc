// STAR-CCM+ macro: mac_6_assem.java
package macro;

import java.util.*;

import star.common.*;

public class mac_6_assem extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("cell.fluid");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("symmetry");

    boundary_0.setBoundaryType(SymmetryBoundary.class);

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("cell.solid");

    Boundary boundary_1 = 
      region_1.getBoundaryManager().getBoundary("symmetry");

    boundary_1.setBoundaryType(SymmetryBoundary.class);
  }
}
