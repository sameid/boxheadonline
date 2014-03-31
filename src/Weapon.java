//Weapon class

/*
This class is responsible for the weapons in the boxhead game. Each weapon has unique
characteristics such as the amount of ammo, damage, and speed. this class will
create the weapons used by the user in the game.
*/


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Weapon implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 6120429494650031929L;
//Variables for weapon class
	private int currentWeapon; // current weapon used
	// Weapon List
	// 1 - pistol
	// 2 - uzi
	// 3 - shotgun
	// 4 - grenade
	// 5 - turret
	// 6 - sniper
	// 7 - rpg
	// 8 - rpg turret
	private boolean [] availableWep; // stores available weapons user can use
	private int [] ammo; // stores remaining ammunition for each weapon
	final static int [] MAX_AMMO = {-1, 200, 12, 6, 1, 6, 6, 1}; // stores max ammo for each weapon type
	private ArrayList <Bullet> bullets; // stores bullets from weapon
	private ArrayList <Turret> turrets; // stores turrets
	private long timeLastShot;// real time shooting
	private long startOfVibrate;// real time shooting
	// constant delays
	static final int VIBRATION_LENGTH = 200;
	static final int WEAPON_1_DELAY = 350;
	static final int WEAPON_2_DELAY = 1;
	static final int WEAPON_3_DELAY = 1000;
	static final int WEAPON_4_DELAY = 1000;
	static final int WEAPON_5_DELAY = 1000;
	static final int WEAPON_6_DELAY = 700;
	static final int WEAPON_7_DELAY = 1000;
	static final int WEAPON_8_DELAY = 1000;
		
	//Constructor to create a new weapon by taking in the type (see above for types)
	public Weapon (int NUM_WEAPON_TYPES){
		availableWep = new boolean [NUM_WEAPON_TYPES];
		ammo = new int [NUM_WEAPON_TYPES];
		this.resetWeapons(NUM_WEAPON_TYPES);
	}
	
	//Switch weapons chronologically
	public void rotateWeapon(int NUM_WEAPON_TYPES) {
		do{
			this.currentWeapon++;
			if (NUM_WEAPON_TYPES == currentWeapon){
				currentWeapon = 0;
			}
		}
		while(!availableWep[currentWeapon]);
		
		
	}

	//Switch weapon in reverse
	public void rotateWeaponReverse(int NUM_WEAPON_TYPES) {
		do{
			this.currentWeapon--;
			if (currentWeapon < 0){
				currentWeapon = NUM_WEAPON_TYPES - 1;
			}
		}
		while(!availableWep[currentWeapon]);
	}
	
	public void chooseWeapon (int weapon){
		if (availableWep[weapon]){
			currentWeapon = weapon;
		}
	}

	//Returns the current weapon
	public int getWeapon() {
		return currentWeapon;
	}

	//Checks to see if any powerups are applied to the weapon
	public void powerUp (int itemBox){
		availableWep [itemBox] = true;
		this.setAmmo (itemBox);
	}

	//Resets the weapon
	public void resetWeapons (int NUM_WEAPON_TYPES){
		availableWep [0] = true;
		for (int i = 1; i < NUM_WEAPON_TYPES; i++){
			availableWep [i] = false;
		}
		currentWeapon = 0;
		ammo [currentWeapon] = MAX_AMMO [currentWeapon];
	}
	
	//Shoots the weapon by calling a bullet (bullet class)
	public boolean shootWeapon (double x, double y, double direction, long currentTime, boolean inRadians){
		boolean shot = false;
		boolean vibrate = false;
		if (currentWeapon == MainApplet.PISTOL){
			if(timeLastShot + WEAPON_1_DELAY <= currentTime ){ // shooting weapon delay
				if (!inRadians){
					bullets.add(new Bullet (x,y,currentWeapon, Math.toRadians(direction)));
				}
				else{
					bullets.add(new Bullet (x,y,currentWeapon, direction));
				}
				shot = true;
			}
		}
		else if (currentWeapon == MainApplet.MACHINE){
			if(timeLastShot + WEAPON_2_DELAY <= currentTime ){ // shooting weapon delay
				if (!inRadians){
					bullets.add(new Bullet (x,y,currentWeapon, Math.toRadians(direction)));
				}
				else{
					bullets.add(new Bullet (x,y,currentWeapon, direction));
				}
				shot = true;
			}
		}
		else if (currentWeapon == MainApplet.SHOTGUN){
			if(timeLastShot + WEAPON_3_DELAY <= currentTime){ // shooting weapon delay
				Random random = new Random();
				for(int i = 0; i < 7; i ++){
					double newDirection = random.nextDouble();
					if (!inRadians){
						bullets.add(new Bullet (x,y,currentWeapon, Math.toRadians(direction) - (newDirection-0.5)/3));
					}
					else{
						bullets.add(new Bullet (x,y,currentWeapon, direction -(newDirection-0.5)/3));
					}
				}
				shot = true;
			}
		}
		else if (currentWeapon == MainApplet.TURRET){
			if (timeLastShot + WEAPON_4_DELAY <= currentTime){
				turrets.add(new Turret (this, (int)x, (int)y, 0));
				//turrets.add(new Turret (this, MainApplet.getMouseX(), MainApplet.getMouseY(), 0));
				shot = true;
			}
		}
		else if (currentWeapon == MainApplet.SNIPER){
			if (timeLastShot + WEAPON_5_DELAY <= currentTime){
				if (!inRadians){
					bullets.add(new Bullet (x,y,currentWeapon, Math.toRadians(direction)));
				}
				else{
					bullets.add(new Bullet (x,y,currentWeapon, direction));
				}
				shot = true;
			}
		}
		else if (currentWeapon == MainApplet.GRENADE){
			if (timeLastShot + WEAPON_6_DELAY <= currentTime){
				if (!inRadians){
					bullets.add(new Bullet (x,y,currentWeapon, Math.toRadians(direction),currentTime));
				}
				else{
					bullets.add(new Bullet (x,y,currentWeapon, direction,currentTime));
				}
				shot = true;
			}
		}
		else if (currentWeapon == MainApplet.RPG){
			if (timeLastShot + WEAPON_7_DELAY <= currentTime){
				if (!inRadians){
					bullets.add(new Bullet (x,y,currentWeapon, Math.toRadians(direction)));
				}
				else{
					bullets.add(new Bullet (x,y,currentWeapon, direction));
				}
				shot = true;
			}
		}
		else if (currentWeapon == MainApplet.RPG_TURRET){
			if (timeLastShot + WEAPON_8_DELAY <= currentTime){
				turrets.add(new Turret (this, (int)x, (int)y, 1));
				//turrets.add(new Turret (this, MainApplet.getMouseX(), MainApplet.getMouseY(), 1));
				shot = true;
			}
		}
		
		if (shot){
			startOfVibrate = currentTime;
			vibrate = true;
			timeLastShot = currentTime;
			MainApplet.shotSound(getWeapon());
			if (currentWeapon != MainApplet.PISTOL){
				ammo [currentWeapon]--;
			}
			if (ammo [currentWeapon] == 0){
				availableWep[currentWeapon] = false;
				this.rotateWeapon(availableWep.length);
				if (currentWeapon == 0){ // skip pistol
					int otherAvailableWeapons = 0;
					for (int i = 1; i < availableWep.length; i++){
						if (availableWep[i] == true){
							otherAvailableWeapons++;
						}
					}
					if (otherAvailableWeapons > 0){
						this.rotateWeapon(availableWep.length);
					}
				}
			}
		}
		return vibrate;
	}
	
	//Gets rid of collide detected bullet 
	public void bulletHit (int hit){
		bullets.remove(hit);
	}
	
	public void setAmmo (int weapon){
		ammo [weapon] = MAX_AMMO [weapon];
	}
	
	//Return the bullets to the user
	public ArrayList <Bullet> getBullets (){
		return bullets;
	}
	
	public void setBullets (ArrayList <Bullet> list ){
		this.bullets = list;
	}

	public void recieveItem(int itemType) {
		availableWep [itemType] = true;
		ammo [itemType] = MAX_AMMO[itemType];
	}
	
	public boolean checkVibrate (long currentTime){
		if (startOfVibrate + VIBRATION_LENGTH <= currentTime){
			return true;
		}
		return false;
	}
	
	public int getAmmo (){
		return ammo [currentWeapon];
	}

	public void setTurrets(ArrayList <Turret> turrets) {
		this.turrets = turrets;
	}

	public ArrayList <Turret> getTurrets() {
		return turrets;
	}
}
