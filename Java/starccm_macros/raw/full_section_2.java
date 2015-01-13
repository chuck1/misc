// STAR-CCM+ macro: full_section_2.java
package macro;

import java.util.*;

import star.material.*;
import star.common.*;
import star.base.neo.*;
import star.resurfacer.*;
import star.vis.*;
import star.base.report.*;
import star.flow.*;
import star.trimmer.*;
import star.segregatedflow.*;
import star.meshing.*;

public class full_section_2 extends StarMacro {

  public void execute() {
    execute0();
    execute1();
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
      ((CadPart) compositePart_0.getChildParts().getPart("out0"));

    PartSurface partSurface_0 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces");

    partDisplayer_3.getParts().setObjects(partSurface_0);

    PartCurve partCurve_0 = 
      ((PartCurve) cadPart_0.getPartCurveManager().getObject("Edges"));

    partDisplayer_3.getParts().setObjects(partCurve_0);

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {-1.1956930875615251E-4, -0.0020375412345696106, -0.0016939756664390414}), new DoubleVector(new double[] {0.04308923075098302, -0.02136363241708434, 0.003374867738832601}), new DoubleVector(new double[] {-0.021659501456324365, 0.20805185630877215, 0.9778779530611872}), 0.012427276340684525, 0);

    partDisplayer_3.getParts().setObjects();

    currentView_0.setInput(new DoubleVector(new double[] {-0.00398869803587365, -6.914952033226229E-4, -0.002059061681919352}), new DoubleVector(new double[] {0.04217148888756227, -0.021337659416419536, 0.003356010218931228}), new DoubleVector(new double[] {-0.021659501456324365, 0.20805185630877215, 0.9778779530611872}), 0.013276124262698471, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.00398869803587365, -6.914952033226229E-4, -0.002059061681919352}), new DoubleVector(new double[] {0.04217148888756227, -0.021337659416419536, 0.003356010218931228}), new DoubleVector(new double[] {-0.021659501456324365, 0.20805185630877215, 0.9778779530611872}), 0.013276124262698471, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.00398869803587365, -6.914952033226229E-4, -0.002059061681919352}), new DoubleVector(new double[] {0.04217148888756227, -0.021337659416419536, 0.003356010218931228}), new DoubleVector(new double[] {-0.021659501456324365, 0.20805185630877215, 0.9778779530611872}), 0.013276124262698471, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.00398869803587365, -6.914952033226229E-4, -0.002059061681919352}), new DoubleVector(new double[] {0.04217148888756227, -0.021337659416419536, 0.003356010218931228}), new DoubleVector(new double[] {-0.021659501456324365, 0.20805185630877215, 0.9778779530611872}), 0.013276124262698471, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.00398869803587365, -6.914952033226229E-4, -0.002059061681919352}), new DoubleVector(new double[] {0.04217148888756227, -0.021337659416419536, 0.003356010218931228}), new DoubleVector(new double[] {-0.021659501456324365, 0.20805185630877215, 0.9778779530611872}), 0.013276124262698471, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.00398869803587365, -6.914952033226229E-4, -0.002059061681919352}), new DoubleVector(new double[] {0.04217148888756227, -0.021337659416419536, 0.003356010218931228}), new DoubleVector(new double[] {-0.021659501456324365, 0.20805185630877215, 0.9778779530611872}), 0.013276124262698471, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.00398869803587365, -6.914952033226229E-4, -0.002059061681919352}), new DoubleVector(new double[] {0.04217148888756227, -0.021337659416419536, 0.003356010218931228}), new DoubleVector(new double[] {-0.021659501456324365, 0.20805185630877215, 0.9778779530611872}), 0.013276124262698471, 0);

    partDisplayer_3.getParts().setObjects(partSurface_0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.00398869803587365, -6.914952033226229E-4, -0.002059061681919352}), new DoubleVector(new double[] {0.04217148888756227, -0.021337659416419536, 0.003356010218931228}), new DoubleVector(new double[] {-0.021659501456324365, 0.20805185630877215, 0.9778779530611872}), 0.013276124262698471, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.00398869803587365, -6.914952033226229E-4, -0.002059061681919352}), new DoubleVector(new double[] {0.04217148888756227, -0.021337659416419536, 0.003356010218931228}), new DoubleVector(new double[] {-0.021659501456324365, 0.20805185630877215, 0.9778779530611872}), 0.013276124262698471, 0);

    partDisplayer_3.getParts().setObjects();

    partDisplayer_3.getParts().setObjects(partSurface_0);

    partDisplayer_3.getParts().setObjects();

    partDisplayer_3.getParts().setObjects(partSurface_0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.0076655142118035625, 0.0010229640647921993, -0.0025052670955079395}), new DoubleVector(new double[] {0.04213942937481463, -0.022163391667711217, 0.003530981662839906}), new DoubleVector(new double[] {-0.021659501152556646, 0.20805185613802396, 0.9778779531042436}), 0.014427899799800532, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.006111480084426069, -0.007536669074154345, -0.0014239169712677207}), new DoubleVector(new double[] {0.03413978345763837, -0.020585056759999186, 0.0019730512662509163}), new DoubleVector(new double[] {-0.021659501152556646, 0.20805185613802396, 0.9778779531042436}), 0.00811946613138563, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.0049008802371160835, -0.00840772001394082, -0.0013410960257829712}), new DoubleVector(new double[] {0.02796916017438926, -0.019147002226606518, 0.0014547283663562654}), new DoubleVector(new double[] {-0.021659501152556646, 0.20805185613802396, 0.9778779531042436}), 0.00668260633424654, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-9.82248853481603E-4, -0.0063502167667549726, -0.002147674834479683}), new DoubleVector(new double[] {0.024907836948285092, -0.0184031716767589, 9.901461732409877E-4}), new DoubleVector(new double[] {-0.021659501152556646, 0.20805185613802396, 0.9778779531042436}), 0.007500049931920665, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-9.82248853481603E-4, -0.0063502167667549726, -0.002147674834479683}), new DoubleVector(new double[] {0.024907836948285092, -0.0184031716767589, 9.901461732409877E-4}), new DoubleVector(new double[] {-0.021659501152556646, 0.20805185613802396, 0.9778779531042436}), 0.007500049931920665, 0);

    partDisplayer_3.getParts().setObjects(partSurface_0);

    currentView_0.setInput(new DoubleVector(new double[] {-9.82248853481603E-4, -0.0063502167667549726, -0.002147674834479683}), new DoubleVector(new double[] {0.024907836948285092, -0.0184031716767589, 9.901461732409877E-4}), new DoubleVector(new double[] {-0.021659501152556646, 0.20805185613802396, 0.9778779531042436}), 0.007500049931920665, 0);

    partDisplayer_3.getParts().setObjects();

    partDisplayer_3.getParts().setObjects(partSurface_0);

    cadPart_0.getPartSurfaceManager().splitPartSurfacesByPartCurves(new NeoObjectVector(new Object[] {partSurface_0}), new NeoObjectVector(new Object[] {partCurve_0}));

    PartSurface partSurface_1 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 2");

    partDisplayer_3.getParts().setObjects(partSurface_1);

    partDisplayer_3.getParts().setObjects(partSurface_1, partSurface_0);

    partDisplayer_3.getParts().setObjects();

    partDisplayer_3.getParts().setObjects(partSurface_0);

    partDisplayer_3.getParts().setObjects(partSurface_1);

    partDisplayer_3.getParts().setObjects(partSurface_0);

    partDisplayer_3.getParts().setObjects(partSurface_1, partSurface_0);

    currentView_0.setInput(new DoubleVector(new double[] {-9.82248853481603E-4, -0.0063502167667549726, -0.002147674834479683}), new DoubleVector(new double[] {0.024907836948285092, -0.0184031716767589, 9.901461732409877E-4}), new DoubleVector(new double[] {-0.021659501152556646, 0.20805185613802396, 0.9778779531042436}), 0.007500049931920665, 0);

    partDisplayer_3.getParts().setObjects();

    currentView_0.setInput(new DoubleVector(new double[] {-9.82248853481603E-4, -0.0063502167667549726, -0.002147674834479683}), new DoubleVector(new double[] {0.024907836948285092, -0.0184031716767589, 9.901461732409877E-4}), new DoubleVector(new double[] {-0.021659501152556646, 0.20805185613802396, 0.9778779531042436}), 0.007500049931920665, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-9.82248853481603E-4, -0.0063502167667549726, -0.002147674834479683}), new DoubleVector(new double[] {0.024907836948285092, -0.0184031716767589, 9.901461732409877E-4}), new DoubleVector(new double[] {-0.021659501152556646, 0.20805185613802396, 0.9778779531042436}), 0.007500049931920665, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002448416153621501, -0.005647353642775938, -0.002160553974125565}), new DoubleVector(new double[] {0.02469024298533405, -0.018688222975615454, -0.0021732161203661064}), new DoubleVector(new double[] {0.07782106005263908, 0.16099395711788128, 0.9838825277358113}), 0.007860110223279674, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002448416153621501, -0.005647353642775938, -0.002160553974125565}), new DoubleVector(new double[] {0.02469024298533405, -0.018688222975615454, -0.0021732161203661064}), new DoubleVector(new double[] {0.07782106005263908, 0.16099395711788128, 0.9838825277358113}), 0.007860110223279674, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002448416153621501, -0.005647353642775938, -0.002160553974125565}), new DoubleVector(new double[] {0.02469024298533405, -0.018688222975615454, -0.0021732161203661064}), new DoubleVector(new double[] {0.07782106005263908, 0.16099395711788128, 0.9838825277358113}), 0.007860110223279674, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002448416153621501, -0.005647353642775938, -0.002160553974125565}), new DoubleVector(new double[] {0.02469024298533405, -0.018688222975615454, -0.0021732161203661064}), new DoubleVector(new double[] {0.07782106005263908, 0.16099395711788128, 0.9838825277358113}), 0.007860110223279674, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002448416153621501, -0.005647353642775938, -0.002160553974125565}), new DoubleVector(new double[] {0.02469024298533405, -0.018688222975615454, -0.0021732161203661064}), new DoubleVector(new double[] {0.07782106005263908, 0.16099395711788128, 0.9838825277358113}), 0.007860110223279674, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002448416153621501, -0.005647353642775938, -0.002160553974125565}), new DoubleVector(new double[] {0.02469024298533405, -0.018688222975615454, -0.0021732161203661064}), new DoubleVector(new double[] {0.07782106005263908, 0.16099395711788128, 0.9838825277358113}), 0.007860110223279674, 0);

    PartRepresentation partRepresentation_0 = 
      ((PartRepresentation) simulation_0.getRepresentationManager().getObject("Geometry"));

    PartSurfaceMeshWidget partSurfaceMeshWidget_0 = 
      partRepresentation_0.startSurfaceMeshWidget(scene_0);

    CadPart cadPart_1 = 
      ((CadPart) compositePart_0.getChildParts().getPart("in1"));

    CadPart cadPart_2 = 
      ((CadPart) compositePart_0.getChildParts().getPart("out2"));

    CadPart cadPart_3 = 
      ((CadPart) compositePart_0.getChildParts().getPart("out1"));

    CadPart cadPart_4 = 
      ((CadPart) compositePart_0.getChildParts().getPart("duct"));

    CadPart cadPart_5 = 
      ((CadPart) compositePart_0.getChildParts().getPart("in0"));

    partSurfaceMeshWidget_0.setActiveParts(new NeoObjectVector(new Object[] {cadPart_1, cadPart_2, cadPart_0, cadPart_3, cadPart_4, cadPart_5}), new NeoObjectVector(new Object[] {}), new NeoObjectVector(new Object[] {}));

    partSurfaceMeshWidget_0.startSurfaceMeshDiagnostics();

    partSurfaceMeshWidget_0.startSurfaceMeshRepair();

    partSurfaceMeshWidget_0.startMergeImprintController();

    partSurfaceMeshWidget_0.startIntersectController();

    partSurfaceMeshWidget_0.startLeakFinderController();

    partSurfaceMeshWidget_0.startSurfaceMeshQueryController();

    SurfaceMeshWidgetDiagnosticsController surfaceMeshWidgetDiagnosticsController_0 = 
      partSurfaceMeshWidget_0.getControllers().getController(SurfaceMeshWidgetDiagnosticsController.class);

    surfaceMeshWidgetDiagnosticsController_0.setCheckPiercedFaces(false);

    surfaceMeshWidgetDiagnosticsController_0.setPiercedFacesActive(false);

    surfaceMeshWidgetDiagnosticsController_0.setCheckPoorQualityFaces(false);

    surfaceMeshWidgetDiagnosticsController_0.setPoorQualityFacesActive(false);

    surfaceMeshWidgetDiagnosticsController_0.setMinimumFaceQuality(0.01);

    surfaceMeshWidgetDiagnosticsController_0.setCheckCloseProximityFaces(false);

    surfaceMeshWidgetDiagnosticsController_0.setCloseProximityFacesActive(false);

    surfaceMeshWidgetDiagnosticsController_0.setMinimumFaceProximity(0.05);

    surfaceMeshWidgetDiagnosticsController_0.setCheckFreeEdges(false);

    surfaceMeshWidgetDiagnosticsController_0.setFreeEdgesActive(false);

    surfaceMeshWidgetDiagnosticsController_0.setCheckNonmanifoldEdges(false);

    surfaceMeshWidgetDiagnosticsController_0.setNonmanifoldEdgesActive(false);

    surfaceMeshWidgetDiagnosticsController_0.setCheckNonmanifoldVertices(false);

    surfaceMeshWidgetDiagnosticsController_0.setNonmanifoldVerticesActive(false);

    surfaceMeshWidgetDiagnosticsController_0.setCheckFeatureNumberEdges(true);

    surfaceMeshWidgetDiagnosticsController_0.setCheckFeatureLength(false);

    surfaceMeshWidgetDiagnosticsController_0.setCheckFeatureAngle(true);

    surfaceMeshWidgetDiagnosticsController_0.setCheckFeatureOpenCurve(true);

    surfaceMeshWidgetDiagnosticsController_0.setCheckFeatureSmallRegions(false);

    surfaceMeshWidgetDiagnosticsController_0.setMinNumberEdges(5);

    surfaceMeshWidgetDiagnosticsController_0.setMinFeatureLength(1.0E-4);

    surfaceMeshWidgetDiagnosticsController_0.setMaxFeatureAngle(121.0);

    surfaceMeshWidgetDiagnosticsController_0.setMinFeatureRegionArea(1.0E-4);

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    Units units_1 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    surfaceMeshWidgetDiagnosticsController_0.setCheckSoftFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_0.setSoftFeatureErrorsActive(false);

    surfaceMeshWidgetDiagnosticsController_0.setCheckHardFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_0.setHardFeatureErrorsActive(false);

    surfaceMeshWidgetDiagnosticsController_0.setCheckSoftFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_0.setSoftFeatureErrorsActive(false);

    surfaceMeshWidgetDiagnosticsController_0.setCheckHardFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_0.setHardFeatureErrorsActive(false);

    SurfaceMeshWidgetRepairController surfaceMeshWidgetRepairController_0 = 
      partSurfaceMeshWidget_0.getControllers().getController(SurfaceMeshWidgetRepairController.class);

    SurfaceMeshWidgetMergeImprintOptions surfaceMeshWidgetMergeImprintOptions_0 = 
      surfaceMeshWidgetRepairController_0.getOptions().getMergeImprintOptions();

    surfaceMeshWidgetMergeImprintOptions_0.setImprintMethod("NormalImprintMethod");

    surfaceMeshWidgetMergeImprintOptions_0.setMergeAction(SurfaceMeshWidgetMergedFaceOption.MAINTAIN_DEST_BOUNDARY);

    surfaceMeshWidgetDiagnosticsController_0.changeDisplayedThresholds(new NeoObjectVector(new Object[] {}), true);

    SurfaceMeshWidgetDisplayer surfaceMeshWidgetDisplayer_0 = 
      ((SurfaceMeshWidgetDisplayer) scene_0.getDisplayerManager().getDisplayer("Widget displayer 1"));

    surfaceMeshWidgetDisplayer_0.initialize();

    PartSurface partSurface_2 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("inlet");

    PartSurface partSurface_3 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("wall");

    PartSurface partSurface_4 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("int");

    cadPart_1.getPartSurfacesSharingPatches(partSurfaceMeshWidget_0, new NeoObjectVector(new Object[] {partSurface_2, partSurface_3, partSurface_4}), new NeoObjectVector(new Object[] {}));

    PartSurface partSurface_5 = 
      cadPart_2.getPartSurfaceManager().getPartSurface("int");

    PartSurface partSurface_6 = 
      cadPart_2.getPartSurfaceManager().getPartSurface("wall");

    PartSurface partSurface_7 = 
      cadPart_2.getPartSurfaceManager().getPartSurface("outlet");

    cadPart_2.getPartSurfacesSharingPatches(partSurfaceMeshWidget_0, new NeoObjectVector(new Object[] {partSurface_5, partSurface_6, partSurface_7}), new NeoObjectVector(new Object[] {}));

    PartSurface partSurface_8 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 3");

    PartSurface partSurface_9 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 4");

    PartSurface partSurface_10 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 5");

    PartSurface partSurface_11 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 6");

    PartSurface partSurface_12 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 7");

    PartSurface partSurface_13 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 8");

    PartSurface partSurface_14 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 9");

    PartSurface partSurface_15 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 10");

    PartSurface partSurface_16 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 11");

    PartSurface partSurface_17 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 12");

    PartSurface partSurface_18 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 13");

    PartSurface partSurface_19 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 14");

    PartSurface partSurface_20 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 15");

    PartSurface partSurface_21 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 16");

    PartSurface partSurface_22 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 17");

    PartSurface partSurface_23 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 18");

    PartSurface partSurface_24 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 19");

    PartSurface partSurface_25 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 20");

    PartSurface partSurface_26 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 21");

    PartSurface partSurface_27 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 22");

    PartSurface partSurface_28 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 23");

    PartSurface partSurface_29 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 24");

    PartSurface partSurface_30 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 25");

    PartSurface partSurface_31 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 26");

    PartSurface partSurface_32 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 27");

    PartSurface partSurface_33 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 28");

    PartSurface partSurface_34 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 29");

    PartSurface partSurface_35 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 30");

    PartSurface partSurface_36 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 31");

    PartSurface partSurface_37 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 32");

    PartSurface partSurface_38 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 33");

    PartSurface partSurface_39 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 34");

    PartSurface partSurface_40 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 35");

    PartSurface partSurface_41 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 36");

    PartSurface partSurface_42 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 37");

    PartSurface partSurface_43 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 38");

    PartSurface partSurface_44 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 39");

    PartSurface partSurface_45 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 40");

    PartSurface partSurface_46 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 41");

    PartSurface partSurface_47 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 42");

    PartSurface partSurface_48 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 43");

    PartSurface partSurface_49 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 44");

    PartSurface partSurface_50 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 45");

    PartSurface partSurface_51 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 46");

    PartSurface partSurface_52 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 47");

    PartSurface partSurface_53 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 48");

    PartSurface partSurface_54 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 49");

    PartSurface partSurface_55 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 50");

    PartSurface partSurface_56 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 51");

    PartSurface partSurface_57 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 52");

    PartSurface partSurface_58 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 53");

    PartSurface partSurface_59 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 54");

    PartSurface partSurface_60 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 55");

    PartSurface partSurface_61 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 56");

    PartSurface partSurface_62 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 57");

    PartSurface partSurface_63 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 58");

    PartSurface partSurface_64 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 59");

    PartSurface partSurface_65 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 60");

    PartSurface partSurface_66 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 61");

    PartSurface partSurface_67 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 62");

    PartSurface partSurface_68 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 63");

    PartSurface partSurface_69 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 64");

    PartSurface partSurface_70 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 65");

    PartSurface partSurface_71 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 66");

    PartSurface partSurface_72 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 67");

    PartSurface partSurface_73 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 68");

    PartSurface partSurface_74 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 69");

    PartSurface partSurface_75 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 70");

    PartSurface partSurface_76 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 71");

    PartSurface partSurface_77 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 72");

    PartSurface partSurface_78 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 73");

    PartSurface partSurface_79 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 74");

    PartSurface partSurface_80 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 75");

    PartSurface partSurface_81 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 76");

    PartSurface partSurface_82 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 77");

    PartSurface partSurface_83 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 78");

    PartSurface partSurface_84 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 79");

    PartSurface partSurface_85 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 80");

    PartSurface partSurface_86 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 81");

    PartSurface partSurface_87 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 82");

    PartSurface partSurface_88 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 83");

    PartSurface partSurface_89 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 84");

    PartSurface partSurface_90 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 85");

    PartSurface partSurface_91 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 86");

    PartSurface partSurface_92 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 87");

    PartSurface partSurface_93 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 88");

    PartSurface partSurface_94 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 89");

    PartSurface partSurface_95 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 90");

    PartSurface partSurface_96 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 91");

    PartSurface partSurface_97 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 92");

    PartSurface partSurface_98 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 93");

    PartSurface partSurface_99 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 94");

    PartSurface partSurface_100 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 95");

    PartSurface partSurface_101 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 96");

    PartSurface partSurface_102 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 97");

    PartSurface partSurface_103 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 98");

    PartSurface partSurface_104 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 99");

    PartSurface partSurface_105 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 100");

    PartSurface partSurface_106 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 101");

    PartSurface partSurface_107 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 102");

    PartSurface partSurface_108 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 103");

    PartSurface partSurface_109 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 104");

    PartSurface partSurface_110 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 105");

    PartSurface partSurface_111 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 106");

    PartSurface partSurface_112 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 107");

    PartSurface partSurface_113 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 108");

    PartSurface partSurface_114 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 109");

    PartSurface partSurface_115 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 110");

    PartSurface partSurface_116 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 111");

    PartSurface partSurface_117 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 112");

    cadPart_0.getPartSurfacesSharingPatches(partSurfaceMeshWidget_0, new NeoObjectVector(new Object[] {partSurface_0, partSurface_1, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12, partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22, partSurface_23, partSurface_24, partSurface_25, partSurface_26, partSurface_27, partSurface_28, partSurface_29, partSurface_30, partSurface_31, partSurface_32, partSurface_33, partSurface_34, partSurface_35, partSurface_36, partSurface_37, partSurface_38, partSurface_39, partSurface_40, partSurface_41, partSurface_42, partSurface_43, partSurface_44, partSurface_45, partSurface_46, partSurface_47, partSurface_48, partSurface_49, partSurface_50, partSurface_51, partSurface_52, partSurface_53, partSurface_54, partSurface_55, partSurface_56, partSurface_57, partSurface_58, partSurface_59, partSurface_60, partSurface_61, partSurface_62, partSurface_63, partSurface_64, partSurface_65, partSurface_66, partSurface_67, partSurface_68, partSurface_69, partSurface_70, partSurface_71, partSurface_72, partSurface_73, partSurface_74, partSurface_75, partSurface_76, partSurface_77, partSurface_78, partSurface_79, partSurface_80, partSurface_81, partSurface_82, partSurface_83, partSurface_84, partSurface_85, partSurface_86, partSurface_87, partSurface_88, partSurface_89, partSurface_90, partSurface_91, partSurface_92, partSurface_93, partSurface_94, partSurface_95, partSurface_96, partSurface_97, partSurface_98, partSurface_99, partSurface_100, partSurface_101, partSurface_102, partSurface_103, partSurface_104, partSurface_105, partSurface_106, partSurface_107, partSurface_108, partSurface_109, partSurface_110, partSurface_111, partSurface_112, partSurface_113, partSurface_114, partSurface_115, partSurface_116, partSurface_117}), new NeoObjectVector(new Object[] {}));

    PartSurface partSurface_118 = 
      cadPart_3.getPartSurfaceManager().getPartSurface("wall");

    PartSurface partSurface_119 = 
      cadPart_3.getPartSurfaceManager().getPartSurface("int1");

    PartSurface partSurface_120 = 
      cadPart_3.getPartSurfaceManager().getPartSurface("int0");

    cadPart_3.getPartSurfacesSharingPatches(partSurfaceMeshWidget_0, new NeoObjectVector(new Object[] {partSurface_118, partSurface_119, partSurface_120}), new NeoObjectVector(new Object[] {}));

    PartSurface partSurface_121 = 
      cadPart_4.getPartSurfaceManager().getPartSurface("wall");

    cadPart_4.getPartSurfacesSharingPatches(partSurfaceMeshWidget_0, new NeoObjectVector(new Object[] {partSurface_121}), new NeoObjectVector(new Object[] {}));

    PartSurface partSurface_122 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces");

    cadPart_5.getPartSurfacesSharingPatches(partSurfaceMeshWidget_0, new NeoObjectVector(new Object[] {partSurface_122}), new NeoObjectVector(new Object[] {}));

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_0.getHiddenParts().addObjects(partSurface_2, partSurface_3, partSurface_4, partSurface_118, partSurface_119, partSurface_120, partSurface_5, partSurface_6, partSurface_7, partSurface_121, partSurface_0, partSurface_1, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12, partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22, partSurface_23, partSurface_24, partSurface_25, partSurface_26, partSurface_27, partSurface_28, partSurface_29, partSurface_30, partSurface_31, partSurface_32, partSurface_33, partSurface_34, partSurface_35, partSurface_36, partSurface_37, partSurface_38, partSurface_39, partSurface_40, partSurface_41, partSurface_42, partSurface_43, partSurface_44, partSurface_45, partSurface_46, partSurface_47, partSurface_48, partSurface_49, partSurface_50, partSurface_51, partSurface_52, partSurface_53, partSurface_54, partSurface_55, partSurface_56, partSurface_57, partSurface_58, partSurface_59, partSurface_60, partSurface_61, partSurface_62, partSurface_63, partSurface_64, partSurface_65, partSurface_66, partSurface_67, partSurface_68, partSurface_69, partSurface_70, partSurface_71, partSurface_72, partSurface_73, partSurface_74, partSurface_75, partSurface_76, partSurface_77, partSurface_78, partSurface_79, partSurface_80, partSurface_81, partSurface_82, partSurface_83, partSurface_84, partSurface_85, partSurface_86, partSurface_87, partSurface_88, partSurface_89, partSurface_90, partSurface_91, partSurface_92, partSurface_93, partSurface_94, partSurface_95, partSurface_96, partSurface_97, partSurface_98, partSurface_99, partSurface_100, partSurface_101, partSurface_102, partSurface_103, partSurface_104, partSurface_105, partSurface_106, partSurface_107, partSurface_108, partSurface_109, partSurface_110, partSurface_111, partSurface_112, partSurface_113, partSurface_114, partSurface_115, partSurface_116, partSurface_117, partSurface_122);

    PartDisplayer partDisplayer_2 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getDisplayer("Geometry 1"));

    partDisplayer_2.getHiddenParts().addObjects(partSurface_2, partSurface_3, partSurface_4, partSurface_118, partSurface_119, partSurface_120, partSurface_5, partSurface_6, partSurface_7, partSurface_121, partSurface_0, partSurface_1, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12, partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22, partSurface_23, partSurface_24, partSurface_25, partSurface_26, partSurface_27, partSurface_28, partSurface_29, partSurface_30, partSurface_31, partSurface_32, partSurface_33, partSurface_34, partSurface_35, partSurface_36, partSurface_37, partSurface_38, partSurface_39, partSurface_40, partSurface_41, partSurface_42, partSurface_43, partSurface_44, partSurface_45, partSurface_46, partSurface_47, partSurface_48, partSurface_49, partSurface_50, partSurface_51, partSurface_52, partSurface_53, partSurface_54, partSurface_55, partSurface_56, partSurface_57, partSurface_58, partSurface_59, partSurface_60, partSurface_61, partSurface_62, partSurface_63, partSurface_64, partSurface_65, partSurface_66, partSurface_67, partSurface_68, partSurface_69, partSurface_70, partSurface_71, partSurface_72, partSurface_73, partSurface_74, partSurface_75, partSurface_76, partSurface_77, partSurface_78, partSurface_79, partSurface_80, partSurface_81, partSurface_82, partSurface_83, partSurface_84, partSurface_85, partSurface_86, partSurface_87, partSurface_88, partSurface_89, partSurface_90, partSurface_91, partSurface_92, partSurface_93, partSurface_94, partSurface_95, partSurface_96, partSurface_97, partSurface_98, partSurface_99, partSurface_100, partSurface_101, partSurface_102, partSurface_103, partSurface_104, partSurface_105, partSurface_106, partSurface_107, partSurface_108, partSurface_109, partSurface_110, partSurface_111, partSurface_112, partSurface_113, partSurface_114, partSurface_115, partSurface_116, partSurface_117, partSurface_122);

    SurfaceMeshWidgetDisplayController surfaceMeshWidgetDisplayController_0 = 
      partSurfaceMeshWidget_0.getControllers().getController(SurfaceMeshWidgetDisplayController.class);

    surfaceMeshWidgetDisplayController_0.showPartSurfaceFaces(new NeoObjectVector(new Object[] {partSurface_2, partSurface_3, partSurface_4, partSurface_118, partSurface_119, partSurface_120, partSurface_5, partSurface_6, partSurface_7, partSurface_121, partSurface_0, partSurface_1, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12, partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22, partSurface_23, partSurface_24, partSurface_25, partSurface_26, partSurface_27, partSurface_28, partSurface_29, partSurface_30, partSurface_31, partSurface_32, partSurface_33, partSurface_34, partSurface_35, partSurface_36, partSurface_37, partSurface_38, partSurface_39, partSurface_40, partSurface_41, partSurface_42, partSurface_43, partSurface_44, partSurface_45, partSurface_46, partSurface_47, partSurface_48, partSurface_49, partSurface_50, partSurface_51, partSurface_52, partSurface_53, partSurface_54, partSurface_55, partSurface_56, partSurface_57, partSurface_58, partSurface_59, partSurface_60, partSurface_61, partSurface_62, partSurface_63, partSurface_64, partSurface_65, partSurface_66, partSurface_67, partSurface_68, partSurface_69, partSurface_70, partSurface_71, partSurface_72, partSurface_73, partSurface_74, partSurface_75, partSurface_76, partSurface_77, partSurface_78, partSurface_79, partSurface_80, partSurface_81, partSurface_82, partSurface_83, partSurface_84, partSurface_85, partSurface_86, partSurface_87, partSurface_88, partSurface_89, partSurface_90, partSurface_91, partSurface_92, partSurface_93, partSurface_94, partSurface_95, partSurface_96, partSurface_97, partSurface_98, partSurface_99, partSurface_100, partSurface_101, partSurface_102, partSurface_103, partSurface_104, partSurface_105, partSurface_106, partSurface_107, partSurface_108, partSurface_109, partSurface_110, partSurface_111, partSurface_112, partSurface_113, partSurface_114, partSurface_115, partSurface_116, partSurface_117, partSurface_122}));

    currentView_0.setInput(new DoubleVector(new double[] {-0.007496950816607527, -0.003900051094678895, -0.0022171697432909984}), new DoubleVector(new double[] {0.02688111610645861, -0.02041965423217464, -0.0022332095965725534}), new DoubleVector(new double[] {0.07782106005263908, 0.16099395711788128, 0.9838825277358113}), 0.009956843994945596, 0);

    surfaceMeshWidgetDiagnosticsController_0.setDiagnosticsInputType(1);

    surfaceMeshWidgetDiagnosticsController_0.getDiagnosticsPartsGroup().setObjects(cadPart_0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.007496950816607527, -0.003900051094678895, -0.0022171697432909984}), new DoubleVector(new double[] {0.02688111610645861, -0.02041965423217464, -0.0022332095965725534}), new DoubleVector(new double[] {0.07782106005263908, 0.16099395711788128, 0.9838825277358113}), 0.009956843994945596, 0);

    SurfaceMeshWidgetSelectController surfaceMeshWidgetSelectController_0 = 
      partSurfaceMeshWidget_0.getControllers().getController(SurfaceMeshWidgetSelectController.class);

    surfaceMeshWidgetSelectController_0.clearSelected();

    currentView_0.setInput(new DoubleVector(new double[] {-0.007323167584259377, -0.003974190020748685, -0.00230118172241382}), new DoubleVector(new double[] {0.02667742039105995, -0.021266643052089085, 0.006231717615525001}), new DoubleVector(new double[] {-0.11157605302506036, 0.25461494189924594, 0.9605842054463485}), 0.010204040786624489, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.004029320120322763, -4.8410345783741864E-4, -0.009631363297620349}), new DoubleVector(new double[] {0.03021398867894466, -0.0179000025440195, -0.00103754994373939}), new DoubleVector(new double[] {-0.11157605302506036, 0.25461494189924594, 0.9605842054463485}), 0.010276884620652516, 0);

    surfaceMeshWidgetDiagnosticsController_0.setCheckSoftFeatureErrors(true);

    surfaceMeshWidgetDiagnosticsController_0.setSoftFeatureErrorsActive(true);

    surfaceMeshWidgetDiagnosticsController_0.setCheckHardFeatureErrors(true);

    surfaceMeshWidgetDiagnosticsController_0.setHardFeatureErrorsActive(true);

    surfaceMeshWidgetDiagnosticsController_0.setCheckSoftFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_0.setSoftFeatureErrorsActive(false);

    surfaceMeshWidgetDiagnosticsController_0.setCheckHardFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_0.setHardFeatureErrorsActive(false);

    surfaceMeshWidgetDiagnosticsController_0.setCheckSoftFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_0.setSoftFeatureErrorsActive(false);

    surfaceMeshWidgetDiagnosticsController_0.setCheckHardFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_0.setHardFeatureErrorsActive(false);

    surfaceMeshWidgetDiagnosticsController_0.setCheckSoftFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_0.setCheckHardFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_0.setCheckSoftFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_0.setCheckHardFeatureErrors(false);

    partSurfaceMeshWidget_0.stop();

    partDisplayer_2.getParts().addParts(partSurface_2, partSurface_3, partSurface_4, partSurface_118, partSurface_119, partSurface_120, partSurface_5, partSurface_6, partSurface_7, partSurface_121, partSurface_0, partSurface_1, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12, partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22, partSurface_23, partSurface_24, partSurface_25, partSurface_26, partSurface_27, partSurface_28, partSurface_29, partSurface_30, partSurface_31, partSurface_32, partSurface_33, partSurface_34, partSurface_35, partSurface_36, partSurface_37, partSurface_38, partSurface_39, partSurface_40, partSurface_41, partSurface_42, partSurface_43, partSurface_44, partSurface_45, partSurface_46, partSurface_47, partSurface_48, partSurface_49, partSurface_50, partSurface_51, partSurface_52, partSurface_53, partSurface_54, partSurface_55, partSurface_56, partSurface_57, partSurface_58, partSurface_59, partSurface_60, partSurface_61, partSurface_62, partSurface_63, partSurface_64, partSurface_65, partSurface_66, partSurface_67, partSurface_68, partSurface_69, partSurface_70, partSurface_71, partSurface_72, partSurface_73, partSurface_74, partSurface_75, partSurface_76, partSurface_77, partSurface_78, partSurface_79, partSurface_80, partSurface_81, partSurface_82, partSurface_83, partSurface_84, partSurface_85, partSurface_86, partSurface_87, partSurface_88, partSurface_89, partSurface_90, partSurface_91, partSurface_92, partSurface_93, partSurface_94, partSurface_95, partSurface_96, partSurface_97, partSurface_98, partSurface_99, partSurface_100, partSurface_101, partSurface_102, partSurface_103, partSurface_104, partSurface_105, partSurface_106, partSurface_107, partSurface_108, partSurface_109, partSurface_110, partSurface_111, partSurface_112, partSurface_113, partSurface_114, partSurface_115, partSurface_116, partSurface_117, partSurface_122);

    partDisplayer_0.getParts().addParts(partSurface_2, partSurface_3, partSurface_4, partSurface_118, partSurface_119, partSurface_120, partSurface_5, partSurface_6, partSurface_7, partSurface_121, partSurface_0, partSurface_1, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12, partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22, partSurface_23, partSurface_24, partSurface_25, partSurface_26, partSurface_27, partSurface_28, partSurface_29, partSurface_30, partSurface_31, partSurface_32, partSurface_33, partSurface_34, partSurface_35, partSurface_36, partSurface_37, partSurface_38, partSurface_39, partSurface_40, partSurface_41, partSurface_42, partSurface_43, partSurface_44, partSurface_45, partSurface_46, partSurface_47, partSurface_48, partSurface_49, partSurface_50, partSurface_51, partSurface_52, partSurface_53, partSurface_54, partSurface_55, partSurface_56, partSurface_57, partSurface_58, partSurface_59, partSurface_60, partSurface_61, partSurface_62, partSurface_63, partSurface_64, partSurface_65, partSurface_66, partSurface_67, partSurface_68, partSurface_69, partSurface_70, partSurface_71, partSurface_72, partSurface_73, partSurface_74, partSurface_75, partSurface_76, partSurface_77, partSurface_78, partSurface_79, partSurface_80, partSurface_81, partSurface_82, partSurface_83, partSurface_84, partSurface_85, partSurface_86, partSurface_87, partSurface_88, partSurface_89, partSurface_90, partSurface_91, partSurface_92, partSurface_93, partSurface_94, partSurface_95, partSurface_96, partSurface_97, partSurface_98, partSurface_99, partSurface_100, partSurface_101, partSurface_102, partSurface_103, partSurface_104, partSurface_105, partSurface_106, partSurface_107, partSurface_108, partSurface_109, partSurface_110, partSurface_111, partSurface_112, partSurface_113, partSurface_114, partSurface_115, partSurface_116, partSurface_117, partSurface_122);

    partDisplayer_3.getParts().setObjects(partSurface_0);

    PartSurfaceMeshWidget partSurfaceMeshWidget_1 = 
      partRepresentation_0.startSurfaceMeshWidget(scene_0);

    partSurfaceMeshWidget_1.setActiveParts(new NeoObjectVector(new Object[] {cadPart_0}), new NeoObjectVector(new Object[] {}), new NeoObjectVector(new Object[] {}));

    partSurfaceMeshWidget_1.startSurfaceMeshDiagnostics();

    partSurfaceMeshWidget_1.startSurfaceMeshRepair();

    partSurfaceMeshWidget_1.startMergeImprintController();

    partSurfaceMeshWidget_1.startIntersectController();

    partSurfaceMeshWidget_1.startLeakFinderController();

    partSurfaceMeshWidget_1.startSurfaceMeshQueryController();

    SurfaceMeshWidgetDiagnosticsController surfaceMeshWidgetDiagnosticsController_1 = 
      partSurfaceMeshWidget_1.getControllers().getController(SurfaceMeshWidgetDiagnosticsController.class);

    surfaceMeshWidgetDiagnosticsController_1.setCheckPiercedFaces(false);

    surfaceMeshWidgetDiagnosticsController_1.setPiercedFacesActive(false);

    surfaceMeshWidgetDiagnosticsController_1.setCheckPoorQualityFaces(false);

    surfaceMeshWidgetDiagnosticsController_1.setPoorQualityFacesActive(false);

    surfaceMeshWidgetDiagnosticsController_1.setMinimumFaceQuality(0.01);

    surfaceMeshWidgetDiagnosticsController_1.setCheckCloseProximityFaces(false);

    surfaceMeshWidgetDiagnosticsController_1.setCloseProximityFacesActive(false);

    surfaceMeshWidgetDiagnosticsController_1.setMinimumFaceProximity(0.05);

    surfaceMeshWidgetDiagnosticsController_1.setCheckFreeEdges(false);

    surfaceMeshWidgetDiagnosticsController_1.setFreeEdgesActive(false);

    surfaceMeshWidgetDiagnosticsController_1.setCheckNonmanifoldEdges(false);

    surfaceMeshWidgetDiagnosticsController_1.setNonmanifoldEdgesActive(false);

    surfaceMeshWidgetDiagnosticsController_1.setCheckNonmanifoldVertices(false);

    surfaceMeshWidgetDiagnosticsController_1.setNonmanifoldVerticesActive(false);

    surfaceMeshWidgetDiagnosticsController_1.setCheckFeatureNumberEdges(true);

    surfaceMeshWidgetDiagnosticsController_1.setCheckFeatureLength(false);

    surfaceMeshWidgetDiagnosticsController_1.setCheckFeatureAngle(true);

    surfaceMeshWidgetDiagnosticsController_1.setCheckFeatureOpenCurve(true);

    surfaceMeshWidgetDiagnosticsController_1.setCheckFeatureSmallRegions(false);

    surfaceMeshWidgetDiagnosticsController_1.setMinNumberEdges(5);

    surfaceMeshWidgetDiagnosticsController_1.setMinFeatureLength(1.0E-4);

    surfaceMeshWidgetDiagnosticsController_1.setMaxFeatureAngle(121.0);

    surfaceMeshWidgetDiagnosticsController_1.setMinFeatureRegionArea(1.0E-4);

    surfaceMeshWidgetDiagnosticsController_1.setCheckSoftFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_1.setSoftFeatureErrorsActive(false);

    surfaceMeshWidgetDiagnosticsController_1.setCheckHardFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_1.setHardFeatureErrorsActive(false);

    surfaceMeshWidgetDiagnosticsController_1.setCheckSoftFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_1.setSoftFeatureErrorsActive(false);

    surfaceMeshWidgetDiagnosticsController_1.setCheckHardFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_1.setHardFeatureErrorsActive(false);

    surfaceMeshWidgetMergeImprintOptions_0.setImprintMethod("NormalImprintMethod");

    surfaceMeshWidgetMergeImprintOptions_0.setMergeAction(SurfaceMeshWidgetMergedFaceOption.MAINTAIN_DEST_BOUNDARY);

    surfaceMeshWidgetDiagnosticsController_1.changeDisplayedThresholds(new NeoObjectVector(new Object[] {}), true);

    SurfaceMeshWidgetDisplayer surfaceMeshWidgetDisplayer_1 = 
      ((SurfaceMeshWidgetDisplayer) scene_0.getDisplayerManager().getDisplayer("Widget displayer 1"));

    surfaceMeshWidgetDisplayer_1.initialize();

    cadPart_0.getPartSurfacesSharingPatches(partSurfaceMeshWidget_1, new NeoObjectVector(new Object[] {partSurface_0, partSurface_1, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12, partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22, partSurface_23, partSurface_24, partSurface_25, partSurface_26, partSurface_27, partSurface_28, partSurface_29, partSurface_30, partSurface_31, partSurface_32, partSurface_33, partSurface_34, partSurface_35, partSurface_36, partSurface_37, partSurface_38, partSurface_39, partSurface_40, partSurface_41, partSurface_42, partSurface_43, partSurface_44, partSurface_45, partSurface_46, partSurface_47, partSurface_48, partSurface_49, partSurface_50, partSurface_51, partSurface_52, partSurface_53, partSurface_54, partSurface_55, partSurface_56, partSurface_57, partSurface_58, partSurface_59, partSurface_60, partSurface_61, partSurface_62, partSurface_63, partSurface_64, partSurface_65, partSurface_66, partSurface_67, partSurface_68, partSurface_69, partSurface_70, partSurface_71, partSurface_72, partSurface_73, partSurface_74, partSurface_75, partSurface_76, partSurface_77, partSurface_78, partSurface_79, partSurface_80, partSurface_81, partSurface_82, partSurface_83, partSurface_84, partSurface_85, partSurface_86, partSurface_87, partSurface_88, partSurface_89, partSurface_90, partSurface_91, partSurface_92, partSurface_93, partSurface_94, partSurface_95, partSurface_96, partSurface_97, partSurface_98, partSurface_99, partSurface_100, partSurface_101, partSurface_102, partSurface_103, partSurface_104, partSurface_105, partSurface_106, partSurface_107, partSurface_108, partSurface_109, partSurface_110, partSurface_111, partSurface_112, partSurface_113, partSurface_114, partSurface_115, partSurface_116, partSurface_117}), new NeoObjectVector(new Object[] {}));

    partDisplayer_0.getHiddenParts().addObjects(partSurface_2, partSurface_3, partSurface_4, partSurface_118, partSurface_119, partSurface_120, partSurface_5, partSurface_6, partSurface_7, partSurface_121, partSurface_0, partSurface_1, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12, partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22, partSurface_23, partSurface_24, partSurface_25, partSurface_26, partSurface_27, partSurface_28, partSurface_29, partSurface_30, partSurface_31, partSurface_32, partSurface_33, partSurface_34, partSurface_35, partSurface_36, partSurface_37, partSurface_38, partSurface_39, partSurface_40, partSurface_41, partSurface_42, partSurface_43, partSurface_44, partSurface_45, partSurface_46, partSurface_47, partSurface_48, partSurface_49, partSurface_50, partSurface_51, partSurface_52, partSurface_53, partSurface_54, partSurface_55, partSurface_56, partSurface_57, partSurface_58, partSurface_59, partSurface_60, partSurface_61, partSurface_62, partSurface_63, partSurface_64, partSurface_65, partSurface_66, partSurface_67, partSurface_68, partSurface_69, partSurface_70, partSurface_71, partSurface_72, partSurface_73, partSurface_74, partSurface_75, partSurface_76, partSurface_77, partSurface_78, partSurface_79, partSurface_80, partSurface_81, partSurface_82, partSurface_83, partSurface_84, partSurface_85, partSurface_86, partSurface_87, partSurface_88, partSurface_89, partSurface_90, partSurface_91, partSurface_92, partSurface_93, partSurface_94, partSurface_95, partSurface_96, partSurface_97, partSurface_98, partSurface_99, partSurface_100, partSurface_101, partSurface_102, partSurface_103, partSurface_104, partSurface_105, partSurface_106, partSurface_107, partSurface_108, partSurface_109, partSurface_110, partSurface_111, partSurface_112, partSurface_113, partSurface_114, partSurface_115, partSurface_116, partSurface_117, partSurface_122);

    partDisplayer_2.getHiddenParts().addObjects(partSurface_2, partSurface_3, partSurface_4, partSurface_118, partSurface_119, partSurface_120, partSurface_5, partSurface_6, partSurface_7, partSurface_121, partSurface_0, partSurface_1, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12, partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22, partSurface_23, partSurface_24, partSurface_25, partSurface_26, partSurface_27, partSurface_28, partSurface_29, partSurface_30, partSurface_31, partSurface_32, partSurface_33, partSurface_34, partSurface_35, partSurface_36, partSurface_37, partSurface_38, partSurface_39, partSurface_40, partSurface_41, partSurface_42, partSurface_43, partSurface_44, partSurface_45, partSurface_46, partSurface_47, partSurface_48, partSurface_49, partSurface_50, partSurface_51, partSurface_52, partSurface_53, partSurface_54, partSurface_55, partSurface_56, partSurface_57, partSurface_58, partSurface_59, partSurface_60, partSurface_61, partSurface_62, partSurface_63, partSurface_64, partSurface_65, partSurface_66, partSurface_67, partSurface_68, partSurface_69, partSurface_70, partSurface_71, partSurface_72, partSurface_73, partSurface_74, partSurface_75, partSurface_76, partSurface_77, partSurface_78, partSurface_79, partSurface_80, partSurface_81, partSurface_82, partSurface_83, partSurface_84, partSurface_85, partSurface_86, partSurface_87, partSurface_88, partSurface_89, partSurface_90, partSurface_91, partSurface_92, partSurface_93, partSurface_94, partSurface_95, partSurface_96, partSurface_97, partSurface_98, partSurface_99, partSurface_100, partSurface_101, partSurface_102, partSurface_103, partSurface_104, partSurface_105, partSurface_106, partSurface_107, partSurface_108, partSurface_109, partSurface_110, partSurface_111, partSurface_112, partSurface_113, partSurface_114, partSurface_115, partSurface_116, partSurface_117, partSurface_122);

    partDisplayer_3.getParts().eraseObjects(partSurface_0);

    SurfaceMeshWidgetDisplayController surfaceMeshWidgetDisplayController_1 = 
      partSurfaceMeshWidget_1.getControllers().getController(SurfaceMeshWidgetDisplayController.class);

    surfaceMeshWidgetDisplayController_1.showPartSurfaceFaces(new NeoObjectVector(new Object[] {partSurface_2, partSurface_3, partSurface_4, partSurface_118, partSurface_119, partSurface_120, partSurface_5, partSurface_6, partSurface_7, partSurface_121, partSurface_0, partSurface_1, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12, partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22, partSurface_23, partSurface_24, partSurface_25, partSurface_26, partSurface_27, partSurface_28, partSurface_29, partSurface_30, partSurface_31, partSurface_32, partSurface_33, partSurface_34, partSurface_35, partSurface_36, partSurface_37, partSurface_38, partSurface_39, partSurface_40, partSurface_41, partSurface_42, partSurface_43, partSurface_44, partSurface_45, partSurface_46, partSurface_47, partSurface_48, partSurface_49, partSurface_50, partSurface_51, partSurface_52, partSurface_53, partSurface_54, partSurface_55, partSurface_56, partSurface_57, partSurface_58, partSurface_59, partSurface_60, partSurface_61, partSurface_62, partSurface_63, partSurface_64, partSurface_65, partSurface_66, partSurface_67, partSurface_68, partSurface_69, partSurface_70, partSurface_71, partSurface_72, partSurface_73, partSurface_74, partSurface_75, partSurface_76, partSurface_77, partSurface_78, partSurface_79, partSurface_80, partSurface_81, partSurface_82, partSurface_83, partSurface_84, partSurface_85, partSurface_86, partSurface_87, partSurface_88, partSurface_89, partSurface_90, partSurface_91, partSurface_92, partSurface_93, partSurface_94, partSurface_95, partSurface_96, partSurface_97, partSurface_98, partSurface_99, partSurface_100, partSurface_101, partSurface_102, partSurface_103, partSurface_104, partSurface_105, partSurface_106, partSurface_107, partSurface_108, partSurface_109, partSurface_110, partSurface_111, partSurface_112, partSurface_113, partSurface_114, partSurface_115, partSurface_116, partSurface_117, partSurface_122}));

    surfaceMeshWidgetDiagnosticsController_1.setCheckSoftFeatureErrors(true);

    surfaceMeshWidgetDiagnosticsController_1.setSoftFeatureErrorsActive(true);

    surfaceMeshWidgetDiagnosticsController_1.setCheckHardFeatureErrors(true);

    surfaceMeshWidgetDiagnosticsController_1.setHardFeatureErrorsActive(true);

    surfaceMeshWidgetDiagnosticsController_1.setCheckSoftFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_1.setSoftFeatureErrorsActive(false);

    surfaceMeshWidgetDiagnosticsController_1.setCheckHardFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_1.setHardFeatureErrorsActive(false);

    currentView_0.setInput(new DoubleVector(new double[] {-0.004029320120322763, -4.8410345783741864E-4, -0.009631363297620349}), new DoubleVector(new double[] {0.03021398867894466, -0.0179000025440195, -0.00103754994373939}), new DoubleVector(new double[] {-0.11157605302506036, 0.25461494189924594, 0.9605842054463485}), 0.010276884620652516, 0);

    SurfaceMeshWidgetSelectController surfaceMeshWidgetSelectController_1 = 
      partSurfaceMeshWidget_1.getControllers().getController(SurfaceMeshWidgetSelectController.class);

    surfaceMeshWidgetSelectController_1.toggleFace(271, false);

    surfaceMeshWidgetDiagnosticsController_1.setCheckSoftFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_1.setCheckHardFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_1.setCheckSoftFeatureErrors(false);

    surfaceMeshWidgetDiagnosticsController_1.setCheckHardFeatureErrors(false);

    partSurfaceMeshWidget_1.stop();

    partDisplayer_2.getParts().addParts(partSurface_2, partSurface_3, partSurface_4, partSurface_118, partSurface_119, partSurface_120, partSurface_5, partSurface_6, partSurface_7, partSurface_121, partSurface_0, partSurface_1, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12, partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22, partSurface_23, partSurface_24, partSurface_25, partSurface_26, partSurface_27, partSurface_28, partSurface_29, partSurface_30, partSurface_31, partSurface_32, partSurface_33, partSurface_34, partSurface_35, partSurface_36, partSurface_37, partSurface_38, partSurface_39, partSurface_40, partSurface_41, partSurface_42, partSurface_43, partSurface_44, partSurface_45, partSurface_46, partSurface_47, partSurface_48, partSurface_49, partSurface_50, partSurface_51, partSurface_52, partSurface_53, partSurface_54, partSurface_55, partSurface_56, partSurface_57, partSurface_58, partSurface_59, partSurface_60, partSurface_61, partSurface_62, partSurface_63, partSurface_64, partSurface_65, partSurface_66, partSurface_67, partSurface_68, partSurface_69, partSurface_70, partSurface_71, partSurface_72, partSurface_73, partSurface_74, partSurface_75, partSurface_76, partSurface_77, partSurface_78, partSurface_79, partSurface_80, partSurface_81, partSurface_82, partSurface_83, partSurface_84, partSurface_85, partSurface_86, partSurface_87, partSurface_88, partSurface_89, partSurface_90, partSurface_91, partSurface_92, partSurface_93, partSurface_94, partSurface_95, partSurface_96, partSurface_97, partSurface_98, partSurface_99, partSurface_100, partSurface_101, partSurface_102, partSurface_103, partSurface_104, partSurface_105, partSurface_106, partSurface_107, partSurface_108, partSurface_109, partSurface_110, partSurface_111, partSurface_112, partSurface_113, partSurface_114, partSurface_115, partSurface_116, partSurface_117, partSurface_122);

    partDisplayer_0.getParts().addParts(partSurface_2, partSurface_3, partSurface_4, partSurface_118, partSurface_119, partSurface_120, partSurface_5, partSurface_6, partSurface_7, partSurface_121, partSurface_0, partSurface_1, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12, partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22, partSurface_23, partSurface_24, partSurface_25, partSurface_26, partSurface_27, partSurface_28, partSurface_29, partSurface_30, partSurface_31, partSurface_32, partSurface_33, partSurface_34, partSurface_35, partSurface_36, partSurface_37, partSurface_38, partSurface_39, partSurface_40, partSurface_41, partSurface_42, partSurface_43, partSurface_44, partSurface_45, partSurface_46, partSurface_47, partSurface_48, partSurface_49, partSurface_50, partSurface_51, partSurface_52, partSurface_53, partSurface_54, partSurface_55, partSurface_56, partSurface_57, partSurface_58, partSurface_59, partSurface_60, partSurface_61, partSurface_62, partSurface_63, partSurface_64, partSurface_65, partSurface_66, partSurface_67, partSurface_68, partSurface_69, partSurface_70, partSurface_71, partSurface_72, partSurface_73, partSurface_74, partSurface_75, partSurface_76, partSurface_77, partSurface_78, partSurface_79, partSurface_80, partSurface_81, partSurface_82, partSurface_83, partSurface_84, partSurface_85, partSurface_86, partSurface_87, partSurface_88, partSurface_89, partSurface_90, partSurface_91, partSurface_92, partSurface_93, partSurface_94, partSurface_95, partSurface_96, partSurface_97, partSurface_98, partSurface_99, partSurface_100, partSurface_101, partSurface_102, partSurface_103, partSurface_104, partSurface_105, partSurface_106, partSurface_107, partSurface_108, partSurface_109, partSurface_110, partSurface_111, partSurface_112, partSurface_113, partSurface_114, partSurface_115, partSurface_116, partSurface_117, partSurface_122);

    currentView_0.setInput(new DoubleVector(new double[] {-0.003786211702842946, -6.146739146956347E-4, -0.00954030706484343}), new DoubleVector(new double[] {0.02716528613115028, -0.01840502765573917, 0.00711274669820737}), new DoubleVector(new double[] {-0.2820528632793708, 0.3466733216142547, 0.8945746421606463}), 0.010283661944685163, 0);

    partDisplayer_3.getParts().setObjects(partSurface_0, partSurface_1, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12, partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22, partSurface_23, partSurface_24, partSurface_25, partSurface_26, partSurface_27, partSurface_28, partSurface_29, partSurface_30, partSurface_31, partSurface_32, partSurface_33, partSurface_34, partSurface_35, partSurface_36, partSurface_37, partSurface_38, partSurface_39, partSurface_40, partSurface_41, partSurface_42, partSurface_43, partSurface_44, partSurface_45, partSurface_46, partSurface_47, partSurface_48, partSurface_49, partSurface_50, partSurface_51, partSurface_52, partSurface_53, partSurface_54, partSurface_55, partSurface_56, partSurface_57, partSurface_58, partSurface_59, partSurface_60, partSurface_61, partSurface_62, partSurface_63, partSurface_64, partSurface_65, partSurface_66, partSurface_67, partSurface_68, partSurface_69, partSurface_70, partSurface_71, partSurface_72, partSurface_73, partSurface_74, partSurface_75, partSurface_76, partSurface_77, partSurface_78, partSurface_79, partSurface_80, partSurface_81, partSurface_82, partSurface_83, partSurface_84, partSurface_85, partSurface_86, partSurface_87, partSurface_88, partSurface_89, partSurface_90, partSurface_91, partSurface_92, partSurface_93, partSurface_94, partSurface_95, partSurface_96, partSurface_97, partSurface_98, partSurface_99, partSurface_100, partSurface_101, partSurface_102, partSurface_103, partSurface_104, partSurface_105, partSurface_106, partSurface_107, partSurface_108, partSurface_109, partSurface_110, partSurface_111, partSurface_112, partSurface_113, partSurface_114, partSurface_115, partSurface_116, partSurface_117);

    currentView_0.setInput(new DoubleVector(new double[] {-0.003786211702842946, -6.146739146956347E-4, -0.00954030706484343}), new DoubleVector(new double[] {0.02716528613115028, -0.01840502765573917, 0.00711274669820737}), new DoubleVector(new double[] {-0.2820528632793708, 0.3466733216142547, 0.8945746421606463}), 0.010283661944685163, 0);

    partDisplayer_0.getHiddenParts().addObjects(partSurface_2, partSurface_3, partSurface_4, partSurface_118, partSurface_119, partSurface_120, partSurface_5, partSurface_6, partSurface_7, partSurface_121, partSurface_122);

    partDisplayer_2.getHiddenParts().addObjects(partSurface_2, partSurface_3, partSurface_4, partSurface_118, partSurface_119, partSurface_120, partSurface_5, partSurface_6, partSurface_7, partSurface_121, partSurface_122);

    currentView_0.setInput(new DoubleVector(new double[] {-0.003786211702842946, -6.146739146956347E-4, -0.00954030706484343}), new DoubleVector(new double[] {0.02716528613115028, -0.01840502765573917, 0.00711274669820737}), new DoubleVector(new double[] {-0.2820528632793708, 0.3466733216142547, 0.8945746421606463}), 0.010283661944685163, 0);

    partDisplayer_3.getParts().setObjects();

    currentView_0.setInput(new DoubleVector(new double[] {-0.003786211702842946, -6.146739146956347E-4, -0.00954030706484343}), new DoubleVector(new double[] {0.02716528613115028, -0.01840502765573917, 0.00711274669820737}), new DoubleVector(new double[] {-0.2820528632793708, 0.3466733216142547, 0.8945746421606463}), 0.010283661944685163, 0);

    partDisplayer_3.getParts().setObjects(partSurface_102);

    currentView_0.setInput(new DoubleVector(new double[] {-0.003786211702842946, -6.146739146956347E-4, -0.00954030706484343}), new DoubleVector(new double[] {0.02716528613115028, -0.01840502765573917, 0.00711274669820737}), new DoubleVector(new double[] {-0.2820528632793708, 0.3466733216142547, 0.8945746421606463}), 0.010283661944685163, 0);

    partDisplayer_3.getParts().setObjects(partSurface_102, partSurface_108);

    currentView_0.setInput(new DoubleVector(new double[] {-0.003786211702842946, -6.146739146956347E-4, -0.00954030706484343}), new DoubleVector(new double[] {0.02716528613115028, -0.01840502765573917, 0.00711274669820737}), new DoubleVector(new double[] {-0.2820528632793708, 0.3466733216142547, 0.8945746421606463}), 0.010283661944685163, 0);

    partDisplayer_3.getParts().setObjects(partSurface_102, partSurface_108, partSurface_116);

    currentView_0.setInput(new DoubleVector(new double[] {-0.003786211702842946, -6.146739146956347E-4, -0.00954030706484343}), new DoubleVector(new double[] {0.02716528613115028, -0.01840502765573917, 0.00711274669820737}), new DoubleVector(new double[] {-0.2820528632793708, 0.3466733216142547, 0.8945746421606463}), 0.010283661944685163, 0);

    partDisplayer_3.getParts().setObjects(partSurface_102, partSurface_108, partSurface_116, partSurface_43);

    currentView_0.setInput(new DoubleVector(new double[] {-0.003786211702842946, -6.146739146956347E-4, -0.00954030706484343}), new DoubleVector(new double[] {0.02716528613115028, -0.01840502765573917, 0.00711274669820737}), new DoubleVector(new double[] {-0.2820528632793708, 0.3466733216142547, 0.8945746421606463}), 0.010283661944685163, 0);

    cadPart_0.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_102, partSurface_108, partSurface_116, partSurface_43}));

    partDisplayer_3.getParts().setObjects(partSurface_102);

    currentView_0.setInput(new DoubleVector(new double[] {-0.003786211702842946, -6.146739146956347E-4, -0.00954030706484343}), new DoubleVector(new double[] {0.02716528613115028, -0.01840502765573917, 0.00711274669820737}), new DoubleVector(new double[] {-0.2820528632793708, 0.3466733216142547, 0.8945746421606463}), 0.010283661944685163, 0);

    partSurface_102.setPresentationName("int1");

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    partDisplayer_3.getParts().setObjects(partSurface_60);

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    partDisplayer_3.getParts().setObjects(partSurface_60, partSurface_17);

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    partDisplayer_3.getParts().setObjects(partSurface_60, partSurface_17, partSurface_74);

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    partDisplayer_3.getParts().setObjects(partSurface_60, partSurface_17, partSurface_74, partSurface_86);

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    partDisplayer_3.getParts().setObjects(partSurface_60, partSurface_17, partSurface_74, partSurface_86, partSurface_56);

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    partDisplayer_3.getParts().setObjects(partSurface_60, partSurface_17, partSurface_74, partSurface_86, partSurface_56, partSurface_0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    partDisplayer_3.getParts().setObjects(partSurface_60, partSurface_17, partSurface_74, partSurface_86, partSurface_56, partSurface_0, partSurface_69);

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    partDisplayer_3.getParts().setObjects(partSurface_60, partSurface_17, partSurface_74, partSurface_86, partSurface_56, partSurface_0, partSurface_69, partSurface_82);

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    cadPart_0.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_60, partSurface_17, partSurface_74, partSurface_86, partSurface_56, partSurface_0, partSurface_69, partSurface_82}));

    partDisplayer_3.getParts().setObjects(partSurface_60);

    partDisplayer_3.getParts().setObjects(partSurface_60);

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    partSurface_60.setPresentationName("int0");

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    partDisplayer_3.getParts().setObjects(partSurface_30);

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    partDisplayer_3.getParts().setObjects(partSurface_30);

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    partDisplayer_3.getParts().setObjects();

    partDisplayer_3.getParts().setObjects(partSurface_117);

    partDisplayer_3.getParts().setObjects(partSurface_50, partSurface_24, partSurface_33, partSurface_60, partSurface_42, partSurface_64, partSurface_77, partSurface_100, partSurface_93, partSurface_10, partSurface_12, partSurface_89, partSurface_113, partSurface_35, partSurface_85, partSurface_90, partSurface_27, partSurface_61, partSurface_106, partSurface_95, partSurface_104, partSurface_109, partSurface_62, partSurface_38, partSurface_98, partSurface_115, partSurface_34, partSurface_80, partSurface_26, partSurface_1, partSurface_49, partSurface_15, partSurface_111, partSurface_23, partSurface_28, partSurface_65, partSurface_71, partSurface_91, partSurface_54, partSurface_52, partSurface_94, partSurface_47, partSurface_36, partSurface_20, partSurface_81, partSurface_40, partSurface_73, partSurface_76, partSurface_99, partSurface_83, partSurface_8, partSurface_41, partSurface_31, partSurface_18, partSurface_67, partSurface_96, partSurface_107, partSurface_88, partSurface_59, partSurface_30, partSurface_9, partSurface_48, partSurface_92, partSurface_110, partSurface_39, partSurface_66, partSurface_55, partSurface_117, partSurface_103, partSurface_29, partSurface_32, partSurface_37, partSurface_68, partSurface_101, partSurface_112, partSurface_51, partSurface_13, partSurface_11, partSurface_97, partSurface_53, partSurface_22, partSurface_19, partSurface_84, partSurface_87, partSurface_44, partSurface_79, partSurface_46, partSurface_58, partSurface_21, partSurface_78, partSurface_70, partSurface_57, partSurface_63, partSurface_105, partSurface_45, partSurface_16, partSurface_25, partSurface_14, partSurface_72, partSurface_75, partSurface_114);

    partDisplayer_3.getParts().setObjects(partSurface_50, partSurface_24, partSurface_33, partSurface_42, partSurface_64, partSurface_77, partSurface_100, partSurface_93, partSurface_10, partSurface_12, partSurface_89, partSurface_113, partSurface_35, partSurface_85, partSurface_90, partSurface_61, partSurface_27, partSurface_106, partSurface_95, partSurface_104, partSurface_109, partSurface_62, partSurface_38, partSurface_98, partSurface_115, partSurface_34, partSurface_80, partSurface_26, partSurface_1, partSurface_111, partSurface_49, partSurface_15, partSurface_23, partSurface_28, partSurface_65, partSurface_71, partSurface_91, partSurface_54, partSurface_52, partSurface_94, partSurface_47, partSurface_36, partSurface_20, partSurface_81, partSurface_40, partSurface_73, partSurface_76, partSurface_99, partSurface_83, partSurface_8, partSurface_31, partSurface_41, partSurface_18, partSurface_67, partSurface_96, partSurface_107, partSurface_88, partSurface_59, partSurface_30, partSurface_9, partSurface_48, partSurface_92, partSurface_110, partSurface_66, partSurface_39, partSurface_55, partSurface_117, partSurface_103, partSurface_29, partSurface_32, partSurface_37, partSurface_68, partSurface_101, partSurface_112, partSurface_51, partSurface_13, partSurface_11, partSurface_97, partSurface_53, partSurface_22, partSurface_84, partSurface_19, partSurface_87, partSurface_44, partSurface_79, partSurface_46, partSurface_21, partSurface_58, partSurface_78, partSurface_70, partSurface_57, partSurface_63, partSurface_105, partSurface_45, partSurface_16, partSurface_25, partSurface_14, partSurface_72, partSurface_75, partSurface_114);

    cadPart_0.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_37, partSurface_77, partSurface_93, partSurface_92, partSurface_20, partSurface_97, partSurface_14, partSurface_72, partSurface_76, partSurface_19, partSurface_84, partSurface_15, partSurface_49, partSurface_95, partSurface_53, partSurface_94, partSurface_34, partSurface_24, partSurface_64, partSurface_90, partSurface_66, partSurface_79, partSurface_65, partSurface_89, partSurface_88, partSurface_87, partSurface_83, partSurface_109, partSurface_103, partSurface_38, partSurface_21, partSurface_11, partSurface_106, partSurface_1, partSurface_48, partSurface_78, partSurface_32, partSurface_8, partSurface_67, partSurface_10, partSurface_57, partSurface_29, partSurface_52, partSurface_114, partSurface_111, partSurface_107, partSurface_117, partSurface_70, partSurface_40, partSurface_51, partSurface_23, partSurface_110, partSurface_50, partSurface_16, partSurface_68, partSurface_104, partSurface_22, partSurface_98, partSurface_105, partSurface_26, partSurface_18, partSurface_71, partSurface_35, partSurface_62, partSurface_47, partSurface_31, partSurface_44, partSurface_54, partSurface_42, partSurface_100, partSurface_75, partSurface_73, partSurface_12, partSurface_30, partSurface_101, partSurface_80, partSurface_41, partSurface_112, partSurface_33, partSurface_59, partSurface_115, partSurface_85, partSurface_61, partSurface_55, partSurface_27, partSurface_46, partSurface_63, partSurface_99, partSurface_13, partSurface_28, partSurface_81, partSurface_96, partSurface_45, partSurface_39, partSurface_58, partSurface_36, partSurface_25, partSurface_91, partSurface_113, partSurface_9}));

    partDisplayer_3.getParts().setObjects(partSurface_37);

    partSurface_37.setPresentationName("wall");

    partDisplayer_3.getParts().setObjects(partSurface_37, partSurface_60, partSurface_102);

    partDisplayer_3.getParts().setObjects(partSurface_122);

    PartCurve partCurve_1 = 
      ((PartCurve) cadPart_5.getPartCurveManager().getObject("Edges"));

    cadPart_5.getPartSurfaceManager().splitPartSurfacesByPartCurves(new NeoObjectVector(new Object[] {partSurface_122}), new NeoObjectVector(new Object[] {partCurve_1}));

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    partDisplayer_3.getParts().setObjects();

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    PartSurface partSurface_123 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 2");

    PartSurface partSurface_124 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 3");

    PartSurface partSurface_125 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 4");

    PartSurface partSurface_126 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 5");

    PartSurface partSurface_127 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 6");

    PartSurface partSurface_128 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 7");

    PartSurface partSurface_129 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 8");

    PartSurface partSurface_130 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 9");

    PartSurface partSurface_131 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 10");

    PartSurface partSurface_132 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 11");

    PartSurface partSurface_133 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 12");

    PartSurface partSurface_134 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 13");

    PartSurface partSurface_135 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 14");

    PartSurface partSurface_136 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 15");

    PartSurface partSurface_137 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 16");

    PartSurface partSurface_138 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 17");

    PartSurface partSurface_139 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 18");

    PartSurface partSurface_140 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 19");

    PartSurface partSurface_141 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 20");

    PartSurface partSurface_142 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 21");

    PartSurface partSurface_143 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 22");

    PartSurface partSurface_144 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 23");

    PartSurface partSurface_145 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 24");

    PartSurface partSurface_146 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 25");

    PartSurface partSurface_147 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 26");

    PartSurface partSurface_148 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 27");

    PartSurface partSurface_149 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 28");

    PartSurface partSurface_150 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 29");

    PartSurface partSurface_151 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 30");

    PartSurface partSurface_152 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 31");

    PartSurface partSurface_153 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 32");

    PartSurface partSurface_154 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 33");

    PartSurface partSurface_155 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 34");

    PartSurface partSurface_156 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 35");

    PartSurface partSurface_157 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 36");

    PartSurface partSurface_158 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 37");

    PartSurface partSurface_159 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 38");

    PartSurface partSurface_160 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 39");

    PartSurface partSurface_161 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 40");

    PartSurface partSurface_162 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 41");

    PartSurface partSurface_163 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 42");

    PartSurface partSurface_164 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 43");

    PartSurface partSurface_165 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 44");

    PartSurface partSurface_166 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 45");

    PartSurface partSurface_167 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 46");

    PartSurface partSurface_168 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 47");

    PartSurface partSurface_169 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 48");

    PartSurface partSurface_170 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 49");

    PartSurface partSurface_171 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 50");

    PartSurface partSurface_172 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 51");

    PartSurface partSurface_173 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 52");

    PartSurface partSurface_174 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 53");

    PartSurface partSurface_175 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 54");

    PartSurface partSurface_176 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 55");

    PartSurface partSurface_177 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 56");

    PartSurface partSurface_178 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 57");

    PartSurface partSurface_179 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 58");

    PartSurface partSurface_180 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 59");

    PartSurface partSurface_181 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 60");

    PartSurface partSurface_182 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 61");

    PartSurface partSurface_183 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 62");

    PartSurface partSurface_184 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 63");

    PartSurface partSurface_185 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 64");

    PartSurface partSurface_186 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 65");

    PartSurface partSurface_187 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 66");

    PartSurface partSurface_188 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 67");

    PartSurface partSurface_189 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 68");

    PartSurface partSurface_190 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 69");

    PartSurface partSurface_191 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 70");

    PartSurface partSurface_192 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 71");

    PartSurface partSurface_193 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 72");

    PartSurface partSurface_194 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 73");

    PartSurface partSurface_195 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 74");

    PartSurface partSurface_196 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 75");

    PartSurface partSurface_197 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 76");

    PartSurface partSurface_198 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 77");

    PartSurface partSurface_199 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 78");

    PartSurface partSurface_200 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 79");

    PartSurface partSurface_201 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 80");

    PartSurface partSurface_202 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 81");

    PartSurface partSurface_203 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 82");

    PartSurface partSurface_204 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 83");

    PartSurface partSurface_205 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 84");

    PartSurface partSurface_206 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 85");

    PartSurface partSurface_207 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 86");

    PartSurface partSurface_208 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 87");

    PartSurface partSurface_209 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 88");

    PartSurface partSurface_210 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 89");

    PartSurface partSurface_211 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 90");

    PartSurface partSurface_212 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 91");

    PartSurface partSurface_213 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 92");

    PartSurface partSurface_214 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 93");

    PartSurface partSurface_215 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 94");

    PartSurface partSurface_216 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 95");

    PartSurface partSurface_217 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 96");

    PartSurface partSurface_218 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 97");

    PartSurface partSurface_219 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 98");

    PartSurface partSurface_220 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 99");

    PartSurface partSurface_221 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 100");

    PartSurface partSurface_222 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 101");

    PartSurface partSurface_223 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 102");

    PartSurface partSurface_224 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 103");

    PartSurface partSurface_225 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 104");

    PartSurface partSurface_226 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 105");

    PartSurface partSurface_227 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 106");

    PartSurface partSurface_228 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 107");

    PartSurface partSurface_229 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 108");

    PartSurface partSurface_230 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 109");

    PartSurface partSurface_231 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 110");

    PartSurface partSurface_232 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 111");

    PartSurface partSurface_233 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 112");

    partDisplayer_3.getParts().setObjects(partSurface_122, partSurface_123, partSurface_124, partSurface_125, partSurface_126, partSurface_127, partSurface_128, partSurface_129, partSurface_130, partSurface_131, partSurface_132, partSurface_133, partSurface_134, partSurface_135, partSurface_136, partSurface_137, partSurface_138, partSurface_139, partSurface_140, partSurface_141, partSurface_142, partSurface_143, partSurface_144, partSurface_145, partSurface_146, partSurface_147, partSurface_148, partSurface_149, partSurface_150, partSurface_151, partSurface_152, partSurface_153, partSurface_154, partSurface_155, partSurface_156, partSurface_157, partSurface_158, partSurface_159, partSurface_160, partSurface_161, partSurface_162, partSurface_163, partSurface_164, partSurface_165, partSurface_166, partSurface_167, partSurface_168, partSurface_169, partSurface_170, partSurface_171, partSurface_172, partSurface_173, partSurface_174, partSurface_175, partSurface_176, partSurface_177, partSurface_178, partSurface_179, partSurface_180, partSurface_181, partSurface_182, partSurface_183, partSurface_184, partSurface_185, partSurface_186, partSurface_187, partSurface_188, partSurface_189, partSurface_190, partSurface_191, partSurface_192, partSurface_193, partSurface_194, partSurface_195, partSurface_196, partSurface_197, partSurface_198, partSurface_199, partSurface_200, partSurface_201, partSurface_202, partSurface_203, partSurface_204, partSurface_205, partSurface_206, partSurface_207, partSurface_208, partSurface_209, partSurface_210, partSurface_211, partSurface_212, partSurface_213, partSurface_214, partSurface_215, partSurface_216, partSurface_217, partSurface_218, partSurface_219, partSurface_220, partSurface_221, partSurface_222, partSurface_223, partSurface_224, partSurface_225, partSurface_226, partSurface_227, partSurface_228, partSurface_229, partSurface_230, partSurface_231, partSurface_232, partSurface_233);
  }

  private void execute1() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    PartDisplayer partDisplayer_3 = 
      ((PartDisplayer) scene_0.getHighlightDisplayer());

    partDisplayer_3.getParts().setObjects();

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getDisplayer("Outline 1"));

    CompositePart compositePart_0 = 
      ((CompositePart) simulation_0.get(SimulationPartManager.class).getPart("Assembly 1"));

    CadPart cadPart_0 = 
      ((CadPart) compositePart_0.getChildParts().getPart("out0"));

    PartSurface partSurface_37 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("wall");

    PartSurface partSurface_60 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("int0");

    PartSurface partSurface_102 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("int1");

    CadPart cadPart_5 = 
      ((CadPart) compositePart_0.getChildParts().getPart("in0"));

    PartSurface partSurface_123 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 2");

    PartSurface partSurface_124 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 3");

    PartSurface partSurface_125 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 4");

    PartSurface partSurface_126 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 5");

    PartSurface partSurface_127 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 6");

    PartSurface partSurface_128 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 7");

    PartSurface partSurface_129 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 8");

    PartSurface partSurface_130 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 9");

    PartSurface partSurface_131 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 10");

    PartSurface partSurface_132 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 11");

    PartSurface partSurface_133 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 12");

    PartSurface partSurface_134 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 13");

    PartSurface partSurface_135 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 14");

    PartSurface partSurface_136 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 15");

    PartSurface partSurface_137 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 16");

    PartSurface partSurface_138 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 17");

    PartSurface partSurface_139 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 18");

    PartSurface partSurface_140 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 19");

    PartSurface partSurface_141 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 20");

    PartSurface partSurface_142 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 21");

    PartSurface partSurface_143 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 22");

    PartSurface partSurface_144 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 23");

    PartSurface partSurface_145 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 24");

    PartSurface partSurface_146 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 25");

    PartSurface partSurface_147 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 26");

    PartSurface partSurface_148 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 27");

    PartSurface partSurface_149 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 28");

    PartSurface partSurface_150 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 29");

    PartSurface partSurface_151 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 30");

    PartSurface partSurface_152 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 31");

    PartSurface partSurface_153 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 32");

    PartSurface partSurface_154 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 33");

    PartSurface partSurface_155 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 34");

    PartSurface partSurface_156 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 35");

    PartSurface partSurface_157 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 36");

    PartSurface partSurface_158 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 37");

    PartSurface partSurface_159 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 38");

    PartSurface partSurface_160 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 39");

    PartSurface partSurface_161 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 40");

    PartSurface partSurface_162 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 41");

    PartSurface partSurface_163 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 42");

    PartSurface partSurface_164 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 43");

    PartSurface partSurface_165 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 44");

    PartSurface partSurface_166 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 45");

    PartSurface partSurface_168 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 47");

    PartSurface partSurface_169 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 48");

    PartSurface partSurface_170 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 49");

    PartSurface partSurface_171 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 50");

    PartSurface partSurface_172 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 51");

    PartSurface partSurface_173 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 52");

    PartSurface partSurface_174 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 53");

    PartSurface partSurface_175 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 54");

    PartSurface partSurface_176 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 55");

    PartSurface partSurface_177 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 56");

    PartSurface partSurface_178 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 57");

    PartSurface partSurface_179 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 58");

    PartSurface partSurface_180 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 59");

    PartSurface partSurface_181 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 60");

    PartSurface partSurface_182 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 61");

    PartSurface partSurface_183 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 62");

    PartSurface partSurface_184 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 63");

    PartSurface partSurface_185 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 64");

    PartSurface partSurface_186 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 65");

    PartSurface partSurface_187 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 66");

    PartSurface partSurface_188 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 67");

    PartSurface partSurface_189 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 68");

    PartSurface partSurface_190 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 69");

    PartSurface partSurface_191 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 70");

    PartSurface partSurface_192 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 71");

    PartSurface partSurface_193 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 72");

    PartSurface partSurface_194 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 73");

    PartSurface partSurface_195 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 74");

    PartSurface partSurface_196 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 75");

    PartSurface partSurface_197 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 76");

    PartSurface partSurface_198 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 77");

    PartSurface partSurface_199 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 78");

    PartSurface partSurface_200 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 79");

    PartSurface partSurface_201 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 80");

    PartSurface partSurface_202 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 81");

    PartSurface partSurface_203 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 82");

    PartSurface partSurface_204 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 83");

    PartSurface partSurface_205 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 84");

    PartSurface partSurface_206 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 85");

    PartSurface partSurface_207 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 86");

    PartSurface partSurface_208 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 87");

    PartSurface partSurface_209 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 88");

    PartSurface partSurface_210 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 89");

    PartSurface partSurface_211 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 90");

    PartSurface partSurface_212 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 91");

    PartSurface partSurface_213 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 92");

    PartSurface partSurface_214 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 93");

    PartSurface partSurface_215 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 94");

    PartSurface partSurface_216 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 95");

    PartSurface partSurface_217 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 96");

    PartSurface partSurface_218 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 97");

    PartSurface partSurface_219 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 98");

    PartSurface partSurface_220 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 99");

    PartSurface partSurface_221 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 100");

    PartSurface partSurface_222 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 101");

    PartSurface partSurface_223 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 102");

    PartSurface partSurface_224 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 103");

    PartSurface partSurface_225 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 104");

    PartSurface partSurface_226 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 105");

    PartSurface partSurface_227 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 106");

    PartSurface partSurface_228 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 107");

    PartSurface partSurface_229 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 108");

    PartSurface partSurface_230 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 109");

    PartSurface partSurface_231 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 110");

    PartSurface partSurface_232 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 111");

    PartSurface partSurface_233 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 112");

    partDisplayer_0.getHiddenParts().addObjects(partSurface_37, partSurface_60, partSurface_102, partSurface_123, partSurface_124, partSurface_125, partSurface_126, partSurface_127, partSurface_128, partSurface_129, partSurface_130, partSurface_131, partSurface_132, partSurface_133, partSurface_134, partSurface_135, partSurface_136, partSurface_137, partSurface_138, partSurface_139, partSurface_140, partSurface_141, partSurface_142, partSurface_143, partSurface_144, partSurface_145, partSurface_146, partSurface_147, partSurface_148, partSurface_149, partSurface_150, partSurface_151, partSurface_152, partSurface_153, partSurface_154, partSurface_155, partSurface_156, partSurface_157, partSurface_158, partSurface_159, partSurface_160, partSurface_161, partSurface_162, partSurface_163, partSurface_164, partSurface_165, partSurface_166, partSurface_168, partSurface_169, partSurface_170, partSurface_171, partSurface_172, partSurface_173, partSurface_174, partSurface_175, partSurface_176, partSurface_177, partSurface_178, partSurface_179, partSurface_180, partSurface_181, partSurface_182, partSurface_183, partSurface_184, partSurface_185, partSurface_186, partSurface_187, partSurface_188, partSurface_189, partSurface_190, partSurface_191, partSurface_192, partSurface_193, partSurface_194, partSurface_195, partSurface_196, partSurface_197, partSurface_198, partSurface_199, partSurface_200, partSurface_201, partSurface_202, partSurface_203, partSurface_204, partSurface_205, partSurface_206, partSurface_207, partSurface_208, partSurface_209, partSurface_210, partSurface_211, partSurface_212, partSurface_213, partSurface_214, partSurface_215, partSurface_216, partSurface_217, partSurface_218, partSurface_219, partSurface_220, partSurface_221, partSurface_222, partSurface_223, partSurface_224, partSurface_225, partSurface_226, partSurface_227, partSurface_228, partSurface_229, partSurface_230, partSurface_231, partSurface_232, partSurface_233);

    PartDisplayer partDisplayer_2 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getDisplayer("Geometry 1"));

    partDisplayer_2.getHiddenParts().addObjects(partSurface_37, partSurface_60, partSurface_102, partSurface_123, partSurface_124, partSurface_125, partSurface_126, partSurface_127, partSurface_128, partSurface_129, partSurface_130, partSurface_131, partSurface_132, partSurface_133, partSurface_134, partSurface_135, partSurface_136, partSurface_137, partSurface_138, partSurface_139, partSurface_140, partSurface_141, partSurface_142, partSurface_143, partSurface_144, partSurface_145, partSurface_146, partSurface_147, partSurface_148, partSurface_149, partSurface_150, partSurface_151, partSurface_152, partSurface_153, partSurface_154, partSurface_155, partSurface_156, partSurface_157, partSurface_158, partSurface_159, partSurface_160, partSurface_161, partSurface_162, partSurface_163, partSurface_164, partSurface_165, partSurface_166, partSurface_168, partSurface_169, partSurface_170, partSurface_171, partSurface_172, partSurface_173, partSurface_174, partSurface_175, partSurface_176, partSurface_177, partSurface_178, partSurface_179, partSurface_180, partSurface_181, partSurface_182, partSurface_183, partSurface_184, partSurface_185, partSurface_186, partSurface_187, partSurface_188, partSurface_189, partSurface_190, partSurface_191, partSurface_192, partSurface_193, partSurface_194, partSurface_195, partSurface_196, partSurface_197, partSurface_198, partSurface_199, partSurface_200, partSurface_201, partSurface_202, partSurface_203, partSurface_204, partSurface_205, partSurface_206, partSurface_207, partSurface_208, partSurface_209, partSurface_210, partSurface_211, partSurface_212, partSurface_213, partSurface_214, partSurface_215, partSurface_216, partSurface_217, partSurface_218, partSurface_219, partSurface_220, partSurface_221, partSurface_222, partSurface_223, partSurface_224, partSurface_225, partSurface_226, partSurface_227, partSurface_228, partSurface_229, partSurface_230, partSurface_231, partSurface_232, partSurface_233);

    PartSurface partSurface_122 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces");

    PartSurface partSurface_167 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces 46");

    partDisplayer_3.getParts().setObjects(partSurface_122, partSurface_123, partSurface_124, partSurface_125, partSurface_126, partSurface_127, partSurface_128, partSurface_129, partSurface_130, partSurface_131, partSurface_132, partSurface_133, partSurface_134, partSurface_135, partSurface_136, partSurface_137, partSurface_138, partSurface_139, partSurface_140, partSurface_141, partSurface_142, partSurface_143, partSurface_144, partSurface_145, partSurface_146, partSurface_147, partSurface_148, partSurface_149, partSurface_150, partSurface_151, partSurface_152, partSurface_153, partSurface_154, partSurface_155, partSurface_156, partSurface_157, partSurface_158, partSurface_159, partSurface_160, partSurface_161, partSurface_162, partSurface_163, partSurface_164, partSurface_165, partSurface_166, partSurface_167, partSurface_168, partSurface_169, partSurface_170, partSurface_171, partSurface_172, partSurface_173, partSurface_174, partSurface_175, partSurface_176, partSurface_177, partSurface_178, partSurface_179, partSurface_180, partSurface_181, partSurface_182, partSurface_183, partSurface_184, partSurface_185, partSurface_186, partSurface_187, partSurface_188, partSurface_189, partSurface_190, partSurface_191, partSurface_192, partSurface_193, partSurface_194, partSurface_195, partSurface_196, partSurface_197, partSurface_198, partSurface_199, partSurface_200, partSurface_201, partSurface_202, partSurface_203, partSurface_204, partSurface_205, partSurface_206, partSurface_207, partSurface_208, partSurface_209, partSurface_210, partSurface_211, partSurface_212, partSurface_213, partSurface_214, partSurface_215, partSurface_216, partSurface_217, partSurface_218, partSurface_219, partSurface_220, partSurface_221, partSurface_222, partSurface_223, partSurface_224, partSurface_225, partSurface_226, partSurface_227, partSurface_228, partSurface_229, partSurface_230, partSurface_231, partSurface_232, partSurface_233);

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    partDisplayer_3.getParts().setObjects();

    PartCurve partCurve_1 = 
      ((PartCurve) cadPart_5.getPartCurveManager().getObject("Edges"));

    partDisplayer_2.getParts().setObjects(partSurface_187, partSurface_162, partSurface_189, partSurface_127, partSurface_122, partSurface_211, partSurface_217, partSurface_212, partSurface_152, partSurface_196, partSurface_139, partSurface_141, partSurface_150, partSurface_184, partSurface_161, partSurface_171, partSurface_142, partSurface_148, partSurface_170, partSurface_210, partSurface_166, partSurface_165, partSurface_135, partSurface_227, partSurface_151, partSurface_194, partSurface_169, partSurface_220, partSurface_182, partSurface_201, partSurface_128, partSurface_177, partSurface_185, partSurface_231, partSurface_183, partSurface_173, partSurface_124, partSurface_204, partSurface_188, partSurface_230, partSurface_144, partSurface_232, partSurface_222, partSurface_131, partSurface_157, partSurface_179, partSurface_175, partSurface_146, partSurface_130, partSurface_138, partSurface_208, partSurface_178, partSurface_176, partSurface_191, partSurface_218, partSurface_197, partSurface_180, partSurface_158, partSurface_154, partSurface_140, partSurface_203, partSurface_133, partSurface_199, partSurface_223, partSurface_134, partSurface_125, partSurface_192, partSurface_226, partSurface_145, partSurface_136, partSurface_216, partSurface_229, partSurface_205, partSurface_214, partSurface_164, partSurface_163, partSurface_174, partSurface_172, partSurface_225, partSurface_123, partSurface_193, partSurface_181, partSurface_228, partSurface_129, partSurface_202, partSurface_221, partSurface_233, partCurve_1, partSurface_198, partSurface_186, partSurface_168, partSurface_224, partSurface_219, partSurface_155, partSurface_156, partSurface_143, partSurface_207, partSurface_190, partSurface_160, partSurface_200, partSurface_206, partSurface_167, partSurface_149, partSurface_132, partSurface_195, partSurface_213, partSurface_209, partSurface_153, partSurface_126, partSurface_147, partSurface_215, partSurface_159, partSurface_137);

    currentView_0.setInput(new DoubleVector(new double[] {-0.001052917001614194, -0.002436648331308836, -0.009215217161253618}), new DoubleVector(new double[] {0.028749575124021758, -0.02572764167481302, -0.02130670997644891}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.01036632117998475, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.00562317796839339, 0.004555769028809633, -0.005967774208528743}), new DoubleVector(new double[] {0.023657337934351104, -0.01832729384090794, -0.017847490380274618}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.010184760082610825, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.004906652182715784, 0.0053640779721451405, -0.005701206576179429}), new DoubleVector(new double[] {0.021620443058482843, -0.015367154707345905, -0.0164638025418049}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.009227026655457661, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.0036455969027427496, 0.006841456524416957, -0.005209744246212872}), new DoubleVector(new double[] {0.01795403228191997, -0.010038904266934243, -0.013973164432559408}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.007513086239663184, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.00349682162894637, 0.006050615803254098, -0.0031317793899948423}), new DoubleVector(new double[] {0.018145754789507307, -0.010863308749547999, -0.011912624165084717}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.007528024749415729, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.00349682162894637, 0.006050615803254098, -0.0031317793899948423}), new DoubleVector(new double[] {0.018145754789507307, -0.010863308749547999, -0.011912624165084717}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.007528024749415729, 0);

    partDisplayer_3.getParts().setObjects(partSurface_172);

    currentView_0.setInput(new DoubleVector(new double[] {-0.00349682162894637, 0.006050615803254098, -0.0031317793899948423}), new DoubleVector(new double[] {0.018145754789507307, -0.010863308749547999, -0.011912624165084717}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.007528024749415729, 0);

    partDisplayer_3.getParts().setObjects(partSurface_172, partCurve_1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.00349682162894637, 0.006050615803254098, -0.0031317793899948423}), new DoubleVector(new double[] {0.018145754789507307, -0.010863308749547999, -0.011912624165084717}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.007528024749415729, 0);

    partDisplayer_3.getParts().setObjects(partSurface_172);

    currentView_0.setInput(new DoubleVector(new double[] {-0.00349682162894637, 0.006050615803254098, -0.0031317793899948423}), new DoubleVector(new double[] {0.018145754789507307, -0.010863308749547999, -0.011912624165084717}), new DoubleVector(new double[] {0.3298315157333504, -0.06682478526538739, 0.9416717152507424}), 0.007528024749415729, 0);

    partDisplayer_3.getParts().setObjects(partSurface_172, partCurve_1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002316050994246515, 0.004949062949244636, -0.00410543992175922}), new DoubleVector(new double[] {0.007622251385537739, -0.009787890861263783, -0.02742176565347302}), new DoubleVector(new double[] {0.6968610028727868, -0.4337509627199796, 0.5711784703703602}), 0.007653772361227646, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002316050994246515, 0.004949062949244636, -0.00410543992175922}), new DoubleVector(new double[] {0.007622251385537739, -0.009787890861263783, -0.02742176565347302}), new DoubleVector(new double[] {0.6968610028727868, -0.4337509627199796, 0.5711784703703602}), 0.007653772361227646, 0);

    partDisplayer_3.getParts().setObjects();

    currentView_0.setInput(new DoubleVector(new double[] {-0.002379307864679516, 0.005435013838240431, -0.0023691464670710463}), new DoubleVector(new double[] {0.008117118270208824, -0.010129550532422323, -0.026994890525508835}), new DoubleVector(new double[] {0.6968610028727868, -0.4337509627199796, 0.5711784703703602}), 0.008083599509539163, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002379307864679516, 0.005435013838240431, -0.0023691464670710463}), new DoubleVector(new double[] {0.008117118270208824, -0.010129550532422323, -0.026994890525508835}), new DoubleVector(new double[] {0.6968610028727868, -0.4337509627199796, 0.5711784703703602}), 0.008083599509539163, 0);

    partDisplayer_3.getParts().setObjects(partSurface_198);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002379307864679516, 0.005435013838240431, -0.0023691464670710463}), new DoubleVector(new double[] {0.008117118270208824, -0.010129550532422323, -0.026994890525508835}), new DoubleVector(new double[] {0.6968610028727868, -0.4337509627199796, 0.5711784703703602}), 0.008083599509539163, 0);

    partDisplayer_3.getParts().setObjects(partSurface_198, partSurface_188);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002379307864679516, 0.005435013838240431, -0.0023691464670710463}), new DoubleVector(new double[] {0.008117118270208824, -0.010129550532422323, -0.026994890525508835}), new DoubleVector(new double[] {0.6968610028727868, -0.4337509627199796, 0.5711784703703602}), 0.008083599509539163, 0);

    partDisplayer_3.getParts().setObjects(partSurface_198, partSurface_188, partSurface_122);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002379307864679516, 0.005435013838240431, -0.0023691464670710463}), new DoubleVector(new double[] {0.008117118270208824, -0.010129550532422323, -0.026994890525508835}), new DoubleVector(new double[] {0.6968610028727868, -0.4337509627199796, 0.5711784703703602}), 0.008083599509539163, 0);

    partDisplayer_3.getParts().setObjects(partSurface_198, partSurface_188, partSurface_122, partCurve_1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002379307864679516, 0.005435013838240431, -0.0023691464670710463}), new DoubleVector(new double[] {0.008117118270208824, -0.010129550532422323, -0.026994890525508835}), new DoubleVector(new double[] {0.6968610028727868, -0.4337509627199796, 0.5711784703703602}), 0.008083599509539163, 0);

    partDisplayer_3.getParts().setObjects();

    currentView_0.setInput(new DoubleVector(new double[] {-0.002379307864679516, 0.005435013838240431, -0.0023691464670710463}), new DoubleVector(new double[] {0.008117118270208824, -0.010129550532422323, -0.026994890525508835}), new DoubleVector(new double[] {0.6968610028727868, -0.4337509627199796, 0.5711784703703602}), 0.008083599509539163, 0);

    partDisplayer_3.getParts().setObjects(partSurface_202);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002379307864679516, 0.005435013838240431, -0.0023691464670710463}), new DoubleVector(new double[] {0.008117118270208824, -0.010129550532422323, -0.026994890525508835}), new DoubleVector(new double[] {0.6968610028727868, -0.4337509627199796, 0.5711784703703602}), 0.008083599509539163, 0);

    partDisplayer_3.getParts().setObjects(partSurface_202, partSurface_192);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002379307864679516, 0.005435013838240431, -0.0023691464670710463}), new DoubleVector(new double[] {0.008117118270208824, -0.010129550532422323, -0.026994890525508835}), new DoubleVector(new double[] {0.6968610028727868, -0.4337509627199796, 0.5711784703703602}), 0.008083599509539163, 0);

    partDisplayer_3.getParts().setObjects(partSurface_202, partSurface_192, partSurface_133);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002379307864679516, 0.005435013838240431, -0.0023691464670710463}), new DoubleVector(new double[] {0.008117118270208824, -0.010129550532422323, -0.026994890525508835}), new DoubleVector(new double[] {0.6968610028727868, -0.4337509627199796, 0.5711784703703602}), 0.008083599509539163, 0);

    partDisplayer_3.getParts().setObjects(partSurface_202, partSurface_192, partSurface_133, partSurface_176);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002379307864679516, 0.005435013838240431, -0.0023691464670710463}), new DoubleVector(new double[] {0.008117118270208824, -0.010129550532422323, -0.026994890525508835}), new DoubleVector(new double[] {0.6968610028727868, -0.4337509627199796, 0.5711784703703602}), 0.008083599509539163, 0);

    partDisplayer_3.getParts().setObjects(partSurface_202, partSurface_192, partSurface_133, partSurface_176, partSurface_198);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002379307864679516, 0.005435013838240431, -0.0023691464670710463}), new DoubleVector(new double[] {0.008117118270208824, -0.010129550532422323, -0.026994890525508835}), new DoubleVector(new double[] {0.6968610028727868, -0.4337509627199796, 0.5711784703703602}), 0.008083599509539163, 0);

    partDisplayer_3.getParts().setObjects(partSurface_202, partSurface_192, partSurface_133, partSurface_176, partSurface_198, partSurface_188);

    currentView_0.setInput(new DoubleVector(new double[] {-0.002379307864679516, 0.005435013838240431, -0.0023691464670710463}), new DoubleVector(new double[] {0.008117118270208824, -0.010129550532422323, -0.026994890525508835}), new DoubleVector(new double[] {0.6968610028727868, -0.4337509627199796, 0.5711784703703602}), 0.008083599509539163, 0);

    partDisplayer_3.getParts().setObjects(partSurface_202, partSurface_192, partSurface_133, partSurface_176, partSurface_198, partSurface_188, partSurface_122);

    currentView_0.setInput(new DoubleVector(new double[] {-5.084587016038248E-4, 0.0026006570557514565, -0.006875449856094875}), new DoubleVector(new double[] {0.013788009046641144, -0.010251031239479005, -0.024174323214771937}), new DoubleVector(new double[] {0.5978074263754392, -0.32272323632141947, 0.7338092352298404}), 0.006751149305089838, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.00113686836074977, 0.0018509187741739097, -0.0045447551253049905}), new DoubleVector(new double[] {0.015586402408507932, -0.011138367171363524, -0.022028840284364363}), new DoubleVector(new double[] {0.5978074263754392, -0.32272323632141947, 0.7338092352298404}), 0.006823431036478909, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.00113686836074977, 0.0018509187741739097, -0.0045447551253049905}), new DoubleVector(new double[] {0.015586402408507932, -0.011138367171363524, -0.022028840284364363}), new DoubleVector(new double[] {0.5978074263754392, -0.32272323632141947, 0.7338092352298404}), 0.006823431036478909, 0);

    partDisplayer_3.getParts().setObjects(partSurface_202, partSurface_192, partSurface_133, partSurface_176, partSurface_198, partSurface_188, partSurface_122, partSurface_172);

    currentView_0.setInput(new DoubleVector(new double[] {0.00113686836074977, 0.0018509187741739097, -0.0045447551253049905}), new DoubleVector(new double[] {0.015586402408507932, -0.011138367171363524, -0.022028840284364363}), new DoubleVector(new double[] {0.5978074263754392, -0.32272323632141947, 0.7338092352298404}), 0.006823431036478909, 0);

    cadPart_5.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_202, partSurface_192, partSurface_133, partSurface_176, partSurface_198, partSurface_188, partSurface_122, partSurface_172}));

    partDisplayer_3.getParts().setObjects(partSurface_202);

    currentView_0.setInput(new DoubleVector(new double[] {0.00113686836074977, 0.0018509187741739097, -0.0045447551253049905}), new DoubleVector(new double[] {0.015586402408507932, -0.011138367171363524, -0.022028840284364363}), new DoubleVector(new double[] {0.5978074263754392, -0.32272323632141947, 0.7338092352298404}), 0.006823431036478909, 0);

    partSurface_202.setPresentationName("int0");

    currentView_0.setInput(new DoubleVector(new double[] {0.001490101380932662, 0.0013119715270662026, -0.0020932959782277724}), new DoubleVector(new double[] {0.016590134251365032, -0.012262074811922232, -0.020364491418761472}), new DoubleVector(new double[] {0.5978074263754392, -0.32272323632141947, 0.7338092352298404}), 0.007130612834947825, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.00601881890922818, -0.00203265399486152, -0.0029446755442094556}), new DoubleVector(new double[] {0.02469451448654967, -0.012285309028037202, 0.01609966693964366}), new DoubleVector(new double[] {-0.5001725229915881, 0.45613078192919376, 0.7360517352882823}), 0.007459822638390688, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.005259730983338873, 0.001602623752375236, -0.0031858842521198896}), new DoubleVector(new double[] {0.025217119894124437, -0.009353660205994827, 0.017165451414434377}), new DoubleVector(new double[] {-0.5001725229915881, 0.45613078192919376, 0.7360517352882823}), 0.007971782415463743, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.005259730983338873, 0.001602623752375236, -0.0031858842521198896}), new DoubleVector(new double[] {0.025217119894124437, -0.009353660205994827, 0.017165451414434377}), new DoubleVector(new double[] {-0.5001725229915881, 0.45613078192919376, 0.7360517352882823}), 0.007971782415463743, 0);

    partDisplayer_3.getParts().setObjects(partSurface_158);

    currentView_0.setInput(new DoubleVector(new double[] {0.005259730983338873, 0.001602623752375236, -0.0031858842521198896}), new DoubleVector(new double[] {0.025217119894124437, -0.009353660205994827, 0.017165451414434377}), new DoubleVector(new double[] {-0.5001725229915881, 0.45613078192919376, 0.7360517352882823}), 0.007971782415463743, 0);

    partDisplayer_3.getParts().setObjects(partSurface_158, partSurface_218);

    currentView_0.setInput(new DoubleVector(new double[] {0.005259730983338873, 0.001602623752375236, -0.0031858842521198896}), new DoubleVector(new double[] {0.025217119894124437, -0.009353660205994827, 0.017165451414434377}), new DoubleVector(new double[] {-0.5001725229915881, 0.45613078192919376, 0.7360517352882823}), 0.007971782415463743, 0);

    partDisplayer_3.getParts().setObjects(partSurface_158, partSurface_218, partCurve_1);

    currentView_0.setInput(new DoubleVector(new double[] {0.005259730983338873, 0.001602623752375236, -0.0031858842521198896}), new DoubleVector(new double[] {0.025217119894124437, -0.009353660205994827, 0.017165451414434377}), new DoubleVector(new double[] {-0.5001725229915881, 0.45613078192919376, 0.7360517352882823}), 0.007971782415463743, 0);

    partDisplayer_3.getParts().setObjects();

    currentView_0.setInput(new DoubleVector(new double[] {1.2274516550453765E-4, 0.004711944088550456, -0.005168181655142129}), new DoubleVector(new double[] {0.016963736733576727, -0.004533488096247909, 0.012005240874807283}), new DoubleVector(new double[] {-0.5001725229915881, 0.45613078192919376, 0.7360517352882823}), 0.006726968194159755, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-4.336973596764781E-4, 0.005171280081520929, -0.00350303010155688}), new DoubleVector(new double[] {0.011235289995464932, -0.0012348053809147761, 0.00839629598838664}), new DoubleVector(new double[] {-0.5001725229915881, 0.45613078192919376, 0.7360517352882823}), 0.0046610620567559755, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-4.336973596764781E-4, 0.005171280081520929, -0.00350303010155688}), new DoubleVector(new double[] {0.011235289995464932, -0.0012348053809147761, 0.00839629598838664}), new DoubleVector(new double[] {-0.5001725229915881, 0.45613078192919376, 0.7360517352882823}), 0.0046610620567559755, 0);

    partDisplayer_3.getParts().setObjects(partSurface_158);

    currentView_0.setInput(new DoubleVector(new double[] {-4.336973596764781E-4, 0.005171280081520929, -0.00350303010155688}), new DoubleVector(new double[] {0.011235289995464932, -0.0012348053809147761, 0.00839629598838664}), new DoubleVector(new double[] {-0.5001725229915881, 0.45613078192919376, 0.7360517352882823}), 0.0046610620567559755, 0);

    partDisplayer_3.getParts().setObjects(partSurface_158, partSurface_218);

    currentView_0.setInput(new DoubleVector(new double[] {-4.336973596764781E-4, 0.005171280081520929, -0.00350303010155688}), new DoubleVector(new double[] {0.011235289995464932, -0.0012348053809147761, 0.00839629598838664}), new DoubleVector(new double[] {-0.5001725229915881, 0.45613078192919376, 0.7360517352882823}), 0.0046610620567559755, 0);

    partDisplayer_3.getParts().setObjects(partSurface_158, partSurface_218, partSurface_224);

    currentView_0.setInput(new DoubleVector(new double[] {-4.336973596764781E-4, 0.005171280081520929, -0.00350303010155688}), new DoubleVector(new double[] {0.011235289995464932, -0.0012348053809147761, 0.00839629598838664}), new DoubleVector(new double[] {-0.5001725229915881, 0.45613078192919376, 0.7360517352882823}), 0.0046610620567559755, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-4.336973596764781E-4, 0.005171280081520929, -0.00350303010155688}), new DoubleVector(new double[] {0.011235289995464932, -0.0012348053809147761, 0.00839629598838664}), new DoubleVector(new double[] {-0.5001725229915881, 0.45613078192919376, 0.7360517352882823}), 0.0046610620567559755, 0);

    partDisplayer_3.getParts().setObjects(partSurface_158, partSurface_218, partSurface_224, partSurface_232);

    currentView_0.setInput(new DoubleVector(new double[] {-4.336973596764781E-4, 0.005171280081520929, -0.00350303010155688}), new DoubleVector(new double[] {0.011235289995464932, -0.0012348053809147761, 0.00839629598838664}), new DoubleVector(new double[] {-0.5001725229915881, 0.45613078192919376, 0.7360517352882823}), 0.0046610620567559755, 0);

    cadPart_5.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_158, partSurface_218, partSurface_224, partSurface_232}));

    partDisplayer_3.getParts().setObjects(partSurface_158);

    currentView_0.setInput(new DoubleVector(new double[] {-4.336973596764781E-4, 0.005171280081520929, -0.00350303010155688}), new DoubleVector(new double[] {0.011235289995464932, -0.0012348053809147761, 0.00839629598838664}), new DoubleVector(new double[] {-0.5001725229915881, 0.45613078192919376, 0.7360517352882823}), 0.0046610620567559755, 0);

    partSurface_158.setPresentationName("int1");

    partDisplayer_3.getParts().setObjects(partSurface_123);

    partDisplayer_3.getParts().setObjects(partSurface_187, partSurface_162, partSurface_189, partSurface_127, partSurface_211, partSurface_217, partSurface_212, partSurface_152, partSurface_139, partSurface_196, partSurface_141, partSurface_150, partSurface_161, partSurface_184, partSurface_171, partSurface_142, partSurface_148, partSurface_170, partSurface_210, partSurface_166, partSurface_165, partSurface_135, partSurface_227, partSurface_151, partSurface_169, partSurface_194, partSurface_182, partSurface_220, partSurface_201, partSurface_128, partSurface_177, partSurface_185, partSurface_231, partSurface_183, partSurface_173, partSurface_124, partSurface_204, partSurface_230, partSurface_144, partSurface_222, partSurface_131, partSurface_157, partSurface_179, partSurface_175, partSurface_130, partSurface_146, partSurface_138, partSurface_208, partSurface_178, partSurface_191, partSurface_197, partSurface_180, partSurface_158, partSurface_154, partSurface_140, partSurface_203, partSurface_199, partSurface_223, partSurface_134, partSurface_125, partSurface_226, partSurface_136, partSurface_145, partSurface_216, partSurface_229, partSurface_205, partSurface_164, partSurface_214, partSurface_163, partSurface_174, partSurface_225, partSurface_123, partSurface_193, partSurface_181, partSurface_228, partSurface_129, partSurface_221, partSurface_233, partSurface_168, partSurface_186, partSurface_155, partSurface_219, partSurface_156, partSurface_143, partSurface_207, partSurface_190, partSurface_160, partSurface_200, partSurface_206, partSurface_167, partSurface_149, partSurface_132, partSurface_195, partSurface_213, partSurface_209, partSurface_153, partSurface_126, partSurface_147, partSurface_215, partSurface_159, partSurface_137);

    partDisplayer_3.getParts().setObjects(partSurface_187, partSurface_162, partSurface_189, partSurface_127, partSurface_211, partSurface_217, partSurface_212, partSurface_152, partSurface_196, partSurface_139, partSurface_141, partSurface_150, partSurface_184, partSurface_161, partSurface_171, partSurface_142, partSurface_148, partSurface_170, partSurface_210, partSurface_166, partSurface_165, partSurface_135, partSurface_227, partSurface_151, partSurface_194, partSurface_169, partSurface_220, partSurface_182, partSurface_201, partSurface_128, partSurface_177, partSurface_185, partSurface_231, partSurface_183, partSurface_173, partSurface_124, partSurface_204, partSurface_230, partSurface_144, partSurface_222, partSurface_131, partSurface_157, partSurface_179, partSurface_175, partSurface_130, partSurface_146, partSurface_138, partSurface_208, partSurface_178, partSurface_191, partSurface_197, partSurface_180, partSurface_154, partSurface_140, partSurface_203, partSurface_199, partSurface_223, partSurface_134, partSurface_125, partSurface_226, partSurface_145, partSurface_136, partSurface_216, partSurface_205, partSurface_229, partSurface_164, partSurface_214, partSurface_163, partSurface_174, partSurface_225, partSurface_123, partSurface_193, partSurface_181, partSurface_228, partSurface_129, partSurface_221, partSurface_233, partSurface_168, partSurface_186, partSurface_219, partSurface_155, partSurface_156, partSurface_143, partSurface_207, partSurface_190, partSurface_160, partSurface_200, partSurface_206, partSurface_167, partSurface_149, partSurface_132, partSurface_195, partSurface_213, partSurface_209, partSurface_126, partSurface_153, partSurface_147, partSurface_215, partSurface_159, partSurface_137);

    cadPart_5.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_205, partSurface_223, partSurface_214, partSurface_126, partSurface_125, partSurface_193, partSurface_151, partSurface_220, partSurface_139, partSurface_181, partSurface_136, partSurface_168, partSurface_149, partSurface_167, partSurface_230, partSurface_177, partSurface_140, partSurface_227, partSurface_216, partSurface_207, partSurface_166, partSurface_183, partSurface_130, partSurface_132, partSurface_169, partSurface_161, partSurface_160, partSurface_143, partSurface_219, partSurface_194, partSurface_173, partSurface_134, partSurface_171, partSurface_199, partSurface_228, partSurface_163, partSurface_162, partSurface_150, partSurface_222, partSurface_196, partSurface_195, partSurface_137, partSurface_201, partSurface_197, partSurface_145, partSurface_200, partSurface_164, partSurface_184, partSurface_144, partSurface_142, partSurface_210, partSurface_131, partSurface_233, partSurface_127, partSurface_213, partSurface_135, partSurface_138, partSurface_174, partSurface_155, partSurface_178, partSurface_170, partSurface_209, partSurface_189, partSurface_231, partSurface_153, partSurface_152, partSurface_221, partSurface_148, partSurface_206, partSurface_179, partSurface_156, partSurface_211, partSurface_123, partSurface_225, partSurface_185, partSurface_165, partSurface_203, partSurface_180, partSurface_229, partSurface_175, partSurface_146, partSurface_190, partSurface_187, partSurface_182, partSurface_186, partSurface_215, partSurface_141, partSurface_191, partSurface_204, partSurface_129, partSurface_159, partSurface_128, partSurface_157, partSurface_124, partSurface_212, partSurface_147, partSurface_217, partSurface_154, partSurface_226, partSurface_208}));

    partDisplayer_3.getParts().setObjects(partSurface_205);

    partSurface_205.setPresentationName("wall");

    partDisplayer_3.getParts().setObjects(partSurface_158, partSurface_202, partSurface_205);

    CadPart cadPart_1 = 
      ((CadPart) compositePart_0.getChildParts().getPart("in1"));

    PartSurface partSurface_2 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("inlet");

    PartSurface partSurface_3 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("wall");

    PartSurface partSurface_4 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("int");

    CadPart cadPart_3 = 
      ((CadPart) compositePart_0.getChildParts().getPart("out1"));

    PartSurface partSurface_118 = 
      cadPart_3.getPartSurfaceManager().getPartSurface("wall");

    PartSurface partSurface_119 = 
      cadPart_3.getPartSurfaceManager().getPartSurface("int1");

    PartSurface partSurface_120 = 
      cadPart_3.getPartSurfaceManager().getPartSurface("int0");

    CadPart cadPart_2 = 
      ((CadPart) compositePart_0.getChildParts().getPart("out2"));

    PartSurface partSurface_5 = 
      cadPart_2.getPartSurfaceManager().getPartSurface("int");

    PartSurface partSurface_6 = 
      cadPart_2.getPartSurfaceManager().getPartSurface("wall");

    PartSurface partSurface_7 = 
      cadPart_2.getPartSurfaceManager().getPartSurface("outlet");

    CadPart cadPart_4 = 
      ((CadPart) compositePart_0.getChildParts().getPart("duct"));

    PartSurface partSurface_121 = 
      cadPart_4.getPartSurfaceManager().getPartSurface("wall");

    partDisplayer_3.getParts().setObjects(partSurface_2, partSurface_3, partSurface_4, partSurface_118, partSurface_119, partSurface_120, partSurface_5, partSurface_6, partSurface_7, partSurface_121, partSurface_37, partSurface_60, partSurface_102, partSurface_158, partSurface_202, partSurface_205);

    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {cadPart_1, cadPart_2, cadPart_0, cadPart_3, cadPart_4, cadPart_5}), "OneRegionPerPart", null, "OneBoundaryPerPartSurface", null, "OneFeatureCurvePerPartCurve", null, true);

    partDisplayer_3.getParts().setObjects();

    MeshContinuum meshContinuum_0 = 
      simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);

    meshContinuum_0.enable(ResurfacerMeshingModel.class);

    meshContinuum_0.enable(TrimmerMeshingModel.class);

    SurfaceProximity surfaceProximity_0 = 
      meshContinuum_0.getReferenceValues().get(SurfaceProximity.class);

    surfaceProximity_0.setNumPointsInGap(5.0);

    MeshPipelineController meshPipelineController_0 = 
      simulation_0.get(MeshPipelineController.class);

    meshPipelineController_0.generateVolumeMesh();

    currentView_0.setInput(new DoubleVector(new double[] {-0.001099805590709024, 0.005581353670406059, -0.004134993313983312}), new DoubleVector(new double[] {0.011386250321176579, -0.0021103045366226924, 0.0077057833037724}), new DoubleVector(new double[] {-0.46389481375855174, 0.43499072921861426, 0.7717413214683904}), 0.004920454433458746, 0);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Assembly 1.duct");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("wall");

    partDisplayer_3.getParts().setObjects(boundary_0);

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("Assembly 1.in0");

    Boundary boundary_1 = 
      region_1.getBoundaryManager().getBoundary("int1");

    Boundary boundary_2 = 
      region_1.getBoundaryManager().getBoundary("int0");

    Boundary boundary_3 = 
      region_1.getBoundaryManager().getBoundary("wall");

    partDisplayer_3.getParts().setObjects(boundary_1, boundary_2, boundary_3);

    Region region_2 = 
      simulation_0.getRegionManager().getRegion("Assembly 1.in1");

    Boundary boundary_4 = 
      region_2.getBoundaryManager().getBoundary("inlet");

    Boundary boundary_5 = 
      region_2.getBoundaryManager().getBoundary("wall");

    Boundary boundary_6 = 
      region_2.getBoundaryManager().getBoundary("int");

    partDisplayer_3.getParts().setObjects(boundary_4, boundary_5, boundary_6);

    Region region_3 = 
      simulation_0.getRegionManager().getRegion("Assembly 1.out0");

    Boundary boundary_7 = 
      region_3.getBoundaryManager().getBoundary("wall");

    Boundary boundary_8 = 
      region_3.getBoundaryManager().getBoundary("int0");

    Boundary boundary_9 = 
      region_3.getBoundaryManager().getBoundary("int1");

    partDisplayer_3.getParts().setObjects(boundary_7, boundary_8, boundary_9);

    Region region_4 = 
      simulation_0.getRegionManager().getRegion("Assembly 1.out1");

    Boundary boundary_10 = 
      region_4.getBoundaryManager().getBoundary("wall");

    Boundary boundary_11 = 
      region_4.getBoundaryManager().getBoundary("int1");

    Boundary boundary_12 = 
      region_4.getBoundaryManager().getBoundary("int0");

    DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_0 = 
      ((DirectBoundaryInterfaceBoundary) region_4.getBoundaryManager().getBoundary("int1 [out1/out2]"));

    partDisplayer_3.getParts().setObjects(boundary_10, boundary_11, boundary_12, directBoundaryInterfaceBoundary_0);

    Region region_5 = 
      simulation_0.getRegionManager().getRegion("Assembly 1.out2");

    Boundary boundary_13 = 
      region_5.getBoundaryManager().getBoundary("int");

    Boundary boundary_14 = 
      region_5.getBoundaryManager().getBoundary("wall");

    Boundary boundary_15 = 
      region_5.getBoundaryManager().getBoundary("outlet");

    DirectBoundaryInterfaceBoundary directBoundaryInterfaceBoundary_1 = 
      ((DirectBoundaryInterfaceBoundary) region_5.getBoundaryManager().getBoundary("int [out1/out2]"));

    partDisplayer_3.getParts().setObjects(boundary_13, boundary_14, boundary_15, directBoundaryInterfaceBoundary_1);

    currentView_0.setInput(new DoubleVector(new double[] {-0.001099805590709024, 0.005581353670406059, -0.004134993313983312}), new DoubleVector(new double[] {0.011386250321176579, -0.0021103045366226924, 0.0077057833037724}), new DoubleVector(new double[] {-0.46389481375855174, 0.43499072921861426, 0.7717413214683904}), 0.004920454433458746, 0);

    partDisplayer_2.setSurface(false);

    partDisplayer_2.setOutline(true);

    currentView_0.setInput(new DoubleVector(new double[] {-0.001099805590709024, 0.005581353670406059, -0.004134993313983312}), new DoubleVector(new double[] {0.011386250321176579, -0.0021103045366226924, 0.0077057833037724}), new DoubleVector(new double[] {-0.46389481375855174, 0.43499072921861426, 0.7717413214683904}), 0.004920454433458746, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.001099805590709024, 0.005581353670406059, -0.004134993313983312}), new DoubleVector(new double[] {0.011386250321176579, -0.0021103045366226924, 0.0077057833037724}), new DoubleVector(new double[] {-0.46389481375855174, 0.43499072921861426, 0.7717413214683904}), 0.004920454433458746, 0);

    partDisplayer_3.getParts().setObjects();

    partDisplayer_3.getParts().setObjects(boundary_0);

    meshContinuum_0.erase(region_0);

    partDisplayer_3.getParts().setObjects(boundary_4, boundary_5, boundary_6);

    meshContinuum_0.erase(region_2);

    partDisplayer_3.getParts().setObjects(boundary_7, boundary_8, boundary_9);

    meshContinuum_0.erase(region_3);

    partDisplayer_3.getParts().setObjects(boundary_10, boundary_11, boundary_12, directBoundaryInterfaceBoundary_0);

    meshContinuum_0.erase(region_4);

    partDisplayer_3.getParts().setObjects(boundary_13, boundary_14, boundary_15, directBoundaryInterfaceBoundary_1);

    meshContinuum_0.erase(region_5);

    partDisplayer_3.getParts().setObjects(boundary_0);

    partDisplayer_3.getParts().setObjects(boundary_1, boundary_2, boundary_3);

    partDisplayer_3.getParts().setObjects(boundary_4, boundary_5, boundary_6);

    partDisplayer_3.getParts().setObjects(boundary_7, boundary_8, boundary_9);

    partDisplayer_3.getParts().setObjects(boundary_10, boundary_11, boundary_12, directBoundaryInterfaceBoundary_0);

    partDisplayer_3.getParts().setObjects(boundary_13, boundary_14, boundary_15, directBoundaryInterfaceBoundary_1);

    meshPipelineController_0.generateVolumeMesh();

    partDisplayer_3.getParts().setObjects();

    partDisplayer_2.setMesh(true);

    partDisplayer_2.setOutline(false);

    partDisplayer_2.setSurface(true);

    FvRepresentation fvRepresentation_0 = 
      ((FvRepresentation) simulation_0.getRepresentationManager().getObject("Volume Mesh"));

    partDisplayer_2.setRepresentation(fvRepresentation_0);

    partDisplayer_3.getParts().setObjects(boundary_1, boundary_2, boundary_3);

    partDisplayer_3.getParts().setObjects();

    meshContinuum_0.getReferenceValues().get(BaseSize.class).setValue(0.0010);

    meshPipelineController_0.generateVolumeMesh();

    currentView_0.setInput(new DoubleVector(new double[] {-0.001870426025368351, 0.006103574783219138, -0.004834157738055983}), new DoubleVector(new double[] {0.011351189189762228, -0.0028695864743821073, 0.007152584044841739}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.005214587281738244, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.00161947741825513, 0.007423191716856285, -0.0064105532509051944}), new DoubleVector(new double[] {0.012510694706672668, -0.0021665831337641093, 0.0063998879738234845}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.005572920906599917, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.0015363508331182798, 0.007632121407009923, -0.006713291256614422}), new DoubleVector(new double[] {0.011326752689875067, -0.001097727428172508, 0.004948423136673529}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.0050731907519077695, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.002709526081857908, 0.004763857086772162, -0.0030123411547488795}), new DoubleVector(new double[] {0.01052499306579072, -5.402940633863043E-4, 0.004073176244211354}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.0030824096808249684, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.0027225193149181095, 0.004943650257471743, -0.003316400165373633}), new DoubleVector(new double[] {0.009924975824752507, 5.553313546959591E-5, 0.003213360758778554}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.0028406391732286053, 0);

    meshContinuum_0.getReferenceValues().get(BaseSize.class).setValue(5.0E-4);

    meshPipelineController_0.generateVolumeMesh();

    meshContinuum_0.setPresentationName("Mesh in0");

    MeshContinuum meshContinuum_1 = 
      simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);

    meshContinuum_1.setPresentationName("Copy of Mesh in0");

    meshContinuum_1.copyManagedProperties(meshContinuum_0, simulation_0.getContinuumManager());

    meshContinuum_1.setPresentationName("Mesh out0");

    partDisplayer_3.getParts().setObjects(boundary_7, boundary_8, boundary_9);

    meshContinuum_1.add(region_3);

    partDisplayer_3.getParts().setObjects();

    MeshContinuum meshContinuum_2 = 
      simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);

    meshContinuum_2.setPresentationName("Copy of Mesh out0");

    meshContinuum_2.copyManagedProperties(meshContinuum_1, simulation_0.getContinuumManager());

    MeshContinuum meshContinuum_3 = 
      simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);

    meshContinuum_3.setPresentationName("Copy of Mesh out0");

    meshContinuum_3.copyManagedProperties(meshContinuum_1, simulation_0.getContinuumManager());

    simulation_0.saveState(resolvePath("/nfs/mohr/sva/work/rymalc/bin/sunshot/star/full_design/full_design_3/full_section_3_1_300_1.5_v2.sim"));

    currentView_0.setInput(new DoubleVector(new double[] {0.0027225193149181095, 0.004943650257471743, -0.003316400165373633}), new DoubleVector(new double[] {0.009924975824752507, 5.553313546959591E-5, 0.003213360758778554}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.0028406391732286053, 0);

    MeshContinuum meshContinuum_4 = 
      simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);

    meshContinuum_4.setPresentationName("Copy of Mesh out0");

    meshContinuum_4.copyManagedProperties(meshContinuum_1, simulation_0.getContinuumManager());

    MeshContinuum meshContinuum_5 = 
      simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);

    meshContinuum_5.setPresentationName("Copy of Mesh out0");

    meshContinuum_5.copyManagedProperties(meshContinuum_1, simulation_0.getContinuumManager());

    meshContinuum_2.setPresentationName("Mesh out1");

    meshContinuum_5.setPresentationName("Mesh in1");

    meshContinuum_3.setPresentationName("Mesh out2");

    meshContinuum_4.setPresentationName("Mesh duct");

    partDisplayer_3.getParts().setObjects(boundary_0);

    meshContinuum_4.add(region_0);

    partDisplayer_3.getParts().setObjects(boundary_1, boundary_2, boundary_3);

    partDisplayer_3.getParts().setObjects(boundary_4, boundary_5, boundary_6);

    meshContinuum_5.add(region_2);

    partDisplayer_3.getParts().setObjects(boundary_7, boundary_8, boundary_9);

    partDisplayer_3.getParts().setObjects(boundary_10, boundary_11, boundary_12, directBoundaryInterfaceBoundary_0);

    meshContinuum_2.add(region_4);

    partDisplayer_3.getParts().setObjects(boundary_13, boundary_14, boundary_15, directBoundaryInterfaceBoundary_1);

    meshContinuum_3.add(region_5);

    currentView_0.setInput(new DoubleVector(new double[] {0.0027225193149181095, 0.004943650257471743, -0.003316400165373633}), new DoubleVector(new double[] {0.009924975824752507, 5.553313546959591E-5, 0.003213360758778554}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.0028406391732286053, 0);

    partDisplayer_3.getParts().setObjects();

    meshPipelineController_0.generateVolumeMesh();

    currentView_0.setInput(new DoubleVector(new double[] {0.0027225193149181095, 0.004943650257471743, -0.003316400165373633}), new DoubleVector(new double[] {0.009924975824752507, 5.553313546959591E-5, 0.003213360758778554}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.0028406391732286053, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.0021514646605593924, 0.004951247461711554, -0.00292398484791996}), new DoubleVector(new double[] {0.012331483747649547, -0.0019576627877247446, 0.0063052400354571}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.004014985854273224, 0);

    partDisplayer_2.getParts().setObjects(partSurface_37, partSurface_118, partCurve_1, partSurface_7, partSurface_60, partSurface_5, partSurface_102, partSurface_120, partSurface_6, partSurface_121, partSurface_119);

    currentView_0.setInput(new DoubleVector(new double[] {0.002058255257402328, 5.641662647210511E-4, -0.0070625233315821465}), new DoubleVector(new double[] {0.012618476172155817, -0.006602776929597323, 0.002511393259988838}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.004164936944421271, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.0019577825216991404, 4.6210470135646647E-4, -0.007315081924892785}), new DoubleVector(new double[] {0.011575967550346011, -0.006065503602410226, 0.0014047831205357144}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.003793399256271717, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.0019688260360388853, 3.0138497830358227E-4, -0.007450392689649097}), new DoubleVector(new double[] {0.010637709790717187, -0.005581957607941838, 4.088339950279031E-4}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.003418996108908188, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.0018014960214527125, 0.001114491507974177, -0.00693190629634804}), new DoubleVector(new double[] {0.014913956581951403, -0.007784589366701625, 0.004955875666725508}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.0051715368325666025, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.0016651825322671412, 0.002466183192948477, -0.005849149776387555}), new DoubleVector(new double[] {0.02261120080617299, -0.011749326532469243, 0.013140550675781197}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.008261081472797012, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.0014880726122168328, 0.004265288778016619, -0.004401266515303627}), new DoubleVector(new double[] {0.032874193105135105, -0.017035642753492734, 0.02405345068785545}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.01237864376495995, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.0013390336119169996, 0.005877452795070827, -0.003088779249909031}), new DoubleVector(new double[] {0.04211088617420101, -0.021793327352413877, 0.03387506069872228}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.016080363886319112, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.0012805779738204112, 0.006571898339000997, -0.002514479176292911}), new DoubleVector(new double[] {0.04611345317079624, -0.02385499067861304, 0.038131091703431236}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.01768202575872643, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.0013985296043687381, 0.004331095971197418, -0.004477621024069241}), new DoubleVector(new double[] {0.03290498208203199, -0.017051501702155806, 0.02408618938789167}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.012426102538114943, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.0016317993538005832, -0.00272787815527264, -0.00838680130704617}), new DoubleVector(new double[] {0.030656094718859515, -0.02464081961274079, 0.02088546555786941}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.01273430205355906, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.003959730840247493, -0.005537317980114476, -0.0038474217656971794}), new DoubleVector(new double[] {0.017575915918022426, -0.014778263388690384, 0.00849703781354201}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.005370205105583843, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.00400018435061106, -0.005518775267380913, -0.0038951842133270196}), new DoubleVector(new double[] {0.016261512058744414, -0.013840214741089598, 0.007220959068825829}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.004835851178824786, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.004144479772019849, -0.00608517195462895, -0.003462918096365857}), new DoubleVector(new double[] {0.014846419517478145, -0.01334829597863126, 0.006239481059687019}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.004220830660896277, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.0035946128156372093, -0.006166203849250252, -0.00367351472448783}), new DoubleVector(new double[] {0.013526815354299488, -0.012906927548468339, 0.005331039199464052}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.0039172473404373775, 0);

    SurfaceProximity surfaceProximity_1 = 
      meshContinuum_1.getReferenceValues().get(SurfaceProximity.class);

    surfaceProximity_1.setNumPointsInGap(8.0);

    SurfaceProximity surfaceProximity_2 = 
      meshContinuum_2.getReferenceValues().get(SurfaceProximity.class);

    surfaceProximity_2.setNumPointsInGap(8.0);

    SurfaceProximity surfaceProximity_3 = 
      meshContinuum_4.getReferenceValues().get(SurfaceProximity.class);

    surfaceProximity_3.setNumPointsInGap(8.0);

    currentView_0.setInput(new DoubleVector(new double[] {0.0035946128156372093, -0.006166203849250252, -0.00367351472448783}), new DoubleVector(new double[] {0.013526815354299488, -0.012906927548468339, 0.005331039199464052}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.0039172473404373775, 0);

    meshPipelineController_0.generateVolumeMesh();

    currentView_0.setInput(new DoubleVector(new double[] {0.0035946128156372093, -0.006166203849250252, -0.00367351472448783}), new DoubleVector(new double[] {0.013526815354299488, -0.012906927548468339, 0.005331039199464052}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.0039172473404373775, 0);

    meshContinuum_4.getReferenceValues().get(BaseSize.class).setValue(1.0E-4);

    meshContinuum_1.getReferenceValues().get(BaseSize.class).setValue(1.0E-4);

    meshPipelineController_0.generateVolumeMesh();

    meshContinuum_0.getReferenceValues().get(BaseSize.class).setValue(1.0E-4);

    surfaceProximity_0.setNumPointsInGap(8.0);

    meshContinuum_5.getReferenceValues().get(BaseSize.class).setValue(1.0E-4);

    SurfaceProximity surfaceProximity_4 = 
      meshContinuum_5.getReferenceValues().get(SurfaceProximity.class);

    surfaceProximity_4.setNumPointsInGap(8.0);

    meshContinuum_2.getReferenceValues().get(BaseSize.class).setValue(1.0E-4);

    simulation_0.saveState(resolvePath("/nfs/mohr/sva/work/rymalc/bin/sunshot/star/full_design/full_design_3/full_section_3_1_300_1.5_v2.sim"));

    meshPipelineController_0.generateVolumeMesh();

    currentView_0.setInput(new DoubleVector(new double[] {0.0035946128156372093, -0.006166203849250252, -0.00367351472448783}), new DoubleVector(new double[] {0.013526815354299488, -0.012906927548468339, 0.005331039199464052}), new DoubleVector(new double[] {-0.4378225178233059, 0.41811324764673746, 0.7959225810524282}), 0.0039172473404373775, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.005842785528887877, -0.005552963333560125, -4.490466095371094E-4}), new DoubleVector(new double[] {0.005526639498682714, 0.008623406602755158, 0.007007373504650584}), new DoubleVector(new double[] {-0.9915231195187151, 0.042473709050003965, -0.12279204982168634}), 0.004182280922819926, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.0065317307928471745, -0.004638537695978725, 4.983566440328576E-4}), new DoubleVector(new double[] {0.020595434589452156, -0.006865822011124588, 0.008542045123005689}), new DoubleVector(new double[] {-0.2841563414936619, 0.672766287647886, 0.6831110420666754}), 0.004269220112642066, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.0065317307928471745, -0.004638537695978725, 4.983566440328576E-4}), new DoubleVector(new double[] {-0.00982215205636929, -0.004638537695978725, 4.983566440328576E-4}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 0.004269220112642066, 0);

    partDisplayer_3.getParts().setObjects(boundary_1, boundary_2, boundary_3);

    partDisplayer_3.getParts().setObjects(boundary_4, boundary_5, boundary_6);

    partDisplayer_3.getParts().setObjects(boundary_4);

    partDisplayer_3.getParts().setObjects();

    PhysicsContinuum physicsContinuum_0 = 
      ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("Physics 1"));

    physicsContinuum_0.enable(SteadyModel.class);

    physicsContinuum_0.enable(SingleComponentGasModel.class);

    physicsContinuum_0.enable(SegregatedFlowModel.class);

    physicsContinuum_0.enable(LaminarModel.class);

    physicsContinuum_0.enable(ConstantDensityModel.class);

    partDisplayer_3.getParts().setObjects(boundary_4);

    boundary_4.setBoundaryType(MassFlowBoundary.class);

    currentView_0.setInput(new DoubleVector(new double[] {0.0076946602532534745, -0.004255045115575137, -0.005103969747950124}), new DoubleVector(new double[] {-0.00982215205636929, -0.004255045115575137, -0.005103969747950124}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 0.004572805621216773, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.00707792229960105, -0.004277707339629438, -0.0050706175785730735}), new DoubleVector(new double[] {-0.010584581579382975, -0.0013531555360309015, -0.009374702953064706}), new DoubleVector(new double[] {-0.2337512813347106, 0.018949586030196454, 0.9721117485472875}), 0.0048067832759211004, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.00707792229960105, -0.004277707339629438, -0.0050706175785730735}), new DoubleVector(new double[] {-0.010584581579382975, -0.0013531555360309015, -0.009374702953064706}), new DoubleVector(new double[] {-0.2337512813347106, 0.018949586030196454, 0.9721117485472875}), 0.0048067832759211004, 0);

    partDisplayer_3.getParts().setObjects(partSurface_121);

    currentView_0.setInput(new DoubleVector(new double[] {0.00707792229960105, -0.004277707339629438, -0.0050706175785730735}), new DoubleVector(new double[] {-0.010584581579382975, -0.0013531555360309015, -0.009374702953064706}), new DoubleVector(new double[] {-0.2337512813347106, 0.018949586030196454, 0.9721117485472875}), 0.0048067832759211004, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.00707792229960105, -0.004277707339629438, -0.0050706175785730735}), new DoubleVector(new double[] {-0.010584581579382975, -0.0013531555360309015, -0.009374702953064706}), new DoubleVector(new double[] {-0.2337512813347106, 0.018949586030196454, 0.9721117485472875}), 0.0048067832759211004, 0);

    partDisplayer_3.getParts().setObjects();

    MassFlowRateProfile massFlowRateProfile_0 = 
      boundary_4.getValues().get(MassFlowRateProfile.class);

    massFlowRateProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.00175);

    partDisplayer_3.getParts().setObjects(boundary_4, boundary_5, boundary_6);

    partDisplayer_3.getParts().setObjects();

    AreaAverageReport areaAverageReport_0 = 
      simulation_0.getReportManager().createReport(AreaAverageReport.class);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("StaticPressure"));

    areaAverageReport_0.setScalar(primitiveFieldFunction_0);

    areaAverageReport_0.getParts().setObjects(boundary_4);

    AreaAverageReport areaAverageReport_1 = 
      simulation_0.getReportManager().createReport(AreaAverageReport.class);

    areaAverageReport_1.setPresentationName("Copy of Surface Average 1");

    areaAverageReport_1.copyProperties(areaAverageReport_0);

    areaAverageReport_1.setPresentationName("p outlet");

    areaAverageReport_0.setPresentationName("p inlet");

    areaAverageReport_1.getParts().setObjects(boundary_13, directBoundaryInterfaceBoundary_1, boundary_15, boundary_14);

    partDisplayer_3.getParts().setObjects(boundary_15);

    boundary_15.setBoundaryType(PressureBoundary.class);

    partDisplayer_3.getParts().setObjects(boundary_13, boundary_14, boundary_15, directBoundaryInterfaceBoundary_1);

    partDisplayer_3.getParts().setObjects();

    ExpressionReport expressionReport_0 = 
      simulation_0.getReportManager().createReport(ExpressionReport.class);

    expressionReport_0.setPresentationName("dp");

    expressionReport_0.setDefinition("$pinletReport - $poutletReport");

    ReportMonitor reportMonitor_0 = 
      expressionReport_0.createMonitor();

    MonitorPlot monitorPlot_0 = 
      simulation_0.getPlotManager().createMonitorPlot();

    monitorPlot_0.setPresentationName("dp Monitor Plot");

    monitorPlot_0.getMonitors().addObjects(reportMonitor_0);

    Axes axes_0 = 
      monitorPlot_0.getAxes();

    Axis axis_0 = 
      axes_0.getXAxis();

    AxisTitle axisTitle_0 = 
      axis_0.getTitle();

    axisTitle_0.setText("Iteration");

    Axis axis_1 = 
      axes_0.getYAxis();

    AxisTitle axisTitle_1 = 
      axis_1.getTitle();

    axisTitle_1.setText("Expression");

    simulation_0.saveState(resolvePath("/nfs/mohr/sva/work/rymalc/bin/sunshot/star/full_design/full_design_3/full_section_3_1_300_1.5_v3.sim"));

    simulation_0.getSimulationIterator().run();

    scene_0.close(true);

    simulation_0.saveState(resolvePath("/nfs/mohr/sva/work/rymalc/bin/sunshot/star/full_design/full_design_3/full_section_3_1_300_1.5_v3.sim"));
  }
}
