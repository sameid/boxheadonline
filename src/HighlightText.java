//Highlight text class

//This class is responsible for keeping track of when clickable text is being hovered
//over and clicked for actions too occur

import java.util.ArrayList;


public class HighlightText
{

    private int x;
    private int y;
    private int width = 250;
    private int height = 25;
    private boolean hover;
    private ArrayList < String > list = new ArrayList < String > ();
    private int position = 0;
    //Sets to -1 so would not be part of array
    private int positionHover = -1;
    private int positionClicked = -1;
    private int maxListSize = 0;

    //Constructor, only checks to see the x and y positions
    public HighlightText (int x, int y)
    {
	this.setX (x);
	this.setY (y);
    }


    //The following two methods get and set the x position
    public void setX (int x)
    {
	this.x = x;
    }


    public int getX ()
    {
	return x;
    }


    //The following two methods get and set the y position
    public void setY (int y)
    {
	this.y = y;
    }


    public int getY ()
    {
	return y;
    }


    //Checks where the mouse is clicked and returns the position of the mouse
    public int whereClicked ()
    {
	if (this.checkHover (MainApplet.getMouseX (), MainApplet.getMouseY ()) >= 0)
	{
	    if (MainApplet.getMouseClicked ())
	    {
		this.setPositionClicked (this.checkHover (MainApplet.getMouseX (), MainApplet.getMouseY ()));
		return positionClicked;
	    }
	}
	//set to -1 so will not be part of the array
	this.setPositionClicked (-1);
	return positionClicked;
    }


    //Checks to see if the text is being hovered over
    public int checkHover (int mouseX, int mouseY)
    {
	int num = 0;
	if (list.size () - position < this.maxListSize)
	{
	    num = list.size () - position;
	}
	else
	{
	    num = this.maxListSize;
	}

	for (int i = 0 ; i < num ; i++)
	{
	    //Makes sure that when the check is going on, it takes in consideration
	    //the size of the text (the area the array slot takes up on the screen)
	    if (mouseX >= x && mouseX <= x + width)
	    {
		if (mouseY >= y + (height * i) && mouseY <= y + (height * (i + 1)))
		{
		    hover = true;
		    this.setPositionHover (i);
		    //System.out.println ("Hover " + list.get (i));
		    return i;

		}
	    }
	}

	hover = false;
	//Sets to -1 so will not be part of the array
	this.setPositionHover (-1);
	return -1;
    }


    //The following two methods set and get the index position in the array
    public void setPosition (int position)
    {
	this.position = position;
    }


    public int getPosition ()
    {
	return position;
    }


    //Sets the array of text using positions
    public void setList (ArrayList < String > list)
    {
	this.list = list;
	this.setPosition (0);
	//sets to -1 so will not be part of the array
	this.setPositionClicked (-1);
    }


    //Adds the text to the array list
    public void addToList (String input)
    {
	this.list.add (input);
    }


    //The following two methods check which position of the array was clicked
    //after clicking on the text placed on screen from the array slot
    public void setPositionClicked (int positionClicked)
    {
	this.positionClicked = positionClicked;
    }


    public int getPositionClicked ()
    {
	return positionClicked;
    }


    //This method moves the scroll bar that lists any datatype that requires scrolling
    public void moveScrollBar (boolean clickDirection)
    {
	if (clickDirection)
	{
	    if (position != 0)
	    {
		position--;
	    }
	}
	else
	{
	    if ((position + maxListSize) < list.size ())
	    {
		position++;
	    }
	}
    }


    //The following method gets the position of the data sets in a scroll menu
    public String[] getList (int maxSize)
    {
	setMaxListSize (maxSize);
	String[] temp;
	int num;
	if (list.size () - position < maxSize)
	{
	    temp = new String [list.size () - position]; //scroll menu shows a max of 6 people
	    num = list.size () - position;
	}
	else
	{
	    temp = new String [maxSize]; //scroll menu shows a max of 6 people
	    num = maxSize;
	}

	for (int i = this.position ; i < position + num ; i++)
	{
	    temp [i - position] = this.list.get (i);
	}

	return temp;
    }


    //The following two methods get and set the position of the text being hovered over
    //by checking which slot in the array takes up that position on the screen
    public void setPositionHover (int positionHover)
    {
	this.positionHover = positionHover;
    }


    public int getPositionHover ()
    {
	return positionHover;
    }


    //The following two methods get and set the size of the list that can be displayed
    //on the screen at one time, this is different depending on which menu is displaying
    //the text
    public void setMaxListSize (int maxListSize)
    {
	this.maxListSize = maxListSize;
    }


    public int getMaxListSize ()
    {
	return maxListSize;
    }


	public void setWidth(int i) {
		// TODO Auto-generated method stub
		this.width = i;
	}
	
	public void setHeight(int i) {
		// TODO Auto-generated method stub
		this.height= i;
	}
	
	public int getHeight (){
		return height;
	}
	
	//Return all the data
	public ArrayList <String> getArrayList (){
		return list;
	}
	
}
