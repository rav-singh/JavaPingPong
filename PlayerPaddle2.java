import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerPaddle2 {

	int paddleX;
	int paddleY;
	int paddleWidth =20;
	int paddleHeight = 45;
	int paddleSpeed = 6;
	
	Rectangle boundsBox;
	
	boolean player2Up= false;
	boolean player2Down= false;
	
	public PlayerPaddle2(int paddleX, int paddleY)
	{
		this.paddleX=paddleX;
		this.paddleY=paddleY;
		
		boundsBox = new Rectangle(paddleX, paddleY, paddleWidth, paddleHeight);
		boundsBox.setBounds(paddleX, paddleY, paddleWidth, paddleHeight);
		
	} // End of PlayerPaddle2()
	
	public void tick(Game1 game)
	{
		boundsBox.setBounds(paddleX, paddleY, paddleWidth, paddleHeight);
		
		if(player2Up && paddleY > 0)
		{
			paddleY -= paddleSpeed;
		}
		if(player2Down && paddleY< game.getHeight()-paddleHeight)
		{
			paddleY+=paddleSpeed;
		}
	} // End of tick()
	
	public void renderPaddle2(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(paddleX, paddleY, paddleWidth, paddleHeight);
	} // End of renderPaddle2()
	
} // End of class PlayerPaddle2()