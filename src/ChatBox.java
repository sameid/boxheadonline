import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyListener;


public class ChatBox {

	private double x;
	private double y;
	private double xprev;
	private double yprev;
	private double xspeed;
	private double yspeed;

	private static double width = 250;
	private static double height = 20;

	private boolean close;
	private boolean maximized;
	private boolean offScreen;
	private boolean clicked;

	public final static int SEND_WIDTH = 235;
	public final static int SEND_HEIGHT = 45;
	public final static int SEND_XOFFSET = 8;
	public final static int SEND_YOFFSET = 145;

	public final static int CONVO_WIDTH = 235;
	public final static int CONVO_HEIGHT = 90;
	public final static int CONVO_XOFFSET = 8;
	public final static int CONVO_YOFFSET = 50;

	final static String NEW_LINE = "\n"; 

	private Message message;

	private TextField send;
	private TextArea convo;

	private String friend;

	public ChatBox(String sender, String recipient, KeyListener listener){
		x=0;
		y=0;
		clicked = false;
		maximized = false;
		convo= new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY );
		send = new TextField();
		message = new Message (sender , recipient);


		setFriend(recipient);//Set the friend that sent the message

		//Setting gui components
		getConvo().setEditable(false);
		getConvo().setBounds((int)getX() + ChatBox.CONVO_XOFFSET,(int) getY() + ChatBox.CONVO_YOFFSET, ChatBox.CONVO_WIDTH, ChatBox.CONVO_HEIGHT);
		getSend().setBounds((int)getX() + ChatBox.SEND_XOFFSET, (int)getY() + ChatBox.SEND_YOFFSET, ChatBox.SEND_WIDTH, ChatBox.SEND_HEIGHT);

		getConvo().addKeyListener(listener);
		getSend().addKeyListener(listener);


	}

	int i;
	public void animateMin (){
		i++;
		x -= xspeed*i ;
		y -= yspeed*i;

		getConvo().setBounds((int)getX() + this.CONVO_XOFFSET,(int) getY() + this.CONVO_YOFFSET, this.CONVO_WIDTH, this.CONVO_HEIGHT);
		getSend().setBounds((int)getX() + this.SEND_XOFFSET, (int)getY() + this.SEND_YOFFSET,this.SEND_WIDTH, this.SEND_HEIGHT);
	}

	public void animateMax (){
		i++;
		x += xspeed*i ;
		getConvo().setBounds((int)getX() + this.CONVO_XOFFSET,(int) getY() + this.CONVO_YOFFSET, this.CONVO_WIDTH, this.CONVO_HEIGHT);
		getSend().setBounds((int)getX() + this.SEND_XOFFSET, (int)getY() + this.SEND_YOFFSET,this.SEND_WIDTH, this.SEND_HEIGHT);


	}

	public void addText (String text){
		convo.append(text + NEW_LINE);
	}

	public boolean checkHover (int mouseX, int mouseY, int arg)
	{
		if (arg == 0){
			if (mouseX >= x && mouseX <= x+250){
				if (mouseY >= y && mouseY <= y+200){

					return true;
				}
			}
		}
		else if (arg == 1){
			if (mouseX >= x+255 && mouseX <= x+265){
				if (mouseY >= y+57 && mouseY <= y+67){

					return true;
				}
			}
		}
		else if (arg == 2){
			if (mouseX >= x+255 && mouseX <= x+265){
				if (mouseY >= y+35 && mouseY <= y+45){

					return true;
				}
			}
		}
		return false;
	}



	public boolean isClicked() {
		if (this.checkHover(MainApplet.getMouseMoveX(), MainApplet.getMouseMoveY(), 0))
		{
			if (MainApplet.getMouseClicked()){
				this.setClicked(true);
			}
		}
		return clicked;
	}



	public void setBox(double d, double e){

		if (d >= 0 && d <= 1016-275){
			setX(d);

		}
		if (e >= 0 && e <= 662-200){
			setY(e);
		}

		getConvo().setBounds((int)getX() + this.CONVO_XOFFSET,(int) getY() + this.CONVO_YOFFSET, this.CONVO_WIDTH, this.CONVO_HEIGHT);
		getSend().setBounds((int)getX() + this.SEND_XOFFSET, (int)getY() + this.SEND_YOFFSET,this.SEND_WIDTH, this.SEND_HEIGHT);



	}

	public void setX(double x) {
		this.x = x;
	}
	public double getX() {
		return x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getY() {
		return y;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getWidth() {
		return width;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getHeight() {
		return height;
	}

	public void setClicked(boolean arg) {
		this.clicked = arg;
	}

	public void setXprev(double xprev) {
		this.xprev = xprev;
	}

	public double getXprev() {
		return xprev;
	}

	public void setYprev(double yprev) {
		this.yprev = yprev;
	}

	public double getYprev() {
		return yprev;
	}

	public void setMaximized(boolean maximized) {
		i = 0;
		this.maximized = maximized;
	}

	public boolean isMaximized() {

		if (this.checkHover(MainApplet.getMouseMoveX(), MainApplet.getMouseMoveY(), 1))
		{
			if (MainApplet.getMouseClicked()){
				this.setMaximized(true);
			}
		}
		return maximized;
	}

	public boolean isClose() {

		if (this.checkHover(MainApplet.getMouseMoveX(), MainApplet.getMouseMoveY(), 2))
		{
			if (MainApplet.getMouseClicked()){
				this.setClose(true);
			}
		}
		return close;
	}


	public void setXspeed(double xspeed) {
		this.xspeed = xspeed;
	}

	public double getXspeed() {
		return xspeed;
	}

	public void setYspeed(double yspeed) {
		this.yspeed = yspeed;
	}

	public double getYspeed() {
		return yspeed;
	}

	public void setOffScreen(boolean offScreen) {
		this.offScreen = offScreen;
	}

	public boolean isOffScreen() {
		return offScreen;
	}

	public void setSend(TextField send) {
		this.send = send;
	}

	public TextField getSend() {
		return send;
	}

	public void setConvo(TextArea convo) {
		this.convo = convo;
	}

	public TextArea getConvo() {
		return convo;
	}

	public boolean setMessage() {

		if (send.getText().length() >0){
			message.setMessage(send.getText());
			return true;

		}
		return false;		
	}

	public Message getMessage() {
		return message;
	}

	public void setFriend(String friend) {
		this.friend = friend;
	}

	public String getFriend() {
		return friend;
	}

	public void setClose(boolean close) {
		this.close = close;
	}


}
