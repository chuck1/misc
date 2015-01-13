// STAR-CCM+ macro: java_macro4.java
package macro;

import java.util.*;

import star.material.*;
import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.base.report.*;
import star.flow.*;
import star.meshing.*;
import star.energy.*;

public class java_macro4 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PhysicsContinuum physicsContinuum_0 = ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("Physics fluid"));
    SingleComponentGasModel singleComponentGasModel_0 = physicsContinuum_0.getModelManager().getModel(SingleComponentGasModel.class);
    Gas gas_0 = ((Gas) singleComponentGasModel_0.getMaterial());

	// dynamic viscosity
	
    PowerLaw powerLaw_0 = ((PowerLaw) gas_0.getMaterialProperties().getMaterialProperty(DynamicViscosityProperty.class).getMethod());

    powerLaw_0.setReferenceValue(2.894345E-5);
    powerLaw_0.setReferenceTemperature(600.0);
    powerLaw_0.setTemperatureExponent(0.7071589);

	// density
	
    TemperaturePolynomial temperaturePolynomial_0 = ((TemperaturePolynomial) gas_0.getMaterialProperties().getMaterialProperty(PolynomialDensityProperty.class).getMethod());

    temperaturePolynomial_0.getPolynomial().setIntervalRanges(new DoubleVector(new double[] {100.0, 1100.0}));
    temperaturePolynomial_0.getPolynomial().setCoefficients(new DoubleVector(new double[] {211.6808, -0.2725829, 1.12436E-4}));

    gas_0.getMaterialProperties().getMaterialProperty(SpecificHeatProperty.class).setMethod(PolynomialSpecificHeat.class);
	
	// specific heat
	
    PolynomialSpecificHeat polynomialSpecificHeat_0 = ((PolynomialSpecificHeat) gas_0.getMaterialProperties().getMaterialProperty(SpecificHeatProperty.class).getMethod());

    polynomialSpecificHeat_0.getPolynomial().setIntervalRanges(new DoubleVector(new double[] {100.0, 1100.0}));
    polynomialSpecificHeat_0.getPolynomial().setNumberOfCoefficients(new IntVector(new int[] {3}));
    polynomialSpecificHeat_0.getPolynomial().setCoefficients(new DoubleVector(new double[] {970.372, 0.3319256, -4.833853E-5}));
    polynomialSpecificHeat_0.getPolynomial().setExponents(new DoubleVector(new double[] {0.0, 1.0, 2.0}));
	
	// thermal conductivity
	
    gas_0.getMaterialProperties().getMaterialProperty(ThermalConductivityProperty.class).setMethod(PowerLaw.class);

    PowerLaw powerLaw_1 = ((PowerLaw) gas_0.getMaterialProperties().getMaterialProperty(ThermalConductivityProperty.class).getMethod());

    powerLaw_1.setReferenceValue(0.04443491);
    powerLaw_1.setReferenceTemperature(600.0);
    powerLaw_1.setTemperatureExponent(0.9355018);
	
	// turbulent prandtl number
	
    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_0 = ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(TurbulentPrandtlNumberProperty.class).getMethod());
    constantMaterialPropertyMethod_0.getQuantity().setValue(1.0);

	// 
    StaticTemperatureProfile staticTemperatureProfile_0 = physicsContinuum_0.getInitialConditions().get(StaticTemperatureProfile.class);

    staticTemperatureProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(900.0);

    PhysicsContinuum physicsContinuum_1 = ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("Physics solid"));

    SolidModel solidModel_0 = physicsContinuum_1.getModelManager().getModel(SolidModel.class);

    Solid solid_0 = ((Solid) solidModel_0.getMaterial());

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_1 = ((ConstantMaterialPropertyMethod) solid_0.getMaterialProperties().getMaterialProperty(ConstantDensityProperty.class).getMethod());

    constantMaterialPropertyMethod_1.getQuantity().setValue(8050.0);

    ConstantSpecificHeat constantSpecificHeat_0 = ((ConstantSpecificHeat) solid_0.getMaterialProperties().getMaterialProperty(SpecificHeatProperty.class).getMethod());

    constantSpecificHeat_0.getQuantity().setValue(728.0);

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_2 = ((ConstantMaterialPropertyMethod) solid_0.getMaterialProperties().getMaterialProperty(ThermalConductivityProperty.class).getMethod());
	
    constantMaterialPropertyMethod_2.getQuantity().setValue(31.0);
	
    Region region_0 = simulation_0.getRegionManager().getRegion("Assembly 1.fluid");
	
    Boundary boundary_0 = region_0.getBoundaryManager().getBoundary("inlet");
	
    boundary_0.setBoundaryType(MassFlowBoundary.class);
	
    Boundary boundary_1 = region_0.getBoundaryManager().getBoundary("outlet");
	
    boundary_1.setBoundaryType(PressureBoundary.class);
	
    Boundary boundary_2 = region_0.getBoundaryManager().getBoundary("symmetry");

    boundary_2.setBoundaryType(SymmetryBoundary.class);

    Region region_1 = simulation_0.getRegionManager().getRegion("Assembly 1.solid");

    Boundary boundary_3 = region_1.getBoundaryManager().getBoundary("symmetry");

    boundary_3.setBoundaryType(SymmetryBoundary.class);

    Boundary boundary_4 = region_1.getBoundaryManager().getBoundary("top");

    boundary_4.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.HEAT_FLUX);

    HeatFluxProfile heatFluxProfile_0 = boundary_4.getValues().get(HeatFluxProfile.class);

    heatFluxProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(1000000.0);

    simulation_0.saveState(resolvePath("/nfs/mohr/sva/work/rymalc/bin/sunshot/clust/jobs/star/pin_circ_stag_duct2/case_0000/sim.sim"));

    TotalTemperatureProfile totalTemperatureProfile_0 = boundary_0.getValues().get(TotalTemperatureProfile.class);

    totalTemperatureProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(848.15);

    MassFlowRateProfile massFlowRateProfile_0 = boundary_0.getValues().get(MassFlowRateProfile.class);

    massFlowRateProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(1.82E-5);

    StepStoppingCriterion stepStoppingCriterion_0 = ((StepStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Steps"));

    stepStoppingCriterion_0.setIsUsed(false);

    AreaAverageReport areaAverageReport_0 = simulation_0.getReportManager().createReport(AreaAverageReport.class);
	areaAverageReport_0.setPresentationName("ttop");
	areaAverageReport_0.setScalar(primitiveFieldFunction_0);
	PrimitiveFieldFunction primitiveFieldFunction_0 = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Temperature"));
	areaAverageReport_0.getParts().setObjects(boundary_4);
	
	
	
    AreaAverageReport areaAverageReport_1 = simulation_0.getReportManager().createReport(AreaAverageReport.class);
    AreaAverageReport areaAverageReport_2 = simulation_0.getReportManager().createReport(AreaAverageReport.class);

    MassAverageReport massAverageReport_0 = simulation_0.getReportManager().createReport(MassAverageReport.class);
	
    simulation_0.getReportManager().removeObjects(massAverageReport_0);
	
    MassFlowAverageReport massFlowAverageReport_0 = simulation_0.getReportManager().createReport(MassFlowAverageReport.class);
	
    ExpressionReport expressionReport_0 = simulation_0.getReportManager().createReport(ExpressionReport.class);
	
    expressionReport_0.setPresentationName("dp");

    massFlowAverageReport_0.setPresentationName("tout");

    

    areaAverageReport_1.setPresentationName("pin");

    areaAverageReport_2.setPresentationName("pout");

    

    massFlowAverageReport_0.setScalar(primitiveFieldFunction_0);

    
    PrimitiveFieldFunction primitiveFieldFunction_1 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("StaticPressure"));

    areaAverageReport_1.setScalar(primitiveFieldFunction_1);

    areaAverageReport_2.setScalar(primitiveFieldFunction_1);

    expressionReport_0.setDefinition("$pinReport - $poutReport");

    massFlowAverageReport_0.getParts().setObjects(boundary_1);

    MeshContinuum meshContinuum_0 = 
      ((MeshContinuum) simulation_0.getContinuumManager().getContinuum("Mesh 2"));

    meshContinuum_0.add(region_1);

    physicsContinuum_1.add(region_1);

    

    areaAverageReport_1.getParts().setObjects(boundary_0);

    areaAverageReport_2.getParts().setObjects(boundary_1);

    ReportMonitor reportMonitor_0 = 
      expressionReport_0.createMonitor();

    MonitorPlot monitorPlot_0 = 
      simulation_0.getPlotManager().createMonitorPlot();

    monitorPlot_0.setPresentationName("dp Monitor Plot");

    monitorPlot_0.getMonitors().addObjects(reportMonitor_0);

    Axes axes_0 = 
      monitorPlot_0.getAxes();

    Axis axis_0 = 
      axes_0.getXAxis();

    AxisTitle axisTitle_0 = 
      axis_0.getTitle();

    axisTitle_0.setText("Iteration");

    Axis axis_1 = 
      axes_0.getYAxis();

    AxisTitle axisTitle_1 = 
      axis_1.getTitle();

    axisTitle_1.setText("Expression");

    ReportMonitor reportMonitor_1 = 
      massFlowAverageReport_0.createMonitor();

    MonitorPlot monitorPlot_1 = 
      simulation_0.getPlotManager().createMonitorPlot();

    monitorPlot_1.setPresentationName("tout Monitor Plot");

    monitorPlot_1.getMonitors().addObjects(reportMonitor_1);

    Axes axes_1 = 
      monitorPlot_1.getAxes();

    Axis axis_2 = 
      axes_1.getXAxis();

    AxisTitle axisTitle_2 = 
      axis_2.getTitle();

    axisTitle_2.setText("Iteration");

    Axis axis_3 = 
      axes_1.getYAxis();

    AxisTitle axisTitle_3 = 
      axis_3.getTitle();

    axisTitle_3.setText("Mass Flow Averaged of Temperature (K)");

    ReportMonitor reportMonitor_2 = 
      areaAverageReport_0.createMonitor();

    MonitorPlot monitorPlot_2 = 
      simulation_0.getPlotManager().createMonitorPlot();

    monitorPlot_2.setPresentationName("ttop Monitor Plot");

    monitorPlot_2.getMonitors().addObjects(reportMonitor_2);

    Axes axes_2 = 
      monitorPlot_2.getAxes();

    Axis axis_4 = 
      axes_2.getXAxis();

    AxisTitle axisTitle_4 = 
      axis_4.getTitle();

    axisTitle_4.setText("Iteration");

    Axis axis_5 = 
      axes_2.getYAxis();

    AxisTitle axisTitle_5 = 
      axis_5.getTitle();

    axisTitle_5.setText("Surface Average of Temperature (K)");

    simulation_0.saveState(resolvePath("/nfs/mohr/sva/work/rymalc/bin/sunshot/clust/jobs/star/pin_circ_stag_duct2/case_0000/sim.sim"));

    MeshPipelineController meshPipelineController_0 = 
      simulation_0.get(MeshPipelineController.class);

    meshPipelineController_0.generateVolumeMesh();

    simulation_0.getSceneManager().createGeometryScene("Mesh Scene", "Outline", "Mesh", 3);

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Mesh Scene 1");

    scene_0.initializeAndWait();

    PartDisplayer partDisplayer_1 = 
      ((PartDisplayer) scene_0.getCreatorDisplayer());

    partDisplayer_1.initialize();

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getDisplayer("Mesh 1"));

    partDisplayer_0.initialize();

    PartDisplayer partDisplayer_2 = 
      ((PartDisplayer) scene_0.getHighlightDisplayer());

    partDisplayer_2.initialize();

    scene_0.open(true);

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    scene_0.close(true);

    
  }
}
