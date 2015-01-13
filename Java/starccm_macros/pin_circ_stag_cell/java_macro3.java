// STAR-CCM+ macro: java_macro3.java
package macro;

import java.util.*;

import java.lang.*;
import star.cadmodeler.*;

import star.material.*;
import star.common.*;
import star.base.neo.*;
import star.segregatedenergy.*;
import star.energy.*;
import star.base.report.*;
import star.flow.*;


public class java_macro3 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = getActiveSimulation();
	
	
	String session_abs_dir = simulation_0.getSessionDir();
	String session_dir = session_abs_dir.substring(session_abs_dir.lastIndexOf('/') + 1);
	String savePath = session_abs_dir + "/sim.sim";
	
	
	
	simulation_0.println(session_abs_dir);
	
	
	CsvReader csvReader_0 = new CsvReader(session_abs_dir+"/csv_param.csv",3);
	
	Collection<java.lang.String> strings_0 = csvReader_0.getValues();
	
	Iterator iterator = strings_0.iterator();
	double D = Double.parseDouble(iterator.next().toString());
	double P_T = Double.parseDouble(iterator.next().toString());
	double massFlowRate = Double.parseDouble(iterator.next().toString());
	
	double S_T = P_T*D;
	double G = S_T-D;
	double S_L = (3^(1/2))/2*S_T;
	
	double A_hs = S_T*S_L;
	double A_wall;
	double heatFlux;
	
	double qpp = 1e6;
	
	double cp = 1.2317e+03;
	double k = 6.297913e-02;
	double TurbulentPr = 1;
	double T_av = 848.15;
	
	
	// report
	Region region_0 = simulation_0.getRegionManager().getRegion("Region 1");
    Boundary boundary_0 = region_0.getBoundaryManager().getBoundary("pin_cell.wall");
	
	
	PrimitiveFieldFunction primitiveFieldFunction_0 = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Area"));
	
	
	SumReport sumReport_0 = simulation_0.getReportManager().createReport(SumReport.class);
    sumReport_0.setPresentationName("areaWall");
    
    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = ((VectorMagnitudeFieldFunction) primitiveFieldFunction_0.getMagnitudeFunction());
    sumReport_0.setScalar(vectorMagnitudeFieldFunction_0);
    
    sumReport_0.getParts().setObjects(boundary_0);
    sumReport_0.printReport();
	
	
	
	
	A_wall = sumReport_0.getValue();
	heatFlux = qpp*A_hs/A_wall/2;
	
	// physics models
    PhysicsContinuum physicsContinuum_0 = ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("Physics 1"));
    physicsContinuum_0.enable(SegregatedFluidTemperatureModel.class);

	// fluid properties
    SingleComponentGasModel singleComponentGasModel_0 = physicsContinuum_0.getModelManager().getModel(SingleComponentGasModel.class);
    Gas gas_0 = ((Gas) singleComponentGasModel_0.getMaterial());
	
    ConstantSpecificHeat constantSpecificHeat_0 = ((ConstantSpecificHeat) gas_0.getMaterialProperties().getMaterialProperty(SpecificHeatProperty.class).getMethod());
    constantSpecificHeat_0.getQuantity().setValue(cp);

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_0 = ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(ThermalConductivityProperty.class).getMethod());
    constantMaterialPropertyMethod_0.getQuantity().setValue(k);

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_1 = ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(TurbulentPrandtlNumberProperty.class).getMethod());
    constantMaterialPropertyMethod_1.getQuantity().setValue(TurbulentPr);

	// boundary conditions
	
    DirectBoundaryInterface directBoundaryInterface_0 = ((DirectBoundaryInterface) simulation_0.getInterfaceManager().getInterface("Periodic 1"));
    directBoundaryInterface_0.getConditions().get(FullyDevelopedEnergyJumpOption.class).setSelected(FullyDevelopedEnergyJumpOption.CONSTANT_HEAT_FLUX_WALLS);

    
    Boundary boundary_1 = region_0.getBoundaryManager().getBoundary("pin_cell.wall");
    boundary_1.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.HEAT_FLUX);
    HeatFluxProfile heatFluxProfile_0 = boundary_1.getValues().get(HeatFluxProfile.class);
    heatFluxProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(heatFlux);

    InterfaceBulkTemperature interfaceBulkTemperature_0 = directBoundaryInterface_0.getValues().get(InterfaceBulkTemperature.class);
    interfaceBulkTemperature_0.getBulkTemperature().setValue(T_av);

	// more reports
	
    DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_0 = ((DirectBoundaryInterfaceBoundary) region_0.getBoundaryManager().getBoundary("pin_cell.outlet [Periodic 1]"));
	
	PrimitiveFieldFunction primitiveFieldFunction_1 = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Temperature"));
	
	
    AreaAverageReport areaAverageReport_0 = simulation_0.getReportManager().createReport(AreaAverageReport.class);
    areaAverageReport_0.getParts().setObjects(boundary_0);
    areaAverageReport_0.setScalar(primitiveFieldFunction_1);
    areaAverageReport_0.setPresentationName("twall");

    MassFlowAverageReport massFlowAverageReport_0 = simulation_0.getReportManager().createReport(MassFlowAverageReport.class);
    massFlowAverageReport_0.setScalar(primitiveFieldFunction_1);
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
	
	
	
	
	
	
	
	
	
	
	
    simulation_0.saveState(resolvePath(savePath));
  }
}
