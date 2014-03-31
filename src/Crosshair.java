
public class Crosshair {

	private long startTimeOuter;
	private long startTimeInner;
	private long previousCurrent;

	final static int OUTSIDE_FRAME_LENGTH = 5;
	final static int INSIDE_FRAME_LENGTH = 6;
	
	final static int INSIDE_LENGTH = INSIDE_FRAME_LENGTH*180; // milliseconds before crosshair repeats
	final static int OUTSIDE_LENGTH = OUTSIDE_FRAME_LENGTH*90; // milliseconds before crosshair repeats
	
	
	public Crosshair (long startTime){
		this.setStartTimeOuter(startTime);
	}
	
	public int getOuterFrame (long currentTime){
		int time = (int) Math.floor((currentTime - this.getStartTimeOuter())/10); // in centiseconds (100 centiseconds in a second)
		int frame = 0;

		int tempNum = 0;
		for (int i = 0; i < 9; i ++){
			if (time - OUTSIDE_FRAME_LENGTH*i > 0){
				tempNum = i;
			}
		}
		frame += tempNum;
		
		return frame;
	}
	
	public int getInnerFrame (long currentTime){
		int time = (int) Math.floor((currentTime - this.getStartTimeInner())/10); // in centiseconds (100 centiseconds in a second)
		int frame = 0;

		int tempNum = 0;
		for (int i = 0; i < 18; i ++){
			if (time - INSIDE_FRAME_LENGTH*i > 0){
				tempNum = i;
			}
		}
		frame += tempNum;
		
		return frame;
	}
	
	public void freeze (long currentTime){
		long timeDifference = currentTime - this.getPreviousCurrent();
		this.setStartTimeInner(this.getStartTimeInner() + timeDifference);
		this.setStartTimeOuter(this.getStartTimeOuter() + timeDifference);
		this.setPreviousCurrent(currentTime);
	}
	
	public void checkFrameTime (long currentTime){
		int time = (int) Math.floor((currentTime - this.getStartTimeOuter())/10); // in centiseconds (100 centiseconds in a second)

		if (time - OUTSIDE_LENGTH/10 > 0){
			this.setStartTimeOuter(this.getStartTimeOuter() + OUTSIDE_LENGTH);
		}
		
		time = (int) Math.floor((currentTime - this.getStartTimeInner())/10); // in centiseconds (100 centiseconds in a second)
		
		if (time - INSIDE_LENGTH/10 > 0){
			this.setStartTimeInner(this.getStartTimeInner() + INSIDE_LENGTH);
		}
		this.setPreviousCurrent(currentTime);
	}

	public void setStartTimeOuter(long startTime) {
		this.startTimeOuter = startTime;
	}

	public long getStartTimeOuter() {
		return startTimeOuter;
	}

	public void setStartTimeInner(long startTimeInner) {
		this.startTimeInner = startTimeInner;
	}

	public long getStartTimeInner() {
		return startTimeInner;
	}

	public void setPreviousCurrent(long previousCurrent) {
		this.previousCurrent = previousCurrent;
	}

	public long getPreviousCurrent() {
		return previousCurrent;
	}
	
}
