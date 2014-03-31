import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;


public class Message implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3032350960023659786L;
	private String sender;
	private String recipient;
	private String message;

	public Message (String sender, String recipient){
		setSender (sender);
		setRecipient (recipient);
	}


	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSender() {
		return sender;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getRecipient() {
		return recipient;
	}


	


	
}
