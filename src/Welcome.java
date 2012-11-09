import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

import de.progra.charting.ChartEncoder;
import de.progra.charting.CoordSystem;
import de.progra.charting.DefaultChart;
import de.progra.charting.event.ChartDataModelEvent;
import de.progra.charting.event.ChartDataModelListener;
import de.progra.charting.model.EditableChartDataModel;
import de.progra.charting.model.ObjectChartDataModel;
import de.progra.charting.render.BarChartRenderer;
import de.progra.charting.render.LineChartRenderer;
import de.progra.charting.render.RowColorModel;
import de.progra.charting.swing.ChartPanel;

	public class Welcome extends javax.swing.JFrame implements ActionListener, ChartDataModelListener {
		  
		      ChartPanel panel;
		      EditableChartDataModel data;
		      
		      // Initialize the Timer:
		      javax.swing.Timer t = new javax.swing.Timer(1000, this);
		      double time = 3.0;
		      
		      public Welcome() {
		          // Init some starting data
		          double[][] model = {{25.0, 22.0, 23.0},
		                              {13.0, 11.0, 12.0}};
		          
		          double[] columns = {0.0, 1.0, 2.0};
		          String[] columnString = {"1998", "1999", "2000"};
		          String[] rows = {"Int. Temp.", "Ext. Temp."};
		 
		          String title = "Viewing Internal & External Temperature";
		  
		          // Create an editable chart data model
		         data = new EditableChartDataModel(model, columns, rows);
		       
		          // Creating the Swing ChartPanel instead of DefaultChart
		          panel = new ChartPanel(data, title, DefaultChart.LINEAR_X_LINEAR_Y);
		          // Adding ChartRenderer as usual
		          panel.addChartRenderer(new LineChartRenderer(panel.getCoordSystem(), data), 1);
		          // Register EventListener
		          data.addChartDataModelListener(this);
		         
		          // Start the Timer
		          t.start();
		          setSize(640, 480);
		          this.getContentPane().add(panel, BorderLayout.CENTER);
		          
		          
		      }
		  
		      public void actionPerformed(ActionEvent evt) {
		         // The Timer generated an event -> update DataModel with random data
		          data.insertValue(0, new Double(Math.random() * 10.0 + 20.0), new Double(time));
		          data.insertValue(1, new Double(Math.random() * 7.0 + 10.0), new Double(time));
		          
		          time++;
		      }
		     
		      public void chartDataChanged(ChartDataModelEvent evt) {
		         // The DataModel changed -> update display
		          panel.revalidate();
		          repaint();
		      }

		  
		      public static Welcome main(String args[]) {
		          // Start the whole shebang 
		          new Welcome().show();
				
		          return null;
		      }
		      
	}
	
	
	

