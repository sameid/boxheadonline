import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;




public class MessageReceive extends Thread{


	boolean running = false;
	private ObjectInputStream receive;
	private Object object;
	private String[] searchableProfiles;
	private ArrayList <String> invites;
	private ArrayList <String> friends;
	private String[] allUsers;
private LiveNotification liveNotify;
	private boolean received;
	private boolean liveMessage;
	private boolean friendOnline;
	private boolean exit = false;



	public MessageReceive (){

	}

	public void run (){
		System.out.println ("Freeway Live Message System Started!");
		while (!exit){
			if (running){


				object =  receiveObject();


				
				if (object instanceof String)
				{
					String command = (String) object;
					if (command.equals("ap")){
						setSearchableProfiles((String[]) receiveObject());
					}
					else if (command.equals("cin")){
						System.out.println ("getting invites");
						setInvites((ArrayList<String>) receiveObject());
					}
					else if (command.equals("friends")){
						System.out.println ("gettin friends");
						setFriends ((ArrayList<String>) receiveObject());
					}
					else if (command.equals("sli")){
						
						setLiveNotify ((LiveNotification)receiveObject());
						setLiveMessage(true);
					}
					else if (command.equals("ve")){
						setFriendOnline ((Boolean)receiveObject());
					}
					else if (command.equals("al")){
						setAllUsers((String[]) receiveObject());
					}
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public Object receiveObject (){
		try {
			Object object1 =  receive.readObject();//Read objects from the stream and set the receivable to it
			if ( object1 != null) //as long as the input stream is not null we can keep reading through the stream
			{
				return object1;// return the object received from the client
			}
		} 
		//This exception is reached when it is done reading the object
		catch (EOFException ex){
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}

	public synchronized void setRunning (boolean running){
		this.running = running;
	}

	public synchronized boolean isRunning (){
		return running;
	}

	public synchronized void setReceive(ObjectInputStream receive) {
		this.receive = receive;
	}

	public synchronized ObjectInputStream getReceive() {
		return receive;
	}

	public synchronized Message getReceivedMessage() {
		return (Message) object;
	}

	public synchronized void setReceived(boolean received) {
		this.received = received;
	}

	public synchronized boolean isReceived() {
		return received;
	}

	public synchronized void setSearchableProfiles(String[] searchableProfiles) {
		this.searchableProfiles = searchableProfiles;
	}

	public synchronized String[] getSearchableProfiles() {
		return searchableProfiles;
	}

	public synchronized void setInvites(ArrayList<String> arrayList) {
		this.invites = arrayList;
	}

	public synchronized ArrayList<String> getInvites() {
		return invites;
	}

	public synchronized void setFriends(ArrayList <String> friends) {
		this.friends = friends;
	}

	public synchronized ArrayList <String> getFriends() {
		return friends;
	}


	public synchronized void setLiveMessage(boolean liveMessage) {
		this.liveMessage = liveMessage;
	}

	public synchronized boolean isLiveMessage() {
		return liveMessage;
	}



	public synchronized void setFriendOnline(boolean friendOnline) {
		this.friendOnline = friendOnline;
	}

	public synchronized boolean isFriendOnline() {
		return friendOnline;
	}

	public synchronized void setLiveNotify(LiveNotification liveNotify) {
		this.liveNotify = liveNotify;
	}

	public synchronized LiveNotification getLiveNotify() {
		return liveNotify;
	}

	public synchronized void setExit(boolean exit) {
		this.exit = exit;
	}

	public synchronized boolean isExit() {
		return exit;
	}

	public synchronized void setAllUsers(String[] allUsers) {
		this.allUsers = allUsers;
	}

	public synchronized String[] getAllUsers() {
		return allUsers;
	}

}
