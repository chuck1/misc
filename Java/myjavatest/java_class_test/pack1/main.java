package pack1;


import java.util.*;


public class main {
	public static void main(String[] args) {
		main m = new main();

		

		//List<myClass> l = new ArrayList<myClass>();
		
		List<Double> l = new ArrayList<Double>();
		
		m.execute();

		//myClass c = new myClass(1.0);

		//l.add(c);
	}
	public void execute() {
		myClass c = new myClass(1.0);
	}
	public class myClass {
		double a;
		
		public myClass( double param ) {
			a = param;
		}
	}
}
