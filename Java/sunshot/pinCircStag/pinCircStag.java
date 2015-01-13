// STAR-CCM+ macro: pinCircStag.java
package sunshot.pinCircStag;

public class pinCircStag {
	public double D;
	
	public double P_T;
	public double P_L;
	public double P_D;
	
	public double S_T;
	public double S_L;
	public double S_D;
	
	public double alpha;
	public double H;
	public double N_T;
	
	public double f;
	
	public class LengthDependent {
		double mdot;
		double N_L;
		double L;
		double A_hs;
	}
	
	LengthDependent simu;
	LengthDependent full;
	
	public class Mesh {
		
		public class Values {
			public double baseSizeRatio;
			public double baseSize;
			public double numPointsInGap;
			public int numPrismLayers;
		}
		
		public Values fluid;
		public Values solid;
	}
	
	public Mesh mesh;
	
	public void eval() {
	
	}
	
	
	
}