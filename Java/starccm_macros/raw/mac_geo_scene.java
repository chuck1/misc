// STAR-CCM+ macro: mac_geo_scene.java
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class mac_geo_scene extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

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

    currentView_0.setInput(new DoubleVector(new double[] {-0.051691025467334846, 0.018417111445475642, 0.014879831421012625}), new DoubleVector(new double[] {-0.051691025467334846, 0.018417111445475642, 0.025390666821968173}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.0027438786438768936, 0);

    partDisplayer_2.setMesh(true);
  }
}
