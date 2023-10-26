import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Menu implements ActionListener, MouseListener{ //subclass so we can use save method here
	
	JFrame frame = new JFrame( "TTTGame" );
	ImageIcon icon = new ImageIcon( "icon.png" );
	JLabel  backL = new JLabel( new ImageIcon( "backmenu.png" ) );
	JLabel titleL = new JLabel( "TTTGame" );
	ImageIcon logoII = new ImageIcon( "icon.png" );
	JLabel logoL;
	
	ImageIcon classicII = new ImageIcon( "classicb.png" );
	JButton classicB; //add action when cursor touches the button
	ImageIcon classicII2 = new ImageIcon( "classicb2.png" );
	JButton classicB2; //add action when cursor touches the button
	ImageIcon ninoII = new ImageIcon( "ninob.png" );
	JButton ninoB; //add action when cursor touches the button
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
		
		/*logo image*/
		Image logoBefore = logoII.getImage();
		Image logoAfter = logoBefore.getScaledInstance( 110, 110, java.awt.Image.SCALE_SMOOTH );
		logoII = new ImageIcon( logoAfter );
		logoL = new JLabel( logoII );
		logoL.setBounds( 20, 20, 110, 110);
		
		/*logo image*/
		titleL.setBounds( 150, 40, 500, 110 );
		titleL.setFont( new Font( "Calibri", Font.BOLD, 90 ) );
		titleL.setForeground( Color.white );
		
		Image classicBefore = classicII.getImage();
		Image classicAfter = classicBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		classicII = new ImageIcon( classicAfter );
		classicB = new JButton( classicII );
		classicB.setBounds( 75, 160, 176, 60 );
		classicB.setContentAreaFilled( false );
		classicB.setFocusable( false );
		classicB.setBorder( null );
		
		Image classicBefore2 = classicII2.getImage();
		Image classicAfter2 = classicBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		classicII2 = new ImageIcon( classicAfter2 );
		classicB2 = new JButton( classicII2 );
		classicB2.setBounds( 75, 160, 176, 60 );
		classicB2.setContentAreaFilled( false );
		classicB2.setFocusable( false );
		classicB2.setBorder( null );
		classicB2.setVisible( false );
		
		classicB2.addActionListener( this );
		classicB.addMouseListener( this );
		classicB2.addMouseListener( this );
		
		Image classicBefore = classicII.getImage();
		Image classicAfter = classicBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		classicII = new ImageIcon( classicAfter );
		classicB = new JButton( classicII );
		classicB.setBounds( 75, 160, 176, 60 );
		classicB.setContentAreaFilled( false );
		classicB.setFocusable( false );
		classicB.setBorder( null );
		
		Image classicBefore2 = classicII2.getImage();
		Image classicAfter2 = classicBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		classicII2 = new ImageIcon( classicAfter2 );
		classicB2 = new JButton( classicII2 );
		classicB2.setBounds( 75, 160, 176, 60 );
		classicB2.setContentAreaFilled( false );
		classicB2.setFocusable( false );
		classicB2.setBorder( null );
		classicB2.setVisible( false );
		
		classicB2.addActionListener( this );
		classicB.addMouseListener( this );
		classicB2.addMouseListener( this );
		
		
		
		
		
		backL.add( logoL );
		backL.add( titleL );
		backL.add( classicB );
		backL.add( classicB2 );
		/*backL.add( ninoB );
		backL.add( ninoB2 );
		backL.add( rankB );
		backL.add( rankB2 );
		backL.add( exitB );
		backL.add( exitB2 );*/
		
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


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		if( e.getSource() == classicB ) {
			classicB2.setVisible( true );
			classicB.setVisible( false );
		}
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		if( e.getSource() == classicB2 ) {
			classicB2.setVisible( false );
			classicB.setVisible( true );
		}
		
	}

}
