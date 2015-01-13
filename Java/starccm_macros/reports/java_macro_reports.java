// STAR-CCM+ macro: java_macro_reports.java
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;
import star.flow.*;

public class java_macro_reports extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = getActiveSimulation();

	AreaAverageReport areaAverageReport_ttop = MyStarCreateReport("AreaAverageReport","ttop","Temperature",boundary_top);
	
	
	
  }
	private Report MyStarCreateReport(String type,String name,String fieldFunction,Boundary boundary) {
		Report report;
		PrimitiveFieldFunction primitiveFieldFunction = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Temperature"));
		boolean isExpression = false;
		switch (type) {
			case "AreaAverageReport":
				report = simulation_0.getReportManager().createReport(AreaAverageReport.class);
				break;
			case "MassFlowAverageReport":
				report = simulation_0.getReportManager().createReport(MassFlowAverageReport.class);
				break;
			case "Expression":
				report = simulation_0.getReportManager().createReport(ExpressionReport.class);
				isExpression = true;
				break;
			default:
				break;
		}
		if (isExpression) {
			report.setDefinition(fieldFunction);
		} else {
			primitiveFieldFunction = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction(fieldFunction));
			report.setScalar(primitiveFieldFunction);
			report.getParts().setObjects(boundary);
		}
		report.setPresentationName(name);
		return report;
	}
}
