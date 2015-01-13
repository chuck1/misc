// STAR-CCM+ macro: macro_unit_cell_setup.java
package macro;

import java.util.*;

import java.io.*;

import star.common.*;
import star.flow.*;
import star.meshing.*;
import star.segregatedflow.*;
import star.turbulence.*;
import star.material.*;
import star.kwturb.*;
import star.base.neo.*;
import star.vis.*;
import star.resurfacer.*;
import star.base.report.*;
import star.dualmesher.*;
import star.prismmesher.*;

public class macro_unit_cell_setup extends StarMacro {

  public void execute() {
    execute0();
  }
  
  private void execute0() {
	
	// variables
	Double diameter = 500E-6;
	Double pitch = 1.4;
	Double massFlowRate = 9.4E-5;
	
	// base size
	Double baseSize_fluid = diameter*( pitch  - 1 )/40;
	Double baseSize_solid = baseSize_fluid*2;
	
	// paths
	Simulation simulation_0 = getActiveSimulation();
	
	String session_abs_dir = simulation_0.getSessionDir();
	String session_dir = session_abs_dir.substring(session_abs_dir.lastIndexOf('/') + 1);
	String save_path = session_abs_dir + "/sim_unit_cell.sim";
	String CAD_path = "/nfs/stak/students/r/rymalc/Windows.Documents/My Documents/SYNC/SUNSHOT/solidworks/unit_cell/" + session_dir + ".STEP";
	
	// parts
	
	// import
    PartImportManager partImportManager_0 = simulation_0.get(PartImportManager.class);
    partImportManager_0.importCadPart(resolvePath(CAD_path), "SharpEdges", 30.0, 2, true, true);
	
	// split
    CadPart cadPart_0 = ((CadPart) simulation_0.get(SimulationPartManager.class).getPart("Cut-Extrude1"));
	
    PartSurface partSurface_0 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces");

    PartCurve partCurve_0 = ((PartCurve) cadPart_0.getPartCurveManager().getObject("Edges"));

    cadPart_0.getPartSurfaceManager().splitPartSurfacesByPartCurves(new NeoObjectVector(new Object[] {partSurface_0}), new NeoObjectVector(new Object[] {partCurve_0}));
	
	// combine and rename
    PartSurface partSurface_1 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 2");
	PartSurface partSurface_2 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 3");
    PartSurface partSurface_3 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 4");
    PartSurface partSurface_4 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 5");
    PartSurface partSurface_5 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 6");
    PartSurface partSurface_6 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 7");
    PartSurface partSurface_7 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 8");
	
    partSurface_0.setPresentationName("wall");
    partSurface_1.setPresentationName("outlet");
	
    cadPart_0.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_2, partSurface_3, partSurface_5, partSurface_6, partSurface_7}));
	
    partSurface_2.setPresentationName("symmetry");
    partSurface_4.setPresentationName("inlet");
	
	// regions
	
	// create regions
    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {cadPart_0}), "OneRegionPerPart", null, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", null, true);
	
	// set boundary conditions
    Region region_0 = simulation_0.getRegionManager().getRegion("Cut-Extrude1");

    Boundary boundary_0 = region_0.getBoundaryManager().getBoundary("symmetry");

    boundary_0.setBoundaryType(SymmetryBoundary.class);
	
	// interface
    Boundary boundary_1 = region_0.getBoundaryManager().getBoundary("inlet");
    Boundary boundary_2 = region_0.getBoundaryManager().getBoundary("outlet");
	
	DirectBoundaryInterface directBoundaryInterface_0 = simulation_0.getInterfaceManager().createDirectInterface(boundary_1, boundary_2, "Periodic");

    directBoundaryInterface_0.getTopology().setSelected(InterfaceConfigurationOption.PERIODIC);
    directBoundaryInterface_0.setInterfaceType(FullyDevelopedInterface.class);

    InterfacePeriodicTransformSpecification interfacePeriodicTransformSpecification_0 = directBoundaryInterface_0.getPeriodicTransform();
    interfacePeriodicTransformSpecification_0.getPeriodicityOption().setSelected(PeriodicityOption.TRANSLATION);
	
	// continua
	MeshContinuum meshContinuum_0 = simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);
	PhysicsContinuum physicsContinuum_0 = simulation_0.getContinuumManager().createContinuum(PhysicsContinuum.class);
	
	// mesh
    meshContinuum_0.enable(ResurfacerMeshingModel.class);
    meshContinuum_0.enable(DualMesherModel.class);
    meshContinuum_0.enable(PrismMesherModel.class);
    meshContinuum_0.getReferenceValues().get(BaseSize.class).setValue(base_size);
	
    NumPrismLayers numPrismLayers_0 = meshContinuum_0.getReferenceValues().get(NumPrismLayers.class);
    numPrismLayers_0.setNumLayers(5);
	
    MeshPipelineController meshPipelineController_0 = simulation_0.get(MeshPipelineController.class);
	
    meshPipelineController_0.generateVolumeMesh();
	
	// physics
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
	ConstantMaterialPropertyMethod constantMaterialPropertyMethod_1 = ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(DynamicViscosityProperty.class).getMethod());
	
	// gas properties
    constantMaterialPropertyMethod_0.getQuantity().setValue(rho;
    constantMaterialPropertyMethod_1.getQuantity().setValue(mu);
	
	// set mass flow rate
	directBoundaryInterface_0.getConditions().get(FullyDevelopedFlowOption.class).setSelected(FullyDevelopedFlowOption.MASS_FLOW_RATE);
	
    FullyDevelopedMassFlowRate fullyDevelopedMassFlowRate_0 = directBoundaryInterface_0.getValues().get(FullyDevelopedMassFlowRate.class);
	
    fullyDevelopedMassFlowRate_0.getFullyDevelopedMassFlowRate().setValue(massFlowRate);
	
	// inlet and outlet area average static pressure report
    AreaAverageReport areaAverageReport_0 = simulation_0.getReportManager().createReport(AreaAverageReport.class);
	AreaAverageReport areaAverageReport_1 = simulation_0.getReportManager().createReport(AreaAverageReport.class);
	
    DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_0 = ((DirectBoundaryInterfaceBoundary) region_0.getBoundaryManager().getBoundary("inlet [Periodic 1]"));
	DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_1 = ((DirectBoundaryInterfaceBoundary) region_0.getBoundaryManager().getBoundary("outlet [Periodic 1]"));
	
    areaAverageReport_0.getParts().setObjects(directBoundaryInterfaceBoundary_0);
	areaAverageReport_1.getParts().setObjects(directBoundaryInterfaceBoundary_1);
	
    PrimitiveFieldFunction primitiveFieldFunction_0 = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("StaticPressure"));

    areaAverageReport_0.setScalar(primitiveFieldFunction_0);
	areaAverageReport_1.setScalar(primitiveFieldFunction_0);

	// Expression 1 Report
	ExpressionReport expressionReport_0 = simulation_0.getReportManager().createReport(ExpressionReport.class);
	
    expressionReport_0.setDefinition("$SurfaceAverage2Report - $SurfaceAverage3Report\n");

	// Expression 1 Monitor
	
    ReportMonitor reportMonitor_0 = expressionReport_0.createMonitor();
	
	// Expression 1 Monitor Plot
	
    MonitorPlot monitorPlot_0 = simulation_0.getPlotManager().createMonitorPlot();
	
    monitorPlot_0.setPresentationName("Expression 1 Monitor Plot");
    monitorPlot_0.getMonitors().addObjects(reportMonitor_0);
	
	// create continuity and momentum stopping criteria
    ResidualMonitor residualMonitor_0 = ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("Continuity"));
	ResidualMonitor residualMonitor_1 = ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("X-momentum"));
	ResidualMonitor residualMonitor_2 = ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("Y-momentum"));
	ResidualMonitor residualMonitor_3 = ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("Z-momentum"));

    MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_0 = residualMonitor_0.createIterationStoppingCriterion();
    MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_1 = residualMonitor_1.createIterationStoppingCriterion();
    MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_2 = residualMonitor_2.createIterationStoppingCriterion();
    MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_3 = residualMonitor_3.createIterationStoppingCriterion();
	
	monitorIterationStoppingCriterion_0.getLogicalOption().setSelected(SolverStoppingCriterionLogicalOption.AND);
    monitorIterationStoppingCriterion_1.getLogicalOption().setSelected(SolverStoppingCriterionLogicalOption.AND);
	monitorIterationStoppingCriterion_2.getLogicalOption().setSelected(SolverStoppingCriterionLogicalOption.AND);
	monitorIterationStoppingCriterion_3.getLogicalOption().setSelected(SolverStoppingCriterionLogicalOption.AND);
	
	// disable number of steps stopping criteria
    StepStoppingCriterion stepStoppingCriterion_0 = ((StepStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Steps"));
	
    stepStoppingCriterion_0.setIsUsed(false);
	
	// save
    simulation_0.saveState(resolvePath(save_path));
  }
}
