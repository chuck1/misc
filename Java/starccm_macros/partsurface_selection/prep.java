// STAR-CCM+ macro: prep.java
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.meshing.*;

public class prep extends StarMacro {

	public Simulation simulation_0;
	
	public void execute() {
		execute0();
	}

	private void execute0() {

		simulation_0 = getActiveSimulation();

		PartImportManager partImportManager_0 = simulation_0.get(PartImportManager.class);
		partImportManager_0.importCadPart(resolvePath("Z:\\Windows.Documents\\My Documents\\SYNC\\SUNSHOT\\solidworks\\clust\\pin_circ_stag_duct\\pin_duct_assem2_case_0004.x_b"), "SharpEdges", 30.0, 2, true, true);

		simulation_0.getSceneManager().createGeometryScene("Geometry Scene", "Outline", "Geometry", 1);
		Scene scene_0 = simulation_0.getSceneManager().getScene("Geometry Scene 1");
		scene_0.initializeAndWait();
		scene_0.open(true);
		CurrentView currentView_0 = scene_0.getCurrentView();
		
		
		
		for (GeometryPart geometryPart: simulation_0.getGeometryPartManager().getParts())
		{
			climbGeometryTree_split(geometryPart);
		}
		
		
		
	}
	private void climbGeometryTree_split(GeometryPart geometryPart) {
		simulation_0.println(geometryPart.getPresentationName() + " " + geometryPart.isLeaf());
		if (geometryPart.isLeaf()) {
			for (PartSurface partSurface: geometryPart.getPartSurfaces()) {
				partSurface.getManager().splitPartSurfacesByPartCurves(new Vector(geometryPart.getPartSurfaces()),new Vector(geometryPart.getPartCurves()));
				break;
			}
		} else {
			for (GeometryPart geometryPart_0: geometryPart.getLeafParts()) {
				climbGeometryTree_split(geometryPart_0);
			}
		}
	}
	private void climbGeometryTree_createRegion(GeometryPart geometryPart) {
		if (geometryPart.isLeaf()) {
			simulation_0.getRegionManager().newRegionsFromParts(new ArrayList<GeometryPart>(Arrays.asList(geometryPart)), "OneRegionPerPart", null, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", null, true);
		} else {
			for (GeometryPart geometryPart_0: geometryPart.getLeafParts()) {
				climbGeometryTree_createRegion(geometryPart_0);
			}
		}
	}
}
