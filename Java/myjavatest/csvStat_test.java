
package myjava;

import java.io.*;
import csvStat.*;

public class csvStat_test {
	public static void main(String[] args){
		double myAvg=0;
		try {
			myAvg = csvStat.avg("myjava/pressure_500_1.4.csv",1000,1);
		}
		catch(IOException e) {
		}
		System.out.println(myAvg);
	}
}
