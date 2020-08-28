//JPanel is the actual black space the game will be designed in.
import javax.swing.JPanel;
//timer library
import javax.swing.Timer;
//Adds color functionality
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PongPanel extends JPanel implements ActionListener, KeyListener{
	
	//setting a constant variable for the background colour of the frame
	private final static Color BACKGROUND_COLOUR = Color.BLACK;
	//setting a constant variable for the timer delay
	private final static int TIMER_DELAY = 5;
	
	//pong panel constructor
	public PongPanel() {
        setBackground(BACKGROUND_COLOUR);
        //creating the timer object		
        //Video games generally use some form of timed loop to 
    	//provide synchronized steps for objects in the game 
    	//to move (animation) or react based on the input and 
    	//game logic.
        Timer timer = new Timer(TIMER_DELAY, this);
        timer.start();
    }
	
	//this method paint the objects to the screen
	//after we call the update method we will then call the 
	//repaint() which will draw the objects to the screen again
	//If the objects have moved, such as the ball, 
	//the repainting will happen every few moments giving us 
	//the illusion the ball is moving. 
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(20, 20, 100, 100);
		
	}
	
	public void update() {
		
	}
	//adding unimplemented methods adds these keyTyped
	//keyPressed, KeyReleased and actionPerformed methods
	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	//This will be your first time seeing the @Override keyword. 
	//The actionPerformed() method belongs to the ActionListener 
	//class and we want to customise the behaviour for our own 
	//purpose. We override the default behaviour of the 
	//actionPerformed() method – we use the @Override keyword 
	//to identify that we are doing this. Whenever we override a 
	//method from a parent class it is good practice to use 
	//@Override; this will make the compiler check that we are 
	//correctly overriding an existing method – and then we will 
	//receive a warning if we haven’t.
	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	//this method will be called on a loop every few moments; 
	//the time between calls is determined by our TIMER_DELAY 
	//value. This will give us a method to update the object 
	//positions and run our game logic.
	@Override
	public void actionPerformed(ActionEvent event) {
		//Calling the method "update" we created about
		//this method is called according to our timer function
		update();		
	}

}
