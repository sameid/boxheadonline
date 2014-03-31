import java.io.*;

public class Character implements Serializable{

	private static final long serialVersionUID = -6268911544366533976L;
	
	private double x;
	private double y;
	private int health;
	private int score;
	private double speedX;
	private double speedY;
	private double aimX;
	private double aimY;
	private int imageRow;
	private int imageCol;
	private int width;
	private int height;
	private double direction; // walking direction
	private double aimDirection; // walking direction
	private boolean radian;
	private Weapon weapon; // character weapon
	
	private double distanceTravelled;
	static final int FRAME_PER_DISTANCE = 40;
	
	public Character (){
		health = 100;
		setDistanceTravelled(0);
	}
	
	public void calculateMove (double magnitude, double direction){

		speedX = 10*magnitude*Math.sin(Math.toRadians(direction)) ;
		speedY = 10*magnitude*Math.cos(Math.toRadians(direction)) ;
		this.setDirection(direction);
	}
	
	public int getFrame (int dir){
		int frame = dir*4;
		

		int tempNum = 0;
		for (int i = 0; i < 4; i ++){
			if (distanceTravelled - FRAME_PER_DISTANCE*i > 0){
				tempNum = i;
			}
		}
		frame += tempNum;
		
		return frame;
	}
	
	public void moveCharacter (){
		x += speedX;
		y -= speedY;

		distanceTravelled = distanceTravelled +  Math.sqrt (Math.pow (speedX, 2) + Math.pow (speedY, 2));

		if (distanceTravelled - FRAME_PER_DISTANCE*4 > 0){
			distanceTravelled -= FRAME_PER_DISTANCE*4;
		}
		
		if (x < width/2){
			x = width/2;
		}
		else if (x > MainApplet.SCREEN_WIDTH - width/2){
			x=1016- width/2;
		}
		if (y < height/2){
			y = height/2;
		}
		else if (y > MainApplet.SCREEN_HEIGHT - height/2){
			y = 662 - height/2;
		}
		speedX = 0;
		speedY = 0;
	}

	public void aimDegrees(double magnitude, double direction){
		aimX = Math.sin(Math.toRadians(direction))*((magnitude))*100 + x;
		aimY = Math.cos(Math.toRadians(direction))*((magnitude))*-100 + y;
		this.setAimDirection(direction);
		setRadian(false);
	}
	
	public void aimRadians(double magnitude, double direction){
		aimX = Math.sin(direction)*((magnitude))*100 + x;
		aimY = Math.cos(direction)*((magnitude))*-100 + y;
		this.setAimDirection(direction);
		setRadian(true);	
	}
	
	public void damageCharacter (int enemyDamage){
		health -= enemyDamage;
	}
	
	public void healCharacter (int heal)
	{
		health += heal;
		if (health > 100){
			health = 100;
		}
	}
	
	
	public void setX(double x) {
		this.x = x;
	}

	public double getX() {
		return x;
	}

	public int getXAsInt() {
		return ((int) x) - (width/2);
	}

	
	public void setY(double y) {
		this.y = y;
	}

	public double getY() {
		return y;
	}
	
	public int getYAsInt() {
		return ((int) y) - (height/2);
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public double getHealth() {
		return health;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setImageRow(int imageRow) {
		this.imageRow = imageRow;
	}

	public int getImageRow() {
		return imageRow;
	}

	public void setImageCol(int imageCol) {
		this.imageCol = imageCol;
	}

	public int getImageCol() {
		return imageCol;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Weapon getWeapon() {
		return weapon;
	}


	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setAimX(double aimX) {
		this.aimX = aimX;
	}

	public double getAimX() {
		return aimX;
	}
	


	public int getAimXAsInt() {
		return ((int)aimX);
	}
	
	public int getAimYAsInt() {
		return ((int)aimY);
	}

	public void setAimY(double aimY) {
		this.aimY = aimY;
	}

	public double getAimY() {
		return aimY;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return height;
	}
	
	public boolean shootWeaponRadians (double direction, long currentTime){
		return weapon.shootWeapon(x, y, direction, currentTime, true);
	}
	
	public boolean shootWeaponDegrees (double direction, long currentTime){
		return weapon.shootWeapon(x, y, direction, currentTime, false);
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public double getDirection() {
		return direction;
	}

	public void recieveItem(int itemType) {
		if (itemType == 0){
			this.healCharacter(MainApplet.HEALTH_POWERUP);
		}
		else{
			this.getWeapon().recieveItem(itemType);
		}
	}

	public void setAimDirection(double aimDirection) {
		this.aimDirection = aimDirection;
	}

	public double getAimDirection() {
		return aimDirection;
	}

	public void setRadian(boolean radian) {
		this.radian = radian;
	}

	public boolean isRadian() {
		return radian;
	}

	public void setDistanceTravelled(double distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}

	public double getDistanceTravelled() {
		return distanceTravelled;
	}

}
