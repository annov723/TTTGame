import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
		
		titlep.setLayout( new BorderLayout() );
		titlep.setBounds( 0, 0, 800, 100 );
		
		buttonp.setLayout( new GridLayout( 3, 3 ) );
		buttonp.setBackground( new Color( 0, 0, 0 ) );
		for( int i = 0; i < 9; i++ ) {
			barray[i] = new JButton();
			buttonp.add( barray[i] );
			barray[i].setFont( new Font( "Ink Free", Font.BOLD, 120 ) );
			barray[i].setFocusable( false );
			barray[i].addActionListener( this );
		}
		
		
		
		titlep.add( txtl );
		frame.add( titlep, BorderLayout.NORTH );
		frame.add( buttonp );
		
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for( int i = 0; i < 9; i++ ) {
			if( e.getSource() == barray[i] ) {
				if( p1_turn ) {
					if( barray[i].getText() == "" ) {
						barray[i].setForeground( new Color( 255, 0, 0 ) );
						barray[i].setText( "X" );
						p1_turn = false;
						txtl.setText( "O turn" );
					}
				}
				else {
					if( barray[i].getText() == "" ) {
						barray[i].setForeground( new Color( 0, 0, 255 ) );
						barray[i].setText( "O" );
						p1_turn = true;
						txtl.setText( "X turn" );
					}
				}
			}
		}
		
	}
	
	public void firstTurn() {
		try {
			Thread.sleep( 2000 );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if( random.nextInt( 2 ) == 0 ) {
			p1_turn = true;
			txtl.setText( "X turn" );
		}
		else {
			p1_turn = false;
			txtl.setText( "O turn" );			
		}

	}
	
	public void check() {
		for( int i = 0; i < 3; i++ ) {
			if( barray[0 + ( i * 3 )].getText() == barray[1 + ( i * 3 )].getText() && barray[1 + ( i * 3 )].getText() == barray[2 + ( i * 3 )].getText() ) { //rows
				if( barray[0 + ( i * 3 )].getText() == "X" ) xwin( 0 + ( i * 3 ), 1 + ( i * 3 ), 2 + ( i * 3 ) );
				else owin( 0 + ( i * 3 ), 1 + ( i * 3 ), 2 + ( i * 3 ) );
				return;
			}
			
			if( barray[0 + i].getText() == barray[3 + i].getText() && barray[3 + i].getText() == barray[6 + i].getText() ) { //columns
				if( barray[0 + i].getText() == "X" ) xwin( 0 + i, 3 + i, 6 + i );
				else owin( 0 + i, 3 + i, 6 + i );
				return;
			}
		}
		if( barray[0].getText() == barray[4].getText() && barray[4].getText() == barray[8].getText() ) { //diagonals
			if( barray[0].getText() == "X" ) xwin( 0, 4, 8 );
			else owin( 0, 4, 8 );
			return;
		}
		if( barray[2].getText() == barray[4].getText() && barray[4].getText() == barray[6].getText() ) { //diagonals
			if( barray[2].getText() == "X" ) xwin( 2, 4, 6 );
			else owin( 2, 4, 6 );
			return;
		}
		
	}
	
	
	
	public void xwin( int a, int b, int c) {
		
	}
	
	public void owin( int a, int b, int c) {
		
	}
}
