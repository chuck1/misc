// STAR-CCM+ macro: java_macro4.java
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;
import star.flow.*;

public class java_macro4 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = getActiveSimulation();

    
    
    DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_0 = ((DirectBoundaryInterfaceBoundary) region_0.getBoundaryManager().getBoundary("pin_cell.outlet [Periodic 1]"));
	
	PrimitiveFieldFunction primitiveFieldFunction_0 = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Temperature"));
	
	
    AreaAverageReport areaAverageReport_0 = simulation_0.getReportManager().createReport(AreaAverageReport.class);
    areaAverageReport_0.getParts().setObjects(boundary_0);
    areaAverageReport_0.setScalar(primitiveFieldFunction_0);
    areaAverageReport_0.setPresentationName("twall");

    MassFlowAverageReport massFlowAverageReport_0 = simulation_0.getReportManager().createReport(MassFlowAverageReport.class);
    massFlowAverageReport_0.setScalar(primitiveFieldFunction_0);
    massFlowAverageReport_0.getParts().setObjects(directBoundaryInterfaceBoundary_0);
    massFlowAverageReport_0.setPresentationName("tout");

    ReportMonitor reportMonitor_0 = areaAverageReport_0.createMonitor();
    MonitorPlot monitorPlot_0 = simulation_0.getPlotManager().createMonitorPlot();
    monitorPlot_0.setPresentationName("twall Monitor Plot");
    monitorPlot_0.getMonitors().addObjects(reportMonitor_0);

    Axes axes_0 = monitorPlot_0.getAxes();
    Axis axis_0 = axes_0.getXAxis();
    AxisTitle axisTitle_0 = axis_0.getTitle();
    axisTitle_0.setText("Iteration");
    Axis axis_1 = axes_0.getYAxis();
    AxisTitle axisTitle_1 = axis_1.getTitle();
    axisTitle_1.setText("Surface Average of Temperature (K)");
  }
}
