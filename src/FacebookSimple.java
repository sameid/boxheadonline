import java.util.ArrayList;
import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.exception.FacebookOAuthException;
import com.restfb.types.FacebookType;
import com.restfb.types.Post;
import com.restfb.types.User;


public class FacebookSimple {

	public static String NEW_LINE = "\n";

	private FacebookClient fbc;
	private User fbuser;
	private String accessToken;


	public FacebookSimple (String at){

		this.accessToken = at;
		fbc = new DefaultFacebookClient(at);
		fbuser = fbc.fetchObject("me", User.class);
	}

	public boolean postMessage(String message){
		try{
			fbc.publish("me/feed", FacebookType.class,Parameter.with("message", message));

		}
		catch (FacebookOAuthException e){
			e.printStackTrace();
			System.out.println ("Message post was unsuccessful.");
			return false;
		}
		System.out.println ("Message posted.");
		return true;
	}

	public boolean postEndGameResults (String score, String levelReached){
		try{

			String posting = fbuser.getFirstName() + " has just finished owning zombies, in Boxhead Online!" + NEW_LINE +
			"Level: " + levelReached + NEW_LINE +"Score: " + score + NEW_LINE+ "Check it out at http://www.roadhousestudios.ca/";
			fbc.publish("me/feed", FacebookType.class,Parameter.with("message", posting));
		}
		catch (FacebookOAuthException e){
			e.printStackTrace();
			System.out.println ("Score could not be posted.");
			return false;
		}

		System.out.println ("Score posted.");
		return true;
	}

	public User getFacebookUser (){
		try{

			System.out.println ("Success user fetch.");
			return fbuser;
		}
		catch (FacebookOAuthException e){
			e.printStackTrace();
			System.out.println ("Could not receive user.");
			return null;
		}

	}

	public Post getMostRecentPost (){
		try{
			Connection<Post> is = fbc.fetchConnection("me/feed", Post.class);
			return is.getData().get(0);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public List<Post> getRecentPosts (){
		try{
			Connection<Post> posts = fbc.fetchConnection("me/feed", Post.class);
			List <Post> postInAL =  posts.getData();


			return postInAL;
		}
		catch (Exception  e){
			e.printStackTrace();
		}
		return null;
	}

	public List<Post> getNewsFeed (){
		try{
			Connection<Post> posts = fbc.fetchConnection("me/home", Post.class);
			List <Post> postInAL =  posts.getData();


			return postInAL;
		}
		catch (Exception  e){
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<String> getUserFriendsList (){
		try{

			Connection<User> friends = fbc.fetchConnection("me/friends", User.class);
			
			ArrayList <String> list = new ArrayList <String>();
			
			
			
			for (int i = 0; i < friends.getData().size(); i++){
				list.add(friends.getData().get(i).getName());
			}
			
			return list;

		}
		catch (Exception  e){
			e.printStackTrace();
		}
		return null;

	}

}
