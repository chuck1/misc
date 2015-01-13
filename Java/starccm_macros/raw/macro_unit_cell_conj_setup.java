// STAR-CCM+ macro: macro_unit_cell_conj_setup.java
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.meshing.*;

public class macro_unit_cell_conj_setup extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PartImportManager partImportManager_0 = 
      simulation_0.get(PartImportManager.class);

    partImportManager_0.importCadPart(resolvePath("/nfs/stak/students/r/rymalc/Windows.Documents/My Documents/SYNC/SUNSHOT/solidworks/unit_cell/Assem1.STEP"), "SharpEdges", 30.0, 2, true, true);

    CompositePart compositePart_1 = 
      ((CompositePart) simulation_0.get(SimulationPartManager.class).getPart("Assem1"));

    CompositePart compositePart_0 = 
      ((CompositePart) compositePart_1.getChildParts().getPart("Part2^Assem1"));

    CadPart cadPart_0 = 
      ((CadPart) compositePart_0.getChildParts().getPart("Cavity1"));

    PartSurface partSurface_0 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces");

    PartCurve partCurve_0 = 
      ((PartCurve) cadPart_0.getPartCurveManager().getObject("Edges"));

    cadPart_0.getPartSurfaceManager().splitPartSurfacesByPartCurves(new NeoObjectVector(new Object[] {partSurface_0}), new NeoObjectVector(new Object[] {partCurve_0}));

    PartSurface partSurface_1 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 15");

    partSurface_1.setPresentationName("top");

    PartSurface partSurface_2 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 18");

    partSurface_2.setPresentationName("wall");

    PartSurface partSurface_3 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 13");

    PartSurface partSurface_4 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 6");

    cadPart_0.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_3, partSurface_4}));

    partSurface_3.setPresentationName("symmetry");

    PartSurface partSurface_5 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 3");

    PartSurface partSurface_6 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 10");

    PartSurface partSurface_7 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 5");

    PartSurface partSurface_8 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 4");

    PartSurface partSurface_9 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 14");

    PartSurface partSurface_10 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 8");

    PartSurface partSurface_11 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 12");

    PartSurface partSurface_12 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 11");

    PartSurface partSurface_13 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 2");

    cadPart_0.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_5, partSurface_6, partSurface_7, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12, partSurface_0, partSurface_13}));

    partSurface_5.setPresentationName("contact");

    PartSurface partSurface_14 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 9");

    partSurface_14.setPresentationName("top_in");

    PartSurface partSurface_15 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 16");

    partSurface_15.setPresentationName("top_out");

    PartSurface partSurface_16 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 17");

    partSurface_16.setPresentationName("bottom_out");

    PartSurface partSurface_17 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 7");

    partSurface_17.setPresentationName("bottom_in");

    simulation_0.saveState(resolvePath("/nfs/stak/students/r/rymalc/star.sim"));
  }
}
