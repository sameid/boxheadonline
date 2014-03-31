import java.io.Serializable;


public class Turret implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3775600222779561283L;
	private int x;
	private int y;
	static final int SIZE = 30;
	private double direction;
	private Weapon weapon;
	static final int WEAPON_1_DELAY = 100;
	static final int WEAPON_2_DELAY = 1500;
	private int type;
	static final int [] MAX_AMMO = {100, 10};
	private long timeLastShot;// real time shooting
	static final int SHOOTING_DISTANCE = 200;
	private double shortestDistance;
	private int ammo;
	private boolean allowShoot;
	private int enemiesInVicinity;
	
	public Turret (Weapon weapon, int x, int y, int type){
		this.setX(x);
		this.setY(y);
		this.setWeapon(weapon);
		this.setDirection(Math.PI);
		this.setType(type);
		this.setAmmo(MAX_AMMO[type]);
		shortestDistance = SHOOTING_DISTANCE;
		timeLastShot = 0;
		allowShoot = false;
		this.setEnemiesInVicinity(0);
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}
	
	public void aim (double x, double y){
			double xDistance = x - this.x, yDistance = y - this.y;
			double hypotenuse = Math.sqrt (Math.pow (xDistance, 2) + Math.pow (yDistance, 2));
			boolean set = false;
			if (x >=0 && x <= MainApplet.SCREEN_WIDTH){
				if (y >= 0 && y <= MainApplet.SCREEN_HEIGHT){
					if (hypotenuse <= SHOOTING_DISTANCE){
						if (hypotenuse < shortestDistance){
							set = true;
							this.enemiesInVicinity++;
						}
					}
				}
			}
			
			if (set){
				double angle = Math.atan((this.getX() - x)/(this.getY() - (y + 10)));
				if (angle < 0){
					angle *= -1;
				}
				if (this.getX() - x <= 0){
					if (this.getY() - (y + 10) < 0){
						angle = Math.PI - angle;
					}
				}
				else if (this.getX() - x > 0){
					if (this.getY() - (y + 10) <= 0){
						angle = Math.PI + angle;
					}
					else if (this.getY() - (y + 10) > 0){
						angle = 2*Math.PI - angle;
					}
				}
				allowShoot = true;
				this.setDirection(angle);
				this.setShortestDistance(hypotenuse);
			}
	}
	
	public void resetTurret(){
		shortestDistance = SHOOTING_DISTANCE;
		allowShoot = false;
	}
	
	public boolean shoot(long currentTime){
		if (allowShoot){
			boolean shot = false;
			if (type == 0){
				if(timeLastShot + WEAPON_1_DELAY <= currentTime){ // shooting weapon delay
					weapon.getBullets().add(new Bullet (x,y - 10,MainApplet.MACHINE,direction)); // shoot uzi bullets
					shot = true;
					MainApplet.shotSound(MainApplet.MACHINE);
					
				}
			}
			else if (type == 1){
				if(timeLastShot + WEAPON_2_DELAY <= currentTime){ // shooting weapon delay
					weapon.getBullets().add(new Bullet (x,y - 10,MainApplet.RPG,direction)); // shoot rockets
					shot = true;
					MainApplet.shotSound(MainApplet.RPG);
				}
			}
			if (shot == true){
				timeLastShot = currentTime;
				ammo --;
				if (ammo == 0){
					return true;
				}
				resetTurret();
			}
			
		}
		return false;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public double getDirection() {
		return direction;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}

	public int getAmmo() {
		return ammo;
	}

	public void setShortestDistance(double shortestDistance) {
		this.shortestDistance = shortestDistance;
	}

	public double getShortestDistance() {
		return shortestDistance;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setEnemiesInVicinity(int enemiesInVicinity) {
		this.enemiesInVicinity = enemiesInVicinity;
	}

	public int getEnemiesInVicinity() {
		return enemiesInVicinity;
	}
	
	public void setAllowShoot (boolean allowShoot){
		this.allowShoot = allowShoot;
	}

	public boolean getAllowShoot (){
		return allowShoot;
	}
}
