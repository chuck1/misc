// STAR-CCM+ macro: mac_1.java
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;

public class mac_1 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    ExpressionReport expressionReport_0 = 
      simulation_0.getReportManager().createReport(ExpressionReport.class);

    expressionReport_0.setDimensionsVector(new IntVector(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    expressionReport_0.setDefinition("$SurfaceAverage2Report - $SurfaceAverage3Reprot");

    expressionReport_0.setDimensionsVector(new IntVector(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    expressionReport_0.setDefinition("$SurfaceAverage2Report - $SurfaceAverage3Report\n");

    expressionReport_0.printReport();

    ReportMonitor reportMonitor_0 = 
      expressionReport_0.createMonitor();

    MonitorPlot monitorPlot_0 = 
      simulation_0.getPlotManager().createMonitorPlot();

    monitorPlot_0.setPresentationName("Expression 1 Monitor Plot");

    monitorPlot_0.getMonitors().addObjects(reportMonitor_0);

    Axes axes_1 = 
      monitorPlot_0.getAxes();

    Axis axis_2 = 
      axes_1.getXAxis();

    AxisTitle axisTitle_0 = 
      axis_2.getTitle();

    axisTitle_0.setText("Iteration");

    Axis axis_3 = 
      axes_1.getYAxis();

    AxisTitle axisTitle_1 = 
      axis_3.getTitle();

    axisTitle_1.setText("Expression");
  }
}
