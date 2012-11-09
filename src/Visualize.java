import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.*;

import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;



public class Visualize{// extends ApplicationFrame implements ActionListener {
	
	//instance variables
	//protected int [] array;
	//protected XYDataset data;
	
	/** The time series data. */
   // private TimeSeries series;

    /** The most recent value added. */
   // private double lastValue = 100.0;
	
	public Visualize(String title,int []A) {
		//super(title);
		
		int j = 0;
		
		System.out.println("2");

		//array = A.clone();	
		
		XYSeries series1 = new XYSeries(title);
		System.out.println("5");
		
		while(j< A.length){
			
			series1.add(A[j+1], A[j]);
			j+=3;
		}
		
		/*System.out.println("6");
		this.series = new TimeSeries("Random Data", Millisecond.class);
        final TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        final JButton button = new JButton("Add New Data Item");
        button.setActionCommand("ADD_DATA");
        button.addActionListener(this);

        final JPanel content = new JPanel(new BorderLayout());
        content.add(chartPanel);
        content.add(button, BorderLayout.SOUTH);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(content);
*/
		XYDataset xyDataset = new XYSeriesCollection(series1);
		JFreeChart chart = ChartFactory.createXYLineChart
		  ("XYLine Chart using JFreeChart", "Y-values", "X-values", xyDataset, PlotOrientation.VERTICAL, true, true, false);
		ChartFrame frame1=new ChartFrame("XYLine Chart",chart);
		  
		frame1.setVisible(true);
		  
		frame1.setSize(500,500);
	
	}
	public void run(){
		System.out.println("x");
	}
	
	/*private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
            "Dynamic Data Demo", 
            "Time", 
            "Value",
            dataset, 
            true, 
            true, 
            false
        );
        
        final XYPlot plot = result.getXYPlot();
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(60000.0);  // 60 seconds
        axis = plot.getRangeAxis();
        axis.setRange(0.0, 200.0); 
        return result;
    }
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("ADD_DATA")) {
            final double factor = 0.90 + 0.2 * Math.random();
            this.lastValue = this.lastValue * factor;
            final Millisecond now = new Millisecond();
            System.out.println("Now = " + now.toString());
            this.series.add(new Millisecond(), this.lastValue);
        }
		
	}
	*/
}
