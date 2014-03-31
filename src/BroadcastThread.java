
public class BroadcastThread extends Thread {

	private boolean running;
	private boolean hosting;
	private boolean exit =  false;
	private ServerBroadcast sb;

	public BroadcastThread(){
		sb = new ServerBroadcast (4446);
	}

	public void run() {
		System.out.println ("Broadcast LAN System Started!");

		while(!exit){
			if (running){
				if (hosting){
					sb.broadcastGame();
				}
				else{
					sb.scanForGames();
				}
			}

			delay (2000);

		}
		System.out.println ("Broadcast LAN System Exited Successfully!");
	}


	public void delay (int delay){
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void setSb(ServerBroadcast sb) {
		this.sb = sb;
	}

	public synchronized ServerBroadcast getSb() {
		return sb;
	}

	public synchronized void setRunning(boolean running) {
		this.running = running;
	}

	public synchronized boolean isRunning() {
		return running;
	}

	public synchronized void setHosting(boolean hosting) {
		this.hosting = hosting;
	}

	public synchronized boolean isHosting() {
		return hosting;
	}

	public synchronized void setExit(boolean exit) {
		this.exit = exit;
	}

	public synchronized boolean isExit() {
		return exit;
	}

}
