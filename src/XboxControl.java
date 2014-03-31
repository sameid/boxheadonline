


import java.io.File;
import java.io.IOException;

import ch.aplu.xboxcontroller.XboxController;
import ch.aplu.xboxcontroller.XboxControllerAdapter;

public class XboxControl {

	//Button constants
	final static int BUTTON_A = 0;
	final static int BUTTON_B = 1;
	final static int BUTTON_X = 2;
	final static int BUTTON_Y = 3;
	final static int START = 4;
	final static int LEFT_SHOULDER = 5;
	final static int RIGHT_SHOULDER = 6;
	final static int NULL = -1;
	
	XboxController controller;//From the APLU Xbox Gamepad Library Allowing us to use inputs from the Xbox 360 controller
	File test = new File("");//Used to copy the Xbox Controller java driver (.dll) file to the Applet output folder (/bin)
	
	private double magnitudeLeft;//Holds the magnitude of the left joystick of controller
	private double directionLeft;//Holds the direction that the left joystick pointing towards 
	private double magnitudeRight;//Holds the magnitude of the left joystick of controller
	private double directionRight;//Holds the direction that the left joystick pointing towards 
	private double leftTriggerMagnitude;
	private double rightTriggerMagnitude;
	private int button;//Holds which button of the Xbox controller is being pressed
	private boolean connected;//Used to check whether or not the xbox controller is connected
	
	
	
	public XboxControl (){
		//Using our previous copy file class to copy over the xbox controller java driver file so that it can be accessed from the output folder
		//Copy.copyFile(test.getAbsolutePath().substring(0, test.getAbsolutePath().length() - 3)+ "xboxcontroller.dll", test.getAbsolutePath()+ "/xboxcontroller.dll");	
		
		//Instantiating a new XboxController using the driver file
		controller = new XboxController ("xboxcontroller", 1, 10, 10 );
		System.out.println (controller.getVersion());
		
		//Set the dead zone of joystick(Basically the joysticks are extremely sensitive so we must increase the radius at which start reading so that the slightest input is not read in
		controller.setLeftThumbDeadZone(0.2);
		controller.setRightThumbDeadZone(0.2);
		controller.vibrate(10000, 10000, 1000);

	}
	
	public void getInput (){
		/*
		 * The APLU Xbox controller gamepad library is slightly odd int the way that it works.
		 * 
		 * There are only three classes but what happens is when I instantiate a new XboxController
		 * I need to add a Listener class which actually reads the input in. The problem is that the
		 * interface XboxControllerListener has a lot of required methods. Thats why the APLU developers
		 * created the Adapter class allowing for interface class to plug into the Adapter class, then we 
		 * can instantiate a Adapter as a listener and only need to inherit the methods required for our game.
		 * 
		 */
		controller.addXboxControllerListener(new XboxControllerAdapter()//Adds a listener in which we can over ride and only use the methods we need
		{
			//These methods gets us the Directions and MAgnitudes of both the left and right joysticks
			public void leftThumbDirection (double direction)
			{
				directionLeft=  direction;
			}
			
			public void leftThumbMagnitude (double magnitude)
			{
				magnitudeLeft = magnitude;
			}
			
			public void rightThumbDirection (double direction)
			{
				directionRight = direction;
			}
			
			public void rightThumbMagnitude (double magnitude)
			{
				magnitudeRight = magnitude;
			}
			/*
			public void rightTrigger (double value){
				setRightTriggerMagnitude(value);
			}
			
			public void leftTrigger (double value)
			{
				setLeftTriggerMagnitude(value);
			}
		*/	
			
			
			//Button inputs
			public void buttonB (boolean pressed)
			{
				if (pressed){
					
					setButton(BUTTON_B);
					}
			}
			
			public void buttonA (boolean pressed)
			{
				if (pressed){                           
				     
				setButton(BUTTON_A);	
				
				}
			}
			public void buttonX (boolean pressed)
			{
				if (pressed){
					
				setButton(BUTTON_X);
				}
			}
			
			public void buttonY (boolean pressed)
			{
				if (pressed){   
					
					setButton(BUTTON_Y);
					
					}
			}
			
			public void start (boolean pressed)
			{
				if (pressed){   
					
					setButton(START);
					
					}
			}
			
			public void leftShoulder (boolean pressed)
			{
				if (pressed){   
					
					setButton(LEFT_SHOULDER);
					
					}
			}
			public void rightShoulder (boolean pressed)
			{
				if (pressed){   
					
					setButton(RIGHT_SHOULDER);
					}
			}
			
		});

	}

	public void vibrate (int weaponType){
		if (weaponType == 0){
			controller.vibrate(20000, 20000);
		}
		else if (weaponType == 1){
			controller.vibrate(8000, 8000);
		}
		else if(weaponType == 2){
			controller.vibrate(60000, 60000);
		}		
	}
	
	public void stopVibration (){
		controller.vibrate(0, 0);
	}
	public void setMagnitudeLeft(int magnitudeLeft) {
		this.magnitudeLeft = magnitudeLeft;
	}

	public double getMagnitudeLeft() {
		return magnitudeLeft;
	}

	public void setDirectionLeft(int directionLeft) {
		this.directionLeft = directionLeft;
	}

	public double getDirectionLeft() {
		return directionLeft;
	}

	public void setMagnitudeRight(int magnitudeRight) {
		this.magnitudeRight = magnitudeRight;
	}

	public double getMagnitudeRight() {
		return magnitudeRight;
	}

	public void setDirectionRight(int directionRight) {
		this.directionRight = directionRight;
	}

	public double getDirectionRight() {
		return directionRight;
	}

	public void setButton(int button) {
		this.button = button;
	}

	public int getButton() {
		return button;
	}


	public boolean isConnected() {
		return connected = controller.isConnected();
	}

	public void setRightTriggerMagnitude(double rightTriggerMagnitude) {
		this.rightTriggerMagnitude = rightTriggerMagnitude;
	}

	public double getRightTriggerMagnitude() {
		return rightTriggerMagnitude;
	}

	public void setLeftTriggerMagnitude(double leftTriggerMagnitude) {
		this.leftTriggerMagnitude = leftTriggerMagnitude;
	}

	public double getLeftTriggerMagnitude() {
		return leftTriggerMagnitude;
	}
	

	
}
