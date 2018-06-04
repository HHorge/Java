import java.util.ArrayList;
import static java.lang.Thread.*;
/** Adds additional functionality to bird**/
/** Allowing it to move on its own by getting a speed and a time**/
class DynamicBird extends Bird
{
	private int currentSpeed;
	/**Sets the default speed and **/
	public DynamicBird(Canvas canvas, ArrayList<Bird> birds, String colour)
	{
		super(canvas, birds, colour);
		this.currentSpeed = 2;

	}
	/**Takes a given time and multiplies it with the speed of the bird to calculate how many pixels it should move**/
	public void updateForGivenTime(int time)
	{
		this.move(this.currentSpeed * time);
	}
	/**Delaying the updating of the canvas so as to give the impression of smooth movement**/
	public static void pause(int time) {
		try{
			sleep(time);
		} catch (InterruptedException e) {
			// Pass silently
		}
	}
}