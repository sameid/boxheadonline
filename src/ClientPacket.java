
import java.io.Serializable;
import java.util.ArrayList;





public class ClientPacket implements Serializable, Cloneable{


	private static final long serialVersionUID = -6402335500524060118L;
	private Character character;
	private Profile profile;
	
	
	public ClientPacket(){
		
	}
	
	public void setCharacter(Character character) {
		this.character = character;
	}
	
	public Character getCharacter() {
		return character;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Profile getProfile() {
		return profile;
	}
	

	
	public Object clone (){
		
		
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
