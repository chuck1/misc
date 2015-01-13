// STAR-CCM+ macro: java_macro.java
package macro;

import java.util.*;

import star.common.*;
import star.delaunaymesher.*;
import star.flow.*;
import star.trimmer.*;
import star.meshing.*;
import star.segregatedflow.*;
import star.turbulence.*;
import star.kwturb.*;
import star.cadmodeler.*;
import star.material.*;
import star.base.neo.*;
import star.resurfacer.*;
import star.base.report.*;
import star.dualmesher.*;
import star.prismmesher.*;
import star.metrics.*;

public class java_macro extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = getActiveSimulation();

	double massFlowRate = 0;
	double D = 0;
	double P_T = 0;
	
	
	// 3D CAD
	
	CadModel cadModel_0 = ((CadModel) simulation_0.get(SolidModelManager.class).getObject("3D-CAD Model 1"));

    ScalarQuantityDesignParameter scalarQuantityDesignParameter_0 = ((ScalarQuantityDesignParameter) cadModel_0.getDesignParameterManager().getObject("Distance"));
	ScalarQuantityDesignParameter scalarQuantityDesignParameter_1 = ((ScalarQuantityDesignParameter) cadModel_0.getDesignParameterManager().getObject("Radius"));
    
	scalarQuantityDesignParameter_0.getQuantity().setDefinition("$Radius*"+String.format("%.3d", D));
    scalarQuantityDesignParameter_1.getQuantity().setValue(D);
	
    cadModel_0.update();
	
    cadModel_0.createParts("SharpEdges", 30.0, 2, true);

	// part
	
    SolidModelPart solidModelPart_1 = ((SolidModelPart) simulation_0.get(SimulationPartManager.class).getPart("Body 1"));

    PartSurface partSurface_0 = solidModelPart_1.getPartSurfaceManager().getPartSurface("Default");
    PartCurve partCurve_0 = ((PartCurve) solidModelPart_1.getPartCurveManager().getObject("Default"));
    solidModelPart_1.getPartSurfaceManager().splitPartSurfacesByPartCurves(new NeoObjectVector(new Object[] {partSurface_0}), new NeoObjectVector(new Object[] {partCurve_0}));

	
    PartSurface partSurface_1 = solidModelPart_1.getPartSurfaceManager().getPartSurface("Default 9");
    PartSurface partSurface_2 = solidModelPart_1.getPartSurfaceManager().getPartSurface("Default 6");
    PartSurface partSurface_3 = solidModelPart_1.getPartSurfaceManager().getPartSurface("Default 3");
    PartSurface partSurface_4 = solidModelPart_1.getPartSurfaceManager().getPartSurface("Default 10");
    PartSurface partSurface_5 = solidModelPart_1.getPartSurfaceManager().getPartSurface("Default 8");
	PartSurface partSurface_6 = solidModelPart_1.getPartSurfaceManager().getPartSurface("Default 5");
	PartSurface partSurface_7 = solidModelPart_1.getPartSurfaceManager().getPartSurface("Default 7");
	PartSurface partSurface_8 = solidModelPart_1.getPartSurfaceManager().getPartSurface("Default 4");
    PartSurface partSurface_9 = solidModelPart_1.getPartSurfaceManager().getPartSurface("Default 2");
	
	solidModelPart_1.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_0, partSurface_1, partSurface_2}));
    solidModelPart_1.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_3, partSurface_4, partSurface_5}));
	solidModelPart_1.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_8, partSurface_9}));
	
	partSurface_0.setPresentationName("wall");
    partSurface_3.setPresentationName("symmetry");
    partSurface_6.setPresentationName("inlet");
    partSurface_7.setPresentationName("outlet");
    partSurface_8.setPresentationName("interior");
	
	// region
    SolidModelPart solidModelPart_0 = ((SolidModelPart) simulation_0.get(SimulationPartManager.class).getPart("Body 1"));
	
    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {solidModelPart_0}), "OneRegion", null, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", null, true);
    Region region_0 = simulation_0.getRegionManager().getRegion("Region 1");
	
    Boundary boundary_0 = region_0.getBoundaryManager().getBoundary("Body 1.inlet");
    Boundary boundary_1 = region_0.getBoundaryManager().getBoundary("Body 1.outlet");
	Boundary boundary_2 = region_0.getBoundaryManager().getBoundary("Body 1.symmetry");
	Boundary boundary_3 = region_0.getBoundaryManager().getBoundary("Body 1.interior");
	
	boundary_2.setBoundaryType(SymmetryBoundary.class);
    boundary_3.setBoundaryType(SymmetryBoundary.class);
	
    DirectBoundaryInterface directBoundaryInterface_0 = simulation_0.getInterfaceManager().createDirectInterface(boundary_0, boundary_1, "Periodic");
    directBoundaryInterface_0.getTopology().setSelected(InterfaceConfigurationOption.PERIODIC);
    
	// continua
    MeshContinuum meshContinuum_0 = simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);
    PhysicsContinuum physicsContinuum_0 = simulation_0.getContinuumManager().createContinuum(PhysicsContinuum.class);
	
	// dual
    meshContinuum_0.enable(ResurfacerMeshingModel.class);
    meshContinuum_0.enable(DualMesherModel.class);
    meshContinuum_0.enable(PrismMesherModel.class);
	
	// trimmer
    meshContinuum_0.enable(TrimmerMeshingModel.class);
    meshContinuum_0.enable(PrismMesherModel.class);

	// delaunay
    meshContinuum_0.enable(DelaunayMesherModel.class);
    meshContinuum_0.enable(PrismMesherModel.class);
	
	// mesh reference values
    meshContinuum_0.getReferenceValues().get(BaseSize.class).setValue(baseSize);
    NumPrismLayers numPrismLayers_0 = meshContinuum_0.getReferenceValues().get(NumPrismLayers.class);
    numPrismLayers_0.setNumLayers(3);
    SurfaceProximity surfaceProximity_0 = meshContinuum_0.getReferenceValues().get(SurfaceProximity.class);
    surfaceProximity_0.setNumPointsInGap(5.0);
	double surfaceProximity = 5.0;
	int numPrismLayers = 3;
	// physics
    physicsContinuum_0.enable(TwoDimensionalModel.class);
	physicsContinuum_0.enable(SingleComponentGasModel.class);
	physicsContinuum_0.enable(SegregatedFlowModel.class);
    physicsContinuum_0.enable(ConstantDensityModel.class);
	
	
	// time
	switch (timeString) {
		case "steady":
			physicsContinuum_0.enable(SteadyModel.class);
			break;
		case "trans":
			break;
		default:
			// error
			break;
	}
	
	// viscous
	switch (viscousString) {
		case "laminar":
			physicsContinuum_0.enable(LaminarModel.class);
			break;
		case "turb":
			physicsContinuum_0.enable(TurbulentModel.class);
			switch (turbString) {
				case "rans":
					physicsContinuum_0.enable(RansTurbulenceModel.class);
					switch (ransString) {
						case "komega":
							physicsContinuum_0.enable(KOmegaTurbulence.class);
							physicsContinuum_0.enable(SstKwTurbModel.class);
							physicsContinuum_0.enable(KwAllYplusWallTreatment.class);
							break;
						default:
							// error
							break;
					}
					break;
				default:
					// error
					break:
			}
			break;
		default:
			// error
			break;
	}
	
	// fluid properties
    SingleComponentGasModel singleComponentGasModel_0 = physicsContinuum_0.getModelManager().getModel(SingleComponentGasModel.class);
    Gas gas_0 = ((Gas) singleComponentGasModel_0.getMaterial());
    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_0 = ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(ConstantDensityProperty.class).getMethod());
    constantMaterialPropertyMethod_0.getQuantity().setValue(91.28);
    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_1 = ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(DynamicViscosityProperty.class).getMethod());
    constantMaterialPropertyMethod_1.getQuantity().setValue(3.67E-5);

	// boundary
    directBoundaryInterface_0.setInterfaceType(FullyDevelopedInterface.class);

    directBoundaryInterface_0.getConditions().get(FullyDevelopedFlowOption.class).setSelected(FullyDevelopedFlowOption.MASS_FLOW_RATE);

    FullyDevelopedMassFlowRate fullyDevelopedMassFlowRate_0 = directBoundaryInterface_0.getValues().get(FullyDevelopedMassFlowRate.class);

    fullyDevelopedMassFlowRate_0.getFullyDevelopedMassFlowRate().setValue(massFlowRate);

    MeshPipelineController meshPipelineController_0 = simulation_0.get(MeshPipelineController.class);
	
    meshPipelineController_0.generateVolumeMesh();
	
    MeshManager meshManager_0 = simulation_0.getMeshManager();

    meshManager_0.convertTo2d(1.0E-6, new NeoObjectVector(new Object[] {region_0}), true);
	
    ResidualMonitor residualMonitor_0 = ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("Continuity"));
	ResidualMonitor residualMonitor_1 = ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("X-momentum"));
    ResidualMonitor residualMonitor_2 = ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("Y-momentum"));
	ResidualMonitor residualMonitor_3 = ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("Sdr"));
	ResidualMonitor residualMonitor_4 = ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("Tke"));

    MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_0 = residualMonitor_0.createIterationStoppingCriterion();
    MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_1 = residualMonitor_1.createIterationStoppingCriterion();
    MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_2 = residualMonitor_2.createIterationStoppingCriterion();
    MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_3 = residualMonitor_3.createIterationStoppingCriterion();
    MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_4 = residualMonitor_4.createIterationStoppingCriterion();

    monitorIterationStoppingCriterion_1.getLogicalOption().setSelected(SolverStoppingCriterionLogicalOption.AND);
    monitorIterationStoppingCriterion_2.getLogicalOption().setSelected(SolverStoppingCriterionLogicalOption.AND);
    monitorIterationStoppingCriterion_4.getLogicalOption().setSelected(SolverStoppingCriterionLogicalOption.AND);
    monitorIterationStoppingCriterion_3.getLogicalOption().setSelected(SolverStoppingCriterionLogicalOption.AND);
    monitorIterationStoppingCriterion_0.getLogicalOption().setSelected(SolverStoppingCriterionLogicalOption.AND);

    StepStoppingCriterion stepStoppingCriterion_0 = ((StepStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Steps"));

    stepStoppingCriterion_0.setIsUsed(false);

    AreaAverageReport areaAverageReport_0 = simulation_0.getReportManager().createReport(AreaAverageReport.class);

    PrimitiveFieldFunction primitiveFieldFunction_0 = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("StaticPressure"));

    areaAverageReport_0.setScalar(primitiveFieldFunction_0);

    Region region_1 = simulation_0.getRegionManager().getRegion("Region 1 2D");

    DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_0 = ((DirectBoundaryInterfaceBoundary) region_1.getBoundaryManager().getBoundary("Body 1.inlet [Periodic 1 2D]"));

    areaAverageReport_0.getParts().setObjects(directBoundaryInterfaceBoundary_0);

    areaAverageReport_0.setPresentationName("Pinlet");

    AreaAverageReport areaAverageReport_1 = simulation_0.getReportManager().createReport(AreaAverageReport.class);

    areaAverageReport_1.setScalar(primitiveFieldFunction_0);

    DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_1 = ((DirectBoundaryInterfaceBoundary) region_1.getBoundaryManager().getBoundary("Body 1.outlet [Periodic 1 2D]"));

    areaAverageReport_1.getParts().setObjects(directBoundaryInterfaceBoundary_1);

    areaAverageReport_1.setPresentationName("Poutlet");

    ExpressionReport expressionReport_0 = simulation_0.getReportManager().createReport(ExpressionReport.class);

    expressionReport_0.setPresentationName("dP");

    expressionReport_0.setDefinition("$PinletReport - $PoutletReport\n");

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

    simulation_0.getSimulationIterator().run();

    stepStoppingCriterion_0.setIsUsed(true);

    stepStoppingCriterion_0.setMaximumNumberSteps(10250);

    stepStoppingCriterion_0.setMaximumNumberSteps(10220);

    monitorPlot_0.export(resolvePath("/nfs/mohr/sva/work/rymalc/bin/sunshot/clust/jobs/star/pin_circ_stag_cell_2D/pin_circ_stag_cell_2D_case_0000/csv_dP.csv"), ",");

    ResidualPlot residualPlot_0 = ((ResidualPlot) simulation_0.getPlotManager().getObject("Residuals"));

    residualPlot_0.export(resolvePath("/nfs/mohr/sva/work/rymalc/bin/sunshot/clust/jobs/star/pin_circ_stag_cell_2D/pin_circ_stag_cell_2D_case_0000/csv_Residuals.csv"), ",");
  }
}
