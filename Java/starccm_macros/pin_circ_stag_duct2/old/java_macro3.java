// STAR-CCM+ macro: java_macro3.java
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;

public class java_macro3 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = getActiveSimulation();

    PhysicsContinuum physicsContinuum_0 = ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("Physics 1"));

    SteadyModel steadyModel_0 = physicsContinuum_0.getModelManager().getModel(SteadyModel.class);

    physicsContinuum_0.disableModel(steadyModel_0);

    physicsContinuum_0.enable(ImplicitUnsteadyModel.class);

    PhysicsContinuum physicsContinuum_1 = ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("Physics 2"));

    SteadyModel steadyModel_1 = 
      physicsContinuum_1.getModelManager().getModel(SteadyModel.class);

    physicsContinuum_1.disableModel(steadyModel_1);

    physicsContinuum_1.enable(ImplicitUnsteadyModel.class);

    ImplicitUnsteadySolver implicitUnsteadySolver_0 = 
      ((ImplicitUnsteadySolver) simulation_0.getSolverManager().getSolver(ImplicitUnsteadySolver.class));

    implicitUnsteadySolver_0.getTimeStep().setValue(1.43E-6);

    StepStoppingCriterion stepStoppingCriterion_0 = 
      ((StepStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Steps 2"));

    stepStoppingCriterion_0.setIsUsed(false);

    InnerIterationStoppingCriterion innerIterationStoppingCriterion_0 = 
      ((InnerIterationStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Inner Iterations"));

    innerIterationStoppingCriterion_0.setMaximumNumberInnerIterations(50);

    ReportMonitor reportMonitor_0 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("dp Monitor"));

    reportMonitor_0.getTriggerOption().setSelected(MonitorTriggerOption.TIME_STEP);

    ReportMonitor reportMonitor_1 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("tout Monitor"));

    reportMonitor_1.getTriggerOption().setSelected(MonitorTriggerOption.TIME_STEP);

    ReportMonitor reportMonitor_2 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("ttop Monitor"));

    reportMonitor_2.getTriggerOption().setSelected(MonitorTriggerOption.TIME_STEP);

    simulation_0.getSimulationIterator().run();
  }
}
