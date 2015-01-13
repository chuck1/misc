// STAR-CCM+ macro: java_pin_circ_stag_duct2.java
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.prismmesher.*;
import star.meshing.*;

public class java_pin_circ_stag_duct2 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    MeshPipelineController meshPipelineController_0 = 
      simulation_0.get(MeshPipelineController.class);

    meshPipelineController_0.generateVolumeMesh();

    MeshContinuum meshContinuum_0 = 
      ((MeshContinuum) simulation_0.getContinuumManager().getContinuum("Mesh fluid"));

    meshContinuum_0.getReferenceValues().get(BaseSize.class).setValue(1.0E-4);

    meshPipelineController_0.generateVolumeMesh();

    SurfaceProximity surfaceProximity_0 = 
      meshContinuum_0.getReferenceValues().get(SurfaceProximity.class);

    surfaceProximity_0.setNumPointsInGap(2.0);

    meshPipelineController_0.clearGeneratedMeshes();

    meshPipelineController_0.generateVolumeMesh();

    MeshContinuum meshContinuum_1 = 
      ((MeshContinuum) simulation_0.getContinuumManager().getContinuum("Mesh solid"));

    meshContinuum_1.getReferenceValues().get(BaseSize.class).setValue(0.0010);

    meshContinuum_0.getReferenceValues().get(BaseSize.class).setValue(0.0010);

    PrismMesherModel prismMesherModel_0 = 
      meshContinuum_0.getModelManager().getModel(PrismMesherModel.class);

    meshContinuum_0.disableModel(prismMesherModel_0);

    meshPipelineController_0.generateSurfaceMesh();

    meshPipelineController_0.clearGeneratedMeshes();

    meshPipelineController_0.initializeMeshPipeline();

    Units units_0 = 
      simulation_0.getUnitsManager().hasPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    meshPipelineController_0.generateVolumeMesh();

    meshContinuum_0.getReferenceValues().get(BaseSize.class).setValue(5.0E-5);

    surfaceProximity_0.setNumPointsInGap(10.0);

    meshContinuum_0.enable(PrismMesherModel.class);

    meshContinuum_1.getReferenceValues().get(BaseSize.class).setValue(5.0E-5);

    meshContinuum_1.getReferenceValues().get(BaseSize.class).setValue(1.0E-4);

    simulation_0.saveState(resolvePath("/nfs/mohr/sva/work/rymalc/bin/sunshot/clust/jobs/star/pin_circ_stag_duct/pin_circ_stag_duct_case_0000/sim_pin_circ_stag_duct.sim"));

    meshPipelineController_0.generateVolumeMesh();

    simulation_0.saveState(resolvePath("/nfs/mohr/sva/work/rymalc/bin/sunshot/clust/jobs/star/pin_circ_stag_duct/pin_circ_stag_duct_case_0000/sim_pin_circ_stag_duct.sim"));
  }
}
