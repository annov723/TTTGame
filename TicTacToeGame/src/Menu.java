import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Menu implements ActionListener{ //subclass so we can use save method here
	
	JFrame frame = new JFrame( "TTTGame" );
	ImageIcon icon = new ImageIcon( "icon.png" );
	JLabel  backL = new JLabel( new ImageIcon( "backmenu.png" ) );
	JLabel titleL = new JLabel( "TTTGame" );
	
	ImageIcon classicII = new ImageIcon( "classicb.png" );
	JButton classicB; //add action when cursor touches the button
	ImageIcon classicII2 = new ImageIcon( "classicb2.png" );
	JButton classicB2; //add action when cursor touches the button
	ImageIcon ninoII = new ImageIcon( "ninob.png" );
	JButton nionoB; //add action when cursor touches the button
	ImageIcon ninoII2 = new ImageIcon( "ninob2.png" );
	JButton ninoB2; //add action when cursor touches the button
	ImageIcon rankII = new ImageIcon( "rankb.png" );
	JButton rankB; //add action when cursor touches the button
	ImageIcon rankII2 = new ImageIcon( "rankb2.png" );
	JButton rankB2; //add action when cursor touches the button
	ImageIcon exitII = new ImageIcon( "exitb.png" );
	JButton exitB; //add action when cursor touches the button
	ImageIcon exitII2 = new ImageIcon( "exitb2.png" );
	JButton exitB2; //add action when cursor touches the button
	
	Menu( HashMap<String, Integer> dat, String name ){
		
		if( !dat.containsKey( name ) ) {
			dat.put( name, 0 );
		}
		
		/*Image before = playII.getImage();
		Image after = before.getScaledInstance( 146, 50, java.awt.Image.SCALE_SMOOTH );
		playII = new ImageIcon( after );
		playB = new JButton( playII );
		playB.setBounds( 234, 95, 146, 50 );
		playB.setContentAreaFilled( false );
		playB.setFocusable( false );
		playB.setBorder( null ); //no border when button mouse go through the button :)
		
		Image before2 = playII2.getImage();
		Image after2 = before2.getScaledInstance( 146, 50, java.awt.Image.SCALE_SMOOTH );
		playII2 = new ImageIcon( after2 );
		playB2 = new JButton( playII2 );
		playB2.setBounds( 234, 95, 146, 50 );
		playB2.setContentAreaFilled( false );
		playB2.setFocusable( false );
		playB2.setVisible( false );
		playB2.setBorder( null );
		
		playB2.addActionListener( this );
		playB.addMouseListener( this );
		playB2.addMouseListener( this );
		
		
		
		backL.add( messL );
		backL.add( txtF );
		backL.add( playB2 );
		backL.add( playB );
		backL.add( wrongL );*/
		
		backL.setLayout( null );
		backL.setBounds( 0, 0, 750, 500 );
		
		frame.add( backL );
		
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); //no additional action is needed
		frame.setSize( 750, 500 );
		frame.setResizable( false );
		frame.setLocationRelativeTo( null ); //the window appears on the center of the screen
		frame.setIconImage( icon.getImage() );
		frame.setLayout( null );
		frame.setVisible( true );
		
	}
	
	
	@Override
	public void actionPerformed( ActionEvent e ) {
		// TODO Auto-generated method stub
		
	}

}
