import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login implements ActionListener{

	HashMap<String, Integer> dat = new HashMap<String, Integer>();
	
	JFrame frame = new JFrame();
	JButton playB = new JButton( "play" );
	JTextField txtF = new JTextField();
	JLabel messL = new JLabel( "Type your name:" );
	
	
	Login( HashMap<String, Integer> datImported ){
		dat = datImported;
		
		messL.setBounds( 125, 250, 250, 35 );
		messL.setFont( new Font( "Segoe UI", Font.BOLD, 25 ) );
		
		txtF.setBounds( 125, 100, 200, 25 );
		
		playB.setBounds( 125, 200, 100, 25 );
		playB.addActionListener( this );
		playB.setFocusable( false );
		
		frame.add( messL );
		frame.add( txtF );
		frame.add( playB );
		
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );  //exit unavailable for now
		frame.setSize( 420, 420 );
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
