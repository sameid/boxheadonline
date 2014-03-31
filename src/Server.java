//Sameid Usmani, and Isaiah Tan
//03/01/11
/*
 * This is class is used for our Local Area Network multiplayer feature, what this allows for is an easy way for a
 * us to instantiate a server without having to figure out the complicated java.net methods every time we want to create 
 * a server. Once the main level programmer has simply created a server all they have to do is specify a port on which
 * they want to talk upon.  So once a client is connected, the server now has the ability to send and receive objects 
 * using object i/o streams to the client.
 */



import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;



public class Server extends Connection{

	private ServerSocket serverSocket;//The current computer will be hosting so it will use ServerSocket instead of Socket

	
	public Server (){
		super();
	}

	public Server ( int port){
		super( port);

	}

	public void startServer (){
	
		try {
			serverSocket = new ServerSocket(getPort());//Instantiate a socket on the port if there is an exception than that means that port cannot be used by the network
			//System.out.println ("Port: " + serverSocket.getLocalPort());
			System.out.println ("Server started!");
		} catch (IOException e) {
			System.out.println("Could not listen on port: " + getPort());

		}
	
	}
	

	
	public void listen (){
		
		/*
		 * Here we begin to listen to the port to see if there are going to be any incoming connections.
		 * The thread is paused at the accept() method until there is any sort of incoming connection.
		 */
	
	        try {
	        	System.out.println ("Waiting on incoming connections...");
	            setSocket ( serverSocket.accept());//Waiting on the port for activity
	            System.out.println ("Found and accpeted an incoming connection!");
	            setConnected (true);//If there was no exception then the connection was successful
	            //Open I/O streams to the client as so
	            setOutputStream(new ObjectOutputStream(getSocket().getOutputStream()));
	            setInputStream(new ObjectInputStream(getSocket().getInputStream()));
	        } catch (IOException e) {
	            System.out.println("Failed to connect to client.");
	            setConnected (false);
	        }
	}
	
	//Closing the connection to the client
	public void closeServer (){
		if (isConnected()){
			try {
				//Close both streams
				getOutputStream().close();
				getInputStream().close();
				//Then close the socket
				getSocket().close();
				//Close the serverSocket
				serverSocket.close();
				setConnected (false);
			} catch (IOException e) {

				System.out.println ("Could not close the connection properly");
			}
		}
	}
	
	//Send an object using the streams
	public void sendObject (Object send){
		
		if (isConnected()){
			try {
				getOutputStream().writeObject(send);//Send the object pass through to the client
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
					return receive;// return the object received from the client
				}
			} 
        	//This exception is reached when it is done reading the object
			catch (EOFException ex){
				ex.printStackTrace();
			} catch (IOException e) {
				System.out.println ("IO Exception");
			} catch (ClassNotFoundException e) {
				System.out.println ("This exception doesnt make sense to me yet...???");
			}
			
			
		}
		return null;
		
	}
	
	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}


	public ServerSocket getServerSocket() {
		return serverSocket;
	}

		
}
