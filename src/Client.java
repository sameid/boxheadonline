

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;



//The Client class is subclass of Connection class because connection has multiple attributes used by a server and client
public class Client extends Connection{


	//Empty constructor
	public Client (){
		super ();//Calling empty super constructor
	}
	
	public Client ( String serverIP, int port){
		super(port);//Calls the constructor of Connection class setting the port
		setIp(serverIP);//Set the IP Address of the server in which we need to connect to

	}

	
	//Allows us to connect to the specified IP address on the specified port.
	public boolean connect (){
		try {

			
			/* Note:
			 * The InetAddress is an object the gets all the network information based on an IP Address, or Computer Name of any node on a network.
			 * We initially used computer names but as Mr. Tombs pointed out that Computer Names are not fail safe, sometimes you can't connect to a computer 
			 * or node just based on names as they are only used by head servers to recognize machines on a network. That is IP Address is fail safe.
			 * 
			 * The Socket object used to connect to a ServerSocket does not take in a IP Address, it takes in a InetAddress object, which is Java's representation of a IP Address.
			 * But the issue is that for some reason unexplained the InetAddress can only specify a IP Address in an array of byte. Each index in the array is each token between 
			 * the dot operators in a IP Address is one index. As you can see below this over complicates things. But is necessary.
			*/
		
			
			System.out.println(getIp());
			StringTokenizer token = new StringTokenizer (getIp(), ".");//So we get the IP Address specified by the constructor, and then we set the delimiter to the dot operator

			//Then we set each index in the array of byte to the each token in the StringTokenizer and also we have to cast each token from int to byte
			byte[] ipInByte = new byte[4];
			for (int i = 0 ; i < 4 ; i++){
				ipInByte[i] = (byte)(Integer.parseInt(token.nextToken()));
			}

			
			InetAddress ipInInet = InetAddress.getByAddress(ipInByte);//Create a new InetAddress based from the array of byte IP Address

			setSocket ( new Socket(ipInInet,getPort()));//Set the socket 

			
			//Then open object i/o streams from i/o streams from the socket object to the ServerSocket
		
			setOutputStream(new ObjectOutputStream(getSocket().getOutputStream()));
			setInputStream(new ObjectInputStream(getSocket().getInputStream()));

		
			System.out.println ("You are now connected...");
			setConnected(true);//Now we are connected to the server
			return isConnected();

		}
		// Any Exceptions then no exception can be established
		catch (UnknownHostException e) {
			System.out.println("Could not connect to host.");
			setConnected(false);
			return isConnected();

		} catch (IOException e) {
			System.out.println("Improper usage of IO Streams.");
			setConnected(false);
			return isConnected();
		}
		catch (NumberFormatException e) {
			System.out.println("Wrong Input");
			setConnected(false);
			return isConnected();
		}
		catch (Exception e){
		System.out.println ("Undefined Problem");
		setConnected(false);
		return isConnected();
		}

	}
	
	//Allows us to disconnect from server
	public void disconnect (){

		//If we are connected then we can disconnect
		if (isConnected()){
			try {
				//Close the i/o streams
				getOutputStream().close();
				getInputStream().close();
				//Close the socket
				getSocket().close();
				setConnected (false);
			}
			//Just in case if there are any problems with closing the IO streams
			catch (IOException e) {

				System.out.println ("Could not close the connection properly");
			}
		}

	}

	//Send an object using the streams
	public void sendObject (Object send){
		
		if (isConnected()){
			try {
				getOutputStream().writeObject(send);//Send the object pass through to the Server
				getOutputStream().reset();
				
			} catch (IOException e) {
				System.out.println ("Could not send object");
			}
		}
	}
	
	
	public Object receiveObject (){
		

		//If we are connected then we can receive
		if (isConnected()){

        	try {
        		Object receive =  getInputStream().readObject();//Read objects from the stream and set the receivable to it
				if ( receive != null) //as long as the input stream is not null we can keep reading through the stream
				{
					return receive;// return the object received from the server
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
			
			
		}
		return null;
		
	}
	

}
