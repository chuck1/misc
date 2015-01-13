// STAR-CCM+ macro: java_macro.java
package macro;

import java.util.*;
import java.lang.*;

import star.cadmodeler.*;
import star.base.neo.*;
import star.base.report.*;
import star.common.*;
import star.dualmesher.*;
import star.energy.*;
import star.flow.*;
import star.kwturb.*;
import star.material.*;
import star.meshing.*;
import star.metrics.*;
import star.segregatedflow.*;
import star.turbulence.*;
import star.resurfacer.*;
import star.segregatedenergy.*;
import star.prismmesher.*;




public class java_macro2 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = getActiveSimulation();
	
	
	CsvReader csvReader_0 = new CsvReader("Z:\\Windows.Documents\\My Documents\\SYNC\\star_macros\\csvread\\csv_param.csv",2);
	
	Collection<java.lang.String> strings_0 = csvReader_0.getValues();
	
	for (String str: strings_0) {
	simulation_0.println(str);
	}
  }
}
