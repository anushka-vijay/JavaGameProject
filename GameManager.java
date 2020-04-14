//Anushka Vijay
//5-10-18
//GameManager.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class GameManager
{
	JFrame frame;
	JPanel cards, TitleScreen, EventsScreen, RunningLevel1, RunningLevel2, RunningLevel3, Arrow1, Arrow2, Arrow3, Instructions, WinScreen, LoseScreen;
	int width, height;
	public GameManager()
	{
	}
	public static void main(String [] args)
	{
		GameManager gm = new GameManager();
		gm.run();
	}
	public void run()
	{	
		cards = new JPanel(new CardLayout());
		TitleScreen title = new TitleScreen();
		cards.add(title,"title");
		//title.setPreferredSize(new Dimension(90,750));
		EventsScreen events = new EventsScreen();
		cards.add(events,"events");
		RunningLevel1 run1 = new RunningLevel1();
		cards.add(run1, "running1");
		RunningLevel2 run2 = new RunningLevel2();
		cards.add(run2, "running2");
		RunningLevel3 run3 = new RunningLevel3();
		cards.add(run3, "running3");
		Arrow1 a1 = new Arrow1();
		cards.add(a1, "arrow1");
		Arrow2 a2 = new Arrow2();
		cards.add(a2, "arrow2");
		Arrow3 a3 = new Arrow3();
		cards.add(a3, "arrow3");
		Instructions how = new Instructions();
		cards.add(how, "how");
		WinScreen win = new WinScreen();
		cards.add(win, "win");
		LoseScreen lose = new LoseScreen();
		cards.add(lose, "lose");
		
		frame = new JFrame("Greek Olympics");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(cards);
		frame.setVisible(true);
		frame.setSize(1000,750);
		frame.setResizable(false);
	
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, "title");
		
	} //end of run()
	public class TitleScreen extends JPanel implements MouseListener
	{
		private boolean playButtonClicked, howButtonClicked, play, how;
		private int mouseX, mouseY;
		public TitleScreen()
		{
			playButtonClicked = howButtonClicked = play = false;
			mouseX = mouseY = 0;
			setFocusable(true);
			grabFocus(); 
			requestFocus(); 
			addMouseListener(this);
			how = false;
		}
		public void mousePressed (MouseEvent e)
		{
			mouseX = e.getX();
			mouseY = e.getY();
			if(mouseX >= 400 && mouseX <= 800 && mouseY >= 400 && mouseY <= 480) //if the mouse is pressing the play button
				playButtonClicked = true;
			else if(mouseX >= 400 && mouseX <= 600 && mouseY >= 490 && mouseY <= 570) //if the mouse is pressing the how to play button
				howButtonClicked = true;;
			grabFocus(); 
			repaint();
		}
		public void mouseReleased (MouseEvent e)
		{
			mouseX = e.getX();
			mouseY = e.getY();
			if(mouseX >= 400 && mouseX <= 600 && mouseY >= 400 && mouseY <= 480) //if the mouse is releasing the play button
			{
				playButtonClicked = false;
				play = true;
			}
			else if(mouseX >= 400 && mouseX <= 600 && mouseY >= 490 && mouseY <= 570)//if the mouse is releasing the how to play button
				howButtonClicked = false;
			grabFocus();
			repaint();
		}
		public void mouseClicked (MouseEvent e)
		{
			
		}
		public void mouseEntered (MouseEvent e) { }
		public void mouseExited (MouseEvent e)	{ }
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			setBackground(Color.WHITE);
			//declaring background image of title screen
			Image back = new ImageIcon("bigCol.jpg").getImage();
			//drawing background
			g.drawImage(back,0,0,1000,750,null);
			/*Graphics2D g2d = (Graphics2D)g;
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Image image = toolkit.getImage("Olympics.gif");
			g2d.drawImage(image,0,0,400,350,this);*/
			Image rings = new ImageIcon("olympic.png").getImage();
			g.drawImage(rings,250,60,500,280,null);
			
			Graphics2D g2d = (Graphics2D)g;
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Image fire1 = toolkit.getImage("200w.gif");
		//	g2d.drawImage(fire1,0,0,100,200,this);
			
			Image fire2 = toolkit.getImage("torch-olympic.gif");
			g2d.drawImage(fire2,130,0,200,350,this);
			g2d.drawImage(fire2,670,0,200,350,this);
			
			//declaring the play button image
			Image playButton = new ImageIcon("playButton.png").getImage();
			//the clicked play button image
			Image clickedPlayButton = new ImageIcon("clickedPlayButton.png").getImage();
			//the how button image
			Image howButton = new ImageIcon("how-to-play.png").getImage();
			//the clicked how button image
			Image clickedHowButton = new ImageIcon("clicked-how.png").getImage();
			if(playButtonClicked) //if play button is pressed
			{
				g.drawImage(clickedPlayButton,400,400,200,80,null);
				playButtonClicked = false;
			}
			else if(playButtonClicked == false) //play button released
			{
				g.drawImage(playButton,400,400,200,80,null);
			}
			
			if(howButtonClicked) //how button pressed
			{
				g.drawImage(clickedHowButton,400,490,200,80,null);
				howButtonClicked = false;
				how = true;
			}
			else //how button released
				g.drawImage(howButton,400,490,200,80,null);
			if(play) // play will call the events screenn
			{
				CardLayout hi = (CardLayout)(cards.getLayout());
				hi.show(cards, "events");
				System.out.println("EVENTS");
			}	
			if(how)
			{
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "how");
			}
			play = false;
			how = false;
		}
	
	} // end of TitleScreen class
	public class Instructions extends JPanel implements MouseListener
	{
		private boolean mainClicked, callTitle;
		private int x, y;
		public Instructions()
		{
			addMouseListener(this);
			mainClicked = false;
			x = y = 0;
			callTitle = false;
		}
		public void mousePressed(MouseEvent e)
		{ 
			x = e.getX();
			y = e.getY();
			if(x >= 425 && x <= 595 && y >= 640 && y <= 710)
				mainClicked = true;
			repaint();
			grabFocus();
		}
		public void mouseReleased(MouseEvent e) { }
		public void mouseClicked(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			setBackground(Color.BLACK);
			Image back = new ImageIcon("inside.jpg").getImage();
			g.drawImage(back,0,0,1000,750,null);
			Image title = new ImageIcon("How-to-Play-2.png").getImage();
			g.drawImage(title,250,0,500,200,null);
			Image runIcon = new ImageIcon("running.png").getImage();
			g.drawImage(runIcon,20,220,200,200,null);
			g.setColor(Color.BLACK);
			Font header = new Font("Impact",Font.PLAIN,30);
			g.setFont(header);
			g.drawString("Running Event",230,245);
			Font writing = new Font("San Serif",Font.BOLD,17);
			g.setFont(writing);
			g.drawString("There are 3 levels to the running event. Alternate clicking left and right arrow keys",230,265);
			Image arrowKeys = new ImageIcon("arrow-keys.jpg").getImage();
			g.drawImage(arrowKeys,820,270,170,130,null);
			g.drawString("The goal of this event is to beat the computer controlled sprite:",230,290);
			Image bolt = new ImageIcon("boltRunStarter.png").getImage();
			g.drawImage(bolt,230,300,80,120,null);
			g.drawString("This is the sprite you will control",310,320);
			g.drawString("In order to win, you must cross the finish line",310,350);
			g.drawString("If you do not cross the finish line, you will not win",310,380);
			g.drawString("Each level, your opponent will become increasingly faster",310,410);
			Image archeryIcon = new ImageIcon("ar.png").getImage();
			g.drawImage(archeryIcon,20,450,200,190,null);
			g.setFont(header);
			g.drawString("Archery Event",230,475);
			g.setFont(writing);
			g.drawString("There are also 3 levels to the archery event.Drag mouse of aim icon to aim",230,495);
			Image aimIcon = new ImageIcon("aim.png").getImage();
			g.drawImage(aimIcon,230,515,100,100,null);
			Image target = new ImageIcon("target.png").getImage();
			g.drawImage(target,860,500,130,130,null);
			g.drawString("The goal of Level 1 is to earn 450 points",330,520);
			g.drawString("The goal of Level 2 is to earn 450 points under 1 minute",330,545);
			g.drawString("The goal of Level 3 is to earn 450 points under 1 minute",330,570);
			g.drawString("with only 7 arrows",330,595);
			g.drawString("If you meet these requirements then you have won the event",330,620);
			Image mainMenu = new ImageIcon("mainMenu.png").getImage();
			Image clickedMainMenu = new ImageIcon("clickedMainMenu.png").getImage();
			if(mainClicked)
			{
				g.drawImage(clickedMainMenu,425,640,170,70,null);
				callTitle = true;
			}
			else if(mainClicked == false)
				g.drawImage(mainMenu,425,640,170,70,null);
			if(callTitle)
			{
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "title");
			}
		}
	}//end of Instructions class
	public class WinScreen extends JPanel implements MouseListener
	{
		private boolean continuePressed, continueClicked;
		private int x, y;
		public WinScreen()
		{
			addMouseListener(this);
			continuePressed = false;
			x = y = 0;
			continueClicked = false;
		}
		public void mousePressed(MouseEvent e) 
		{ 
			x = e.getX();
			y = e.getY();
			if(x >= 390 && x <= 610 && y >= 600 && y <= 690)
				continuePressed = true;
		}
		public void mouseReleased(MouseEvent e) { }
		public void mouseClicked(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Image back = new ImageIcon("templeBuilding.jpg").getImage();
			g.drawImage(back,0,0,1000,750,null);
			Font impact = new Font("Impact",Font.PLAIN,90);
			g.setFont(impact);
			g.drawString("YOU WON!",325,85);

			Graphics2D g2d = (Graphics2D)g;
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Image image = toolkit.getImage("source.gif");
			g2d.drawImage(image,275,100,450,450,this);
			Image continueButton = new ImageIcon("continueButton.png").getImage();
			Image clickedContinueButton = new ImageIcon("clickedContinueButton.png").getImage();
			
			if(continuePressed)
			{
				g.drawImage(clickedContinueButton,390,600,220,80,null);
				continuePressed = false; 
				continueClicked = true;
				System.out.println("CONTINUE PRESSED");
			}
			else if(continuePressed == false)
				g.drawImage(continueButton,390,600,220,80,null);
			if(continueClicked)
			{
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "events");
			}
			continueClicked = false;
			System.exit(1);
		}
	}//end of WinScreen class
	public class LoseScreen extends JPanel implements MouseListener
	{
		private boolean continueClicked, continuePressed;
		private int x, y;
		public LoseScreen()
		{
			addMouseListener(this);
			continueClicked = continuePressed = false;
			x = y = 0;
		}
		public void mousePressed(MouseEvent e) 
		{ 
			x = e.getX();
			y = e.getY();
			if(x >= 390 && x <= 610 && y >= 600 && y <= 690)
			{
				continuePressed = true;
				System.out.println("CONTINUE");
			}
			repaint();
		}
		public void mouseReleased(MouseEvent e) { }
		public void mouseClicked(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			setBackground(Color.BLACK);
			Image gameOver = new ImageIcon("game-over.png").getImage();
			g.drawImage(gameOver,50,0,900,500,null);
			
			Image continueButton = new ImageIcon("continueButton.png").getImage();
				Image clickedContinueButton = new ImageIcon("clickedContinueButton.png").getImage();
			if(continuePressed)
			{
				g.drawImage(clickedContinueButton,390,600,220,80,null);
				continuePressed = false; 
				continueClicked = true;
			}
			else if(continuePressed == false)
				g.drawImage(continueButton,390,600,220,80,null);
			if(continueClicked)
			{
				//continueClicked = false;
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "events");
				System.out.println("STILL HERE");
				//continueClicked = false;
			}
			System.exit(1);
			//continueClicked = false;
		}//end of paintComponent()
	}//end of the LoseScreen class
	public class EventsScreen extends JPanel implements MouseListener
	{
		boolean run1Clicked, run2Clicked, run3Clicked, archery3Clicked, archery1Clicked, archery2Clicked;
		private int x, y;
		private boolean buttonPressed;
		private boolean buttonClicked;
		private boolean bbClicked;
		private boolean goBack;
		boolean pressed;
		boolean start = true;
		public EventsScreen()
		{
			System.out.println("EVENTS SCREEN");
			addMouseListener(this);
			setFocusable(true);
		grabFocus(); 
			x = 0;
			y = 0;
			buttonPressed = false;
			buttonClicked = false;
			bbClicked = false;
			goBack = false;
			run1Clicked = false;
			run2Clicked = false;
			archery3Clicked = false;
			run3Clicked = false;
			archery1Clicked = false;
			archery2Clicked = false;
			pressed = false;
			
		}
		public void mousePressed(MouseEvent e) 
		{ 
			System.out.println("PRESSED");
			pressed = true;
			x = e.getX();
			y = e.getY();
			if(x >= 415 && x <= 595 && y >= 620 && y <= 700)
				buttonPressed = true;
			if(x >= 165 && x <= 315 && y >= 120 && y <= 320)
				run1Clicked = true;
			else if(x >= 425 && x <= 575 && y >= 120 && y <= 320)
				run2Clicked = true;
			else if(x >= 685 && x <= 835 && y >= 120 && y <= 320)
				run3Clicked = true;
			else if(x >= 165 && x <= 315 && y >= 400 && y <= 600)
				archery1Clicked = true;
			else if(x >= 425 && x <= 575 && y >= 400 && y <= 600)
				archery2Clicked = true;
			else if(x >= 685 && x <= 835 && y >= 400 && y <= 600)
				archery3Clicked = true;
			if(run1Clicked == true || run2Clicked == true || archery3Clicked == true || run3Clicked == true || archery1Clicked == true || archery2Clicked == true)
			{
				if(x >= 165 && x <= 315 && y >= 120 && y <= 320)
				{
					run1Clicked = true;
					run2Clicked = false;
					run3Clicked = false;
					archery3Clicked = false;
					archery1Clicked = false;
					archery2Clicked = false;
					System.out.println("TRUE");
				}
				else if(x >= 425 && x <= 575 && y >= 120 && y <= 320)
				{
					run2Clicked = true;
					run3Clicked = false;
					archery3Clicked = false;
					archery1Clicked = false;
					archery2Clicked = false;
					run1Clicked = false;
				}
				else if(x >= 685 && x <= 835 && y >= 120 && y <= 320)
				{
					run3Clicked = true;
					archery3Clicked = false;
					archery1Clicked = false;
					archery2Clicked = false;
					run1Clicked = false;
					run2Clicked = false;
				}
				else if(x >= 165 && x <= 315 && y >= 400 && y <= 600)
				{
					archery1Clicked = true;
					archery2Clicked = false;
					archery3Clicked = false;
					run1Clicked = false;
					run2Clicked = false;
					run3Clicked = false;
				}
				else if(x >= 425 && x <= 575 && y >= 400 && y <= 600)
				{
					archery2Clicked = true;
					archery3Clicked = false;
					run1Clicked = false;
					run2Clicked = false;
					run3Clicked = false;
					archery1Clicked = false;
				}
				else if(x >= 685 && x <= 835 && y >= 400 && y <= 600)
				{
					archery3Clicked = true;
					run1Clicked = false;
					run2Clicked = false;
					run3Clicked = false;
					archery2Clicked = false;
					archery1Clicked = false;
				}
			}
			if(x >= 0 && x <= 100 && y >= 630 && y <= 730)
				bbClicked = true;
			grabFocus();
			repaint();
		} 
		public void mouseReleased(MouseEvent e){ }	
		public void mouseClicked(MouseEvent e)
		{
			
		}
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			System.out.println("PAINTING");
			if(start)
			{
		/*		addMouseListener(this);
		setFocusable(true);
		grabFocus(); 
		requestFocus(); */
				x = 0;
			y = 0;
			buttonPressed = false;
			buttonClicked = false;
			bbClicked = false;
			goBack = false;
			run1Clicked = false;
			run2Clicked = false;
			archery3Clicked = false;
			run3Clicked = false;
			archery1Clicked = false;
			archery2Clicked = false;
			pressed = false;
			}
			start = false;
			Image back = new ImageIcon("temple.jpg").getImage();
			g.drawImage(back,0,0,1000,750,null);
			Font header = new Font("Impact",Font.PLAIN,70);
			g.setFont(header);
			g.setColor(Color.WHITE);
			g.drawString("EVENTS",400,90);
			Font impact = new Font("Impact",Font.PLAIN,40);
			g.setFont(impact);
			g.drawString("Running",10,220);
			g.setColor(Color.BLACK);
			g.drawString("Archery",10,500);
			Image run1 = new ImageIcon("run1.png").getImage();
			g.drawImage(run1,165,120,150,200,null);
			Image run2 = new ImageIcon("run2.png").getImage();
			g.drawImage(run2,425,120,150,200,null);
			Image run3 = new ImageIcon("run3.png").getImage();
			g.drawImage(run3,685,120,150,200,null);
			//System.out.println("PAINTED");
			Image archery1 = new ImageIcon("archery1.png").getImage();
			g.drawImage(archery1,165,400,150,200,null);
			Image archery2 = new ImageIcon("archery2.png").getImage();
			g.drawImage(archery2,425,400,150,200,null);
			Image archery3 = new ImageIcon("archery3.png").getImage();
			g.drawImage(archery3,685,400,150,200,null);
			
			Image check = new ImageIcon("checkin.png").getImage();
			if(pressed)
			{
				if(run1Clicked)
					g.drawImage(check,165,120,150,200,null);
				if(run2Clicked)
					g.drawImage(check,425,120,150,200,null);
				if(run3Clicked)
					g.drawImage(check,685,140,150,200,null);
				if(archery1Clicked)
					g.drawImage(check,165,400,150,200,null);
				if(archery2Clicked)
					g.drawImage(check,425,400,150,200,null);
				if(archery3Clicked)
					g.drawImage(check,685,400,150,200,null);
			}
				
			Image playNow = new ImageIcon("playNowButton.png").getImage();
			Image clickedPlayNow = new ImageIcon("clickedPlayNowButton.png").getImage();
			if(buttonPressed)
			{
				g.drawImage(clickedPlayNow,415,620,180,80,null);
				buttonPressed = false;
				buttonClicked = true;
			}
			else if(buttonPressed == false)
				g.drawImage(playNow,415,620,180,80,null);
			if(buttonClicked)
			{
				if(run1Clicked)
				{
					CardLayout cl = (CardLayout)(cards.getLayout());
					cl.show(cards, "running1");
				}
				else if(run2Clicked)
				{
					CardLayout cl = (CardLayout)(cards.getLayout());
					cl.show(cards, "running2");
				}
				else if(run3Clicked)
				{
					CardLayout cl = (CardLayout)(cards.getLayout());
					cl.show(cards, "running3");
				}
				else if(archery3Clicked)
				{
					CardLayout cl = (CardLayout)(cards.getLayout());
					cl.show(cards, "arrow3");
				}
				else if(archery1Clicked)
				{
					CardLayout cl = (CardLayout)(cards.getLayout());
					cl.show(cards, "arrow1");
				}
				else if(archery2Clicked)
				{
					CardLayout cl = (CardLayout)(cards.getLayout());
					cl.show(cards, "arrow2");
				}
			}
			
			Image backButton = new ImageIcon("backButton.png").getImage();
			Image clickedBackButton = new ImageIcon("clickedBackButton.png").getImage();
			if(bbClicked)
			{
				g.drawImage(clickedBackButton,0,630,100,100,null);
				bbClicked  = false;
				goBack = true;
			}	
			else if(bbClicked == false)
				g.drawImage(backButton,0,630,100,100,null);
			if(goBack)
			{
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "title");
			}
			
		}
		
			
	} //end of EventsScreen class
	public class RunningLevel1 extends JPanel implements KeyListener, MouseListener
	{
		
		private boolean up,down,firstBolt, wrestStart, wArray, blueArray, blueStart, userWins, wrestWins;
		private int xbolt, runCount, wrestX, blueX, count, xpos, lfcount;
		private Timer wTimer, blueTimer, countdownTimer;
		private Image [] wrestler = new Image[3];
		private Image [] blue = new Image[3];
		private int x,y;
		private boolean continuePressed;
		private boolean start;
		
		public RunningLevel1()
		{
		   addKeyListener(this);
		   firstBolt = true;
		   up = down = false;
		   wArray = blueArray = true;
		   xbolt = 0;
		   count = 4;
		   xpos = 0;
		   lfcount = -1;
		   runCount = wrestX = blueX = 0;
		   wrestStart = blueStart = true;
		   //declare Wrestler images
		   Image wStart = new ImageIcon("wrestlerStart.jpg").getImage();
		   Image wUp = new ImageIcon("wrestlerUp.jpg").getImage();
		   Image wDown = new ImageIcon("wrestlerDown.jpg").getImage();
		   //Assigning wrestler image array
		   wrestler[0] = wStart;
		   wrestler[1] = wUp; //120
		   wrestler[2] = wDown;
		   //create timer for wrestler
		   wMover wrestM = new wMover();
		   wTimer = new Timer(200, wrestM);
		   //wTimer.start(); //starting the wrestler's timer
		   userWins = false;
		   wrestWins = false;
		   continuePressed = false;
		   start = true;
		   System.out.print("up = " + up);
		}
		class CountDown implements ActionListener //timer for the 3-2-1 countdown timer
		{
			public void actionPerformed(ActionEvent e)
			{
				count--;
				if(count == -1) //after the word go is displayed, all the other runner's timers are started and the countdown timer is stopped
				{
					countdownTimer.stop();
					wTimer.start();
				}
				else
					repaint(); //drawing the 3-2-1-or go strings
			}
		}
		class wMover implements ActionListener //class for timer of wrestler for incrementing x position of image
		{
			public void actionPerformed(ActionEvent e) //deciding which image in the array should be displayed
			{
				wrestX += 15;
				if(wArray)	//deciding which index of image array
					wArray = false;
				else
					wArray = true;
				if(wrestX >= 930) //where the finish line is located
				{
					wTimer.stop();
					wrestWins = true;
				}
				repaint();
				grabFocus();
			}
		}
		public void keyTyped(KeyEvent e)
		{ }
		public void keyPressed(KeyEvent e) //checking if the right and left arrow keys have been clicked by the user
		{ 
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) //if the right arrow key is clicked, increment the x position of the image
				{
					up = true;
					firstBolt = false;
					down = false;
					xbolt += 15;
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT) //if left arrow key is clicked, also incrementing position of image
				{
					down = true;
					up = false;
					xbolt += 15;
				}
				repaint(); 
		} 
		public void keyReleased(KeyEvent e)
		{ 
			if(userWins)
			{
				if(x >= 400 && x <= 640 && y >= 400 && y <= 490)
					continuePressed = false;
				repaint();
			}
		}  
		public void mousePressed(MouseEvent e) { }
		public void mouseReleased(MouseEvent e) { }
		public void mouseClicked(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
		public void paintComponent(Graphics g)
		{
			if(start)
			{
				CountDown cd = new CountDown();
				countdownTimer = new Timer(1000, cd);
				countdownTimer.start(); 
				start = false;
			}
			if(userWins)
			{
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "win");
				
			}
			else if(wrestWins)
			{
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "lose");
			}
			else
			{
				Image back = new ImageIcon("trackBack.png").getImage();
				//declare Usain bolt images
				Image pillarBack = new ImageIcon("pillar-back.jpg").getImage();
				g.drawImage(pillarBack,0,0,1000,750,null);
				
				Image boltStart = new ImageIcon("boltRunStarter.png").getImage();
				Image bolt1 = new ImageIcon("boltRun1.png").getImage();
				Image bolt2 = new ImageIcon("boltRun2.png").getImage();
				
				g.drawImage(pillarBack,0,0,1000,750,null);
				
				for(int i = 0;i < 10;i++)
				{
					xpos += 100*i;
					g.drawImage(back,xpos,300,100,150,null);
					xpos = 0;
				}
				
				Color gray = new Color(105,105,105);
				g.setColor(gray);
				g.fillRect(118,200,764,100);
				
				Color line = new Color(240,207,181);
				g.setColor(line);
				Graphics2D g2 = (Graphics2D)g;
				g2.setStroke(new BasicStroke(4));
				g2.drawLine(70,300,70,450);
				
				Image people = new ImageIcon("group-of-people-clipart-5.jpg").getImage();
				g.drawImage(people,200,200,300,100,null);
				g.drawImage(people,500,200,300,100,null);
				
				Image dash = new ImageIcon("impact.png").getImage();
				g.drawImage(dash,300,60,400,100,null);
				
				Image check = new ImageIcon("checkered.jpg").getImage();
				g.drawImage(check,940,300,20,150,null);
				
				if(count==3)
				{
					Image three = new ImageIcon("three.png").getImage();
					g.drawImage(three,750,0,100,100,null);
				}	
				else if(count == 2)
				{
					Image two = new ImageIcon("two.png").getImage();
					g.drawImage(two,750,0,100,100,null);
				}
				else if(count == 1)
				{
					Image one = new ImageIcon("one.png").getImage();
					g.drawImage(one,750,0,100,100,null);
				}
				else if(count == 0)
				{
					Image go = new ImageIcon("go.png").getImage();
					g.drawImage(go,750,0,200,200,null);
				}
				//draw wrestler
				if(wrestStart) //for the starting position of the wrestler
				{
					g.drawImage(wrestler[0],0,290,60,80,null);
					wrestStart = false; //after start of wrestler, make false so it doesn't show up again
				}
				else
				{
					if(wArray) //the 1st index of the array
						g.drawImage(wrestler[1],wrestX,290,60,80,null);
					else      //the 2nd index of the array
						g.drawImage(wrestler[2],wrestX,290,60,80,null);
					
				}
				//drawing Usain Bolt
				if(firstBolt) //starting position of Usain Bolt
				{
					g.drawImage(boltStart,0,325,60,90,null);
				}
				else if(up) //when right arrow key clicked, 1st index of array is displayed
				{
					g.drawImage(bolt1,xbolt,325,50,80,null);
				}
				else if(down) //when left arrow key clicked, 2nd index of array is displayed
				{ 
					g.drawImage(bolt2,xbolt,325,70,90,null);
				} 
				
				if(xbolt >= 930)
				{
					wTimer.stop();
					userWins = true;
				}
			}
		} //end of paintComponent()	
	}//end of RunningLevel1 class
	public class RunningLevel2 extends JPanel implements KeyListener
	{
		private boolean up,down,firstBolt, wrestStart, wArray, blueArray, blueStart, userWins, wrestWins;
		private int xbolt, runCount, wrestX, blueX, count, xpos, lfcount;
		private Timer wTimer, blueTimer, countdownTimer;
		private Image [] wrestler = new Image[3];
		private Image [] blue = new Image[3];
		private int x,y;
		private boolean continuePressed;
		private boolean start;
		public RunningLevel2()
		{
		   addKeyListener(this);
		   firstBolt = true;
		   up = down = false;
		   wArray = blueArray = true;
		   xbolt = 0;
		   count = 4;
		   xpos = 0;
		   lfcount = -1;
		   runCount = wrestX = blueX = 0;
		   wrestStart = blueStart = true;
		   //declare Wrestler images
		   Image wStart = new ImageIcon("wrestlerStart.jpg").getImage();
		   Image wUp = new ImageIcon("wrestlerUp.jpg").getImage();
		   Image wDown = new ImageIcon("wrestlerDown.jpg").getImage();
		   //Assigning wrestler image array
		   wrestler[0] = wStart;
		   wrestler[1] = wUp; //120
		   wrestler[2] = wDown;
		   //create timer for wrestler
		   wMover wrestM = new wMover();
		   wTimer = new Timer(110, wrestM);
		   //wTimer.start(); //starting the wrestler's timer
		   start = true;
		   userWins = false;
		   wrestWins = false;
		   continuePressed = false;
		}
		class CountDown implements ActionListener //timer for the 3-2-1 countdown timer
		{
			public void actionPerformed(ActionEvent e)
			{
				count--;
				if(count == -1) //after the word go is displayed, all the other runner's timers are started and the countdown timer is stopped
				{
					countdownTimer.stop();
					wTimer.start();
				}
				else
					repaint(); //drawing the 3-2-1-or go strings
			}
		}
		class wMover implements ActionListener //class for timer of wrestler for incrementing x position of image
		{
			public void actionPerformed(ActionEvent e) //deciding which image in the array should be displayed
			{
				wrestX += 15;
				if(wArray)	//deciding which index of image array
					wArray = false;
				else
					wArray = true;
				if(wrestX >= 930) //where the finish line is located
				{
					wTimer.stop();
					wrestWins = true;
				}
				repaint();
				grabFocus();
			}
		}
		public void keyTyped(KeyEvent e)
		{ }
		public void keyPressed(KeyEvent e) //checking if the right and left arrow keys have been clicked by the user
		{ 
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) //if the right arrow key is clicked, increment the x position of the image
				{
					up = true;
					firstBolt = false;
					down = false;
					xbolt += 15;
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT) //if left arrow key is clicked, also incrementing position of image
				{
					down = true;
					up = false;
					xbolt += 15;
				}
				repaint(); 
		} 
		public void keyReleased(KeyEvent e)
		{ 
			if(userWins)
			{
				if(x >= 400 && x <= 640 && y >= 400 && y <= 490)
					continuePressed = false;
				repaint();
			}
		}  
		public void paintComponent(Graphics g)
		{
			if(start)
			{
				CountDown cd = new CountDown();
				countdownTimer = new Timer(1000, cd);
				countdownTimer.start(); 
				start = false;
			}
			if(userWins)
			{
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "win");
			}
			else if(wrestWins)
			{
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "lose");
			}
			else
			{
				Image back = new ImageIcon("trackBack.png").getImage();
				//declare Usain bolt images
				Image pillarBack = new ImageIcon("pillar-back.jpg").getImage();
				g.drawImage(pillarBack,0,0,1000,750,null);
				Image boltStart = new ImageIcon("boltRunStarter.png").getImage();
				Image bolt1 = new ImageIcon("boltRun1.png").getImage();
				Image bolt2 = new ImageIcon("boltRun2.png").getImage();
				
				g.drawImage(pillarBack,0,0,1000,750,null);
				
				for(int i = 0;i < 10;i++)
				{
					xpos += 100*i;
					g.drawImage(back,xpos,300,100,150,null);
					xpos = 0;
				}
				
				Color gray = new Color(105,105,105);
				g.setColor(gray);
				g.fillRect(118,200,764,100);
				
				Color line = new Color(240,207,181);
				g.setColor(line);
				Graphics2D g2 = (Graphics2D)g;
				g2.setStroke(new BasicStroke(4));
				g2.drawLine(70,300,70,450);
				
				Image people = new ImageIcon("group-of-people-clipart-5.jpg").getImage();
				g.drawImage(people,200,200,300,100,null);
				g.drawImage(people,500,200,300,100,null);
				
				Image dash = new ImageIcon("impact.png").getImage();
				g.drawImage(dash,300,60,400,100,null);
				
				Image check = new ImageIcon("checkered.jpg").getImage();
				g.drawImage(check,940,300,20,150,null);
				
				if(count==3)
				{
					Image three = new ImageIcon("three.png").getImage();
					g.drawImage(three,750,0,100,100,null);
				}	
				else if(count == 2)
				{
					Image two = new ImageIcon("two.png").getImage();
					g.drawImage(two,750,0,100,100,null);
				}
				else if(count == 1)
				{
					Image one = new ImageIcon("one.png").getImage();
					g.drawImage(one,750,0,100,100,null);
				}
				else if(count == 0)
				{
					Image go = new ImageIcon("go.png").getImage();
					g.drawImage(go,750,0,200,200,null);
				}
				//draw wrestler
				if(wrestStart) //for the starting position of the wrestler
				{
					g.drawImage(wrestler[0],0,290,60,80,null);
					wrestStart = false; //after start of wrestler, make false so it doesn't show up again
				}
				else
				{
					if(wArray) //the 1st index of the array
						g.drawImage(wrestler[1],wrestX,290,60,80,null);
					else      //the 2nd index of the array
						g.drawImage(wrestler[2],wrestX,290,60,80,null);
				}
				//drawing Usain Bolt
				if(firstBolt) //starting position of Usain Bolt
				{
					g.drawImage(boltStart,0,325,60,90,null);
				}
				else if(up) //when right arrow key clicked, 1st index of array is displayed
				{
					g.drawImage(bolt1,xbolt,325,50,80,null);
				}
				else if(down) //when left arrow key clicked, 2nd index of array is displayed
				{ 
					g.drawImage(bolt2,xbolt,325,70,90,null);
				} 
				
				if(xbolt >= 930)
				{
					wTimer.stop();
					userWins = true;
				}
			}
		} //end of paintComponent()
	}//end of RunningLevel2 class
	public class RunningLevel3 extends JPanel implements KeyListener
	{
		private boolean up,down,firstBolt, wrestStart, wArray, blueArray, blueStart, userWins, wrestWins;
		private int xbolt, runCount, wrestX, blueX, count, xpos, lfcount;
		private Timer wTimer, blueTimer, countdownTimer;
		private Image [] wrestler = new Image[3];
		private Image [] blue = new Image[3];
		private int x,y;
		private boolean continuePressed;
		public RunningLevel3()
		{
		   addKeyListener(this);
		   firstBolt = true;
		   up = down = false;
		   wArray = blueArray = true;
		   xbolt = 0;
		   count = 4;
		   xpos = 0;
		   lfcount = -1;
		   runCount = wrestX = blueX = 0;
		   wrestStart = blueStart = true;
		   //declare Wrestler images
		   Image wStart = new ImageIcon("wrestlerStart.jpg").getImage();
		   Image wUp = new ImageIcon("wrestlerUp.jpg").getImage();
		   Image wDown = new ImageIcon("wrestlerDown.jpg").getImage();
		   //Assigning wrestler image array
		   wrestler[0] = wStart;
		   wrestler[1] = wUp; //120
		   wrestler[2] = wDown;
		   //create timer for wrestler
		   wMover wrestM = new wMover();
		   wTimer = new Timer(80, wrestM);
		   //wTimer.start(); //starting the wrestler's timer
		   CountDown cd = new CountDown();
		   countdownTimer = new Timer(1000, cd);
		   countdownTimer.start(); 
		  /* Image fire1 = new ImageIcon("fire1.png").getImage();
		   Image fire2 = new ImageIcon("fire2.png").getImage();
		   Image fire3 = new ImageIcon("fire3.png").getImage();
		   Image fire4 = new ImageIcon("fire4.png").getImage();
		   Image fire5 = new ImageIcon("fire5.png").getImage();
		   Image fire6 = new ImageIcon("fire6.png").getImage();
		   fire[0] = fire1;
		   fire[1] = fire2;
		   fire[2] = fire3;
		   fire[3] = fire4;
		   fire[4] = fire5;
		   fire[5] = fire6; */
		   userWins = false;
		   wrestWins = false;
		   continuePressed = false;
		}
		class CountDown implements ActionListener //timer for the 3-2-1 countdown timer
		{
			public void actionPerformed(ActionEvent e)
			{
				count--;
				if(count == -1) //after the word go is displayed, all the other runner's timers are started and the countdown timer is stopped
				{
					countdownTimer.stop();
					wTimer.start();
				}
				else
					repaint(); //drawing the 3-2-1-or go strings
			}
		}
		class wMover implements ActionListener //class for timer of wrestler for incrementing x position of image
		{
			public void actionPerformed(ActionEvent e) //deciding which image in the array should be displayed
			{
				wrestX += 15;
				if(wArray)	//deciding which index of image array
					wArray = false;
				else
					wArray = true;
				if(wrestX >= 930) //where the finish line is located
				{
					wTimer.stop();
					wrestWins = true;
				}
				repaint();
				grabFocus();
			}
		}
		public void keyTyped(KeyEvent e)
		{ }
		public void keyPressed(KeyEvent e) //checking if the right and left arrow keys have been clicked by the user
		{ 
			/*x = e.getX();
			y = e.getY();
			if(userWins)
			{
				if(x >= 400 && x <= 640 && y >= 400 && y <= 490)
					continuePressed = true;
				repaint();
			}*/
			//else
			//{
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) //if the right arrow key is clicked, increment the x position of the image
				{
					up = true;
					firstBolt = false;
					down = false;
					xbolt += 15;
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT) //if left arrow key is clicked, also incrementing position of image
				{
					down = true;
					up = false;
					xbolt += 15;
				}
				repaint(); 
			//}
		} 
		public void keyReleased(KeyEvent e)
		{ 
			if(userWins)
			{
				if(x >= 400 && x <= 640 && y >= 400 && y <= 490)
					continuePressed = false;
				repaint();
			}
		}  
		public void paintComponent(Graphics g)
		{
			if(userWins)
			{
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "win");
			}
			else if(wrestWins)
			{
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "lose");
			}
			else
			{
				Image back = new ImageIcon("trackBack.png").getImage();
				//declare Usain bolt images
				Image pillarBack = new ImageIcon("pillar-back.jpg").getImage();
				g.drawImage(pillarBack,0,0,1000,750,null);
				
				Image boltStart = new ImageIcon("boltRunStarter.png").getImage();
				Image bolt1 = new ImageIcon("boltRun1.png").getImage();
				Image bolt2 = new ImageIcon("boltRun2.png").getImage();
				
				g.drawImage(pillarBack,0,0,1000,750,null);
				
				for(int i = 0;i < 10;i++)
				{
					xpos += 100*i;
					g.drawImage(back,xpos,300,100,150,null);
					xpos = 0;
				}
				
				Color gray = new Color(105,105,105);
				g.setColor(gray);
				g.fillRect(118,200,764,100);
				
				Color line = new Color(240,207,181);
				g.setColor(line);
				Graphics2D g2 = (Graphics2D)g;
				g2.setStroke(new BasicStroke(4));
				g2.drawLine(70,300,70,450);
				
				Image people = new ImageIcon("group-of-people-clipart-5.jpg").getImage();
				g.drawImage(people,200,200,300,100,null);
				g.drawImage(people,500,200,300,100,null);
				
				Image dash = new ImageIcon("impact.png").getImage();
				g.drawImage(dash,300,60,400,100,null);
				
				Image check = new ImageIcon("checkered.jpg").getImage();
				g.drawImage(check,940,300,20,150,null);
				
				if(count==3)
				{
					Image three = new ImageIcon("three.png").getImage();
					g.drawImage(three,750,0,100,100,null);
				}	
				else if(count == 2)
				{
					Image two = new ImageIcon("two.png").getImage();
					g.drawImage(two,750,0,100,100,null);
				}
				else if(count == 1)
				{
					Image one = new ImageIcon("one.png").getImage();
					g.drawImage(one,750,0,100,100,null);
				}
				else if(count == 0)
				{
					Image go = new ImageIcon("go.png").getImage();
					g.drawImage(go,750,0,200,200,null);
				}
				//draw wrestler
				if(wrestStart) //for the starting position of the wrestler
				{
					g.drawImage(wrestler[0],0,290,60,80,null);
					wrestStart = false; //after start of wrestler, make false so it doesn't show up again
				}
				else
				{
					if(wArray) //the 1st index of the array
						g.drawImage(wrestler[1],wrestX,290,60,80,null);
					else      //the 2nd index of the array
						g.drawImage(wrestler[2],wrestX,290,60,80,null);
				}
				//drawing Usain Bolt
				if(firstBolt) //starting position of Usain Bolt
				{
					g.drawImage(boltStart,0,325,60,90,null);
				}
				else if(up) //when right arrow key clicked, 1st index of array is displayed
				{
					g.drawImage(bolt1,xbolt,325,50,80,null);
				}
				else if(down) //when left arrow key clicked, 2nd index of array is displayed
				{ 
					g.drawImage(bolt2,xbolt,325,70,90,null);
				} 
				
				if(xbolt >= 930)
				{
					wTimer.stop();
					userWins = true;
				}
			}
		} //end of paintComponent()
	}//end of RunningLevel3 class
	public class Arrow1 extends JPanel implements MouseListener, MouseMotionListener, KeyListener //Archery Event game
	{
		private int aimX, aimY;
		private Image [] arrow = new Image[8];
		private Timer arrowTimer;
		private int count;
		private boolean arrowMove;
		private boolean arrowNotMoving;
		private int x,y;
		private boolean dragged;
		private boolean bigTarget;
		private boolean left, right;
		private int yellowRadius;
		private int userX, userY;
		private int userRadius;
		private int redRadius;
		private int blueRadius;
		private int blackRadius;
		private int whiteRadius;
		private boolean yellow, red, blue, black, white, out, center;
		//all the possible points the arrow can land on, on the left or right side of the target
		private int [] redPointsRight = {451,320,451,230};
		private int [] redPointsLeft = {520,330,530,230};
		private int [] bluePointsRight = {390,320,490,390};
		private int [] bluePointsLeft = {590,320,490,170};
		private int [] whitePointsRight = {270,320,485,50};
		private int [] whitePointsLeft = {700,320,485,490};
		private int [] blackPointsRight = {485,100,340,320};
		private int [] blackPointsLeft = {485,440, 650,320};
		private int [] yellowPointsRight = {518,290,478,258};
		private int [] yellowPointsLeft = {478,290,518,258};
		private int [] centerPoints = {498,274};
		private int index;
		private int centerOrNot;
		private int arrowX, arrowY;
		private boolean onTarget;
		private int aimPointY, aimPointX;
		private int arrowPointX, arrowPointY;
		private int score;
		private boolean enter;
		private boolean gameOver;
		private boolean userWins;
		public Arrow1()
		{
			score = 0;
			index = 0;
			aimX = 598;
			aimY = 334;
			addMouseListener(this);
			addMouseMotionListener(this);
			addKeyListener(this);
			//frames of the arrow images, to make it look like an arrow moving closer to the target
			Image a1 = new ImageIcon("arrow1.png").getImage();
			Image a2 = new ImageIcon("arrow2.png").getImage();
			Image a3 = new ImageIcon("arrow3.png").getImage();
			Image a4 = new ImageIcon("arrow4.png").getImage();
			Image a8 = new ImageIcon("arrow5.png").getImage();
			Image a5 = new ImageIcon("arrow6.png").getImage();
			Image a6 = new ImageIcon("arrow7.png").getImage();
			Image a7 = new ImageIcon("arrow8.png").getImage();
			arrow[0] = a1;
			arrow[1] = a2;
			arrow[2] = a3;
			arrow[3] = a4;
			arrow[4] = a5;
			arrow[5] = a6;
			arrow[6] = a7;
			arrow[7] = a8;
			//the mover for the arrow moving to the target
			ArrowMover amover = new ArrowMover();
			//initializing the timer
			arrowTimer = new Timer(500,amover);
			count = -1;
			bigTarget = false;
			left = right = false;
			yellow = red = blue = black = white = false;
			onTarget = false;
			arrowNotMoving = true;
			arrowX = arrowY = 0;
			center = false;
			enter = false;
			gameOver = false;
			userWins = false;
		}
		public class ArrowMover implements ActionListener //class responsible for making arrow lool like its moving towards the target
		{
			public void actionPerformed(ActionEvent e)
			{
				//System.out.println(count);
				count++;
				if(count == 7) //the last index of the arrow image array
				{
					arrowTimer.stop(); //stopping the timer when the image array is finished
					arrowMove = false;
					bigTarget = true; 
					if(aimX <= 475)
						deriveLocation(0); //the left side of ther target location
					else if(aimX >= 475)
						deriveLocation(1); //the right side of their target location
				} 
				repaint();
				grabFocus();
			}
		}
		public void deriveLocation(int direction) //figuring out with color the arrow landed on the target 
		{
			if(direction == 0)
				left = true;
			else
				right = true;
			if(left)
			{
				//finding the radiuses of all the sections of colors on the target
				yellowRadius = 471 - 463;
				redRadius = 471 - 435;
				blueRadius = 471 - 434;
				blackRadius = 471 - 419;
				whiteRadius = 471 - 400;
				if(userY == 350) //finding the user's radiuses if it is a point on y = 350
					userRadius = 471 - userX;
				else //finding "hypotenuse" through points
					userRadius = (int)(Math.sqrt(Math.pow((350-userY),2) + Math.pow((471 - userX),2)));
				//deciding which color the point is on
				if(userRadius <= yellowRadius)
					yellow = true;
				else if(userRadius <= redRadius && userRadius > yellowRadius)
					red = true;
				else if(userRadius <= blueRadius && userRadius > redRadius)
					blue = true;
				else if(userRadius <= blackRadius && userRadius > blueRadius)
					black = true;
				else if(userRadius <= whiteRadius && userRadius > blackRadius)
					white = true;
				else
					out = true; //if the arrow never hit the target
			}
			else if(right)
			{
				//same thing applies as above
				yellowRadius = 484 - 471;
				redRadius = 499-471;
				blueRadius = 515 - 471;
				blackRadius = 531 - 471;
				whiteRadius = 549 -471;
				if(userY == 350)
					userRadius = userX - 471;
				else
					userRadius = (int)(Math.sqrt(Math.pow(userX - 471, 2)+Math.pow(350 - userY, 2)));
						
				if(userRadius <= yellowRadius)
					yellow = true;
				else if(userRadius <= redRadius && userRadius > yellowRadius)
					red = true;
				else if(userRadius <= blueRadius && userRadius > redRadius)
					blue = true;
				else if(userRadius <= blackRadius && userRadius > blueRadius)
					black = true;
				else if(userRadius <= whiteRadius && userRadius > blackRadius)
					white = true;
				else
					out = true;
			}
			color(); // calling color to find where the arrow will be shown to land on the bigger version of the target
		}  
		public void color() //finding coordinates of where arrow will be shown on bigger target
		{
			
			index = (int)(Math.random()*2+1); //randomly chosen index of the array of points
			if(index == 1)
				index = 0;
			else if(index == 2)
				index = 2;
			
			System.out.println("index = " + index);
			
			//using each color and using the index to find the coordinates
			if(yellow)
			{
				centerOrNot = (int)(Math.random()*2+1);
				if(centerOrNot == 1)
				{
					arrowX = centerPoints[0];
					arrowY = centerPoints[1];
					center = true;
				}
				else
				{
					if(left)
					{
						arrowX = yellowPointsLeft[index];
						index++;
						arrowY = yellowPointsLeft[index];
					}
					else
					{
						arrowX = yellowPointsRight[index];
						index++;
						arrowY = yellowPointsRight[index];
					}
				}
				//System.out.println("YELLOW");
			}
			else if(red)
			{
				if(left)
				{
					arrowX = redPointsLeft[index];
					index++;
					arrowY = redPointsLeft[index];
				}
				else
				{
					arrowX = redPointsRight[index];
					index++;
					arrowY = redPointsRight[index];
				}
				//System.out.println("RED");
			}
			else if(blue)
			{
				if(left)
				{
					arrowX = bluePointsLeft[index];
					index++;
					arrowY = bluePointsLeft[index];
				}
				else
				{
					arrowX = bluePointsRight[index];
					index++;
					arrowY = bluePointsRight[index];
				}
				//System.out.println("BLUE");
			}
			else if(black)
			{
				if(left)
				{
					arrowX = blackPointsLeft[index];
					index++;
					arrowY = blackPointsLeft[index];
				}
				else
				{
					arrowX = blackPointsRight[index];
					index++;
					arrowY = blackPointsRight[index];
				}
				//System.out.println("BLACK");
			}
			else if(white)
			{
				if(left)
				{
					arrowX = whitePointsLeft[index];
					index++;
					arrowY = whitePointsLeft[index];
				}
				else
				{
					arrowX = whitePointsRight[index];
					index++;   
					arrowY = whitePointsRight[index];
				}
				//System.out.println("WHITE");
			}
			else if(out)
			{
				//System.out.println("OUT");
			}
			onTarget = true; //the close-up target will be drawn in paintComponent()
			System.out.println("x = " + arrowX + "arrowY = " + arrowY);
			findScore();
			repaint();
		}
		public void findScore()
		{
			if(center)
				score += 100;
			else if(yellow)
				score += 90;
			else if(red)
				score += 80;
			else if(blue)
				score += 60;
			else if(black)
				score += 40;
			else if(white)
				score += 20;
			
			if(score >= 450)
				userWins = true;
		}
		public void mousePressed(MouseEvent e) { }
		public void mouseReleased(MouseEvent e) 
		{	
			if(onTarget == false && bigTarget == false) //if mouse is released after it has been dragged
			{
				if(dragged)	
				{
					arrowMove = true;
					arrowNotMoving = false;
					userX = aimX;
					userY = aimY;
					arrowTimer.start();
				}
			}
		}
		public void mouseClicked(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
		public void mouseDragged(MouseEvent e) 
		{ 
			//as long as mouse is being dragged
			aimX = e.getX();
			aimY = e.getY();
			//System.out.println("aimX = " + aimX + " aimY = " + aimY);
			dragged = true;
			repaint();
		}
		public void mouseMoved(MouseEvent e) { }
		public void keyPressed(KeyEvent e) 
		{ 
			if(onTarget)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					enter = true;
				repaint();
				//System.out.println("ENTER");
			}
		}
		public void keyReleased(KeyEvent e) { }
		public void keyTyped(KeyEvent e) { }
		public void paintComponent(Graphics g) //start of paintComponent()
		{
			super.paintComponent(g);
			if(gameOver)
			{
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "lose");
			}
			else if(userWins)
			{
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "win");
			}
			else
			{
				//change the background
				Image back = new ImageIcon("7Wonders.jpg").getImage();
				g.drawImage(back,0,0,1000,750,null);
				Image target = new ImageIcon("target.png").getImage();
				Image scoreboard = new ImageIcon("masekj-Blank-Billboard.png").getImage();
				g.drawImage(scoreboard,0,0,220,100,null);
				if(enter)
				{
					index = 0;
					aimX = 598;
					aimY = 334;
					count = -1;
					left = false;
					right = false;
					center = false;
					yellow = false;
					red = false;
					blue = false;
					black = false;
					white = false;
					onTarget = false;
					bigTarget = false;
					arrowMove = false;
					dragged = false;
					arrowNotMoving = true;
					enter = false;
				}
				if(arrowNotMoving) //the starting screen displayed
				{
					System.out.println("NOT MOVING");
					Image aim = new ImageIcon("aim.png").getImage();
					g.drawImage(target,400,275,150,150,null);
					aimPointX = aimX + 15;
					aimPointY = aimY - 15;
					//drawing the image of the aimer
					g.drawImage(aim,aimX,aimY,20,20,null);
				} 
				else if(arrowMove) //the arrow array of images being drawin
				{
					g.drawImage(target,400,275,150,150,null);
					//g.drawImage(arrow[count],475,375,150,150,null);
					g.drawImage(arrow[count],userX,userY,150,150,null);
				}
				else //the close-up arrow being drawn
				{	 
					if(bigTarget)
						g.drawImage(target,250,25,500,500,null);
					if(onTarget)
					{
						Image closeUp = new ImageIcon("close-up-arrow.png").getImage();
						g.drawImage(target,250,25,500,500,null);
						arrowPointY = arrowY - 75;
						arrowPointX = arrowX;
						g.drawImage(closeUp,arrowPointX,arrowPointY,100,100,null);
						
						Font click = new Font("Impact",Font.BOLD,20);
						g.setFont(click);
						g.setColor(Color.WHITE);
						g.drawString("Press enter to shoot again",650,600);
					}
				}
				
				Font impact = new Font("Impact",Font.BOLD,40);
				g.setColor(Color.BLACK);
				g.setFont(impact);
				g.drawString(score+"",65,70);
			}
		} //end of paintComponent()
	} //end of Arrow1 class
	public class Arrow2 extends JPanel implements MouseListener, MouseMotionListener, KeyListener //Archery Event game
	{
		int aimX, aimY;
		Image [] arrow = new Image[8];
		Timer arrowTimer;
		int count;
		boolean arrowMove;
		boolean arrowNotMoving;
		int x,y;
		boolean dragged;
		boolean bigTarget;
		boolean left, right;
		int yellowRadius;
		int userX, userY;
		int userRadius;
		int redRadius;
		int blueRadius;
		int blackRadius;
		int whiteRadius;
		boolean yellow, red, blue, black, white, out, center;
		//all the possible points the arrow can land on, on the left or right side of the target
		int [] redPointsRight = {451,320,451,230};
		int [] redPointsLeft = {520,330,530,230};
		int [] bluePointsRight = {390,320,490,390};
		int [] bluePointsLeft = {590,320,490,170};
		int [] whitePointsRight = {270,320,485,50};
		int [] whitePointsLeft = {700,320,485,490};
		int [] blackPointsRight = {485,100,340,320};
		int [] blackPointsLeft = {485,440, 650,320};
		int [] yellowPointsRight = {518,290,478,258};
		int [] yellowPointsLeft = {478,290,518,258};
		int [] centerPoints = {498,274};
		int index;
		int centerOrNot;
		int arrowX, arrowY;
		boolean onTarget;
		int aimPointY, aimPointX;
		int arrowPointX, arrowPointY;
		int score;
		boolean enter;
		boolean gameOver;
		Timer gameTimer;
		int timeCount;
		boolean userWins;
		public Arrow2()
		{
			score = 0;
			index = 0;
			aimX = 598;
			aimY = 334;
			addMouseListener(this);
			addMouseMotionListener(this);
			addKeyListener(this);
			//frames of the arrow images, to make it look like an arrow moving closer to the target
			Image a1 = new ImageIcon("arrow1.png").getImage();
			Image a2 = new ImageIcon("arrow2.png").getImage();
			Image a3 = new ImageIcon("arrow3.png").getImage();
			Image a4 = new ImageIcon("arrow4.png").getImage();
			Image a8 = new ImageIcon("arrow5.png").getImage();
			Image a5 = new ImageIcon("arrow6.png").getImage();
			Image a6 = new ImageIcon("arrow7.png").getImage();
			Image a7 = new ImageIcon("arrow8.png").getImage();
			arrow[0] = a1;
			arrow[1] = a2;
			arrow[2] = a3;
			arrow[3] = a4;
			arrow[4] = a5;
			arrow[5] = a6;
			arrow[6] = a7;
			arrow[7] = a8;
			//the mover for the arrow moving to the target
			ArrowMover amover = new ArrowMover();
			//initializing the timer
			arrowTimer = new Timer(300,amover);
			count = -1;
			bigTarget = false;
			left = right = false;
			yellow = red = blue = black = white = false;
			onTarget = false;
			arrowNotMoving = true;
			arrowX = arrowY = 0;
			center = false;
			enter = false;
			gameOver = false;
			GameMover gmover = new GameMover();
			gameTimer = new Timer(1000,gmover);
			gameTimer.start();
			timeCount = 60;
			userWins = false;
		}
		public class GameMover implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				timeCount--;
				if(timeCount == 0)
					gameOver = true;
				repaint();
			}
		}
		public class ArrowMover implements ActionListener //class responsible for making arrow lool like its moving towards the target
		{
			public void actionPerformed(ActionEvent e)
			{
				//System.out.println(count);
				count++;
				if(count == 7) //the last index of the arrow image array
				{
					arrowTimer.stop(); //stopping the timer when the image array is finished
					arrowMove = false;
					bigTarget = true; 
					if(aimX <= 475)
						deriveLocation(0); //the left side of ther target location
					else if(aimX >= 475)
						deriveLocation(1); //the right side of their target location
				} 
				repaint();
				grabFocus();
			}
		}
		public void deriveLocation(int direction) //figuring out with color the arrow landed on the target 
		{
			if(direction == 0)
				left = true;
			else
				right = true;
			if(left)
			{
				//finding the radiuses of all the sections of colors on the target
				yellowRadius = 471 - 463;
				redRadius = 471 - 435;
				blueRadius = 471 - 434;
				blackRadius = 471 - 419;
				whiteRadius = 471 - 400;
				if(userY == 350) //finding the user's radiuses if it is a point on y = 350
					userRadius = 471 - userX;
				else //finding "hypotenuse" through points
					userRadius = (int)(Math.sqrt(Math.pow((350-userY),2) + Math.pow((471 - userX),2)));
				//deciding which color the point is on
				if(userRadius <= yellowRadius)
					yellow = true;
				else if(userRadius <= redRadius && userRadius > yellowRadius)
					red = true;
				else if(userRadius <= blueRadius && userRadius > redRadius)
					blue = true;
				else if(userRadius <= blackRadius && userRadius > blueRadius)
					black = true;
				else if(userRadius <= whiteRadius && userRadius > blackRadius)
					white = true;
				else
					out = true; //if the arrow never hit the target
			}
			else if(right)
			{
				//same thing applies as above
				yellowRadius = 484 - 471;
				redRadius = 499-471;
				blueRadius = 515 - 471;
				blackRadius = 531 - 471;
				whiteRadius = 549 -471;
				if(userY == 350)
					userRadius = userX - 471;
				else
					userRadius = (int)(Math.sqrt(Math.pow(userX - 471, 2)+Math.pow(350 - userY, 2)));
						
				if(userRadius <= yellowRadius)
					yellow = true;
				else if(userRadius <= redRadius && userRadius > yellowRadius)
					red = true;
				else if(userRadius <= blueRadius && userRadius > redRadius)
					blue = true;
				else if(userRadius <= blackRadius && userRadius > blueRadius)
					black = true;
				else if(userRadius <= whiteRadius && userRadius > blackRadius)
					white = true;
				else
					out = true;
			}
			color(); // calling color to find where the arrow will be shown to land on the bigger version of the target
		}  
		public void color() //finding coordinates of where arrow will be shown on bigger target
		{
			
			index = (int)(Math.random()*2+1); //randomly chosen index of the array of points
			if(index == 1)
				index = 0;
			else if(index == 2)
				index = 2;
			
			//System.out.println("index = " + index);
			
			//using each color and using the index to find the coordinates
			if(yellow)
			{
				centerOrNot = (int)(Math.random()*2+1);
				if(centerOrNot == 1)
				{
					arrowX = centerPoints[0];
					arrowY = centerPoints[1];
					center = true;
				}
				else
				{
					if(left)
					{
						arrowX = yellowPointsLeft[index];
						index++;
						arrowY = yellowPointsLeft[index];
					}
					else
					{
						arrowX = yellowPointsRight[index];
						index++;
						arrowY = yellowPointsRight[index];
					}
				}
				//System.out.println("YELLOW");
			}
			else if(red)
			{
				if(left)
				{
					arrowX = redPointsLeft[index];
					index++;
					arrowY = redPointsLeft[index];
				}
				else
				{
					arrowX = redPointsRight[index];
					index++;
					arrowY = redPointsRight[index];
				}
				//System.out.println("RED");
			}
			else if(blue)
			{
				if(left)
				{
					arrowX = bluePointsLeft[index];
					index++;
					arrowY = bluePointsLeft[index];
				}
				else
				{
					arrowX = bluePointsRight[index];
					index++;
					arrowY = bluePointsRight[index];
				}
				//System.out.println("BLUE");
			}
			else if(black)
			{
				if(left)
				{
					arrowX = blackPointsLeft[index];
					index++;
					arrowY = blackPointsLeft[index];
				}
				else
				{
					arrowX = blackPointsRight[index];
					index++;
					arrowY = blackPointsRight[index];
				}
				//System.out.println("BLACK");
			}
			else if(white)
			{
				if(left)
				{
					arrowX = whitePointsLeft[index];
					index++;
					arrowY = whitePointsLeft[index];
				}
				else
				{
					arrowX = whitePointsRight[index];
					index++;   
					arrowY = whitePointsRight[index];
				}
				//System.out.println("WHITE");
			}
			else if(out)
			{
				//System.out.println("OUT");
			}
			onTarget = true; //the close-up target will be drawn in paintComponent()
			//System.out.println("x = " + arrowX + "arrowY = " + arrowY);
			findScore();
			repaint();
		}
		public void findScore()
		{
			if(center)
				score += 100;
			else if(yellow)
				score += 90;
			else if(red)
				score += 80;
			else if(blue)
				score += 60;
			else if(black)
				score += 40;
			else if(white)
				score += 20;
			
			if(score >= 450)
				userWins = true;
		}
		public void mousePressed(MouseEvent e) { }
		public void mouseReleased(MouseEvent e) 
		{	
			if(onTarget == false && bigTarget == false) //if mouse is released after it has been dragged
			{
				if(dragged)	
				{
					arrowMove = true;
					arrowNotMoving = false;
					userX = aimX;
					userY = aimY;
					arrowTimer.start();
				}
			}
		}
		public void mouseClicked(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
		public void mouseDragged(MouseEvent e) 
		{ 
			//as long as mouse is being dragged
			aimX = e.getX();
			aimY = e.getY();
			//System.out.println("aimX = " + aimX + " aimY = " + aimY);
			dragged = true;
			repaint();
		}
		public void mouseMoved(MouseEvent e) { }
		public void keyPressed(KeyEvent e) 
		{ 
			if(onTarget)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					enter = true;
				repaint();
				//System.out.println("ENTER");
			}
		}
		public void keyReleased(KeyEvent e) { }
		public void keyTyped(KeyEvent e) { }
		public void paintComponent(Graphics g) //start of paintComponent()
		{
			super.paintComponent(g);
			if(gameOver)
			{
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "lose");
			}
			else if(userWins)
			{
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "win");
			}
			else
			{
				//change the background
				Image back = new ImageIcon("7Wonders.jpg").getImage();
				g.drawImage(back,0,0,1000,750,null);
				Image target = new ImageIcon("target.png").getImage();
				Image scoreboard = new ImageIcon("masekj-Blank-Billboard.png").getImage();
				g.drawImage(scoreboard,0,0,220,150,null);
				g.drawImage(scoreboard,780,0,220,150,null);
				if(enter)
				{
					index = 0;
					aimX = 598;
					aimY = 334;
					count = -1;
					left = false;
					right = false;
					center = false;
					yellow = false;
					red = false;
					blue = false;
					black = false;
					white = false;
					onTarget = false;
					bigTarget = false;
					arrowMove = false;
					dragged = false;
					arrowNotMoving = true;
					enter = false;
				}
				if(arrowNotMoving) //the starting screen displayed
				{
					//System.out.println("NOT MOVING");
					Image aim = new ImageIcon("aim.png").getImage();
					g.drawImage(target,400,275,150,150,null);
					aimPointX = aimX + 10;
					aimPointY = aimY - 10;
					//drawing the image of the aimer
					g.drawImage(aim,aimX,aimY,20,20,null);
				} 
				else if(arrowMove) //the arrow array of images being drawin
				{
					g.drawImage(target,400,275,150,150,null);
					//g.drawImage(arrow[count],475,375,150,150,null);
					g.drawImage(arrow[count],userX,userY,150,150,null);
				}
				else //the close-up arrow being drawn
				{	 
					if(bigTarget)
						g.drawImage(target,250,25,500,500,null);
					if(onTarget)
					{
						Image closeUp = new ImageIcon("close-up-arrow.png").getImage();
						g.drawImage(target,250,25,500,500,null);
						arrowPointY = arrowY - 75;
						arrowPointX = arrowX;
						g.drawImage(closeUp,arrowPointX,arrowPointY,100,100,null);
						
						Font click = new Font("Impact",Font.BOLD,20);
						g.setFont(click);
						g.setColor(Color.WHITE);
						g.drawString("Press enter to shoot again",650,600);
					}
				}
				
				Font impact = new Font("Impact",Font.BOLD,40);
				g.setColor(Color.BLACK);
				g.setFont(impact);
				g.drawString(score+"",65,70);
				g.drawString(timeCount+"",920,70);
			}
		} //end of paintComponent()
	}//end of Arrow2 class
	public class Arrow3 extends JPanel implements MouseListener, MouseMotionListener, KeyListener
	{
		int aimX, aimY;
		Image [] arrow = new Image[8];
		Timer arrowTimer;
		int count;
		boolean arrowMove;
		boolean arrowNotMoving;
		int x,y;
		boolean dragged;
		boolean bigTarget;
		boolean left, right;
		int yellowRadius;
		int userX, userY;
		int userRadius;
		int redRadius;
		int blueRadius;
		int blackRadius;
		int whiteRadius;
		boolean yellow, red, blue, black, white, out, center;
		//all the possible points the arrow can land on, on the left or right side of the target
		int [] redPointsRight = {451,320,451,230};
		int [] redPointsLeft = {520,330,530,230};
		int [] bluePointsRight = {390,320,490,390};
		int [] bluePointsLeft = {590,320,490,170};
		int [] whitePointsRight = {270,320,485,50};
		int [] whitePointsLeft = {700,320,485,490};
		int [] blackPointsRight = {485,100,340,320};
		int [] blackPointsLeft = {485,440, 650,320};
		int [] yellowPointsRight = {518,290,478,258};
		int [] yellowPointsLeft = {478,290,518,258};
		int [] centerPoints = {498,274};
		int index;
		int centerOrNot;
		int arrowX, arrowY;
		boolean onTarget;
		int aimPointY, aimPointX;
		int arrowPointX, arrowPointY;
		int score;
		boolean enter;
		boolean gameOver;
		Timer gameTimer;
		int timeCount;
		int arrowCount;
		boolean userWins;
		
		public Arrow3()
		{
			score = 0;
			index = 0;
			aimX = 598;
			aimY = 334;
			addMouseListener(this);
			addMouseMotionListener(this);
			addKeyListener(this);
			//frames of the arrow images, to make it look like an arrow moving closer to the target
			Image a1 = new ImageIcon("arrow1.png").getImage();
			Image a2 = new ImageIcon("arrow2.png").getImage();
			Image a3 = new ImageIcon("arrow3.png").getImage();
			Image a4 = new ImageIcon("arrow4.png").getImage();
			Image a8 = new ImageIcon("arrow5.png").getImage();
			Image a5 = new ImageIcon("arrow6.png").getImage();
			Image a6 = new ImageIcon("arrow7.png").getImage();
			Image a7 = new ImageIcon("arrow8.png").getImage();
			arrow[0] = a1;
			arrow[1] = a2;
			arrow[2] = a3;
			arrow[3] = a4;
			arrow[4] = a5;
			arrow[5] = a6;
			arrow[6] = a7;
			arrow[7] = a8;
			//the mover for the arrow moving to the target
			ArrowMover amover = new ArrowMover();
			//initializing the timer
			arrowTimer = new Timer(300,amover);
			count = 0;
			bigTarget = false;
			left = right = false;
			yellow = red = blue = black = white = false;
			onTarget = false;
			arrowNotMoving = true;
			arrowX = arrowY = 0;
			center = false;
			enter = false;
			gameOver = false;
			GameMover gmover = new GameMover();
			gameTimer = new Timer(1000,gmover);
			gameTimer.start();
			timeCount = 60;
			arrowCount = 7;
			userWins = false;
		}
		public class GameMover implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				timeCount--;
				if(timeCount == 0)
					gameOver = true;
				repaint();
			}
		}
		public class ArrowMover implements ActionListener //class responsible for making arrow lool like its moving towards the target
		{
			public void actionPerformed(ActionEvent e)
			{
				//System.out.println(count);
				if(count == 7) //the last index of the arrow image array
				{
					arrowTimer.stop(); //stopping the timer when the image array is finished
					arrowMove = false;
					bigTarget = true; 
					if(aimX <= 475)
						deriveLocation(0); //the left side of ther target location
					else if(aimX >= 475)
						deriveLocation(1); //the right side of their target location
				} 
				repaint();
				grabFocus();
			}
		}
		public void deriveLocation(int direction) //figuring out with color the arrow landed on the target 
		{
			if(direction == 0)
				left = true;
			else
				right = true;
			if(left)
			{
				//finding the radiuses of all the sections of colors on the target
				yellowRadius = 471 - 463;
				redRadius = 471 - 435;
				blueRadius = 471 - 434;
				blackRadius = 471 - 419;
				whiteRadius = 471 - 400;
				if(userY == 350) //finding the user's radiuses if it is a point on y = 350
					userRadius = 471 - userX;
				else //finding "hypotenuse" through points
					userRadius = (int)(Math.sqrt(Math.pow((350-userY),2) + Math.pow((471 - userX),2)));
				//deciding which color the point is on
				if(userRadius <= yellowRadius)
					yellow = true;
				else if(userRadius <= redRadius && userRadius > yellowRadius)
					red = true;
				else if(userRadius <= blueRadius && userRadius > redRadius)
					blue = true;
				else if(userRadius <= blackRadius && userRadius > blueRadius)
					black = true;
				else if(userRadius <= whiteRadius && userRadius > blackRadius)
					white = true;
				else
					out = true; //if the arrow never hit the target
			}
			else if(right)
			{
				//same thing applies as above
				yellowRadius = 484 - 471;
				redRadius = 499-471;
				blueRadius = 515 - 471;
				blackRadius = 531 - 471;
				whiteRadius = 549 -471;
				if(userY == 350)
					userRadius = userX - 471;
				else
					userRadius = (int)(Math.sqrt(Math.pow(userX - 471, 2)+Math.pow(350 - userY, 2)));
						
				if(userRadius <= yellowRadius)
					yellow = true;
				else if(userRadius <= redRadius && userRadius > yellowRadius)
					red = true;
				else if(userRadius <= blueRadius && userRadius > redRadius)
					blue = true;
				else if(userRadius <= blackRadius && userRadius > blueRadius)
					black = true;
				else if(userRadius <= whiteRadius && userRadius > blackRadius)
					white = true;
				else
					out = true;
			}
			color(); // calling color to find where the arrow will be shown to land on the bigger version of the target
		}  
		public void color() //finding coordinates of where arrow will be shown on bigger target
		{
			
			index = (int)(Math.random()*2+1); //randomly chosen index of the array of points
			if(index == 1)
				index = 0;
			else if(index == 2)
				index = 2;
			
			//System.out.println("index = " + index);
			
			//using each color and using the index to find the coordinates
			if(yellow)
			{
				centerOrNot = (int)(Math.random()*2+1);
				if(centerOrNot == 1)
				{
					arrowX = centerPoints[0];
					arrowY = centerPoints[1];
					center = true;
				}
				else
				{
					if(left)
					{
						arrowX = yellowPointsLeft[index];
						index++;
						arrowY = yellowPointsLeft[index];
					}
					else
					{
						arrowX = yellowPointsRight[index];
						index++;
						arrowY = yellowPointsRight[index];
					}
				}
				//System.out.println("YELLOW");
			}
			else if(red)
			{
				if(left)
				{
					arrowX = redPointsLeft[index];
					index++;
					arrowY = redPointsLeft[index];
				}
				else
				{
					arrowX = redPointsRight[index];
					index++;
					arrowY = redPointsRight[index];
				}
				System.out.println("RED");
			}
			else if(blue)
			{
				if(left)
				{
					arrowX = bluePointsLeft[index];
					index++;
					arrowY = bluePointsLeft[index];
				}
				else
				{
					arrowX = bluePointsRight[index];
					index++;
					arrowY = bluePointsRight[index];
				}
				//System.out.println("BLUE");
			}
			else if(black)
			{
				if(left)
				{
					arrowX = blackPointsLeft[index];
					index++;
					arrowY = blackPointsLeft[index];
				}
				else
				{
					arrowX = blackPointsRight[index];
					index++;
					arrowY = blackPointsRight[index];
				}
				//System.out.println("BLACK");
			}
			else if(white)
			{
				if(left)
				{
					arrowX = whitePointsLeft[index];
					index++;
					arrowY = whitePointsLeft[index];
				}
				else
				{
					arrowX = whitePointsRight[index];
					index++;   
					arrowY = whitePointsRight[index];
				}
				//System.out.println("WHITE");
			}
			else if(out)
			{
				//System.out.println("OUT");
			}
			onTarget = true; //the close-up target will be drawn in paintComponent()
			//System.out.println("x = " + arrowX + "arrowY = " + arrowY);
			findScore();
			repaint();
		}
		public void findScore()
		{
			if(center)
				score += 100;
			else if(yellow)
				score += 90;
			else if(red)
				score += 80;
			else if(blue)
				score += 60;
			else if(black)
				score += 40;
			else if(white)
				score += 20;
			
			if(score >= 450)
				userWins = true;
			
			arrowCount--;
		}
		public void mousePressed(MouseEvent e) { }
		public void mouseReleased(MouseEvent e) 
		{	
			if(onTarget == false && bigTarget == false) //if mouse is released after it has been dragged
			{
				if(dragged)	
				{
					arrowMove = true;
					arrowNotMoving = false;
					userX = aimX;
					userY = aimY;
					arrowTimer.start();
				}
			}
		}
		public void mouseClicked(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }
		public void mouseDragged(MouseEvent e) 
		{ 
			//as long as mouse is being dragged
			aimX = e.getX();
			aimY = e.getY();
			//System.out.println("aimX = " + aimX + " aimY = " + aimY);
			dragged = true;
			repaint();
		}
		public void mouseMoved(MouseEvent e) { }
		public void keyPressed(KeyEvent e) 
		{ 
			if(onTarget)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					enter = true;
				repaint();
				//System.out.println("ENTER");
			}
		}
		public void keyReleased(KeyEvent e) { }
		public void keyTyped(KeyEvent e) { }
		public void paintComponent(Graphics g) //start of paintComponent()
		{
			super.paintComponent(g);
			if(gameOver)
			{
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "lose");
			}
			else if(userWins)
			{
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "win");
			}
			else
			{
				//change the background
				Image back = new ImageIcon("7Wonders.jpg").getImage();
				g.drawImage(back,0,0,1000,750,null);
				Image target = new ImageIcon("target.png").getImage();
				Image scoreboard = new ImageIcon("masekj-Blank-Billboard.png").getImage();
				g.drawImage(scoreboard,0,0,220,100,null);
				g.drawImage(scoreboard,880,0,120,100,null);
				if(enter)
				{
					index = 0;
					aimX = 598;
					aimY = 334;
					count = 0;
					left = false;
					right = false;
					center = false;
					yellow = false;
					red = false;
					blue = false;
					black = false;
					white = false;
					onTarget = false;
					bigTarget = false;
					arrowMove = false;
					dragged = false;
					arrowNotMoving = true;
					enter = false;
				}
				if(arrowNotMoving) //the starting screen displayed
				{
					Image aim = new ImageIcon("aim.png").getImage();
					g.drawImage(target,400,275,150,150,null);
					aimPointX = aimX + 10;
					aimPointY = aimY - 10;
					//drawing the image of the aimer
					g.drawImage(aim,aimX,aimY,20,20,null);
				} 
				else if(arrowMove) //the arrow array of images being drawin
				{
					g.drawImage(target,400,275,150,150,null);
					g.drawImage(arrow[count],userX,userY,150,150,null);
					//System.out.println("count = " + count);
					count++;
				}
				else //the close-up arrow being drawn
				{	 
					if(bigTarget)
						g.drawImage(target,250,25,500,500,null);
					if(onTarget)
					{
						Image closeUp = new ImageIcon("close-up-arrow.png").getImage();
						g.drawImage(target,250,25,500,500,null);
						arrowPointY = arrowY - 75;
						arrowPointX = arrowX;
						g.drawImage(closeUp,arrowPointX,arrowPointY,100,100,null);
						
						Font click = new Font("Impact",Font.BOLD,20);
						g.setFont(click);
						g.setColor(Color.WHITE);
						g.drawString("Press enter to shoot again",650,600);
					}
				}
				if(arrowCount == 0)
					gameOver = true;
				Font impact = new Font("Impact",Font.BOLD,40);
				g.setColor(Color.BLACK);
				g.setFont(impact);
				g.drawString(score+"",65,70);
				g.drawString(timeCount+"",920,70);
				g.setColor(Color.WHITE);
				g.drawString("Arrows Left " + arrowCount + "/10",350,700);
			}
		} //end of paintComponent()
	}
}//end of GameManager class
