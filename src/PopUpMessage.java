//Pop up message class

//This class is responsible for displaying a message based on the players situation

import java.awt.Image;


public class PopUpMessage {
	
 private String [] MESSAGE = {"PROFILE DOES NOT EXIST",
		 "INCORRECT PASSWORD",
		"PROFILE ALREADY EXISTS", 
		"LENGTH TOO SHORT", 
		"LENGTH TOO LONG", 
		"CLAN ALREADY EXIST", 
		"SELECT A PROFILE",
		"SELECT A CLAN",
		"ALREADY AN ADMIN", 
		"USER NOT AN ADMIN",
		"CANNOT KICK LEADER",
		"SELECT A LEAGUE", 
		"Unable to join game.", 
		"no internet connection",
		"roadhouse servers are busy.",
		"login to your facebook homie!",
		"Could not connect to freeway.",
		"Gamertag must be atleast 6 characters.",
		"Select a game.", "Your inbox is empty.", "You are logged on some where else..."};
	// Possible messages
	// 0 - profile does not exist
	// 1 - wrong password
	// 2 - profile exists
	// 3 - length too short
	// 4 - length too long
	// 5 - clan doesn't exist
	// 6 - profile not selected
	// 7 - clan not selected
	// 8 - already an admin
	// 9 - selected not an admin
	// 10 - cannot kick leader
	// 11 - league not selected
	
	//Position of the message
	final private int x = 40; // edit
	final private int y = 70; // edit
	
	private String message;
	
	//Constructor
	public PopUpMessage (){
		
	}

	//The following two methods get the x and y of the message
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	//The following two methods get and set the message
	public void setMessage(int messageType) {
		message = MESSAGE [messageType];
	}

	public String getMessage() {
		return message;
	}
	

}
