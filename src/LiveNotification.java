import java.io.Serializable;


public class LiveNotification implements Serializable {

	/**
	 * 
	 */
	public final static String ACCEPTED = "accepted";
	public final static String DECLINED = "declined";
	public final static String INVITE_SENT = "invite sent";
	public final static String MESSAGE_SENT = "message sent";
	public final static String MESSAGE_RECEIVED = "message received";
	public final static String INVITE_RECEIVED = "invite";
	public final static String REMOVED = "removed";
	public final static String ONLINE = "online";
	public final static String OFFLINE= "offline";
	
	
	private static final long serialVersionUID = 5302563889083930891L;
	private String user;
	private String notification;
	private String picUrl;
	private String picName;
	private Message message;
	
	public LiveNotification (String user, String notification, String picUrl, String picName){
		this.user = user;
		this.notification = notification;
		this.picUrl = picUrl;
		this.picName = picName;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public String getNotification() {
		return notification;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getPicName() {
		return picName;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
	
	
}
