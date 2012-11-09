
public class FuzzyClassify {
	
	public FuzzyClassify(){
	}
	
	public String classify(int[]A){
		
		int counter=0;
		boolean side = A[16]<100 && A[16]>=40;
		boolean bend = A[16]>=100 && A[16]<= 195;
		boolean straight;
		boolean XindexFB= A[4]>=100 && A[4]<=255;
		boolean ZindexFB= A[6]>=100 && A[6]<=255;
		boolean indexStretch = A[5]>=85 && A[5]<=100;
		boolean thumbStretch = A[1]>=0 && A[1]<=43;
		boolean thumbFB = A[1]<=255 && A[1]>=80;
		
		String symbol = null;
		
		//boolean Side = A[15]<85;
		for(int i=0; i < 18; i++){
			
			
			if (counter<3){
				System.out.println(A[i]);
				counter++;
			}
			
			else{
				counter = 0;
				System.out.println("next finger: ");
			}
		}
		
		for(int i=0 ; i<A.length ; i++)
			System.out.println(" A["+i+"]="+A[i]);
		if(side){
			System.out.println("alif or 3ain or 3'ain");
			
			if(XindexFB)
					symbol = "l";
			else if(indexStretch){
				System.out.println("3 or 3'");
				if(thumbStretch)
					symbol = "3'";
				else if(thumbFB)
					symbol = "3";
			}
			
				
			//if()
		}
		else if(bend){
			System.out.println("bent");
			if(ZindexFB)
				symbol = "w";
			
		}
		return symbol;
	}	
}