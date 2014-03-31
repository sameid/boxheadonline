//Item class

/*
This is the item class. This class is responsible for determining the properties
of each item dropped by an enemy or found. These properties include position, type
and many more. This items will give unique properties to other objects created in
other classes.

*/



import java.io.Serializable;
import java.util.*;

public class Item implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 4825422180355902204L;
	//Variables for the item class
	private int x, y;
	private int type;
	final static int ITEM_SIZE = 20; // size of powerups
	private boolean recieved;
	private long timeLastChecked;
	static Random randomGen = new Random (); // random generator
	final private int MAX_TIME = 30; // max counter to determine item time length on playing field in seconds (max is a minute)
	
	//Constructor method, creates an item based on where and enemy dies of a unique type
	public Item (int []enemyStat, int NUM_ITEM_TYPES, long currentTime, int level){
		recieved = false;
		x = enemyStat[1];
		y = enemyStat[2];
		int num = level/2 + 1;
		if (num > NUM_ITEM_TYPES){
			num = NUM_ITEM_TYPES;
		}
		type = (randomGen.nextInt (num));
		timeLastChecked = currentTime;
	}
	
	public boolean addTimer (long currentTime){
		boolean destroy = false;
		if(timeLastChecked + 1000*MAX_TIME <= currentTime){
			destroy = true;
		}
		return destroy;
	}
	
	
	//Gets the position of the item
	public int[] getItemPosition (){ // return coordinates to main to animate
		int [] coordinate = {x,y};
		return coordinate;
	}

	//returns the type of item
	public int getType() {
		return type;
	}
	
	public boolean ItemTouched (int charX, int charY, int charSize){ // runs checker to see if item is received
		boolean xContact = false;
		if (charX + charSize > x && charX + charSize < x + ITEM_SIZE){ // if character's right side makes contact with item
			xContact = true;
		}
		else if (charX > x && charX < x + ITEM_SIZE ){ // if character's left side makes contact with item
			xContact = true;
		}
		if (xContact){
			if (charY + charSize > y && charY + charSize < y + ITEM_SIZE){ // if contact is made from above
				recieved = true;
			}
			else if (charY > y && charY < y + ITEM_SIZE){// if contact is made from below
				recieved = true;
			}
		}
				
		return recieved;
	}

	//returns the max length the item can stay on map
	public int getMaxItemTime() {
		return MAX_TIME;
	}
	
}
