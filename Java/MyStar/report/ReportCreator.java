// STAR-CCM+ macro: ReportCreator.java
package MyStar.report;

import java.util.*;
import java.lang.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.base.report.*;
import star.meshing.*;
import star.flow.*;

public class ReportCreator {
	public static Report MyStarCreateReport(Simulation simulation_0,String type,String name,String fieldFunction,Boundary boundary) {
		Report report = null;
		PrimitiveFieldFunction primitiveFieldFunction = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Temperature"));
		boolean isExpression = false;
		if (type.equals("AreaAverageReport")) {
			report = simulation_0.getReportManager().createReport(AreaAverageReport.class);
		} else if (type.equals("MassFlowAverageReport")) {
			report = simulation_0.getReportManager().createReport(MassFlowAverageReport.class);
		} else if (type.equals("Expression")) {
			report = simulation_0.getReportManager().createReport(ExpressionReport.class);
			isExpression = true;
		} else {
		
		}
		
		if (isExpression) {
			((ExpressionReport) report).setDefinition(fieldFunction);
		} else {
			primitiveFieldFunction = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction(fieldFunction));
			((ScalarReport) report).setScalar(primitiveFieldFunction);
			((AnalysisReport) report).getParts().setObjects(boundary);
		}
		report.setPresentationName(name);
		return report;
	}
}
