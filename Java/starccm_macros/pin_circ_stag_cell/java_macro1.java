// STAR-CCM+ macro: java_macro.java
package macro;

import java.util.*;

import java.lang.*;
import star.cadmodeler.*;

import star.common.*;
import star.flow.*;
import star.meshing.*;
import star.segregatedflow.*;
import star.turbulence.*;
import star.material.*;
import star.kwturb.*;
import star.base.neo.*;
import star.resurfacer.*;
import star.base.report.*;
import star.dualmesher.*;
import star.prismmesher.*;
import star.metrics.*;

public class java_macro1 extends StarMacro {

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
	
	
    

    PartImportManager partImportManager_0 = 
      simulation_0.get(PartImportManager.class);

    partImportManager_0.importCadPart(resolvePath(CADPath), "SharpEdges", 30.0, 2, true, true);

    CadPart cadPart_0 = 
      ((CadPart) simulation_0.get(SimulationPartManager.class).getPart("pin_cell"));

    PartSurface partSurface_0 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces");

    PartCurve partCurve_0 = 
      ((PartCurve) cadPart_0.getPartCurveManager().getObject("Edges"));

    cadPart_0.getPartSurfaceManager().splitPartSurfacesByPartCurves(new NeoObjectVector(new Object[] {partSurface_0}), new NeoObjectVector(new Object[] {partCurve_0}));

	simulation_0.saveState(resolvePath(savePath));
	
  }
}
