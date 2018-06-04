package stateandbehavior;

public class Location {
		int xPos = 0;
		int yPos = 0;
		int distance = 1;
		
		void up() {
			yPos -= distance;
		}
		
		void down() {
			yPos += distance;
		}
		
		void left() {
			xPos -= distance;
		}
		
		void right() {
			xPos += distance;	
		}
		
		int getX() {
			return xPos;
		}
		int getY() {
			return yPos;
		}
		public String toString(int pos) {
			return Integer.toString(pos);
		}
		
		public static void main(String[] args) {
			Location location = new Location();
			System.out.println(location.getX());
			location.down();
			location.down();
			location.left();
			location.right();
			location.right();
			location.down();
			/*System.out.format("X posisjon er: %d%n", location.getX());*/
			/*System.out.format("Y posisjon er: %d%n",location.getY());*/
			System.out.println(location.toString(location.getY()));
			
			
		}
}
