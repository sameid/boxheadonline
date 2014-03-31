/*import java.applet.AudioClip;*/
import java.awt.Image;
import java.io.Serializable;


public class Explosion implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -911654723322447032L;
	private double x;
	private double y;
	final static int RADIUS = 100; // base on gif file, instant kill zone
	final static int RADIUS_2 = 135; // base on gif file, damage zone
	private int explosionPhase;
	private long startTime;
	final static int EXPLODE_LENGTH = 600; // milliseconds that explosion exists
	final static int DAMAGE = 300; // instant kill zone damage
	final static int DAMAGE_2 = 75; // damage zone damage
	

	final static int DAMAGE_TIME = 50; // milliseconds that explosion starts damaging
	private int type;
	final static int CHARACTER_DAMAGE = 15; // damage zone damage
	final static int CHARACTER_DAMAGE_2 = 10; // damage zone damage
	final static int CHARACTER_DAMAGE_3 = 5; // damage zone damage

	final static int GRENADE_EXPLODE_LENGTH = 600; // milliseconds that explosion exists
	final static int GRENADE_RADIUS = 80; // base on gif file, instant kill zone
	final static int GRENADE_RADIUS_2 = 120; // base on gif file, damage zone
	final static int GRENADE_RADIUS_3 = 170; // base on gif file, damage zone
	static final int GRENADE_DAMAGE = 100; 
	static final int GRENADE_DAMAGE_2 = 75; 
	static final int GRENADE_DAMAGE_3 = 50;
	
	final static int ENEMY_RADIUS = 95; // base on gif file, damage zone
	static final int ENEMY_DAMAGE = 50;
	
	static final int RPG_EXPLOSION = 0;
	static final int GRENADE_EXPLOSION = 1;
	static final int ENEMY_EXPLOSION = 2;
	
	
	public Explosion(double x, double y, long currentTime, int type){
		setExplosionPhase (0);
		setStartTime (currentTime);
		this.setX(x);
		this.setY(y);
		this.setType(type);
	}

	public boolean toRemove (long currentTime){
		if (startTime + EXPLODE_LENGTH < currentTime){
			return true;
		}
		return false;
	}
	
	public int getFrame (long currentTime){
		int time = (int) Math.floor((currentTime - this.getStartTime())/10); // in centiseconds (100 centiseconds in a second)
		int frame = 0;
		if (type == RPG_EXPLOSION){
			if (time < 16){
				frame = time;
			}
			else if (time < 20){
				frame = 16 +((time - 16)/2);
			}
			else if (time < 32){
				frame = 18 +((time - 20)/4);
			}
			else if (time < 50){
				frame = 21 +((time - 32)/6);
			}
			else{
				frame = 24;
			}		
		}
		else if (type == GRENADE_EXPLOSION){
			frame = time*2;
			if (time > 33/2){
				frame = 33;
			}
		}
		else if (type == ENEMY_EXPLOSION){
			if (time < 6){
				frame = time;
			}
			else if (time < 12){
				frame = 6 +((time - 6)/2);
			}
			else if (time < 15){
				frame = 9 +((time - 12)/3);
			}
			else if (time < 19){
				frame = 10 +((time - 15)/4);
			}
			else if (time < 34){
				frame = 11 +((time - 19)/5);
			}
			else{
				frame = 14;
			}
			
		}
		return frame;
	}
	
	public boolean startDamage (long currentTime){
		if (startTime + DAMAGE_TIME < currentTime){
			return true;
		}
		return false;
	}
	
	public int damageEnemy (Enemy enemy){
		if (enemy.getEnemyPosition()[0] > 0 && enemy.getEnemyPosition()[0] < MainApplet.SCREEN_WIDTH){
			if (enemy.getEnemyPosition()[1] > 0 && enemy.getEnemyPosition()[1] < MainApplet.SCREEN_HEIGHT){
				double xDistance = enemy.getEnemyPosition()[0] - this.getX(), yDistance = enemy.getEnemyPosition()[1] - this.getY();
				double hypotenuse = Math.sqrt (Math.pow (xDistance, 2) + Math.pow (yDistance, 2));
				if (type == GRENADE_EXPLOSION){
					if (hypotenuse <= Explosion.GRENADE_RADIUS + (enemy.getWidth() + enemy.getHeight())/4){
						return GRENADE_DAMAGE;
					}
					else if (hypotenuse <= Explosion.GRENADE_RADIUS_2 + (enemy.getWidth() + enemy.getHeight())/4){
						return GRENADE_DAMAGE_2;
					}
					else if (hypotenuse <= Explosion.GRENADE_RADIUS_3 + (enemy.getWidth() + enemy.getHeight())/4){
						return GRENADE_DAMAGE_3;
					}
				}
				else if (type == RPG_EXPLOSION){
					if (hypotenuse <= Explosion.RADIUS + (enemy.getWidth() + enemy.getHeight())/4){
						return DAMAGE;
					}
					else if (hypotenuse <= Explosion.RADIUS_2 + (enemy.getWidth() + enemy.getHeight())/4){
						return DAMAGE_2;
					}
				}
				else if (type == ENEMY_EXPLOSION){
					if (hypotenuse <= Explosion.ENEMY_RADIUS + (enemy.getWidth() + enemy.getHeight())/4){
						//return CHARACTER_DAMAGE_2;
						return ENEMY_DAMAGE;
					}
				}
			}
		}
		return 0;
	}

	public int damageCharacter (Character character){
		double xDistance = character.getX() - this.getX(), yDistance = character.getY() - this.getY();
		double hypotenuse = Math.sqrt (Math.pow (xDistance, 2) + Math.pow (yDistance, 2));
		if (type == GRENADE_EXPLOSION){
			if (hypotenuse <= Explosion.GRENADE_RADIUS + MainApplet.CHAR_SIZE/2){
				//return CHARACTER_GRENADE_DAMAGE;
				return CHARACTER_DAMAGE_3;
			}
			/*else if (hypotenuse <= Explosion.GRENADE_RADIUS_2 + MainApplet.CHAR_SIZE/2){
				return CHARACTER_GRENADE_DAMAGE_2;
			}*/
		}
		else if (type == RPG_EXPLOSION){
			/*if (hypotenuse <= Explosion.RADIUS + MainApplet.CHAR_SIZE/2){
				return CHARACTER_DAMAGE;
			}
			else */if (hypotenuse <= Explosion.RADIUS_2 + MainApplet.CHAR_SIZE/2){
				//return CHARACTER_DAMAGE_2;
				return CHARACTER_DAMAGE_3;
			}
		}
		else if (type == ENEMY_EXPLOSION){
			if (hypotenuse <= Explosion.ENEMY_RADIUS + MainApplet.CHAR_SIZE/2){
				//return CHARACTER_DAMAGE_2;
				return CHARACTER_DAMAGE_2;
			}
		}
		return 0;
	}
	
	public boolean chainExplode (Bullet bullet){
		double xDistance = bullet.getX() - this.getX(), yDistance = bullet.getY() - this.getY();
		double hypotenuse = Math.sqrt (Math.pow (xDistance, 2) + Math.pow (yDistance, 2));
		if (type == RPG_EXPLOSION){
			if (hypotenuse <= Explosion.RADIUS_2){
				return true;
			}
		}
		else if (type == GRENADE_EXPLOSION){
			if (hypotenuse <= Explosion.GRENADE_RADIUS_2){
				return true;
			}
		}

		return false;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getX() {
		return x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getY() {
		return y;
	}

	public void setExplosionPhase(int explosionPhase) {
		this.explosionPhase = explosionPhase;
	}

	public int getExplosionPhase() {
		return explosionPhase;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
}
