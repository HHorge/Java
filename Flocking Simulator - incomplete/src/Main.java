
/**Make a canvas and put a bird on it**/

import javax.swing.*;
import java.util.ArrayList;

public class Main {
	public static int CANVAS_WIDTH = 1280;
	public static int CANVAS_HEIGHT = 720;
	public static ArrayList<Bird> arrayListOfBirds = new ArrayList<>();

	public static void main(String[] args) {

		/**make a canvas to draw on**/
		Canvas myCanvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		int numberOfBirdsAsInt;
		String userInputBirds, userInputColour;


		/**Checks if the user inputs an integer or not**/
		do {

			/**Prompts the user asking how many birds they would like in the simulation**/
			userInputBirds = JOptionPane.showInputDialog(null, "Please enter the number of birds you want in the simulation:\n(integer)");

		} while (!userInputBirds.matches(".*\\d.*"));

		/**Turns the user's string into an int**/
		numberOfBirdsAsInt = Integer.parseInt(userInputBirds);

		/**Prompts the user asking what colour they would like the birds to have**/
		userInputColour = JOptionPane.showInputDialog(null, "Please enter the colour you would like the birds to have:\n You can choose between blue, red, yellow, orange, cyan, magenta, black, and green");

		/**Initialises however many birds the user chose**/
		for (int i = 0; i < numberOfBirdsAsInt; i++) {
			arrayListOfBirds.add(new DynamicBird(myCanvas, arrayListOfBirds, userInputColour));
		}

		/**infinite while loop to keep the canvas continually updating**/
		while (true) {

			myCanvas.clear();

			for (Bird bird : arrayListOfBirds) {
				bird.updateForGivenTime(5);
			}

			myCanvas.repaintCanvas();
			DynamicBird.pause(25);
		}

	}
}


