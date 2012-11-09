import org.encog.neural.activation.ActivationSigmoid;      // to import the Sigmoid Activation ( because we have positive values)
import org.encog.neural.data.NeuralData;
import org.encog.neural.data.NeuralDataPair;
import org.encog.neural.data.NeuralDataSet;
import org.encog.neural.data.basic.BasicNeuralDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;				// layers 
import org.encog.neural.networks.training.Train;				// training phase
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;// training algorithm 
//import org.encog.neural.networks.training.propagation.back.Backpropagation;
import org.encog.util.logging.Logging;
import org.encog.neural.networks.logic.FeedforwardLogic;

	public class ANNTest {
	
	//instance variables
		public final int ALPHABET = 5;
		public double[] deltaProbablity = new double[ALPHABET]; 
		
		public static double input[][] = { { 168,0,132,196,112,38,209,124,79,212,94,124,210,54,128,229,55,170 }, {139,33,50,167,53,32,152,66,32,189,51,74,186,12,115,195,24,177},{165,7,104,237,117,113,211,128,77,218,91,138,203,44,106,242,64,159}, {154,4,89,232,123,109,220,110,143,206,78,166,202,39,150,245,80,142}};                       //setting the input value sets

		public static double output[][] = { { 0.01 }, { 0.01 }, { 0.01 }, { 0.01 } };										//setting the ideal output set Alef
	
		public static double input_2[][] = { {44,105,40,113,0,56,127,203,52,172,188,107,187,144,79,149,3,116 }, {19,84,67,129,21,36,109,227,77,165,197,127,191,156,104,153,14,95},{21,123,64,141,8,53,149,187,48,193,166,108,202,108,87,185,20,103}, {77,151,32,113,0,61,118,141,15,150,167,51,161,117,42,145,0,161}};                       //setting the input value sets
	
		public static double output_2[][] = { { 0.05 }, { 0.05 }, { 0.05 }, { 0.05 } };										//setting the ideal output set Baa2
			
		public static double input_3[][] = { {49,95,38,123,0,79,117,6,65,130,187,62,153,117,37,127,0,124}, {23,101,60,97,1,59,94,20,52,141,205,117,178,158,91,135,7,102},{10,113,76,110,7,49,133,14,61,171,178,76,181,117,57,153,13,99}, {10,92,79,68,8,62,102,31,40,136,211,111,158,176,84,100,8,105}};                       //setting the input value sets
	
		public static double output_3[][] = { { 0.1 }, { 0.1 }, { 0.1 }, { 0.1 } };										//setting the ideal output set Taa2
			
		public static double input_4[][] = { {35,70,55,101,0,85,94,0,109,119,0,74,120,110,22,105,0,129}, {27,82,55,100,0,67,95,12,58,109,0,72,136,165,49,110,7,107},{9,125,82,115,1,56,116,2,75,155,5,88,184,105,57,157,18,92}, {0,88,102,60,3,73,75,12,61,96,12,50,129,171,58,97,23,84}};                       //setting the input value sets
	
		public static double output_4[][] = { { 0.15 }, { 0.15 }, { 0.15 }, { 0.15 } };										//setting the ideal output set Thaa2
			
		public static double input_5[][] = { {0,152,116,97,123,11,126,148,18,176,125,52,169,90,43,154,51,56}, {0,104,125,69,148,27,50,189,52,102,170,35,111,143,32,94,40,73},{2,162,128,65,139,30,82,171,33,124,129,26,105,122,28,101,78,43}, {5,168,160,65,167,37,90,190,37,104,164,30,111,157,39,120,82,45}};                       //setting the input value sets
	
		public static double output_5[][] = { { 0.20 }, { 0.20 }, { 0.20 }, { 0.20 } };										//setting the ideal output set Jeem
			 
		public static double test[][];
	
		public ANNTest(int[] data){
			test = new double[1][data.length];
			for(int i =0; i<data.length; i++){
				
				test[0][i] = data[i];
			}
		}
			
			
		public void run(){	
			
		Logging.stopConsoleLogging();	
			
		BasicNetwork NN = new BasicNetwork();
		NN.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
		NN.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
		NN.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));
	
		NN.setLogic(new FeedforwardLogic());
		NN.getStructure().finalizeStructure();
		NN.reset();
	
		//-----------------------------------------------------------------------------
	
		BasicNetwork NN2 = new BasicNetwork();
		NN2.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
		NN2.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
		NN2.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));
	
		NN2.setLogic(new FeedforwardLogic());
		NN2.getStructure().finalizeStructure();
		NN2.reset();
	
		//-----------------------------------------------------------------------------
	
		BasicNetwork NN3 = new BasicNetwork();
		NN3.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
		NN3.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
		NN3.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));
	
		NN3.setLogic(new FeedforwardLogic());
		NN3.getStructure().finalizeStructure();
		NN3.reset();
	
		//-----------------------------------------------------------------------------
	
		BasicNetwork NN4 = new BasicNetwork();
		NN4.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
		NN4.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
		NN4.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));
	
		NN4.setLogic(new FeedforwardLogic());
		NN4.getStructure().finalizeStructure();
		NN4.reset();
	
		//-----------------------------------------------------------------------------
	
		BasicNetwork NN5 = new BasicNetwork();
		NN5.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
		NN5.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
		NN5.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));
	
		NN5.setLogic(new FeedforwardLogic());
		NN5.getStructure().finalizeStructure();
		NN5.reset();
	
	
		// Creating the Network Data set
		NeuralDataSet trainingSet = new BasicNeuralDataSet(input, output);
		NeuralDataSet trainingSet_2 = new BasicNeuralDataSet(input_2, output_2);
		NeuralDataSet trainingSet_3 = new BasicNeuralDataSet(input_3, output_3);
		NeuralDataSet trainingSet_4 = new BasicNeuralDataSet(input_4, output_4);
		NeuralDataSet trainingSet_5 = new BasicNeuralDataSet(input_5, output_5);
	
		//-----------------------------------------------------------------------------
	
		// creating the Network training set
		NeuralDataSet test1 = new BasicNeuralDataSet(test, output);
		NeuralDataSet test2 = new BasicNeuralDataSet(test, output_2);
		NeuralDataSet test3 = new BasicNeuralDataSet(test, output_3);
		NeuralDataSet test4 = new BasicNeuralDataSet(test, output_4);
		NeuralDataSet test5 = new BasicNeuralDataSet(test, output_5);
	
		//-----------------------------------------------------------------------------
	
		//train the neural network
		final Train train = new ResilientPropagation (NN, trainingSet);
		final Train train_2 = new ResilientPropagation (NN2, trainingSet_2);
		final Train train_3 = new ResilientPropagation (NN3, trainingSet_3);
		final Train train_4 = new ResilientPropagation (NN4, trainingSet_4);
		final Train train_5 = new ResilientPropagation (NN5, trainingSet_5);
	
	
		//Iteration to optimize
	
		int x = 1;
	
		do{
			train.iteration();
			System.out.println("X #" + x + " Error:" + train.getError());
			x++;
			
		} while(train.getError() > 0.0001);
	
		System.out.println("Neural Network Results Alef :");
	
		//-----------------------------------------------------------------------------
	
		do{
			train_2.iteration();
			System.out.println("X #" + x + " Error:" + train_2.getError());
			x++;
		}while(train_2.getError() > 0.0001);
	
		System.out.println("Neural Network Results baa2 :");
	
		//-----------------------------------------------------------------------------
	
		do{
			train_3.iteration();
			System.out.println("X #" + x + " Error:" + train_3.getError());
			x++;
		}while(train_3.getError() > 0.0001);
	
		System.out.println("Neural Network Results taa2:");
	
		//-----------------------------------------------------------------------------
	
	
		do{
			train_4.iteration();
			System.out.println("X #" + x + " Error:" + train_4.getError());
			x++;
		}while(train_4.getError() > 0.0001);
	
		System.out.println("Neural Network Results thaa2:");
	
		//-----------------------------------------------------------------------------
	
		do{
			
			train_5.iteration();
			System.out.println("X #" + x + " Error:" + train_5.getError());
			x++;
		}
	
		while(train_5.getError() > 0.0001);
	
		System.out.println("Neural Network Results Jeem:");
	
	
	
	
		//testing the Neural Network with the glove current data
	
		for(NeuralDataPair pair: test1 ){
			final NeuralData output = NN.compute(pair.getInput());
	
			System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) +"   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
		}
	
		//-----------------------------------------------------------------------------
	
		for(NeuralDataPair pair: test2 ){
			final NeuralData output = NN2.compute(pair.getInput());
	
			System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17)+ "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
		}
	
		//-----------------------------------------------------------------------------
	
		for(NeuralDataPair pair: test3){
		
			final NeuralData output = NN3.compute(pair.getInput());
	
			System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) + "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
		}
	
		//-----------------------------------------------------------------------------
	
		for(NeuralDataPair pair: test4){
			final NeuralData output = NN4.compute(pair.getInput());
	
			System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) + "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
		}
	
		//-----------------------------------------------------------------------------
	
		for(NeuralDataPair pair: test5){
			
			final NeuralData output = NN5.compute(pair.getInput());
	
			System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) + "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
			//deltaProbablity[5] = (abs(output.getData(0) - pair.getIdeal().getData(0)));
		}

		
	}	
}



