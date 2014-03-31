


public class NetworkThread extends Thread{


	private Object send;//The object in which we will be sending to the client
	private Object receive;//The object that we will be receiving from the client

	private Server server;//Server to create a host for the session
	private Client client;//Client object to establish a connection the server

	private String serverIp;//The IP address of the server

	boolean hosting = false;
	boolean running = false;
	private boolean exit = false;

	public NetworkThread (){

		server = new Server (MainApplet.NETWORK_PORT);//Instantiate a server object that will listen to port 10000
		client = new Client (serverIp, MainApplet.NETWORK_PORT);//instantiate the client object with the specified ip address on port 10000


	}



	public void run (){
		System.out.println ("LAN Game System Started!");
		while (!exit){

			if (running){
				
				
				if (hosting){
					server.startServer();//Start the server (Basically checking to see if it will listen on the port specified
					System.out.println ("Your IP Address: " + server.getLocalIp());
					System.out.println ("Listening on port: " + server.getPort());
					server.listen();//Listen to port until there is a incoming connection
					if (server.isConnected()){//If the server was successfully connected to the client then begin the ServerThread which will send and receive
						while (server.isConnected()){
							receive = server.receiveObject();
						}
					}
				}
				else {
					while (client.isConnected()){
						receive = client.receiveObject();
					}


				}
			}
			
		}

		System.out.println ("LAN Game System Exited Successfully!");

	}

	public synchronized  Object receive (){
		return receive;
	}


	public synchronized  void send (Object arg){
		send = arg;	
	}



	public synchronized void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public synchronized Client getClient (){
		return client;
	}

	public synchronized void generalConnect(){
		client.connect();
	}
	
	public synchronized Server getServer (){
		return server;
	}


	public synchronized void setRunning (boolean running){
		this.running = running;
	}

	public synchronized boolean isRunning (){
		return running;
	}


	public synchronized void setHosting (boolean hosting){
		this.hosting = hosting;
	}

	public synchronized boolean isHosting (){
		return hosting;
	}



	public synchronized void setExit(boolean exit) {
		this.exit = exit;
	}



	public synchronized boolean isExit() {
		return exit;
	}



}
