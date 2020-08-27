import javax.swing.JFrame;

public class Pong extends JFrame{
	
	//setting the constant values to be final and static
	//the using the variable name in place of the numbers
	//so that if we need to change these values, we only
	//have to do it here instead of searching the entire 
	//program for all the functions that rely on these values
	
	
	private final static String WINDOW_TITLE = "Pong";
	private final static int WINDOW_WIDTH = 800;
	private final static int WINDOW_HEIGHT = 600;
	
	//Pong constructor provides configuration 
	//for our window
	public Pong() {
		setTitle(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);//window size in pixels
		setResizable(false);
		setVisible(true);//if false the window will disappear
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//calling the window
		new Pong();

	}

}
