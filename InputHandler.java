import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

	public InputHandler(Game1 game) {
		game.addKeyListener(this);
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		// Player 1 controls
		if (keyCode == KeyEvent.VK_W) {
			Game1.player1.playerUp = true;
		}
		if (keyCode == KeyEvent.VK_S) {
			Game1.player1.playerDown = true;
		}

		// Player 2 controls
		if (keyCode == KeyEvent.VK_UP) {
			Game1.player2.player2Up = true;
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			Game1.player2.player2Down = true;
		}

		// Other controls
		if (keyCode == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

		// Player 1 controls
		if (keyCode == KeyEvent.VK_W) {
			Game1.player1.playerUp = false;
		}
		if (keyCode == KeyEvent.VK_S) {
			Game1.player1.playerDown = false;
		}

		// Player 2 controls
		if (keyCode == KeyEvent.VK_UP) {
			Game1.player2.player2Up = false;
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			Game1.player2.player2Down = false;
		}

	}

	public void keyTyped(KeyEvent e) {

	}

}