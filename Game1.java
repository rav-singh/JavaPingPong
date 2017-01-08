import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class Game1 extends Canvas implements Runnable {

	
	private static final long serialVersionUID = 1L;
	
	public static PlayerPaddle player1; // Player 1 
	public static PlayerPaddle2 player2; // Player 2 
	public static PongBall gameball; // Game Ball 
	
	static int player1Score; // Player 1 Score 
	static int player2Score; // Player 2 Score 
	
	InputHandler IH; // Declaration for Input Handler 
	JFrame frame; // Declaration for JFrame 
	
	private static final int WIDTH = 750;
	private static final int HEIGHT = WIDTH / 16 * 9;
	public static final Dimension windowSize = new Dimension(WIDTH, HEIGHT); // One variable for WIDTH and HEIGHT
	public String TITLE = "Java Pong Horizon"; // Title 
	
	public int ScreenWidth; // Screen Width 
	public int Screenheight; // Screen Height 
	
	static boolean gameRunning = false; // Initially gameRunning is declared as false 
	
	BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB); // new Buffered Image 
	
	

	public void run() {

		while (gameRunning) { // If gameRunning = true
			tick();
			render();

			try {
				Thread.sleep(7); // Slows down the game 
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	} // End of run()

	public synchronized void start() {
		gameRunning = true;
		new Thread(this).start();
	} // End start method

	public static synchronized void stop() {
		gameRunning = false;
		System.exit(0);
	} // End stop method 

	public Game1() {
		
		frame = new JFrame();
		
		setMinimumSize(windowSize);
		setPreferredSize(windowSize);
		setMaximumSize(windowSize);
		
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(TITLE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		IH = new InputHandler(this);
		
		player1 = new PlayerPaddle(10, 120);
		player2= new PlayerPaddle2(735, 120);
		gameball = new PongBall(getWidth()/2, getHeight()/2);
		
	} // End of Game1()


	public void tick() {
		player1.tick(this);
		player2.tick(this);
		gameball.points(this);
		
	} // End of tick()

	public void render() {
		
		BufferStrategy bs = getBufferStrategy();
		if (bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.WHITE);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.drawString("Player 1: " + player1Score, 5, 10);
		g.drawString("Player 2: " + player2Score, getWidth() - 60, 10);
		
		
		player1.renderPaddle(g);
		player2.renderPaddle2(g);
		gameball.renderball(g);
		
		
		g.dispose();
		bs.show();
	} // End of render()

} // End of class Game1