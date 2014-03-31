import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;


public class OurListener extends PlaybackListener  {

	private boolean nowPlaying;
	
	public OurListener(){

	}
	
	public void playbackStarted(PlaybackEvent evt){
		this.setNowPlaying(true);
	}
	
	public void playbackFinished(PlaybackEvent evt){
		this.setNowPlaying(false);
	}



	public void setNowPlaying(boolean nowPlaying) {
		this.nowPlaying = nowPlaying;
	}

	public boolean isNowPlaying() {
		return nowPlaying;
	}	
	
}
