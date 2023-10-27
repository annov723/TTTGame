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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Menu implements ActionListener, MouseListener{
	
	Data list = new Data(); //create new Cata object and import dat.txt file
	byte mode = 0;
	byte level = 0;
	
	JFrame frame = new JFrame( "TTTGame" );
	ImageIcon icon = new ImageIcon( "icon.png" );
	
	JLabel  menuBackL = new JLabel( new ImageIcon( "backmenu.png" ) );
	JLabel  modeBackL = new JLabel( new ImageIcon( "backmenu.png" ) );
	JLabel  levelBackL = new JLabel( new ImageIcon( "backmenu.png" ) );
	JLabel  rankBackL = new JLabel( new ImageIcon( "backmenu.png" ) );
	JLabel  classicBackL = new JLabel( new ImageIcon( "backmenu.png" ) );
	JLabel  ninoBackL = new JLabel( new ImageIcon( "backmenu.png" ) );

	
	
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
	
	ImageIcon singleII = new ImageIcon( "spb.png" );
	JButton singleB;
	ImageIcon singleII2 = new ImageIcon( "spb2.png" );
	JButton singleB2;
	ImageIcon twoII = new ImageIcon( "tpb.png" );
	JButton twoB;
	ImageIcon twoII2 = new ImageIcon( "tpb2.png" );
	JButton twoB2;
	
	ImageIcon easyII = new ImageIcon( "easyb.png" );
	JButton easyB;
	ImageIcon easyII2 = new ImageIcon( "easyb2.png" );
	JButton easyB2;
	ImageIcon mediumII = new ImageIcon( "mediumb.png" );
	JButton mediumB;
	ImageIcon mediumII2 = new ImageIcon( "mediumb2.png" );
	JButton mediumB2;
	ImageIcon hardII = new ImageIcon( "hardb.png" );
	JButton hardB;
	ImageIcon hardII2 = new ImageIcon( "hardb2.png" );
	JButton hardB2;
	
	ImageIcon backII = new ImageIcon( "backb.png" );
	JButton backB;
	ImageIcon backII2 = new ImageIcon( "backb2.png" );
	JButton backB2;
	
	
	Menu( String name ){
		
		if( !list.dat.containsKey( name ) ) {
			list.dat.put( name, 0 );
		}
		
		frame.add( menu() );
		frame.add( mode() );
		frame.add( level() );
		frame.add( ranking() );
		frame.add( classic() );
		frame.add( nino() );
		
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
		/*classic button to start classic version of Tic Tac Toe game*/
		if( e.getSource() == classicB2 ) {
			menuBackL.setVisible( false );
			modeBackL.setVisible( true );
		}
		/*9 in 1 button to start this version of game*/
		if( e.getSource() == ninoB2 ) {
			menuBackL.setVisible( false );
			modeBackL.setVisible( true );
		}
		/*ranking button to open ranking view*/
		if( e.getSource() == rankB2 ) {
			menuBackL.setVisible( false );
			rankBackL.setVisible( true );
			
		}
		/*exit button clicked closes window, saves data and closes whole program*/
		if( e.getSource() == exitB2 ) {
			list.dataSave();
            frame.dispose();
            System.exit(0);
        }
		
		/*back button to return to the menu screen*/
		if( e.getSource() == backB2 ) {
			if( rankBackL.isVisible() ) {
				rankBackL.setVisible( false );
				menuBackL.setVisible( true );
			}
			else if( ninoBackL.isVisible() || classicBackL.isVisible() ) {
				 int result = JOptionPane.showConfirmDialog( frame, "Are you sure you want to go back to menu? ", "Your progress will be lost.", JOptionPane.YES_NO_OPTION );
	             if ( result == JOptionPane.YES_OPTION ) {
	            	 ninoBackL.setVisible( false );
	            	 classicBackL.setVisible( false );
	            	 menuBackL.setVisible( true );
	             }
			}
			
        }
		
		if( e.getSource() == singleB2 ) {
			mode = 1;
			modeBackL.setVisible( false );
			levelBackL.setVisible( true );
		}
		if( e.getSource() == twoB2 ) {
			mode = 2;
			modeBackL.setVisible( false );
			levelBackL.setVisible( true );
		}
		
		if( e.getSource() == easyB2 ) {
			level = 1;
			levelBackL.setVisible( false );
			if( mode == 1 ) classicBackL.setVisible( true );
			else if( mode == 2 ) ninoBackL.setVisible( true );
			else menuBackL.setVisible( true ); //an error occured...
		}
		if( e.getSource() == mediumB2 ) {
			level = 2;
			levelBackL.setVisible( false );
			if( mode == 1 ) classicBackL.setVisible( true );
			else if( mode == 2 ) ninoBackL.setVisible( true );
			else menuBackL.setVisible( true );
		}
		if( e.getSource() == hardB2 ) {
			level = 3;
			levelBackL.setVisible( false );
			if( mode == 1 ) classicBackL.setVisible( true );
			else if( mode == 2 ) ninoBackL.setVisible( true );
			else menuBackL.setVisible( true );
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
		
		
		if( e.getSource() == singleB ) {
			singleB2.setVisible( true );
			singleB.setVisible( false );
		}
		if( e.getSource() == twoB ) {
			twoB2.setVisible( true );
			twoB.setVisible( false );
		}
		
		
		if( e.getSource() == easyB ) {
			easyB2.setVisible( true );
			easyB.setVisible( false );
		}
		if( e.getSource() == mediumB ) {
			mediumB2.setVisible( true );
			mediumB.setVisible( false );
		}
		if( e.getSource() == hardB ) {
			hardB2.setVisible( true );
			hardB.setVisible( false );
		}
		
		
		if( e.getSource() == backB ) {
			backB2.setVisible( true );
			backB.setVisible( false );
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
		
		
		if( e.getSource() == singleB2 ) {
			singleB2.setVisible( false );
			singleB.setVisible( true );
		}
		if( e.getSource() == twoB2 ) {
			twoB2.setVisible( false );
			twoB.setVisible( true );
		}
		
		
		if( e.getSource() == easyB2 ) {
			easyB2.setVisible( false );
			easyB.setVisible( true );
		}
		if( e.getSource() == mediumB2 ) {
			mediumB2.setVisible( false );
			mediumB.setVisible( true );
		}
		if( e.getSource() == hardB2 ) {
			hardB2.setVisible( false );
			hardB.setVisible( true );
		}
		
		
		if( e.getSource() == backB2 ) {
			backB2.setVisible( false );
			backB.setVisible( true );
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
		menuBackL.setVisible( true );
		
		return( menuBackL );
	}
	
	JLabel mode() {
		
		/*single mode button*/
		Image singleBefore = singleII.getImage();
		Image singleAfter = singleBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		singleII = new ImageIcon( singleAfter );
		singleB = new JButton( singleII );
		singleB.setBounds( 280, 165, 176, 60 );
		singleB.setContentAreaFilled( false );
		singleB.setFocusable( false );
		singleB.setBorder( null );
		
		Image singleBefore2 = singleII2.getImage();
		Image singleAfter2 = singleBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		singleII2 = new ImageIcon( singleAfter2 );
		singleB2 = new JButton( singleII2 );
		singleB2.setBounds( 280, 165, 176, 60 );
		singleB2.setContentAreaFilled( false );
		singleB2.setFocusable( false );
		singleB2.setBorder( null );
		singleB2.setVisible( false );
		
		singleB2.addActionListener( this );
		singleB.addMouseListener( this );
		singleB2.addMouseListener( this );
		
		/*two mode button*/
		Image twoBefore = twoII.getImage();
		Image twoAfter = twoBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		twoII = new ImageIcon( twoAfter );
		twoB = new JButton( twoII );
		twoB.setBounds( 280, 245, 176, 60 );
		twoB.setContentAreaFilled( false );
		twoB.setFocusable( false );
		twoB.setBorder( null );
		
		Image twoBefore2 = twoII2.getImage();
		Image twoAfter2 = twoBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		twoII2 = new ImageIcon( twoAfter2 );
		twoB2 = new JButton( twoII2 );
		twoB2.setBounds( 280, 245, 176, 60 );
		twoB2.setContentAreaFilled( false );
		twoB2.setFocusable( false );
		twoB2.setBorder( null );
		twoB2.setVisible( false );
		
		twoB2.addActionListener( this );
		twoB.addMouseListener( this );
		twoB2.addMouseListener( this );
		
		
		
		modeBackL.add( singleB );
		modeBackL.add( singleB2 );
		modeBackL.add( twoB );
		modeBackL.add( twoB2 );
		
		modeBackL.setLayout( null );
		modeBackL.setBounds( 0, 0, 750, 500 );
		modeBackL.setVisible( false );
		
		return( modeBackL );
		
	}
	
	JLabel level() {
		
		/*easy level button*/
		Image easyBefore = easyII.getImage();
		Image easyAfter = easyBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		easyII = new ImageIcon( easyAfter );
		easyB = new JButton( easyII );
		easyB.setBounds( 280, 120, 176, 60 );
		easyB.setContentAreaFilled( false );
		easyB.setFocusable( false );
		easyB.setBorder( null );
		
		Image easyBefore2 = easyII2.getImage();
		Image easyAfter2 = easyBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		easyII2 = new ImageIcon( easyAfter2 );
		easyB2 = new JButton( easyII2 );
		easyB2.setBounds( 280, 120, 176, 60 );
		easyB2.setContentAreaFilled( false );
		easyB2.setFocusable( false );
		easyB2.setBorder( null );
		easyB2.setVisible( false );
		
		easyB2.addActionListener( this );
		easyB.addMouseListener( this );
		easyB2.addMouseListener( this );
		
		/*medium level button*/
		Image mediumBefore = mediumII.getImage();
		Image mediumAfter = mediumBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		mediumII = new ImageIcon( mediumAfter );
		mediumB = new JButton( mediumII );
		mediumB.setBounds( 280, 200, 176, 60 );
		mediumB.setContentAreaFilled( false );
		mediumB.setFocusable( false );
		mediumB.setBorder( null );
		
		Image mediumBefore2 = mediumII2.getImage();
		Image mediumAfter2 = mediumBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		mediumII2 = new ImageIcon( mediumAfter2 );
		mediumB2 = new JButton( mediumII2 );
		mediumB2.setBounds( 280, 200, 176, 60 );
		mediumB2.setContentAreaFilled( false );
		mediumB2.setFocusable( false );
		mediumB2.setBorder( null );
		mediumB2.setVisible( false );
		
		mediumB2.addActionListener( this );
		mediumB.addMouseListener( this );
		mediumB2.addMouseListener( this );
		
		/*hard level button*/
		Image hardBefore = hardII.getImage();
		Image hardAfter = hardBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		hardII = new ImageIcon( hardAfter );
		hardB = new JButton( hardII );
		hardB.setBounds( 280, 280, 176, 60 );
		hardB.setContentAreaFilled( false );
		hardB.setFocusable( false );
		hardB.setBorder( null );
		
		Image hardBefore2 = hardII2.getImage();
		Image hardAfter2 = hardBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		hardII2 = new ImageIcon( hardAfter2 );
		hardB2 = new JButton( hardII2 );
		hardB2.setBounds( 280, 280, 176, 60 );
		hardB2.setContentAreaFilled( false );
		hardB2.setFocusable( false );
		hardB2.setBorder( null );
		hardB2.setVisible( false );
		
		hardB2.addActionListener( this );
		hardB.addMouseListener( this );
		hardB2.addMouseListener( this );
		
		
		
		levelBackL.add( easyB );
		levelBackL.add( easyB2 );
		levelBackL.add( mediumB );
		levelBackL.add( mediumB2 );
		levelBackL.add( hardB );
		levelBackL.add( hardB2 );
		
		levelBackL.setLayout( null );
		levelBackL.setBounds( 0, 0, 750, 500 );
		levelBackL.setVisible( false );
		
		return( levelBackL );
		
	}
	
	JLabel ranking() {
		
		/*ranking board*/
		
		
		/*back button*/
		Image backBefore = backII.getImage();
		Image backAfter = backBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		backII = new ImageIcon( backAfter );
		backB = new JButton( backII );
		backB.setBounds( 525, 380, 176, 60 );
		backB.setContentAreaFilled( false );
		backB.setFocusable( false );
		backB.setBorder( null );
		
		Image backBefore2 = backII2.getImage();
		Image backAfter2 = backBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		backII2 = new ImageIcon( backAfter2 );
		backB2 = new JButton( backII2 );
		backB2.setBounds( 525, 380, 176, 60 );
		backB2.setContentAreaFilled( false );
		backB2.setFocusable( false );
		backB2.setBorder( null );
		backB2.setVisible( false );
		
		backB2.addActionListener( this );
		backB.addMouseListener( this );
		backB2.addMouseListener( this );
		
		
		
		rankBackL.add( backB );
		rankBackL.add( backB2 );
		
		rankBackL.setLayout( null );
		rankBackL.setBounds( 0, 0, 750, 500 );
		rankBackL.setVisible( false );
		
		return( rankBackL );
		
	}
	
	JLabel classic() {
		
		/*back button*/
		Image backBefore = backII.getImage();
		Image backAfter = backBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		backII = new ImageIcon( backAfter );
		backB = new JButton( backII );
		backB.setBounds( 525, 380, 176, 60 );
		backB.setContentAreaFilled( false );
		backB.setFocusable( false );
		backB.setBorder( null );
		
		Image backBefore2 = backII2.getImage();
		Image backAfter2 = backBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		backII2 = new ImageIcon( backAfter2 );
		backB2 = new JButton( backII2 );
		backB2.setBounds( 525, 380, 176, 60 );
		backB2.setContentAreaFilled( false );
		backB2.setFocusable( false );
		backB2.setBorder( null );
		backB2.setVisible( false );
		
		backB2.addActionListener( this );
		backB.addMouseListener( this );
		backB2.addMouseListener( this );
		
		
		
		classicBackL.add( backB );
		classicBackL.add( backB2 );
		
		classicBackL.setLayout( null );
		classicBackL.setBounds( 0, 0, 750, 500 );
		classicBackL.setVisible( false );
		
		return( classicBackL );
		
	}
	
	JLabel nino() {
		
		/*back button*/
		Image backBefore = backII.getImage();
		Image backAfter = backBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		backII = new ImageIcon( backAfter );
		backB = new JButton( backII );
		backB.setBounds( 525, 380, 176, 60 );
		backB.setContentAreaFilled( false );
		backB.setFocusable( false );
		backB.setBorder( null );
		
		Image backBefore2 = backII2.getImage();
		Image backAfter2 = backBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		backII2 = new ImageIcon( backAfter2 );
		backB2 = new JButton( backII2 );
		backB2.setBounds( 525, 380, 176, 60 );
		backB2.setContentAreaFilled( false );
		backB2.setFocusable( false );
		backB2.setBorder( null );
		backB2.setVisible( false );
		
		backB2.addActionListener( this );
		backB.addMouseListener( this );
		backB2.addMouseListener( this );
		
		
		
		ninoBackL.add( backB );
		ninoBackL.add( backB2 );
		
		ninoBackL.setLayout( null );
		ninoBackL.setBounds( 0, 0, 750, 500 );
		ninoBackL.setVisible( false );
		
		return( ninoBackL );
		
	}
	
}
