// STAR-CCM+ macro: mac_5_assem.java
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;

public class mac_5_assem extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    AreaAverageReport areaAverageReport_0 = 
      simulation_0.getReportManager().createReport(AreaAverageReport.class);

    areaAverageReport_0.setPresentationName("P0");

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("StaticPressure"));

    areaAverageReport_0.setScalar(primitiveFieldFunction_0);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("cell.fluid");

    DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_0 = 
      ((DirectBoundaryInterfaceBoundary) region_0.getBoundaryManager().getBoundary("inlet [Periodic 1]"));

    areaAverageReport_0.getParts().setObjects(directBoundaryInterfaceBoundary_0);

    AreaAverageReport areaAverageReport_1 = 
      simulation_0.getReportManager().createReport(AreaAverageReport.class);

    areaAverageReport_1.setPresentationName("P1");

    areaAverageReport_1.setScalar(primitiveFieldFunction_0);

    DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_1 = 
      ((DirectBoundaryInterfaceBoundary) region_0.getBoundaryManager().getBoundary("outlet [Periodic 1]"));

    areaAverageReport_1.getParts().setObjects(directBoundaryInterfaceBoundary_1);

    ExpressionReport expressionReport_0 = 
      simulation_0.getReportManager().createReport(ExpressionReport.class);

    expressionReport_0.setPresentationName("dP");

    expressionReport_0.setDefinition("$P1Report - $P0Report");

    expressionReport_0.printReport();

    AreaAverageReport areaAverageReport_2 = 
      simulation_0.getReportManager().createReport(AreaAverageReport.class);

    PrimitiveFieldFunction primitiveFieldFunction_1 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Temperature"));

    areaAverageReport_2.setScalar(primitiveFieldFunction_1);

    DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_2 = 
      ((DirectBoundaryInterfaceBoundary) region_0.getBoundaryManager().getBoundary("wall [In-place 1]"));

    areaAverageReport_2.getParts().setObjects(directBoundaryInterfaceBoundary_2);

    areaAverageReport_2.setPresentationName("T fluid wall");

    areaAverageReport_2.printReport();

    AreaAverageReport areaAverageReport_3 = 
      simulation_0.getReportManager().createReport(AreaAverageReport.class);

    areaAverageReport_3.setScalar(primitiveFieldFunction_1);

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("cell.solid");

    DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_3 = 
      ((DirectBoundaryInterfaceBoundary) region_1.getBoundaryManager().getBoundary("wall [In-place 1]"));

    areaAverageReport_3.getParts().setObjects(directBoundaryInterfaceBoundary_3);

    areaAverageReport_3.setPresentationName("T solid wall");

    AreaAverageReport areaAverageReport_4 = 
      simulation_0.getReportManager().createReport(AreaAverageReport.class);

    areaAverageReport_4.setScalar(primitiveFieldFunction_1);

    areaAverageReport_4.getParts().setObjects(directBoundaryInterfaceBoundary_0);

    areaAverageReport_4.setPresentationName("T fluid inlet");

    AreaAverageReport areaAverageReport_5 = 
      simulation_0.getReportManager().createReport(AreaAverageReport.class);

    areaAverageReport_5.setScalar(primitiveFieldFunction_1);

    areaAverageReport_5.getParts().setObjects(directBoundaryInterfaceBoundary_1);

    areaAverageReport_5.setPresentationName("T fluid outelt");

    AreaAverageReport areaAverageReport_6 = 
      simulation_0.getReportManager().createReport(AreaAverageReport.class);

    areaAverageReport_6.setScalar(primitiveFieldFunction_1);

    Boundary boundary_0 = 
      region_1.getBoundaryManager().getBoundary("top");

    areaAverageReport_6.getParts().setObjects(boundary_0);

    areaAverageReport_6.setPresentationName("T top");

    areaAverageReport_6.printReport();

    areaAverageReport_4.printReport();

    areaAverageReport_5.printReport();

    areaAverageReport_3.printReport();
  }
}
