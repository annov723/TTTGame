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
import javax.swing.border.LineBorder;

public class Login implements ActionListener, MouseListener{
	
	JFrame frame = new JFrame( "TTTGame" );
	ImageIcon icon = new ImageIcon( "icon.png" );
	ImageIcon playII = new ImageIcon( "continueb.png" );
	JButton playB;
	ImageIcon playII2 = new ImageIcon( "continueb2.png" );
	JButton playB2; //add action when button clicked
	JTextField txtF = new JTextField();
	JLabel messL = new JLabel( "name:" );
	JLabel wrongL = new JLabel();
	JLabel  backL = new JLabel( new ImageIcon( "backlogin.png" ) );
	
	
	Login(){
		
		/*name text*/
		messL.setBounds( 20, 35, 80, 35 );
		messL.setFont( new Font( "Calibri", Font.BOLD, 25 ) );
		messL.setForeground( Color.white );
		
		/*text field*/
		txtF.setBounds( 100, 30, 200, 40 );
		txtF.setFont( new Font( "Calibri", Font.BOLD, 25 ) );
		txtF.setHorizontalAlignment( JTextField.CENTER );
		txtF.setBorder( new LineBorder( Color.white, 5 ) );
		
		/*continue button*/
		Image before = playII.getImage();
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
		
		/*mistakes message*/
		wrongL.setBounds( 100, 74, 200, 20 );
		wrongL.setFont( new Font( "Calibri", Font.BOLD, 17 ) );
		wrongL.setHorizontalAlignment( JLabel.CENTER );
		wrongL.setForeground( Color.RED );
		wrongL.setVisible( false );
		

		
		backL.add( messL );
		backL.add( txtF );
		backL.add( playB2 );
		backL.add( playB );
		backL.add( wrongL );
		
		/*background picture label*/
		backL.setLayout( null );
		backL.setBounds( 0, 0, 420, 200 );
		
		frame.add( backL );
		
		/*whole window*/
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); //no additional action is needed
		frame.setSize( 420, 200 );
		frame.setResizable( false );
		frame.setLocationRelativeTo( null ); //the window appears on the center of the screen
		frame.setIconImage( icon.getImage() );
		frame.setLayout( null );
		frame.setVisible( true );
		
	}
	
	
	@Override
	public void actionPerformed( ActionEvent e ) {
		
		/**
		 * check if the name doesn't contain a ":" sign that is unacceptable (used to save a file properly)
		 * force user to input any name, even one character
		 * if everything is ok, close Login and open Menu
		 * pass all names and scores information (dat) to Menu
		 * max length of name is 20 characters
		 */
		if( e.getSource() == playB2 ) {
			String name = txtF.getText(); //put name from txtF to a string
			int a = name.indexOf( ':' );
			if( name.length() == 0 ) {
				wrongL.setText( "enter your name here" );
				wrongL.setVisible( true );
			}
			else if( name.length() > 20 ) {
				wrongL.setText( "name is too long >20" );
				wrongL.setVisible( true );
				txtF.setText( "" );
			}
			else if( a == -1 ) {
				frame.dispose(); //Login window disappears
				Menu menu = new Menu( name ); //Menu opens
			}
			else {
				wrongL.setText( "forbidden character \":\"" );
				wrongL.setVisible( true );
				txtF.setText( "" );
			}			
		}
	}

	
	
	@Override
	public void mouseEntered( MouseEvent e ) {
		if( e.getSource() == playB ) {
			playB2.setVisible( true );
			playB.setVisible( false );
		}
		
	}

	@Override
	public void mouseExited( MouseEvent e ) {
		if( e.getSource() == playB2 ) {
			playB2.setVisible( false );
			playB.setVisible( true );
		}
		
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

	
	
}
