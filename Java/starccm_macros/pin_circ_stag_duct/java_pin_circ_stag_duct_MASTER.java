// STAR-CCM+ macro: java_pin_circ_stag_duct.java
package macro;

import java.util.*;

import star.common.*;
import star.segregatedenergy.*;
import star.flow.*;
import star.meshing.*;
import star.segregatedflow.*;
import star.turbulence.*;
import star.material.*;
import star.kwturb.*;
import star.base.neo.*;
import star.resurfacer.*;
import star.base.report.*;
import star.dualmesher.*;
import star.prismmesher.*;
import star.metrics.*;
import star.energy.*;

public class java_pin_circ_stag_duct extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = getActiveSimulation();

	CsvReader csvReader_0 = new CsvReader("/nfs/mohr/sva/work/rymalc/bin/sunshot/clust/jobs/star/pin_circ_stag_duct/pin_circ_stag_duct_case_0000/csv_param.csv",3);
	
	Collection<java.lang.String> strings_0 = csvReader_0.getValues();
	
	simulation_0.println("csv contents:");
	
	for (Object o : strings_0)
    simulation_0.println(o);
	
	Iterator iterator = strings_0.iterator();
	double D   = Double.parseDouble(iterator.next().toString());
	double P_T = Double.parseDouble(iterator.next().toString());
	int N_L    = Integer.parseInt(iterator.next().toString());
	
	simulation_0.println(D);
	simulation_0.println(P_T);
	simulation_0.println(N_L);
	
	double G_T = D*(P-1);
	double H = 4*G_T;
	double S_T = D*P_T;
	double S_L = sqrt(3)/2*S_T;
	double A_hs = (N_L*S_L + 2*H)*S_T;
	
	double qpp = 1e6;
	double dh = 
	
	double massFlowRate = qpp*A_hs/dh;
	
	
	
	
	
	
	
	
    CompositePart compositePart_0 = ((CompositePart) simulation_0.get(SimulationPartManager.class).getPart("assembly"));

    CadPart cadPart_0 = ((CadPart) compositePart_0.getChildParts().getPart("fluid"));

    CadPart cadPart_1 = ((CadPart) compositePart_0.getChildParts().getPart("solid"));

    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {cadPart_0, cadPart_1}), "OneRegionPerPart", null, "OneBoundaryPerPartSurface", null, "OneFeatureCurvePerPartCurve", null, true);

    MeshContinuum meshContinuum_0 = simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);

    MeshContinuum meshContinuum_1 = simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);

    PhysicsContinuum physicsContinuum_0 = simulation_0.getContinuumManager().createContinuum(PhysicsContinuum.class);

    PhysicsContinuum physicsContinuum_1 = simulation_0.getContinuumManager().createContinuum(PhysicsContinuum.class);

    meshContinuum_0.setPresentationName("Mesh fluid");

    meshContinuum_1.setPresentationName("Mesh solid");

    physicsContinuum_0.setPresentationName("Physics fluid");

    physicsContinuum_1.setPresentationName("Physics solid");

    meshContinuum_0.enable(ResurfacerMeshingModel.class);

    meshContinuum_0.enable(DualMesherModel.class);

    meshContinuum_0.enable(PrismMesherModel.class);

    meshContinuum_1.enable(ResurfacerMeshingModel.class);

    meshContinuum_1.enable(DualMesherModel.class);

    physicsContinuum_0.enable(ThreeDimensionalModel.class);

    physicsContinuum_0.enable(SteadyModel.class);

    physicsContinuum_0.enable(SingleComponentGasModel.class);

    physicsContinuum_0.enable(SegregatedFlowModel.class);

    physicsContinuum_0.enable(ConstantDensityModel.class);

    physicsContinuum_0.enable(TurbulentModel.class);

    physicsContinuum_0.enable(RansTurbulenceModel.class);

    physicsContinuum_0.enable(KOmegaTurbulence.class);

    physicsContinuum_0.enable(SstKwTurbModel.class);

    physicsContinuum_0.enable(KwAllYplusWallTreatment.class);

    physicsContinuum_0.enable(SegregatedFluidTemperatureModel.class);

    physicsContinuum_1.enable(SolidModel.class);

    physicsContinuum_1.enable(ThreeDimensionalModel.class);

    physicsContinuum_1.enable(SteadyModel.class);

    physicsContinuum_1.enable(SegregatedSolidEnergyModel.class);

    physicsContinuum_1.enable(ConstantDensityModel.class);

    meshContinuum_0.getReferenceValues().get(BaseSize.class).setValue(5.0E-5);

    SurfaceProximity surfaceProximity_0 = meshContinuum_0.getReferenceValues().get(SurfaceProximity.class);

    surfaceProximity_0.setNumPointsInGap(10.0);

    meshContinuum_1.getReferenceValues().get(BaseSize.class).setValue(1.0E-4);

    SingleComponentGasModel singleComponentGasModel_0 = physicsContinuum_0.getModelManager().getModel(SingleComponentGasModel.class);
	
    Gas gas_0 = ((Gas) singleComponentGasModel_0.getMaterial());

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_0 = ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(ConstantDensityProperty.class).getMethod());

    constantMaterialPropertyMethod_0.getQuantity().setValue(rhoAvgFluid);

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_1 = ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(DynamicViscosityProperty.class).getMethod());

    constantMaterialPropertyMethod_1.getQuantity().setValue(muAvgFluid);

    ConstantSpecificHeat constantSpecificHeat_0 = ((ConstantSpecificHeat) gas_0.getMaterialProperties().getMaterialProperty(SpecificHeatProperty.class).getMethod());

    constantSpecificHeat_0.getQuantity().setValue(specificHeatFluid);

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_2 = ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(ThermalConductivityProperty.class).getMethod());

    constantMaterialPropertyMethod_2.getQuantity().setValue(999.0);

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_3 = ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(TurbulentPrandtlNumberProperty.class).getMethod());

    constantMaterialPropertyMethod_3.getQuantity().setValue(999.0);

    SolidModel solidModel_0 = physicsContinuum_1.getModelManager().getModel(SolidModel.class);

    Solid solid_0 = ((Solid) solidModel_0.getMaterial());

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_4 = ((ConstantMaterialPropertyMethod) solid_0.getMaterialProperties().getMaterialProperty(ConstantDensityProperty.class).getMethod());

    constantMaterialPropertyMethod_4.getQuantity().setValue(999.0);

    ConstantSpecificHeat constantSpecificHeat_1 = ((ConstantSpecificHeat) solid_0.getMaterialProperties().getMaterialProperty(SpecificHeatProperty.class).getMethod());

    constantSpecificHeat_1.getQuantity().setValue(999.0);

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_5 = ((ConstantMaterialPropertyMethod) solid_0.getMaterialProperties().getMaterialProperty(ThermalConductivityProperty.class).getMethod());

    constantMaterialPropertyMethod_5.getQuantity().setValue(999.0);

    Region region_0 = simulation_0.getRegionManager().getRegion("assembly.solid");

    meshContinuum_1.add(region_0);

    physicsContinuum_1.add(region_0);

    Region region_1 = simulation_0.getRegionManager().getRegion("assembly.fluid");

    Boundary boundary_0 = region_1.getBoundaryManager().getBoundary("inlet");

    boundary_0.setBoundaryType(MassFlowBoundary.class);

    Boundary boundary_1 = region_1.getBoundaryManager().getBoundary("outlet");

    boundary_1.setBoundaryType(PressureBoundary.class);

    Boundary boundary_2 = region_1.getBoundaryManager().getBoundary("symmetry");

    boundary_2.setBoundaryType(SymmetryBoundary.class);

    Boundary boundary_3 = region_0.getBoundaryManager().getBoundary("symmetry");

    boundary_3.setBoundaryType(SymmetryBoundary.class);

    Boundary boundary_4 = region_0.getBoundaryManager().getBoundary("top");

    boundary_4.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.HEAT_FLUX);

    HeatFluxProfile heatFluxProfile_0 = boundary_4.getValues().get(HeatFluxProfile.class);

    heatFluxProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(1000000.0);

    AreaAverageReport areaAverageReport_0 = simulation_0.getReportManager().createReport(AreaAverageReport.class);

    AreaAverageReport areaAverageReport_1 = simulation_0.getReportManager().createReport(AreaAverageReport.class);

    areaAverageReport_0.setPresentationName("Pinlet");

    areaAverageReport_1.setPresentationName("Poutlet");

    PrimitiveFieldFunction primitiveFieldFunction_0 = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("StaticPressure"));

    areaAverageReport_0.setScalar(primitiveFieldFunction_0);

    areaAverageReport_0.getParts().setObjects(boundary_0);

    areaAverageReport_1.setScalar(primitiveFieldFunction_0);

    areaAverageReport_1.getParts().setObjects(boundary_1);

    ExpressionReport expressionReport_0 = simulation_0.getReportManager().createReport(ExpressionReport.class);

    expressionReport_0.setPresentationName("dP");

    expressionReport_0.setDefinition("$PinletReport - $PoutletReport");

    expressionReport_0.printReport();

    AreaAverageReport areaAverageReport_2 = simulation_0.getReportManager().createReport(AreaAverageReport.class);

    areaAverageReport_2.setPresentationName("Ttop");

    PrimitiveFieldFunction primitiveFieldFunction_1 = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Temperature"));

    areaAverageReport_2.setScalar(primitiveFieldFunction_1);

    areaAverageReport_2.getParts().setObjects(boundary_4);

    MassFlowAverageReport massFlowAverageReport_0 = simulation_0.getReportManager().createReport(MassFlowAverageReport.class);

    massFlowAverageReport_0.setPresentationName("Toutlet");

    massFlowAverageReport_0.setScalar(primitiveFieldFunction_1);

    massFlowAverageReport_0.getParts().setObjects(boundary_1);

    TotalTemperatureProfile totalTemperatureProfile_0 = boundary_0.getValues().get(TotalTemperatureProfile.class);

    totalTemperatureProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(T_in);

    StaticTemperatureProfile staticTemperatureProfile_0 = boundary_1.getValues().get(StaticTemperatureProfile.class);

    staticTemperatureProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(T_out);

    ResidualMonitor residualMonitor_0 = ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("Continuity"));

    MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_0 = residualMonitor_0.createIterationStoppingCriterion();

    ResidualMonitor residualMonitor_1 = ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("X-momentum"));

    MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_1 = residualMonitor_1.createIterationStoppingCriterion();

    ResidualMonitor residualMonitor_2 = ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("Y-momentum"));

    MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_2 = residualMonitor_2.createIterationStoppingCriterion();

    ResidualMonitor residualMonitor_3 = ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("Z-momentum"));

    MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_3 = residualMonitor_3.createIterationStoppingCriterion();

    monitorIterationStoppingCriterion_0.getLogicalOption().setSelected(SolverStoppingCriterionLogicalOption.AND);
    monitorIterationStoppingCriterion_1.getLogicalOption().setSelected(SolverStoppingCriterionLogicalOption.AND);
    monitorIterationStoppingCriterion_2.getLogicalOption().setSelected(SolverStoppingCriterionLogicalOption.AND);
    monitorIterationStoppingCriterion_3.getLogicalOption().setSelected(SolverStoppingCriterionLogicalOption.AND);

    StepStoppingCriterion stepStoppingCriterion_0 = ((StepStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Steps"));

    stepStoppingCriterion_0.setIsUsed(false);

    ReportMonitor reportMonitor_0 = expressionReport_0.createMonitor();

    MonitorPlot monitorPlot_0 = simulation_0.getPlotManager().createMonitorPlot();

    monitorPlot_0.setPresentationName("dP Monitor Plot");

    monitorPlot_0.getMonitors().addObjects(reportMonitor_0);

    Axes axes_0 = monitorPlot_0.getAxes();

    Axis axis_0 = axes_0.getXAxis();

    AxisTitle axisTitle_0 = axis_0.getTitle();

    axisTitle_0.setText("Iteration");

    Axis axis_1 = axes_0.getYAxis();

    AxisTitle axisTitle_1 = axis_1.getTitle();

    axisTitle_1.setText("Expression");

    ReportMonitor reportMonitor_1 = areaAverageReport_2.createMonitor();

    MonitorPlot monitorPlot_1 = simulation_0.getPlotManager().createMonitorPlot();

    monitorPlot_1.setPresentationName("Ttop Monitor Plot");

    monitorPlot_1.getMonitors().addObjects(reportMonitor_1);

    Axes axes_1 = monitorPlot_1.getAxes();

    Axis axis_2 = axes_1.getXAxis();

    AxisTitle axisTitle_2 = axis_2.getTitle();

    axisTitle_2.setText("Iteration");

    Axis axis_3 = axes_1.getYAxis();

    AxisTitle axisTitle_3 = axis_3.getTitle();

    axisTitle_3.setText("Surface Average of Temperature (K)");
	
	
  }
}
