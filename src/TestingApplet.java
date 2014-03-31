import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class TestingApplet extends Applet implements Runnable, KeyListener, MouseMotionListener, MouseListener{

	private static final long serialVersionUID = -1036959940525621791L;
	Thread t = new Thread (this);


	private Image dbImage;
	private Graphics dbg;

	URL base;
	Image img;

	double x1 = 95;
	double y1 = 295;


	double width = 250;
	double height = 50;

	double x1Speed;
	double y1Speed;

Image pp;
Image tell;
	public void init(){

		
		try {
			pp=getImage (new URL ("http://www.roadhousestudios.ca/"),"boxhead/MenuImages/film.png");
			
			tell = getImage ( getDocumentBase(), "loading.png");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resize (1016,662);
		setLayout(null);
		addKeyListener (this);
		addMouseListener(this);
		addMouseMotionListener(this);

	

		//img = getImage (base, "boxhead/MenuImages/film.png");


		x1Speed =Math.cos(Math.atan(y1/x1))/20;
		y1Speed =Math.sin(Math.atan(y1/x1))/20;


		t.start();
	}

	int accell;
	boolean firstAnimation= true;
	boolean secondAnimation= false;
	boolean thirdAnimation = false;

	public void run (){
		while (true){
			/*
			if (firstAnimation){
				boolean animating = false;
				if (x1>0 && y1>0){
					accell++;
					y1-=y1Speed*accell;
					x1-=x1Speed*accell;
					animating = true;
				}
				else if (!animating && (x1!=0 || y1!=0)){
					x1=0;
					y1=0;
					accell=0;
					firstAnimation = false;
					secondAnimation = true;
				}
			}
			else if (secondAnimation){
				boolean animating = false;
				if (width < 1016){
					accell++;
					width+=accell/5;
					animating = true;
				}
				else if (!animating && (width != 1016)){
					width = 1016;
					accell=0;
					secondAnimation = false;
					thirdAnimation = true;
				}
			}
			else if (thirdAnimation){
				boolean animating = false;
				if (height < 662){
					accell++;
					height+=accell/5;
					animating = true;
				}
				else if (!animating && (height != 662)){
					height = 662;
					accell=0;
					thirdAnimation = false;
				}
			}


*/

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		


			repaint ();
		}
	}

	public static String replaceSpace (String name){
		return name.replace(" ", "%20");
	}

	public void paint (Graphics g){


		//g.drawImage(tell, 0, 0, this);
		g.drawImage(pp, 0, 0, this);



	}

	public void update (Graphics g)
	{
		if (dbImage == null)
		{
			dbImage = createImage (this.getSize ().width, this.getSize ().height);
			dbg = dbImage.getGraphics ();
		}

		dbg.setColor (getBackground ());
		dbg.fillRect (0, 0, this.getSize ().width, this.getSize ().height);

		dbg.setColor (getForeground ());
		paint (dbg);

		g.drawImage (dbImage, 0, 0, this);

	}


	boolean enter = false;
	@Override
	public void keyPressed(KeyEvent ke) {


		int key = ke.getKeyCode(); // get keyboard character, convert to int
		// TODO Auto-generated method stub
		if (key == KeyEvent.VK_ENTER) {
			//Toolkit.getDefaultToolkit().beep(); // make a beep
			enter = true;
		}

	}



	@Override
	public void keyReleased(KeyEvent ke) {
		// TODO Auto-generated method stub
		int key = ke.getKeyCode(); // get keyboard character, convert to int

		if (key == KeyEvent.VK_ENTER) {
			enter = false;
		}

	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


	public static int mouseX;
	public static int mouseY;
	public static int mouseDragX;
	public static int mouseDragY;
	public boolean dragging;
	public static boolean clicked = false;

	public static int getMouseDragX(){
		return mouseDragX;
	}

	public static int getMouseDragY(){
		return mouseDragY;
	}

	public static int getMouseX(){
		return mouseX;
	}

	public static int getMouseY(){
		return mouseY;
	}

	public static boolean getMouseClicked (){
		return clicked;
	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mouseDragX =  arg0.getX();
		mouseDragY =  arg0.getY();
		dragging = true;


	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mouseX =  arg0.getX();
		mouseY =  arg0.getY();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		clicked = true;

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		clicked = false;
		dragging = false;

	}
}
