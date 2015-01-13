// STAR-CCM+ macro: mac_1_assem.java
package macro;

import java.util.*;

import star.common.*;
import star.coupledflow.*;
import star.solidmesher.*;
import star.flow.*;
import star.segregatedflow.*;
import star.meshing.*;
import star.turbulence.*;
import star.material.*;
import star.kwturb.*;
import star.base.neo.*;
import star.vis.*;
import star.resurfacer.*;
import star.base.report.*;
import star.dualmesher.*;
import star.prismmesher.*;
import star.energy.*;

public class mac_1_assem extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PartImportManager partImportManager_0 = 
      simulation_0.get(PartImportManager.class);

    partImportManager_0.importCadPart(resolvePath("Z:\\Windows.Documents\\My Documents\\SYNC\\SUNSHOT\\solidworks\\unit_cell\\Assem1.x_b"), "SharpEdges", 30.0, 2, true, true);

    CompositePart compositePart_0 = 
      ((CompositePart) simulation_0.get(SimulationPartManager.class).getPart("Assembly 1"));

    CadPart cadPart_0 = 
      ((CadPart) compositePart_0.getChildParts().getPart("Part2^Assem1"));

    PartSurface partSurface_0 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces");

    PartCurve partCurve_0 = 
      ((PartCurve) cadPart_0.getPartCurveManager().getObject("Edges"));

    cadPart_0.getPartSurfaceManager().splitPartSurfacesByPartCurves(new NeoObjectVector(new Object[] {partSurface_0}), new NeoObjectVector(new Object[] {partCurve_0}));

    CadPart cadPart_1 = 
      ((CadPart) compositePart_0.getChildParts().getPart("unit_cell_full_height"));

    PartSurface partSurface_1 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("Faces");

    PartCurve partCurve_1 = 
      ((PartCurve) cadPart_1.getPartCurveManager().getObject("Edges"));

    cadPart_1.getPartSurfaceManager().splitPartSurfacesByPartCurves(new NeoObjectVector(new Object[] {partSurface_1}), new NeoObjectVector(new Object[] {partCurve_1}));

    PartSurface partSurface_2 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 8");

    partSurface_2.setPresentationName("top_inlet");

    PartSurface partSurface_3 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 6");

    partSurface_3.setPresentationName("bottom_inlet");

    PartSurface partSurface_4 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 18");

    partSurface_4.setPresentationName("top_outlet");

    PartSurface partSurface_5 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 19");

    partSurface_5.setPresentationName("bottom_outlet");

    PartSurface partSurface_6 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 2");

    PartSurface partSurface_7 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 12");

    cadPart_0.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_6, partSurface_7}));

    partSurface_6.setPresentationName("symmetry");

    PartSurface partSurface_8 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 22");

    partSurface_8.setPresentationName("top");

    PartSurface partSurface_9 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 25");

    partSurface_9.setPresentationName("bottom");

    PartSurface partSurface_10 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 3");

    PartSurface partSurface_11 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 4");

    PartSurface partSurface_12 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 5");

    PartSurface partSurface_13 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 7");

    PartSurface partSurface_14 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 9");

    PartSurface partSurface_15 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 10");

    PartSurface partSurface_16 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 11");

    PartSurface partSurface_17 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 13");

    PartSurface partSurface_18 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 14");

    PartSurface partSurface_19 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 15");

    PartSurface partSurface_20 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 16");

    PartSurface partSurface_21 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 17");

    PartSurface partSurface_22 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 20");

    PartSurface partSurface_23 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 21");

    PartSurface partSurface_24 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 23");

    PartSurface partSurface_25 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 24");

    PartSurface partSurface_26 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 26");

    cadPart_0.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_10, partSurface_11, partSurface_12, partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22, partSurface_23, partSurface_24, partSurface_25, partSurface_26, partSurface_0}));

    partSurface_10.setPresentationName("contact");

    PartSurface partSurface_27 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("Faces 2");

    partSurface_27.setPresentationName("inlet");

    PartSurface partSurface_28 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("Faces 4");

    partSurface_28.setPresentationName("outlet");

    PartSurface partSurface_29 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("Faces 6");

    PartSurface partSurface_30 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("Faces 3");

    PartSurface partSurface_31 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("Faces 5");

    PartSurface partSurface_32 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("Faces 7");

    cadPart_1.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_29, partSurface_30, partSurface_31, partSurface_32}));

    partSurface_29.setPresentationName("symmetry");

    partSurface_1.setPresentationName("contact");

    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {cadPart_0, cadPart_1}), "OneRegionPerPart", null, "OneBoundaryPerPartSurface", null, "OneFeatureCurvePerPartCurve", null, true);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Assembly 1.Part2^Assem1");

    region_0.setRegionType(SolidRegion.class);

    MeshContinuum meshContinuum_0 = 
      simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);

    MeshContinuum meshContinuum_1 = 
      simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);

    PhysicsContinuum physicsContinuum_0 = 
      simulation_0.getContinuumManager().createContinuum(PhysicsContinuum.class);

    PhysicsContinuum physicsContinuum_1 = 
      simulation_0.getContinuumManager().createContinuum(PhysicsContinuum.class);

    meshContinuum_1.add(region_0);

    physicsContinuum_1.add(region_0);

    meshContinuum_0.enable(ResurfacerMeshingModel.class);

    meshContinuum_0.enable(DualMesherModel.class);

    meshContinuum_0.enable(SolidMesherSubModel.class);

    SolidMesherSubModel solidMesherSubModel_0 = 
      meshContinuum_0.getModelManager().getModel(SolidMesherSubModel.class);

    meshContinuum_0.disableModel(solidMesherSubModel_0);

    meshContinuum_0.enable(PrismMesherModel.class);

    meshContinuum_1.enable(ResurfacerMeshingModel.class);

    meshContinuum_1.enable(DualMesherModel.class);

    meshContinuum_0.getReferenceValues().get(BaseSize.class).setValue(1.0E-4);

    meshContinuum_1.getReferenceValues().get(BaseSize.class).setValue(2.0E-4);

    MeshPipelineController meshPipelineController_0 = 
      simulation_0.get(MeshPipelineController.class);

    meshPipelineController_0.generateVolumeMesh();

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("bottom_inlet");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("bottom_outlet");

    DirectBoundaryInterface directBoundaryInterface_0 = 
      simulation_0.getInterfaceManager().createDirectInterface(boundary_0, boundary_1, "Periodic");

    directBoundaryInterface_0.getTopology().setSelected(InterfaceConfigurationOption.PERIODIC);

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("top_inlet");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("top_outlet");

    DirectBoundaryInterface directBoundaryInterface_1 = 
      simulation_0.getInterfaceManager().createDirectInterface(boundary_2, boundary_3, "Periodic");

    directBoundaryInterface_1.getTopology().setSelected(InterfaceConfigurationOption.PERIODIC);

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("Assembly 1.unit_cell_full_height");

    Boundary boundary_4 = 
      region_1.getBoundaryManager().getBoundary("inlet");

    Boundary boundary_5 = 
      region_1.getBoundaryManager().getBoundary("outlet");

    DirectBoundaryInterface directBoundaryInterface_2 = 
      simulation_0.getInterfaceManager().createDirectInterface(boundary_4, boundary_5, "Periodic");

    directBoundaryInterface_2.getTopology().setSelected(InterfaceConfigurationOption.PERIODIC);

    InterfacePeriodicTransformSpecification interfacePeriodicTransformSpecification_0 = 
      directBoundaryInterface_0.getPeriodicTransform();

    interfacePeriodicTransformSpecification_0.getPeriodicityOption().setSelected(PeriodicityOption.TRANSLATION);

    InterfacePeriodicTransformSpecification interfacePeriodicTransformSpecification_1 = 
      directBoundaryInterface_1.getPeriodicTransform();

    interfacePeriodicTransformSpecification_1.getPeriodicityOption().setSelected(PeriodicityOption.TRANSLATION);

    InterfacePeriodicTransformSpecification interfacePeriodicTransformSpecification_2 = 
      directBoundaryInterface_2.getPeriodicTransform();

    interfacePeriodicTransformSpecification_2.getPeriodicityOption().setSelected(PeriodicityOption.TRANSLATION);

    physicsContinuum_0.enable(SteadyModel.class);

    physicsContinuum_0.enable(SingleComponentGasModel.class);

    physicsContinuum_0.enable(CoupledFlowModel.class);

    physicsContinuum_0.enable(ConstantDensityModel.class);

    physicsContinuum_0.enable(TurbulentModel.class);

    physicsContinuum_0.enable(RansTurbulenceModel.class);

    physicsContinuum_0.enable(KOmegaTurbulence.class);

    physicsContinuum_0.enable(SstKwTurbModel.class);

    physicsContinuum_0.enable(KwAllYplusWallTreatment.class);

    physicsContinuum_1.enable(SteadyModel.class);

    physicsContinuum_1.enable(SolidModel.class);

    physicsContinuum_1.enable(CoupledSolidEnergyModel.class);

    physicsContinuum_1.enable(ConstantDensityModel.class);

    directBoundaryInterface_2.setInterfaceType(FullyDevelopedInterface.class);

    directBoundaryInterface_2.getConditions().get(FullyDevelopedFlowOption.class).setSelected(FullyDevelopedFlowOption.MASS_FLOW_RATE);

    FullyDevelopedMassFlowRate fullyDevelopedMassFlowRate_0 = 
      directBoundaryInterface_2.getValues().get(FullyDevelopedMassFlowRate.class);

    fullyDevelopedMassFlowRate_0.getFullyDevelopedMassFlowRate().setValue(1.0E-5);

    physicsContinuum_0.enable(CoupledEnergyModel.class);

    ResidualMonitor residualMonitor_0 = 
      ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("Continuity"));

    MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_0 = 
      residualMonitor_0.createIterationStoppingCriterion();

    ResidualMonitor residualMonitor_1 = 
      ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("X-momentum"));

    MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_1 = 
      residualMonitor_1.createIterationStoppingCriterion();

    ResidualMonitor residualMonitor_2 = 
      ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("Y-momentum"));

    MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_2 = 
      residualMonitor_2.createIterationStoppingCriterion();

    ResidualMonitor residualMonitor_3 = 
      ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("Z-momentum"));

    MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_3 = 
      residualMonitor_3.createIterationStoppingCriterion();

    monitorIterationStoppingCriterion_0.getLogicalOption().setSelected(SolverStoppingCriterionLogicalOption.AND);

    monitorIterationStoppingCriterion_1.getLogicalOption().setSelected(SolverStoppingCriterionLogicalOption.AND);

    monitorIterationStoppingCriterion_2.getLogicalOption().setSelected(SolverStoppingCriterionLogicalOption.AND);

    monitorIterationStoppingCriterion_3.getLogicalOption().setSelected(SolverStoppingCriterionLogicalOption.AND);

    StepStoppingCriterion stepStoppingCriterion_0 = 
      ((StepStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Steps"));

    stepStoppingCriterion_0.setIsUsed(false);

    AreaAverageReport areaAverageReport_0 = 
      simulation_0.getReportManager().createReport(AreaAverageReport.class);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("ConnectedCells"));

    areaAverageReport_0.setScalar(primitiveFieldFunction_0);

    PrimitiveFieldFunction primitiveFieldFunction_1 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("StaticPressure"));

    areaAverageReport_0.setScalar(primitiveFieldFunction_1);

    DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_0 = 
      ((DirectBoundaryInterfaceBoundary) region_1.getBoundaryManager().getBoundary("inlet [Periodic 3]"));

    areaAverageReport_0.getParts().setObjects(directBoundaryInterfaceBoundary_0);

    AreaAverageReport areaAverageReport_1 = 
      simulation_0.getReportManager().createReport(AreaAverageReport.class);

    DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_1 = 
      ((DirectBoundaryInterfaceBoundary) region_1.getBoundaryManager().getBoundary("outlet [Periodic 3]"));

    areaAverageReport_1.getParts().setObjects(directBoundaryInterfaceBoundary_1);

    areaAverageReport_1.setScalar(primitiveFieldFunction_1);

    ExpressionReport expressionReport_0 = 
      simulation_0.getReportManager().createReport(ExpressionReport.class);

    expressionReport_0.setDefinition("0");

    areaAverageReport_0.setPresentationName("StaticPressureInlet");

    areaAverageReport_1.setPresentationName("StaticPressureOutlet");

    expressionReport_0.setDefinition("$StaticPressureOutletReport - $StaticPressureInletReport");

    expressionReport_0.printReport();

    AreaAverageReport areaAverageReport_2 = 
      simulation_0.getReportManager().createReport(AreaAverageReport.class);

    DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_2 = 
      ((DirectBoundaryInterfaceBoundary) region_1.getBoundaryManager().getBoundary("contact [Part2^Assem1/unit_cell_full_height]"));

    areaAverageReport_2.getParts().setObjects(directBoundaryInterfaceBoundary_2);

    PrimitiveFieldFunction primitiveFieldFunction_2 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Temperature"));

    areaAverageReport_2.setScalar(primitiveFieldFunction_2);

    areaAverageReport_2.setPresentationName("TemperatureFluidContact");

    AreaAverageReport areaAverageReport_3 = 
      simulation_0.getReportManager().createReport(AreaAverageReport.class);

    DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_3 = 
      ((DirectBoundaryInterfaceBoundary) region_0.getBoundaryManager().getBoundary("contact [Part2^Assem1/unit_cell_full_height]"));

    areaAverageReport_3.getParts().setObjects(directBoundaryInterfaceBoundary_3);

    areaAverageReport_3.setScalar(primitiveFieldFunction_2);

    areaAverageReport_3.setPresentationName("TemperatureSolidContact");

    VolumeAverageReport volumeAverageReport_0 = 
      simulation_0.getReportManager().createReport(VolumeAverageReport.class);

    volumeAverageReport_0.getParts().setObjects(region_1);

    volumeAverageReport_0.setPresentationName("TemperatureFluid");

    PrimitiveFieldFunction primitiveFieldFunction_3 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("LocalCellIndex"));

    volumeAverageReport_0.setScalar(primitiveFieldFunction_3);

    volumeAverageReport_0.setScalar(primitiveFieldFunction_2);

    expressionReport_0.setPresentationName("StaticPressureDrop");

    simulation_0.saveState(resolvePath("Z:\\Windows.Documents\\My Documents\\SYNC\\sim_unit_cell_assem_test.sim"));

    simulation_0.getSimulationIterator().run();

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    PlaneSection planeSection_0 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {region_0, region_1}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), new DoubleVector(new double[] {-0.05131095186416396, 0.01821502438936842, 0.013569468584133331}), 0, 1, new DoubleVector(new double[] {0.0}));

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    planeSection_0.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_0 = 
      planeSection_0.getOriginCoordinate();

    coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-0.05131095186416396, 0.01821502438936842, 0.013569468584133331}));

    Coordinate coordinate_1 = 
      planeSection_0.getOrientationCoordinate();

    coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_1.setValue(new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_0.setValue(new DoubleVector(new double[] {-0.05131095186416396, 0.01821502438936842, 0.013569468584133331}));

    SingleValue singleValue_0 = 
      planeSection_0.getSingleValue();

    singleValue_0.getValueQuantity().setValue(0.0);

    singleValue_0.getValueQuantity().setUnits(units_0);

    RangeMultiValue rangeMultiValue_0 = 
      planeSection_0.getRangeMultiValue();

    rangeMultiValue_0.setNValues(2);

    rangeMultiValue_0.getStartQuantity().setValue(0.0);

    rangeMultiValue_0.getStartQuantity().setUnits(units_0);

    rangeMultiValue_0.getEndQuantity().setValue(1.0);

    rangeMultiValue_0.getEndQuantity().setUnits(units_0);

    DeltaMultiValue deltaMultiValue_0 = 
      planeSection_0.getDeltaMultiValue();

    deltaMultiValue_0.setNValues(2);

    deltaMultiValue_0.getStartQuantity().setValue(0.0);

    deltaMultiValue_0.getStartQuantity().setUnits(units_0);

    deltaMultiValue_0.getDeltaQuantity().setValue(1.0);

    deltaMultiValue_0.getDeltaQuantity().setUnits(units_0);

    MultiValue multiValue_0 = 
      planeSection_0.getArbitraryMultiValue();

    multiValue_0.getValueQuantities().setUnits(units_0);

    multiValue_0.getValueQuantities().setArray(new DoubleVector(new double[] {0.0}));

    planeSection_0.setValueMode(0);

    coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-0.05131095186416396, 0.0182, 0.013569468584133331}));

    simulation_0.getSimulationIterator().run();

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("top");

    boundary_6.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.HEAT_FLUX);

    HeatFluxProfile heatFluxProfile_0 = 
      boundary_6.getValues().get(HeatFluxProfile.class);

    heatFluxProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(100.0);

    simulation_0.getSimulationIterator().run();

    heatFluxProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(10000.0);

    simulation_0.getSimulationIterator().run();

    directBoundaryInterface_2.getConditions().get(FullyDevelopedEnergyJumpOption.class).setSelected(FullyDevelopedEnergyJumpOption.CONSTANT_HEAT_FLUX_WALLS);

    InterfaceBulkTemperature interfaceBulkTemperature_0 = 
      directBoundaryInterface_2.getValues().get(InterfaceBulkTemperature.class);

    interfaceBulkTemperature_0.getBulkTemperature().setValue(310.0);

    Solution solution_0 = 
      simulation_0.getSolution();

    solution_0.clearSolution();

    simulation_0.getSimulationIterator().run();

    heatFluxProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(1000.0);

    heatFluxProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(100.0);

    solution_0.clearSolution();

    simulation_0.getSimulationIterator().run();

    solution_0.clearSolution();

    heatFluxProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(1.0);

    solution_0.initializeSolution();

    simulation_0.getSimulationIterator().run();

    DirectBoundaryInterface directBoundaryInterface_3 = 
      ((DirectBoundaryInterface) simulation_0.getInterfaceManager().getInterface("Part2^Assem1/unit_cell_full_height"));

    directBoundaryInterface_3.getConditions().get(EnergyUserSurfaceSourceOption.class).setSelected(EnergyUserSurfaceSourceOption.HEAT_FLUX);

    directBoundaryInterface_3.getConditions().get(EnergyUserSurfaceSourceOption.class).setSelected(EnergyUserSurfaceSourceOption.NONE);

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("symmetry");

    boundary_7.setBoundaryType(SymmetryBoundary.class);

    Boundary boundary_8 = 
      region_1.getBoundaryManager().getBoundary("symmetry");

    boundary_8.setBoundaryType(SymmetryBoundary.class);

    heatFluxProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.0);

    solution_0.clearSolution();

    simulation_0.getSimulationIterator().run();

    directBoundaryInterface_2.getConditions().get(FullyDevelopedEnergyJumpOption.class).setSelected(FullyDevelopedEnergyJumpOption.SPECIFIED_TEMPERATURE_JUMP);

    directBoundaryInterface_2.getConditions().get(FullyDevelopedEnergyJumpOption.class).setSelected(FullyDevelopedEnergyJumpOption.CONSTANT_TEMPERATURE_WALLS);

    directBoundaryInterface_2.getConditions().get(FullyDevelopedEnergyJumpOption.class).setSelected(FullyDevelopedEnergyJumpOption.CONSTANT_HEAT_FLUX_WALLS);

    directBoundaryInterfaceBoundary_2.getConditions().get(UserWallHeatFluxCoefficientOption.class).setSelected(UserWallHeatFluxCoefficientOption.USER_DEFINED);

    directBoundaryInterfaceBoundary_2.getConditions().get(UserWallHeatFluxCoefficientOption.class).setSelected(UserWallHeatFluxCoefficientOption.NONE);

    Boundary boundary_9 = 
      region_1.getBoundaryManager().getBoundary("contact");

    boundary_9.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.ENVIRONMENT);

    boundary_9.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.CONVECTION);

    Boundary boundary_10 = 
      region_0.getBoundaryManager().getBoundary("contact");

    boundary_10.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.CONVECTION);

    boundary_10.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.ADIABATIC);

    boundary_9.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.ADIABATIC);

    CoupledEnergyModel coupledEnergyModel_0 = 
      physicsContinuum_0.getModelManager().getModel(CoupledEnergyModel.class);

    physicsContinuum_0.disableModel(coupledEnergyModel_0);

    physicsContinuum_0.enable(CoupledEnergyModel.class);

    CoupledEnergyModel coupledEnergyModel_1 = 
      physicsContinuum_0.getModelManager().getModel(CoupledEnergyModel.class);

    physicsContinuum_0.disableModel(coupledEnergyModel_1);

    KwAllYplusWallTreatment kwAllYplusWallTreatment_0 = 
      physicsContinuum_0.getModelManager().getModel(KwAllYplusWallTreatment.class);

    physicsContinuum_0.disableModel(kwAllYplusWallTreatment_0);

    CoupledFlowModel coupledFlowModel_0 = 
      physicsContinuum_0.getModelManager().getModel(CoupledFlowModel.class);

    physicsContinuum_0.disableModel(coupledFlowModel_0);

    ResidualPlot residualPlot_0 = 
      ((ResidualPlot) simulation_0.getPlotManager().getObject("Residuals"));

    Axes axes_0 = 
      residualPlot_0.getAxes();

    Axis axis_0 = 
      axes_0.getXAxis();

    AxisTitle axisTitle_0 = 
      axis_0.getTitle();

    axisTitle_0.setText("");

    Axis axis_1 = 
      axes_0.getYAxis();

    AxisTitle axisTitle_1 = 
      axis_1.getTitle();

    axisTitle_1.setText("");

    axisTitle_0.setText("");

    axisTitle_1.setText("");

    physicsContinuum_0.enable(SegregatedFlowModel.class);

    physicsContinuum_0.enable(KwAllYplusWallTreatment.class);

    axisTitle_0.setText("");

    axisTitle_1.setText("");

    axisTitle_0.setText("");

    axisTitle_1.setText("");

    SegregatedFlowModel segregatedFlowModel_0 = 
      physicsContinuum_0.getModelManager().getModel(SegregatedFlowModel.class);

    physicsContinuum_0.disableModel(segregatedFlowModel_0);

    axisTitle_0.setText("");

    axisTitle_1.setText("");

    axisTitle_0.setText("");

    axisTitle_1.setText("");

    physicsContinuum_0.enable(CoupledFlowModel.class);

    axisTitle_0.setText("");

    axisTitle_1.setText("");

    axisTitle_0.setText("");

    axisTitle_1.setText("");

    physicsContinuum_0.enable(CoupledEnergyModel.class);

    directBoundaryInterface_3.getConditions().get(EnergyUserSurfaceSourceOption.class).setSelected(EnergyUserSurfaceSourceOption.HEAT_FLUX);

    directBoundaryInterface_3.getConditions().get(EnergyUserSurfaceSourceOption.class).setSelected(EnergyUserSurfaceSourceOption.NONE);

    directBoundaryInterface_3.getConditions().get(EnergyUserSurfaceSourceOption.class).setSelected(EnergyUserSurfaceSourceOption.HEAT_SOURCE);

    directBoundaryInterface_3.getConditions().get(EnergyUserSurfaceSourceOption.class).setSelected(EnergyUserSurfaceSourceOption.NONE);

    simulation_0.getInterfaceManager().deleteInterfaces(directBoundaryInterface_0, directBoundaryInterface_1);

    simulation_0.getSimulationIterator().run();

    solution_0.clearSolution();

    meshContinuum_0.getReferenceValues().get(BaseSize.class).setValue(1.0E-5);

    meshContinuum_1.getReferenceValues().get(BaseSize.class).setValue(2.0E-5);

    meshContinuum_1.getReferenceValues().get(BaseSize.class).setValue(4.0E-5);

    meshContinuum_0.getReferenceValues().get(BaseSize.class).setValue(2.0E-5);

    meshPipelineController_0.generateVolumeMesh();

    solution_0.clearSolution();

    solution_0.initializeSolution();

    simulation_0.getSimulationIterator().run();

    fullyDevelopedMassFlowRate_0.getFullyDevelopedMassFlowRate().setValue(1.0E-4);

    SumReport sumReport_0 = 
      simulation_0.getReportManager().createReport(SumReport.class);

    PrimitiveFieldFunction primitiveFieldFunction_4 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Area"));

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = 
      ((VectorMagnitudeFieldFunction) primitiveFieldFunction_4.getMagnitudeFunction());

    sumReport_0.setScalar(vectorMagnitudeFieldFunction_0);

    sumReport_0.getParts().setObjects(boundary_6);

    sumReport_0.printReport();

    heatFluxProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(1.0);

    solution_0.clearSolution();

    fullyDevelopedMassFlowRate_0.getFullyDevelopedMassFlowRate().setValue(0.01);

    fullyDevelopedMassFlowRate_0.getFullyDevelopedMassFlowRate().setValue(0.0010);

    heatFluxProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(100.0);

    interfaceBulkTemperature_0.getBulkTemperature().setValue(300.0);

    solution_0.initializeSolution();

    simulation_0.getSimulationIterator().run();

    KwAllYplusWallTreatment kwAllYplusWallTreatment_1 = 
      physicsContinuum_0.getModelManager().getModel(KwAllYplusWallTreatment.class);

    physicsContinuum_0.disableModel(kwAllYplusWallTreatment_1);

    SstKwTurbModel sstKwTurbModel_0 = 
      physicsContinuum_0.getModelManager().getModel(SstKwTurbModel.class);

    physicsContinuum_0.disableModel(sstKwTurbModel_0);

    axisTitle_0.setText("");

    axisTitle_1.setText("");

    axisTitle_0.setText("");

    axisTitle_1.setText("");

    KOmegaTurbulence kOmegaTurbulence_0 = 
      physicsContinuum_0.getModelManager().getModel(KOmegaTurbulence.class);

    physicsContinuum_0.disableModel(kOmegaTurbulence_0);

    RansTurbulenceModel ransTurbulenceModel_0 = 
      physicsContinuum_0.getModelManager().getModel(RansTurbulenceModel.class);

    physicsContinuum_0.disableModel(ransTurbulenceModel_0);

    TurbulentModel turbulentModel_0 = 
      physicsContinuum_0.getModelManager().getModel(TurbulentModel.class);

    physicsContinuum_0.disableModel(turbulentModel_0);

    physicsContinuum_0.enable(LaminarModel.class);

    simulation_0.getSimulationIterator().run();

    physicsContinuum_0.getReferenceValues().get(MaximumAllowableTemperature.class).setValue(500000.0);

    physicsContinuum_1.getReferenceValues().get(MaximumAllowableTemperature.class).setValue(500000.0);

    heatFluxProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(1000000.0);

    solution_0.clearSolution();

    simulation_0.getSimulationIterator().run();

    directBoundaryInterface_2.getConditions().get(FullyDevelopedEnergyJumpOption.class).setSelected(FullyDevelopedEnergyJumpOption.SPECIFIED_TEMPERATURE_JUMP);

    TemperatureJump temperatureJump_0 = 
      directBoundaryInterface_2.getValues().get(TemperatureJump.class);

    temperatureJump_0.getTemperatureJump().setValue(10.0);

    boundary_6.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.TEMPERATURE);

    StaticTemperatureProfile staticTemperatureProfile_0 = 
      boundary_6.getValues().get(StaticTemperatureProfile.class);

    staticTemperatureProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(400.0);

    simulation_0.getSimulationIterator().run();

    physicsContinuum_0.getReferenceValues().get(MaximumAllowableTemperature.class).setValue(5000.0);

    physicsContinuum_1.getReferenceValues().get(MaximumAllowableTemperature.class).setValue(5000.0);

    solution_0.clearSolution();

    simulation_0.getSimulationIterator().run();

    simulation_0.getSimulationIterator().step(1);

    simulation_0.getSimulationIterator().run();

    simulation_0.saveState(resolvePath("Z:\\Windows.Documents\\My Documents\\SYNC\\sim_unit_cell_assem_test.sim"));
  }
}
