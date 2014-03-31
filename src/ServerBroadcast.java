import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.ArrayList;


public class ServerBroadcast {

	private int port;
	public ArrayList<String> list;
	private String message;
	private MulticastSocket socket;
	private InetAddress group;
	private DatagramPacket packet;

	public ServerBroadcast (int port){
		setPort(port);
		list = new ArrayList<String>();
	}


	public void scanForGames (){
		try{
			socket = new MulticastSocket(getPort());
			group = InetAddress.getByName("230.0.0.1");
			socket.joinGroup(group);

			byte[] buf = new byte[100];
			packet = new DatagramPacket(buf, buf.length);


			try{

				socket.receive(packet);
			

			String received = new String(packet.getData());

			int stringLength = 0;
			for (int i = 0 ; i < packet.getData().length ; i++){
				if (packet.getData()[i] == 0){
					char c = (char) packet.getData()[i] ;
					stringLength = i;
					break;
				}
			}
			String actual = "";

			for (int i = 0 ; i < stringLength; i++){
				actual += (char)packet.getData()[i];
			}
			if (list.indexOf(actual) == -1){
				list.add(actual.substring(0, actual.length()));
				System.out.println("Stored: "+list.get(list.size()-1));
			}
			socket.leaveGroup(group);
			socket.close();
			}
			catch (SocketException e){
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	public void refresh (){
		list = null;
		list = new ArrayList<String>();
		System.out.println ("Game list refreshed!");
	}

	public void broadcastGame (){


		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket ();
			//System.out.println (message);
			InetAddress group = InetAddress.getByName("230.0.0.1");
			DatagramPacket packet;
			packet = new DatagramPacket(message.getBytes(), message.getBytes().length, group, getPort());
			socket.send(packet);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		socket.close();
	}


	public void setPort(int port) {
		this.port = port;
	}


	public int getPort() {
		return port;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public String getMessage() {
		return message;
	}

	public ArrayList<String> getList (){
		return list;
	}

	public DatagramPacket getPacket (){
		return packet;
	}

	public void setPacket (DatagramPacket p){
		packet = p;
	}

	public MulticastSocket getMultiSocket (){
		return socket;
	}

}
