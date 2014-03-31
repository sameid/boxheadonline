import java.io.Serializable;
import java.util.Random;


public class Obstacle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4331586067064233985L;
	final static int SPAWN_RANDOM_1 = 0;
	final static int SPAWN_RANDOM_2 = 1;
	final static int SPAWN_RANDOM_3 = 2;

	final static int SPAWN_SIZE_1 = 30;
	final static int SPAWN_SIZE_2 = 35;
	final static int SPAWN_SIZE_3 = 40;
	
	private double x;
	private double y;
	private int width;
	private int height;
	Random random =  new Random ();
	

	public Obstacle (){
		x = random.nextInt(MainApplet.SCREEN_WIDTH - 60) + 30;
		y = random.nextInt(MainApplet.SCREEN_HEIGHT - 60) + 30;
		generateSize();
	}

	public void generateSize(){
		int randomNumGenerated = random.nextInt(3);
		
		if (randomNumGenerated == SPAWN_RANDOM_1){
			width = SPAWN_SIZE_1;
			height = SPAWN_SIZE_1;
		}
		else if (randomNumGenerated == SPAWN_RANDOM_2){
			width = SPAWN_SIZE_2;
			height = SPAWN_SIZE_2;
		}
		if (randomNumGenerated == SPAWN_RANDOM_3){
			width = SPAWN_SIZE_3;
			height = SPAWN_SIZE_3;
		}
	}

	public void setX(double x) {
		this.x = x;
	}


	public double getX() {
		return x;
	}

	public int getXAsInt() {
		return (int)(x - width/2);
	}


	public void setY(double y) {
		this.y = y;
	}


	public double getY() {
		return y;
	}

	public int getYAsInt() {
		return (int)(y - height/2);
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
	
}
