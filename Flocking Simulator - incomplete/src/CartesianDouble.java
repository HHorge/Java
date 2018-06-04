/***************************************************************************  
* 
* CARTESIAN DOUBLE
* Class to store x and y coordinate pair as doubles.  
* 
***************************************************************************/ 
public class CartesianDouble
{
  private double xcoord, ycoord;

  /***************************************************************************  
  * CONSTRUCTOR
  ***************************************************************************/
  public CartesianDouble(double xValue, double yValue)
  {
    this.xcoord = xValue;
    this.ycoord = yValue;
  }
  /***************************************************************************  
  * GET X
  * Return the x coordinate
  ***************************************************************************/
//  public static double angle(CartesianCoordinate x, CartesianCoordinate y){
//
//
//    return angle;
//  }
  public double getX()
  {
    return this.xcoord;
  }

  /***************************************************************************  
  * GET Y
  * Return the y coordinate
  ***************************************************************************/
  public double getY()
  {
    return this.ycoord;
  }

  public void setX(double x)
  {
    this.xcoord = x;

  }

  public void setY(double y)
  {
    this.ycoord = y;

  }
  /***************************************************************************  
  * GET CARTESIAN
  * Returns a CartesianCoordinate object with integer x and y values
  ***************************************************************************/
  public CartesianCoordinate getCartesian()
  {
    return new CartesianCoordinate((int) this.xcoord, (int) this.ycoord);
  }
}