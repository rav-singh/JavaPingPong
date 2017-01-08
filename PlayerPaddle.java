import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerPaddle {

	int paddleX; // X coordinate of paddle 
	int paddleY; // Y coordinate for paddle 
	int paddleWidth =20;
	int paddleHeight = 45;
	int paddleSpeed = 6;
	
	Rectangle boundsBox;
	
	boolean playerUp= false;
	boolean playerDown= false;
	
	public PlayerPaddle(int paddleX, int paddleY)
	{
		this.paddleX=paddleX;
		this.paddleY=paddleY;
		
		boundsBox = new Rectangle(paddleX, paddleY, paddleWidth, paddleHeight);
		boundsBox.setBounds(paddleX, paddleY, paddleWidth, paddleHeight);
		
	} // End of PlayerPaddle()
	public void tick(Game1 game)
	{
		boundsBox.setBounds(paddleX, paddleY, paddleWidth, paddleHeight);
		
		if(playerUp && paddleY > 0)
		{
			paddleY -= paddleSpeed;
		}
		if(playerDown && paddleY< game.getHeight()-paddleHeight)
		{
			paddleY+=paddleSpeed;
		}
	} // End of tick()
	public void renderPaddle(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(paddleX, paddleY, paddleWidth, paddleHeight);
	} // End of renderPaddle()
	
} // End of class PlayerPaddle()