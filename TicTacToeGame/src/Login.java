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

	HashMap<String, Integer> dat = new HashMap<String, Integer>();
	
	JFrame frame = new JFrame( "TTTGame" );
	ImageIcon icon = new ImageIcon( "icon.png" );
	ImageIcon playII = new ImageIcon( "continueb.png" );
	JButton playB; //add action when cursor touches the button
	JTextField txtF = new JTextField();
	JLabel messL = new JLabel( "name:" );
	JLabel  backL = new JLabel( new ImageIcon( "backlogin.png" ) );
	
	
	Login( HashMap<String, Integer> datImported ){
		dat = datImported;
		
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
		
		
		backL.add( messL );
		backL.add( txtF );
		backL.add( playB );
		
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
	public void actionPerformed(ActionEvent e) {
		
		/*if( e.getSource()==loginb ) { //remember to check if the name doesn't contain a ":" sign that is unacceptable (used to save a file properly)
			String uidS = idf.getText(); //pobieramy login do string'a
			String passS = String.valueOf(passf.getPassword() ); //jako, ¿e to z PasswordField to pobieramy przez valueOf
		
			//check if name doesn't exist, pass the name and the dat HashMap to the Menu object
			if( info.containsKey( uidS ) ){
				if( info.get( uidS ).equals( passS ) ) {
					messl.setForeground( Color.green );
					messl.setText( "login successful" );
					
					frame.dispose(); //znika LoginPage
					
					WelcomePage welcome = new WelcomePage( uidS ); //otwieramy nowe okno jak oba elementy HashMap pasuj¹
				}
				else {
					messl.setForeground( Color.red );
					messl.setText( "wrong password" );
				}
			}
			else {
				messl.setForeground( Color.red );
				messl.setText( "wrong username" );
			}
		}*/
		
	}

}
