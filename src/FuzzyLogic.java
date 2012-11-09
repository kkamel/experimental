import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;

import net.sourceforge.jFuzzyLogic.FIS;


public class FuzzyLogic {
		
		public FuzzyLogic(){
		
		}//end constructor FuzzyLogic()
	    
		public double Run(int[] data) throws Exception {
	        // Load from 'FCL' file
	        String fileName = "src/tipper.fcl";
	        FIS fis = FIS.load(fileName,true);
	        // Error while loading?
	        if( fis == null ) { 
	            System.err.println("Can't load file: '" 
	                                   + fileName + "'");
	            return 1.1;
	        }//end if

	        // Show charts of membership functions
	        fis.chart();

	        // Enter crisp inputs into the fuzzy system
	        fis.setVariable("Wx", data[15]);
	        fis.setVariable("Wy", data[16]);
	        fis.setVariable("Ty", data[1]);
	        fis.setVariable("Tz", data[2]);
	        fis.setVariable("Iy", data[4]);
	        fis.setVariable("My", data[7]);
	        fis.setVariable("Rx", data[9]);
	        fis.setVariable("Ry", data[10]);
	        fis.setVariable("Py", data[13]);
	        	       	       
	        // Evaluate rules in inference engine
	        try{
	        	fis.evaluate();
	        }catch (NullPointerException e){
	        	System.out.println(e);
	        }//end try/catch clause

	        // Show output variable's chart 
	       fis.getVariable("letter").chartDefuzzifier(true);
	       // System.out.println("letter output:"+fis.getVariable("letter").getLatestDefuzzifiedValue());
	        
	        // Return latest defuzzifed letter that has been classified
			return fis.getVariable("letter").getLatestDefuzzifiedValue();
	    }//end Run
				
}//end class FuzzyLogic

