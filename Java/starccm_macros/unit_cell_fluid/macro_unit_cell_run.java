// STAR-CCM+ macro: macro_unit_cell_run.java
package macro;

import java.util.*;

import star.common.*;
import star.flow.*;
import star.meshing.*;
import star.segregatedflow.*;
import star.turbulence.*;
import star.material.*;
import star.kwturb.*;
import star.base.neo.*;
import star.vis.*;
import star.resurfacer.*;
import star.base.report.*;
import star.dualmesher.*;
import star.prismmesher.*;

public class macro_unit_cell_run extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {
	// simulation
	Simulation simulation_0 = getActiveSimulation();	

	// paths
	String session_abs_dir = simulation_0.getSessionDir();
	String save_path = session_abs_dir + "/sim_unit_cell.sim";
	
	// run
    simulation_0.getSimulationIterator().run(10);
	
	// export monitor plots
	ResidualPlot residualPlot_0 = ((ResidualPlot) simulation_0.getPlotManager().getObject("Residuals"));
	MonitorPlot monitorPlot_0 = ((MonitorPlot)  simulation_0.getPlotManager().getObject("Expression 1 Monitor Plot"));
	
    residualPlot_0.export(resolvePath( session_abs_dir + "/residuals.csv" ), ",");
    monitorPlot_0.export(resolvePath( session_abs_dir + "/pressure.csv" ), ",");
	
	// save
    simulation_0.saveState(resolvePath(save_path));
  }
}
