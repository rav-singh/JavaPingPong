import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;


public class PongBall {

	//location of ball
	int ballX, ballY;
	//size of ball
	int ballSize =20;
	//how fast the ball moves across the screen
	int ballSpeed = 4;
	//ball movement 
	int vx, vy;
	// the space of the object 
	Rectangle boundsBox;
	
	public PongBall(int ballX, int ballY)
	{
		this.ballX=ballX;
		this.ballY=ballY;
		
		vx=ballSpeed;
		vy=ballSpeed;
		
		//creates new boundaries for the ball
		boundsBox= new Rectangle (ballX, ballY, ballSize, ballSize);
		boundsBox.setBounds(this.ballX, this.ballY, this.ballSize, this.ballSize);
	} // End of PongBall() Constructor 
	public void points(Game1 game)
	{
		//sets the dimensions of the boundaries of the ball
		boundsBox.setBounds(ballX, ballY, ballSize, ballSize);
		
		/*
		 * generates the movement of the ball
		 * according to it's location on the screen
		 */
		if (ballX <= 0) {
			Game1.player2Score++;
			vx = ballSpeed;
			
		} else if (ballX + ballSize >= game.getWidth()) {
			Game1.player1Score++;
			vx = -ballSpeed;
			
		}

		if (ballY <= 0) {
			vy = ballSpeed;
		} else if (ballY + ballSize >= game.getHeight()) {
			vy = -ballSpeed;
		}

		ballX += vx;
		ballY += vy;

		paddleCollison(game);
		
	} // End of points ()
	private void paddleCollison(Game1 game)
	{
		if(boundsBox.intersects(Game1.player1.boundsBox))
		{
			vx= ballSpeed;
		}
		else if(boundsBox.intersects(Game1.player2.boundsBox))
		{
			vy= -ballSpeed;
		}
	} // End of paddleCollision()
	
	public void renderball(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(ballX, ballY, ballSize, ballSize);
	} // End of renderball()
} // End of public class PongBall()

