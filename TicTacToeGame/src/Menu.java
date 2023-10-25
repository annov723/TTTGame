import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Menu implements ActionListener{ //subclass so we can use save method here


	HashMap<String, Integer> dat = new HashMap<String, Integer>();
	
	JFrame frame = new JFrame( "TTTGame" );
	ImageIcon icon = new ImageIcon( "icon.png" );
	JLabel  backL = new JLabel( new ImageIcon( "backmenu.png" ) );
	
	ImageIcon oneII = new ImageIcon( "oneb.png" );
	JButton oneB; //add action when cursor touches the button
	ImageIcon twoII = new ImageIcon( "tpb.png" );
	JButton twoB; //add action when cursor touches the button
	ImageIcon nineoneII = new ImageIcon( "nineoneb.png" );
	JButton nineoneB; //add action when cursor touches the button
	ImageIcon ninetwoII = new ImageIcon( "ninetwob.png" );
	JButton ninetwoB; //add action when cursor touches the button
	ImageIcon statsII = new ImageIcon( "statsb.png" );
	JButton statsB; //add action when cursor touches the button
	ImageIcon exitII = new ImageIcon( "exitb.png" );
	JButton exitB; //add action when cursor touches the button
	
	Menu( HashMap<String, Integer> hashImported, String name ){
		
		//first check if name exists or is a new one
		
		
	}
	
	
	@Override
	public void actionPerformed( ActionEvent e ) {
		// TODO Auto-generated method stub
		
	}

}
