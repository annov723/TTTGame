import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Menu implements ActionListener, MouseListener{
	
	Data list = new Data(); //create new Cata object and import dat.txt file
	byte game = 0; //1 - classic, 2 - 9 in 1
	String name; //iser's nickname
	
	Random random  = new Random(); //to choose who starts the game
	
	JFrame frame = new JFrame( "TTTGame" ); //a title for menu display
	ImageIcon icon = new ImageIcon( "icon.png" ); //an icon for menu display
	
	//bakground JLabels for each display
	JLabel  menuBackL = new JLabel( new ImageIcon( "backmenu.png" ) ); 
	JLabel  modeBackL = new JLabel( new ImageIcon( "backmenu.png" ) );
	JLabel  levelBackL = new JLabel( new ImageIcon( "backmenu.png" ) );
	JLabel  rankBackL = new JLabel( new ImageIcon( "backmenu.png" ) );
	JLabel  classicBackL = new JLabel( new ImageIcon( "backmenu.png" ) );
	JLabel  ninoBackL = new JLabel( new ImageIcon( "backmenu.png" ) );
	
	//menu display buttons
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
	
	//single and two player mode buttons
	ImageIcon singleII = new ImageIcon( "spb.png" );
	JButton singleB;
	ImageIcon singleII2 = new ImageIcon( "spb2.png" );
	JButton singleB2;
	ImageIcon twoII = new ImageIcon( "tpb.png" );
	JButton twoB;
	ImageIcon twoII2 = new ImageIcon( "tpb2.png" );
	JButton twoB2;
	
	//difficulty level buttons
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
	
	//back button for each display
	ImageIcon backII = new ImageIcon( "backb.png" );
	JButton backRankB;
	ImageIcon backII2 = new ImageIcon( "backb2.png" );
	JButton backRankB2;
	JButton backClassicB;
	JButton backClassicB2;
	JButton backNinoB;
	JButton backNinoB2;
	
	//classic and 9 in 1 games buttons
	JButton[] xoclassicB = new JButton[9]; //X and O buttons
	JButton[] xoninoB = new JButton[9];
	JLabel xobuttonCL = new JLabel( new ImageIcon( "tttboard.png" ) ); //board for O and X 
	JLabel xobuttonNL = new JLabel( new ImageIcon( "tttboard.png" ) );
	JLabel moveCL = new JLabel(); //whose move is now
	JLabel moveNL = new JLabel();
	JLabel whotitCL = new JLabel( "turn" ); //just "turn" JLabel
	JLabel whotitNL = new JLabel( "turn" );
	JLabel winnerCL = new JLabel(); //to display the winner
	JLabel winnerNL = new JLabel();
	
	//ending game JButton when someone's won
	ImageIcon mainII = new ImageIcon( "mainb.png" );
	JButton winnerCB;
	JButton winnerLB;
	ImageIcon mainII2 = new ImageIcon( "mainb2.png" );
	JButton winnerCB2;
	JButton winnerLB2;
	
	JLabel scoreNL = new JLabel(); //shows score in the single mode
	JLabel scoreCL = new JLabel();
	
	boolean Xturn; //check whose move is now
	int score = 0; //count the player's score
	String points = "score: ";
	String Xplayer;
	String Oplayer;
	char user;
	boolean winner = false;
	int mode; //if we have single, two player easy, medium or hard mode (0 for two players mode and 1, 2, 3 for single with different difficulty levels)
	
	//ranking stuff
	int num = list.dat.size();
	JLabel rankL = new JLabel( new ImageIcon( "backrank.png" ) );
	JLabel pointsL = new JLabel();
	JLabel numL = new JLabel();
	JLabel[] names = new JLabel[num];
	JLabel[] scores = new JLabel[num];
	JLabel[] nums = new JLabel[num];
	
	
	
	Menu( String player ){
		
		name = player;
		
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
			game = 1;
			menuBackL.setVisible( false );
			modeBackL.setVisible( true );
		}
		
		/*9 in 1 button to start this version of game*/
		if( e.getSource() == ninoB2 ) {
			game = 2;
			menuBackL.setVisible( false );
			modeBackL.setVisible( true );
		}
		
		/*ranking button to open ranking view*/
		if( e.getSource() == rankB2 ) {
			menuBackL.setVisible( false );	
			
			List<Map.Entry<String, Integer>> sorted = new ArrayList<>( list.dat.entrySet() );
			Collections.sort( sorted, ( entry1, entry2 ) -> entry2.getValue().compareTo( entry1.getValue() ) );
			
			int counter = 0;
			for ( Map.Entry<String, Integer> entry : sorted ) {
				nums[counter].setText( Integer.toString( counter + 1 ) + "." );
		    	names[counter].setText( entry.getKey() );
		    	scores[counter].setText( Integer.toString( entry.getValue() ) );
		    	counter++;
			}
			
			rankBackL.setVisible( true );
		}
		
		/*exit button clicked closes window, saves data and closes whole program*/
		if( e.getSource() == exitB2 ) {
			list.dataSave();
            frame.dispose();
            System.exit(0);
        }
		
		/*back button to return to the menu screen*/
		if( e.getSource() == backRankB2 ) {
			rankBackL.setVisible( false );
			menuBackL.setVisible( true );
        }
		
		//ending the game in the middle of it
		if( e.getSource() == backClassicB2 || e.getSource() == backNinoB2 ) {
			int result = JOptionPane.showConfirmDialog( frame, "Are you sure you want to go back to menu?\nYour progress will be lost.", "", JOptionPane.YES_NO_OPTION );
            if ( result == JOptionPane.YES_OPTION ) {
            	ninoBackL.setVisible( false );
            	classicBackL.setVisible( false );
            	menuBackL.setVisible( true );
            	game = 0;
            	score = 0;
            }
		}
		 /*single player mode chosen so user has to choose the game level now*/
		if( e.getSource() == singleB2 ) {
			modeBackL.setVisible( false );
			levelBackL.setVisible( true );
		}
		/*two player mode chosen so it's time to start the game*/
		if( e.getSource() == twoB2 ) {
			modeBackL.setVisible( false );
			
			if( game == 1 ) {
				mode = 0;
				classic_game();
			}
			else if( game == 2 ) {
				mode = 0;
				nino_game();
			}
			else {
				ninoBackL.setVisible( false );
            	classicBackL.setVisible( false );
            	menuBackL.setVisible( true );
            	game = 0;
            	score = 0;
			}
		}
		
		/*easy level chosen so it's time to start the game, we are sure that the mode is single*/
		if( e.getSource() == easyB2 ) {
			levelBackL.setVisible( false );

			if( game == 1 ) {
				mode = 1;
				classic_game();
			}
			else if( game == 2 ) {
				mode = 1;
				nino_game();
			}
			else {
				ninoBackL.setVisible( false );
            	classicBackL.setVisible( false );
            	menuBackL.setVisible( true );
            	game = 0;
            	score = 0;
			}
		}
		/*medium level chosen so it's time to start the game, we are sure that the mode is single*/
		if( e.getSource() == mediumB2 ) {
			levelBackL.setVisible( false );

			if( game == 1 ) {
				mode = 2;
				classic_game();
			}
			else if( game == 2 ) {
				mode = 2;
				nino_game();
			}
			else{
				ninoBackL.setVisible( false );
            	classicBackL.setVisible( false );
            	menuBackL.setVisible( true );
            	game = 0;
            	score = 0;
			}
		}
		/*hard level chosen so it's time to start the game, we are sure that the mode is single*/
		if( e.getSource() == hardB2 ) {
			levelBackL.setVisible( false );

			if( game == 1 ) {
				mode = 3;
				classic_game();
			}
			else if( game == 2 ) {
				mode = 3;
				nino_game();
			}
			else {
				ninoBackL.setVisible( false );
            	classicBackL.setVisible( false );
            	menuBackL.setVisible( true );
            	game = 0;
            	score = 0;
			}
		}
		
		
		for( int i = 0; i < 9; i++ ) {
			if( e.getSource() == xoclassicB[i] ) {
				if( Xturn ) {
					if( xoclassicB[i].getText() == "" ) {
						xoclassicB[i].setText( "X" );
						if( !checkc() ) {
							if( mode == 0 ) {
								Xturn = false;
								moveCL.setText( Oplayer );
							}
							else {
								if( mode == 1 ) classic_easy();
								else if( mode == 2 ) classic_medium();
								else classic_hard();
								Xturn = false;
								if( !checkc() ) Xturn = true;
							}
							
						}
					}
				}
				else {
					if( xoclassicB[i].getText() == "" ) {
						xoclassicB[i].setText( "O" );
						if( !checkc() ) {
							if( mode == 0 ) {
								Xturn = true;
								moveCL.setText( Xplayer );
							}
							else {
								if( mode == 1 ) classic_easy();
								else if( mode == 2 ) classic_medium();
								else classic_hard();
								Xturn = true;
								if( !checkc() ) Xturn = false;								
							}
							
						}
					}
				}
			}
			
		}
		
		//go back to menu after the classic game
		if( e.getSource() == winnerCB2 ) {
			winner = false;
			classicBackL.setVisible( false );
			menuBackL.setVisible( true );
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
		
		
		if( e.getSource() == backRankB ) {
			backRankB2.setVisible( true );
			backRankB.setVisible( false );
		}
		if( e.getSource() == backClassicB ) {
			backClassicB2.setVisible( true );
			backClassicB.setVisible( false );
		}
		if( e.getSource() == backNinoB ) {
			backNinoB2.setVisible( true );
			backNinoB.setVisible( false );
		}
		
		if( e.getSource() == winnerCB ) {
			winnerCB2.setVisible( true );
			winnerCB.setVisible( false );
		}
		if( e.getSource() == winnerLB ) {
			winnerLB2.setVisible( true );
			winnerLB.setVisible( false );
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
		
		
		if( e.getSource() == backRankB2 ) {
			backRankB2.setVisible( false );
			backRankB.setVisible( true );
		}
		if( e.getSource() == backClassicB2 ) {
			backClassicB2.setVisible( false );
			backClassicB.setVisible( true );
		}
		if( e.getSource() == backNinoB2 ) {
			backNinoB2.setVisible( false );
			backNinoB.setVisible( true );
		}
		
		if( e.getSource() == winnerCB2 ) {
			winnerCB2.setVisible( false );
			winnerCB.setVisible( true );
		}
		if( e.getSource() == winnerLB2 ) {
			winnerLB2.setVisible( false );
			winnerLB.setVisible( true );
		}
		
	}
	

	
	JLabel menu() {
		
		JLabel titleL = new JLabel( "TTTGame" );
		ImageIcon logoII = new ImageIcon( "icon.png" );
		JLabel logoL;
		
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
		rankL.setLayout( null );
		rankL.setBounds( 20, 20, 480, 420 );
		
		pointsL.setLayout( null );
		pointsL.setBounds( 420, 20, 80, 420 );
		
		numL.setLayout( null );
		numL.setBounds( 45, 20, 40, 420 );
		
		/*print ranking*/
		List<Map.Entry<String, Integer>> sorted = new ArrayList<>( list.dat.entrySet() );
		Collections.sort( sorted, ( entry1, entry2 ) -> entry2.getValue().compareTo( entry1.getValue() ) );
		
		int counter = 0;
		for ( Map.Entry<String, Integer> entry : sorted ) {
			nums[counter] = new JLabel();
	    	names[counter] = new JLabel();
	    	scores[counter] = new JLabel();
	    	counter++;
		}
		
		for( int i = 0; i < num; i++ ) {
			if( 40 + ( i * 35 ) >= 420 ) break;
			nums[i].setBounds( 25, 20 + ( i * 35 ), 40, 35 );
			nums[i].setFont( new Font( "Calibri", Font.BOLD, 25 ) );
			nums[i].setForeground( new Color( 27, 213, 213 ) );
			rankL.add( nums[i] );
			names[i].setBounds( 65, 20 + ( i * 35 ), 355, 35 );
			names[i].setFont( new Font( "Calibri", Font.BOLD, 25 ) );
			names[i].setForeground( new Color( 27, 213, 213 ) );
			rankL.add( names[i] );
			scores[i].setBounds( 0, 20 + ( i * 35 ), 80, 35 );
			scores[i].setFont( new Font( "Calibri", Font.BOLD, 25 ) );
			scores[i].setForeground( new Color( 27, 213, 213 ) );
			pointsL.add( scores[i] );
		}
		
		/*back button - used in ranking, classic and 9 in 1 JLabel*/
		Image backBefore = backII.getImage();
		Image backAfter = backBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		backII = new ImageIcon( backAfter );
		backRankB = new JButton( backII );
		backRankB.setBounds( 525, 380, 176, 60 );
		backRankB.setContentAreaFilled( false );
		backRankB.setFocusable( false );
		backRankB.setBorder( null );
		
		Image backBefore2 = backII2.getImage();
		Image backAfter2 = backBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		backII2 = new ImageIcon( backAfter2 );
		backRankB2 = new JButton( backII2 );
		backRankB2.setBounds( 525, 380, 176, 60 );
		backRankB2.setContentAreaFilled( false );
		backRankB2.setFocusable( false );
		backRankB2.setBorder( null );
		backRankB2.setVisible( false );
		
		backRankB2.addActionListener( this );
		backRankB.addMouseListener( this );
		backRankB2.addMouseListener( this );
		
		
		
		rankBackL.add( backRankB );
		rankBackL.add( backRankB2 );
		rankBackL.add( pointsL );
		rankBackL.add( rankL );
		
		
		
		rankBackL.setLayout( null );
		rankBackL.setBounds( 0, 0, 750, 500 );
		rankBackL.setVisible( false );
		
		return( rankBackL );
		
	}
	
	JLabel classic() {
		
		/*back button - used in ranking, classic and 9 in 1 JLabel*/
		Image backClassicBefore = backII.getImage();
		Image backAfter = backClassicBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		backII = new ImageIcon( backAfter );
		backClassicB = new JButton( backII );
		backClassicB.setBounds( 525, 380, 176, 60 );
		backClassicB.setContentAreaFilled( false );
		backClassicB.setFocusable( false );
		backClassicB.setBorder( null );
		
		Image backClassicBefore2 = backII2.getImage();
		Image backAfter2 = backClassicBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		backII2 = new ImageIcon( backAfter2 );
		backClassicB2 = new JButton( backII2 );
		backClassicB2.setBounds( 525, 380, 176, 60 );
		backClassicB2.setContentAreaFilled( false );
		backClassicB2.setFocusable( false );
		backClassicB2.setBorder( null );
		backClassicB2.setVisible( false );
		
		backClassicB2.addActionListener( this );
		backClassicB.addMouseListener( this );
		backClassicB2.addMouseListener( this );
		
		/*main menu button*/
		Image mainBefore = mainII.getImage();
		Image mainAfter = mainBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		mainII = new ImageIcon( mainAfter );
		winnerCB = new JButton( mainII );
		winnerCB.setBounds( 122, 240, 176, 60 );
		winnerCB.setContentAreaFilled( false );
		winnerCB.setFocusable( false );
		winnerCB.setBorder( null );
		
		Image mainBefore2 = mainII2.getImage();
		Image mainAfter2 = mainBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		mainII2 = new ImageIcon( mainAfter2 );
		winnerCB2 = new JButton( mainII2 );
		winnerCB2.setBounds( 122, 240, 176, 60 );
		winnerCB2.setContentAreaFilled( false );
		winnerCB2.setFocusable( false );
		winnerCB2.setBorder( null );
		winnerCB2.setVisible( false );
		
		winnerCB2.addActionListener( this );
		winnerCB.addMouseListener( this );
		winnerCB2.addMouseListener( this );
		
		/*game buttons field*/
		xobuttonCL.setLayout( null );
		xobuttonCL.setBounds( 20, 20, 420, 420 );
		
		//winner message
		winnerCL.setBounds( 0, 0, 420, 420 );
		winnerCL.setHorizontalAlignment( SwingConstants.CENTER );
		winnerCL.setFont( new Font( "Calibri", Font.BOLD, 50 ) );
		winnerCL.setForeground( Color.white );
		winnerCL.setBackground(new Color(255, 255, 255, 55));
		winnerCL.setOpaque(true);
		
		xobuttonCL.add( winnerCL );
		winnerCL.setVisible( false );
		xobuttonCL.add( winnerCB );
		winnerCB.setVisible( false );
		xobuttonCL.add( winnerCB2 );
		
		for( int i = 0; i < 9; i++ ) {
			xoclassicB[i] = new JButton();
			xoclassicB[i].setFont( new Font( "Ink Free", Font.BOLD, 90 ) ); //Comic Sans, Forte, MV Boli, Segoe UI Black
			xoclassicB[i].setContentAreaFilled( false );
			xoclassicB[i].setFocusable( false );
			xoclassicB[i].setBorder( null );
			xoclassicB[i].setBounds( 140 * ( i % 3 ) , 140 * Integer.valueOf( i / 3 ), 140, 140 );
			xoclassicB[i].addActionListener( this );
			
			xobuttonCL.add( xoclassicB[i] );
		}
		
		//whose turn is now
		moveCL.setBounds( 470, 80, 240, 55 );
		moveCL.setHorizontalAlignment( SwingConstants.CENTER );
		moveCL.setFont( new Font( "Calibri", Font.BOLD, 35 ) );
		moveCL.setForeground( Color.white );
		
		//just "turn" word
		whotitCL.setBounds( 470, 110, 240, 55 );
		whotitCL.setHorizontalAlignment( SwingConstants.CENTER );
		whotitCL.setFont( new Font( "Calibri", Font.BOLD, 35 ) );
		whotitCL.setForeground( Color.white );
		
		//"score = " and number of points 
		scoreCL.setBounds( 470, 200, 240, 35 );
		scoreCL.setHorizontalAlignment( SwingConstants.CENTER );
		scoreCL.setFont( new Font( "Calibri", Font.BOLD, 35 ) );
		scoreCL.setForeground( Color.white );
		scoreCL.setText( points + score );
		scoreCL.setVisible( false );
		
		classicBackL.add( backClassicB );
		classicBackL.add( backClassicB2 );
		classicBackL.add( xobuttonCL );
		classicBackL.add( moveCL );
		classicBackL.add( whotitCL );
		classicBackL.add( scoreCL );
		
		classicBackL.setLayout( null );
		classicBackL.setBounds( 0, 0, 750, 500 );
		classicBackL.setVisible( false );
		
		return( classicBackL );
		
	}
	
	JLabel nino() {
		
		/*back button - used in ranking, classic and 9 in 1 JLabel*/
		Image backNinoBefore = backII.getImage();
		Image backAfter = backNinoBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		backII = new ImageIcon( backAfter );
		backNinoB = new JButton( backII );
		backNinoB.setBounds( 525, 380, 176, 60 );
		backNinoB.setContentAreaFilled( false );
		backNinoB.setFocusable( false );
		backNinoB.setBorder( null );
		
		Image backNinoBefore2 = backII2.getImage();
		Image backAfter2 = backNinoBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		backII2 = new ImageIcon( backAfter2 );
		backNinoB2 = new JButton( backII2 );
		backNinoB2.setBounds( 525, 380, 176, 60 );
		backNinoB2.setContentAreaFilled( false );
		backNinoB2.setFocusable( false );
		backNinoB2.setBorder( null );
		backNinoB2.setVisible( false );
		
		backNinoB2.addActionListener( this );
		backNinoB.addMouseListener( this );
		backNinoB2.addMouseListener( this );
		
		/*main menu button*/
		Image mainBefore = mainII.getImage();
		Image mainAfter = mainBefore.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		mainII = new ImageIcon( mainAfter );
		winnerLB = new JButton( mainII );
		winnerLB.setBounds( 122, 240, 176, 60 );
		winnerLB.setContentAreaFilled( false );
		winnerLB.setFocusable( false );
		winnerLB.setBorder( null );
		
		Image mainBefore2 = mainII2.getImage();
		Image mainAfter2 = mainBefore2.getScaledInstance( 176, 60, java.awt.Image.SCALE_SMOOTH );
		mainII2 = new ImageIcon( mainAfter2 );
		winnerLB2 = new JButton( mainII2 );
		winnerLB2.setBounds( 122, 240, 176, 60 );
		winnerLB2.setContentAreaFilled( false );
		winnerLB2.setFocusable( false );
		winnerLB2.setBorder( null );
		winnerLB2.setVisible( false );
		
		winnerLB2.addActionListener( this );
		winnerLB.addMouseListener( this );
		winnerLB2.addMouseListener( this );
		
		/*game buttons field*/
		xobuttonNL.setLayout( null );
		xobuttonNL.setBounds( 20, 20, 420, 420 );
		
		//winner message
		winnerNL.setBounds( 0, 0, 420, 420 );
		winnerNL.setHorizontalAlignment( SwingConstants.CENTER );
		winnerNL.setFont( new Font( "Calibri", Font.BOLD, 50 ) );
		winnerNL.setForeground( Color.white );
		winnerNL.setBackground(new Color(255, 255, 255, 55));
		winnerNL.setOpaque(true);
		
		xobuttonNL.add( winnerNL );
		winnerNL.setVisible( false );
		xobuttonNL.add( winnerLB );
		winnerLB.setVisible( false );
		xobuttonNL.add( winnerLB2 );
		
		for( int i = 0; i < 9; i++ ) {
			xoninoB[i] = new JButton();
			xoninoB[i].setFont( new Font( "Ink Free", Font.BOLD, 90 ) ); //Comic Sans, Forte, MV Boli, Segoe UI Black
			xoninoB[i].setContentAreaFilled( false );
			xoninoB[i].setFocusable( false );
			xoninoB[i].setBorder( null );
			xoninoB[i].setBounds( 140 * ( i % 3 ) , 140 * Integer.valueOf( i / 3 ), 140, 140 );
			xoninoB[i].addActionListener( this );
			
			xobuttonNL.add( xoninoB[i] );
		}
		
		/*whose turn label*/
		moveNL.setBounds( 470, 80, 240, 55 );
		moveNL.setHorizontalAlignment( SwingConstants.CENTER );
		moveNL.setFont( new Font( "Calibri", Font.BOLD, 35 ) );
		moveNL.setForeground( Color.white );
		
		/*whose turn title label*/
		whotitNL.setBounds( 470, 110, 240, 55 );
		whotitNL.setHorizontalAlignment( SwingConstants.CENTER );
		whotitNL.setFont( new Font( "Calibri", Font.BOLD, 35 ) );
		whotitNL.setForeground( Color.white );
		
		scoreNL.setBounds( 470, 200, 240, 35 );
		scoreNL.setHorizontalAlignment( SwingConstants.CENTER );
		scoreNL.setFont( new Font( "Calibri", Font.BOLD, 35 ) );
		scoreNL.setForeground( Color.white );
		scoreNL.setText( points + score );
		scoreNL.setVisible( false );
		
		
		
		ninoBackL.add( backNinoB );
		ninoBackL.add( backNinoB2 );
		ninoBackL.add( xobuttonNL );
		ninoBackL.add( moveNL );
		ninoBackL.add( whotitNL );
		ninoBackL.add( scoreNL );
		
		ninoBackL.setLayout( null );
		ninoBackL.setBounds( 0, 0, 750, 500 );
		ninoBackL.setVisible( false );
		
		return( ninoBackL );
		
	}
	
	
	
	/**
	 * @brief runs the classic game variant
	 */
	void classic_game(){
		if( !winner ) {
			for( int i = 0; i < 9; i++ ) {
				xoclassicB[i].setText( "" );
				xoclassicB[i].setEnabled( true );
				xoclassicB[i].setVisible( true );
			}
			backClassicB2.setVisible( false );
			backClassicB.setEnabled( true );
			backClassicB2.setEnabled( true );
			winnerCL.setVisible( false );
			winnerCB2.setVisible( false );
			winnerCB.setVisible( false );
			scoreCL.setText( points + score );
			moveCL.setVisible( true );
			
			classicBackL.setVisible( true );
			
			begin();
			if( mode >= 1 ) scoreCL.setVisible( true );
		}
		else if( winner ) {
			backClassicB.setEnabled( false );
			backClassicB2.setEnabled( false );
			moveCL.setVisible( false );
			
			if( Xturn ) {
				winnerCL.setText( Xplayer + " won!" );
				if( user == 'X' ) {
					if( mode == 1 ) score = score + 10;
					else if( mode == 2 ) score = score + 30;
					else score = score + 50;
				}
				
			}
			else {
				winnerCL.setText( Oplayer + " won!" );
				if( user == 'O' ) {
					if( mode == 1 ) score = score + 10;
					else if( mode == 2 ) score = score + 30;
					else score = score + 50;
				}
			}
			
			if( mode != 0 ) {
				scoreCL.setText( points + String.valueOf( score ) );
				score = score + list.dat.get( name );
				if( score > 9999 ) score = 9999;
				list.dat.put( name, score );
			}
			
			winnerCL.setVisible( true );
			
			game = 0;
			score = 0;
			mode = 4;
			
			winnerCB.setVisible( true );
		}
		
		
	}
	
	/**
	 * @brief runs the 9 in 1 game variant
	 */
	void nino_game() {
		
		ninoBackL.setVisible( true );
		begin();
		if( mode >= 1 ) scoreNL.setVisible( true );
		
		score = score + list.dat.get( name );
		list.dat.put( name, score );
		game = 0;
		score = 0;
		mode = 4;
		
	}
	
	/**
	 * @brief decides who starts, and with which elem
	 * 0 - X begins, 1 - O begins
	 * 0 - the logged user begins, 1 - computer (1) or their friend (0) begins
	 */
	void begin() {
		if( random.nextInt( 2 ) == 0 ) Xturn = true;
		else Xturn = false;
			
		if( random.nextInt( 2 ) == 0 ) { //who starts
			if( Xturn == true ) {
				Xplayer = name;
				if( mode == 0 ) Oplayer = "friend";
				else Oplayer = "computer";
			}
			else {
				Oplayer = name;
				if( mode == 0 ) Xplayer = "friend";
				else Xplayer = "computer";
			}
			if( game == 1 ) moveCL.setText( name );
			else moveNL.setText( name );
		}
		else {
			if( mode == 0 ) {
				if( Xturn == true ) {
					Xplayer = "friend";
					Oplayer = name;
				}
				else {
					Xplayer = name;
					Oplayer = "friend";
				}
				if( game == 1 ) moveCL.setText( "friend" );
				else moveNL.setText( "friend" );
			}
			else {
				if( Xturn == true ) {
					Xplayer = "computer";
					Oplayer = name;
				}
				else {
					Xplayer = name;
					Oplayer = "computer";
				}
				if( game == 1 ) moveCL.setText( "computer" );
				else moveNL.setText( "computer" );
			}
		}
		
		if( Xplayer == name ) user = 'X';
		else user = 'O';
		
		if( Xturn == true && user == 'O' && mode >= 1 ) {
			if( game == 1 ) {
				if( mode == 1 ) classic_easy();
				if( mode == 2 ) classic_medium();
				else classic_hard();
			}
			else {
				//nino game options 
			}
			
			Xturn = false;
			if( game == 1 ) moveCL.setText( Oplayer );
			else moveNL.setText( Oplayer );
			
		}
		else if( Xturn == false && user == 'X' && mode >= 1 ) {
			if( game == 1 ) {
				if( mode == 1 ) classic_easy();
				if( mode == 2 ) classic_medium();
				else classic_hard();
			}
			else {
				//nino game options
			}
			
			Xturn = true;
			if( game == 1 ) moveCL.setText( Xplayer );
			else moveNL.setText( Xplayer );
		}
		
	}
	
	boolean checkc() {
		for( int i = 0; i < 3; i++ ) {
			if( xoclassicB[0 + ( i * 3 )].getText() != "" && xoclassicB[0 + ( i * 3 )].getText() == xoclassicB[1 + ( i * 3 )].getText() && xoclassicB[1 + ( i * 3 )].getText() == xoclassicB[2 + ( i * 3 )].getText() ) { //rows
				if( xoclassicB[0 + ( i * 3 )].getText() == "X" ) winc( 0 + ( i * 3 ), 1 + ( i * 3 ), 2 + ( i * 3 ) );
				else winc( 0 + ( i * 3 ), 1 + ( i * 3 ), 2 + ( i * 3 ) );
				return true;
			}
			
			if( xoclassicB[0 + i].getText() != "" && xoclassicB[0 + i].getText() == xoclassicB[3 + i].getText() && xoclassicB[3 + i].getText() == xoclassicB[6 + i].getText() ) { //columns
				if( xoclassicB[0 + i].getText() == "X" ) winc( 0 + i, 3 + i, 6 + i );
				else winc( 0 + i, 3 + i, 6 + i );
				return true;
			}
		}
		if( xoclassicB[0].getText() != "" && xoclassicB[0].getText() == xoclassicB[4].getText() && xoclassicB[4].getText() == xoclassicB[8].getText() ) { //diagonals
			if( xoclassicB[0].getText() == "X" ) winc( 0, 4, 8 );
			else winc( 0, 4, 8 );
			return true;
		}
		if( xoclassicB[2].getText() != "" && xoclassicB[2].getText() == xoclassicB[4].getText() && xoclassicB[4].getText() == xoclassicB[6].getText() ) { //diagonals
			if( xoclassicB[2].getText() == "X" ) winc( 2, 4, 6 );
			else winc( 2, 4, 6 );
			return true;
		}
		return false;
	}
	
	void winc( int a, int b, int c) {
		
		for( int i = 0; i < 9; i++ ) {
			xoclassicB[i].setVisible( false );
		}
		xoclassicB[a].setVisible( true );
		xoclassicB[b].setVisible( true );
		xoclassicB[c].setVisible( true );
		xoclassicB[a].setEnabled( false );
		xoclassicB[b].setEnabled( false );
		xoclassicB[c].setEnabled( false );
		
		
		winner = true;
		classic_game();
	}
	
	void classic_easy() {
		while( true ) {
			int count = random.nextInt( 9 );
			if( xoclassicB[count].getText() == "" ) {
				if( user == 'X' ) xoclassicB[count].setText( "O" );
				else xoclassicB[count].setText( "X" );
				break;
			}
		}
	}
	
	void classic_hard() {
		
	}
	
	void classic_medium() {
		int count = random.nextInt( 2 );
		if( count == 0 ) classic_easy();
		else classic_hard();
	}
	

	
}