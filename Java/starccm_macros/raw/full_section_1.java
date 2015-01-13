// STAR-CCM+ macro: full_section_1.java
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.meshing.*;

public class full_section_1 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PartImportManager partImportManager_0 = 
      simulation_0.get(PartImportManager.class);

    partImportManager_0.importCadPart(resolvePath("/nfs/stak/students/r/rymalc/Windows.Documents/My Documents/SYNC/SUNSHOT/solidworks/full_design/design_3/full_section_3_1_300_1.5.x_b"), "SharpEdges", 30.0, 2, true, true);

    simulation_0.getSceneManager().createGeometryScene("Geometry Scene", "Outline", "Geometry", 1);

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    scene_0.initializeAndWait();

    LogoAnnotation logoAnnotation_0 = 
      ((LogoAnnotation) simulation_0.getAnnotationManager().getObject("Logo"));

    logoAnnotation_0.setOpacity(0.20000000298023224);

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

    currentView_0.setInput(new DoubleVector(new double[] {4.336808689942018E-18, 1.734723475976807E-18, 0.0034500000931322553}), new DoubleVector(new double[] {4.336808689942018E-18, 1.734723475976807E-18, 0.08321021042544248}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.020821593090693733, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.0018873295565754447, -0.01186034097897675, 0.01639743654476906}), new DoubleVector(new double[] {0.014658149549597902, -0.09211462363495096, 0.011353015993861362}), new DoubleVector(new double[] {0.16481487669484401, -0.03572830150330113, 0.9856772011626082}), 0.021255002980855035, 0);

    currentView_0.setInput(new DoubleVector(new double[] {0.0026084553353647125, -0.007745971226200431, 6.169044091540064E-4}), new DoubleVector(new double[] {0.01584428080252803, -0.09092243748343637, -0.004611191361616026}), new DoubleVector(new double[] {0.16481487669484401, -0.03572830150330113, 0.9856772011626082}), 0.02202893079006211, 0);

    CompositePart compositePart_0 = 
      ((CompositePart) simulation_0.get(SimulationPartManager.class).getPart("Assembly 1"));

    CadPart cadPart_0 = 
      ((CadPart) compositePart_0.getChildParts().getPart("Body1"));

    PartSurface partSurface_0 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces");

    partDisplayer_3.getParts().setObjects(partSurface_0);

    CadPart cadPart_1 = 
      ((CadPart) compositePart_0.getChildParts().getPart("Body2"));

    PartSurface partSurface_1 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("Faces");

    partDisplayer_3.getParts().setObjects(partSurface_1);

    CadPart cadPart_2 = 
      ((CadPart) compositePart_0.getChildParts().getPart("Body3"));

    PartSurface partSurface_2 = 
      cadPart_2.getPartSurfaceManager().getPartSurface("Faces");

    partDisplayer_3.getParts().setObjects(partSurface_2);

    CadPart cadPart_3 = 
      ((CadPart) compositePart_0.getChildParts().getPart("Body4"));

    PartSurface partSurface_3 = 
      cadPart_3.getPartSurfaceManager().getPartSurface("Faces");

    partDisplayer_3.getParts().setObjects(partSurface_3);

    CadPart cadPart_4 = 
      ((CadPart) compositePart_0.getChildParts().getPart("Body5"));

    PartSurface partSurface_4 = 
      cadPart_4.getPartSurfaceManager().getPartSurface("Faces");

    partDisplayer_3.getParts().setObjects(partSurface_4);

    CadPart cadPart_5 = 
      ((CadPart) compositePart_0.getChildParts().getPart("Body6"));

    PartSurface partSurface_5 = 
      cadPart_5.getPartSurfaceManager().getPartSurface("Faces");

    partDisplayer_3.getParts().setObjects(partSurface_5);

    partDisplayer_3.getParts().setObjects(partSurface_3);

    cadPart_3.setPresentationName("duct");

    partDisplayer_3.getParts().setObjects(partSurface_4);

    currentView_0.setInput(new DoubleVector(new double[] {0.008188122635064122, -0.016507450194108056, 7.215041444901633E-4}), new DoubleVector(new double[] {0.08648709353243456, -0.05152839613492395, 0.009906790977819739}), new DoubleVector(new double[] {-0.02165950145632435, 0.20805185630877215, 0.9778779530611872}), 0.022519554979252798, 0);

    partDisplayer_3.getParts().setObjects(partSurface_3);

    partDisplayer_3.getParts().setObjects(partSurface_2);

    partDisplayer_3.getParts().setObjects(partSurface_1);

    partDisplayer_3.getParts().setObjects(partSurface_0);

    partDisplayer_3.getParts().setObjects(partSurface_4);

    partDisplayer_3.getParts().setObjects(partSurface_5);

    cadPart_5.setPresentationName("in0");

    partDisplayer_3.getParts().setObjects(partSurface_4);

    cadPart_4.setPresentationName("out0");

    partDisplayer_3.getParts().setObjects(partSurface_2);

    cadPart_2.setPresentationName("out2");

    partDisplayer_3.getParts().setObjects(partSurface_0);

    cadPart_0.setPresentationName("in1");

    partDisplayer_3.getParts().setObjects(partSurface_1);

    cadPart_1.setPresentationName("out1");

    partDisplayer_3.getParts().setObjects(partSurface_0);

    partDisplayer_3.getParts().setObjects(partSurface_1);

    partDisplayer_3.getParts().setObjects(partSurface_3);

    partDisplayer_3.getParts().setObjects(partSurface_5);

    partDisplayer_3.getParts().setObjects(partSurface_0);

    PartCurve partCurve_0 = 
      ((PartCurve) cadPart_0.getPartCurveManager().getObject("Edges"));

    cadPart_0.getPartSurfaceManager().splitPartSurfacesByPartCurves(new NeoObjectVector(new Object[] {partSurface_0}), new NeoObjectVector(new Object[] {partCurve_0}));

    PartSurface partSurface_6 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 2");

    partDisplayer_3.getParts().setObjects(partSurface_6);

    partDisplayer_3.getParts().setObjects(partSurface_0);

    partSurface_0.setPresentationName("inlet");

    partDisplayer_3.getParts().setObjects(partSurface_6);

    partSurface_6.setPresentationName("wall");

    PartSurface partSurface_7 = 
      cadPart_0.getPartSurfaceManager().getPartSurface("Faces 3");

    partDisplayer_3.getParts().setObjects(partSurface_7);

    partSurface_7.setPresentationName("int");

    partDisplayer_3.getParts().setObjects();

    partDisplayer_3.getParts().setObjects(partSurface_0, partSurface_6, partSurface_7);

    partDisplayer_3.getParts().setObjects(partSurface_1);

    partDisplayer_3.getParts().setObjects(partSurface_1);

    PartCurve partCurve_1 = 
      ((PartCurve) cadPart_1.getPartCurveManager().getObject("Edges"));

    cadPart_1.getPartSurfaceManager().splitPartSurfacesByPartCurves(new NeoObjectVector(new Object[] {partSurface_1}), new NeoObjectVector(new Object[] {partCurve_1}));

    PartSurface partSurface_8 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("Faces 2");

    partDisplayer_3.getParts().setObjects(partSurface_8);

    PartSurface partSurface_9 = 
      cadPart_1.getPartSurfaceManager().getPartSurface("Faces 3");

    partDisplayer_3.getParts().setObjects(partSurface_9);

    partDisplayer_3.getParts().setObjects(partSurface_1);

    partDisplayer_3.getParts().setObjects(partSurface_8);

    partSurface_8.setPresentationName("int1");

    partDisplayer_3.getParts().setObjects(partSurface_9);

    partSurface_9.setPresentationName("int0");

    partDisplayer_3.getParts().setObjects(partSurface_1);

    partSurface_1.setPresentationName("wall");

    partDisplayer_3.getParts().setObjects(partSurface_1, partSurface_8, partSurface_9);

    partDisplayer_3.getParts().setObjects(partSurface_2);

    partDisplayer_3.getParts().setObjects(partSurface_2);

    PartCurve partCurve_2 = 
      ((PartCurve) cadPart_2.getPartCurveManager().getObject("Edges"));

    cadPart_2.getPartSurfaceManager().splitPartSurfacesByPartCurves(new NeoObjectVector(new Object[] {partSurface_2}), new NeoObjectVector(new Object[] {partCurve_2}));

    PartSurface partSurface_10 = 
      cadPart_2.getPartSurfaceManager().getPartSurface("Faces 2");

    partDisplayer_3.getParts().setObjects(partSurface_10);

    PartSurface partSurface_11 = 
      cadPart_2.getPartSurfaceManager().getPartSurface("Faces 3");

    partDisplayer_3.getParts().setObjects(partSurface_11);

    partDisplayer_3.getParts().setObjects(partSurface_10);

    partSurface_10.setPresentationName("wall");

    partDisplayer_3.getParts().setObjects(partSurface_2);

    partSurface_2.setPresentationName("int");

    partDisplayer_3.getParts().setObjects(partSurface_11);

    partSurface_11.setPresentationName("outlet");

    partDisplayer_3.getParts().setObjects(partSurface_2, partSurface_10, partSurface_11);

    partDisplayer_3.getParts().setObjects(partSurface_3);

    partDisplayer_3.getParts().setObjects();

    partDisplayer_3.getParts().setObjects(partSurface_3);

    PartCurve partCurve_3 = 
      ((PartCurve) cadPart_3.getPartCurveManager().getObject("Edges"));

    cadPart_3.getPartSurfaceManager().splitPartSurfacesByPartCurves(new NeoObjectVector(new Object[] {partSurface_3}), new NeoObjectVector(new Object[] {partCurve_3}));

    PartSurface partSurface_12 = 
      cadPart_3.getPartSurfaceManager().getPartSurface("Faces 2");

    partDisplayer_3.getParts().setObjects(partSurface_12);

    PartSurface partSurface_13 = 
      cadPart_3.getPartSurfaceManager().getPartSurface("Faces 4");

    partDisplayer_3.getParts().setObjects(partSurface_13);

    partDisplayer_3.getParts().setObjects(partSurface_3);

    PartSurface partSurface_14 = 
      cadPart_3.getPartSurfaceManager().getPartSurface("Faces 6");

    partDisplayer_3.getParts().setObjects(partSurface_14);

    PartSurface partSurface_15 = 
      cadPart_3.getPartSurfaceManager().getPartSurface("Faces 5");

    PartSurface partSurface_16 = 
      cadPart_3.getPartSurfaceManager().getPartSurface("Faces 3");

    partDisplayer_3.getParts().setObjects(partSurface_13, partSurface_12, partSurface_14, partSurface_15, partSurface_16, partSurface_3);

    cadPart_3.combinePartSurfaces(new NeoObjectVector(new Object[] {partSurface_3, partSurface_12, partSurface_16, partSurface_13, partSurface_15, partSurface_14}));

    partDisplayer_3.getParts().setObjects(partSurface_3);

    partSurface_3.setPresentationName("wall");

    partDisplayer_3.getParts().setObjects(partSurface_3);

    partDisplayer_3.getParts().setObjects();

    currentView_0.setInput(new DoubleVector(new double[] {0.0051099548517649085, -0.01200174087333472, -9.118150428213609E-5}), new DoubleVector(new double[] {0.07985380392842979, -0.04543257997533742, 0.008677052419202542}), new DoubleVector(new double[] {-0.02165950145632435, 0.20805185630877215, 0.9778779530611872}), 0.021497066939093784, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.0024892951089495324, -0.005501810769397514, -0.001315182677391849}), new DoubleVector(new double[] {0.06453480348579094, -0.035479820783027846, 0.006547443909935729}), new DoubleVector(new double[] {-0.02165950145632435, 0.20805185630877215, 0.9778779530611872}), 0.01927679069010354, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-0.0020281499415481796, -0.004467669126348599, -0.0013940974567884686}), new DoubleVector(new double[] {0.058407203308735396, -0.03149871710610402, 0.005695600506229004}), new DoubleVector(new double[] {-0.02165950145632435, 0.20805185630877215, 0.9778779530611872}), 0.017381802654778334, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-8.647989173788048E-4, -0.002758272845503104, -0.0015091973426591626}), new DoubleVector(new double[] {0.04738034989658688, -0.02433698236309209, 0.0041504623577702775}), new DoubleVector(new double[] {-0.02165950145632435, 0.20805185630877215, 0.9778779530611872}), 0.013875779831415646, 0);

    currentView_0.setInput(new DoubleVector(new double[] {-1.1956930875615251E-4, -0.0020375412345696106, -0.0016939756664390414}), new DoubleVector(new double[] {0.04308923075098302, -0.02136363241708434, 0.003374867738832601}), new DoubleVector(new double[] {-0.02165950145632435, 0.20805185630877215, 0.9778779530611872}), 0.012427276340684523, 0);

    partDisplayer_3.getParts().setObjects(partSurface_4);

    partDisplayer_0.getHiddenParts().addObjects(partSurface_4);

    partDisplayer_2.getHiddenParts().addObjects(partSurface_4);

    PartDisplayer partDisplayer_4 = 
      scene_0.getDisplayerManager().createPartDisplayer("Dummy", 3, 1);

    PartRepresentation partRepresentation_0 = 
      ((PartRepresentation) simulation_0.getRepresentationManager().getObject("Geometry"));

    partDisplayer_4.setRepresentation(partRepresentation_0);

    partDisplayer_4.getParts().setObjects(partSurface_4);

    partDisplayer_3.getParts().eraseObjects(partSurface_4);

    partDisplayer_2.getParts().addParts(partSurface_4);

    partDisplayer_0.getParts().addParts(partSurface_4);

    partDisplayer_3.getParts().setObjects(partSurface_4);

    scene_0.getDisplayerManager().deleteDisplayer(partDisplayer_4);

    partDisplayer_4.initialize();

    currentView_0.setInput(new DoubleVector(new double[] {-1.1956930875615251E-4, -0.0020375412345696106, -0.0016939756664390414}), new DoubleVector(new double[] {0.04308923075098302, -0.02136363241708434, 0.003374867738832601}), new DoubleVector(new double[] {-0.02165950145632435, 0.20805185630877215, 0.9778779530611872}), 0.012427276340684523, 0);

    partDisplayer_3.getParts().setObjects();
  }
}
