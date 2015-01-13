// STAR-CCM+ macro: java_macro3extra.java
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;

public class java_macro3extra extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    SumReport sumReport_0 = 
      simulation_0.getReportManager().createReport(SumReport.class);

    sumReport_0.setPresentationName("areaWall");

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Area"));

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = 
      ((VectorMagnitudeFieldFunction) primitiveFieldFunction_0.getMagnitudeFunction());

    sumReport_0.setScalar(vectorMagnitudeFieldFunction_0);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region 1");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("pin_cell.wall");

    sumReport_0.getParts().setObjects(boundary_0);

    sumReport_0.printReport();
  }
}
