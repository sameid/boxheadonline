//By Sameid Usmani,and Isaiah Tan
//03/01/11
/*
 * Connection class used to handle either a Server or Client side of connection allowing for I/O Object Streams across
 * a local area network. With this we can send and receive objects across a LAN which allows for LAN Gaming.
 */


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Connection {

	private Socket socket;//Used establish a connection to a server or client from the java.net
	private String ip;//IP of the other computer (usually only used when the current local host is the client)
	private ObjectOutputStream outputStream;//An output stream to the other computer(Being able to write to the other computer)
	private ObjectInputStream inputStream;//An input stream from the other computer(Being able to read from the other computer)
	private int port;//The port on which we are establishing the connection upon
	private boolean connected;//To determine whether or not we connected to the computer
	
	public Connection (){
		
	}
	
	public Connection( int port){
		this.port = port;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}
	
	//Gets the local ip address of this current computer on the network
	public String getLocalIp(){
		try {
			InetAddress ipInInet = InetAddress.getLocalHost();//get the current InetAddress (Java representation of IP Address)
			String localIp = ipInInet.getHostAddress();//get the Address in string 
			return localIp;//Return as so
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void setPort(int port) {
		this.port = port;
	}


	public int getPort() {
		return port;
	}

	public void setSocket(Socket clientSocket) {
		this.socket = clientSocket;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setInputStream(ObjectInputStream inputStream) {
		this.inputStream = inputStream;
	}

	public ObjectInputStream getInputStream() {
		return inputStream;
	}

	public void setOutputStream(ObjectOutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public ObjectOutputStream getOutputStream() {
		return outputStream;
	}
	
}
