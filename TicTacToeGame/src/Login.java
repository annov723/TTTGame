import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login implements ActionListener{

	HashMap<String, Integer> dat = new HashMap<String, Integer>();
	
	JFrame frame = new JFrame( "TTTGame" );
	JButton playB = new JButton( "play" );
	JTextField txtF = new JTextField();
	JLabel messL = new JLabel( "name:" );
	ImageIcon background = new ImageIcon( "backlogin.png" );
	JLabel  backL = new JLabel( background );
	
	
	Login( HashMap<String, Integer> datImported ){
		dat = datImported;
		
		messL.setBounds( 50, 50, 100, 35 );
		messL.setFont( new Font( "Candara", Font.BOLD, 25 ) );
		messL.setForeground( Color.white );
		
		txtF.setBounds( 150, 50, 200, 25 );
		
		playB.setBounds( 125, 100, 100, 25 );
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
		frame.setLocationRelativeTo( null ); //the window appears on the center of the screen
		frame.setLayout( null );
		frame.setVisible( true );
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*if( e.getSource()==loginb ) { //remember to check if the name doesn't contain a ":" sign that is unacceptable (used to save a file properly)
			String uidS = idf.getText(); //pobieramy login do string'a
			String passS = String.valueOf(passf.getPassword() ); //jako, ¿e to z PasswordField to pobieramy przez valueOf
		
			//sprawedzamy czy login i has³o siê zgadzaj¹ z data w HashMap
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
