
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.NavigableMap;
import java.util.TreeMap;
import weka.core.Queue;
import com.idrt.Glove;
import com.idrt.Glove.GloveIOException;
import com.idrt.GloveConnectionStatus;
import com.idrt.Handshape;

/**
 * Opens a connection to the AcceleGlove and prints the current accelerometer
 * values to the console.
 **/
public class ReadGlove implements com.idrt.GloveHandshapeListener {
	
	
	//Class variables
	public static final int NUMBER_OF_HANDSHAPES_TO_READ = 1;
	private int numberOfHandshapesIn = 0;
	private final Object syncObject = new Object();
	private long endTime;
	private NavigableMap<Double, String> fuzzyDict = new TreeMap<Double, String>();	//lookup tables with Arabic letters
	private Queue wordQueue = new Queue();
	
	
	public ReadGlove() {
		
		//intialize lookup table with Arabic letters and their
		//mapped output membership of the fuzzy system.
		initializeFuzzyDict();	
		
	}//end ReadGlove

	public void connectGlove() throws IOException {
		try {
			// Create a connection to a Glove.
			final Glove glove = new Glove();

			// Listen for glove status changes.
			glove.addPropertyChangeListener(new PropertyChangeListener() {

				public void propertyChange(PropertyChangeEvent evt) {
					if (evt.getPropertyName().equals(Glove.PropertyGloveStatus)) {
						//System.out.println("Glove Status changed to: "
								//+ evt.getNewValue());

						// If we have lost the connection, close it.
						if (glove.getGloveStatus() == GloveConnectionStatus.DISCONNECTED) {
							System.out.println("Lost connection to glove.");
							glove.close();
							System.exit(0);
						}//end if
					}//end if
				}//end propertyChange
			});

			System.out.println("Reading " + NUMBER_OF_HANDSHAPES_TO_READ
					+ " Glove Handshapes");

				// Read Glove Handshapes
				// We synchronize to get notifications of when we are complete.
				synchronized (syncObject) {
					// Register that we want handshapes from the glove.
					glove.setInterHandshapeTime(2000);
										
					glove.addGloveHandshapeListener(this);
					
	
					long startTime = System.currentTimeMillis();
					// Wait for all the handshapes to be read.
					while (numberOfHandshapesIn < NUMBER_OF_HANDSHAPES_TO_READ) {
							
						try {
							syncObject.wait();
						} catch (InterruptedException e) {
									// Keep waiting.
						}//end try/catch clause				 							
					}//end while
										
					long elapsed = endTime - startTime;	//elapsed time
					double perPacket = elapsed / (double) NUMBER_OF_HANDSHAPES_TO_READ;	//time per packet in ms
					double Hz = Math.floor((1000 / perPacket) * 1000) / 1000;	//baud rate
				
				//System.out.println("" + NUMBER_OF_HANDSHAPES_TO_READ + " took " + elapsed + "ms rate = " + Hz + "Hz");
			
				}//end thread synchronized
				
				for(int i=0; i<NUMBER_OF_HANDSHAPES_TO_READ; i++){
					System.out.print(wordQueue.pop());
					
				}//end for
				
				System.out.print('\n');
				
			// Close Glove Connection.
			glove.close();
			
		} catch (GloveIOException e) {
			System.out.println("Failed to connect to an AcceleGlove.");
			e.printStackTrace();
			
		}//end try/catch clause	
	}//end connectGlove

	public void receivedHandshape(Glove glove, Handshape handshape) {
		numberOfHandshapesIn++;
		endTime = System.currentTimeMillis();
		
		try {
			FuzzyRun(handshape, numberOfHandshapesIn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end try/catch clause
			
		// Check if we are done.
		if (numberOfHandshapesIn == NUMBER_OF_HANDSHAPES_TO_READ) {
			synchronized (syncObject) {
				// Register that we do not want anymore handshapes.
				glove.removeGloveHandshapeListener(this);
				// Inform the main Thread that we are completed.
				syncObject.notifyAll();
				return;
				
			}//end thread synchronized
		}//end if	
		
	}//end recievedHanshape
		
	@SuppressWarnings("deprecation")
	public void FuzzyRun(Handshape handshape, int handshapeNum) throws Exception{
		
		double fuzzyOutput;
		int[]A = handshape.toArray();
		
		//System.out.println(A);
		
		//for(int i=0; i<A.length; i++)
			//System.out.println(A[i]);
		//Calls fuzzy system method and sends the crisp sensor data into the fuzzy system
		FuzzyLogic fl = new FuzzyLogic();
		fuzzyOutput = fl.Run(A);
		
		//Send classified letter to the output buffer to obtain a full string
		wordQueue.push(fuzzyDict.get(fuzzyDict.floorKey(fuzzyOutput)));
		System.out.println(fuzzyDict.get(fuzzyDict.floorKey(fuzzyOutput)));
		return;
	}//end FuzzyRun
	
	public void initializeFuzzyDict(){
		
		//Creates dictionary (lookup table) mapping the output of the fuzzy system 
		//to a letter/character of the Arabic alphabet
		
		fuzzyDict.put(0.0, " ");
		fuzzyDict.put(1.0, "ا");
		fuzzyDict.put(10.0, "ب");
		fuzzyDict.put(20.0, "ت");
		fuzzyDict.put(30.0, "ث");
		fuzzyDict.put(40.0, "ج");
		fuzzyDict.put(50.0, "ح");	
		fuzzyDict.put(60.0, "خ");
		fuzzyDict.put(70.0, "د");
		fuzzyDict.put(80.0, "ذ");
		fuzzyDict.put(90.0, "ر");
		fuzzyDict.put(100.0, "ز");
		fuzzyDict.put(110.0, "س");
		fuzzyDict.put(120.0, "ش");
		fuzzyDict.put(130.0, "ص");
		fuzzyDict.put(140.0, "ض");
		fuzzyDict.put(150.0, "ط");
		fuzzyDict.put(160.0, "ظ");
		fuzzyDict.put(170.0, "ع");	
		fuzzyDict.put(190.0, "غ");
		fuzzyDict.put(200.0, "ف");
		fuzzyDict.put(210.0, "ق");
		fuzzyDict.put(220.0, "ك");
		fuzzyDict.put(230.0, "ل");
		fuzzyDict.put(240.0, "م");
		fuzzyDict.put(250.0, "ن");
		fuzzyDict.put(260.0, "ه");
		fuzzyDict.put(270.0, "و");
		fuzzyDict.put(280.0, "ي");
		
		return;
	}//end intializeFuzzyDict
	
	public static void main(String[] args) {
		ReadGlove g = new ReadGlove();
		try {
			g.connectGlove();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}//end try/catch clause
	}//end main
}//end class ReadGlove
