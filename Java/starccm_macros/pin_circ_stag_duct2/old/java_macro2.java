// STAR-CCM+ macro: java_macro2.java
package macro;

import java.util.*;

import star.common.*;
import star.segregatedenergy.*;
import star.flow.*;
import star.meshing.*;
import star.segregatedflow.*;
import star.turbulence.*;
import star.kwturb.*;
import star.material.*;
import star.base.neo.*;
import star.vis.*;
import star.resurfacer.*;
import star.dualmesher.*;
import star.prismmesher.*;
import star.metrics.*;
import star.energy.*;

public class java_macro2 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    PartDisplayer partDisplayer_3 = 
      ((PartDisplayer) scene_0.getHighlightDisplayer());

    CompositePart compositePart_0 = 
      ((CompositePart) simulation_0.get(SimulationPartManager.class).getPart("Assembly 1"));

    CadPart cadPart_0 = 
      ((CadPart) compositePart_0.getChildParts().getPart("solid"));

    PartSurface partSurface_0 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("symmetry");

    PartSurface partSurface_1 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("interior");

    PartSurface partSurface_2 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("top");

    PartSurface partSurface_3 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("bottom");

    CadPart cadPart_1 = 
      ((CadPart) compositePart_0.getChildParts().getPart("fluid"));

    PartSurface partSurface_4 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("interior");

    PartSurface partSurface_5 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("outlet");

    PartSurface partSurface_6 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("inlet");

    PartSurface partSurface_7 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("symmetry");

    partDisplayer_3.getParts().setObjects(partSurface_0, partSurface_1, partSurface_2, partSurface_3, partSurface_4, partSurface_5, partSurface_6, partSurface_7);

    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {cadPart_1, cadPart_0}), "OneRegionPerPart", null, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", null, true);

    partDisplayer_3.getParts().setObjects();

    MeshContinuum meshContinuum_0 = simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);

    MeshContinuum meshContinuum_1 = simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);

    PhysicsContinuum physicsContinuum_0 = simulation_0.getContinuumManager().createContinuum(PhysicsContinuum.class);
    PhysicsContinuum physicsContinuum_1 = simulation_0.getContinuumManager().createContinuum(PhysicsContinuum.class);

    meshContinuum_0.enable(ResurfacerMeshingModel.class);

    meshContinuum_0.enable(DualMesherModel.class);

    meshContinuum_0.enable(PrismMesherModel.class);

    meshContinuum_0.getReferenceValues().get(BaseSize.class).setValue(2.5E-5);

    NumPrismLayers numPrismLayers_0 = meshContinuum_0.getReferenceValues().get(NumPrismLayers.class);

    numPrismLayers_0.setNumLayers(5);

    SurfaceProximity surfaceProximity_0 = meshContinuum_0.getReferenceValues().get(SurfaceProximity.class);

    surfaceProximity_0.setNumPointsInGap(10.0);

    meshContinuum_1.enable(ResurfacerMeshingModel.class);

    meshContinuum_1.enable(DualMesherModel.class);

    meshContinuum_1.getReferenceValues().get(BaseSize.class).setValue(7.5E-5);

    SurfaceProximity surfaceProximity_1 = meshContinuum_1.getReferenceValues().get(SurfaceProximity.class);

    surfaceProximity_1.setNumPointsInGap(5.0);

    physicsContinuum_0.enable(ThreeDimensionalModel.class);

    physicsContinuum_0.enable(SteadyModel.class);

    physicsContinuum_0.enable(SingleComponentGasModel.class);

    physicsContinuum_0.enable(SegregatedFlowModel.class);

    physicsContinuum_0.enable(IdealGasModel.class);

    physicsContinuum_0.enable(SegregatedFluidTemperatureModel.class);

    IdealGasModel idealGasModel_0 = physicsContinuum_0.getModelManager().getModel(IdealGasModel.class);
	
    physicsContinuum_0.disableModel(idealGasModel_0);
	
    physicsContinuum_0.enable(PolynomialDensityModel.class);

    physicsContinuum_0.enable(TurbulentModel.class);

    physicsContinuum_0.enable(RansTurbulenceModel.class);

    physicsContinuum_0.enable(KOmegaTurbulence.class);

    physicsContinuum_0.enable(SstKwTurbModel.class);

    physicsContinuum_0.enable(KwAllYplusWallTreatment.class);

    physicsContinuum_0.enable(KOmegaTurbulence.class);

    SingleComponentGasModel singleComponentGasModel_0 = physicsContinuum_0.getModelManager().getModel(SingleComponentGasModel.class);

    Gas gas_0 = ((Gas) singleComponentGasModel_0.getMaterial());

    gas_0.getMaterialProperties().getMaterialProperty(DynamicViscosityProperty.class).setMethod(PowerLaw.class);

    scene_0.close(true);

    
  }
}
