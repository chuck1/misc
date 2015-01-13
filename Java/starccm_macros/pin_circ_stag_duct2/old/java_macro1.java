// STAR-CCM+ macro: java_macro1.java
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.meshing.*;

public class java_macro1 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = getActiveSimulation();
	
	String session_abs_dir = simulation_0.getSessionDir();
	String session_dir = session_abs_dir.substring(session_abs_dir.lastIndexOf('/') + 1);
	String savePath = session_abs_dir + "/sim.sim";
	String CADPath = session_abs_dir + "/pin_duct_assem.x_b";
	
	
    PartImportManager partImportManager_0 = simulation_0.get(PartImportManager.class);

    partImportManager_0.importCadPart(resolvePath(CADPath), "SharpEdges", 30.0, 2, true, true);

    simulation_0.getSceneManager().createGeometryScene("Geometry Scene", "Outline", "Geometry", 1);

    Scene scene_0 = simulation_0.getSceneManager().getScene("Geometry Scene 1");

    scene_0.initializeAndWait();

    PartDisplayer partDisplayer_1 = 
      ((PartDisplayer) scene_0.getCreatorDisplayer());

    partDisplayer_1.initialize();

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_0.initialize();

    PartDisplayer partDisplayer_2 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getDisplayer("Geometry 1"));

    partDisplayer_2.initialize();

    PartDisplayer partDisplayer_3 = 
      ((PartDisplayer) scene_0.getHighlightDisplayer());

    partDisplayer_3.initialize();

    scene_0.open(true);

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    CompositePart compositePart_0 = 
      ((CompositePart) simulation_0.get(SimulationPartManager.class).getPart("Assembly 1"));

    CadPart cadPart_0 = 
      ((CadPart) compositePart_0.getChildParts().getPart("Part2^pin_duct_assem"));

    PartSurface partSurface_0 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces");

    partDisplayer_3.getParts().setObjects(partSurface_0);

    cadPart_0.setPresentationName("solid");

    CadPart cadPart_1 = 
      ((CadPart) compositePart_0.getChildParts().getPart("pin_duct"));

    PartSurface partSurface_1 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("Faces");

    partDisplayer_3.getParts().setObjects(partSurface_1);

    cadPart_1.setPresentationName("fluid");

    partDisplayer_3.getParts().setObjects(partSurface_0);

    PartCurve partCurve_0 = 
      ((PartCurve) cadPart_0.getPartCurveManager().getObject("Edges"));

    cadPart_0.getPartSurfaceManager().splitPartSurfacesByPartCurves(new NeoObjectVector(new Object[] {partSurface_0}), new NeoObjectVector(new Object[] {partCurve_0}));

    partDisplayer_3.getParts().setObjects();

    partDisplayer_3.getParts().setObjects(partSurface_1);

    PartCurve partCurve_1 = 
      ((PartCurve) cadPart_1.getPartCurveManager().getObject("Edges"));

    cadPart_1.getPartSurfaceManager().splitPartSurfacesByPartCurves(new NeoObjectVector(new Object[] {partSurface_1}), new NeoObjectVector(new Object[] {partCurve_1}));

    partDisplayer_3.getParts().setObjects();

  }
}
