import java.util.ArrayList;

/**Modified code from the Java labs**/
public abstract class Bird
{
  private static ArrayList<Bird> allBirds;

  /***************************************************************************  
  * INSTANCE VARIABLES
  ***************************************************************************/ 
  private int currentAngle; // current angle that turtle is facing (in degrees)
  private CartesianDouble currentPosition; // current x,y coordinate
  private Canvas canvas; // private instance variable reference to a canvas object
  public String selectedColour;
  public static int CANVAS_WIDTH = 1280;
  public static int CANVAS_HEIGHT = 720;
  /***************************************************************************
  * CONSTRUCTOR
  * Initialises the new bird when we instantiate one
  ***************************************************************************/

  public Bird(Canvas canvas, ArrayList<Bird> birds, String colour)
  {
    this.canvas = canvas;
    this.selectedColour = colour;
    this.allBirds = birds;
    /**Generates a random starting position and initial angle for each bird**/
    this.currentPosition = new CartesianDouble((Math.random()*CANVAS_WIDTH) + 1, (Math.random()* CANVAS_HEIGHT) + 1);
    this.currentAngle = (int)(Math.random() * 360);
  }

  abstract void updateForGivenTime(int time);


  /***************************************************************************
  * PUBLIC MOVE METHOD
  * Method that moves the bird a number of pixels forward to a new position.
  ***************************************************************************/

  public void move(double pixels)
  {
    CartesianDouble newPosition;

    /**call innerMove function to move the turtle to a new position**/
    newPosition = this.calculateEndPoint(this.currentPosition, (int)pixels, this.currentAngle);

    /**Checks whether or not the bird is still on the canvas and changes it position accordingly**/
    if(newPosition.getX() >= CANVAS_WIDTH)
        {
          newPosition.setX(newPosition.getX() - CANVAS_WIDTH);
        }
        if(newPosition.getX() <= 0)
        {
          newPosition.setX(newPosition.getX() + CANVAS_WIDTH);
        }

        if(newPosition.getY() >= CANVAS_HEIGHT)
        {
          newPosition.setY(newPosition.getY() - CANVAS_HEIGHT);
        }

        if(newPosition.getY() <= 0)
        {
          newPosition.setY(newPosition.getY() + CANVAS_HEIGHT);
        }

    /**update turtle position state**/
    this.currentPosition = newPosition;

    /**Draw the bird in the new position**/
    this.drawingBird();
  }

  /***************************************************************************  
  * CALCULATE ENDPOINT METHOD
  * calculates a new coordinate given a start point, distance and bearing 
  ***************************************************************************/
  private CartesianDouble calculateEndPoint(CartesianDouble startPosition, int distance, int bearing)
  {
    double deltaX, deltaY; // relative distance moved x,y
    double newX, newY; // new positions after move x,y

    deltaX =  distance * Math.cos(Math.toRadians(bearing));
    deltaY =  distance * Math.sin(Math.toRadians(bearing));
    
    /**calculate new floating point coordinates**/
    newX = startPosition.getX() + deltaX;
    newY = startPosition.getY() + deltaY;

    /** make new position coordinate**/
    return new CartesianDouble(newX, newY);
  }
  /*************************************************************************** 
  * DRAW LINE METHOD
  * Private helper method to draw a line between two CartesianDouble 
  * points on to the canvas 
  ***************************************************************************/
  private void drawLine(CartesianDouble startPoint, CartesianDouble endPoint, String colour)
  {
      this.canvas.drawLineBetweenPoints(startPoint.getCartesian(), endPoint.getCartesian(), colour);
  }

  /*************************************************************************** 
  * DRAW BIRD METHOD
  * Uses the bird's internal private methods to draw a turtle shape.
  * Does not affect the actual position of the turtle because it doesn't
  * update the bird's currentPosition instance variable
  ***************************************************************************/
  public void drawingBird()
  {
    int localBearing;
    CartesianDouble localPosition, nextPosition;

    /**array holding angles and distances to draw a bird**/
    int[][] polarArray = new int[][]{ {  90, 90, 180, -90, 90, -90  },
                                      {  15, 15, 15, 15, 15, 15} };

    /**set local bearing to the same as the bird**/
    localBearing = this.currentAngle - 45;

    /**set local position reference to current position**/
    localPosition = this.currentPosition;

    for(int i=0; i<6 ; i++)
    {
      /**update local bearing**/
      localBearing  = localBearing + polarArray[0][i];

      /**calculate new position given local bearing and distance**/
      nextPosition = this.calculateEndPoint(localPosition, polarArray[1][i], localBearing);

      /**draw a line between local position and new position**/
      this.drawLine(localPosition,nextPosition, selectedColour);

      /**update local position reference to point at new position**/
      localPosition = nextPosition;
    }
  }

//  public static ArrayList<Bird> getAllBirds() {
//    return allBirds;
//  }
//
//  public int getCurrentAngle() {
//    return currentAngle;
//  }
//
//  public CartesianDouble getCurrentPosition() {
//    return currentPosition;
//  }
}