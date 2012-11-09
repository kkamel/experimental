
import com.idrt.BluetoothHelper;
import com.idrt.BluetoothHelper.BluetoothDetectionListener;
import com.idrt.BluetoothHelper.BluetoothGloveEntry;
import com.idrt.Glove;
import com.idrt.Glove.GloveIOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jon
 */
public class Main implements BluetoothDetectionListener {

	public Main() {

	}

    public static void main(String[] args) {
       Main instance = new Main();

	   System.out.println("Starting Bluetooth Scan");

	   BluetoothHelper.BluetoothDetector detector = BluetoothHelper.startAcceleGloveDetection( instance );

	   while( detector.inProgress() ) {
			try {
				// Wait for detection to complete.
				Thread.sleep( 1000 );
			} catch ( InterruptedException ex ) {
				Logger.getLogger( Main.class.getName() ).log( Level.SEVERE, null, ex );
			}
	   }

	   // Detection is completed.
	   System.out.println("Completed results: ");

	   for( BluetoothGloveEntry bge : detector.getResults() ) {
		   System.out.println( bge.friendlyName + " ( BT://" + bge.address + " )" );

		  
	   }

	    /* Connect to the first glove.*/
		if( !detector.getResults().isEmpty() ) {
			try {
				System.out.println("Connecting.");
				Glove g = new Glove( "BT://" + detector.getResults().get( 0 ).address );
				System.out.println("Connected.");
				g.close();
			} catch ( GloveIOException ex ) {
				Logger.getLogger( Main.class.getName() ).log( Level.SEVERE, null, ex );
			}
		}


	   System.out.println("Done");
    }

	public void detectedAcceleGlove( BluetoothGloveEntry bge ) {
		System.out.println("Detected glove: " + bge.friendlyName + " at address: BT://" + bge.address );

		// Could start connection here as well.
	}

	public void scanCompleted() {
		System.out.println("Scan completed ");
		
	}

}
