import java.awt.Rectangle;
import java.io.FileOutputStream;


	public class GraphV{ 
		  
		     //ChartPanel panel;
		     //EditableChartDataModel data;
		     
		      // Initialize the Timer:
		      //javax.swing.Timer t = new javax.swing.Timer(1000, this);
		     //double time = 3.0;
		      
		     public static void make(int []A) {
		         // Init some starting data
		    	 System.out.println("in"+ A[0]);
		    	 
		          int[][] model={{1,2,3,4,5,6,7}};
		          
			    	 System.out.println("in"+ A[0]);

		           //{{25.0, 22.0, 23.0},
		              //{13.0, 11.0, 12.0}};
		          
		         double[] columns = {0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0};	//x-axis values
		    	 
		         System.out.println("1");

		                 String[] rows = {"DataSet 1"};          // Create data set title
		                 String title = "A First Test";          // Create diagram title
				         System.out.println("2");

		                 int width = 640;                        // Image size
		                 int height = 480;
		                 
		                 // Create data model
		                 DefaultChartDataModel data = new DefaultChartDataModel(model, columns, rows);
		                 
		                 // Create chart with default coordinate system
		                 DefaultChart chart = new DefaultChart(data, title, DefaultChart.LINEAR_X_LINEAR_Y);
		                 
		                 // Add a line chart renderer
		                chart.addChartRenderer(new LineChartRenderer(chart.getCoordSystem(), data), 1);
				         System.out.println("5");

		                 // Set the chart size
		                 chart.setBounds(new Rectangle(0, 0, width, height));
				         System.out.println("6");
				         
		                 // Export the chart as a PNG image
				         try{
		                    ChartEncoder.createEncodedImage(new FileOutputStream(System.getProperty("user.home")+"/first.png"), chart, "png");
		                 } catch(Exception e) {
		                     e.printStackTrace();
		                 }
		     }
	}
		                 
		     

