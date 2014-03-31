//CustomButton class

//This class is responsible for dealing with buttons used in the program

import java.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;


public class CustomButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1583048956352407761L;
	//Variables for the object
	private int x;
	private int y;
	private int width = 250;
	private int height = 50;
	private Image buttonOrgImage; //Original button image
	private Image buttonHoverImage; //Button image if hovered over
	private String orgDirectory; //Directory of original image
	private String hoverDirectory; //Directory of hovered image
	private boolean hover;
	private String fileName;
	private boolean clicked;
	
	//Constructor method
	//takes in which button and position and saves directory
	public CustomButton (int x, int y , String fileName){
		this.setX(x);
		this.setY(y);
		this.setFileName(fileName);
		this.setOrgDirectory();
		this.setHoverDirectory();
	}

	
	
	//The following two methods get and set the x of the button
	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	//The following two methods get and set the y of the button
	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}
	
	//checks to see if the mouse is hovering over a button
	public boolean checkHover (int mouseX, int mouseY)
	{
		if (mouseX >= x && mouseX <= x+width){
			if (mouseY >= y && mouseY <= y+height){
			hover = true; //if button is being hovered, knows to change to hovered button
			return hover;
			}
		}
		
			hover = false;
			return hover;

	
	}


	//The following two methods get and set the file name of the button
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	//The following two methods set the original and hovered image of the custom buttons
	public void setButtonOrgImage(Image buttonOrgImage) {
		this.buttonOrgImage = buttonOrgImage;
	}

	

	public void setButtonHoverImage(Image buttonHoverImage) {
		this.buttonHoverImage = buttonHoverImage;
	}

	//Tells the user which of the buttons should be shown of the two original and hovered
	public Image getButtonImage(boolean hover) {
		if (hover) //from previous method, if mouse is above hover, knows to use hovered image
		{
		return buttonHoverImage;
		
		}
		else
		{
		return buttonOrgImage;
		}
	}

	//The following four methods get and set the Directory for the button
	public void setOrgDirectory() {
		this.orgDirectory =  "boxhead/MenuImages/menubuttons/noCursor/" +fileName; //saves image in folder with other original images
	}

	public String getOrgDirectory() {
		return orgDirectory;
	}

	public void setHoverDirectory() {
		this.hoverDirectory ="boxhead/MenuImages/menubuttons/cursor/" +fileName; //saves image in folder with other hovered images
	}

	public String getHoverDirectory() {
		return hoverDirectory;
	}

	//sets the instance variable boolean clicked
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	//Checks to see if mouse was clicked
	public boolean isClicked() {
		
		if (this.checkHover(MainApplet.getMouseX(), MainApplet.getMouseY()))
		{
			if (MainApplet.getMouseClicked()){
				this.setClicked(true);
				//System.out.println (fileName + " button was clicked");
				return clicked;
				
		}
			this.setClicked(false);
			return clicked;
	}
		this.setClicked(false);
		return clicked;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

}
