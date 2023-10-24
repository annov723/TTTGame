import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Login implements ActionListener{

	Data dat = new Data();
	
	JFrame frame = new JFrame( "TTTGame" );
	ImageIcon icon = new ImageIcon( "icon.png" );
	ImageIcon playII = new ImageIcon( "continueb.png" );
	JButton playB; //add action when cursor touches the button
	JTextField txtF = new JTextField();
	JLabel messL = new JLabel( "name:" );
	JLabel wrongL = new JLabel( "invalid sign \":\"");
	JLabel  backL = new JLabel( new ImageIcon( "backlogin.png" ) );
	
	
	Login(){
		
		messL.setBounds( 20, 35, 80, 35 );
		messL.setFont( new Font( "Calibri", Font.BOLD, 25 ) );
		messL.setForeground( Color.white );
		
		txtF.setBounds( 100, 30, 200, 40 );
		txtF.setFont( new Font( "Calibri", Font.BOLD, 25 ) );
		txtF.setHorizontalAlignment( JTextField.CENTER );
		txtF.setBorder( new LineBorder( Color.white, 5 ) );
		
		Image before = playII.getImage();
		Image after = before.getScaledInstance( 146, 50, java.awt.Image.SCALE_SMOOTH );
		playII = new ImageIcon( after );
		playB = new JButton( playII );
		playB.setBounds( 234, 95, 146, 50 );
		playB.setContentAreaFilled( false );
		playB.addActionListener( this );
		playB.setFocusable( false );
		
		wrongL.setBounds( 100, 74, 200, 20 );
		wrongL.setFont( new Font( "Calibri", Font.BOLD, 17 ) );
		wrongL.setHorizontalAlignment( JLabel.CENTER );
		wrongL.setForeground( Color.RED );
		wrongL.setVisible( false );
		
		
		
		backL.add( messL );
		backL.add( txtF );
		backL.add( playB );
		backL.add( wrongL );
		
		backL.setLayout( null );
		backL.setBounds( 0, 0, 420, 200 );
		
		frame.add( backL );
		
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
		
		if( e.getSource() == playB ) { //remember to check if the name doesn't contain a ":" sign that is unacceptable (used to save a file properly)
			String name = txtF.getText(); //put name from txtF to a string
			int a = name.indexOf( ':' );
			if( a == -1 ) {
				frame.dispose(); //Login window disappears	
				Menu start = new Menu( dat.loginInfo(), name ); //Menu opens
			}
			
			wrongL.setVisible( true );
							
		}
	}
	
	public void save() {
		dat.dataSave(); //this method will be called by the Menu object!
	}

	
	
}
