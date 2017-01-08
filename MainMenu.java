import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;

	int screenWidth = 400;
	int screenHeight = 250;
	
	int Buttonwidth = 100;
	int Buttonheight = 40;
	
	JButton PlayNow;
	JButton Quit;
	JLabel welcome;
	
	public MainMenu() {
		
		addButtons();
		addActions();
		
		welcome = new JLabel("Welcome To Java Horizons Pong Game", SwingConstants.CENTER);
		welcome.setForeground (Color.blue);
		welcome.setHorizontalAlignment(JLabel.CENTER);
	    welcome.setVerticalAlignment(JLabel.TOP);
		
	    welcome.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
	   
		getContentPane().setLayout(null);
		
		welcome.setBounds((screenWidth - Buttonwidth) / 100 , 5, screenWidth, screenHeight);
		PlayNow.setBounds((screenWidth - Buttonwidth) / 2 , 50, Buttonwidth, Buttonheight);
		Quit.setBounds((screenWidth - Buttonwidth) / 2 , 100, Buttonwidth, Buttonheight);
		
		getContentPane().add(welcome);
		getContentPane().add(PlayNow);
		getContentPane().add(Quit);
		
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(screenWidth, screenHeight);
		setTitle("Java Pong Horizons Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		
	} // End of MainMenu() 

	private void addButtons(){
		PlayNow = new JButton("Play Now");
		Quit = new JButton("Quit");
	} // End of addButtons() 
	
	private void addActions(){
		PlayNow.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent e) { // turn actionPerformed into a variable for usage 
				dispose();
				Game1 game = new Game1();
				game.start();
				}
		});
		
		Quit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
				System.exit(0);
				}
		});
		
			}
		
		}
