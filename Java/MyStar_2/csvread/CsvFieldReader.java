// STAR-CCM+ macro: CsvFieldReader.java
package MyStar.csvread;

import java.util.*;
import java.lang.*;

import star.cadmodeler.*;
import star.base.neo.*;
//import star.vis.*;
//import star.base.report.*;
//import star.meshing.*;

public class CsvFieldReader {
	public static void load_param(Object o, String csvFilename) {
		CsvReader csvReader_0 = new CsvReader(csvFilename,2);
		Collection<String> strings_0 = csvReader_0.getValues();
		Iterator it = strings_0.iterator();
		Field field;
		
		while (it.hasNext()) {
			field = o.getField(it.next());
			switch (field.getType()) {
				case Double.class:
					field.set(o,Double.parseDouble(it.next()));
					break;
				case Integer.class:
					field.set(o,Integer.parseInteger(it.next()));
					break;
				default:
					break;
			}
		}
	}
}
