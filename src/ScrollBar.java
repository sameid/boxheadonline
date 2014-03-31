//ScrollButton Class

//This class is responsible for creating the scroll buttons used to move up and down
//information from highlight text

import java.awt.Image;


public class ScrollBar
{

	//Private variables for the method
	private int x; // scrolling x area
	private int y; // scrolling y area
	private int height; // scrolling window height
	private int width; // scrolling window width
	private int barPosition; // scroll bar y position
	private int maxSize; // max times the scroll bar can move the list
	private HighlightText list; // list that the scroll is attached to
	private boolean clicked; //Checks if the mouse is clicked
	private Image img; // scroll bar picture
	private String directory; // picture directory

	//Constructor
	public ScrollBar (int x, int y, int width, HighlightText list, String dir)
	{
		this.setX (x);
		this.setY (y);
		this.setWidth(width);
		this.setList(list);
		this.setDirectory(dir);
		this.setBarPosition(y);
	}

	// moves scroll bar if bar is clicked
	public int moveScrollBar ()
	{
		int difference = 0;
		if (!MainApplet.getMouseClicked()){ // if mouse is not pressed down
			clicked = false;
		}
		else{ // if mouse is pressed
			if (clicked){ // if the scroll bar was clicked
				// place scroll bar according to mouse location
				if (maxSize <= 0){
					this.setBarPosition(y);
				}
				else if (maxSize != 2){
					if (MainApplet.getMouseDraggedY() <= y + (height/maxSize)){
						this.setBarPosition(y); // put scroll bar on the top of scroll area
					}
					else if (MainApplet.getMouseDraggedY() > y + height - (height/maxSize)){
						this.setBarPosition(y + height - 2 * (height/maxSize)); // put scroll bar on the bottom of scroll area
					}
					else { // place scroll bar according to mouse location
						this.setBarPosition(MainApplet.getMouseDraggedY () - (height/maxSize));
					}
				}
				else { // when list is split to exactly half, it makes the scroll bar weird out. so when there are only 2 possible positions, ...
					if (MainApplet.getMouseDraggedY() <= y + (((height/6) * 5)/2)){
						this.setBarPosition(y); // put scroll bar on the top of scroll area
					}
					else if (MainApplet.getMouseDraggedY() > y + height - (((height/6) * 5)/2)){
						this.setBarPosition(y + height/6);  // put scroll bar on the bottom of scroll area
					}
					else { // place scroll bar according to mouse location
						this.setBarPosition(MainApplet.getMouseDraggedY () - (((height/6) * 5)/2));
					}
				}
				
			}
			// set list according to mouse location
			for (int i = 0 ; i < maxSize; i++){
				if(MainApplet.getMouseDraggedY() >= y + i * (height/maxSize)
						&& MainApplet.getMouseDraggedY() < y + (i + 1) * (height/maxSize)){
					difference = list.getPosition() - i;
					this.setListPosition(i);
				}
			}
		}

		return difference;
	}
	
	// move scroll bar according to mouse wheel
	public int moveScrollBar (int mouseWheelnotches, int prevClick)
	{
		if (mouseWheelnotches < 0){ // move up
			if (list.getPosition() + mouseWheelnotches >= 0){ // prevents going out of bounds
				this.setListPosition(list.getPosition() + mouseWheelnotches); // set list position
				prevClick -= mouseWheelnotches;
			}
		}
		else { // move down
			if (list.getPosition() + mouseWheelnotches <= list.getArrayList().size() - list.getMaxListSize()){ // prevents going out of bounds
				this.setListPosition(list.getPosition() + mouseWheelnotches); // set list position
				prevClick -= mouseWheelnotches;
			}
		}
		if (this.getBarHeight() != height){
			this.setBarPosition(y + list.getPosition() * ((height-this.getBarHeight())/(maxSize-1))); // set scroll bar
		}
		else if (maxSize == 2){
			this.setBarPosition(y + list.getPosition() * (height/6)); // set scroll bar
		}
		return prevClick;
	}
	
	// returns height of scroll bar
	public int getBarHeight (){
		if (maxSize >= 3){
			return (height/maxSize) * 2;
		}
		else if (maxSize == 2){
			return (height/6) * 5;
		}
		else{
			return height;
		}
	}
	
	//The following two methods return the height and width of the scroll bar
	public int getHeight ()
	{
		return height;
	}

	public int getWidth ()
	{
		return width;
	}
	
	//The following two methods get and set the x position of the scroll bar
	public void setX (int x)
	{
		this.x = x;
	}

	public int getX ()
	{
		return x;
	}


	//The following two methods get and set the y position of the scroll location
	public void setY (int y)
	{
		this.y = y;
	}


	public int getY ()
	{
		return y;
	}

	//The following two methods get and set the height
	public void setHeight (int height)
	{
		this.height = height;
	}

	//The following two methods sets the height
	public void setWidth (int width)
	{
		this.width = width;
	}

	//sets the boolean
	public void setClicked (boolean click)
	{
		this.clicked = click;
	}


	//Checks to see if the scroll bar is clicked
	public boolean isClicked ()
	{
		if (MainApplet.getMouseX () >= x && MainApplet.getMouseX () <= x + width)
		{
			if (MainApplet.getMouseY () >= y && MainApplet.getMouseY () <= y + height)
			{
				if (MainApplet.getMouseClicked ())
				{
					this.setClicked (true);
					MainApplet.setMouseDraggedY(MainApplet.getMouseY());
					return true;
				}
			}
		}
		this.setClicked (false);
		return false;
	}

	// sets max times the scroll bar can move the list
	public void setMaxSize() {
		this.maxSize = list.getArrayList().size() - list.getMaxListSize() + 1;
	}

	// gets max size
	public int getMaxSize() {
		return maxSize;
	}

	// set y of bar position
	public void setBarPosition(int barPosition) {
		this.barPosition = barPosition;
	}

	// sets y of bar position
	public int getBarPosition() {
		return barPosition;
	}

	// sets the highlight text object to be scrolled through
	public void setList(HighlightText list) {
		this.list = list;
		this.setHeight(list.getHeight() * list.getMaxListSize());
		this.setMaxSize();
	}

	// get the highlight text
	public HighlightText getList() {
		return list;
	}

	// set position of the list
	public void setListPosition(int listPosition) {
		list.setPosition(listPosition);
		if (listPosition==0){
			this.setBarPosition(y);
		}
	}

	// if bar area was clicked
	public boolean wasClicked() {
		return clicked;
	}

	// get/set bar image
	public void setImage(Image img) {
		this.img = img;
	}

	public Image getImage() {
		return img;
	}

	// get/set bar image directory
	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getDirectory() {
		return directory;
	}
}
