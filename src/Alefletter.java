import org.encog.neural.activation.ActivationSigmoid;      // to import the Sigmoid Activation ( because we have positive values)
import org.encog.neural.data.NeuralData;
import org.encog.neural.data.NeuralDataPair;
import org.encog.neural.data.NeuralDataSet;
import org.encog.neural.data.basic.BasicNeuralDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;				// layers 
import org.encog.neural.networks.training.Train;				// training phase
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;		// training algorithm 
//import java.io.*;
//import org.encog.neural.networks.training.propagation.back.Backpropagation;
import org.encog.util.logging.Logging;
import org.encog.neural.networks.logic.FeedforwardLogic;



public class Alefletter 
{	
		
	public static double input[][] = { { 168,0,132,196,112,38,209,124,79,212,94,124,210,54,128,229,55,170 }, {139,33,50,167,53,32,152,66,32,189,51,74,186,12,115,195,24,177},{165,7,104,237,117,113,211,128,77,218,91,138,203,44,106,242,64,159}, {154,4,89,232,123,109,220,110,143,206,78,166,202,39,150,245,80,142}};                       //setting the input value sets

	public static double output[][] = { { 0.0010 }, { 0.0010 },{ 0.0010 }, { 0.0010 } };										//setting the ideal output set Alef

	public static double input_2[][] = { {44,105,40,113,0,56,127,203,52,172,188,107,187,144,79,149,3,116 }, {19,84,67,129,21,36,109,227,77,165,197,127,191,156,104,153,14,95},{21,123,64,141,8,53,149,187,48,193,166,108,202,108,87,185,20,103}, {77,151,32,113,0,61,118,141,15,150,167,51,161,117,42,145,0,161}};                       //setting the input value sets

	public static double output_2[][] = { { 0.0050 }, { 0.0050 }, { 0.0050 }, { 0.0050 } };										//setting the ideal output set Baa2
	
	public static double input_3[][] = { {49,95,38,123,0,79,117,6,65,130,187,62,153,117,37,127,0,124}, {23,101,60,97,1,59,94,20,52,141,205,117,178,158,91,135,7,102},{10,113,76,110,7,49,133,14,61,171,178,76,181,117,57,153,13,99}, {10,92,79,68,8,62,102,31,40,136,211,111,158,176,84,100,8,105}};                       //setting the input value sets

	public static double output_3[][] = { { 0.010 }, { 0.010 }, { 0.010 }, { 0.010 } };										//setting the ideal output set Taa2
	
	public static double input_4[][] = { {35,70,55,101,0,85,94,0,109,119,0,74,120,110,22,105,0,129}, {27,82,55,100,0,67,95,12,58,109,0,72,136,165,49,110,7,107},{9,125,82,115,1,56,116,2,75,155,5,88,184,105,57,157,18,92}, {0,88,102,60,3,73,75,12,61,96,12,50,129,171,58,97,23,84}};                       //setting the input value sets

	public static double output_4[][] = { { 0.0150 }, { 0.0150 }, { 0.0150 }, { 0.0150 } };										//setting the ideal output set Thaa2
	
	public static double input_5[][] = { {0,152,116,97,123,11,126,148,18,176,125,52,169,90,43,154,51,56}, {0,104,125,69,148,27,50,189,52,102,170,35,111,143,32,94,40,73},{2,162,128,65,139,30,82,171,33,124,129,26,105,122,28,101,78,43}, {5,168,160,65,167,37,90,190,37,104,164,30,111,157,39,120,82,45}};                       //setting the input value sets

	public static double output_5[][] = { { 0.0200 }, { 0.0200 }, { 0.0200 }, { 0.0200 } };										//setting the ideal output set Jeem
	 
	public static double input_6[][] = {{44,139,45,145,147,21,137,152,21,188,130,67,186,90,61,180,37,81},{36,140,48,91,115,8,67,148,18,126,109,17,122,70,22,116,17,87},{11,162,111,70,163,41,82,182,38,111,133,23,94,119,24,116,86,40},{0,128,132,68,182,52,100,204,45,123,168,38,126,150,39,118,99,38} };                       //setting the input value sets

	public static double output_6[][] = { { 0.0250 }, { 0.0250 },{ 0.0250 }, { 0.0250 } };										//setting the ideal output set 7aa2
	
	public static double input_7[][] = {{78,0,102,120,135,13,129,138,16,168,105,41,153,67,36,173,0,139},{47,20,90,86,156,26,82,163,24,133,130,27,108,96,22,122,10,97},{76,71,33,125,183,41,132,189,43,148,158,43,146,134,41,160,45,65},{7,89,88,72,193,62,107,201,46,126,166,40,135,147,41,119,49,56}};
	
	public static double output_7[][] = { { 0.030 }, { 0.030 },{ 0.030 }, { 0.030 } };										//5aa2
	//////////
	public static double input_8[][] = {{0,137,185,62,89,21,83,236,137,97,214,171,125,204,132,79,34,83},{0,115,127,60,109,23,82,229,133,89,216,147,127,195,96,88,28,86},{4,133,113,108,104,15,149,218,131,153,178,194,175,170,156,135,38,68},{0,97,173,111,108,8,130,234,139,127,206,187,157,198,138,112,12,90}};
	
	public static double output_8[][] = { { 0.0350 }, { 0.0350 },{ 0.0350 }, { 0.0350 } };										//Daal
	//////////
	public static double input_9[][] = {{0,139,157,89,138,15,71,146,18,124,213,163,162,191,143,116,38,64},{0,152,159,81,118,11,66,138,16,116,204,196,138,207,128,94,51,56},{0,147,137,74,158,27,71,167,26,140,209,176,158,195,130,100,55,54},{0,94,174,105,118,7,107,121,10,123,216,155,152,194,114,111,12,97}};
	
	public static double output_9[][] = { { 0.040 }, { 0.040 },{ 0.040 }, { 0.040 } };										//Thaal
	//////////
	public static double input_10[][] = {{1,89,92,122,30,27,141,215,72,170,191,135,192,154,105,157,14,96},{0,116,90,89,58,17,109,237,95,132,218,142,160,184,92,127,29,70},{0,108,105,115,76,15,129,229,128,149,205,132,153,168,74,141,14,90},{0,93,147,104,64,13,128,234,137,124,203,191,159,193,137,107,19,83}};
	
	public static double output_10[][] = { { 0.0450 }, { 0.0450 },{ 0.0450 }, { 0.0450 } };										//Raa2
	//////////
	public static double input_11[][] = {{4,151,107,152,106,15,133,104,15,180,181,156,199,149,123,175,52,65},{0,89,95,76,95,11,57,108,19,113,220,148,147,197,108,99,29,74},{0,125,126,104,107,10,120,124,14,167,200,132,161,164,68,130,38,64},{0,97,163,107,84,8,120,91,12,135,205,187,172,188,137,116,26,76}};
	
	public static double output_11[][] = { { 0.050 }, { 0.050 },{ 0.050 }, { 0.050 } };										//Zain
	//////////
	public static double input_12[][] = {{64,0,149,104,0,82,84,0,85,92,0,100,83,0,96,104,0,127},{80,0,115,93,0,76,72,3,80,88,0,110,77,0,115,94,0,139},{112,9,68,123,3,56,98,3,68,123,0,122,100,0,127,130,0,171},{59,0,143,80,0,76,65,7,77,82,0,102,61,0,118,83,6,141}};
	
	public static double output_12[][] = { { 0.055 }, { 0.055 },{ 0.055 }, { 0.055 } };										//Seen
	//////////
	public static double input_13[][] = {{44,7,122,39,22,71,76,0,105,92,0,118,128,0,118,92,12,108},{42,15,97,29,39,61,54,4,90,95,0,125,137,0,146,96,4,116},{60,36,43,123,0,69,124,0,85,157,0,127,166,0,130,152,0,124},{57,10,94,79,0,83,72,0,92,96,0,116,115,0,135,99,10,103}};
	
	public static double output_13[][] = { { 0.060 }, { 0.060 },{ 0.060 }, { 0.060 } };										//Sheen
	//////////
	public static double input_14[][] = {{21,91,62,72,207,87,100,224,74,142,202,88,149,164,62,106,3,117},{50,70,44,37,189,97,63,227,98,120,207,86,135,170,57,94,0,151},{31,70,61,51,174,58,86,224,90,114,213,110,124,197,97,83,2,148},{40,91,42,62,203,89,84,228,86,129,214,105,128,183,72,109,0,139}};
	
	public static double output_14[][] = { { 0.065 }, { 0.065 },{ 0.065 }, { 0.065 } };										//Saad
	//////////
	public static double input_15[][] = {{10,37,153,89,214,91,109,229,87,139,209,108,155,172,74,123,0,119},{33,14,150,127,217,127,121,230,145,123,211,158,160,185,114,126,3,114},{37,14,176,98,206,65,115,232,95,127,213,104,152,175,76,108,0,162},{48,3,147,146,215,104,150,225,109,175,186,160,175,174,105,146,0,134}};
	
	public static double output_15[][] = { { 0.070 }, { 0.070 },{ 0.070 }, { 0.070 } };										//Daaad
	//////////
	public static double input_16[][] = {{0,75,96,111,8,45,146,149,22,175,189,123,189,150,95,176,5,122},{11,4,171,76,0,69,94,138,15,111,219,129,129,195,90,105,0,148},{0,121,122,107,40,24,143,194,50,164,192,97,178,145,71,156,16,90},{8,61,180,104,0,60,112,167,26,103,219,156,119,192,84,92,6,118}};
	
	public static double output_16[][] = { { 0.075 }, { 0.075 },{ 0.075 }, { 0.075 } };										//Taaah
	//////////
	public static double input_17[][] = {{46,28,77,131,0,60,171,126,33,184,173,109,186,139,78,188,9,152},{62,1,112,94,3,55,59,142,21,117,218,119,131,192,83,119,0,160},{24,50,82,127,13,46,142,173,33,176,187,108,189,145,83,158,2,134},{42,19,99,93,10,49,100,185,37,122,216,143,145,188,94,106,2,117}};
	
	public static double output_17[][] = { { 0.080 }, { 0.080 },{ 0.080 }, { 0.080 } };										//Thaah
	//////////
	public static double input_18[][] = {{107,174,37,227,102,80,219,98,114,210,79,129,206,53,125,244,80,137},{168,117,39,226,99,78,212,96,86,209,80,135,209,56,147,242,84,133},{120,153,28,231,116,89,204,78,73,213,81,107,188,47,73,240,79,146},{143,128,33,214,115,59,220,94,107,212,107,142,214,70,123,232,67,117}};
	
	public static double output_18[][] = { { 0.085 }, { 0.085 },{ 0.085 }, { 0.085 } };										//3ain
	//////////
	public static double input_19[][] = {{136,50,39,227,101,83,219,100,113,210,76,125,205,49,124,241,84,138},{182,91,43,218,89,65,199,84,68,209,90,129,210,64,140,242,71,145},{178,123,42,218,110,71,196,88,64,209,68,116,190,43,86,241,70,142},{133,83,26,202,96,46,197,91,60,213,116,135,211,73,111,226,45,141}};
	
	public static double output_19[][] = { { 0.090 }, { 0.090 },{ 0.090 }, { 0.090 } };										//3'ain
	//////////
	public static double input_20[][] = {{83,38,46,116,51,17,117,215,62,147,195,86,150,152,53,126,0,164},{33,16,117,108,99,7,116,236,114,117,213,168,129,205,124,102,3,120},{5,117,87,125,163,27,169,217,129,173,178,185,187,170,130,146,16,88},{38,11,133,108,71,13,88,208,55,123,208,90,122,183,69,113,0,165}};
	
	public static double output_20[][] = { { 0.0950 }, { 0.095 },{ 0.095 }, { 0.095 } };										//Faa2
	//////////
	public static double input_21[][] = {{62,66,38,154,73,16,112,69,19,155,190,84,161,150,60,152,0,164},{19,30,115,112,119,8,85,136,12,118,218,152,139,194,93,100,0,135},{0,90,125,109,168,29,123,177,30,163,182,189,188,169,132,130,10,93},{0,76,147,79,157,26,103,176,27,126,209,173,148,197,123,108,9,103}};
	
	public static double output_21[][] = { { 0.105 }, { 0.105 },{ 0.105 }, { 0.105 } };										//Qaaaf
	
	//////////
	public static double input_23[][] = {{24,21,163,119,4,48,122,228,82,146,211,130,164,178,90,122,0,117},{31,31,205,107,0,104,86,162,35,106,195,83,125,151,51,101,0,153},{7,50,152,132,13,42,151,228,86,172,202,133,192,161,97,148,5,123},{10,56,183,124,10,46,125,221,70,140,213,145,165,182,100,117,0,128}};
	
	public static double output_23[][] = { { 0.115 }, { 0.115 },{ 0.115 }, { 0.115 } };										//Laaam
	//////////
	public static double input_24[][] = {{6,56,110,43,195,107,69,232,135,106,203,73,62,30,40,76,14,120},{50,134,39,72,208,101,63,227,118,85,195,61,84,0,86,132,0,162},{11,59,106,52,201,134,69,222,166,105,207,82,74,0,68,78,8,126},{44,44,63,35,173,76,41,210,92,89,192,55,80,0,75,79,7,148}};
	
	public static double output_24[][] = { { 0.120 }, { 0.120 },{ 0.120 }, { 0.120 } };										//Meeeem
	//////////
	public static double input_25[][] = {{40,9,153,158,6,61,134,197,47,155,191,86,159,147,56,148,0,171},{100,0,141,192,30,69,168,160,41,192,153,97,202,89,85,197,16,162},{158,0,182,146,0,166,47,92,27,89,143,23,47,68,31,145,73,255},{72,0,138,160,0,84,143,137,20,164,163,57,145,110,30,171,12,208}};
	
	public static double output_25[][] = { { 0.125 }, { 0.125 },{ 0.125 }, { 0.125 } };										//Noon
	//////////
	public static double input_26[][] = {{2,54,118,121,130,13,108,142,12,168,110,42,153,92,33,145,0,145},{21,55,81,85,152,23,63,159,25,117,127,21,119,84,23,101,0,144},{13,144,88,110,202,68,92,205,57,172,176,88,180,132,75,140,12,95},{0,106,171,44,188,81,57,208,71,136,188,60,135,165,52,89,40,68}};
	
	public static double output_26[][] = { { 0.130 }, { 0.130 },{ 0.130 }, { 0.130 } };										//Haa2
	//////////
	public static double input_27[][] = {{37,207,136,99,169,217,98,171,232,67,159,232,102,176,220,77,106,48},{64,212,184,48,139,215,43,171,212,21,160,207,38,192,160,37,117,79},{72,220,170,119,140,236,158,110,233,91,85,250,137,112,243,111,135,48},{70,209,189,131,130,238,113,120,249,82,79,250,127,105,255,136,158,43}};
	
	public static double output_27[][] = { { 0.135 }, { 0.135 },{ 0.135 }, { 0.135 } };										//Wooow
	//////////
	public static double input_28[][] = {{35,12,175,93,190,47,65,226,99,123,210,95,154,33,55,123,0,149},{98,0,154,188,186,88,146,210,75,181,173,104,176,27,74,186,10,171},{81,9,212,153,148,23,126,188,39,163,131,41,151,0,133,153,9,198},{88,0,167,146,195,58,121,222,77,172,184,101,125,35,36,164,2,167}};
	
	public static double output_28[][] = { { 0.140 }, { 0.140 },{ 0.140 }, { 0.140 } };										//Yaaa2

	public static double input_29[][]= {{84,104,24,113,0,90,101,0,84,106,0,112,103,0,103,105,0,131},{44,99,42,124,0,68,95,0,76,124,0,130,107,0,128,125,0,140},{53,104,35,75,0,93,65,5,78,73,0,99,60,0,120,76,9,128},{57,80,37,115,0,91,105,0,74,115,0,102,96,0,98,117,0,123}};
	
	public static double output_29[][] = { { 0.145 }, { 0.145 },{ 0.145 }, { 0.145 } };		
		
		
		
		
	public static double test[][]={{30,57,72,98,0,89,100,3,72,141,194,82,117,121,25,114,0,127}};
	

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Alefletter(int[] data){
		test = new double[1][data.length];
		for(int i =0; i<data.length; i++){
			
			test[0][i] = data[i];
		}
	}
	
	public static void Run()
{	
	
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

//-----------------------------------------------------------------------------

BasicNetwork NN6 = new BasicNetwork();
NN6.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN6.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN6.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN6.setLogic(new FeedforwardLogic());
NN6.getStructure().finalizeStructure();
NN6.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN7 = new BasicNetwork();
NN7.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN7.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN7.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN7.setLogic(new FeedforwardLogic());
NN7.getStructure().finalizeStructure();
NN7.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN8 = new BasicNetwork();
NN8.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN8.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN8.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN8.setLogic(new FeedforwardLogic());
NN8.getStructure().finalizeStructure();
NN8.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN9 = new BasicNetwork();
NN9.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN9.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN9.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN9.setLogic(new FeedforwardLogic());
NN9.getStructure().finalizeStructure();
NN9.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN10 = new BasicNetwork();
NN10.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN10.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN10.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN10.setLogic(new FeedforwardLogic());
NN10.getStructure().finalizeStructure();
NN10.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN11 = new BasicNetwork();
NN11.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN11.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN11.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN11.setLogic(new FeedforwardLogic());
NN11.getStructure().finalizeStructure();
NN11.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN12 = new BasicNetwork();
NN12.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN12.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN12.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN12.setLogic(new FeedforwardLogic());
NN12.getStructure().finalizeStructure();
NN12.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN13 = new BasicNetwork();
NN13.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN13.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN13.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN13.setLogic(new FeedforwardLogic());
NN13.getStructure().finalizeStructure();
NN13.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN14 = new BasicNetwork();
NN14.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN14.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN14.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN14.setLogic(new FeedforwardLogic());
NN14.getStructure().finalizeStructure();
NN14.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN15 = new BasicNetwork();
NN15.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN15.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN15.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN15.setLogic(new FeedforwardLogic());
NN15.getStructure().finalizeStructure();
NN15.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN16 = new BasicNetwork();
NN16.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN16.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN16.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN16.setLogic(new FeedforwardLogic());
NN16.getStructure().finalizeStructure();
NN16.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN17 = new BasicNetwork();
NN17.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN17.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN17.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN17.setLogic(new FeedforwardLogic());
NN17.getStructure().finalizeStructure();
NN17.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN18 = new BasicNetwork();
NN18.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN18.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN18.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN18.setLogic(new FeedforwardLogic());
NN18.getStructure().finalizeStructure();
NN18.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN19 = new BasicNetwork();
NN19.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN19.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN19.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN19.setLogic(new FeedforwardLogic());
NN19.getStructure().finalizeStructure();
NN19.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN20 = new BasicNetwork();
NN20.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN20.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN20.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN20.setLogic(new FeedforwardLogic());
NN20.getStructure().finalizeStructure();
NN20.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN21 = new BasicNetwork();
NN21.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN21.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN21.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN21.setLogic(new FeedforwardLogic());
NN21.getStructure().finalizeStructure();
NN21.reset();


//-----------------------------------------------------------------------------

BasicNetwork NN23 = new BasicNetwork();
NN23.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN23.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN23.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN23.setLogic(new FeedforwardLogic());
NN23.getStructure().finalizeStructure();
NN23.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN24 = new BasicNetwork();
NN24.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN24.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN24.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN24.setLogic(new FeedforwardLogic());
NN24.getStructure().finalizeStructure();
NN24.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN25 = new BasicNetwork();
NN25.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN25.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN25.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN25.setLogic(new FeedforwardLogic());
NN25.getStructure().finalizeStructure();
NN25.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN26 = new BasicNetwork();
NN26.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN26.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN26.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN26.setLogic(new FeedforwardLogic());
NN26.getStructure().finalizeStructure();
NN26.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN27 = new BasicNetwork();
NN27.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN27.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN27.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN27.setLogic(new FeedforwardLogic());
NN27.getStructure().finalizeStructure();
NN27.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN28 = new BasicNetwork();
NN28.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN28.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN28.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN28.setLogic(new FeedforwardLogic());
NN28.getStructure().finalizeStructure();
NN28.reset();

//-----------------------------------------------------------------------------

BasicNetwork NN29 = new BasicNetwork();
NN29.addLayer(new BasicLayer(new ActivationSigmoid(), true,18));
NN29.addLayer(new BasicLayer(new ActivationSigmoid(), true,25));
NN29.addLayer(new BasicLayer(new ActivationSigmoid(), true,1));

NN29.setLogic(new FeedforwardLogic());
NN29.getStructure().finalizeStructure();
NN29.reset();

//////////////////////////////////////////////////////////////////////////////////////////////////////////////


// Creating the Network Data set
NeuralDataSet trainingSet = new BasicNeuralDataSet(input, output);
NeuralDataSet trainingSet_2 = new BasicNeuralDataSet(input_2, output_2);
NeuralDataSet trainingSet_3 = new BasicNeuralDataSet(input_3, output_3);
NeuralDataSet trainingSet_4 = new BasicNeuralDataSet(input_4, output_4);
NeuralDataSet trainingSet_5 = new BasicNeuralDataSet(input_5, output_5);
NeuralDataSet trainingSet_6 = new BasicNeuralDataSet(input_6, output_6);
NeuralDataSet trainingSet_7 = new BasicNeuralDataSet(input_7, output_7);
NeuralDataSet trainingSet_8 = new BasicNeuralDataSet(input_8, output_8);
NeuralDataSet trainingSet_9 = new BasicNeuralDataSet(input_9, output_9);
NeuralDataSet trainingSet_10 = new BasicNeuralDataSet(input_10, output_10);
NeuralDataSet trainingSet_11= new BasicNeuralDataSet(input_11, output_11);
NeuralDataSet trainingSet_12 = new BasicNeuralDataSet(input_12, output_12);
NeuralDataSet trainingSet_13 = new BasicNeuralDataSet(input_13, output_13);
NeuralDataSet trainingSet_14 = new BasicNeuralDataSet(input_14, output_14);
NeuralDataSet trainingSet_15 = new BasicNeuralDataSet(input_15, output_15);
NeuralDataSet trainingSet_16 = new BasicNeuralDataSet(input_16, output_16);
NeuralDataSet trainingSet_17 = new BasicNeuralDataSet(input_17, output_17);
NeuralDataSet trainingSet_18 = new BasicNeuralDataSet(input_18, output_18);
NeuralDataSet trainingSet_19 = new BasicNeuralDataSet(input_19, output_19);
NeuralDataSet trainingSet_20 = new BasicNeuralDataSet(input_20, output_20);
NeuralDataSet trainingSet_21 = new BasicNeuralDataSet(input_21, output_21);
NeuralDataSet trainingSet_23 = new BasicNeuralDataSet(input_23, output_23);
NeuralDataSet trainingSet_24 = new BasicNeuralDataSet(input_24, output_24);
NeuralDataSet trainingSet_25 = new BasicNeuralDataSet(input_25, output_25);
NeuralDataSet trainingSet_26 = new BasicNeuralDataSet(input_26, output_26);
NeuralDataSet trainingSet_27 = new BasicNeuralDataSet(input_27, output_27);
NeuralDataSet trainingSet_28 = new BasicNeuralDataSet(input_28, output_28);
NeuralDataSet trainingSet_29 = new BasicNeuralDataSet(input_29, output_29);


//-----------------------------------------------------------------------------

// creating the Network training set
NeuralDataSet test1 = new BasicNeuralDataSet(test, output);
NeuralDataSet test2 = new BasicNeuralDataSet(test, output_2);
NeuralDataSet test3 = new BasicNeuralDataSet(test, output_3);
NeuralDataSet test4 = new BasicNeuralDataSet(test, output_4);
NeuralDataSet test5 = new BasicNeuralDataSet(test, output_5);
NeuralDataSet test6 = new BasicNeuralDataSet(test, output_6);
NeuralDataSet test7 = new BasicNeuralDataSet(test, output_7);
NeuralDataSet test8 = new BasicNeuralDataSet(test, output_8);
NeuralDataSet test9 = new BasicNeuralDataSet(test, output_9);
NeuralDataSet test10 = new BasicNeuralDataSet(test, output_10);
NeuralDataSet test11= new BasicNeuralDataSet(test, output_11);
NeuralDataSet test12 = new BasicNeuralDataSet(test, output_12);
NeuralDataSet test13 = new BasicNeuralDataSet(test, output_13);
NeuralDataSet test14 = new BasicNeuralDataSet(test, output_14);
NeuralDataSet test15 = new BasicNeuralDataSet(test, output_15);
NeuralDataSet test16 = new BasicNeuralDataSet(test, output_16);
NeuralDataSet test17 = new BasicNeuralDataSet(test, output_17);
NeuralDataSet test18 = new BasicNeuralDataSet(test, output_18);
NeuralDataSet test19 = new BasicNeuralDataSet(test, output_19);
NeuralDataSet test20 = new BasicNeuralDataSet(test, output_20);
NeuralDataSet test21 = new BasicNeuralDataSet(test, output_21);
NeuralDataSet test23 = new BasicNeuralDataSet(test, output_23);
NeuralDataSet test24 = new BasicNeuralDataSet(test, output_24);
NeuralDataSet test25 = new BasicNeuralDataSet(test, output_25);
NeuralDataSet test26 = new BasicNeuralDataSet(test, output_26);
NeuralDataSet test27 = new BasicNeuralDataSet(test, output_27);
NeuralDataSet test28 = new BasicNeuralDataSet(test, output_28);
NeuralDataSet test29 = new BasicNeuralDataSet(test, output_29);

//-----------------------------------------------------------------------------

//train the neural network
final Train train = new ResilientPropagation (NN, trainingSet);
final Train train_2 = new ResilientPropagation (NN2, trainingSet_2);
final Train train_3 = new ResilientPropagation (NN3, trainingSet_3);
final Train train_4 = new ResilientPropagation (NN4, trainingSet_4);
final Train train_5 = new ResilientPropagation (NN5, trainingSet_5);
final Train train_6= new ResilientPropagation (NN6, trainingSet_6);
final Train train_7 = new ResilientPropagation (NN7, trainingSet_7);
final Train train_8 = new ResilientPropagation (NN8, trainingSet_8);
final Train train_9 = new ResilientPropagation (NN9, trainingSet_9);
final Train train_10 = new ResilientPropagation (NN10, trainingSet_10);
final Train train_11 = new ResilientPropagation (NN11, trainingSet_11);
final Train train_12 = new ResilientPropagation (NN12, trainingSet_12);
final Train train_13 = new ResilientPropagation (NN13, trainingSet_13);
final Train train_14 = new ResilientPropagation (NN14, trainingSet_14);
final Train train_15 = new ResilientPropagation (NN15, trainingSet_15);
final Train train_16 = new ResilientPropagation (NN16, trainingSet_16);
final Train train_17 = new ResilientPropagation (NN17, trainingSet_17);
final Train train_18 = new ResilientPropagation (NN18, trainingSet_18);
final Train train_19 = new ResilientPropagation (NN19, trainingSet_19);
final Train train_20 = new ResilientPropagation (NN20, trainingSet_20);
final Train train_21 = new ResilientPropagation (NN21, trainingSet_21);
final Train train_23 = new ResilientPropagation (NN23, trainingSet_23);
final Train train_24 = new ResilientPropagation (NN24, trainingSet_24);
final Train train_25 = new ResilientPropagation (NN25, trainingSet_25);
final Train train_26 = new ResilientPropagation (NN26, trainingSet_26);
final Train train_27 = new ResilientPropagation (NN27, trainingSet_27);
final Train train_28 = new ResilientPropagation (NN28, trainingSet_28);
final Train train_29 = new ResilientPropagation (NN29, trainingSet_29);

//Iteration to optimize

int x = 1;

do
{
train.iteration();
System.out.println("X #" + x + " Error:" + train.getError());
x++;
}

while(train.getError()  > 0.0001);

System.out.println("Neural Network Results Alef :");

//-----------------------------------------------------------------------------

do
{
train_2.iteration();
System.out.println("X #" + x + " Error:" + train_2.getError());
x++;
}

while(train_2.getError() > 0.0001);

System.out.println("Neural Network Results baa2 :");

//-----------------------------------------------------------------------------

do
{
train_3.iteration();
System.out.println("X #" + x + " Error:" + train_3.getError());
x++;
}

while(train_3.getError() > 0.0001);

System.out.println("Neural Network Results taa2:");

//-----------------------------------------------------------------------------


do
{
train_4.iteration();
System.out.println("X #" + x + " Error:" + train_4.getError());
x++;
}

while(train_4.getError() > 0.0001);

System.out.println("Neural Network Results thaa2:");

//-----------------------------------------------------------------------------

do
{
train_5.iteration();
System.out.println("X #" + x + " Error:" + train_5.getError());
x++;
}

while(train_5.getError() > 0.0001);

System.out.println("Neural Network Results Jeem:");

//-----------------------------------------------------------------------------

do
{
train_6.iteration();
System.out.println("X #" + x + " Error:" + train_6.getError());
x++;
}

while(train_6.getError() > 0.0001);

System.out.println("Neural Network Results 7aa2:");

//-----------------------------------------------------------------------------

do
{
train_7.iteration();
System.out.println("X #" + x + " Error:" + train_7.getError());
x++;
}

while(train_7.getError() > 0.0001);

System.out.println("Neural Network Results 5aaa2:");

//-----------------------------------------------------------------------------

do
{
train_8.iteration();
System.out.println("X #" + x + " Error:" + train_8.getError());
x++;
}

while(train_8.getError() > 0.0001);

System.out.println("Neural Network Results Daaal:");

//-----------------------------------------------------------------------------

do
{
train_9.iteration();
System.out.println("X #" + x + " Error:" + train_9.getError());
x++;
}

while(train_9.getError() > 0.0001);

System.out.println("Neural Network Results Thaaal:");

//-----------------------------------------------------------------------------

do
{
train_10.iteration();
System.out.println("X #" + x + " Error:" + train_10.getError());
x++;
}

while(train_10.getError() > 0.0001);

System.out.println("Neural Network Results Raaa2:");

//-----------------------------------------------------------------------------

do
{
train_11.iteration();
System.out.println("X #" + x + " Error:" + train_11.getError());
x++;
}

while(train_11.getError() > 0.0001);

System.out.println("Neural Network Results Zain:");

//-----------------------------------------------------------------------------

do
{
train_12.iteration();
System.out.println("X #" + x + " Error:" + train_12.getError());
x++;
}

while(train_12.getError() > 0.0001);

System.out.println("Neural Network Results Seen:");

//-----------------------------------------------------------------------------

do
{
train_13.iteration();
System.out.println("X #" + x + " Error:" + train_13.getError());
x++;
}

while(train_13.getError() > 0.0001);

System.out.println("Neural Network Results Sheen:");

//-----------------------------------------------------------------------------

do
{
train_14.iteration();
System.out.println("X #" + x + " Error:" + train_14.getError());
x++;
}

while(train_14.getError() > 0.0001);

System.out.println("Neural Network Results Saad:");

//-----------------------------------------------------------------------------

do
{
train_15.iteration();
System.out.println("X #" + x + " Error:" + train_15.getError());
x++;
}

while(train_15.getError() > 0.0001);

System.out.println("Neural Network Results Daaad:");

//-----------------------------------------------------------------------------

do
{
train_16.iteration();
System.out.println("X #" + x + " Error:" + train_16.getError());
x++;
}

while(train_16.getError() > 0.0001);

System.out.println("Neural Network Results Taaah:");

//-----------------------------------------------------------------------------

do
{
train_17.iteration();
System.out.println("X #" + x + " Error:" + train_17.getError());
x++;
}

while(train_17.getError() > 0.0001);

System.out.println("Neural Network Results Thaah:");

//-----------------------------------------------------------------------------

do
{
train_18.iteration();
System.out.println("X #" + x + " Error:" + train_18.getError());
x++;
}

while(train_18.getError() > 0.0001);

System.out.println("Neural Network Results 3ain:");

//-----------------------------------------------------------------------------

do
{
train_19.iteration();
System.out.println("X #" + x + " Error:" + train_19.getError());
x++;
}

while(train_19.getError() > 0.0001);

System.out.println("Neural Network Results 3'ain:");

//-----------------------------------------------------------------------------

do
{
train_20.iteration();
System.out.println("X #" + x + " Error:" + train_20.getError());
x++;
}

while(train_20.getError() > 0.0001);

System.out.println("Neural Network Results faa2:");

//-----------------------------------------------------------------------------

do
{
train_21.iteration();
System.out.println("X #" + x + " Error:" + train_21.getError());
x++;
}

while(train_21.getError() > 0.0001);

System.out.println("Neural Network Results Qaaaf:");

//-----------------------------------------------------------------------------



do
{
train_29.iteration();
System.out.println("X #" + x + " Error:" + train_29.getError());
x++;
}

while(train_29.getError() > 0.0001);

System.out.println("Neural Network Results Kaaf:");

//----------------------------------------------------------------------------

do
{
train_23.iteration();
System.out.println("X #" + x + " Error:" + train_23.getError());
x++;
}

while(train_23.getError() > 0.0001);

System.out.println("Neural Network Results Laaam:");

//-----------------------------------------------------------------------------

do
{
train_24.iteration();
System.out.println("X #" + x + " Error:" + train_24.getError());
x++;
}

while(train_24.getError() > 0.0001);

System.out.println("Neural Network Results Meeem:");

//-----------------------------------------------------------------------------

do
{
train_25.iteration();
System.out.println("X #" + x + " Error:" + train_25.getError());
x++;
}

while(train_25.getError() > 0.0001);

System.out.println("Neural Network Results Nooon:");

//-----------------------------------------------------------------------------

do
{
train_26.iteration();
System.out.println("X #" + x + " Error:" + train_26.getError());
x++;
}

while(train_26.getError() > 0.0001);

System.out.println("Neural Network Results Haa2:");

//-----------------------------------------------------------------------------
do
{
train_27.iteration();
System.out.println("X #" + x + " Error:" + train_27.getError());
x++;
}

while(train_27.getError() > 0.0001);

System.out.println("Neural Network Results Woooow:");

do
{
train_28.iteration();
System.out.println("X #" + x + " Error:" + train_28.getError());
x++;
}

while(train_28.getError() > 0.0001);

System.out.println("Neural Network Results Yaaaaa2:");


//-------------------------------------------------------------------


///////////////////////////////////////////////////////////////////////////////////////////////////////////////

//testing the Neural Network with the glove current data


//-----------------------------------------------------------------------------
for(NeuralDataPair pair: test1 )
{
final NeuralData output = NN.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) +"   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test2 )
{
final NeuralData output = NN2.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17)+ "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test3)
{
final NeuralData output = NN3.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) + "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test4)
{
final NeuralData output = NN4.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) + "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test5)
{
final NeuralData output = NN5.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) + "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}


//-----------------------------------------------------------------------------
for(NeuralDataPair pair: test6 )
{
final NeuralData output = NN6.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) +"   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test7 )
{
final NeuralData output = NN7.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17)+ "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test8)
{
final NeuralData output = NN8.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) + "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test9)
{
final NeuralData output = NN9.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) + "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test10)
{
final NeuralData output = NN10.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) + "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}


//-----------------------------------------------------------------------------
for(NeuralDataPair pair: test11 )
{
final NeuralData output = NN11.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) +"   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test12 )
{
final NeuralData output = NN12.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17)+ "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test13)
{
final NeuralData output = NN13.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) + "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test14)
{
final NeuralData output = NN14.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) + "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test15)
{
final NeuralData output = NN15.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) + "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}


//-----------------------------------------------------------------------------
for(NeuralDataPair pair: test16 )
{
final NeuralData output = NN16.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) +"   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test17 )
{
final NeuralData output = NN17.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17)+ "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test18)
{
final NeuralData output = NN18.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) + "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test19)
{
final NeuralData output = NN19.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) + "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test20)
{
final NeuralData output = NN20.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) + "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}


//-----------------------------------------------------------------------------
for(NeuralDataPair pair: test21 )
{
final NeuralData output = NN21.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) +"   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test29 )
{
final NeuralData output = NN29.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17)+ "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------
for(NeuralDataPair pair: test23)
{
final NeuralData output = NN23.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) + "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test24)
{
final NeuralData output = NN24.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) + "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test25)
{
final NeuralData output = NN25.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) + "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}


//-----------------------------------------------------------------------------
for(NeuralDataPair pair: test26 )
{
final NeuralData output = NN26.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17) +"   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//-----------------------------------------------------------------------------

for(NeuralDataPair pair: test27 )
{
final NeuralData output = NN27.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17)+ "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}

//--------------------------------------------------------------------------------

for(NeuralDataPair pair: test28 )
{
final NeuralData output = NN28.compute(pair.getInput());

System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) +"," + pair.getInput().getData(2) + "," + pair.getInput().getData(3)+ "," + pair.getInput().getData(4) + "," + pair.getInput().getData(5)+ "," + pair.getInput().getData(6) + "," + pair.getInput().getData(7)+ "," + pair.getInput().getData(8) + "," + pair.getInput().getData(9)+ "," + pair.getInput().getData(10) + "," + pair.getInput().getData(11)+ "," +pair.getInput().getData(12) + "," + pair.getInput().getData(13)+ "," + pair.getInput().getData(14) + "," + pair.getInput().getData(15)+ "," + pair.getInput().getData(16) + "," + pair.getInput().getData(17)+ "   : actual=" + (output.getData(0)) + ",ideal=" + pair.getIdeal().getData(0));
}



	}
}

