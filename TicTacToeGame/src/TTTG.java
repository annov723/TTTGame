import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TTTG implements ActionListener{

	Random random  = new Random();
	JFrame frame = new JFrame();
	JPanel titlep = new JPanel();
	JPanel buttonp = new JPanel();
	JLabel txtl = new JLabel();
	JButton[] barray = new JButton[9];
	boolean p1_turn;
	
	TTTG(){
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize( 800, 800 );
		frame.getContentPane().setBackground( new Color( 50, 50, 50 ) );
		frame.setLayout( new BorderLayout() );
		frame.setVisible( true );
		
		txtl.setBackground( new Color( 25, 25, 25 ) );
		txtl.setForeground( new Color(  25, 255, 0 ) );
		txtl.setFont( new Font( "Ink Free", Font.BOLD, 75 ) );
		txtl.setHorizontalAlignment( JLabel.CENTER );
		txtl.setText( "TIC TAC TOE" );
		txtl.setOpaque( true );
		
		titlep.add( txtl );
		frame.add( titlep, BorderLayout.NORTH );
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void firstTurn() {
		
	}
	
	public void check() {
		
	}
	
	public void xwin( int a, int b, int c) {
		
	}
	
	public void owin( int a, int b, int c) {
		
	}
}
