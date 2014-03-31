//ScrollButton Class

//This class is responsible for creating the scroll buttons used to move up and down
//information from highlight text

import java.awt.Image;


public class ScrollButton
{

    //Private variables for the method
    private int x;
    private int y;
    private int height = 15;
    private int width = 15;
    private boolean clicked; //Checks if the mouse is clicked
    private boolean up; //Shows whether the up or down arrow was pressed (up being true)

    //Constructor
    public ScrollButton (int x, int y, boolean upDirection)
    {
	this.setX (x);
	this.setY (y);
	this.setDirection (upDirection);
    }


    //The following two methods return the height and width of the button
    public int getHeight ()
    {
	return height;
    }


    public int getWidth ()
    {
	return width;
    }


    //The following two methods get and set the x position of the button
    public void setX (int x)
    {
	this.x = x;
    }


    public int getX ()
    {
	return x;
    }


    //The following two methods get and set the y position of the button
    public void setY (int y)
    {
	this.y = y;
    }


    public int getY ()
    {
	return y;
    }


    //sets the boolean
    public void setClicked (boolean click)
    {
	this.clicked = click;
    }


    //Checks to see if the button is clicked in the right position, returns boolean as such
    public boolean isClicked (boolean allow)
    {
    	if (allow){
    		if (MainApplet.getMouseX () >= x && MainApplet.getMouseX () <= x + width)
    		{
    		    if (MainApplet.getMouseY () >= y && MainApplet.getMouseY () <= y + height)
    		    {
    			if (MainApplet.getMouseClicked ())
    			{
    			    this.setClicked (true);
    			    return true;
    			}
    		    }
    		}
    	}
    	this.setClicked (false);
    	return false;
    }


    //The following two methods set whether the button is the up or down arrow
    public void setDirection (boolean up)
    {
	this.up = up;
    }


    public boolean getDirection ()
    {
	return up;
    }
}
