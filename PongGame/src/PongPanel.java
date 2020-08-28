//JPanel is the actual black space the game will be designed in.
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;
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
import java.awt.Stroke;
import java.awt.BasicStroke;

public class PongPanel extends JPanel implements ActionListener, KeyListener{
	
	//setting a constant variable for the background colour of the frame
	private final static Color BACKGROUND_COLOUR = Color.BLACK;
	//setting a constant variable for the timer delay
	private final static int TIMER_DELAY = 5;
	GameState gameState = GameState.Initialising;
	Ball ball;
	Paddle paddle1;
	Paddle paddle2;
	
	
	
	public void createObjects() {
		ball = new Ball(getWidth(), getHeight());
		paddle1 = new Paddle(Player.One, getWidth(), getHeight());
		paddle2 = new Paddle(Player.Two, getWidth(), getHeight());
	}
	
	
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
		paintDottedLine(g);
		 if(gameState != GameState.Initialising) {
             paintSprite(g, ball);
             paintSprite(g, paddle1);
             paintSprite(g, paddle2);
         }
	}
	
	//paint the middle dotted line everytime this method is called
	public void paintDottedLine(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.setPaint(Color.WHITE);
        //using the width and height of the window, not hard coded values
        //so that if the window changes the line will change itself
        g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
        g2d.dispose();
		
	}
	
	public void update() {
		
		switch(gameState) {
		
        	case Initialising: {
        		createObjects();
        		gameState = GameState.Playing;
        		break;
        		}
        		case Playing: {
        		break;
        		}
        		case GameOver: {
        		break;
        		}
		}
	}
	
	private void paintSprite(Graphics g, Sprite sprite) {
		g.setColor(sprite.getColour());
		g.fillRect(sprite.getXPosition(), sprite.getYPosition(), sprite.getWidth(), sprite.getWidth());
	}
	
	
	//adding unimplemented methods in the error tool adds these keyTyped
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
		//repaints the graphics based on the new position data every time
		//this method is called
		repaint();
	}

}
