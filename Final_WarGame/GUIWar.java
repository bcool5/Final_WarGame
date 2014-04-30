import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Blake Colyer
 * CS 110
 * GUIWar
 *DRIVER AT BOTTOM OF PAGE
 */


public class GUIWar extends JFrame{
   //size of window
	private final int WINDOW_HEIGHT = 500;
	private final int WINDOW_WIDTH = 450;
	
	private JLabel title, status, label1,label2;
	private ImageIcon front1,front2, back;
	private PlayGame game;
	private Deck d1;
	

	
	public GUIWar() {
   
     
		//set title, add to panel
		title = new JLabel("Game of War");
		title.setFont(new Font ("HELVETICA", Font.BOLD, 24));
		//create a new panel
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.CYAN);
		//add the title to the panel
		panel3.add(title);
		
		
		// set window size
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		
		//specify an action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set layout
		setLayout(new BorderLayout());
		
		//create a flip button
		JButton button1 = new JButton("Flip Cards");
      button1.addActionListener(new ButtonListener());
		
		//add the button to the content pane
		add(button1,BorderLayout.SOUTH);
				
		
		//create 2 panels
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.GREEN);
		panel1.setBackground(Color.YELLOW);
      
			
		//create labels for player 1 and player 2 and status of game
		label1 = new JLabel("Player 1");
		label2 = new JLabel("Player 2");
		status = new JLabel("Game in Progress");
		panel3.add(status);
      
      
		
		//add two panel's to hold the cards
		add(panel1,BorderLayout.WEST);
		add(panel2, BorderLayout.EAST);
		add(panel3, BorderLayout.NORTH);
	
		//create ImageIcon for back of card
		back = new ImageIcon("back.jpg");
		//set back to label 1 and label 2
		label1.setIcon(back);
		panel1.add(label1);
		label2.setIcon(back);
		panel2.add(label2);
		
		//create instances of the classes
		d1 = new Deck();
		game = new PlayGame(d1);
      game.createHands();

		//display the window
		setVisible(true);
		
   }
   /**
   *ButtonListener 
   */
	
	public class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
		
		//if both players still have cards
  
		if(game.cardsRemainingPlayer1() > 0 && game.cardsRemainingPlayer2() > 0){
			game.flip();
         front1 = game.getCardP1().getPic();
         front2 = game.getCardP2().getPic();
         
    
         //for every flip show the front of the card
         label1.setIcon(front1);
         label2.setIcon(front2);
         
         //if player 1 wins
			if(game.getRoundWinner()== 1){
           
				status.setText("Player 1 wins");
			}
         //if player 2 wins
			else if(game.getRoundWinner() == 2){
            
				status.setText("Player 2 wins");
			}	
         //if it is a war
			else if(game.getRoundWinner() == 0){
				status.setText("Tie");
	      }
			
		}
      //if both players are out of cards
      else if(game.gameOver() == true){
         status.setText("Game over");
	
		}
 }  
 
 }  
	
	public static void main(String [] args){
   
		JFrame frame = new GUIWar();
    
	}

}
