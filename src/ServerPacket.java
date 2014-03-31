import java.io.Serializable;
import java.util.ArrayList;




public class ServerPacket implements Serializable , Cloneable{
	

	private static final long serialVersionUID = 2676093341493853697L;
	
	private Character character;
	private Profile profile;
	private ArrayList <Enemy> enemies;
	private ArrayList <Obstacle> obstacles;
	private ArrayList <Item> allItems;
	private ArrayList <Item> itemsTouched;
	private ArrayList <Bullet> bullets;
	private ArrayList <Explosion> explosions;
	private int level;
	
	public ServerPacket(){
		
	}
	
	public void setCharacter(Character character) {
		this.character = character;
	}
	
	public Character getCharacter() {
		return character;
	}
	
	public void setEnemies(ArrayList <Enemy> enemies) {
		this.enemies = enemies;
	}
	
	public ArrayList <Enemy> getEnemies() {
		return enemies;
	}

	public void setObstacles(ArrayList <Obstacle> obstacles) {
		this.obstacles = obstacles;
	}

	public ArrayList <Obstacle> getObstacles() {
		return obstacles;
	}

	public void setAllItems(ArrayList <Item> allItems) {
		this.allItems = allItems;
	}

	public ArrayList <Item> getAllItems() {
		return allItems;
	}

	public void setItemsTouched(ArrayList <Item> itemsTouched) {
		this.itemsTouched = itemsTouched;
	}

	public ArrayList <Item> getItemsTouched() {
		return itemsTouched;
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

	public void setClientBullets(ArrayList <Bullet> bullets) {
		this.bullets = bullets;
	}

	public ArrayList <Bullet> getClientBullets() {
		return bullets;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setExplosionsToAdd(ArrayList <Explosion> explosions) {
		this.explosions = explosions;
	}

	public ArrayList <Explosion> getExplosionsToAdd() {
		return explosions;
	}
	

}
