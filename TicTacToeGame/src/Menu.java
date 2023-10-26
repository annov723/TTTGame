import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Menu implements ActionListener, MouseListener{ //subclass so we can use save method here
	
	Data list = new Data(); //create new Cata object and import dat.txt file
	
	JFrame frame = new JFrame( "TTTGame" );
	ImageIcon icon = new ImageIcon( "icon.png" );
	JLabel  menuBackL = new JLabel( new ImageIcon( "backmenu.png" ) );
	JLabel  rankBackL = new JLabel( new ImageIcon( "backmenu.png" ) );
	JLabel  ninoBackL = new JLabel( new ImageIcon( "backmenu.png" ) );
	JLabel  classicBackL = new JLabel( new ImageIcon( "backmenu.png" ) );
	JLabel titleL = new JLabel( "TTTGame" );
	ImageIcon logoII = new ImageIcon( "icon.png" );
	JLabel logoL;
	
	ImageIcon classicII = new ImageIcon( "classicb.png" );
	JButton classicB;
	ImageIcon classicII2 = new ImageIcon( "classicb2.png" );
	JButton classicB2;
	ImageIcon ninoII = new ImageIcon( "ninob.png" );
	JButton ninoB;
	ImageIcon ninoII2 = new ImageIcon( "ninob2.png" );
	JButton ninoB2;
	ImageIcon rankII = new ImageIcon( "rankb.png" );
	JButton rankB;
	ImageIcon rankII2 = new ImageIcon( "rankb2.png" );
	JButton rankB2;
	ImageIcon exitII = new ImageIcon( "exitb.png" );
	JButton exitB;
	ImageIcon exitII2 = new ImageIcon( "exitb2.png" );
	JButton exitB2;
	
	Menu( String name ){
		
		if( !list.dat.containsKey( name ) ) {
			list.dat.put( name, 0 );
		}
		
		frame.add( menu() );
		
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); //no additional action is needed
		frame.setSize( 750, 500 );
		frame.setResizable( false );
		frame.setLocationRelativeTo( null ); //the window appears on the center of the screen
		frame.setIconImage( icon.getImage() );
		frame.setLayout( null );
		frame.setVisible( true );
		
		/*when the window is closing we wanna save all ranking data to dat.txt*/
		frame.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing( WindowEvent e ) {
            	list.dataSave();
                System.exit(0);
            }
        } );
		
	}
	
	@Override
	public void actionPerformed( ActionEvent e ) {
		if( e.getSource() == classicB2 ) {
			menuBackL.setVisible( false );
			classicBackL.setVisible( true );
			frame.add( mode() );
		}
		
		if( e.getSource() == ninoB2 ) {
			menuBackL.setVisible( false );
			ninoBackL.setVisible( true );
			frame.add( mode() );
		}
		
		if( e.getSource() == rankB2 ) {
			menuBackL.setVisible( false );
			rankBackL.setVisible( true );
			frame.add( ranking() );
		}
		
		/*exit button clicked closes window, saves data and closes whole program*/
		if( e.getSource() == exitB2 ) {
			list.dataSave();
            frame.dispose();
            System.exit(0);
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

	@Override
	public void mouseEntered(MouseEvent e) {
		if( e.getSource() == classicB ) {
			classicB2.setVisible( true );
			classicB.setVisible( false );
		}
		if( e.getSource() == ninoB ) {
			ninoB2.setVisible( true );
			ninoB.setVisible( false );
		}
		if( e.getSource() == rankB ) {
			rankB2.setVisible( true );
			rankB.setVisible( false );
		}
		if( e.getSource() == exitB ) {
			exitB2.setVisible( true );
			exitB.setVisible( false );
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if( e.getSource() == classicB2 ) {
			classicB2.setVisible( false );
			classicB.setVisible( true );
		}
		if( e.getSource() == ninoB2 ) {
			ninoB2.setVisible( false );
			ninoB.setVisible( true );
		}
		if( e.getSource() == rankB2 ) {
			rankB2.setVisible( false );
			rankB.setVisible( true );
		}
		if( e.getSource() == exitB2 ) {
			exitB2.setVisible( false );
			exitB.setVisible( true );
		}
		
	}

	

	JLabel menu() {
		
		/*logo image*/
		Image logoBefore = logoII.getImage();
		Image logoAfter = logoBefore.getScaledInstance( 110, 110, java.awt.Image.SCALE_SMOOTH );
		logoII = new ImageIcon( logoAfter );
		logoL = new JLabel( logoII );
		logoL.setBounds( 20, 20, 110, 110);
		
		/*title label*/
		titleL.setBounds( 150, 40, 500, 110 );
		titleL.setFont( new Font( "Calibri", Font.BOLD, 90 ) );
		titleL.setForeground( Color.white );
		
		/*classic mode button*/
		Image classicBefore = classicII.getImage();
		Image classicAfter = classicBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		classicII = new ImageIcon( classicAfter );
		classicB = new JButton( classicII );
		classicB.setBounds( 100, 160, 176, 60 );
		classicB.setContentAreaFilled( false );
		classicB.setFocusable( false );
		classicB.setBorder( null );
		
		Image classicBefore2 = classicII2.getImage();
		Image classicAfter2 = classicBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		classicII2 = new ImageIcon( classicAfter2 );
		classicB2 = new JButton( classicII2 );
		classicB2.setBounds( 100, 160, 176, 60 );
		classicB2.setContentAreaFilled( false );
		classicB2.setFocusable( false );
		classicB2.setBorder( null );
		classicB2.setVisible( false );
		
		classicB2.addActionListener( this );
		classicB.addMouseListener( this );
		classicB2.addMouseListener( this );
		
		/*9 in 1 mode button*/
		Image ninoBefore = ninoII.getImage();
		Image ninoAfter = ninoBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		ninoII = new ImageIcon( ninoAfter );
		ninoB = new JButton( ninoII );
		ninoB.setBounds( 100, 240, 176, 60 );
		ninoB.setContentAreaFilled( false );
		ninoB.setFocusable( false );
		ninoB.setBorder( null );
		
		Image ninoBefore2 = ninoII2.getImage();
		Image ninoAfter2 = ninoBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		ninoII2 = new ImageIcon( ninoAfter2 );
		ninoB2 = new JButton( ninoII2 );
		ninoB2.setBounds( 100, 240, 176, 60 );
		ninoB2.setContentAreaFilled( false );
		ninoB2.setFocusable( false );
		ninoB2.setBorder( null );
		ninoB2.setVisible( false );
		
		ninoB2.addActionListener( this );
		ninoB.addMouseListener( this );
		ninoB2.addMouseListener( this );
		
		/*player ranking button*/
		Image rankBefore = rankII.getImage();
		Image rankAfter = rankBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		rankII = new ImageIcon( rankAfter );
		rankB = new JButton( rankII );
		rankB.setBounds( 100, 320, 176, 60 );
		rankB.setContentAreaFilled( false );
		rankB.setFocusable( false );
		rankB.setBorder( null );
		
		Image rankBefore2 = rankII2.getImage();
		Image rankAfter2 = rankBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		rankII2 = new ImageIcon( rankAfter2 );
		rankB2 = new JButton( rankII2 );
		rankB2.setBounds( 100, 320, 176, 60 );
		rankB2.setContentAreaFilled( false );
		rankB2.setFocusable( false );
		rankB2.setBorder( null );
		rankB2.setVisible( false );
		
		rankB2.addActionListener( this );
		rankB.addMouseListener( this );
		rankB2.addMouseListener( this );
		
		/*exit button*/
		Image exitBefore = exitII.getImage();
		Image exitAfter = exitBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		exitII = new ImageIcon( exitAfter );
		exitB = new JButton( exitII );
		exitB.setBounds( 525, 380, 176, 60 );
		exitB.setContentAreaFilled( false );
		exitB.setFocusable( false );
		exitB.setBorder( null );
		
		Image exitBefore2 = exitII2.getImage();
		Image exitAfter2 = exitBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		exitII2 = new ImageIcon( exitAfter2 );
		exitB2 = new JButton( exitII2 );
		exitB2.setBounds( 525, 380, 176, 60 );
		exitB2.setContentAreaFilled( false );
		exitB2.setFocusable( false );
		exitB2.setBorder( null );
		exitB2.setVisible( false );
		
		exitB2.addActionListener( this );
		exitB.addMouseListener( this );
		exitB2.addMouseListener( this );
		
		
		
		menuBackL.add( logoL );
		menuBackL.add( titleL );
		menuBackL.add( classicB );
		menuBackL.add( classicB2 );
		menuBackL.add( ninoB );
		menuBackL.add( ninoB2 );
		menuBackL.add( rankB );
		menuBackL.add( rankB2 );
		menuBackL.add( exitB );
		menuBackL.add( exitB2 );
		
		menuBackL.setLayout( null );
		menuBackL.setBounds( 0, 0, 750, 500 );
		
		return( menuBackL );
	}
	
	JLabel mode() {
		
	}
	
	JLabel level() {
		
	}
	
	JLabel ranking() {
		
	}
	
}
