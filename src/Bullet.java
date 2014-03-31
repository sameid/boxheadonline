import java.io.Serializable;



//Bullet class

/*This is the bullet class, this is responsible for taking in the properties of the bullets
including the guntype, which is the speed and damage, and the position of the bullet.
 */


public class Bullet implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3013500249647489670L;
	//Variables for the bullet class
	private double speedX;
	private double speedY;
	private double x;
	private double direction;
	private double y;
	private int gunType;
	static final double[] BULLET_SPEED = {15,15,15,15,15,10,10}; // slots according to number of weapons /*****/
	static final int[] BULLET_DAMAGE = {50,25,100,150,0,0,5}; // slots according to number of weapons /*****/
	static final int[] BULLET_SIZE = {10,10,10,10,10,10,30}; // slots according to number of weapons /*****/
	// Weapon List
	// 0 - pistol
	// 1 - uzi (turret)
	// 2 - shotgun
	// 3 - sniper
	// 4 - rpg (rpg turret)
	// 5 - grenade
	// 6 - enemy projectile


	private long startTime;
	static final int GRENADE_TIME_LIMIT = 2000;
	
	static final int STICKY_TIME_LIMIT = 1000;
	static final int STICKY_RADIUS = 20;
	
	
	//Constructor for the bullet
	public Bullet (double x, double y, int gunType, double direction)
	{
		if (gunType == MainApplet.RPG){
			gunType = 4;
		}
		else if (gunType == MainApplet.SNIPER){
			gunType = 3;
		}
		else if (gunType == MainApplet.GRENADE){
			gunType = 5;
		}
		else if (gunType == MainApplet.ENEMY_SHOT){
			gunType = 6;
		}
		this.setGunType (gunType);
		this.setStartTime(0);
		this.setX (x);
		this.setY (y);
		this.setDirection(direction);
	}
	
	public Bullet (double x, double y, int gunType, double direction, long currentTime)
	{
		if (gunType == MainApplet.GRENADE){
			gunType = 5;
			this.setStartTime(currentTime);
		}
		if (gunType == MainApplet.ENEMY_SHOT){
			gunType = 6;
			this.setStartTime(0);
		}
		this.setGunType (gunType);
		this.setX (x);
		this.setY (y);
		this.setDirection(direction);
	}


	public boolean detonateGrenade (long currentTime){
		if (startTime + GRENADE_TIME_LIMIT < currentTime){
			return true;
		}
		return false;
	}
	
	public boolean stopSticky (long currentTime){
		if (startTime + STICKY_TIME_LIMIT < currentTime){
			return true;
		}
		return false;
	}

	//The following 2 methods get and set the type of gun
	public void setGunType (int gunType)
	{
		this.gunType = gunType;
	}


	public int getGunType ()
	{
		return gunType;
	}


	//The following 2 methods set and get the x position of the bullet
	public void setX (double x)
	{
		this.x = x;
	}

	public double getX ()
	{
		return x;
	}
	
	public int getXAsInt ()
	{
		return ((int)x) - BULLET_SIZE[gunType]/2;
	}


	//The following 2 methods set and get the y position of the bullet
	public void setY (double y)
	{
		this.y = y ;
	}

	public double getY ()
	{
		return y;
	}


	public int getYAsInt ()
	{
		return ((int)y) - BULLET_SIZE[gunType]/2;
	}


	public void setDirection(double direction) {
		this.direction = direction;
	}


	public double getDirection() {
		return direction;
	}

	public void moveBullet (long currentTime){

		double value = 1;
		if (gunType == 5){
			//value=(int) -((currentTime - this.getStartTime())/1000 - 1);
			value= Math.pow(0.984, (currentTime - this.getStartTime())/10);
		}
		speedX = (value*BULLET_SPEED[gunType])*Math.sin(this.getDirection());
		speedY = (value*BULLET_SPEED[gunType])*Math.cos(this.getDirection());
		x += speedX; // move x
		y -= speedY; // move y

	}
	
	public int getBulletDamage (){
		return BULLET_DAMAGE [gunType];
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getStartTime() {
		return startTime;
	}
	
	public int getSize (){
		return BULLET_SIZE [gunType];
	}
}
