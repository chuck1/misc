// STAR-CCM+ macro: java_macro.java
package macro;

import java.util.*;
import java.lang.*;

import star.cadmodeler.*;
import star.base.neo.*;
import star.base.report.*;
import star.common.*;
import star.dualmesher.*;
import star.energy.*;
import star.flow.*;
import star.kwturb.*;
import star.material.*;
import star.meshing.*;
import star.metrics.*;
import star.segregatedflow.*;
import star.turbulence.*;
import star.resurfacer.*;
import star.segregatedenergy.*;
import star.prismmesher.*;







public class java_macro2 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

	String session_abs_dir = simulation_0.getSessionDir();
	String session_dir = session_abs_dir.substring(session_abs_dir.lastIndexOf('/') + 1);
	String savePath = session_abs_dir + "/sim.sim";
	String CADPath = session_abs_dir + "/pin_cell.x_b";
	
	
	
	
	
	CsvReader csvReader_0 = new CsvReader(session_abs_dir+"/csv_param.csv",3);
	
	Collection<java.lang.String> strings_0 = csvReader_0.getValues();
	
	Iterator iterator = strings_0.iterator();
	double D = Double.parseDouble(iterator.next().toString());
	double P_T = Double.parseDouble(iterator.next().toString());
	double massFlowRate = Double.parseDouble(iterator.next().toString());
	
	double S_T = P_T*D;
	double G = S_T-D;
	double S_L = (Math.sqrt(3))/2*S_T;
	
	double A_hs = S_T*S_L;
	double A_wall;
	double heatFlux;
	double A_min = 3.1415*Math.pow(D,2)/16;
	
	double qpp = 1e6;
	
	double rho = 91.28;
	double cp = 1.2317e+03;
	double k = 6.297913e-02;
	double TurbulentPr = 1;
	double T_av = 848.15;
	
	double v_max = massFlowRate/rho/A_min;
	
	double Deltat = 2*S_L/v_max/100;
	
	double baseSize = G/7;
	
	
	
	
	
    simulation_0.saveState(resolvePath(savePath));

	// region
    CadPart cadPart_0 = ((CadPart) simulation_0.get(SimulationPartManager.class).getPart("pin_cell"));
    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {cadPart_0}), "OneRegion", null, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", null, true);

	// continua
    MeshContinuum meshContinuum_0 = simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);

    PhysicsContinuum physicsContinuum_0 = simulation_0.getContinuumManager().createContinuum(PhysicsContinuum.class);

    meshContinuum_0.enable(ResurfacerMeshingModel.class);
    meshContinuum_0.enable(DualMesherModel.class);
    meshContinuum_0.enable(PrismMesherModel.class);
    meshContinuum_0.getReferenceValues().get(BaseSize.class).setValue(baseSize);
    SurfaceProximity surfaceProximity_0 = meshContinuum_0.getReferenceValues().get(SurfaceProximity.class);
    surfaceProximity_0.setNumPointsInGap(10.0);
	NumPrismLayers numPrismLayers_0 = meshContinuum_0.getReferenceValues().get(NumPrismLayers.class);
    numPrismLayers_0.setNumLayers(5);
	
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

    SingleComponentGasModel singleComponentGasModel_0 = physicsContinuum_0.getModelManager().getModel(SingleComponentGasModel.class);
    Gas gas_0 = ((Gas) singleComponentGasModel_0.getMaterial());

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_0 = ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(ConstantDensityProperty.class).getMethod());
    constantMaterialPropertyMethod_0.getQuantity().setValue(rho);

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_1 = ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(DynamicViscosityProperty.class).getMethod());
    constantMaterialPropertyMethod_1.getQuantity().setValue(3.67E-5);

	// boundary varialbes
    Region region_0 = simulation_0.getRegionManager().getRegion("Region 1");
	
    Boundary boundary_inlet = region_0.getBoundaryManager().getBoundary("pin_cell.inlet");
    Boundary boundary_outlet = region_0.getBoundaryManager().getBoundary("pin_cell.outlet");
	Boundary boundary_symmetry = region_0.getBoundaryManager().getBoundary("pin_cell.symmetry");
	Boundary boundary_wall = region_0.getBoundaryManager().getBoundary("pin_cell.wall");
	
	DirectBoundaryInterface directBoundaryInterface_0 = simulation_0.getInterfaceManager().createDirectInterface(boundary_inlet, boundary_outlet, "Periodic");
	
	DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_inlet = ((DirectBoundaryInterfaceBoundary) region_0.getBoundaryManager().getBoundary("pin_cell.inlet [Periodic 1]"));
	DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_outlet = ((DirectBoundaryInterfaceBoundary) region_0.getBoundaryManager().getBoundary("pin_cell.outlet [Periodic 1]"));
	
	// boundary conditions
    
    directBoundaryInterface_0.getTopology().setSelected(InterfaceConfigurationOption.PERIODIC);

    InterfacePeriodicTransformSpecification interfacePeriodicTransformSpecification_0 = directBoundaryInterface_0.getPeriodicTransform();
    interfacePeriodicTransformSpecification_0.getPeriodicityOption().setSelected(PeriodicityOption.TRANSLATION);

    directBoundaryInterface_0.setInterfaceType(FullyDevelopedInterface.class);
    directBoundaryInterface_0.getConditions().get(FullyDevelopedFlowOption.class).setSelected(FullyDevelopedFlowOption.MASS_FLOW_RATE);
    FullyDevelopedMassFlowRate fullyDevelopedMassFlowRate_0 = directBoundaryInterface_0.getValues().get(FullyDevelopedMassFlowRate.class);
    fullyDevelopedMassFlowRate_0.getFullyDevelopedMassFlowRate().setValue(massFlowRate);

	boundary_symmetry.setBoundaryType(SymmetryBoundary.class);
	
	// mesh
    MeshPipelineController meshPipelineController_0 = simulation_0.get(MeshPipelineController.class);
    meshPipelineController_0.generateVolumeMesh();

    // reports
	PrimitiveFieldFunction primitiveFieldFunction_area = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Area"));
	PrimitiveFieldFunction primitiveFieldFunction_pressure = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("StaticPressure"));
	
    AreaAverageReport areaAverageReport_0 = simulation_0.getReportManager().createReport(AreaAverageReport.class);
    AreaAverageReport areaAverageReport_1 = simulation_0.getReportManager().createReport(AreaAverageReport.class);
    
    areaAverageReport_0.setScalar(primitiveFieldFunction_pressure);
    areaAverageReport_1.setScalar(primitiveFieldFunction_pressure);

    areaAverageReport_0.getParts().setObjects(directBoundaryInterfaceBoundary_inlet);
    areaAverageReport_1.getParts().setObjects(directBoundaryInterfaceBoundary_outlet);
	
	areaAverageReport_0.setPresentationName("pin");
    areaAverageReport_1.setPresentationName("pout");
	
    ExpressionReport expressionReport_0 = simulation_0.getReportManager().createReport(ExpressionReport.class);

    expressionReport_0.setPresentationName("dp");
    expressionReport_0.setDefinition("$pinReport - $poutReport");

    ReportMonitor reportMonitor_dp = expressionReport_0.createMonitor();
	
    MonitorPlot monitorPlot_dp = simulation_0.getPlotManager().createMonitorPlot();
    monitorPlot_dp.setPresentationName("dp Monitor Plot");
    monitorPlot_dp.getMonitors().addObjects(reportMonitor_dp);

	// stopping criteria
	StepStoppingCriterion stepStoppingCriterion_0 = ((StepStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Steps"));
    stepStoppingCriterion_0.setIsUsed(true);
	
	// run
	simulation_0.saveState(resolvePath(savePath));
    simulation_0.getSimulationIterator().run(2000);
	simulation_0.saveState(resolvePath(savePath));

	// switch to heat
	// report
	SumReport sumReport_0 = simulation_0.getReportManager().createReport(SumReport.class);
    sumReport_0.setPresentationName("areaWall");
    
    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = ((VectorMagnitudeFieldFunction) primitiveFieldFunction_area.getMagnitudeFunction());
    sumReport_0.setScalar(vectorMagnitudeFieldFunction_0);
    
    sumReport_0.getParts().setObjects(boundary_wall);
    sumReport_0.printReport();

	A_wall = sumReport_0.getValue();
	heatFlux = qpp*A_hs/A_wall/2;
	
	// physics models
    physicsContinuum_0.enable(SegregatedFluidTemperatureModel.class);

	// fluid properties
    ConstantSpecificHeat constantSpecificHeat_0 = ((ConstantSpecificHeat) gas_0.getMaterialProperties().getMaterialProperty(SpecificHeatProperty.class).getMethod());
    constantSpecificHeat_0.getQuantity().setValue(cp);

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_thermalconductivity = ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(ThermalConductivityProperty.class).getMethod());
    constantMaterialPropertyMethod_thermalconductivity.getQuantity().setValue(k);

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_turbulentprandtlnumber = ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(TurbulentPrandtlNumberProperty.class).getMethod());
    constantMaterialPropertyMethod_turbulentprandtlnumber.getQuantity().setValue(TurbulentPr);

	// boundary conditions
    directBoundaryInterface_0.getConditions().get(FullyDevelopedEnergyJumpOption.class).setSelected(FullyDevelopedEnergyJumpOption.CONSTANT_HEAT_FLUX_WALLS);
	
    boundary_wall.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.HEAT_FLUX);
    HeatFluxProfile heatFluxProfile_0 = boundary_wall.getValues().get(HeatFluxProfile.class);
    heatFluxProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(heatFlux);

    InterfaceBulkTemperature interfaceBulkTemperature_0 = directBoundaryInterface_0.getValues().get(InterfaceBulkTemperature.class);
    interfaceBulkTemperature_0.getBulkTemperature().setValue(T_av);
	
	// more reports
	PrimitiveFieldFunction primitiveFieldFunction_temprature = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Temperature"));
	
    AreaAverageReport areaAverageReport_2 = simulation_0.getReportManager().createReport(AreaAverageReport.class);
    areaAverageReport_2.getParts().setObjects(boundary_wall);
    areaAverageReport_2.setScalar(primitiveFieldFunction_temprature);
    areaAverageReport_2.setPresentationName("twall");
	
    MassFlowAverageReport massFlowAverageReport_0 = simulation_0.getReportManager().createReport(MassFlowAverageReport.class);
    massFlowAverageReport_0.setScalar(primitiveFieldFunction_temprature);
    massFlowAverageReport_0.getParts().setObjects(directBoundaryInterfaceBoundary_outlet);
    massFlowAverageReport_0.setPresentationName("tout");
	
    ReportMonitor reportMonitor_twall = areaAverageReport_2.createMonitor();
    MonitorPlot monitorPlot_twall = simulation_0.getPlotManager().createMonitorPlot();
    monitorPlot_twall.setPresentationName("twall Monitor Plot");
    monitorPlot_twall.getMonitors().addObjects(reportMonitor_twall);
	
	// run
	
	simulation_0.saveState(resolvePath(savePath));
    simulation_0.getSimulationIterator().run(500);
	simulation_0.saveState(resolvePath(savePath));
	
	// switch to transient
    SteadyModel steadyModel_0 = physicsContinuum_0.getModelManager().getModel(SteadyModel.class);

    physicsContinuum_0.disableModel(steadyModel_0);

    physicsContinuum_0.enable(ImplicitUnsteadyModel.class);

    ImplicitUnsteadySolver implicitUnsteadySolver_0 = ((ImplicitUnsteadySolver) simulation_0.getSolverManager().getSolver(ImplicitUnsteadySolver.class));

    implicitUnsteadySolver_0.getTimeStep().setValue(Deltat);

    
	reportMonitor_dp.getTriggerOption().setSelected(MonitorTriggerOption.TIME_STEP);
    reportMonitor_twall.getTriggerOption().setSelected(MonitorTriggerOption.TIME_STEP);

	monitorPlot_twall.export(resolvePath(session_abs_dir+"/twall.csv"), ",");
    monitorPlot_dp.export(resolvePath(session_abs_dir+"/dp2.csv"), ",");
	

    ResidualPlot residualPlot_0 = ((ResidualPlot) simulation_0.getPlotManager().getObject("Residuals"));

    residualPlot_0.export(resolvePath(session_abs_dir+"/residuals2.csv"), ",");

	// stopping criteria
    InnerIterationStoppingCriterion innerIterationStoppingCriterion_0 = ((InnerIterationStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Inner Iterations"));

    innerIterationStoppingCriterion_0.setMaximumNumberInnerIterations(50);

    StepStoppingCriterion stepStoppingCriterion_maxsteps = ((StepStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Steps"));

    stepStoppingCriterion_maxsteps.setIsUsed(false);
	
	// run
	simulation_0.saveState(resolvePath(savePath));
	simulation_0.getSimulationIterator().run(1000);
	simulation_0.saveState(resolvePath(savePath));
  }
}
