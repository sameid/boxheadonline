

/*Profile Class
As part of the Boxhead game, a profile class has been included. This class is
responsible for saving, loading, storing information, uploading, and downloading
information for profiles. Each profile is to represent a user in the Boxhead game.

These users will have stored information including:
a username
a password
an E-Mail
a rank
a score
a service tag
and many more

The information for each user will be uploaded and downloaded from/to a server
through use of the game, but the users will be altered in a created file during
gameplay.
 */



import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Profile implements Serializable
{

	//Variables for each user
	private static final long serialVersionUID = 3713508431063421720L;
	private String nickname;
	private String name;
	private String rank;
	private int score;
	private int levelReached;
	private boolean online = false;
	private String status;

	public final static String DIRECTORY = "C:/RHS_USERS/"; 
	public final static String EXTENSION = ".rhprof";

	//Creates an empty profile
	public Profile ()
	{
		
	}



	public void setNickname (String nickname){
		this.nickname = nickname;
	}
	
	public String getNickname (){
		return nickname;
	}
	
	//The following 2 methods set and get the score for the user
	public void setScore (int score)
	{
		this.score = score;
	}


	public int getScore ()
	{
		return score;
	}


	//The following 2 methods set and get the rank for the user
	public void setRank (String rank)
	{
		this.rank = rank;
	}


	public String getRank ()
	{
		return rank;
	}



	//The following two methods set and tell if the user is online
	public void setOnline (boolean onlineStatus)
	{
		this.online = onlineStatus;
	}


	public boolean isOnline ()
	{
		return online;
	}






	//The following method saves the profiles created in this class to a file
	public void saveProfile ()
	{
		ObjectOutputStream outputStream = null;

		try
		{

			//Construct the LineNumberReader object
			outputStream = new ObjectOutputStream (new FileOutputStream (DIRECTORY+ name + "/"+ name + EXTENSION));
			outputStream.writeObject (this);

		}
		catch (Exception ex)
		{
			ex.printStackTrace ();

		}
		finally
		{
			//Close the ObjectOutputStream
			try
			{
				if (outputStream != null)
				{
					outputStream.flush ();
					outputStream.close ();
				}
			}
			catch (IOException ex)
			{
				ex.printStackTrace ();
			}
		}
	}


	//The following method loads the profiles created in this class from a file
	public static Profile loadProfile (String fileloc)
	{
		Profile temp = null;
		ObjectInputStream inputStream = null;
		try
		{
			//inputStream = new ObjectInputStream (new FileInputStream (fileloc + ".profile")); //Opening a object input stream to read in object files
			inputStream = new ObjectInputStream (new FileInputStream (DIRECTORY + fileloc  + "/" +fileloc + EXTENSION)); //Opening a object input stream to read in object files
			Object obj = null; // making a object to test the read in object
			while ((obj = inputStream.readObject ()) != null) // if the object read in is valid and has some sort of data then we can interpret it
			{
				if (obj instanceof Profile) // checking to if the object is an instance of this class (Character)
				{
					temp = ((Profile) obj); //Assigning it to a temporary object so that this method can return
				}
			}
		}
		catch (EOFException ex)
		{ //This exception will be caught when EOF is reached
			ex.printStackTrace();
		}
		catch (ClassNotFoundException ex)
		{
			ex.printStackTrace ();
		}
		catch (FileNotFoundException ex)
		{
			ex.printStackTrace ();
		}
		catch (IOException ex)
		{
			ex.printStackTrace ();
		}
		finally
		{
			//Close the ObjectInputStream
			try
			{
				if (inputStream != null)
				{
					inputStream.close ();
				}
			}
			catch (IOException ex)
			{
				ex.printStackTrace ();
			}
		}
		return temp;
	}


	//The following method searches the profile for the search option in the code
	public ArrayList <String> searchProfile (String searchTerm, String[] profiles, ArrayList<String> friends)
	{
		ArrayList < String > matchingProfiles = new ArrayList < String > ();

		try {
			for (int j = 0 ; j < profiles.length;j++)
			{
				String s1 = profiles[j]; 

			
					String temp1 = s1.toLowerCase();
					String temp2 = searchTerm.toLowerCase ();
					boolean disallow = false;

					if (friends != null)
					{
						for (int i = 0 ; i < friends.size () ; i++)
						{
							if (s1.equals (friends.get (0)))
							{
								disallow = true;
								break;
							}
						}
					}


					if (!disallow)
					{
						if (s1.equals (this.nickname))
						{
							disallow = true;
						}
					}
					if (temp1.indexOf (temp2) > -1 && !disallow)
					{
						matchingProfiles.add (s1);
					}
				}
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return matchingProfiles;
	}






	public void setStatus(String status) {
		this.status = status;
	}


	public String getStatus() {
		return status;
	}



	public void setLevelReached(int levelReached) {
		this.levelReached = levelReached;
	}



	public int getLevelReached() {
		return levelReached;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getName() {
		return name;
	}
}





