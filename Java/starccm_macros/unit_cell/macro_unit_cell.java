// STAR-CCM+ macro: macro_unit_cell.java
package macro;

import java.
import java.util.*;
import java.io.*;

import star.common.*;
import star.energy.*;
import star.segregatedenergy.*;
import star.flow.*;
import star.meshing.*;
import star.segregatedflow.*;
import star.turbulence.*;
import star.material.*;
import star.kwturb.*;
import star.base.neo.*;
import star.base.report.*;
import star.resurfacer.*;
import star.dualmesher.*;
import star.prismmesher.*;
import star.metrics.*;
import star.vis.*;






public class macro_unit_cell extends StarMacro {

	private Simulation simulation_0;
	
	private Region region_fluid;
	private Region region_solid;

	private DirectBoundaryInterface directBoundaryInterface_periodic;
	private DirectBoundaryInterface directBoundaryInterface_inplace;
	
	private DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_periodic_inlet;
	private DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_periodic_outlet;
    private DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_inplace_fluid;
	private DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_inplace_solid;
    
	private Boundary boundary_top;
	
	private ReportMonitor reportMonitor_dp;
	
	private MonitorPlot monitorPlot_P;
	private MonitorPlot monitorPlot_T;
	
	private MeshContinuum meshContinuum_fluid;
    private MeshContinuum meshContinuum_solid;

    private PhysicsContinuum physicsContinuum_fluid;
    private PhysicsContinuum physicsContinuum_solid;
	
	private MeshPipelineController meshPipelineController_0
	
	private double D;
	private double P_T;
	
	
	private double massFlowRate;
	private double heatFlux;
	private double rho;
	private double mu;
	private double dpAvg;
	
	private double baseSize_fluid;
	private double baseSize_solid;
	
	private String session_abs_dir;
	private String session_dir;
	private String save_path;
	private String CAD_path;
	
  public void execute() {
    execute0();
  }
  private void initialize() {
	D = 500E-6;
	P_T = 1.4;
	
	massFlowRate = 3.0E-5;
	heatFlux = 1.0E6;
	rho = 91.28;
	mu = 36.7E-6;
	
	baseSize_fluid = D*( P_T  - 1.0 )/20.0;
	baseSize_solid = baseSize_fluid*5.0;
	
	session_abs_dir = simulation_0.getSessionDir();
	session_dir = session_abs_dir.substring(session_abs_dir.lastIndexOf('/') + 1);
	save_path = session_abs_dir + "/sim_unit_cell.sim";
	CAD_path = "/nfs/stak/students/r/rymalc/Windows.Documents/My Documents/SYNC/SUNSHOT/solidworks/unit_cell/" + session_dir + ".x_b";
  }
  private void geometry() {
	// import
    PartImportManager partImportManager_0 = simulation_0.get(PartImportManager.class);
    partImportManager_0.importCadPart(resolvePath(CAD_path), "SharpEdges", 30.0, 2, true, true);
	
	// rename parts
    CompositePart compositePart_0 = ((CompositePart) simulation_0.get(SimulationPartManager.class).getPart("Assembly 1"));
    compositePart_0.setPresentationName("cell");
	
    CadPart cadPart_0 = ((CadPart) compositePart_0.getChildParts().getPart("Part2^Assem1"));
	CadPart cadPart_1 = ((CadPart) compositePart_0.getChildParts().getPart("unit_cell_full_height"));
	
    cadPart_0.setPresentationName("solid");
    cadPart_1.setPresentationName("fluid");
	
	// split surface
    PartSurface partSurface_0 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces");

    PartCurve partCurve_0 = ((PartCurve) cadPart_0.getPartCurveManager().getObject("Edges"));

    cadPart_0.getPartSurfaceManager().splitPartSurfacesByPartCurves(new NeoObjectVector(new Object[] {partSurface_0}), new NeoObjectVector(new Object[] {partCurve_0}));
	
    PartSurface partSurface_1 = cadPart_1.getPartSurfaceManager().getPartSurface("Faces");
	
    PartCurve partCurve_1 = ((PartCurve) cadPart_1.getPartCurveManager().getObject("Edges"));

    cadPart_1.getPartSurfaceManager().splitPartSurfacesByPartCurves(new NeoObjectVector(new Object[] {partSurface_1}), new NeoObjectVector(new Object[] {partCurve_1}));
	
	// combine and rename surfaces
    PartSurface partSurface_2 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 2");
    PartSurface partSurface_3 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 8");
    PartSurface partSurface_4 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 6");
    PartSurface partSurface_5 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 12");
    PartSurface partSurface_6 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 18");
    PartSurface partSurface_7 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 19");

    cadPart_0.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_2, partSurface_3, partSurface_4, partSurface_5, partSurface_6, partSurface_7}));

    partSurface_2.setPresentationName("symmetry");

    PartSurface partSurface_8 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 22");

    partSurface_8.setPresentationName("top");

    PartSurface partSurface_9 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 25");

    partSurface_9.setPresentationName("bottom");

    PartSurface partSurface_10 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 3");
    PartSurface partSurface_11 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 4");
    PartSurface partSurface_12 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 5");
    PartSurface partSurface_13 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 7");
    PartSurface partSurface_14 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 9");
    PartSurface partSurface_15 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 10");
    PartSurface partSurface_16 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 11");
    PartSurface partSurface_17 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 13");
    PartSurface partSurface_18 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 14");
    PartSurface partSurface_19 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 15");
    PartSurface partSurface_20 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 16");
    PartSurface partSurface_21 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 17");
    PartSurface partSurface_22 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 20");
    PartSurface partSurface_23 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 21");
    PartSurface partSurface_24 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 23");
    PartSurface partSurface_25 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 24");
    PartSurface partSurface_26 = cadPart_0.getPartSurfaceManager().getPartSurface("Faces 26");

    cadPart_0.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_10, partSurface_11, partSurface_12, partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22, partSurface_23, partSurface_0, partSurface_24, partSurface_25, partSurface_26}));

    partSurface_10.setPresentationName("wall");

    partSurface_1.setPresentationName("wall");

    PartSurface partSurface_27 = cadPart_1.getPartSurfaceManager().getPartSurface("Faces 2");

    partSurface_27.setPresentationName("inlet");

    PartSurface partSurface_28 = cadPart_1.getPartSurfaceManager().getPartSurface("Faces 4");

    partSurface_28.setPresentationName("outlet");

    PartSurface partSurface_29 = cadPart_1.getPartSurfaceManager().getPartSurface("Faces 3");
    PartSurface partSurface_30 = cadPart_1.getPartSurfaceManager().getPartSurface("Faces 5");
    PartSurface partSurface_31 = cadPart_1.getPartSurfaceManager().getPartSurface("Faces 6");
    PartSurface partSurface_32 = cadPart_1.getPartSurfaceManager().getPartSurface("Faces 7");
	
    cadPart_1.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_29, partSurface_30, partSurface_31, partSurface_32}));
	
    partSurface_29.setPresentationName("symmetry");
	
	// create regions without contact interface
    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {cadPart_0, cadPart_1}), "OneRegionPerPart", null, "OneBoundaryPerPartSurface", null, "OneFeatureCurvePerPartCurve", null, false);
	
	// region variables
	region_fluid = simulation_0.getRegionManager().getRegion("cell.fluid");
	region_solid = simulation_0.getRegionManager().getRegion("cell.solid");
  }
  private void continua() {
  
	// create continua
	meshContinuum_fluid = simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);
	meshContinuum_solid = simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);

	physicsContinuum_fluid = simulation_0.getContinuumManager().createContinuum(PhysicsContinuum.class);
	physicsContinuum_solid = simulation_0.getContinuumManager().createContinuum(PhysicsContinuum.class);

	meshContinuum_fluid.setPresentationName("Mesh fluid");
	meshContinuum_solid.setPresentationName("Mesh solid");

	physicsContinuum_fluid.setPresentationName("Physics fluid");
	physicsContinuum_solid.setPresentationName("Physics solid");

	// remove solid region from fluid continua and add to solid mesh continuum
	meshContinuum_fluid.erase(region_solid);
	physicsContinuum_fluid.erase(region_solid);
	meshContinuum_solid.add(region_solid);
	region_solid.setRegionType(SolidRegion.class);

	// mesh continuum
	meshContinuum_fluid.enable(ResurfacerMeshingModel.class);
	meshContinuum_fluid.enable(DualMesherModel.class);
	meshContinuum_fluid.enable(PrismMesherModel.class);
	meshContinuum_fluid.getReferenceValues().get(BaseSize.class).setValue(baseSize_fluid);

	NumPrismLayers numPrismLayers_0 = meshContinuum_fluid.getReferenceValues().get(NumPrismLayers.class);

	numPrismLayers_0.setNumLayers(5);

	meshContinuum_solid.enable(ResurfacerMeshingModel.class);
	meshContinuum_solid.enable(DualMesherModel.class);
	meshContinuum_solid.getReferenceValues().get(BaseSize.class).setValue(baseSize_solid);

	// fluid physics continuum
	physicsContinuum_fluid.enable(ThreeDimensionalModel.class);
	physicsContinuum_fluid.enable(SteadyModel.class);
	physicsContinuum_fluid.enable(SingleComponentGasModel.class);
	physicsContinuum_fluid.enable(SegregatedFlowModel.class);
	physicsContinuum_fluid.enable(ConstantDensityModel.class);
	physicsContinuum_fluid.enable(TurbulentModel.class);
	physicsContinuum_fluid.enable(RansTurbulenceModel.class);
	physicsContinuum_fluid.enable(KOmegaTurbulence.class);
	physicsContinuum_fluid.enable(SstKwTurbModel.class);
	physicsContinuum_fluid.enable(KwAllYplusWallTreatment.class);

	// fluid properties
	SingleComponentGasModel singleComponentGasModel_0 = physicsContinuum_fluid.getModelManager().getModel(SingleComponentGasModel.class);
	Gas gas_0 = ((Gas) singleComponentGasModel_0.getMaterial());
	ConstantMaterialPropertyMethod constantMaterialPropertyMethod_0 = ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(ConstantDensityProperty.class).getMethod());
	ConstantMaterialPropertyMethod constantMaterialPropertyMethod_1 = ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(DynamicViscosityProperty.class).getMethod());
	constantMaterialPropertyMethod_0.getQuantity().setValue(rho);
	constantMaterialPropertyMethod_1.getQuantity().setValue(mu);

	// solid physics continuum
	physicsContinuum_solid.enable(ThreeDimensionalModel.class);
	physicsContinuum_solid.enable(SteadyModel.class);
	physicsContinuum_solid.enable(SolidModel.class);
	physicsContinuum_solid.enable(SegregatedSolidEnergyModel.class);
	physicsContinuum_solid.enable(ConstantDensityModel.class);
  
  }
  private void plots() {
	// boundary variables
	directBoundaryInterfaceBoundary_periodic_inlet = ((DirectBoundaryInterfaceBoundary) region_fluid.getBoundaryManager().getBoundary("inlet [Periodic 1]"));
	directBoundaryInterfaceBoundary_periodic_outlet = ((DirectBoundaryInterfaceBoundary) region_fluid.getBoundaryManager().getBoundary("outlet [Periodic 1]"));
    
	boundary_top = region_solid.getBoundaryManager().getBoundary("top");
	
	// field functions
	PrimitiveFieldFunction primitiveFieldFunction_0 = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("StaticPressure"));
	
	// reports
	AreaAverageReport areaAverageReport_0 = simulation_0.getReportManager().createReport(AreaAverageReport.class);
	AreaAverageReport areaAverageReport_1 = simulation_0.getReportManager().createReport(AreaAverageReport.class);
	
	
	ExpressionReport expressionReport_0 = simulation_0.getReportManager().createReport(ExpressionReport.class);
	
	// rename
    areaAverageReport_0.setPresentationName("P0");
	areaAverageReport_1.setPresentationName("P1");
	
	
	expressionReport_0.setPresentationName("dP");

	// field function
	areaAverageReport_0.setScalar(primitiveFieldFunction_0);
	areaAverageReport_1.setScalar(primitiveFieldFunction_0);
	
    expressionReport_dp.setDefinition("$P1Report - $P0Report");
	
	// objects
	areaAverageReport_0.getParts().setObjects(directBoundaryInterfaceBoundary_periodic_inlet);
    areaAverageReport_1.getParts().setObjects(directBoundaryInterfaceBoundary_periodic_outlet);
	
	
	// monitors
    reportMonitor_dp = expressionReport_dp.createMonitor();
	
	// plots
    monitorPlot_P = simulation_0.getPlotManager().createMonitorPlot();
	
    monitorPlot_P.setPresentationName("dP Plot");
	
    monitorPlot_P.getMonitors().addObjects(reportMonitor_0);
  }
  private void plots2() {
	directBoundaryInterfaceBoundary_inplace_fluid = ((DirectBoundaryInterfaceBoundary) region_fluid.getBoundaryManager().getBoundary("wall [In-place 1]"));
	directBoundaryInterfaceBoundary_inplace_solid = ((DirectBoundaryInterfaceBoundary) region_solid.getBoundaryManager().getBoundary("wall [In-place 1]"));
	
	PrimitiveFieldFunction primitiveFieldFunction_1 = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Temperature"));
	
	AreaAverageReport areaAverageReport_2 = simulation_0.getReportManager().createReport(AreaAverageReport.class);
	AreaAverageReport areaAverageReport_3 = simulation_0.getReportManager().createReport(AreaAverageReport.class);
	AreaAverageReport areaAverageReport_4 = simulation_0.getReportManager().createReport(AreaAverageReport.class);
	AreaAverageReport areaAverageReport_5 = simulation_0.getReportManager().createReport(AreaAverageReport.class);
	AreaAverageReport areaAverageReport_6 = simulation_0.getReportManager().createReport(AreaAverageReport.class);

	areaAverageReport_2.setPresentationName("T fluid wall");
	areaAverageReport_3.setPresentationName("T solid wall");
	areaAverageReport_4.setPresentationName("T fluid inlet");
	areaAverageReport_5.setPresentationName("T fluid outelt");
	areaAverageReport_6.setPresentationName("T top");

	areaAverageReport_2.setScalar(primitiveFieldFunction_1);
	areaAverageReport_3.setScalar(primitiveFieldFunction_1);
	areaAverageReport_4.setScalar(primitiveFieldFunction_1);
	areaAverageReport_5.setScalar(primitiveFieldFunction_1);
	areaAverageReport_6.setScalar(primitiveFieldFunction_1);
	
	areaAverageReport_2.getParts().setObjects(directBoundaryInterfaceBoundary_inplace_fluid);
	areaAverageReport_3.getParts().setObjects(directBoundaryInterfaceBoundary_inplace_solid);
	areaAverageReport_4.getParts().setObjects(directBoundaryInterfaceBoundary_periodic_inlet);
	areaAverageReport_5.getParts().setObjects(directBoundaryInterfaceBoundary_periodic_outlet);
	areaAverageReport_6.getParts().setObjects(boundary_top);

	ReportMonitor reportMonitor_1 = areaAverageReport_2.createMonitor();
	ReportMonitor reportMonitor_2 = areaAverageReport_3.createMonitor();
	ReportMonitor reportMonitor_3 = areaAverageReport_4.createMonitor();
	ReportMonitor reportMonitor_4 = areaAverageReport_5.createMonitor();
	ReportMonitor reportMonitor_5 = areaAverageReport_6.createMonitor();
	
	monitorPlot_T = simulation_0.getPlotManager().createMonitorPlot();
	
	monitorPlot_T.setPresentationName("T Plot");
	
	monitorPlot_T.getMonitors().addObjects(reportMonitor_1,reportMonitor_2,reportMonitor_3,reportMonitor_4,reportMonitor_5);
  }
  private void section_plane() {
	// create section plane
    Units units_0 = simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
	
    PlaneSection planeSection_0 = (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {region_fluid, region_solid}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), new DoubleVector(new double[] {0.0, 0.0182, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));
	
    LabCoordinateSystem labCoordinateSystem_0 = simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();
	
    planeSection_0.setCoordinateSystem(labCoordinateSystem_0);
	
    Coordinate coordinate_0 = planeSection_0.getOriginCoordinate();
	Coordinate coordinate_1 = planeSection_0.getOrientationCoordinate();
	
    coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.0182, 0.0}));
	coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1.0, 0.0}));

	coordinate_0.setValue(new DoubleVector(new double[] {0.0, 0.0182, 0.0}));
    coordinate_1.setValue(new DoubleVector(new double[] {0.0, 1.0, 0.0}));
	
    SingleValue singleValue_0 = planeSection_0.getSingleValue();
	
    singleValue_0.getValueQuantity().setValue(0.0);
    singleValue_0.getValueQuantity().setUnits(units_0);

    RangeMultiValue rangeMultiValue_0 = planeSection_0.getRangeMultiValue();
	
    rangeMultiValue_0.setNValues(2);
	
    rangeMultiValue_0.getStartQuantity().setValue(0.0);
    rangeMultiValue_0.getStartQuantity().setUnits(units_0);
	
    rangeMultiValue_0.getEndQuantity().setValue(1.0);
    rangeMultiValue_0.getEndQuantity().setUnits(units_0);

    DeltaMultiValue deltaMultiValue_0 = planeSection_0.getDeltaMultiValue();

    deltaMultiValue_0.setNValues(2);

    deltaMultiValue_0.getStartQuantity().setValue(0.0);
    deltaMultiValue_0.getStartQuantity().setUnits(units_0);

    deltaMultiValue_0.getDeltaQuantity().setValue(1.0);
    deltaMultiValue_0.getDeltaQuantity().setUnits(units_0);

    MultiValue multiValue_0 = planeSection_0.getArbitraryMultiValue();

    multiValue_0.getValueQuantities().setUnits(units_0);
    multiValue_0.getValueQuantities().setArray(new DoubleVector(new double[] {0.0}));

    planeSection_0.setValueMode(0);
  }
  private void stopping() {
	// stopping criteria
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
	}
  private void periodic() {
  
  // periodic interface
    Boundary boundary_0 = region_fluid.getBoundaryManager().getBoundary("inlet");
    Boundary boundary_1 = region_fluid.getBoundaryManager().getBoundary("outlet");

    directBoundaryInterface_periodic = simulation_0.getInterfaceManager().createDirectInterface(boundary_0, boundary_1, "Periodic");

    directBoundaryInterface_periodic.getTopology().setSelected(InterfaceConfigurationOption.PERIODIC);
    directBoundaryInterface_periodic.setInterfaceType(FullyDevelopedInterface.class);

    InterfacePeriodicTransformSpecification interfacePeriodicTransformSpecification_0 = directBoundaryInterface_periodic.getPeriodicTransform();
    interfacePeriodicTransformSpecification_0.getPeriodicityOption().setSelected(PeriodicityOption.TRANSLATION);

    directBoundaryInterface_periodic.getConditions().get(FullyDevelopedFlowOption.class).setSelected(FullyDevelopedFlowOption.MASS_FLOW_RATE);

    FullyDevelopedMassFlowRate fullyDevelopedMassFlowRate_0 = directBoundaryInterface_periodic.getValues().get(FullyDevelopedMassFlowRate.class);
    fullyDevelopedMassFlowRate_0.getFullyDevelopedMassFlowRate().setValue(massFlowRate);
  
  }
  private void turn_on_solid() {
  
  // enable solid physics continuum
    physicsContinuum_solid.add(region_solid);
	
	// enable fluid physics continuum segregated fluid temperature
	physicsContinuum_fluid.enable(SegregatedFluidTemperatureModel.class);
	
	// create contact interface
    Boundary boundary_fluid_wall = region_fluid.getBoundaryManager().getBoundary("wall");
    Boundary boundary_solid_wall = region_solid.getBoundaryManager().getBoundary("wall");
	
    directBoundaryInterface_inplace = simulation_0.getInterfaceManager().createDirectInterface(boundary_fluid_wall, boundary_solid_wall, "In-place");
    directBoundaryInterface_inplace.getTopology().setSelected(InterfaceConfigurationOption.IN_PLACE);

	// set periodic interface energy option
    directBoundaryInterface_periodic.getConditions().get(FullyDevelopedEnergyJumpOption.class).setSelected(FullyDevelopedEnergyJumpOption.CONSTANT_HEAT_FLUX_WALLS);
	
	// set top boundary heat flux condition
    boundary_top.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.HEAT_FLUX);
    HeatFluxProfile heatFluxProfile_0 = boundary_top.getValues().get(HeatFluxProfile.class);
    heatFluxProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(heatFlux);
  
  }
  private void mdot() {
  
	double S_T = D * P_T;
	double S_L = sqrt(3)/2*S_T;
	double H = 4*(S_T-D);
	double A_min = (S_T-D)*H;
	double w = S_T;
	
	double dp  = 28000;
	double qpp = 1e6;
	double dh  = 184763.21225;
	
	double v_max = massFlowRate/(rho*A_min);
	
	double f = dpAvg/2/(rho*v_max^2/2)
	
	double C_1 = 2*dp*S_L / ( rho*f );
	double C_2 = ( rho*A_min*dh ) / ( w*qpp );

	v_max = (C_1/C_2)^(1/3);
	massFlowRate = rho*A_min*v_max;
  }
  private void boundary() {
	Boundary boundary_0 = region_fluid.getBoundaryManager().getBoundary("symmetry");
    boundary_0.setBoundaryType(SymmetryBoundary.class);

    Boundary boundary_1 = region_solid.getBoundaryManager().getBoundary("symmetry");
    boundary_1.setBoundaryType(SymmetryBoundary.class);
  }
  private void execute0() {
	// simulation
    simulation_0 = getActiveSimulation();
	
	initialize();
	geometry();
	continua();
	periodic();
	boundary();
	
	// generate mesh
	meshPipelineController_0 = simulation_0.get(MeshPipelineController.class);
    meshPipelineController_0.generateVolumeMesh();
	
	stopping();
	plots();
	section_plane();
	
	simulation_0.println("massFlowRate = "+massFlowRate);
	
	// run fluid simulation
	int dpNumValues = 5;
	DataSet dataSet_dp;
	Double [] dpValues;
	double massFlowRate_old;
	while (true)
	{
		simulation_0.getSimulationIterator().run(10);
		
		simulation_0.println("run complete");
		
		dataSet_dp = monitorPlot_P.getDataSet(reportMonitor_dp);
		dpValues = dataSet_dp.getYValues();
		
		dpAvg = 0;
		for ( int i = (dpValues.length-dpNumValues); i < dpValues.length; i++ ) {
			dpAvg += dpValues[i];
		}
		dpAvg /= dpNumValues;
		
		simulation_0.println("dpAvg = "+dpAvg);
		
		massFlowRate_old = massFlowRate;
		massFlowRate = mdot();
		
		if ( (massFlowRate-massFlowRate_old)/massFlowRate )
		
		simulation_0.println("massFlowRate = "+massFlowRate);
	}
	
	
	turn_on_solid();
	plots2();
	
	// save
	simulation_0.saveState(resolvePath(save_path));
	
	// run
    simulation_0.getSimulationIterator().run(5);
    
  }
}
