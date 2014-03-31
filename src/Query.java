import java.io.Serializable;


public class Query implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1075984735696852777L;
	private String userName;
	private String userPass;
	
	public Query (){
		
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserPass() {
		return userPass;
	}
	
}
