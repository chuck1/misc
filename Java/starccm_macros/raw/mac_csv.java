// STAR-CCM+ macro: mac_csv.java
package macro;

import java.util.*;



import java.lang.*;
import star.cadmodeler.*;




import star.common.*;
import star.coupledflow.*;
import star.solidmesher.*;
import star.flow.*;
import star.segregatedflow.*;
import star.meshing.*;
import star.turbulence.*;
import star.material.*;
import star.kwturb.*;
import star.base.neo.*;
import star.vis.*;
import star.resurfacer.*;
import star.base.report.*;
import star.dualmesher.*;
import star.prismmesher.*;
import star.energy.*;

public class mac_csv extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();
	  
    CsvReader csvReader_0 = new CsvReader("/nfs/mohr/sva/work/rymalc/bin/sunshot/clust/jobs/star/pin_circ_stag_duct/pin_circ_stag_duct_case_0000/csv_param.csv",3);
	
	Collection<java.lang.String> strings_0 = csvReader_0.getValues();
	
	simulation_0.println("csv contents:");
	
	for (Object o : strings_0)
    simulation_0.println(o);
	
	Iterator iterator = strings_0.iterator();
	double D = Double.parseDouble(iterator.next().toString());
	double P_T = Double.parseDouble(iterator.next().toString());
	int N_L = Integer.parseInt(iterator.next().toString());
	
	
	simulation_0.println(D);
  }
}
