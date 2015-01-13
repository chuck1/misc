
package csvStat;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.util.*;
import java.io.*;
import java.lang.Math.*;


public class csvStat {
	public static double avg(String filePath,int N0,int col) throws IOException {
		CSVReader reader = new CSVReader(new FileReader(filePath));
		
		double sum=0;
		double avg=0;
		
		List<String []> lines = reader.readAll();
		
		if ( lines.size() == 0 ) { return 0.0; }
		if ( lines.get(0).length < (col+1) ) { return 0.0; }
		
		int N=Math.min(N0,lines.size()-1);
		
		for ( int i = lines.size()-N; i < lines.size(); i++ ) {
			sum += Double.parseDouble(lines.get(i)[col]);
		}
		avg = sum/N;
		
		return avg;
	}
}
