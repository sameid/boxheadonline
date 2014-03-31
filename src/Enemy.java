//Enemy Class

/*
This is the ememy class. This class is responsible for constructing the enemies
fought in the boxhead online game. Different attributes such as health, item
dreams and enemy location will be stored here.
 */



import java.io.Serializable;
import java.util.Random;

public class Enemy implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8481931636431722748L;
	private double x, y; // enemy coordinate
	static final int [] WIDTH = {20,20,40,20,20,20,40}, HEIGHT = {20,20,40,20,20,20,40}; // enemy size
	// enemy types
	// 0 - normal hp, normal speed - orange
	// 1 - normal hp, fast speed - red
	// 2 - high hp, slow speed, high damage - brown
	// 3 - normal hp, fast speed, explosive - white
	// 4 - normal hp, normal speed, shoots immobilising projectile - orange with green features
	// 5 - high hp, fast speed, double damage, spawns 3 reds on death - red with green features
	// 6 - high hp, slow speed, high damage, bullets deflect - brown with green features
	
	private int hp; // health points
	private boolean alive; // indicates if enemy is to be animated
	static Random randomGen = new Random (); // random generator
	static final int ITEM_DROP = 0; // constant to indicate what the integer is used for array location
	static final int YES = 1; // integer to replace boolean value
	static final int NO = 0; // integer to replace boolean value
	private double direction = 0; // angle of direction
	private double speed = 1.0;
	private int type; // zombie type
	static final int [] ATTACKING_DISTANCE = {30,30,30,30,400,30,30}; // distance in where the enemy would attack the character
	final static int [] MAX_HP = {100, 100, 300, 100, 100, 200, 500};
	final static int [] ENEMY_DAMAGE = {5, 5, 15, 5, 5, 10, 30};
	private double moveX = 0;
	private double moveY = 0;
	static final int [] ATTACK_DELAY = {300,300,600,300,2000,300,600}; // in milliseconds
	private long attackCounter = 0;
	private long startTime;

	static final int IMAGE_FRAME_DELAY_1 = 20; // frame delay for enemy type 1 (normal)
	static final int IMAGE_FRAME_DELAY_2 = 10; // frame delay for enemy type 2 (fast)
	static final int IMAGE_FRAME_DELAY_3 = 30; // frame delay for enemy type 3 (slow)

	/*private double distanceTravelled;
	static final int FRAME_PER_DISTANCE = 30;*/
	
	//spawns an enemy with default stats
	public Enemy (int type, int level)
	{
		if (type == 0 || type == 4){
			if (1 + (level - 1)*0.3 > 7){
				this.setSpeed(7);
			}
			else{
				this.setSpeed(1 + (level - 1)*0.3);
			}
		}
		else if (type == 1 || type == 3 || type == 5){
			if (4 + (level - 1)*0.3 > 10){
				this.setSpeed(10);
			}
			else {
				this.setSpeed(4 + (level - 1)*0.3);
			}
		}
		else if (type == 2 || type == 6){
			if (this.getSpeed() + (level - 1)*0.3 > 5){
				this.setSpeed(5);
			}
			else {
				this.setSpeed(-0.5 + (level - 1)*0.3);
			}
		}
		
		this.setType(type);
		hp = MAX_HP [type];
		x = -50;
		y = -50;
		alive = false;
	}

	public void checkFrameTime (long currentTime){
		int time = (int) Math.floor((currentTime - this.getStartTime())/10); // in centiseconds (100 centiseconds in a second)
		int animationLength = 0;
		if (type == 0 || type == 4){
			animationLength = IMAGE_FRAME_DELAY_1*4;
		}
		else if (type == 1 || type == 3 || type == 5){
			animationLength = IMAGE_FRAME_DELAY_2*4;
		}
		else if (type == 2 || type == 6){
			animationLength = IMAGE_FRAME_DELAY_3*4;
		}
		
		if (time - animationLength > 0){
			this.setStartTime(this.getStartTime() + animationLength*10);
		}
	}

	/*public int getFrame (int dir){
		int frame = dir*4;
		

		int tempNum = 0;
		for (int i = 0; i < 4; i ++){
			if (distanceTravelled - FRAME_PER_DISTANCE*i > 0){
				tempNum = i;
			}
		}
		frame += tempNum;
		
		return frame;
	}*/
	
	public int getFrame (int dir, long currentTime){
		int time = (int) Math.floor((currentTime - this.getStartTime())/10); // in centiseconds (100 centiseconds in a second)
		int frame = dir*4;
		
		if (type == 0 || type == 4){
			int tempNum = 0;
			for (int i = 0; i < 4; i ++){
				if (time - IMAGE_FRAME_DELAY_1*i > 0){
					tempNum = i;
				}
			}
			frame += tempNum;
		}
		else if (type == 1 || type == 3 || type == 5){
			int tempNum = 0;
			for (int i = 0; i < 4; i ++){
				if (time - IMAGE_FRAME_DELAY_2*i > 0){
					tempNum = i;
				}
			}
			frame += tempNum;
		}
		else if (type == 2 || type == 6){
			int tempNum = 0;
			for (int i = 0; i < 4; i ++){
				if (time - IMAGE_FRAME_DELAY_3*i > 0){
					tempNum = i;
				}
			}
			frame += tempNum;
		}
		
		return frame;
	}
	
	//Using a circular spawn zone, spawns enemy around the battlefield based on the size of the map
	public void enemySpawn (int maxX, int maxY, long currentTime)
	{		
		// square root (x^2 + y^2) = radius
		int radius = 10 + (int) Math.sqrt (Math.pow (maxX/2, 2) + Math.pow (maxY/2, 2)); // spawning radius (from center of map)
		int tempX, tempY; // stores x/y not yet calculated from origin (middle of map)

		tempX = randomGen.nextInt (radius); // spawning x (from center of map)
		if (randomGen.nextInt (2) == NO)
		{ // determine if x is positive or negative
			tempX = tempX * -1;
		}

		// square root (radius^2 - x^2) = y
		tempY = (int) Math.sqrt (Math.pow (radius, 2) - Math.pow (tempX, 2)); // spawning y (from center of map)
		
		if (randomGen.nextInt (2) == NO)
		{ // determine if y is positive or negative
			tempY = tempY * -1;
		}
		x = maxX / 2 + tempX; // spawning x
		y = maxY / 2 + tempY; // spawning y
		alive = true; // spawn
		this.setStartTime(currentTime);
	}


	//Checks the enemies surroundings and moves it based on such
	public boolean enemyCalculateMove (double charX, double charY, long currentTime)
	{
		boolean attacked = false;
		double xDistance = charX - x, yDistance = charY - y;
		double hypotenuse = Math.sqrt (Math.pow (xDistance, 2) + Math.pow (yDistance, 2));
		double relatedAngle;
		try{
			relatedAngle = Math.atan(yDistance/xDistance);
		}
		catch (java.lang.ArithmeticException e){
			relatedAngle = Math.PI/2;
			
			if (yDistance < 0){
				direction = (3*Math.PI)/2;
			}
			else{
				direction = Math.PI/2;
			}
		}
		if (relatedAngle < 0){
			relatedAngle *= -1;
		}
		
		if (xDistance < 0){
			if (yDistance < 0){
				direction = 2*Math.PI - relatedAngle;
			}
			else if (yDistance > 0){
				direction = relatedAngle;
			}
		}
		else if (xDistance > 0){
			if (yDistance < 0){
				direction = Math.PI + relatedAngle;
			}
			else if (yDistance > 0){
				direction = Math.PI - relatedAngle;
			}
		}

		this.setMoveX(speed*Math.cos(direction));
		this.setMoveY(speed*Math.sin(direction));
		moveX *= -1;
		moveY *= -1;
		
		// if close enough to attack
		if (hypotenuse <= ATTACKING_DISTANCE[type])
		{
			if (attackCounter == 0){
				attackCounter = currentTime;
			}
			if (type == 4){
				if (hypotenuse <= ATTACKING_DISTANCE[0]){
					this.setMoveX(0);
					this.setMoveY(0);
				}
			}
			else{
				this.setMoveX(0);
				this.setMoveY(0);
			}
			if (attackCounter + ATTACK_DELAY[type] <= currentTime){
				attackCounter = 0;
				attacked = true;
			}
		}
		return attacked;
	}
	
	//Checks the enemies surroundings and moves it based on such
	public boolean enemyCalculateMove (Character player, Character player2, long currentTime)
	{
		double radius = Math.sqrt (Math.pow ((player.getX() - x), 2) + Math.pow ((player.getY() - y), 2));
		double radius2 = Math.sqrt (Math.pow ((player2.getX() - x), 2) + Math.pow ((player2.getY() - y), 2));
		
		Character closerPlayer = null;
		
		if (radius < radius2){
			closerPlayer = player;
		}
		else{
			closerPlayer = player2;
		}
		
		double charX = closerPlayer.getX();
		double charY = closerPlayer.getY();

		return enemyCalculateMove (charX, charY, currentTime);
	}
	
	
	
	public void move (){
		x += moveX;
		y -= moveY;
		
		/*distanceTravelled = distanceTravelled +  Math.sqrt (Math.pow (moveX, 2) + Math.pow (moveY, 2));

		if (distanceTravelled - FRAME_PER_DISTANCE*4 > 0){
			distanceTravelled -= FRAME_PER_DISTANCE*4;
		}*/
	}
	
	
	//Takes in damage of enemy and applies it
	public int[] damageEnemy (double damage)
	{ // calculate health, drop item if dead
		hp -= damage; // get damaged
		//kills enemy when health runs out

		int[] enemyStat = {NO, (int) x, (int) y};
		
		if (hp <= 0)
		{
			alive = false;
			//Randomly decides if an item and which will be dropped
			int itemDrop = randomGen.nextInt (4);
			if (itemDrop == YES)
			{
				enemyStat [ITEM_DROP] = YES;
			}
		}
		

		return enemyStat;
	}


	//returns the enemys position
	public double[] getEnemyPosition ()
	{
		double[] coordinate = {x, y, direction};
		return coordinate;
	}

	//returns the enemy's position
	public int getWidth ()
	{
		return WIDTH [type];
	}
	//returns the enemys position
	public int getHeight ()
	{
		return HEIGHT[type];
	}
	
	
	//returns the enemies life status
	public boolean getEnemyStatus ()
	{ // tells game if enemy is still alive
		return alive;
	}
	
	//set the enemies life status
	public void setEnemyStatus (boolean alive)
	{ // tells game if enemy is still alive
		this.alive = alive;
	}


	public void setMoveX(double movedX) {
		this.moveX = movedX;
	}


	public double getMoveX() {
		return moveX;
	}


	public void setMoveY(double movedY) {
		this.moveY = movedY;
	}


	public double getMoveY() {
		return moveY;
	}


	public void setSpeed(double speed) {
		if (speed > 10){
			speed = 10;
		}
		this.speed = speed;
	}


	public double getSpeed() {
		return speed;
	}


	public void setType(int type) {
		this.type = type;
	}


	public int getType() {
		return type;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getStartTime() {
		return startTime;
	}
	
	public int getDamage (){
		return ENEMY_DAMAGE[type];
	}
	
	public void setEnemyPosition (double[] coordinate){
		x = coordinate[0];
		y = coordinate[1];
	}
}
