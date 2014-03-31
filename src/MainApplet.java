//BoxHead Online game
//By Sameid Usmani, Isaiah Tan, Shahzaib Bhatti
//This is the boxhead online game that takes use of a server for online play

/* Version 2 - Final Game Project (Version 1.0 Release) - no bugs detected
 * 
 * Overview
 * This game is added onto the database project, which we left sections specifically for multiplayer game implementation
 * From Main menu, Start Solo can be accessed, which lets a single player boxhead game be played. 
 * Just like the original, there are unlimited waves but the speed and number of zombies increase.
 * There are 3 weapons usable, shotgun, smg, and pistol. The character rols are modified though.
 * Weapons and shooting are made like the game age of zombies for the Ipod/Iphone, which lets the user shoot in 360 direction.
 * The game can be played using an Xbox controller or using keyboard and mouse. If a controller is connected, 
 * the keyboard and mouse gameplay is not allowed.
 * 
 * Game Play
 * Enemies spawn every level, increasing in speed and numbers every time.
 * Weapons are picked up as item drops, which killed enemies drop.
 * Health can also be picked up.
 * Weapons, as mentioned, are pistol (default), smg (pickup) and shotgun (pickup).
 * smg shoots with no delay, shotgun shoot multiple bullets at once, pistol is the average of both, but weaker.
 * There are obstacles to obstruct the player, enemies, and bullets.
 * !!Super zombies!!
 * 
 * Multiplayer
 * Multiplayer is the main functionality of the game.
 * Firstly, using the database program, one must either login or create a game account.
 * With the account, a game can be played with a partner on a different machine. 
 * Multiplayer is played using LAN, and not online using ftp as originally designed, due to speed.
 * After login, the host must open a server first, the the host ip must be entered on the client's computer.
 * In doing so, there will be 2 characters instead of 1, increasing chances of survival in the game. 
 * There is no revival system, and the health is shared between partners to increase difficulty.
 * There may be lag due to network connected, but no code problems
 * 
 * 
 * Other Notes
 * -Loading Weapon pngs for the first time will have a slight lag, then after it's in the ram, it'll not lag
 * -Animated Gifs may have white squares, due to the way java draws a gif with transparent spaces.
 * -Merge sort was taken from the blue pelican textbook, but was modified to fit our uses
 * -Sorting done to make sure overlap of images makes sense (sorting by y values of objects)
 * -The whole database and game is made in only 1 while loop, but multiple embedded if statements
 * -The single player and multiplayer are combined, only certain sections differ, making the game code short.
 * -Media library and some code taken from playlist project to play mp3 files, instead of playing some massive wav/au files.
 * -Linked list project classes was not taken, as java provides ArrayList.
 * -Real time shooting, cause it's cooler. And also so lag will not affect shooting, and instead gives advantage to users when lag exists.
 * -Real time spawning, cause it's cooler. And adds difficulty due to ease from real time shooting.
 * 
 *                                       
                                    .......                                     
                             ...+ZNMMMMMMMMMMO7...                              
                         ...$MMMMMMMMMMMMMMMMMMMMMO...                          
                       .~MMMMMMMM8++++++++++7MMMMMMMMMI.                        
                    ..DMMMMM$+++++++++++++++++++IIMMMMM,.,.                     
                  ..MMMMM++++++++++++++++++++++++II??MMM,..:.                   
                ..MMMMM++++++++++++++++++++++++++?II???IO....,..                
               .IMMMM++++++++++++++++++++++++++++++II????:.,..+..               
             ..ZMMM+++++++++=====+++++++++++++++++++I?????..,.. ..              
            ..MMMM?++?MMMMMMMMMM=~===+++++++?+MMMMMMMMMMD+?, ,...,              
           ..MMMD++MMM. ..  .. :MMM~~==++++DMM..  ......7MM?:.,,..,             
           .MMMZ+MM:..          .:=MM~==+?MM...         .::MM+:.,..,            
          .ZMMN+MM.      ...     .:,MM~=NM                ,:IM??=:...           
          =MMM+MM..   .MMMMMMM~.   ::MMDM.                 :::M=7M:.I.          
         .MMM+NM.   .DMZZZZZZZDM...~::MM,                  .:,MM+MMM,:          
        .?MMN+MD   .:MZZZZZZZZZZM..:::DM.                   :,,M++MMM=.         
        .MMM++M.   .MOZZZZM8ZZZZMZ.:::~M           $N      .:,,MN+MMMI:.        
        .MMM++M     MZZZZDMMZZZZMM ~:::M         ..MM.      :,,MM+$MMM?         
       .+MMD++M:   .MNZZZZZZZZZZM..:::=M           ..      :,,.M$++MMM?.        
       .7MM+++MM.  ..MDZZZZZZZZMM.::,,MM.                .,:,.=M+++MMM7.        
       .$MM++++M?..   NMNZZZZMM. :,,,IMMM .             .::,,.MD?++MMMM,        
       .$MM++++$M~.   ...MMM$..::,,..M7+MM.             ::,.,MM++++MMMM,        
       .7MM?++++IMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM+?+++MMMD,.       
       .+MMM++++M=.    MM        ~M......  .MM       .M:,....M+++++MMM7.        
        .MMM++++8M     MM        ~M.        MM      . M,,....M++++DMMMI         
        .MMM+++++M.    MM        ~M.        MM       :M,....MM++++MMMM~         
        .?MMM++++MM    MM        ~M.        MM      ::M.....M++++IMMM$,.        
         .MMM++++?M.   MM        ~M.        MM     .:,M....MN++++MMMM=          
         .=MMM+++++M.. MM        ~M.        MM   ..:,,M...DM++++MMMM7,          
          .ZMMM?+++7M. MM        ~M.        MM   ::,,.M..NM?+++7MMMM~           
           .MMMM+++++M.MM        ~M.        MM ,:,,...M.MM++++IMMMM=.           
           ..MMMM??+++MMM..      ~M.       .MM:,,,....MMO++++OMMMM+.            
             .MMMM++++?IMZ~. ... ~M.   .  ::MM,,.....MM?+++?MMMMM=.             
              .ZMMMMII+++IMM:::::+M:::::::,,MM....,MM+++++?MMMMM~.              
               .7MMMMIIIIIIIMMI,,+M,,,,,,,..MM..MMM++++++MMMMM$~.               
                 ,MMMMMI???????MMMMM=....,$MMMM7++++++?MMMMMM+.                 
                  .:MMMMMM?+?+????++++++++++++++++++8MMMMMM?,                   
                    .:DMMMMMM7?++++++++++++++++++MMMMMMMM+,                     
                      .,+MMMMMMMMMMDI++++?8MMMMMMMMMMM7=.                       
                         .,~$MMMMMMMMMMMMMMMMMMMMMO+~..                         
                             .,~I$NMMMMMMMMMMO$+~,.                             
                                   .........                                    

 * 
 * 
 * 
 * Version 1 - Database Project
 * The database of the game has been set up to allow users to sign in with information such as a name,
 * password, email, gamer tag, and much more. These users can have friends who they may view to be
 * online to play when the game is developed. These user can also be part of a clan. This clan
 * will have leaders and administrators running the higher level options. Some of the option in
 * the clans are to deal with the members, the clan allies, and a clan black list. Finally these
 * clans can be divided even further into leagues, these leagues will also hold clans which a clan
 * can freely join and remove.
 *
 * NOTE:
 * You will notice a certain lag between different UI. At first we decided that whenever we wanted to
 * connect to save any changes we would connect to our server, save the changes, then disconnect. This
 * was implemented to save bandwidth, this is self created a problem that made the lag between the UI.
 * So for now we have left, but for the final product we are going to connect to the server at init,
 * and then leave, it may kill the bandwidth, but the School connection should survive. And the UI will
 * not lad in the future.
 *
 * Who did what:
 * Sameid:               UI Design
 *                       Class structure and design
 *                       Logic assistance
 *                       Vocal entertainment (singing)
 *                       Debugging
 *                       Server setup and maintenance
 * Isaiah:               Logic structure and design
 *                       Class implementation
 *                       UI Assistance
 *                       Food
 *                       Debugging
 * Shahzaib:             Class assistance
 *                       Documentation
 *                       Method assistance
 *                       Odd jobs
 *                       Comic Relief
 *                       Debugging
 *
 *
 */
//imported classes


//Imported packages
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ConcurrentModificationException;
import java.util.Random;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.JFileChooser;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.jlap;



import ch.aplu.xboxcontroller.XboxController;
import ch.aplu.xboxcontroller.XboxControllerAdapter;


public class MainApplet extends Applet implements Runnable, MouseListener, MouseMotionListener, KeyListener, Serializable,  MouseWheelListener {


	private static final long serialVersionUID = 4059527978860458433L;

	final static double LEFT_JOYSTICK_MINIMUM_MOVMENT_MAGNITUDE = 0.005;
	final static double RIGHT_JOYSTICK_MINIMUM_SHOOTING_MAGNITUDE = 0.5;
	final static double ENEMY_DAMAGE = 5;

	MessageReceive nt = new MessageReceive ();
	BroadcastThread bt = new BroadcastThread();

	final static String NEW_LINE = "\n"; 


	public final static String REQUEST_TOKEN 
	= "https://www.facebook.com/dialog/oauth?client_id=183742228324698&redirect_uri=http://roadhousestudios.ca/&scope=user_about_me,publish_stream&response_type=token";

	static Client main = new Client ("99.229.155.96", 10001);

	//private Server server;//Server to create a host for the session
	//private Client client;//Client object to establish a connection the server



	final static String DISCONNECTED = "d";
	final static String MESSAGE = "m";
	final static String GET_INFO = "gi";
	final static String SAVE_INFO = "s";
	final static String VERIFY = "v";
	final static String VERIFIED = "vd";
	final static String INCORRECT_PASS = "ic";
	final static String INVALID = "iv";
	final static String LOGIN = "l";
	final static String CREATE = "c";


	NetworkThread network = new NetworkThread ();


	public ArrayList <Bullet> concurrentBulletFix = new ArrayList <Bullet> ();

	public ArrayList<Turret> concurrentTurretFix = new ArrayList <Turret> ();
	/* this was used to replace array of bullets for a client in multiplayer.
	 * 
	 * this was needed because when in update and paint methods, 
	 * 		arraylist of bullet objects in the weapon object of the character object
	 * 		was disappearing, allowing no bullets to appear on client screen
	 * This bullet arraylist (concurrentBulletFix) is used in exactly the same locations 
	 *  	and the same way as the original bullet list when the glitch occurred, 
	 *  	and the glitch stopped.
	 */

	Character player = new Character(); // player for user
	Character networkPlayer = null; // if a host, stores second player
	//XboxControl controller = new XboxControl (); // xbox controller class

	final static int BUTTON_A = 0;
	final static int BUTTON_B = 1;
	final static int BUTTON_X = 2;
	final static int BUTTON_Y = 3;
	final static int START = 4;
	final static int LEFT_SHOULDER = 5;
	final static int RIGHT_SHOULDER = 6;
	final static int NULL = -1;




	FacebookSimple fb;
	// mp3 file player class
	AdvancedPlayer mp3Player;

	// to calculate real time
	int stopTime = 0;
	int startTime = 0;
	long currentTime = 0;

	// direction booleans for movement
	boolean up = false, down = false, left = false, right = false;
	int prevMouseMoveX = 0, prevMouseMoveY = 0; // for shooting

	// health powerup healing amount
	static final int HEALTH_POWERUP = 50;

	boolean hosting = false; // to differentiate if client or server

	// for synchronisation of server and client
	int iterationCount = 0;
	// spawning fast/explosive zombies


	int spawningEnemies2 = 0;
	// spawning large zombies
	int spawningEnemies3 = 0;
	// spawning bosses
	int spawningBoss = 0;


	final static int NUM_ITEM_TYPES = 8; // total number of different power ups/*****/
	// or pickups types
	final static int NUM_WEAPON_TYPES = 8;/*****/

	// Game images
	Image crosshairOuter[] = new Image[9];
	Image crosshairInner[] = new Image[18];
	Image enemy[] = new Image[32];
	Image enemy2[] = new Image [32]; // faster zombies
	Image enemy3[] = new Image [32]; // large zombies /*****/
	Image enemy4[] = new Image [32]; // explosive zombies /*****/
	Image boss[] = new Image [32]; // shooter zombies /*****/
	Image boss2[] = new Image [32]; // zombie spawner /*****/
	Image boss3[] = new Image [32]; // invincible zombies /*****/
	Image character[] = new Image [32]; // first player
	Image character2[] = new Image [32]; // second player
	Image character3[] = new Image [32]; // third player
	Image character4[] = new Image [32]; // forth player
	Image turret[] = new Image[6]; // turret images /*****/
	Image turret2[] = new Image[6]; // turret images /*****/
	Image gameHud;
	Image weapons[] = new Image [NUM_WEAPON_TYPES];/*****/
	Image obstacle;
	Image items[] = new Image [NUM_ITEM_TYPES];/*****/
	Image explosion[] = new Image [25];
	Image fragOut[] = new Image [34];
	Image enemyExplosion[] = new Image [15];
	Image background;
	Image bullet;
	Image stickyBullet;
	Image rocket;
	Image grenade;
	static AudioClip soundEffects [] = new AudioClip [16]; // sounds

	ArrayList <Explosion> explosions;
	// Screen resolution
	static int SCREEN_WIDTH = 1016;
	static int SCREEN_HEIGHT = 662;


	// game variables
	int level = 0; // starting level
	double enemyMultiplier = 1.5; // enemy multiplier per level
	int LEVEL_1_NUM_ENEMIES = 20; // number of enemies in the level. enemies =
	// numEnemes * enemyMultiplier^level
	int spawningEnemies = LEVEL_1_NUM_ENEMIES; // number of enemies left to
	// spawn
	ArrayList<Enemy> enemies;
	ArrayList<Obstacle> obstacles;
	ArrayList<Item> itemDrops;

	Crosshair crosshair = new Crosshair(currentTime);
	// other static finals
	final int HEALTH_PICKUP = 0;
	final int UZI_PICKUP = 1;
	final int SHOTGUN_PICKUP = 2;
	final int SNIPER_PICKUP = 5;/*****/
	final int TURRET_PICKUP = 4;/*****/
	final int GRENADE_PICKUP = 3;/*****/
	final int RPG_PICKUP = 6;/*****/
	final int RPG_TURRET_PICKUP = 7;/*****/
	final static int PISTOL = 0;
	final static int MACHINE = 1;
	final static int SHOTGUN = 2;
	final static int SNIPER = 5;/*****/
	final static int TURRET = 4;/*****/
	final static int GRENADE = 3;/*****/
	final static int RPG = 6;/*****/
	final static int RPG_TURRET = 7;/*****/
	final static int ENEMY_SHOT = 8;/*****/
	final static int CHAR_SIZE = 30;
	final static int NETWORK_PORT = 3030;
	final static boolean MUSIC = false;

	boolean newLevel = true;

	SimpleDateFormat sdf2 = new SimpleDateFormat("SSS"); // gets the seconds,
	// millisecs

	ServerPacket sPack = new ServerPacket(); 
	ClientPacket cPack = new ClientPacket();


	long timeLastSpawn = 0;
	double LEVEL_1_SPAWN_DELAY = 1;

	// Images used in the program
	Image mainMenuImage;
	Image mainMenuOnlineImage;
	Image signInMenuImage;
	Image createNewProfileImage;

	Image popUpMessageImage;
	Image invitationDialogImage;
	Image editProfileImage;

	Image friendsScreenImage;
	Image friendsScreenImage2;
	Image searchFriendsImage;

	Image gameOverScreenImage;

	Image joinGameImage;
	Image hostGameImage;
	Image networkImage;

	Image connected;

	Image textHover;
	Image selected;

	Image intructions;
	Image intructions2;

	Image[] cursorEffect;
	Image buttonEffect;

	Image film;

	Image chatBox;

	URL base;
	URL jarBase;

	// DIfferent fonts throughout the program
	Font defaultFont;
	Font onlineMenuFont;
	Font onlineMenuFontSpec;
	Font smallFont;
	Font smallerFont;
	Font clanFont;

	// Other variables
	HighlightText searchResults;
	String[] searchResultsReturn;

	// options checkers in the program
	int checker = -1;
	int checker2 = -1;
	int currentlyClicked = -1;



	// Friendlist variables
	HighlightText friendList;
	String[] friendListReturn;
	ScrollBar friendScroll;


	HighlightText gameList;
	String[] gameListReturn;
	ScrollBar gameScroll;
	ArrayList<String> games;


	// Ftp declaration

	int ftpConnectTime;
	SimpleDateFormat dateFormat;

	private Image dbImage;
	private Graphics dbg;

	// Button arrays
	CustomButton[] buttons = new CustomButton[24];
	CustomButton profilePic;
	ScrollButton[] scrollButtons = new ScrollButton[2];

	// Constants

	// Various max and min input lengths
	final static int MIN_USERNAME_LENGTH = 6;
	final static int MAX_USERNAME_LENGTH = 20;
	final static int MIN_PASSWORD_LENGTH = 6;
	final static int MAX_TAG_LENGTH = 8;
	final static int MAX_CLAN_NAME_LENGTH = 10;

	// Scroll button constants
	final static int SEARCH_UP = 0;
	final static int SEARCH_DOWN = 1;

	// Other various constants for buttons, refer to constant name for purpose
	private static final int START_SOLO = 0;
	private static final int ONLINE = 1;
	private static final int OPTIONS = 2;
	private static final int RETURN_TO_MENU = 3;
	private static final int FRIENDS = 4;
	private static final int EDIT_PROFILE = 5;
	private static final int RETURN_TO_GAME = 6;
	private static final int SAVE = 7;
	private static final int OK = 8;
	private static final int ACCEPT = 9;
	private static final int DECLINE = 10;
	private static final int YES = 11;
	private static final int NO = 12;
	private static final int ADD = 13;
	private static final int RETURN_TO_MENU2 = 14;
	private static final int ADD_FRIEND = 15;
	private static final int REMOVE_FRIEND = 16;
	private static final int JOIN = 17;
	private static final int HOST = 18;
	private static final int INBOX = 19;
	private static final int SEND = 20;
	private static final int SIGN_UP = 21;
	private static final int REFRESH = 22;
	private static final int POSTFB = 23;


	boolean exit = false; // exiting game status
	boolean mainMenu = true; // in mainMenu
	boolean game = false; // playing game
	boolean pause = false; // game paused
	boolean multiplayer = false; // playing multiplayer
	boolean signIn = false;

	// Display screen booleans
	boolean optionScreen = false;
	boolean editProfileScreen = false;
	boolean friendsScreen = false;
	boolean popUpMessageScreen = false;
	boolean searchProfileScreen = false;
	boolean joinGameScreen = false;
	boolean hostGameScreen = false;
	boolean networkScreen = false;
	boolean networkConnectedScreen = false;
	boolean tempNickScreen = false;
	boolean gameOverScreen = false;

	boolean profileInvitationScreen = false;

	boolean chat = false;

	boolean setScreen = false;
	boolean creating = false; // if creating new profile or not
	boolean addAlly = false; // if adding ally or adding enemy
	boolean addFriend = false; // adding a friend or adding a clan member

	boolean signedIn = false;

	boolean selfClicked = false;

	boolean searchingForConnectionScreen = false;

	PopUpMessage popUpMessage = null;

	Profile userProfile;
	ArrayList <String> invites;
	String[] searchableProfiles;
	ArrayList <String> friends;
	Profile networkProfile;

	String userLeague = "";

	Profile tempProfile;

	static boolean mousePressed = false;
	static int mouseMoveX = 0;
	static int mouseMoveY = 0;

	static boolean allowScroll = false;
	static boolean enter = false;
	static boolean allowEnter = false;
	static boolean esc = false;
	static boolean allowEsc = false;
	// Weapon userWeapon = new Weapon (NUM_WEAPON_TYPES);

	// Text field variables
	TextField nameTextField;
	TextField sendMessageField;
	boolean sendMessage;

	Image pp;

	final static String[] sideNote = {
		MIN_USERNAME_LENGTH + " characters min.",
		MAX_USERNAME_LENGTH + " characters max.",
		MIN_PASSWORD_LENGTH + " characters min.",
		MAX_TAG_LENGTH + " characters max",
		MAX_CLAN_NAME_LENGTH + " characters max", }; // side notes for
	// textbox entering
	boolean[] sideNoteType = new boolean[sideNote.length];

	Image bigLoad;
	Image fbLoad;
	JFileChooser fc;

	boolean install = false;
	boolean activeBool = false;

	Image loader;
	Image liveInviteImg;
	Image liveFriendImg;
	Image liveOfflineImg;

	Image liveAcceptImg;
	Image liveDeclineImg;
	Image liveRemoveImg;


	Image liveInviteSentImg;
	Image liveMessageSentImg;
	Image liveMessage;

	Image nickname;
	Image nofb;
	Image nonn;
	Image progress;
	Image tg;

	Image buttonAnimate;
	String accessToken;





	// Initialization of previous declared variables
	public void init() {




		System.out.println ("Boxhead Online 2.0.5 Started Successfully!  Loading...");

		initialization();
		th.start();
		nt.start();
		nt.setRunning(false);

		//ystem.out.println(getParameter("token") + "    new build");

		accessToken = getParameter("token");
		//accessToken = "access_token=AAACnHNIZC4VoBACCzCp71Bg59SyO3zpFVFfy3ZBZCFYBWJ5pAiU5lAH9pLW2OjsfthkgkSX2YmWm422ass0tzPnICQ4IAPjBoZBs955yQk1N1wjMYcIM&expires_in=5602";

		if (accessToken != null){
			if ( !accessToken.equals("")){

				accessToken = accessToken.substring(13, accessToken.length()-16);

				fbLimbo = true;
				repaint();
				//perform queries
				try{
					fb = new FacebookSimple (accessToken);

					main.connect();

					delay(10);
					main.sendObject("fromfb");
					delay(10);
					main.sendObject(fb.getFacebookUser().getName());

					System.out.println(fb.getFacebookUser().getFirstName() +" is connected to Project Freeway and Facebook.");

					String command = (String) main.receiveObject();

					if (command.equals("new")){

						sendFbProfilePic();

						nickNameScreen = true;
						nameTextField.setBounds(210+280,325+130,200,25);
						add(nameTextField);
					}
					else if (command.equals("reg")){

						sendFbProfilePic();

						userProfile = (Profile) main.receiveObject();
						System.out.println ("Recevied profile object.");
						signedIn = true;

						buttons[START_SOLO].setY(345);
						buttons[ONLINE].setY(345);
						buttons[OPTIONS].setY(345);

						nt.setRunning(true);
						nt.setReceive(main.getInputStream());



						main.sendObject("nfon");
						delay(10);

					}else if (command.equals("arlo")){
						popUpMessageScreen = true;
						popUpMessage.setMessage(20);
					}

					keepCheckingForToken = false;
				}
				catch (Exception e){

					e.printStackTrace();

					System.out.println ("Could not contact server.");
					popUpMessageScreen = true;
					popUpMessage.setMessage(16);

				}
			}
		}

	} // init method

	public  void sendFbProfilePic (){

		try{
			URL u= new URL("https://graph.facebook.com/me/picture?type=square&access_token="+ accessToken);
			URLConnection c = u.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
			String test = c.getURL().toString();

			String url = test.substring(0, test.lastIndexOf("/")+1);
			String fileName = test.substring(test.lastIndexOf("/")+1, test.length());

			pp = getImage (new URL (url),fileName );

			main.sendObject(url);
			delay(10);
			main.sendObject(fileName);
			delay(10);

		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	public static String replaceSpace (String name){
		return name.replace(" ", "%20");
	}

	public void initialization (){

		userProfile = new Profile ();

		//Copy.copyFile(test.getAbsolutePath().substring(0, test.getAbsolutePath().length() - 3)+ "xboxcontroller.dll", test.getAbsolutePath()+ "/xboxcontroller.dll");	
		//Instantiating a new XboxController using the driver file
		
		//c = new XboxController ("xboxcontroller", 1, 0, 0 );
		//Set the dead zone of joystick(Basically the joysticks are extremely sensitive so we must increase the radius at which start reading so that the slightest input is not read in
		//c.setLeftThumbDeadZone(0.2);
		//c.setRightThumbDeadZone(0.2);

		fc = new JFileChooser(); 
		fc.addChoosableFileFilter(new Filter ());
		fc.setAcceptAllFileFilterUsed(false);

		//server = new Server (NETWORK_PORT);//Instantiate a server object that will listen to port 10000
		//client = new Client ("", NETWORK_PORT);//instantiate the client object with the specified ip address on port 10000

		resize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLayout(null); //no layout
		nameTextField = new TextField(100);
		sendMessageField = new TextField (500);
		addMouseListener(this); // Add the MouseListener
		addMouseMotionListener(this); // Add the MouseMotionListener
		addKeyListener(this); // so keyboard works with mouse
		nameTextField.addKeyListener(this);
		sendMessageField.addKeyListener(this);
		addMouseWheelListener(this);

		cursorEffect = new Image[7];


		try {
			jarBase = getDocumentBase();
			//base = new URL ("http://sameid.byethost9.com/");
			base = getDocumentBase();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}



		loader = getImage (jarBase, "loading.png");
		buttonAnimate = getImage (base, "boxhead/MenuImages/blank.png");

		liveInviteImg = getImage(base, "boxhead/MenuImages/liveInvite.png");
		liveFriendImg = getImage(base, "boxhead/MenuImages/liveFriend.png");
		liveOfflineImg = getImage(base, "boxhead/MenuImages/liveOffline.png");
		liveAcceptImg = getImage(base, "boxhead/MenuImages/liveAccept.png");
		liveDeclineImg = getImage(base, "boxhead/MenuImages/liveDecline.png");
		liveRemoveImg = getImage(base, "boxhead/MenuImages/liveRemove.png");

		liveInviteSentImg = getImage(base, "boxhead/MenuImages/liveInviteSent.png");
		liveMessageSentImg = getImage(base, "boxhead/MenuImages/liveMessageSent.png");
		liveMessage = getImage (base, "boxhead/MenuImages/liveReceiveMessage.png");

		film = getImage(base, "boxhead/MenuImages/film.png");

		bigLoad = getImage (base, "boxhead/MenuImages/loader.png");
		fbLoad  = getImage (base, "boxhead/MenuImages/fbloader.png");


		chatBox = getImage (base, "boxhead/MenuImages/chatBox.png");

		// Various image declerations
		mainMenuImage = getImage(base, "boxhead/MenuImages/mainMenu.png");
		mainMenuOnlineImage = getImage(base, "boxhead/MenuImages/mainMenuOnline.png");
		signInMenuImage = getImage(base, "boxhead/MenuImages/signIn.png");
		popUpMessageImage = getImage(base, "boxhead/MenuImages/popUpMessage.png");
		createNewProfileImage = getImage(base,"boxhead/MenuImages/createNewProfileScreen.png");
		editProfileImage = getImage(base, "boxhead/MenuImages/editProfile.png");

		invitationDialogImage = getImage(base,"boxhead/MenuImages/invitationDialog.png");

		friendsScreenImage = getImage(base,"boxhead/MenuImages/friendsScreen.png");

		friendsScreenImage2 = getImage(base, "boxhead/MenuImages/friendsScreenClick.png");
		searchFriendsImage = getImage(base,"boxhead/MenuImages/searchProfileInviteFriend.png");

		gameOverScreenImage = getImage (base, "boxhead/MenuImages/gameOver.png");

		buttonEffect = getImage(base,"boxhead/MenuImages/buttonEffect/buttonEffect1sec.gif");

		textHover = getImage(base, "boxhead/MenuImages/highlight.png");
		selected = getImage(base, "boxhead/MenuImages/selected.png");

		joinGameImage = getImage(base, "boxhead/MenuImages/join.png");
		hostGameImage = getImage(base, "boxhead/MenuImages/host.png");
		networkImage = getImage(base,"boxhead/MenuImages/hostorjoin.png");

		connected = getImage(base, "boxhead/MenuImages/connected.png");

		intructions = getImage(base, "boxhead/MenuImages/instructions.png");
		intructions2 = getImage(base, "boxhead/MenuImages/instructions2.png");
		buttons[START_SOLO] = new CustomButton(395, 245,"mainMenu/startSolo.png");

		profilePic = new CustomButton (735,35,"friendsScreen/profilePic.png");
		profilePic.setWidth(100);
		profilePic.setHeight(100);
		buttons[ONLINE] = new CustomButton(95, 245, "mainMenu/multiplayer.png");
		buttons[OPTIONS] = new CustomButton(695, 245, "mainMenu/options.png");


		buttons[RETURN_TO_MENU] = new CustomButton(248, 479,
		"signInMenu/returnToMenu.png");

		// When you are signed in and the main menu these are the extra options
		// that exist
		buttons[FRIENDS] = new CustomButton(430-5, 545-5, "mainMenu/friends.png");
		buttons[EDIT_PROFILE] = new CustomButton(720-5, 545-5,"mainMenu/editProfile.png");

		// To be user later within gamplay
		buttons[RETURN_TO_GAME] = new CustomButton(735, 495,"mainMenu/clan.png");

		// Save changes applied to the clan or profile
		buttons[SAVE] = new CustomButton(735, 560,"editCreateProfileMenu/save.png");

		// For any of the pop up messages
		buttons[OK] = new CustomButton(634, 34, "popUpMessage/ok.png");



		// Accept or declining invites
		buttons[ACCEPT] = new CustomButton(150 + 90 - 5, 200 + 180 - 5,"mainMenu/accept.png");
		buttons[DECLINE] = new CustomButton(150 + 375 - 5, 200 + 180 - 5,"mainMenu/decline.png");

		// Accept or decline dialogs
		buttons[YES] = new CustomButton(133 + 90 - 5, 150 + 180 - 5,"noClanScreen/yes.png");
		buttons[NO] = new CustomButton(133 + 375 - 5, 150 + 180 - 5,"noClanScreen/no.png");

		// This button only exists when you are on the main screen and are
		// signed into your profile

		// These buttons are used within the search the three search screens
		buttons[ADD] = new CustomButton(358 + 35 - 5, 106 + 310 - 5,"friendsScreen/add.png");
		buttons[RETURN_TO_MENU2] = new CustomButton(358 + 35 - 5,106 + 385 - 5, "signInMenu/returnToMenu.png");


		buttons[ADD_FRIEND] = new CustomButton(0, 0,"friendsScreen/addFriend.png");
		buttons[REMOVE_FRIEND] = new CustomButton(0, 0,"friendsScreen/friendRemove.png");

		buttons [JOIN] = new CustomButton(0,0,"networkScreen/join.png");
		buttons [HOST] = new CustomButton(0,0,"networkScreen/host.png");


		buttons [INBOX] = new CustomButton(0,0,"friendsScreen/inbox.png");
		buttons [SEND] = new CustomButton(0,0,"friendsScreen/sendMessage.png");

		buttons [SIGN_UP] = new CustomButton(210+211,86+400,"mainMenu/signUp.png");
		buttons [REFRESH] = new CustomButton(0,0,"networkScreen/refresh.png");

		buttons [POSTFB] = new CustomButton (258+85, 200+145, "mainMenu/post.png");

		popUpMessage = new PopUpMessage();
		popUpMessage.setMessage(0);


		// Fonts
		Font f = null;
		try {
			f = Font.createFont( Font.TRUETYPE_FONT, getClass().getResourceAsStream("big_noodle_titling.ttf") );
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		smallFont = f.deriveFont(24f);
		onlineMenuFont = f.deriveFont(24f);
		onlineMenuFontSpec = f.deriveFont(52f);

		smallerFont = f.deriveFont(20f);
		defaultFont = f.deriveFont(35f);
		clanFont =f.deriveFont(30f);



		//onlineMenuFont = new Font("BigNoodleTitling", Font.PLAIN, 24);
		//onlineMenuFontSpec = new Font("BigNoodleTitling", Font.PLAIN, 52);

		searchResults = new HighlightText(358 + 20, 106 + 135);

		friendList = new HighlightText(31, 110);
		friendList.setWidth(500);
		friendList.setHeight(100);

		gameList = new HighlightText(108,161);
		gameList.setWidth(800);
		gameList.setHeight(40);


		for (int i = 0; i < buttons.length; i++) {
			try{
				buttons[i].setButtonOrgImage(getImage(base, buttons[i].getOrgDirectory()));
				buttons[i].setButtonHoverImage(getImage(base, buttons[i].getHoverDirectory()));
			}
			catch (Exception e){

				System.out.println (i);
			}
		}

		profilePic.setButtonOrgImage(getImage (base, profilePic.getOrgDirectory()));
		profilePic.setButtonHoverImage(getImage(base, profilePic.getHoverDirectory()));
		// Buttons declarations
		scrollButtons[SEARCH_UP] = new ScrollButton(358 + 270, 106 + 135, true);
		scrollButtons[SEARCH_DOWN] = new ScrollButton(358 + 270, 106 + 270,false);

		tempProfile = null;

		friendScroll = new ScrollBar (530,110, 15, friendList, "boxhead/MenuImages/scrollBar.png");
		friendScroll.setImage(getImage (base, friendScroll.getDirectory()));


		gameScroll = new ScrollBar (908,161, 15, gameList, "boxhead/MenuImages/scrollBar.png");
		gameScroll.setImage(getImage (base, gameScroll.getDirectory()));

		dateFormat = new SimpleDateFormat("mm"); // gets the minute
		ftpConnectTime = Integer.parseInt(dateFormat.format(Calendar.getInstance().getTime()));

		enemies = new ArrayList<Enemy>();
		obstacles = new ArrayList<Obstacle>();
		itemDrops = new ArrayList<Item>();
		explosions = new ArrayList <Explosion> (); /*****/
		player.setHealth(100);
		player.setWeapon(new Weapon(NUM_WEAPON_TYPES));
		player.getWeapon().setBullets(new ArrayList<Bullet>());
		player.getWeapon().setTurrets(new ArrayList<Turret>());/*****/
		player.setHeight(CHAR_SIZE);
		player.setWidth(CHAR_SIZE);
		player.setX(SCREEN_WIDTH / 2);
		player.setY(SCREEN_HEIGHT / 2);

		for (int i = 0; i < crosshairOuter.length; i++){
			crosshairOuter[i] = getImage(base, "boxhead/GameImages/sprites/crosshair/outerCrosshair" + Integer.toString(i)+".png");
		}

		for (int i = 0; i < crosshairInner.length; i++){
			crosshairInner[i] = getImage(base, "boxhead/GameImages/sprites/crosshair/innerCrosshair" + Integer.toString(i)+".png");
		}


		String [] type = new String [8];
		type [0] = "up";
		type [1] = "down";
		type [2] = "left";
		type [3] = "right";
		type [4] = "upRight";
		type [5] = "upLeft";
		type [6] = "downRight";
		type [7] = "downLeft";

		for (int i = 0; i < 32; i ++){
			enemy[i]=getImage(base,"boxhead/GameImages/sprites/enemies/" + type[i/4] + "Walk" + Integer.toString(i%4) + ".png");
			enemy2[i]=getImage(base,"boxhead/GameImages/sprites/enemies2/" + type[i/4] + "Walk" + Integer.toString(i%4) + ".png");
			enemy3[i]=getImage(base, "boxhead/GameImages/sprites/enemies3/" + type[i/4] + "Walk" + Integer.toString(i%4) + ".png");
			enemy4[i]=getImage(base,"boxhead/GameImages/sprites/enemies4/" + type[i/4] + "Walk" + Integer.toString(i%4) + ".png");
			boss[i]=getImage(base, "boxhead/GameImages/sprites/boss/" + type[i/4] + "Walk" + Integer.toString(i%4) + ".png");
			boss2[i]=getImage(base, "boxhead/GameImages/sprites/boss2/" + type[i/4] + "Walk" + Integer.toString(i%4) + ".png");
			boss3[i]=getImage(base, "boxhead/GameImages/sprites/boss3/" + type[i/4] + "Walk" + Integer.toString(i%4) + ".png");
			character[i]=getImage(base,"boxhead/GameImages/sprites/main/" + type[i/4] + "Walk" + Integer.toString(i%4) + ".png");
			character2[i]=getImage(base, "boxhead/GameImages/sprites/main2/" + type[i/4] + "Walk" + Integer.toString(i%4) + ".png");
			character3[i]=getImage(base, "boxhead/GameImages/sprites/main3/" + type[i/4] + "Walk" + Integer.toString(i%4) + ".png");
			character4[i]=getImage(base, "boxhead/GameImages/sprites/main4/" + type[i/4] + "Walk" + Integer.toString(i%4) + ".png");
		}

		/*****/
		turret[0] = getImage(base,"boxhead/GameImages/sprites/turret/up.png");
		turret[1] = getImage(base,"boxhead/GameImages/sprites/turret/down.png");
		turret[2] = getImage(base,"boxhead/GameImages/sprites/turret/left.png");
		turret[3] = getImage(base, "boxhead/GameImages/sprites/turret/right.png");
		turret[4] = getImage(base, "boxhead/GameImages/sprites/turret/downRight.png");
		turret[5] = getImage(base,"boxhead/GameImages/sprites/turret/downLeft.png");

		turret2[0] = getImage(base, "boxhead/GameImages/sprites/turret2/up.png");
		turret2[1] = getImage(base, "boxhead/GameImages/sprites/turret2/down.png");
		turret2[2] = getImage(base, "boxhead/GameImages/sprites/turret2/left.png");
		turret2[3] = getImage(base, "boxhead/GameImages/sprites/turret2/right.png");
		turret2[4] = getImage(base, "boxhead/GameImages/sprites/turret2/downRight.png");
		turret2[5] = getImage(base, "boxhead/GameImages/sprites/turret2/downLeft.png");
		/*****/

		weapons [PISTOL] =  getImage(base, "boxhead/GameImages/sprites/weapons/pistol.png");
		weapons [MACHINE] =  getImage(base,"boxhead/GameImages/sprites/weapons/machine.png");
		weapons [SHOTGUN] =  getImage(base,"boxhead/GameImages/sprites/weapons/shotGun.png");
		weapons [SNIPER] =  getImage(base,"boxhead/GameImages/sprites/weapons/sniper.png");/*****/
		weapons [TURRET] =  getImage(base,"boxhead/GameImages/sprites/weapons/turret.png");/*****/
		weapons [GRENADE] =  getImage(base,"boxhead/GameImages/sprites/weapons/grenadeWeapon.png");/*****/
		weapons [RPG] =  getImage(base,"boxhead/GameImages/sprites/weapons/rpg.png");/*****/
		weapons [RPG_TURRET] =  getImage(base,"boxhead/GameImages/sprites/weapons/rocketTurret.png");/*****/

		bullet =  getImage(base,"boxhead/GameImages/sprites/weapons/bullet.png");
		stickyBullet =  getImage(base,"boxhead/GameImages/sprites/boss/enemyBullet.png");
		rocket =  getImage(base, "boxhead/GameImages/sprites/weapons/rocket.png");/*****/
		grenade =  getImage(base, "boxhead/GameImages/sprites/weapons/grenade.png");/*****/


		// explosion pictures
		for (int i = 0; i < 24; i++){
			explosion[i] = getImage (base,"boxhead/GameImages/sprites/explosion/explosion" + Integer.toString(i)+".png");
		}

		// grenade explosion pictures
		for (int i = 0; i < 34; i++){
			fragOut[i] = getImage (base,"boxhead/GameImages/sprites/fragOut/frag" + Integer.toString(i)+".png");
		}

		// enemy explosion pictures
		for (int i = 0; i < 15; i++){
			enemyExplosion[i] = getImage (base,"boxhead/GameImages/sprites/enemyExplosion/explosion" + Integer.toString(i)+".png");
		}



		obstacle =getImage(base, "boxhead/GameImages/sprites/environment/tree.png");

		items[HEALTH_PICKUP] = getImage (base,"boxhead/GameImages/sprites/items/health.png");
		items[UZI_PICKUP] = getImage (base, "boxhead/GameImages/sprites/items/machine.png");
		items[SHOTGUN_PICKUP] = getImage (base, "boxhead/GameImages/sprites/items/shotgun.png");
		items[SNIPER_PICKUP] = getImage(base,"boxhead/GameImages/sprites/items/sniper.png");/*****/
		items[TURRET_PICKUP] = getImage(base, "boxhead/GameImages/sprites/items/turret.png");/*****/
		items[GRENADE_PICKUP] = getImage(base,"boxhead/GameImages/sprites/items/grenade.png");/*****/
		items[RPG_PICKUP] = getImage(base,"boxhead/GameImages/sprites/items/rpg.png");/*****/
		items[RPG_TURRET_PICKUP] = getImage(base,"boxhead/GameImages/sprites/items/rocketTurret.png");/*****/

		background = getImage (base,"boxhead/GameImages/sprites/Background.png");
		soundEffects[0] = getAudioClip(base,"boxhead/Sounds/weapons/pistolShot.wav");
		soundEffects[1] = getAudioClip(base,"boxhead/Sounds/weapons/machineShot.wav");	
		soundEffects[2] = getAudioClip(base, "boxhead/Sounds/weapons/shotgunShot.wav");
		soundEffects[8] = getAudioClip(base, "boxhead/Sounds/weapons/sniperShot.wav");/*8*/
		soundEffects[10] = getAudioClip(base,"boxhead/Sounds/weapons/grenadeThrow.wav");/*8*/
		soundEffects[11] = getAudioClip(base,"boxhead/Sounds/weapons/rpgShot.wav");/*8*/




		soundEffects[3] = getAudioClip(base, "boxhead/Sounds/weapons/machineEquip.wav");
		soundEffects[4] = getAudioClip(base, "boxhead/Sounds/weapons/shotgunEquip.wav");
		soundEffects[5] = getAudioClip(base, "boxhead/Sounds/item/healthEquip.wav");
		soundEffects[6] = getAudioClip(base,"boxhead/Sounds/weapons/turretEquip.wav");/*8*/
		soundEffects[7] = getAudioClip(base,"boxhead/Sounds/weapons/sniperEquip.wav");/*8*/
		soundEffects[12] = getAudioClip(base,"boxhead/Sounds/weapons/grenadeEquip.wav");/*8*/
		soundEffects[13] = getAudioClip(base,"boxhead/Sounds/weapons/rpgEquip.wav");/*8*/


		System.out.println ("called");

		soundEffects[9] = getAudioClip(base, "boxhead/Sounds/weapons/explosion.wav");/*8*/
		soundEffects[14] = getAudioClip(base,"boxhead/Sounds/weapons/fragOut.wav");/*8*/
		soundEffects[15] = getAudioClip(base, "boxhead/Sounds/weapons/gasExplosion.wav");/*8*/



		//playMusic ("Lone Wolf.mp3");

		gameHud = getImage(base, "boxhead/GameImages/hud3.png");
		nickname = getImage (base, "boxhead/MenuImages/nn.png");
		nofb = getImage (base, "boxhead/MenuImages/nofb.png");
		nonn = getImage (base, "boxhead/MenuImages/nonn.png");
		tg = getImage (base,  "boxhead/MenuImages/tg.png");

		System.out.println ("Initialization has completed succesfully!");

	}







	public void getInput (){
		/*
		 * The APLU Xbox controller gamepad library is slightly odd int the way that it works.
		 * 
		 * There are only three classes but what happens is when I instantiate a new XboxController
		 * I need to add a Listener class which actually reads the input in. The problem is that the
		 * interface XboxControllerListener has a lot of required methods. Thats why the APLU developers
		 * created the Adapter class allowing for interface class to plug into the Adapter class, then we 
		 * can instantiate a Adapter as a listener and only need to inherit the methods required for our game.
		 * 
		 */
		/*c.addXboxControllerListener(new XboxControllerAdapter()//Adds a listener in which we can over ride and only use the methods we need
		{
			//These methods gets us the Directions and MAgnitudes of both the left and right joysticks
			public void leftThumbDirection (double direction)
			{
				directionLeft=  direction;
			}

			public void leftThumbMagnitude (double magnitude)
			{
				magnitudeLeft = magnitude;
			}

			public void rightThumbDirection (double direction)
			{
				directionRight = direction;
			}

			public void rightThumbMagnitude (double magnitude)
			{
				magnitudeRight = magnitude;
			}




			//Button inputs
			public void buttonB (boolean pressed)
			{
				if (pressed){
					System.out.println ("test");
					setButton(BUTTON_B);
				}
			}

			public void buttonA (boolean pressed)
			{
				if (pressed){                           

					setButton(BUTTON_A);	

				}
			}
			public void buttonX (boolean pressed)
			{
				if (pressed){

					setButton(BUTTON_X);
				}
			}

			public void buttonY (boolean pressed)
			{
				if (pressed){   

					setButton(BUTTON_Y);

				}
			}

			public void start (boolean pressed)
			{
				if (pressed){   

					setButton(START);

				}
			}

			public void leftShoulder (boolean pressed)
			{
				if (pressed){   

					setButton(LEFT_SHOULDER);

				}
			}
			public void rightShoulder (boolean pressed)
			{
				if (pressed){   

					setButton(RIGHT_SHOULDER);
				}
			}

		});*/

	}

/*
	public void setButton(int button) {
		this.button = button;
	}

	public int getButton() {
		return button;
	}*/

	public void playMusic (String fileName){
		if (MUSIC){
			File tempFile = new File("");

			try {
				System.out.println (tempFile.getCanonicalPath().substring(0, tempFile.getCanonicalPath().length() - 4)+"/src/Sounds/" + fileName);
				tempFile = new File (tempFile.getCanonicalPath().substring(0, tempFile.getCanonicalPath().length() - 4)+"/src/Sounds/" + fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				mp3Player = jlap.playMp3(tempFile, new OurListener());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void stopMusic(){

		try{
			mp3Player.stop();
			mp3Player = null;
		}
		catch (NullPointerException e)
		{
			//System.out.println ("Blah");
		}
	}

	boolean limbo = false;
	boolean fbLimbo = false;
	boolean keepCheckingForToken = true;;


	public void mainMenu (Graphics g){

		g.drawImage(film, 0, 0 ,this);
		// main menu screen. Placed at the top as it is drawn at the lowest
		// layer
		if (signedIn && !friendsScreen) {
			// signed in menu screen
			g.drawImage(mainMenuOnlineImage, 0, 0, this);

			if (editProfileScreen || optionScreen ) {

				// signed in extra buttons no hover
				drawButtonNoHover(g, FRIENDS);
				drawButtonNoHover(g, EDIT_PROFILE);

			} else{
				// signed in extra buttons with hover
				drawButton(g, FRIENDS);
				drawButton(g, EDIT_PROFILE);
			}

			g.setFont(onlineMenuFont);
			g.setColor(Color.white);
			try{
				g.drawString(Integer.toString(userProfile.getScore()),135,534);
				g.drawString(Integer.toString(userProfile.getLevelReached()), 155, 574);
				g.drawString(userProfile.getRank(), 85, 614);
			}
			catch (Exception e){
				g.drawString("NO RANK!?", 85, 614);
			}
			g.setFont(onlineMenuFontSpec);
			g.setColor(Color.white);
			try{
				g.drawString(" " +userProfile.getName().substring(0, userProfile.getName().indexOf(" ")) +" (" + userProfile.getNickname() +")", 180, 478);
			}
			catch (Exception e){
				//g.drawString(userProfile.getName().substring(0, userProfile.getName().indexOf(" ")), 180, 478);
				System.out.println (userProfile.getName());
				g.drawString(userProfile.getName(), 180, 478);

			}

			drawButton(g, START_SOLO);
			drawButton(g, ONLINE);
			drawButton(g, OPTIONS);




		} else if (!signedIn && !friendsScreen){
			// menu screen image, a computer picture if not signed in
			g.drawImage(mainMenuImage, 0, 0, this);
			if(nickNameScreen){
				g.drawImage(nonn, 210, 325, this);

			}
			else{
				g.drawImage(nofb, 210, 400, this);
				drawButton(g, SIGN_UP);
			}
			drawButton(g, START_SOLO);
			drawButton(g, ONLINE);
			drawButton(g, OPTIONS);

		}

		else if (friendsScreen) {
			g.setFont(defaultFont);
			g.setColor(Color.white);
			// Draws images and buttons for friends screen
			if ((currentlyClicked ==-1) || (currentlyClicked != -1 && searchProfileScreen)){
				g.drawImage(friendsScreenImage, 0, 0, this);

			}
			else {
				g.drawImage(friendsScreenImage2, 0, 0, this);
			}



			g.drawImage(friendScroll.getImage(), friendScroll.getX(), friendScroll.getBarPosition(), 15, friendScroll.getBarHeight(), this);
			//System.out.println (friendScroll.getBarHeight());



			if (searchProfileScreen) {

				g.drawImage(pp, profilePic.getX(),profilePic.getY(),this);

				g.drawImage(profilePic.getButtonImage(false), profilePic.getX(), profilePic.getY(), this);

				drawButtonNoHover(g, ADD_FRIEND);
				drawButtonNoHover(g, RETURN_TO_MENU);
				drawButtonNoHover(g, INBOX);


			} else {

				g.drawImage(pp, profilePic.getX(),profilePic.getY(),100, 100,this);

				g.drawImage(profilePic.getButtonImage(profilePic.checkHover(mouseMoveX, mouseMoveY)), profilePic.getX(), profilePic.getY(), this);


				drawButton(g, ADD_FRIEND);
				drawButton(g, RETURN_TO_MENU);
				drawButton(g, INBOX);

				if (currentlyClicked != -1){
					drawButton(g, REMOVE_FRIEND);
					drawButton(g, SEND);
				}

			}

			if (friendListReturn != null) {

				if (!searchProfileScreen) {
					if (currentlyClicked != -1) {
						g.drawImage(selected, 31,(currentlyClicked * 100) + 100+9,498,26,  this);
					}
				}

				for (int i = 0; i < friendListReturn.length; i++) {
					int j = (i * 100) + 110 + 20;
					if (friendListReturn.length > 1) {
						int incrementor = (i * 100) + 109 - 25;
						if (friendList.getPositionHover() == i) {
							g.drawImage(textHover,31,incrementor +26, 498, 100, this);
						}
					} else {
						int incrementor = (i * 100) + 110;
						if (friendList.getPositionHover() == i) {
							g.drawImage(textHover,  31, incrementor,498,100, this);
						}

					}



					// Displays the leagues on the screen
					g.setFont(smallerFont);
					//Profile temp = downloadLoadProfile(friendListReturn[i]);
					/*if (temp.isOnline()){
					g.setColor (Color.GREEN);
					g.fillOval (208 + 20, j-13, 10, 10);
				}
				else {
					g.setColor (Color.RED);
					g.fillOval (208 + 20, j-13, 10, 10);
				}
				g.setColor (Color.WHITE);*/

					g.drawString(friendListReturn[i], 35, j);
				}

			}

		} 
		// buttons for the main menu that appears in both menu screens

		// higher layers, placed above main menu (the sign in screen)

		// The options if the user is in the edit profile screen
		if (profileInvitationScreen) { // Draws the screen and
			// buttons for the profile
			// invitation screen
			g.drawImage(invitationDialogImage, 150, 200, this);
			if (invites.size() > 0 && addFriend) {
				g.setColor(Color.white);
				g.drawString(invites.get(0), 250, 340);
			}

			drawButton(g, ACCEPT);
			drawButton(g, DECLINE);
		} 
		else if (animationScreen){
			animateButtonToMenu();
			g.drawImage(buttonAnimate, (int)x1, (int)y1,(int)width, (int)height, this);
		}
		else if (networkScreen) {

			g.drawImage(buttonAnimate, (int)x1, (int)y1,(int)width, (int)height, this);
			g.drawImage(networkImage, 158, 200, this);
			drawButton(g, RETURN_TO_MENU);
			drawButton(g, JOIN);
			drawButton(g, HOST);
		}
		else if (joinGameScreen){
			g.drawImage(joinGameImage, 58,81,this);
			drawButton(g, RETURN_TO_MENU);
			drawButton(g, JOIN);
			drawButton(g, REFRESH);


			g.drawImage(gameScroll.getImage(), gameScroll.getX(), gameScroll.getBarPosition(), 15, gameScroll.getBarHeight(), this);
			if (gameListReturn != null) {

				if (!searchProfileScreen) {
					if (currentlyClicked != -1) {
						g.drawImage(selected, 109,(currentlyClicked * 40) +161,798,41,  this);
					}
				}

				for (int i = 0; i < gameListReturn.length; i++) {
					int j = (i * 40) + 161 +25;
					if (gameListReturn.length > 1) {
						int incrementor = (i * 40) + 161;
						if (gameList.getPositionHover() == i) {
							g.drawImage(textHover,109,incrementor, 798, 40, this);
						}
					} else {
						int incrementor = (i * 40) + 161;
						if (gameList.getPositionHover() == i) {
							g.drawImage(textHover,  109, incrementor,798,40, this);
						}

					}
					g.setFont(smallerFont);
					g.setColor(Color.WHITE);
					g.drawString(gameListReturn[i], 115, j);
				}

			}

		}
		else if (hostGameScreen){
			g.drawImage(hostGameImage, 158,150,this);
			drawButton(g, RETURN_TO_MENU);
			g.setFont(onlineMenuFontSpec);
			g.setColor(Color.white);
			g.drawString(network.getServer().getLocalIp(), 158+325, 150+125);
		}
		else if (networkConnectedScreen){
			g.drawImage(connected, 158,150,this);
			g.setFont(onlineMenuFontSpec);
			g.setColor(Color.white);
			try{
				g.drawString(networkProfile.getNickname(), 158+300, 150+125);
			}
			catch (NullPointerException e){
				//System.out.println ("Can get. Wait...");
			}
		}
		else if (optionScreen) {
			//	if (c.isConnected()){
			//g.drawImage(intructions, 108, 30, this);
			//}
			//else{
			g.drawImage(intructions2, 108, 30, this);
			//}
			drawButton(g, RETURN_TO_MENU);
		}
		else if (tempNickScreen) {

			g.drawImage(buttonAnimate, (int)x1, (int)y1,(int)width, (int)height, this);
			g.drawImage(tg, 258, 281, this);
		}
		else if (gameOverScreen) {
			g.drawImage(gameOverScreenImage, 258,200, this);
			drawButton(g, POSTFB);
			drawButton(g, RETURN_TO_MENU);
			g.setColor(Color.WHITE);
			g.setFont(onlineMenuFont);
			g.drawString (Integer.toString(level), 258+370, 200+60);

			g.drawString (Integer.toString(currentScore), 258+370, 200+95);
		}

		if (searchProfileScreen) { // both friendsScreen and clanScreen
			// use this screen, so it's placed
			// outside their if statements

			if (addFriend) {
				g.drawImage(searchFriendsImage, 358, 106, this);
				if (searchResultsReturn != null) {
					for (int i = 0; i < searchResultsReturn.length; i++) {
						int j = (i * 25) + 262;
						// Checks to see if there is actually a result
						if (searchResultsReturn.length > 1) {
							int incrementor = (i * 25) + 106 + 135 - 25;
							if (searchResults.getPositionHover() == i) {
								g.drawImage(textHover, 358 + 20,
										incrementor + 25, this);
							}

						} else {
							int incrementor = (i * 25) + 106 + 135;
							if (searchResults.getPositionHover() == i) {
								g.drawImage(textHover, 358 + 20,
										incrementor, this);
							}

						}

						// Displays the search results
						g.setFont(smallerFont);
						g.drawString(searchResultsReturn[i], 385, j);
					}
					if (currentlyClicked != -1) {
						g.drawImage(selected, 358 + 20,
								(currentlyClicked * 25) + 106 + 135, this);
					}
				}
			} 

			// Draws the add button to the screen for adding a clan member
			// or a friend
			drawButton(g, ADD);
			drawButton(g, RETURN_TO_MENU2);
		}
		// highest priority/layer, the pop up message screen
		if (popUpMessageScreen) {
			// Draws the images and text for the pop up screen
			g.drawImage(popUpMessageImage, 15, 15, this);
			g.setFont(defaultFont);
			g.setColor(Color.white);
			g.drawString(popUpMessage.getMessage(), popUpMessage.getX(),popUpMessage.getY());
			g.drawImage(buttons[OK].getButtonImage(buttons[OK].checkHover(mouseMoveX, mouseMoveY)), buttons[OK].getX(),buttons[OK].getY(), this);
			g.drawImage(buttonEffect, buttons[OK].getX(), buttons[OK].getY(), this);
		}

		/*if (chat){
			g.setFont(defaultFont);
			g.setColor(Color.white);
			for (int i = chats.size() -1; i >= 0 ; i--){

				g.drawImage (chatBox, (int)chats.get(i).getX(), (int)chats.get(i).getY(), this);
				g.drawString(chats.get(i).getFriend(), (int)chats.get(i).getX()+10, (int)chats.get(i).getY()+40);
			}
		}*/

		if (liveNotification){
			g.setFont(defaultFont);
			g.setColor(Color.white);
			boolean drawAbove = false;
			boolean notify = true;

			if (nt.getLiveNotify().getNotification().equals("invite")){
				g.drawImage (liveInviteImg, 50, liveY, this);


				drawAbove = true;
			}
			else if (nt.getLiveNotify().getNotification().equals("online")){
				g.drawImage (liveFriendImg, 50, liveY, this);
				drawAbove = true;
			}
			else if (nt.getLiveNotify().getNotification().equals("offline")){
				g.drawImage (liveOfflineImg, 50, liveY, this);
				drawAbove = true;
			}
			else if (nt.getLiveNotify().getNotification().equals("accepted")){
				g.drawImage (liveAcceptImg, 50, liveY, this);
				drawAbove = true;
			}
			else if (nt.getLiveNotify().getNotification().equals("declined")){
				g.drawImage (liveDeclineImg, 50, liveY, this);
				drawAbove = true;
			}
			else if (nt.getLiveNotify().getNotification().equals("removed")){
				g.drawImage (liveRemoveImg, 50, liveY, this);
				drawAbove = true;
			}
			else if (nt.getLiveNotify().getNotification().equals("invite sent")){
				g.drawImage (liveInviteSentImg, 50, liveY, this);
				drawAbove = false;
			}
			else if (nt.getLiveNotify().getNotification().equals("message sent")){
				System.out.println ("received notification");
				g.drawImage (liveMessageSentImg, 50, liveY, this);
				drawAbove = false;
			}
			else if (nt.getLiveNotify().getNotification().equals("message received")){
				g.drawImage (liveMessage, 50, liveY, this);
				drawAbove = true;
				notify = false;
			}
			if (drawAbove && notify){
				g.drawString(nt.getLiveNotify().getUser(), 165+55, liveY +45);
			}
			else if (!drawAbove && notify){

				g.drawString(nt.getLiveNotify().getUser(), 165+55, liveY +80);
			}
			else {
				g.drawString(nt.getLiveNotify().getMessage().getSender(), 165+55, liveY +45);
				g.setFont(smallerFont);
				g.drawString(nt.getLiveNotify().getMessage().getMessage(), 165+55, liveY +70);
				//different font for message...
			}

			Image other = null;
			try {
				other = getImage (new URL (nt.getLiveNotify().getPicUrl()),nt.getLiveNotify().getPicName());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage (other, 100, liveY+25,  this);

		}

		if (limbo){
			g.drawImage(bigLoad, 0, 0, this);
		}
		else if (fbLimbo){
			g.drawImage(fbLoad, 0, 0, this);	
		}
	}

	boolean load = true;
	public void paint(Graphics g) {


		if(load){

			load = false;
		}
		else{
			// ////////////////////////////////////////////////////////////////////////////////////////////////////////////
			if (mainMenu) {
				mainMenu(g);

			} 
			else if (game) {

				try {

					g.drawImage (background, 0,0,this);
					int tempNum = 0;
					if (multiplayer) {
						if (hosting){
							tempNum = enemies.size() + obstacles.size() + player.getWeapon().getBullets().size() + player.getWeapon().getTurrets().size() + 2;
						}
						else{
							tempNum = enemies.size() + obstacles.size() + concurrentBulletFix.size() + 2;
						}
					} else {
						tempNum = enemies.size() + obstacles.size() + player.getWeapon().getBullets().size() + player.getWeapon().getTurrets().size() + 1; /*****/
					}
					/*****/

					// sort items
					if (itemDrops.size() > 1){
						Object[] drawingItems = new Object [itemDrops.size()];
						for (int i = 0; i < itemDrops.size(); i++) {
							drawingItems[i] = itemDrops.get(i);
						}
						MainApplet.sort(drawingItems, 0, drawingItems.length - 1);

						//g.setColor(Color.black);
						for (int i = 0; i < drawingItems.length; i++) {
							Item item = (Item) drawingItems[i];
							g.drawImage(items[item.getType()], item.getItemPosition()[0]- Item.ITEM_SIZE / 2, item.getItemPosition()[1] - Item.ITEM_SIZE / 2, this);
						}
					}
					else{
						for (int i = 0; i < itemDrops.size(); i++) {
							g.drawImage(items[itemDrops.get(i).getType()], itemDrops.get(i).getItemPosition()[0]- Item.ITEM_SIZE / 2, itemDrops.get(i).getItemPosition()[1] - Item.ITEM_SIZE / 2, this);
						}
					}




					Object[] drawingObjects = new Object[tempNum];
					for (int i = 0; i < enemies.size(); i++) {
						drawingObjects[i] = enemies.get(i);
					}
					for (int i = enemies.size(); i < enemies.size() + obstacles.size(); i++) {
						drawingObjects[i] = obstacles.get(i - enemies.size());
					}

					for (int i = enemies.size() + obstacles.size(); i < enemies.size() + obstacles.size()+ player.getWeapon().getTurrets().size(); i++){
						drawingObjects[i] = player.getWeapon().getTurrets().get(i - (enemies.size() + obstacles.size()));
					}

					if (!hosting){


						//concurrent bullet fix is x4 now cause extra implmentation...
						for (int i = enemies.size() + obstacles.size()+ player.getWeapon().getTurrets().size(); i < enemies.size() + obstacles.size()+ networkPlayer.getWeapon().getTurrets().size() + concurrentBulletFix.size(); i++) {

							try{
								drawingObjects[i] = concurrentBulletFix.get(i - (enemies.size() + obstacles.size()+ networkPlayer.getWeapon().getTurrets().size()));
							}
							catch(ArrayIndexOutOfBoundsException e){
								e.printStackTrace();
							}
						}
					}
					else{
						for (int i = enemies.size() + obstacles.size()+ player.getWeapon().getTurrets().size(); i < enemies.size() + obstacles.size()+ player.getWeapon().getTurrets().size() + player.getWeapon().getBullets().size(); i++) {
							try{
								drawingObjects[i] = player.getWeapon().getBullets().get(i - (enemies.size() + obstacles.size()+ player.getWeapon().getTurrets().size()));
							}
							catch(ArrayIndexOutOfBoundsException e){
								e.printStackTrace();
							}
						}
					}

					if (multiplayer){
						drawingObjects [tempNum - 2] = player;
						drawingObjects [tempNum - 1] = networkPlayer;
					}
					else{
						drawingObjects [tempNum - 1] = player;
					}

					MainApplet.sort(drawingObjects, 0, drawingObjects.length - 1);


					for (int i = 0; i < tempNum; i++) {

						if (drawingObjects[i] instanceof Character) {
							Character drawingCharacter = (Character) drawingObjects[i];
							int charDir = 0;
							double angle = drawingCharacter.getAimDirection();
							if (angle != -1){
								if (!drawingCharacter.isRadian()){
									angle = Math.toRadians(angle);
								}
							}
							else{
								angle = drawingCharacter.getDirection();
								angle = Math.toRadians(angle);
							}

							if (angle <= (Math.PI) / 8
									|| angle>= (15 * Math.PI) / 8) {// right
								charDir = 0;
							} else if (angle <= (3 * Math.PI) / 8
									&& angle>= (Math.PI) / 8) {// upRight
								charDir = 4;

							} else if (angle <= (5 * Math.PI) / 8
									&& angle>= (3 * Math.PI) / 8) {// up
								charDir = 3;

							} else if (angle <= (7 * Math.PI) / 8
									&& angle >= (5 * Math.PI) / 8) { // upleft
								charDir = 6;

							} else if (angle <= (9 * Math.PI) / 8
									&& angle >= (7 * Math.PI) / 8) {// left
								charDir = 1;

							} else if (angle <= (11 * Math.PI) / 8
									&& angle >= (9 * Math.PI) / 8) {// down
								// left
								charDir = 7;

							} else if (angle <= (13 * Math.PI) / 8
									&& angle>= (11 * Math.PI) / 8) {// down
								charDir = 2;

							}
							else if (angle <= (15 * Math.PI) / 8
									&& angle>= (13 * Math.PI) / 8) {// down
								charDir = 5;

							}

							if ((!hosting && drawingCharacter.equals(player)) || (hosting && !drawingCharacter.equals(player))){
								g.setColor(Color.GREEN);
								g.fillOval(drawingCharacter.getAimXAsInt()-3,drawingCharacter.getAimYAsInt()-3, 6, 6);
								g.drawImage(character2[drawingCharacter.getFrame(charDir)], drawingCharacter.getXAsInt(), drawingCharacter.getYAsInt()- 10, this);
							}
							else{   
								g.setColor(Color.BLUE);
								g.fillOval(drawingCharacter.getAimXAsInt()-3,drawingCharacter.getAimYAsInt()-3, 6, 6);
								g.drawImage(character[drawingCharacter.getFrame(charDir)], drawingCharacter.getXAsInt(), drawingCharacter.getYAsInt()- 10, this);
							}


							/*g.setColor(Color.GREEN);
							g.fillRect(drawingCharacter.getXAsInt(), drawingCharacter.getYAsInt(), drawingCharacter.getWidth(),drawingCharacter.getHeight());*/

						} else if (drawingObjects[i] instanceof Enemy) {
							Enemy drawingEnemy = (Enemy) drawingObjects[i];
							double[] coordinate = drawingEnemy.getEnemyPosition();
							int dir = 0;
							int extra = 0, extra2 = 0;
							if (drawingEnemy.getEnemyPosition()[2] <= (Math.PI) / 8
									|| drawingEnemy.getEnemyPosition()[2] >= (15 * Math.PI) / 8) {// right
								dir = 2;
							} else if (drawingEnemy.getEnemyPosition()[2] <= (3 * Math.PI) / 8
									&& drawingEnemy.getEnemyPosition()[2] >= (Math.PI) / 8) {// upRight
								dir = 7;
								extra2 = -3;
							} else if (drawingEnemy.getEnemyPosition()[2] <= (5 * Math.PI) / 8
									&& drawingEnemy.getEnemyPosition()[2] >= (3 * Math.PI) / 8) {// up
								dir = 1;
								extra = 6;
								extra2 = -2;
							} else if (drawingEnemy.getEnemyPosition()[2] <= (7 * Math.PI) / 8
									&& drawingEnemy.getEnemyPosition()[2] >= (5 * Math.PI) / 8) { // upleft
								dir = 6;
								extra = 5;
								extra2 = -3;
							} else if (drawingEnemy.getEnemyPosition()[2] <= (9 * Math.PI) / 8
									&& drawingEnemy.getEnemyPosition()[2] >= (7 * Math.PI) / 8) {// left
								dir = 3;
								extra = 5;
							} else if (drawingEnemy.getEnemyPosition()[2] <= (11 * Math.PI) / 8
									&& drawingEnemy.getEnemyPosition()[2] >= (9 * Math.PI) / 8) {// down
								// left
								dir = 4;
								extra = 5;
								extra2 = -5;
							} else if (drawingEnemy.getEnemyPosition()[2] <= (13 * Math.PI) / 8
									&& drawingEnemy.getEnemyPosition()[2] >= (11 * Math.PI) / 8) {// down
								dir = 0;
								extra = 6;
								extra2 = -3;
							}

							else if (drawingEnemy.getEnemyPosition()[2] <= (15 * Math.PI) / 8
									&& drawingEnemy.getEnemyPosition()[2] >= (13 * Math.PI) / 8) {// down
								// right
								dir = 5;
								extra2 = -3;
							}
							if (drawingEnemy.getType() == 1){
								g.drawImage(enemy2[drawingEnemy.getFrame(dir, currentTime)], (int) coordinate[0] - drawingEnemy.getWidth() + extra, (int) coordinate[1] - drawingEnemy.getHeight() + extra2, this);
							}
							else if (drawingEnemy.getType() == 0){
								g.drawImage(enemy[drawingEnemy.getFrame(dir, currentTime)], (int) coordinate[0] - drawingEnemy.getWidth() + extra, (int) coordinate[1] - drawingEnemy.getHeight() + extra2, this);
							}
							else if (drawingEnemy.getType() == 3){
								g.drawImage(enemy4[drawingEnemy.getFrame(dir, currentTime)], (int) coordinate[0] - drawingEnemy.getWidth() + extra, (int) coordinate[1] - drawingEnemy.getHeight() + extra2, this);
							}
							else if (drawingEnemy.getType() == 2){
								g.drawImage(enemy3[drawingEnemy.getFrame(dir, currentTime)], (int) coordinate[0] - drawingEnemy.getWidth() + extra*2, (int) coordinate[1] - drawingEnemy.getHeight() + extra2*2, this);
							}
							else if (drawingEnemy.getType() == 4){
								g.drawImage(boss[drawingEnemy.getFrame(dir, currentTime)], (int) coordinate[0] - drawingEnemy.getWidth() + extra, (int) coordinate[1] - drawingEnemy.getHeight() + extra2, this);
							}
							else if (drawingEnemy.getType() == 5){
								g.drawImage(boss2[drawingEnemy.getFrame(dir, currentTime)], (int) coordinate[0] - drawingEnemy.getWidth() + extra, (int) coordinate[1] - drawingEnemy.getHeight() + extra2, this);
							}
							else if (drawingEnemy.getType() == 6){
								g.drawImage(boss3[drawingEnemy.getFrame(dir, currentTime)], (int) coordinate[0] - drawingEnemy.getWidth() + extra*2, (int) coordinate[1] - drawingEnemy.getHeight() + extra2*2, this);
							}

							/*
							 g.setColor(Color.BLUE); 
							g.fillRect((int)coordinate[0] - drawingEnemy.getWidth()/2,(int)coordinate [1] - drawingEnemy.getHeight()/2,drawingEnemy.getWidth(), drawingEnemy.getHeight());
							g.fillRect((int)coordinate[0] - Enemy.getWidth()/2, (int)coordinate [1] - Enemy.getHeight()/2, Enemy.getWidth(), Enemy.getHeight());
							 */
						} else if (drawingObjects[i] instanceof Obstacle) {
							Obstacle drawingObstacle = (Obstacle) drawingObjects[i];
							g.setColor(Color.RED);

							g.drawImage(obstacle, drawingObstacle.getXAsInt()-57 + drawingObstacle.getWidth()/2, drawingObstacle.getYAsInt()-154+drawingObstacle.getHeight(), this);

							//g.fillRect( drawingObstacle.getXAsInt(), drawingObstacle.getYAsInt(), drawingObstacle.getWidth(),  drawingObstacle.getHeight());
						} else if (drawingObjects[i] instanceof Bullet) {
							Bullet drawingBullet = (Bullet) drawingObjects[i];
							//g.setColor(Color.RED);
							if (drawingBullet.getGunType() == 4){
								g.drawImage(rocket, drawingBullet.getXAsInt(), drawingBullet.getYAsInt(),this);/*****/
							}
							else if (drawingBullet.getGunType() == 5){
								g.drawImage(grenade, drawingBullet.getXAsInt(), drawingBullet.getYAsInt(),this);/*****/
							}
							else if (drawingBullet.getGunType() == 6){
								g.drawImage(stickyBullet, drawingBullet.getXAsInt(), drawingBullet.getYAsInt(),this);/*****/
							}
							else{
								g.drawImage(bullet, drawingBullet.getXAsInt(), drawingBullet.getYAsInt(),this);
							}
						}
						else if (drawingObjects[i] instanceof Turret){ /*****/
							Turret drawingTurret = (Turret) drawingObjects[i];
							int dir = 0;

							if (drawingTurret.getDirection() <= (5 * Math.PI) / 8
									&& drawingTurret.getDirection()>= (3 * Math.PI) / 8) {// right
								dir = 3;

							} else if (drawingTurret.getDirection() <= (7 * Math.PI) / 8
									&& drawingTurret.getDirection() >= (5 * Math.PI) / 8) { // down right
								dir = 4;

							} else if (drawingTurret.getDirection() <= (9 * Math.PI) / 8
									&& drawingTurret.getDirection() >= (7 * Math.PI) / 8) {// down
								dir = 1;

							} else if (drawingTurret.getDirection() <= (11 * Math.PI) / 8
									&& drawingTurret.getDirection() >= (9 * Math.PI) / 8) {// downleft
								dir = 5;

							} else if (drawingTurret.getDirection() <= (13 * Math.PI) / 8
									&& drawingTurret.getDirection()>= (11 * Math.PI) / 8) {// left
								dir = 2;

							}
							if (drawingTurret.getType() == 0){
								g.drawImage(turret[dir], (int) drawingTurret.getX() - Turret.SIZE/2, (int) drawingTurret.getY() - Turret.SIZE/2-20, this);
							}
							else if (drawingTurret.getType() == 1){
								g.drawImage(turret2[dir], (int) drawingTurret.getX() - Turret.SIZE/2, (int) drawingTurret.getY() - Turret.SIZE/2-20, this);
							}
							g.setFont(smallerFont);
							g.setColor(Color.WHITE);
							g.drawString(Integer.toString(drawingTurret.getAmmo()), (int) drawingTurret.getX() - 10 - 3*(Integer.toString(drawingTurret.getAmmo()).length() - 3), (int) drawingTurret.getY() - Turret.SIZE/2 - 5);
						}
					}

					// draw explosions
					for (int i = 0; i < explosions.size(); i ++){
						if (explosions.get(i).getType() == Explosion.RPG_EXPLOSION){
							/*g.setColor(Color.YELLOW);
							g.drawOval(explosions.get(i).getX() - Explosion.RADIUS_2, explosions.get(i).getY() - Explosion.RADIUS_2, Explosion.RADIUS_2*2, Explosion.RADIUS_2*2);
							g.setColor(Color.ORANGE);
							g.drawOval(explosions.get(i).getX() - Explosion.RADIUS, explosions.get(i).getY() - Explosion.RADIUS, Explosion.RADIUS*2, Explosion.RADIUS*2);
							g.setColor(Color.BLACK);
							g.fillOval(explosions.get(i).getX()-5, explosions.get(i).getY()-5, 10, 10);*/
							g.drawImage(explosion[explosions.get(i).getFrame(currentTime)], (int)(explosions.get(i).getX()- explosion[0].getWidth(this)/2), (int)(explosions.get(i).getY() - explosion[0].getWidth(this)/2), this);
						}
						else if (explosions.get(i).getType() == Explosion.GRENADE_EXPLOSION){	
							/*g.setColor(Color.GREEN);
							g.drawOval(explosions.get(i).getX() - Explosion.GRENADE_RADIUS_3, explosions.get(i).getY() - Explosion.GRENADE_RADIUS_3, Explosion.GRENADE_RADIUS_3*2, Explosion.GRENADE_RADIUS_3*2);
							g.setColor(Color.BLUE);
							g.drawOval(explosions.get(i).getX() - Explosion.GRENADE_RADIUS_2, explosions.get(i).getY() - Explosion.GRENADE_RADIUS_2, Explosion.GRENADE_RADIUS_2*2, Explosion.GRENADE_RADIUS_2*2);
							g.setColor(Color.LIGHT_GRAY);
							g.drawOval(explosions.get(i).getX() - Explosion.GRENADE_RADIUS, explosions.get(i).getY() - Explosion.GRENADE_RADIUS, Explosion.GRENADE_RADIUS*2, Explosion.GRENADE_RADIUS*2);
							g.setColor(Color.BLACK);
							g.fillOval(explosions.get(i).getX()-5, explosions.get(i).getY()-5, 10, 10);*/
							g.drawImage(fragOut[explosions.get(i).getFrame(currentTime)], (int)(explosions.get(i).getX()- fragOut[0].getWidth(this)/2), (int)(explosions.get(i).getY() - fragOut[0].getWidth(this)/2), this);
						}
						else if (explosions.get(i).getType() == Explosion.ENEMY_EXPLOSION){
							//g.setColor(Color.BLACK);
							//g.drawOval((int)explosions.get(i).getX()- Explosion.ENEMY_RADIUS, (int) (explosions.get(i).getY()-Explosion.ENEMY_RADIUS), Explosion.ENEMY_RADIUS*2, Explosion.ENEMY_RADIUS*2);
							g.drawImage(enemyExplosion[explosions.get(i).getFrame(currentTime)], (int)(explosions.get(i).getX()- enemyExplosion[0].getWidth(this)/2), (int)(explosions.get(i).getY() - enemyExplosion[0].getWidth(this)/2), this);
						}
					}

					// Graphics2D test= (Graphics2D)g;

					/*
					 * for (int i = 0 ; i < enemies.size (); i ++){ double [] coordinate
					 * = enemies.get(i).getEnemyPosition(); if
					 * (enemies.get(i).getEnemyPosition()[2] <= Math.PI/2) { // right
					 * and up direction g.setColor (Color.black); } else if
					 * (enemies.get(i).getEnemyPosition()[2] <= Math.PI) { // left and
					 * up direction g.setColor (Color.blue); } else if
					 * (enemies.get(i).getEnemyPosition()[2] <= (3*Math.PI)/2) { // left
					 * and down direction g.setColor (Color.green); } else if
					 * (enemies.get(i).getEnemyPosition()[2] <= 2*Math.PI) { // right
					 * and down direction g.setColor (Color.orange); }
					 * g.fillRect((int)coordinate[0] - Enemy.getWidth()/2,
					 * (int)coordinate [1] - Enemy.getHeight()/2, Enemy.getWidth(),
					 * Enemy.getHeight()); }
					 */

					if (multiplayer){
						g.setFont(this.smallFont);
						if (hosting){
							g.setColor(new Color(200, 200, 250));
						}
						else{
							g.setColor(new Color(200, 250, 200));
						}
						g.drawString(userProfile.getNickname(), player.getXAsInt() - 5, player.getYAsInt() - CHAR_SIZE + 10);

						if (hosting){
							g.setColor(new Color(200, 250, 200));
						}
						else{
							g.setColor(new Color(200, 200, 250));
						}
						g.drawString(networkProfile.getNickname(), networkPlayer.getXAsInt() - 5, networkPlayer.getYAsInt() - CHAR_SIZE + 10);
					}

					g.drawImage(crosshairOuter[crosshair.getOuterFrame(currentTime)], getMouseX() - crosshairOuter[0].getHeight(this)/2, getMouseY() - crosshairOuter[0].getHeight(this)/2, this);
					g.drawImage(crosshairInner[crosshair.getInnerFrame(currentTime)], getMouseX() - crosshairInner[0].getHeight(this)/2, getMouseY() - crosshairInner[0].getHeight(this)/2, this);

					g.drawImage(gameHud, 0, 0, this);
					g.setColor(Color.WHITE);
					g.setFont(onlineMenuFontSpec);
					g.drawString(Integer.toString(level), 70, 44);
					g.drawString(Integer.toString(currentScore), 200, 44);
					g.setColor(new Color(65, 105, 225));
					// health display
					if (multiplayer && !hosting){ 
						g.fillRect(334, 16,(int)(3.48 * networkPlayer.getHealth()),18);

					}
					else{
						g.fillRect(334, 16,(int)(3.48 * player.getHealth()),18);
					}
					if (player.getWeapon().getWeapon() != TURRET && player.getWeapon().getWeapon() != RPG_TURRET){
						g.drawImage (weapons[player.getWeapon().getWeapon()], 1016 - weapons[player.getWeapon().getWeapon()].getWidth(this) - 15,5,this);
					}
					else{
						g.drawImage (weapons[player.getWeapon().getWeapon()], 1016 - weapons[player.getWeapon().getWeapon()].getWidth(this) - 15,0,this);
					}
					g.setFont(onlineMenuFontSpec);
					g.setColor(Color.white);
					if(player.getWeapon().getWeapon() == MACHINE){
						g.drawString(Integer.toString(player.getWeapon().getAmmo()) + "/"+"200" , 1016 - weapons[player.getWeapon().getWeapon()].getWidth(this) - 180, 42);
					}
					else if(player.getWeapon().getWeapon() == PISTOL){
						g.drawImage((getImage(base, "boxhead/GameImages/sprites/weapons/i.png")) , 1016 - weapons[player.getWeapon().getWeapon()].getWidth(this) - 120, 0, this);
					}
					else if(player.getWeapon().getWeapon() == SHOTGUN || player.getWeapon().getWeapon() == GRENADE){
						g.drawString(Integer.toString(player.getWeapon().getAmmo()) + "/"+Integer.toString(Weapon.MAX_AMMO[player.getWeapon().getWeapon()]) , 1016 - weapons[player.getWeapon().getWeapon()].getWidth(this) - 120, 42);
					}
					else if(player.getWeapon().getWeapon() == TURRET || player.getWeapon().getWeapon() == RPG_TURRET){/*****/
						g.drawString(Integer.toString(player.getWeapon().getAmmo()), 1016 - weapons[player.getWeapon().getWeapon()].getWidth(this) - 50, 42);
					}
					else if (player.getWeapon().getWeapon() == SNIPER || player.getWeapon().getWeapon() == RPG){/*****/
						g.drawString(Integer.toString(player.getWeapon().getAmmo()) + "/"+Integer.toString(Weapon.MAX_AMMO[player.getWeapon().getWeapon()]) , 1016 - weapons[player.getWeapon().getWeapon()].getWidth(this) - 90, 42);
					}



					if (pauseSolo || pauseMulti) {
						g.drawImage(buttons[RETURN_TO_MENU]
						                    .getButtonImage(buttons[RETURN_TO_MENU].checkHover(
						                    		mouseMoveX, mouseMoveY)),
						                    		buttons[RETURN_TO_MENU].getX(),
						                    		buttons[RETURN_TO_MENU].getY(), this);
						// Draws the button effect if hovered over
						if (buttons[RETURN_TO_MENU].checkHover(mouseMoveX, mouseMoveY)) {
							g.drawImage(buttonEffect, buttons[RETURN_TO_MENU].getX(),
									buttons[RETURN_TO_MENU].getY(), this);
						}
					}

				}
				catch (NullPointerException e){
					e.printStackTrace();
					System.out.println ("Caught over here...");
				}
				catch (ConcurrentModificationException e){
					e.printStackTrace();
				}


			}
		}

	} // paint method

	double x1;
	double y1;
	double width = 250;
	double height = 50;
	double x1Speed;
	double y1Speed;
	int accell;
	boolean firstAnimation= true;
	boolean secondAnimation= false;
	boolean thirdAnimation = false;


	public void drawButtonNoHover (Graphics g, int buttonType){
		g.drawImage(buttons[buttonType].getButtonImage(false),buttons[buttonType].getX(), buttons[buttonType].getY(), this);	
	}


	public void drawButton (Graphics g, int buttonType){
		g.drawImage(buttons[buttonType].getButtonImage(buttons[buttonType].checkHover(mouseMoveX, mouseMoveY)),buttons[buttonType].getX(), buttons[buttonType].getY(), this);
		if (buttons[buttonType].checkHover(mouseMoveX, mouseMoveY)) {
			g.drawImage(buttonEffect, buttons[buttonType].getX(),buttons[buttonType].getY(), this);
		}

	}

	public boolean animationScreen=false;




	public void animateButtonToMenu(){


		if (firstAnimation){
			boolean animating = false;
			if (x1>0 && y1>0){
				accell++;
				y1-=y1Speed*accell*50;
				x1-=x1Speed*accell*50;
				animating = true;
			}
			else if (!animating && (x1!=0 || y1!=0)){
				x1=0;
				y1=0;
				accell=0;
				firstAnimation = false;
				secondAnimation = true;
			}
		}
		else if (secondAnimation){
			boolean animating = false;
			if (width < 1016){
				accell++;
				width+=accell*5;
				animating = true;
			}
			else if (!animating && (width != 1016)){
				width = 1016;
				accell=0;
				secondAnimation = false;
				thirdAnimation = true;
			}
		}
		else if (thirdAnimation){
			boolean animating = false;
			if (height < 662){
				accell++;
				height+=accell*5;
				animating = true;
			}
			else if (!animating && (height != 662)){
				height = 662;
				accell=0;
				thirdAnimation = false;
				animationScreen = false;


				buttons[RETURN_TO_MENU].setX(200+158);
				buttons[RETURN_TO_MENU].setY(175+200);
				buttons[JOIN].setX(90+158-5);
				buttons[JOIN].setY(105+200-5);
				buttons[HOST].setX(375+158-5);
				buttons[HOST].setY(105+200-5);
				nameTextField.setText("");


				if (signedIn) { // if logged in
					System.out.println("Signed in.");

					networkScreen = true;
				}
				else {
					System.out.println ("Multi clicked and not signed in.");

					if (userProfile.getNickname() == null){
						tempNickScreen = true;
						nameTextField.setBounds(260+258,35+281,200,25);
						add(nameTextField);
					}
					else {
						networkScreen = true;
					}
				}


			}
		}

	}


	ArrayList <ChatBox> chats = new ArrayList <ChatBox> ();

	long current;
	long stop;
	boolean liveNotification;
	Calendar cal;
	int liveY =662;
	String storeClicked = null;


	public void uploadToRHS (String dir){
		main.sendObject("upp");
		delay (10);
		try{
			InputStream in = new FileInputStream(new File (dir));

			//Basically copying byte to byte from the intial stream to the final stream
			byte[] buf = new byte[1024];//1mb transfer rate
			int len;
			limbo = true;
			repaint();
			while ((len = in.read(buf)) > 0){

				main.sendObject(true);
				delay(5);
				main.sendObject(buf);
				delay(5);
				main.sendObject(len);
				System.out.println ("Sending Profile Picture...");

			}
			System.out.println ("Profile picture has been sent.");
			limbo = false;
			main.sendObject(false);
			in.close();
		}
		catch (Exception e){

		}
	}


	@SuppressWarnings("deprecation")
	public void checkOptions() {
		if (mainMenu) {
			fbLimbo = false;
			limbo = false;
			// setting side note messages to nothing
			for (int i = 0; i < sideNote.length; i++) {
				sideNoteType[i] = false;
			}

			if (mousePressed && !allowScroll) {
				allowScroll = true;
			} else if (mousePressed && allowScroll) {
				mousePressed = false;
			}

			if (enter && !allowEnter) {
				allowEnter = true;
			} else if (enter && allowEnter) {
				enter = false;
			}

			if (esc && !allowEsc) {
				allowEsc = true;
			} else if (esc && allowEsc) {
				esc = false;
			}



			/*if (chat){

				if (enter){//When user has sent a message
					main.sendObject("sm");//Sending query to server that this user will send a message
					delay (10);//Wait on the second query that must go
					for (int i = 0 ; i < chats.size() ; i++){
						if (chats.get(i).setMessage ()){//Set message if there is something in the field
							main.sendObject(chats.get(i).getMessage());//Actually send the message object with the set parameters

							//Add whatever the user wrote to his own chat box
							chats.get(i).addText(chats.get(i).getMessage().getSender() + ": " + chats.get(i).getMessage().getMessage());

							//Set the test field back to blank
							chats.get(i).getSend().setText("");

						}
					}
				}
				else if (nt.isReceived()){//If the user receives a message

					System.out.println("Received mesage");
					Message m =  nt.getReceivedMessage();//Get the message from receiving thread

					if (m.getSender().equals("RoadhouseAdmin")){//If the user's friend had closed his chat box then this user needs to verified
						for (int i = 0 ; i < chats.size();i++){
							if (m.getMessage().equals(chats.get(i).getFriend())){
								chats.get(i).addText(chats.get(i).getFriend() + " has left the convo.");
								break;
							}
						}
					}


					if (chats.size() == 0){//If it is the first message received
						chats.add(new ChatBox(m.getRecipient(), m.getSender(), this));//add a new chatbox with credentials received
						//Adding GUI components
						add(chats.get(chats.size()-1).getConvo());
						add(chats.get(chats.size()-1).getSend());
						//Add the message that was sent to the chat box
						chats.get(chats.size()-1).addText(m.getSender() + ": " + m.getMessage());
					}
					else{//Otherwise later messages
						for (int i = 0 ; i < chats.size(); i++){

							if (m.getSender().equals(chats.get(i).getFriend())){
								chats.get(i).addText(m.getSender() + ": " + m.getMessage());
								break;
							}
							else if (i == chats.size()-1){
								if (!m.getSender().equals("RoadhouseAdmin")){
									chats.add(new ChatBox(m.getRecipient(), m.getSender(), this));

									//Adding GUI components
									add(chats.get(chats.size()-1).getConvo());
									add(chats.get(chats.size()-1).getSend());

									chats.get(chats.size()-1).addText(m.getSender() + ": " + m.getMessage());
									break;
								}
							}
						}
					}
					m = null;
					nt.setReceived(false);

				}
				//Moving GUI around
				for (int i = 0; i < chats.size() ; i++){
					if (chats.get(i).isClicked() && dragging){
						chats.get(i).setBox(mouseDragX-(chats.get(i).getXprev()), mouseDragY-(chats.get(i).getYprev()));
						break;
					}
					else if (chats.get(i).isMaximized()){
						System.out.println ("max");
						if (!chats.get(i).isOffScreen()){
							if(chats.get(i).getX()>=-250 && chats.get(i).getY()>=0){
								chats.get(i).animateMin();
							}
							else if(chats.get(i).getX()<0 && chats.get(i).getY()<= 0){
								chats.get(i).setOffScreen(true);
								chats.get(i).setMaximized(false);
								chats.get(i).setX(-250);
								chats.get(i).setY(0);
							}
						}
						else if (chats.get(i).isOffScreen()){
							System.out.println ("on");

							chats.get(i).animateMax();
							if (!(chats.get(i).getX()<20 && chats.get(i).getY()<1)){
								chats.get(i).setOffScreen(false);
								chats.get(i).setMaximized(false);
							}
						}
						break;
					}
					else if (chats.get(i).isClose()){

						Message m = new Message ("RoadhouseAdmin", chats.get(i).getFriend());
						m.setMessage(userProfile.getName());
						main.sendObject("sm");
						delay (10);
						main.sendObject(m);
						remove(chats.get(i).getConvo());
						remove(chats.get(i).getSend());
						chats.remove(i);
						break;
					}
				}


			}
			else if (nt.isReceived()){
				chat = true;
			}*/
			if (nt.isLiveMessage()){

				liveNotification = true;
				cal = Calendar.getInstance();
				stop =cal.getTimeInMillis()+ 10000;
				liveY = 662;
				System.out.println ("not print");
				nt.setLiveMessage(false);
			}
			if (liveNotification){
				cal = Calendar.getInstance();

				current =cal.getTimeInMillis();
				if (current >= stop){
					liveNotification = false;
				}

				if (liveY > 512){
					liveY-=2;
				}
				else {
					liveY =512;
				}


			}

			if (popUpMessageScreen) {
				if (buttons[OK].isClicked()) {
					popUpMessageScreen = false;

				}
			}



			// If the user is using the search profile screen
			else if (searchProfileScreen) {



				// if the screen has not been set, the following happens
				if (!setScreen) {
					currentlyClicked = -1; // Resets the click
					setScreen = true;
					nameTextField.setBounds(405, 185, 200, 25); // //////////////////////
					nameTextField.setText("");
					// change
					add(nameTextField);
				}
				// If something is typed in
				if (nameTextField.getText().length() > 0 && checker != nameTextField.getText().length()) {
					// Display the profiles with the typed in info
					searchResults.setList(userProfile.searchProfile(nameTextField.getText(), searchableProfiles, friends));
					searchResultsReturn = searchResults.getList(6);
				}
				// if nothing typed in, no search results should come up
				else if (nameTextField.getText().length() == 0) {
					searchResultsReturn = null;
				}
				checker = nameTextField.getText().length();

				// If the up or down button is clicked int he scroll screen
				for (int i = SEARCH_UP; i <= SEARCH_DOWN; i++) {
					if (scrollButtons[i].isClicked(allowScroll)) {
						// Scrolls the user names up and down
						searchResults.moveScrollBar(scrollButtons[i].getDirection());
						searchResultsReturn = searchResults.getList(6);
						i = SEARCH_DOWN;
					}
				}
				// Checks to see if the mouse is clicked
				if (searchResults.whereClicked() != -1) {
					currentlyClicked = searchResults.whereClicked();
				}

				// If the user chooses to add the user, do the following
				if (buttons[ADD].isClicked() || enter) {
					// If actually clicked down
					if (currentlyClicked != -1) {
						boolean allow = true;


						if (allow) {
							String temp = searchResultsReturn[currentlyClicked];

							main.sendObject("si");
							delay(10);
							main.sendObject(temp);

							currentlyClicked = -1;


						}
					} else {

						popUpMessageScreen = true;
						popUpMessage.setMessage(6); // message saying select a
						// profile
					}
				}
				// If the user chooses to return to menu, do as such
				else if (buttons[RETURN_TO_MENU2].isClicked() || esc) {
					searchProfileScreen = false;
					remove(nameTextField);
					setScreen = false;
				}
			} // If the user uses the clan edit screen
			// If a user has added another user as a friend or clan invite, the
			// second user will get the invitation screen
			else if (profileInvitationScreen) {

				// If the user clicks to accepts the invitation
				if (buttons[ACCEPT].isClicked()) {
					// Adds the user if the user is using the addfriend feature
					if (addFriend) {
						main.sendObject("rp");
						delay(10);
						main.sendObject(invites.get(0));
						delay(10);
						invites.remove(0);

						main.sendObject("gf");
						delay(10);
						nullPointer =true;
						while (nullPointer){
							System.out.println ("checking friends");

							if (nt.getFriends() != null){
								friends = nt.getFriends();
								nullPointer = false;
							}
						}
					} 
					// eitherway
				}
				// If the user clicks to not accept friend
				else if (buttons[DECLINE].isClicked()) {
					// Removes the invitations
					if (addFriend) {
						main.sendObject("di");
						delay(10);
						main.sendObject(invites.get(0));
						invites.remove(0);
					} 
				}
				// Leaves invitation screen
				if (addFriend) {
					if (invites.size()  == 0) {
						profileInvitationScreen = false;
					}
				} 

			}


			// If the user is in the friends screen
			else if (friendsScreen) {
				// If the screen was not previously set, reset all the variables
				// for use

				if (sendMessage){
					if (enter){
						if (sendMessageField.getText().length() > 0 ){
							main.sendObject("sm");
							delay (10);
							Message m = new Message (userProfile.getNickname(), storeClicked);
							m.setMessage(sendMessageField.getText());
							main.sendObject(m);
							sendMessageField.setText("");
							remove(sendMessageField);
							sendMessage = false;
						}
						else if (sendMessageField.getText().length() == 0 ){
							sendMessageField.setText("");
							remove(sendMessageField);
							sendMessage = false;
							System.out.println ("no message was sent");
						}
					}
				}

				if (!setScreen) {
					buttons[ADD_FRIEND].setX(660 - 5);
					buttons[ADD_FRIEND].setY(270 - 5);
					buttons[REMOVE_FRIEND].setX(660 - 5);
					buttons[REMOVE_FRIEND].setY(440 - 5);
					buttons[RETURN_TO_MENU].setX(730 - 5);
					buttons[RETURN_TO_MENU].setY(585 - 5);
					buttons[SEND].setX(660 - 5);
					buttons[SEND].setY(355 - 5);
					buttons[INBOX].setX(660 - 5);
					buttons[INBOX].setY(185 - 5);
					currentlyClicked = -1;
					setScreen = true;
					friendList.setList(friends);
					friendScroll.setList(friendList);
					friendListReturn = friendList.getList(5);



				}

				//System.out.println (friendScroll.getList().getArrayList().get(2));

				friendScroll.setList(friendList);
				friendListReturn = friendList.getList(5);



				// Checks of the buttons was clicked
				if (friendList.whereClicked() != -1) {
					currentlyClicked = friendList.whereClicked();
				}

				if (currentlyClicked != -1){
					if (buttons[SEND].isClicked()) {

						/*boolean exists = false;
						for (int i = 0 ; i < chats.size(); i++){
							if (friendListReturn[currentlyClicked].equals(chats.get(i).getFriend())){
								exists = true;
								break;
							}
						}
						if (!exists){
							main.sendObject("cf");
							delay(10);
							main.sendObject(friendListReturn[currentlyClicked]);
							if (nt.isFriendOnline()){

								chat = true;
								System.out.println ("friend is online and okay to chat...");
								chats.add(new ChatBox(userProfile.getName(), friendListReturn[currentlyClicked], this));

								add(chats.get(chats.size()-1).getConvo());
								add(chats.get(chats.size()-1).getSend());

								nt.setFriendOnline(false);
							}
							else */if (!sendMessage) {
								System.out.println ("friend is offline...");
								sendMessage = true;
								sendMessageField.setBounds(655,350, 250, 50);
								add(sendMessageField);
								storeClicked = friendListReturn[currentlyClicked];
							}
							//-}


					}
				}
				// If add friend is clicked after a person is selected, make
				// option for adding friend true
				if (buttons[ADD_FRIEND].isClicked()) {
					searchProfileScreen = true;
					addFriend = true;
					setScreen = false;
					main.sendObject("search");

					boolean nullPointerException =true;
					while (nullPointerException){
						System.out.println ("while");

						if (nt.getSearchableProfiles() != null){
							searchableProfiles = nt.getSearchableProfiles();
							nullPointerException = false;
						}
					}


				}
				// If remove friend is clicked after a person is selected
				if (currentlyClicked != -1){
					if (buttons[REMOVE_FRIEND].isClicked()) {

						// If a user had been selected
						if (currentlyClicked != -1) {
							// Removes friend from list
							main.sendObject("rf");
							delay(10);
							main.sendObject(friendListReturn[currentlyClicked]);
							delay(10);
						} else {
							popUpMessageScreen = true;
							popUpMessage.setMessage(6);// select profile message
						} 
						nt.setFriends(null);
						main.sendObject("gf");
						delay(10);

						nullPointer = true;
						while (nullPointer){
							System.out.println ("checking invites");

							if (nt.getFriends() != null){
								invites = nt.getFriends();
								nullPointer = false;
							}
						}
					}
				}
				// If the return to menu button pressed, turn the current screen
				// off
				if (buttons[RETURN_TO_MENU].isClicked() || esc) {
					friendsScreen = false;
					remove(sendMessageField);
					sendMessage = false;
				}

				if (buttons[INBOX].isClicked()){
					main.sendObject("ci");
					delay(10);
					nullPointer =true;
					while (nullPointer){
						System.out.println ("checking invites");
						if (nt.getInvites() != null){
							invites= nt.getInvites();


							nullPointer = false;


							if(invites.size() != 0){
								profileInvitationScreen = true;
								addFriend = true;
							}
							repaint();
						}
					}

					if(invites.size() == 0){

						popUpMessageScreen = true;
						popUpMessage.setMessage(19);
					}
				}
				if (profilePic.isClicked()){
					//int returnFileVal = fc.showOpenDialog(MainApplet.this); // open screen to select file

					/*if (returnFileVal == JFileChooser.APPROVE_OPTION){ // accept

						File tempFile = fc.getSelectedFile(); // get file
						if (tempFile.exists()){
							uploadToRHS (tempFile.getAbsolutePath());
							tempFile = null;
							pp.flush();
							pp = null;
							delay(1000);
							try {
								pp=getImage (new URL ("http://sameid.dyndns-web.com/"),replaceSpace(userProfile.getNickname()) +".png");
							} catch (MalformedURLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					else if (returnFileVal == JFileChooser.CANCEL_OPTION){ // cancel

					}*/




				}


			}
			// If the current screen is the league screen
			else if (networkScreen){
				if (buttons[JOIN].isClicked()){

					network = new NetworkThread ();
					network.setRunning(false);
					network.setHosting(false);

					bt = new BroadcastThread ();
					bt.setRunning(true);
					bt.setHosting(false);
					bt.start();



					joinGameScreen = true;
					networkScreen = false;
					nameTextField.setBounds(326, 308, 200, 25);
					buttons[JOIN].setX(40+58-5);
					buttons[JOIN].setY(435+81-5);

					buttons[REFRESH].setX(330+58-5);
					buttons[REFRESH].setY(435+81-5);
					buttons[RETURN_TO_MENU].setX(620+58-5);
					buttons[RETURN_TO_MENU].setY(435+81-5);

					gameList.setList(bt.getSb().getList());
					//gameList.setList(temp);
					gameScroll.setList(gameList);
					gameListReturn = gameList.getList(8);


				}
				else if (buttons[HOST].isClicked()){



					network = new NetworkThread();
					network.setRunning(true);
					network.setHosting(true);
					network.start();

					bt = new BroadcastThread ();
					bt.getSb().setMessage(userProfile.getNickname()+" - " +network.getServer().getLocalIp());
					bt.setRunning(true);
					bt.setHosting(true);
					bt.start();

					hostGameScreen = true;
					networkScreen = false;

					buttons[RETURN_TO_MENU].setX(415+158-5);
					buttons[RETURN_TO_MENU].setY(150+175-5);

					hosting = true;

					level = 0; // starting level
					newLevel = true; // let level instantiate

					enemies = new ArrayList <Enemy> ();
					obstacles = new ArrayList <Obstacle>();
					itemDrops = new ArrayList <Item>();
					explosions = new ArrayList<Explosion> ();
					player.setHealth(100);
					player.setWeapon(new Weapon(NUM_WEAPON_TYPES));
					player.getWeapon().setBullets(new ArrayList <Bullet> ());
					player.getWeapon().setTurrets(new ArrayList<Turret>());
					player.setX(SCREEN_WIDTH/3);
					player.setY(SCREEN_HEIGHT/2);;


					Random random = new Random();
					for (int i = 0; i < random.nextInt(8) + 5; i++) {
						obstacles.add(new Obstacle());
					}
					sPack = new ServerPacket ();
					sPack.setObstacles(obstacles);
					sPack.setCharacter(player);
					sPack.setEnemies(enemies);
					sPack.setItemsTouched(new ArrayList <Item> ());
					sPack.setAllItems(itemDrops);
					sPack.setProfile(userProfile);


				}
				else if (buttons[RETURN_TO_MENU].isClicked()){
					networkScreen = false;
				}
			}
			else if (joinGameScreen){
				gameScroll.setList(gameList);
				gameListReturn = gameList.getList(8);

				// Checks of the buttons was clicked
				if (gameList.whereClicked() != -1) {
					currentlyClicked = gameList.whereClicked();
				}

				if (buttons[JOIN].isClicked() || enter){

					if (currentlyClicked != -1){

						network = new NetworkThread ();
						network.setRunning(true);
						network.setHosting(false);
						network.start();

						hosting = false;

						explosions = new ArrayList <Explosion> (); /*****/
						player.setWeapon(new Weapon(NUM_WEAPON_TYPES));
						player.getWeapon().setBullets(new ArrayList <Bullet> ());
						player.getWeapon().setTurrets(new ArrayList<Turret>());/*****/
						player.setX((2*SCREEN_WIDTH)/3);
						player.setY(SCREEN_HEIGHT/2);


						cPack = new ClientPacket ();
						cPack.setProfile(userProfile);
						cPack.setCharacter(player);

						String ipquick = gameListReturn[currentlyClicked].substring (gameListReturn[currentlyClicked].indexOf('-')+2, gameListReturn[currentlyClicked].length());
						System.out.println (ipquick);
						network.getClient().setIp(ipquick);			



						limbo = true;
						repaint();

						System.out.println ("FREEZE");


						if (network.getClient().connect()){

							System.out.println ("CHECKING");
							networkConnectedScreen = true;
							joinGameScreen = false;
							bt.setRunning(false);
							bt.setExit(true);
							bt.getSb().getMultiSocket().close();
							bt = null;
						}
						else {

							System.out.println ("Could not connect to server. (In Join Screen)");
							popUpMessageScreen = true;
							popUpMessage.setMessage(12);
							network.setRunning(false);
							network.setExit(true);
							network = null;

						}
						System.out.println ("REACHED!!");
					}
					else{
						popUpMessageScreen = true;
						popUpMessage.setMessage(18);
					}

				}
				else if (buttons[REFRESH].isClicked()){
					bt.getSb().refresh();
					gameList.setList(null);
					gameList.setList(bt.getSb().getList());
					currentlyClicked = -1;
				}
				else if (buttons[RETURN_TO_MENU].isClicked() || esc){
					joinGameScreen = false;
					bt.setRunning(false);
					bt.setExit(true);
					bt.getSb().getMultiSocket().close();
					bt = null;

					network.setRunning(false);
					network.setHosting(false);
					network.setExit(true);
					network = null;
				}

			}
			else if (hostGameScreen){
				//Start the server (Basically checking to see if it will listen on the port specified

				if (buttons[RETURN_TO_MENU].isClicked() || esc){
					hostGameScreen = false;
					hosting = false;

					network.setHosting(false);
					network.setRunning(false);
					network.setExit(true);
					try {
						network.getServer().getServerSocket().close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					network = null;

					bt.setRunning(false);
					bt.setExit(true);
					bt = null;
				}

				if ((network != null) && network.getServer().isConnected()){
					System.out.println ("Reached Client Connection");
					hostGameScreen = false;
					networkConnectedScreen = true;

					bt.setRunning(false);
					bt.setExit(true);
					bt = null;
				}

			}
			else if (networkConnectedScreen){
				try{
					if (hosting){
						sPack.setProfile(userProfile);
						network.getServer().sendObject(sPack);
						cPack = ((ClientPacket) network.receive());
						networkProfile = cPack.getProfile();	
						networkPlayer = cPack.getCharacter();
						if (networkProfile != null){

							iterationCount = -1;
						}

					}
					else {
						cPack.setProfile(userProfile);
						network.getClient().sendObject(cPack);
						sPack =((ServerPacket) network.receive());
						networkProfile = sPack.getProfile();	
						networkPlayer = sPack.getCharacter();

						if (networkProfile != null){	

							iterationCount = -1;
						}
					}
				}
				catch(NullPointerException e){
					e.printStackTrace();
				}
				catch (ConcurrentModificationException e){
					e.printStackTrace();
				}

				delay (2000);

				if (iterationCount == -1){

					stopMusic();
					playMusic("firefight.mp3");

					game = true;

					mainMenu = false;
					multiplayer = true;
					iterationCount = 0;
					timeLastSpawn = 0;
					currentTime = Integer.parseInt(sdf2.format(Calendar.getInstance().getTime()));
					startTime = Integer.parseInt(sdf2.format(Calendar.getInstance().getTime()));
					currentScore = 0;
				}

			}
			else if (optionScreen) { // implemented later during creating game
				// phase
				if (buttons [RETURN_TO_MENU].isClicked()){
					optionScreen = false;
				}
			}
			else if(nickNameScreen){
				if (enter && nameTextField.getText().length() > 8 && nameTextField.getText().length() <= 20 ){

					main.sendObject(nameTextField.getText());
					delay (10);
					userProfile = (Profile)main.receiveObject();

					signedIn = true;
					remove(nameTextField);
					nickNameScreen = false;

					buttons[START_SOLO].setY(345);
					buttons[ONLINE].setY(345);
					buttons[OPTIONS].setY(345);

					nt.setRunning(true);
					nt.setReceive(main.getInputStream());

					pp = null;
					delay(1000);
					try {
						pp=getImage (new URL ("http://99.230.201.32/"),replaceSpace(userProfile.getNickname()) +".png");
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if (enter) {
					popUpMessageScreen = true;
					popUpMessage.setMessage(17);
				}
			}
			else if (tempNickScreen){
				if (enter && nameTextField.getText().length() >= 6 && nameTextField.getText().length() <= 20  && !Utils.hasOnlySpace(nameTextField.getText())){
					userProfile.setNickname(nameTextField.getText());
					remove(nameTextField);
					tempNickScreen = false;
					networkScreen = true;
				}
				else if (enter) {
					popUpMessageScreen = true;
					popUpMessage.setMessage(17);
				}
			}
			else if (gameOverScreen){
				if(buttons[RETURN_TO_MENU].isClicked()){
					gameOverScreen = false;

				}
				else if (buttons[POSTFB].isClicked()){
					System.out.println ("Post has been clicked");
					if (main.isConnected()){
						fb.postEndGameResults(Integer.toString(currentScore), Integer.toString(level));
						gameOverScreen = false;
					}
					else{
						popUpMessageScreen = true;
						popUpMessage.setMessage(15);
					}
				}
			}
			else { // if not in secondary screens, buttons in main menu can be
				// affected
				if (buttons[START_SOLO].isClicked()) {


					multiplayer = false;
					mainMenu = false;
					game = true; // start game
					level = 0; // starting level
					newLevel = true; // let level instantiate
					hosting = true; // calculation done on this machine
					currentScore = 0;
					enemies = new ArrayList <Enemy> ();
					obstacles = new ArrayList <Obstacle>();
					itemDrops = new ArrayList <Item>();
					explosions = new ArrayList <Explosion> (); /*****/
					player.setHealth(100);
					player.setWeapon(new Weapon(NUM_WEAPON_TYPES));
					player.getWeapon().setBullets(new ArrayList <Bullet> ());
					player.getWeapon().setTurrets(new ArrayList<Turret>());/*****/
					player.setX(SCREEN_WIDTH/2);
					player.setY(SCREEN_HEIGHT/2);;

					Random random = new Random();
					for (int i = 0; i < random.nextInt(8) + 5; i++) {
						obstacles.add(new Obstacle());
					}


					stopMusic();
					playMusic("firefight.mp3");


				} else if (buttons[ONLINE].isClicked()) {
					x1=buttons[ONLINE].getX();
					y1=buttons[ONLINE].getY();

					x1Speed =Math.cos(Math.atan(y1/x1))/20;
					y1Speed =Math.sin(Math.atan(y1/x1))/20;
					animationScreen = true;
					width = 250;
					height=50;
					firstAnimation = true;
					secondAnimation = false;
					thirdAnimation = false;


				}

				else if (buttons[OPTIONS].isClicked()) {
					System.out.println("option clicked");
					optionScreen = true;
					buttons[RETURN_TO_MENU].setX(108+525-5);
					buttons[RETURN_TO_MENU].setY(30+525-5);

				}
				else if (buttons[SIGN_UP].isClicked()){
					System.out.println ("Opening Sign Up window!");
					AppletContext a = getAppletContext();
					URL url = null;
					try {
						url = new URL 
						(REQUEST_TOKEN);
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					a.showDocument(url, "_parent");
				}

				if (signedIn) { // if logged in (make the 2 new options)
					if (buttons[FRIENDS].isClicked()) {

						limbo = true;
						repaint();

						System.out.println ("Connected to Freeway!");

						main.sendObject("gf");
						delay(10);
						nullPointer =true;
						while (nullPointer){

							if (nt.getFriends() != null){
								friends = nt.getFriends();
								nullPointer = false;
							}
						}



						ArrayList <String> temp = fb.getUserFriendsList();

						System.out.println (temp.size());

						main.sendObject("el");
						delay(10);
						String[] users = null;
						nullPointer =true;
						while (nullPointer){

							if (nt.getAllUsers() != null){
								users = nt.getAllUsers();
								nullPointer = false;
							}
						}

						for (int i = 0;i<temp.size();i++){
							boolean existsInFriends = false;
							boolean existsInFbandList = false;
							for (int j =0; j <users.length ; j++){
								if (temp.get(i).equals(users[j])){
									existsInFbandList = true;
									for (int k = 0; k < friends.size();k++){

										if (temp.get(i).equals(friends.get(k))){
											existsInFriends=true;
											break;
										}
									}
									break;
								}
							}

							if (!existsInFriends && existsInFbandList){
								main.sendObject("UF");
								delay(10);
								main.sendObject(temp.get(i));

								System.out.println (temp.get(i)+" has been added to current user friend list.");
							}

						}


						friendsScreen = true;
						setScreen = false;

					}



				} 
			}
		}
	}

	public void signOut (){
		main.sendObject("nfof");
		delay(10);
		userProfile.setOnline(false);
		main.sendObject(SAVE_INFO);
		delay (10);
		main.sendObject(userProfile);
		userProfile = null;

		signedIn = false; //
		chat = false;
		if (main.isConnected()){
			main.sendObject("d");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			main.disconnect();
			System.out.println ("reached.");
			friends = null;
			invites = null;
			searchableProfiles = null;
			nt.setRunning(false);
			nt.setSearchableProfiles(null);
			nt.setInvites(null);
			nt.setFriends(null);
		}
	}

	public boolean checkInternetConnection (){
		InetAddress check = null;
		try {
			check =  InetAddress.getByName("www.google.ca");
			System.out.println (check.getHostAddress());
			return true;

		} 
		catch (UnknownHostException e)
		{

			System.out.println ("Check internet connection.");
			return false;
		}
		catch (NullPointerException e){

			System.out.println ("No internet connection.");
			return false;
		}

	}

	public boolean[] collisionDetection(Object movingObject,
			Object stationaryObject) {
		boolean[] temp = {false, false}; // first value if collided, second if collide from bottom/top
		// moving objects
		Enemy enemy1 = null;
		Character character1 = null;
		Bullet bullet = null;
		// stationary objects
		Enemy enemy2 = null;
		Character character2 = null;
		Obstacle obstacle = null;
		Item item = null;
		Turret turret = null;/*****/

		double comparedX = 0, comparedY = 0;
		double currentMoveX = 0, currentMoveY = 0, currentX = 0, currentY = 0, currentDirection = 0;
		int currentWidth = 0, currentHeight = 0, comparedWidth = 0, comparedHeight = 0;

		if (movingObject instanceof Enemy) {
			enemy1 = (Enemy) movingObject;
			currentX = enemy1.getEnemyPosition()[0];
			currentY = enemy1.getEnemyPosition()[1];
			currentDirection = enemy1.getEnemyPosition()[2];
			currentMoveX = enemy1.getMoveX();
			currentMoveY = enemy1.getMoveY();
			currentWidth = enemy1.getWidth();
			currentHeight = enemy1.getHeight();
		} else if (movingObject instanceof Character) {
			character1 = (Character) movingObject;
			currentX = character1.getX();
			currentY = character1.getY();
			currentMoveX = character1.getSpeedX();
			currentMoveY = character1.getSpeedY();
			currentWidth = CHAR_SIZE;
			currentHeight = CHAR_SIZE;

			if (Math.toRadians(character1.getDirection()) <= Math.PI) {
				currentDirection = (3 * Math.PI) / 2
				- Math.toRadians(character1.getDirection());
			} else if (Math.toRadians(character1.getDirection()) < (3 * Math.PI) / 2) {
				currentDirection = Math.toRadians(character1.getDirection()) - Math.PI;
			} else {
				currentDirection = 2 * Math.PI
				- (Math.toRadians(character1.getDirection()) - (3 * Math.PI) / 2);
			}
			if (Math.toRadians(character1.getDirection()) >= 2 * Math.PI) {
				currentDirection = character1.getDirection() - 2 * Math.PI;
			}

		}
		else if (movingObject instanceof Bullet) {
			bullet = (Bullet) movingObject;
			currentX = bullet.getX();
			currentY = bullet.getY();
			// direction conversion from joystick
			if (bullet.getDirection() <= Math.PI) {
				currentDirection = (3 * Math.PI) / 2 - bullet.getDirection();
			} else if (bullet.getDirection() < (3 * Math.PI) / 2) {
				currentDirection = bullet.getDirection() - Math.PI;
			} else {
				currentDirection = 2 * Math.PI
				- (bullet.getDirection() - (3 * Math.PI) / 2);
			}
			if (bullet.getDirection() >= 2 * Math.PI) {
				currentDirection = bullet.getDirection() - 2 * Math.PI;
			}
			currentMoveX = 0;
			currentMoveY = 0;
			currentWidth = bullet.getSize();
			currentHeight = bullet.getSize();
		}

		if (stationaryObject instanceof Enemy) {
			enemy2 = (Enemy) stationaryObject;
			comparedX = enemy2.getEnemyPosition()[0];
			comparedY = enemy2.getEnemyPosition()[1];
			comparedWidth = enemy2.getWidth();
			comparedHeight = enemy2.getHeight();
		} else if (stationaryObject instanceof Character) {
			character2 = (Character) stationaryObject;
			comparedX = character2.getX();
			comparedY = character2.getY();
			comparedWidth = CHAR_SIZE;
			comparedHeight = CHAR_SIZE;
		} else if (stationaryObject instanceof Obstacle) {
			obstacle = (Obstacle) stationaryObject;
			comparedX = obstacle.getX();
			comparedY = obstacle.getY();
			comparedWidth = obstacle.getWidth();
			comparedHeight = obstacle.getHeight();
		} else if (stationaryObject instanceof Item) {
			item = (Item) stationaryObject;
			comparedX = item.getItemPosition()[0];
			comparedY = item.getItemPosition()[1];
			comparedWidth = Item.ITEM_SIZE;
			comparedHeight = Item.ITEM_SIZE;
		}/*****/
		else if (stationaryObject instanceof Turret){
			turret = (Turret) stationaryObject;
			comparedX = turret.getX();
			comparedY = turret.getY();
			comparedWidth = Turret.SIZE;
			comparedHeight = Turret.SIZE;
		}

		int scenario = 0;
		boolean allow = false;
		double difference = 0;

		if (comparedX >= currentX && comparedY <= currentY) { // compared enemy is right and above of current enemy
			if (currentDirection <= Math.PI) { // right and down direction
				// towards origin
				if (currentX + currentWidth / 2 + currentMoveX >= comparedX - comparedWidth / 2) { // right side of current enemy intersects the left of compared enemy
					if (currentY - currentHeight / 2 - currentMoveY <= comparedY + comparedHeight / 2) {// top of current enemy
						// intersects the bottom of
						// compared enemy
						allow = true;
						scenario = 1;
						difference = (comparedX - comparedWidth / 2) - (currentX + currentWidth / 2);
					}
				}
			} else if (currentDirection <= (3 * Math.PI) / 2) { // right and up direction towards origin
				if (currentX + currentWidth / 2 + currentMoveX >= comparedX - comparedWidth / 2) { // right side of current enemy intersects the left of compared enemy
					if (currentY - currentHeight / 2 - currentMoveY <= comparedY + comparedHeight / 2) {// top of current enemy intersects the bottom of compared enemy
						allow = true;
						if ((currentX + currentWidth / 2 + currentMoveX) - (comparedX - comparedWidth / 2) > (comparedY + comparedHeight / 2) - (currentY - currentHeight / 2 - currentMoveY)) {
							scenario = 2;
							difference = (currentY - currentHeight / 2)
							- (comparedY + comparedHeight / 2);
						} else {
							scenario = 1;
							difference = (comparedX - comparedWidth / 2)
							- (currentX + currentWidth / 2);
						}
					}
				}
			} else if (currentDirection <= 2 * Math.PI) { // left and up
				// direction towards
				// origin
				if (currentX + currentWidth / 2 + currentMoveX >= comparedX
						- comparedWidth / 2) { // right side of current enemy
					// intersects the left of
					// compared enemy
					if (currentY - currentHeight / 2 - currentMoveY <= comparedY
							+ comparedHeight / 2) {// top of current enemy
						// intersects the bottom of
						// compared enemy
						allow = true;
						scenario = 2;
						difference = (currentY - currentHeight / 2)
						- (comparedY + comparedHeight / 2);
					}
				}
			}
		} else if (comparedX < currentX && comparedY > currentY) { // compared
			// enemy is
			// left and
			// below of
			// current
			// enemy
			if (currentDirection <= Math.PI / 2) { // left and down direction
				// towards origin
				if (currentX - currentWidth / 2 + currentMoveX <= comparedX
						+ comparedWidth / 2) {
					if (currentY + currentHeight / 2 - currentMoveY >= comparedY
							- comparedHeight / 2) {
						// bottom left corner of current enemy and top right
						// corner of compared enemy intersect
						allow = true;
						if ((comparedX + comparedWidth / 2)
								- (currentX - currentWidth / 2 + currentMoveX) > (currentY
										+ currentHeight / 2 - currentMoveY)
										- (comparedY - comparedHeight / 2)) {
							scenario = 2;
							difference = (currentY + currentHeight / 2)
							- (comparedY - comparedHeight / 2);
						} else {
							scenario = 1;
							difference = (comparedX + comparedWidth / 2)
							- (currentX - currentWidth / 2);
						}
					}
				}
			} else if (currentDirection <= Math.PI) { // right and down
				// direction towards
				// origin
				if (currentX - currentWidth / 2 + currentMoveX <= comparedX
						+ comparedWidth / 2) {
					if (currentY + currentHeight / 2 - currentMoveY >= comparedY
							- comparedHeight / 2) {
						// bottom left corner of current enemy and top right
						// corner of compared enemy intersect
						allow = true;
						scenario = 2;
						difference = (currentY + currentHeight / 2)
						- (comparedY - comparedHeight / 2);
					}
				}
			} else if (currentDirection <= 2 * Math.PI) { // left and up
				// direction towards
				// origin
				if (currentX - currentWidth / 2 + currentMoveX <= comparedX
						+ comparedWidth / 2) {
					if (currentY + currentHeight / 2 - currentMoveY >= comparedY
							- comparedHeight / 2) {
						// bottom left corner of current enemy and top right
						// corner of compared enemy intersect
						allow = true;
						scenario = 1;
						difference = (comparedX + comparedWidth / 2)
						- (currentX - currentWidth / 2);
					}
				}
			}
		} else if (comparedX < currentX && comparedY < currentY) { // compared
			// enemy is
			// left and
			// above
			if (currentDirection <= Math.PI / 2) { // left and down direction
				// towards origin
				if (currentX - currentWidth / 2 + currentMoveX <= comparedX
						+ comparedWidth / 2) {
					if (currentY - currentHeight / 2 - currentMoveY <= comparedY
							+ comparedHeight / 2) {
						allow = true;
						scenario = 1;
						difference = (comparedX + comparedWidth / 2)
						- (currentX - currentWidth / 2);
					}
				}
			} else if (currentDirection <= (3 * Math.PI) / 2) { // right and up
				// direction
				// towards
				// origin
				if (currentX - currentWidth / 2 + currentMoveX <= comparedX
						+ comparedWidth / 2) {
					if (currentY - currentHeight / 2 - currentMoveY <= comparedY
							+ comparedHeight / 2) {
						allow = true;
						scenario = 2;
						difference = (currentY - currentHeight / 2)
						- (comparedY + comparedHeight / 2);
					}
				}
			} else if (currentDirection <= 2 * Math.PI) { // left and up
				// direction towards
				// origin
				if (currentX - currentWidth / 2 + currentMoveX <= comparedX
						+ comparedWidth / 2) {
					if (currentY - currentHeight / 2 - currentMoveY <= comparedY
							+ comparedHeight / 2) {
						allow = true;
						if ((comparedX + comparedWidth / 2)
								- (currentX - currentWidth / 2 + currentMoveX) > (comparedY + comparedHeight / 2)
								- (currentY - currentHeight / 2 - currentMoveY)) {
							scenario = 2;
							difference = (currentY - currentHeight / 2)
							- (comparedY + comparedHeight / 2);
						} else {
							scenario = 1;
							difference = (comparedX + comparedWidth / 2)
							- (currentX - currentWidth / 2);
						}
					}
				}
			}
		} else if (comparedX > currentX && comparedY > currentY) { // compared
			// enemy is
			// right and
			// below
			if (currentDirection <= Math.PI / 2) { // left and down direction
				// towards origin
				if (currentX + currentWidth / 2 + currentMoveX >= comparedX
						- comparedWidth / 2) {
					if (currentY + currentHeight / 2 - currentMoveY >= comparedY
							- comparedHeight / 2) {
						// bottom right corner of current enemy and top left
						// corner of compared enemy intersect
						allow = true;
						scenario = 2;
						difference = (currentY + currentHeight / 2)
						- (comparedY - comparedHeight / 2);
					}
				}
			} else if (currentDirection <= Math.PI) { // right and down
				// direction towards
				// origin
				if (currentX + currentWidth / 2 + currentMoveX >= comparedX
						- comparedWidth / 2) {
					if (currentY + currentHeight / 2 - currentMoveY >= comparedY
							- comparedHeight / 2) {
						// bottom right corner of current enemy and top left
						// corner of compared enemy intersect
						allow = true;
						if ((currentX + currentWidth / 2 + currentMoveX)
								- (comparedX - comparedWidth / 2) > (currentY
										+ currentHeight / 2 - currentMoveY)
										- (comparedY - comparedHeight / 2)) {
							scenario = 2;
							difference = (currentY + currentHeight / 2)
							- (comparedY - comparedHeight / 2);
						} else {
							scenario = 1;
							difference = (comparedX - comparedWidth / 2)
							- (currentX + currentWidth / 2);
						}
					}
				}
			} else if (currentDirection <= (3 * Math.PI) / 2) { // right and up
				// direction
				// towards
				// origin
				if (currentX + currentWidth / 2 + currentMoveX >= comparedX
						- comparedWidth / 2) {
					if (currentY + currentHeight / 2 - currentMoveY >= comparedY
							- comparedHeight / 2) {
						// bottom right corner of current enemy and top left
						// corner of compared enemy intersect
						allow = true;
						scenario = 1;
						difference = (comparedX - comparedWidth / 2)
						- (currentX + currentWidth / 2);
					}
				}
			}
		}

		/*
		 * if (allow){ if (scenario == 1){ if (enemy1 != null){ if
		 * (enemy1.getMoveX() == 0){ difference = 0; } else if
		 * (enemy1.getMoveX() < 0){ if (difference > 0){ difference *= -1; } if
		 * (difference < enemy1.getMoveX()){ difference = enemy1.getMoveX(); } }
		 * else if (enemy1.getMoveX() > 0){ if (difference < 0){ difference *=
		 * -1; } if (difference > enemy1.getMoveX()){ difference =
		 * enemy1.getMoveX(); } } enemy1.setMoveX(difference); } else if
		 * (character1 != null){ if (character1.getSpeedX() == 0){ difference =
		 * 0; } else if (character1.getSpeedX() < 0){ if (difference > 0){
		 * difference *= -1; } if (difference < character1.getSpeedX()){
		 * difference = character1.getSpeedX(); } } else if
		 * (character1.getSpeedX() > 0){ if (difference < 0){ difference *= -1;
		 * } if (difference > character1.getSpeedX()){ difference =
		 * character1.getSpeedX(); } } character1.setSpeedX(difference); } }
		 * else if (scenario == 2){ if (enemy1 != null){ if (enemy1.getMoveY()
		 * == 0){ difference = 0; } else if (enemy1.getMoveY() < 0){ if
		 * (difference > 0){ difference *= -1; } if (difference <
		 * enemy1.getMoveY()){ difference = enemy1.getMoveY(); } } else if
		 * (enemy1.getMoveY() > 0){ if (difference < 0){ difference *= -1; } if
		 * (difference > enemy1.getMoveY()){ difference = enemy1.getMoveY(); } }
		 * enemy1.setMoveY(difference); } else if (character1 != null){
		 * 
		 * if (character1.getSpeedY() == 0){ difference = 0; } else if
		 * (character1.getSpeedY() < 0){ if (difference > 0){ difference *= -1;
		 * } if (difference < character1.getSpeedY()){ difference =
		 * character1.getSpeedY(); } } else if (character1.getSpeedY() > 0){ if
		 * (difference < 0){ difference *= -1; } if (difference >
		 * character1.getSpeedY()){ difference = character1.getSpeedY(); } }
		 * character1.setSpeedY(difference); } } }
		 */
		if (allow) {
			if (scenario == 1) {
				temp[1] = false;
				if (item == null && bullet == null) {
					if (enemy1 != null) {
						enemy1.setMoveX(0);
					} else if (character1 != null) {
						character1.setSpeedX(0);
					}
				}
			} else if (scenario == 2) {
				temp[1] = true;
				if (item == null & bullet == null) {
					if (enemy1 != null) {
						enemy1.setMoveY(0);
					} else if (character1 != null) {
						character1.setSpeedY(0);
					}
				}
			}
			/*
			 * else{ if (enemy1 != null){ enemy1.setMoveY(0);
			 * enemy1.setMoveY(0); } else if (character1 != null){
			 * character1.setSpeedX(0); character1.setSpeedY(0); } }
			 */
		}
		temp[0]=allow;

		return temp;
	}

	public static void sort(Object a[], int left, int right) {
		if (right == left)
			return;
		int middle = (left + right) / 2; // salient feature
		sort(a, left, middle); // salient feature #1 (recursion)
		sort(a, middle + 1, right); // salient feature #2
		merge(a, left, middle, right); // salient feature #3
	}

	private static void merge(Object a[], int left, int middle, int right) {
		// This temporary array will be used to build the merged list
		Object[] tmpArray = new Object[right - left + 1];
		// This creation of a temporary array is a BIG feature of the merge
		// sort.
		int index1 = left;
		int index2 = middle + 1;
		int indx = 0;
		// Loop until one of the sublists is finished, adding the smaller of the
		// first
		// elements of each sublist to the merged list.
		while (index1 <= middle && index2 <= right) {
			// compared values
			double objectY1 = 0, objectY2 = 0;

			if (a[index1] instanceof Enemy) {
				objectY1 = ((Enemy) a[index1]).getEnemyPosition()[1];
			} else if (a[index1] instanceof Character) {
				objectY1 = ((Character) a[index1]).getY();
			} else if (a[index1] instanceof Obstacle) {
				objectY1 = ((Obstacle) a[index1]).getY();
			} else if (a[index1] instanceof Bullet) {
				objectY1 = ((Bullet) a[index1]).getY() + 5;
				if (((Bullet) a[index1]).getGunType() == 6){
					objectY1 -= 35;
				}
			} else if (a[index1] instanceof Turret){/*****/
				objectY1 = ((Turret) a[index1]).getY();
			} else if (a[index1] instanceof Item){/*****/
				objectY1 = ((Item) a[index1]).getItemPosition()[1];
			}

			if (a[index2] instanceof Enemy) {
				objectY2 = ((Enemy) a[index2]).getEnemyPosition()[1];
			} else if (a[index2] instanceof Character) {
				objectY2 = ((Character) a[index2]).getY();
			} else if (a[index2] instanceof Obstacle) {
				objectY2 = ((Obstacle) a[index2]).getY();
			} else if (a[index2] instanceof Bullet) {
				objectY2 = ((Bullet) a[index2]).getY() + 5;
				if (((Bullet) a[index2]).getGunType() == 6){
					objectY2 -= 35;
				}
			} else if (a[index2] instanceof Turret){/*****/
				objectY2 = ((Turret) a[index2]).getY();
			}else if (a[index2] instanceof Item){/*****/
				objectY2 = ((Item) a[index2]).getItemPosition()[1];
			}

			if (objectY1 < objectY2) {
				tmpArray[indx] = a[index1];
				index1++;
			} else {
				tmpArray[indx] = a[index2];
				index2++;
			}
			indx++;
		}
		// Add to the merged list the remaining elements of whichever sublist is
		// not yet finished
		while (index1 <= middle) {
			tmpArray[indx] = a[index1];
			index1++;
			indx++;
		}
		while (index2 <= right) {
			tmpArray[indx] = a[index2];
			index2++;
			indx++;
		}
		// Copy the merged list from the tmpArray array into the a array
		for (indx = 0; indx < tmpArray.length; indx++) {
			a[left + indx] = tmpArray[indx];
		}
	}

	int currentScore = 0;
	int num = 0;

	boolean nullPointer =true;
	boolean pauseSolo = false;
	boolean pauseMulti = false;


	public void gameplay () throws NullPointerException{

		stopTime = Integer.parseInt(sdf2.format(Calendar.getInstance().getTime()));

		// don't add up current time if paused
		if (!pauseSolo){
			if (stopTime < startTime){
				currentTime += ((stopTime + 1000) - startTime);
			}
			else{
				currentTime += (stopTime - startTime);
			}
		}

		//System.out.println (currentTime);
		startTime = Integer.parseInt(sdf2.format(Calendar.getInstance().getTime()));

		if (pauseSolo){
			if (buttons [RETURN_TO_MENU].isClicked ()){
				game = false;
				mainMenu = true;
				pauseSolo = false;
				stopMusic();
				if (multiplayer){
					networkConnectedScreen = false;
					if (hosting){
						network.getServer().closeServer();
					}
					else{
						network.getClient().disconnect();
					}
				}
				playMusic ("Lone Wolf.mp3");
			}
			else if (esc)
			{
				pauseSolo = false;
				esc = false;
			}


			/*else if (buttons [OPTIONS].isClicked ())
			{
				optionScreen = true;
			}*/
		}
		else{



			if (!hosting)
				player.getWeapon().setBullets(new ArrayList <Bullet> ());


			if (!pauseMulti){
				/*controller.getInput();

				if (controller.isConnected()){/////////////////////////////////////

					if(player.getWeapon().checkVibrate(currentTime)){
						//controller.stopVibration();
					
					}

					if (controller.getMagnitudeLeft() > LEFT_JOYSTICK_MINIMUM_MOVMENT_MAGNITUDE){
						player.calculateMove(controller.getMagnitudeLeft(),controller.getDirectionLeft());
					}

					player.aimDegrees(controller.getMagnitudeRight(), controller.getDirectionRight());

					if(controller.getMagnitudeRight()> RIGHT_JOYSTICK_MINIMUM_SHOOTING_MAGNITUDE){

						if (player.shootWeaponDegrees(controller.getDirectionRight(), currentTime)){
							//controller.vibrate(player.getWeapon().getWeapon());
						}

					}
					else{
						player.setAimDirection(-1);
					}



					if (controller.getButton() == XboxControl.LEFT_SHOULDER){
						player.getWeapon().rotateWeaponReverse (NUM_WEAPON_TYPES);
						controller.setButton(XboxControl.NULL);
						System.out.println("Weapon #"
								+ player.getWeapon().getWeapon());
					}
					else if (controller.getButton() == XboxControl.RIGHT_SHOULDER){
						player.getWeapon().rotateWeapon (NUM_WEAPON_TYPES);
						controller.setButton(XboxControl.NULL);
						System.out.println("Weapon #"
								+ player.getWeapon().getWeapon());
					}
					
				}
				else{//////////////////////////////////////////////////////*/
					double dir = 0;
					if (up){
						if (left){
							dir = 315;
						}
						else if (right){
							dir = 45;
						}
						else{
							dir = 0;
						}
					}
					else if (down)
					{
						if (left){
							dir = 225;
						}
						else if (right){
							dir = 135;
						}
						else{
							dir = 180;
						}
					}
					else{
						if (left){
							dir = 270;
						}
						else if (right){
							dir = 90;
						}
					}
					if (rotateWeapon){
							player.getWeapon().rotateWeapon(NUM_WEAPON_TYPES);
							System.out.println("Weapon #"
									+ player.getWeapon().getWeapon());
							rotateWeapon = false;
					}
					else if (rotateWeaponReverse){
						player.getWeapon().rotateWeaponReverse(NUM_WEAPON_TYPES);
						System.out.println("Weapon #"
								+ player.getWeapon().getWeapon());
						rotateWeaponReverse=false;
					}
					if (up || down || left || right){
						player.calculateMove(1, dir);
					}

					if (mousePressed){

						double angle = Math.atan((player.getX() - MainApplet.getMouseX())/(player.getY() - MainApplet.getMouseY()));
						if (angle < 0){
							angle *= -1;
						}
						if (player.getX() - MainApplet.getMouseX() <= 0){
							if (player.getY() - MainApplet.getMouseY() < 0){
								angle = Math.PI - angle;
							}
						}
						else if (player.getX() - MainApplet.getMouseX() > 0){
							if (player.getY() - MainApplet.getMouseY() <= 0){
								angle = Math.PI + angle;
							}
							else if (player.getY() - MainApplet.getMouseY() > 0){
								angle = 2*Math.PI - angle;
							}
						}

						player.shootWeaponRadians(angle, currentTime);
						player.aimRadians(1, angle);
						if(!(up || down || left || right)){
							player.setDirection(Math.toDegrees(angle));
						}
						crosshair.checkFrameTime(currentTime);
					}
					else {
						player.aimRadians(0, 0);
						player.setAimDirection(-1);

						crosshair.freeze(currentTime);
					}

					prevMouseMoveX = MainApplet.getMouseX();
					prevMouseMoveY = MainApplet.getMouseY();

					}
				//}////////////////////////////////////////////////////////////////




				// differentiates between client and server
				if(hosting){
					sPack.setCharacter(player);
					sPack.setAllItems(itemDrops);
					sPack.setObstacles(obstacles);
					sPack.setEnemies(enemies);
					sPack.setLevel(level);
					network.getServer().sendObject(sPack);




					ArrayList <Bullet> allBullets = player.getWeapon().getBullets();

					if (multiplayer){ // multiplayer
						// get second player bullets

						cPack = (ClientPacket) network.receive();
						networkPlayer = cPack.getCharacter();
						
						
						//System.out.println (networkPlayer.getWeapon().getBullets().size());


						for (int i = 0; i < networkPlayer.getWeapon().getBullets().size(); i++){
							allBullets.add(new Bullet (networkPlayer.getWeapon().getBullets().get(i).getX(),
									networkPlayer.getWeapon().getBullets().get(i).getY(),
									networkPlayer.getWeapon().getBullets().get(i).getGunType(),
									networkPlayer.getWeapon().getBullets().get(i).getDirection()));
						}

						for (int i = 0; i < networkPlayer.getWeapon().getTurrets().size(); i++){
							player.getWeapon().getTurrets().add(new Turret (player.getWeapon(), networkPlayer.getWeapon().getTurrets().get(i).getX(), networkPlayer.getWeapon().getTurrets().get(i).getY(),networkPlayer.getWeapon().getTurrets().get(i).getType()));
						}

					}


					/*****/
					for (int i = 0; i < player.getWeapon().getTurrets().size(); i++){
						player.getWeapon().getTurrets().get(i).setEnemiesInVicinity(0);
						for (int j = 0; j < enemies.size(); j ++){
							player.getWeapon().getTurrets().get(i).aim(enemies.get(j).getEnemyPosition()[0], enemies.get(j).getEnemyPosition()[1]);
						}
						if (player.getWeapon().getTurrets().get(i).getEnemiesInVicinity() == 0){
							player.getWeapon().getTurrets().get(i).resetTurret();
						}
					}

					for(int i = 0; i < player.getWeapon().getTurrets().size(); i ++){
						if (player.getWeapon().getTurrets().get(i).shoot(currentTime)){
							player.getWeapon().getTurrets().remove(i);
							i --;
						}
					}
					/*****/

					if (enemies.size() == 0 && spawningEnemies == 0){
						newLevel = true;
					}

					if (newLevel){
						newLevel = false;
						level ++;
						spawningEnemies = (int) (LEVEL_1_NUM_ENEMIES * Math.pow(enemyMultiplier, level - 1));
						System.out.println("level " + level);
						if (level >= 3){
							spawningEnemies2 = spawningEnemies/3;
						}
						else{
							spawningEnemies2 = 0;
						}
						/*****/
						if (level >= 5){
							spawningEnemies3 = spawningEnemies/4;
						}
						else {
							spawningEnemies3 = 0;
						}
						if (level >= 11){
							spawningBoss = (3*spawningEnemies)/12;
						}

						player.recieveItem(0); // before a level
						soundEffects[5].play();
						/*****/
					}

					ArrayList <Explosion> explosionsToAdd = new ArrayList <Explosion> ();

					// bullets offscreen
					for (int i = 0; i < allBullets.size(); i++){
						boolean remove = false;
						boolean remove2 = false;
						int tempNum = 0;				
						if (allBullets.get(i).getGunType() != 6 || (allBullets.get(i).getGunType() == 6 && allBullets.get(i).getStartTime() == 0)){
							allBullets.get(i).moveBullet(currentTime);
						}
						else {
							if (allBullets.get(i).stopSticky(currentTime)){ // sticky bullets out of time
								remove = true;
							}
						}

						if (allBullets.get(i).getGunType() == 6 && allBullets.get(i).getStartTime() == 0){
							if (multiplayer){
								if (collisionDetection(allBullets.get(i),networkPlayer)[0]){
									allBullets.get(i).setStartTime(currentTime);
									player.damageCharacter(allBullets.get(i).getBulletDamage());
								}
							}
							if (collisionDetection(allBullets.get(i),player)[0]){
								allBullets.get(i).setStartTime(currentTime);
								player.damageCharacter(allBullets.get(i).getBulletDamage());
							}
						}

						if (allBullets.get(i).getGunType() == 6 && allBullets.get(i).getStartTime() != 0){
							double xDistance = player.getX() - allBullets.get(i).getX(), yDistance = player.getY() - allBullets.get(i).getY();
							double hypotenuse = Math.sqrt (Math.pow (xDistance, 2) + Math.pow (yDistance, 2));
							if (hypotenuse <= Bullet.STICKY_RADIUS + player.getWidth()/2){
								player.setSpeedX(0);
								player.setSpeedY(0);
							}
						}

						if (allBullets.get(i).getX() > SCREEN_WIDTH + allBullets.get(i).getSize() || allBullets.get(i).getX() < -allBullets.get(i).getSize() ||
								allBullets.get(i).getY() > SCREEN_HEIGHT + allBullets.get(i).getSize()|| allBullets.get(i).getY() < - allBullets.get(i).getSize()){
							remove = true;
						}
						if (!remove){
							if (allBullets.get(i).getGunType() == 5){// grenade
								if (allBullets.get(i).detonateGrenade(currentTime)){
									remove = true;
									explosions.add(new Explosion (allBullets.get(i).getX(), allBullets.get(i).getY(), currentTime, Explosion.GRENADE_EXPLOSION));
									explosionsToAdd.add(explosions.get(explosions.size()-1));
									soundEffects[14].play();
								}
							}
						}

						if (!remove){
							if (allBullets.get(i).getGunType() == 4){// an rpg shot
								// bullet rocket collision
								for (int j = 0; j < allBullets.size(); j++){
									if(i != j){
										if(collisionDetection(allBullets.get(i),allBullets.get(j))[0]){
											explosions.add(new Explosion (allBullets.get(j).getX(), allBullets.get(j).getY(), currentTime, Explosion.RPG_EXPLOSION));
											explosionsToAdd.add(explosions.get(explosions.size()-1));
											soundEffects[9].play();
											if (j > i){
												allBullets.remove(j);
											}
											else {
												remove2 = true;
												tempNum = j;
											}
											remove = true;
											j = allBullets.size();
										}
									}
								}
							}
						}
						if (!remove){
							// rocket in explosion radius
							for(int j = 0; j < explosions.size(); j++){
								if (explosions.get(j).getExplosionPhase() == 1){
									if (allBullets.get(i).getGunType() == 4){// an rpg shot
										if (explosions.get(j).chainExplode(allBullets.get(i))){
											remove = true;
											explosions.add(new Explosion (allBullets.get(i).getX(), allBullets.get(i).getY(), currentTime, Explosion.RPG_EXPLOSION));
											explosionsToAdd.add(explosions.get(explosions.size()-1));
											soundEffects[9].play();
										}
									}
									else if (allBullets.get(i).getGunType() == 5){ // grenade
										if (explosions.get(j).chainExplode(allBullets.get(i))){
											remove = true;
											explosions.add(new Explosion (allBullets.get(i).getX(), allBullets.get(i).getY(), currentTime, Explosion.GRENADE_EXPLOSION));
											explosionsToAdd.add(explosions.get(explosions.size()-1));
											soundEffects[14].play();
										}
									}
								}
							}
						}


						if (remove){
							allBullets.remove(i);
							i --;
							if (remove2){
								allBullets.remove(tempNum);
								i --;
							}
						}
					}

					// character obstacle collision/bullet obstacle collision
					for (int i = 0; i < obstacles.size(); i++){
						collisionDetection (player, obstacles.get(i));

						for (int j = 0; j < allBullets.size(); j ++){
							boolean[] bulletCollide = collisionDetection (allBullets.get(j),obstacles.get(i));
							if (bulletCollide[0]){
								if (allBullets.get(j).getGunType() == 4){ // a rocket shot/*****/
									explosions.add(new Explosion (allBullets.get(j).getX(), allBullets.get(j).getY(), currentTime, Explosion.RPG_EXPLOSION));
									explosionsToAdd.add(explosions.get(explosions.size()-1));
									soundEffects[9].play();
								}
								else if (allBullets.get(j).getGunType() == 5){ // grenade
									double newDir = allBullets.get(j).getDirection();

									if (newDir <= Math.PI){
										if (bulletCollide[1]){ // hit top
											newDir = Math.PI - newDir;
										}
										else{ // hit side
											newDir = 2*Math.PI - newDir;
										}
									}
									else if (newDir <= 2*Math.PI){
										if (bulletCollide[1]){ // hit bottom
											newDir = 3*Math.PI - newDir;
										}
										else{ // hit side
											newDir = 2*Math.PI - newDir;
										}
									}

									allBullets.get(j).setDirection(newDir);
								}
								else if (allBullets.get(j).getGunType() == 6){
									if (allBullets.get(j).getStartTime() == 0){
										allBullets.get(j).setStartTime(currentTime);
									}
								}

								if (allBullets.get(j).getGunType() != 5 && allBullets.get(j).getGunType() != 6) {
									allBullets.remove(j);
									j --;
								}

							}
						}
					}


					if (spawningEnemies > 0){
						double spawnTime = timeLastSpawn + ((LEVEL_1_SPAWN_DELAY/((Math.log10(level + 2))/Math.log10(3)))*1000);
						if (spawnTime <= currentTime){
							int randomNum = 0;
							int enemyRandom = 0;
							int type = 0; // spawn normal zombies by default
							if (level >= 3 && level <= 5){ // start spawning fast, before level 5, after 3
								enemyRandom = 9;
							}
							else if (level < 9){ // start spawning big strong, before level 9
								enemyRandom = 11;
							}
							else if (level < 11){ // start spawning explosive, before level 11
								enemyRandom = 14;
							}
							else if (level < 12){
								enemyRandom = 15;
							}
							else if (level < 13){
								enemyRandom = 17;
							}
							else {
								enemyRandom = 18;
							}
							Random random = new Random ();
							randomNum = random.nextInt(enemyRandom);
							if (spawningEnemies2 > 0 && randomNum >= 5 && randomNum <= 8){ // fast zombies
								spawningEnemies2--;
								type = 1;
							}
							else if (spawningEnemies3 > 0 && randomNum >= 9 && randomNum <= 10){ // big zombies
								spawningEnemies3--;
								type = 2;
							}
							else if (spawningEnemies2 > 0 && randomNum >= 11 && randomNum <= 13){ // explosive zombies
								spawningEnemies2--;
								type = 3;
							}
							else if (spawningBoss > 0 && randomNum >= 14 && randomNum <= 15){ // normal boss zombies
								spawningBoss--;
								type = 4;
							}
							else if (spawningBoss > 0 && randomNum == 16){ // fast boss zombies
								spawningBoss--;
								type = 5;
							}
							else if (spawningBoss > 0 && randomNum == 17){ // big boss zombies
								spawningBoss--;
								type = 6;
							}

							enemies.add(new Enemy (type, level));
							enemies.get(enemies.size()-1).enemySpawn(SCREEN_WIDTH, SCREEN_HEIGHT, currentTime);

							spawningEnemies --;     
							timeLastSpawn = currentTime;// get spawn time

						}
					}

					for (int i = 0; i < enemies.size(); i ++){
						Enemy currentEnemy = enemies.get(i);
						currentEnemy.checkFrameTime(currentTime); //if time based /*****/
						int [] temp = null;
						boolean removeEnemy = false;
						if (multiplayer){
							if(currentEnemy.enemyCalculateMove(player, networkPlayer, currentTime)){
								if (currentEnemy.getType() != 4){
									player.damageCharacter(currentEnemy.getDamage());
								}
								else{
									double angle = (currentEnemy.getEnemyPosition()[2]*-1) + (3*Math.PI)/2;
									allBullets.add(new Bullet (currentEnemy.getEnemyPosition()[0],currentEnemy.getEnemyPosition()[1],MainApplet.ENEMY_SHOT,angle));
								}
							}
						}
						else{
							if(currentEnemy.enemyCalculateMove(player.getX(), player.getY(), currentTime)){
								if (currentEnemy.getType() != 4){
									player.damageCharacter(currentEnemy.getDamage());
								}
								else{
									double angle = (currentEnemy.getEnemyPosition()[2]*-1) + (3*Math.PI)/2;
									allBullets.add(new Bullet (currentEnemy.getEnemyPosition()[0],currentEnemy.getEnemyPosition()[1],MainApplet.ENEMY_SHOT,angle));
								}
							}
						}


						// enemy-enemy collision
						for (int j = 0; j < enemies.size(); j ++){
							if (j != i){
								collisionDetection(currentEnemy, enemies.get(j));
							}
							if (currentEnemy.getMoveX() == 0 && currentEnemy.getMoveY() == 0){
								j = enemies.size();
							}
						}
						//obstacle enemy collision
						for (int j = 0; j < obstacles.size(); j ++){
							collisionDetection (currentEnemy, obstacles.get(j));
							if (currentEnemy.getMoveX() == 0 && currentEnemy.getMoveY() == 0){
								j = obstacles.size();
							}
						}

						/*****/ // enemy turret collision
						for (int j = 0; j < player.getWeapon().getTurrets().size(); j ++){
							collisionDetection(currentEnemy, player.getWeapon().getTurrets().get(j));
						}
						/*****/

						currentEnemy.move();

						/*****/ // explosion radius - enemy damage
						for (int j = 0; j < explosions.size(); j ++){
							if (explosions.get(j).getExplosionPhase() == 1){
								temp = currentEnemy.damageEnemy(explosions.get(j).damageEnemy(currentEnemy));
							}
						}
						/*****/

						if (!removeEnemy){
							for (int j = 0; j < allBullets.size(); j ++){
								// bullet enemy collision
								boolean[] bulletCollide = collisionDetection (allBullets.get(j),currentEnemy);
								if (currentEnemy.getEnemyStatus()){
									if (bulletCollide[0] && allBullets.get(j).getGunType() != 6){
										boolean removeBullet = true;
										if (currentEnemy.getType() != 6){
											temp = currentEnemy.damageEnemy(allBullets.get(j).getBulletDamage());


										}
										/*****/
										if (allBullets.get(j).getGunType() == 4){ // a rocket shot
											explosions.add(new Explosion (allBullets.get(j).getX(), allBullets.get(j).getY(), currentTime, Explosion.RPG_EXPLOSION));
											explosionsToAdd.add(explosions.get(explosions.size()-1));
											soundEffects[9].play();
										}
										else if (allBullets.get(j).getGunType() == 5){// grenade
											explosions.add(new Explosion (allBullets.get(j).getX(), allBullets.get(j).getY(), currentTime, Explosion.GRENADE_EXPLOSION));
											explosionsToAdd.add(explosions.get(explosions.size()-1));
											soundEffects[14].play();
										}
										else if (currentEnemy.getType() == 6){
											double newDir = allBullets.get(j).getDirection();

											if (newDir <= Math.PI){
												if (bulletCollide[1]){ // hit top
													newDir = Math.PI - newDir;
												}
												else{ // hit side
													newDir = 2*Math.PI - newDir;
												}
											}
											else if (newDir <= 2*Math.PI){
												if (bulletCollide[1]){ // hit bottom
													newDir = 3*Math.PI - newDir;
												}
												else{ // hit side
													newDir = 2*Math.PI - newDir;
												}
											}

											allBullets.get(j).setDirection(newDir);
											removeBullet = false;
										}
										else if (allBullets.get(j).getGunType() == 3/* && currentEnemy.getType() != 2*/){
											removeBullet = false;
										}

										if (removeBullet){
											allBullets.remove(j);
											j--;
										}
										/*****/
									}  
								}                                
							}

							// character enemy collision
							collisionDetection (player, currentEnemy);
						}

						if (!currentEnemy.getEnemyStatus()){
							if (currentEnemy.getType() == 3){ // enemy gas explosion
								explosions.add(new Explosion(currentEnemy.getEnemyPosition()[0], currentEnemy.getEnemyPosition()[1], currentTime, Explosion.ENEMY_EXPLOSION));
								explosionsToAdd.add(explosions.get(explosions.size()-1));
								soundEffects[15].play();
							}
							else if (currentEnemy.getType() == 5){
								for (int j = 0; j < 4; j ++){
									int splitVal = 20;
									double [] position = new double [2];
									position[0] = currentEnemy.getEnemyPosition()[0] + splitVal*Math.cos(currentEnemy.getEnemyPosition()[2] + j*(Math.PI/2));
									position[1] = currentEnemy.getEnemyPosition()[1] + splitVal*Math.sin(currentEnemy.getEnemyPosition()[2] + j*(Math.PI/2));
									enemies.add(new Enemy (1, level));
									enemies.get(enemies.size()-1).setStartTime(currentTime);
									enemies.get(enemies.size()-1).setEnemyPosition(position);
									enemies.get(enemies.size()-1).setEnemyStatus(true);
								}
							}
							if (temp [0] == 1){// if item is to be dropped
								itemDrops.add(new Item (temp, NUM_ITEM_TYPES, currentTime,level));
							}
							Random r = new Random();
							currentScore+= ((currentEnemy.getType()+1)*(10) + (currentEnemy.getType()+1)*(r.nextInt(5)));
							System.out.println (currentScore);
							enemies.remove(currentEnemy);
							i--;
						}
					}

					// characters in explosion radius
					for (int i = 0; i < explosions.size(); i ++){
						if (explosions.get(i).getExplosionPhase() == 1){
							player.damageCharacter(explosions.get(i).damageCharacter(player));
							if (multiplayer){
								player.damageCharacter(explosions.get(i).damageCharacter(networkPlayer));
							}
						}
					}


					// explosion regulator
					for (int i = 0; i < explosions.size(); i ++){
						//System.out.println(explosions.get(0).getExplosionPhase());
						if (explosions.get(i).startDamage(currentTime) && explosions.get(i).getExplosionPhase() == 0){
							explosions.get(i).setExplosionPhase(1);
						}
						else if (explosions.get(i).getExplosionPhase() == 1){
							explosions.get(i).setExplosionPhase(2);
						}
						if (explosions.get(i).toRemove(currentTime)){
							explosions.remove(i);
							i--;
						}
					}


					if (multiplayer){ // collision with other character
						collisionDetection (player, networkPlayer);
					}

					player.getWeapon().setBullets(allBullets);

					ArrayList <Item> itemsTouched = new ArrayList <Item> ();
					for (int i = 0; i < itemDrops.size(); i ++){

						// character item box collision
						if (multiplayer){
							boolean toRemove = false;       
							if(collisionDetection (player, itemDrops.get(i))[0]){
								player.recieveItem(itemDrops.get(i).getType());
								System.out.println("Item #" +itemDrops.get(i).getType());

								if (itemDrops.get(i).getType() == HEALTH_PICKUP){
									soundEffects[5].play();
								}
								else if(itemDrops.get(i).getType() == UZI_PICKUP){
									soundEffects[3].play();
								}
								else if(itemDrops.get(i).getType() == SHOTGUN_PICKUP){
									soundEffects[4].play();
								}
								else if (itemDrops.get(i).getType() == TURRET_PICKUP || itemDrops.get(i).getType() == RPG_TURRET_PICKUP){/*****/
									soundEffects[6].play();
								}
								else if (itemDrops.get(i).getType() == SNIPER_PICKUP){/*****/
									soundEffects[7].play();
								}
								else if (itemDrops.get(i).getType() == GRENADE){/*****/
									soundEffects[12].play();
								}
								else if (itemDrops.get(i).getType() == RPG){/*****/
									soundEffects[13].play();
								}


								itemDrops.remove(i);
								toRemove = true;
							}


							if (toRemove){
								i--;
							}

							if (i >= 0){
								if(collisionDetection (networkPlayer, itemDrops.get(i))[0]){
									if (itemDrops.get(i).getType() != 0){
										itemsTouched.add(itemDrops.get(i));
									}
									else{
										player.recieveItem(itemDrops.get(i).getType());
									}
									System.out.println(itemDrops.get(i).getType());
									itemDrops.remove(i);
								}
							}
						}
						else{
							if(collisionDetection (player, itemDrops.get(i))[0]){
								player.recieveItem(itemDrops.get(i).getType());
								System.out.println("Item #" + itemDrops.get(i).getType());

								if (itemDrops.get(i).getType() == HEALTH_PICKUP){
									soundEffects[5].play();
								}
								else if(itemDrops.get(i).getType() == UZI_PICKUP){
									soundEffects[3].play();
								}
								else if(itemDrops.get(i).getType() == SHOTGUN_PICKUP){
									soundEffects[4].play();
								}
								else if (itemDrops.get(i).getType() == TURRET_PICKUP || itemDrops.get(i).getType() == RPG_TURRET_PICKUP){/*****/
									soundEffects[6].play();
								}
								else if (itemDrops.get(i).getType() == SNIPER_PICKUP){/*****/
									soundEffects[7].play();
								}
								else if (itemDrops.get(i).getType() == GRENADE){/*****/
									soundEffects[12].play();
								}
								else if (itemDrops.get(i).getType() == RPG){/*****/
									soundEffects[13].play();
								}

								itemDrops.remove(i);

								i--;
							}
						}
					}

					for (int i = 0; i < itemDrops.size(); i ++){
						if (itemDrops.get(i).addTimer(currentTime)){
							itemDrops.remove(i);
							i --;
						}
					}
					/*****/ // player turret collision
					for (int i = 0; i < player.getWeapon().getTurrets().size(); i ++){
						collisionDetection(player, player.getWeapon().getTurrets().get(i));
					}



					player.moveCharacter();

					sPack.setItemsTouched(itemsTouched);
					sPack.setExplosionsToAdd(explosionsToAdd);



				}
				else{ // client
					cPack.setCharacter(player);
					network.getClient().sendObject(cPack);

					sPack = (ServerPacket) network.receive();
					if (level != sPack.getLevel()){
						soundEffects[5].play();
					}
					level = sPack.getLevel();
					networkPlayer = sPack.getCharacter();
					itemDrops = sPack.getItemsTouched();
					enemies = sPack.getEnemies();
					obstacles = sPack.getObstacles();

					// calibrate turrets
					for (int i = 0; i < player.getWeapon().getTurrets().size(); i++){
						player.getWeapon().getTurrets().get(i).setEnemiesInVicinity(0);
						for (int j = 0; j < enemies.size(); j ++){
							player.getWeapon().getTurrets().get(i).aim(enemies.get(j).getEnemyPosition()[0], enemies.get(j).getEnemyPosition()[1]);
						}
						if (player.getWeapon().getTurrets().get(i).getEnemiesInVicinity() == 0){
							player.getWeapon().getTurrets().get(i).resetTurret();
						}
					}

					// add newly created explosions

					for (int i = 0; i < sPack.getExplosionsToAdd().size(); i++){
						explosions.add(new Explosion(sPack.getExplosionsToAdd().get(i).getX(), sPack.getExplosionsToAdd().get(i).getY(), currentTime, sPack.getExplosionsToAdd().get(i).getType()));
					}


					// explosion regulator
					for (int i = 0; i < explosions.size(); i ++){
						if (explosions.get(i).toRemove(currentTime)){
							explosions.remove(i);
							i--;
						}
					}

					// apply item drops
					for (int i = 0; i < itemDrops.size(); i++){
						player.recieveItem(itemDrops.get(i).getType());
						if (itemDrops.get(i).getType() == HEALTH_PICKUP){
							soundEffects[5].play();
						}
						else if(itemDrops.get(i).getType() == UZI_PICKUP){
							soundEffects[3].play();
						}
						else if(itemDrops.get(i).getType() == SHOTGUN_PICKUP){
							soundEffects[4].play();
						}
						else if (itemDrops.get(i).getType() == TURRET_PICKUP || itemDrops.get(i).getType() == RPG_TURRET_PICKUP){/*****/
							soundEffects[6].play();
						}
						else if (itemDrops.get(i).getType() == SNIPER_PICKUP){/*****/
							soundEffects[7].play();
						}
						else if (itemDrops.get(i).getType() == GRENADE){/*****/
							soundEffects[12].play();
						}
						else if (itemDrops.get(i).getType() == RPG){/*****/
							soundEffects[13].play();
						}

					}

					// character obstacle collision
					for (int i = 0; i < obstacles.size(); i++){
						collisionDetection (player, obstacles.get(i));
					}

					for (int i = 0; i < enemies.size(); i ++){
						// character enemy collision
						collisionDetection (player, enemies.get(i));
					}

					if (multiplayer){ // collision with other character
						collisionDetection (player, networkPlayer);
					}


					player.moveCharacter();



					concurrentBulletFix = new ArrayList <Bullet> ();
					// set all bullets for drawing
					for (int i = 0; i < networkPlayer.getWeapon().getBullets().size(); i++){
						//player.getWeapon().getBullets().add(new Bullet (networkPlayer.getWeapon().getBullets().get(i).getX(),networkPlayer.getWeapon().getBullets().get(i).getY(), networkPlayer.getWeapon().getBullets().get(i).getGunType(),networkPlayer.getWeapon().getBullets().get(i).getDirection()));
						concurrentBulletFix.add(new Bullet (networkPlayer.getWeapon().getBullets().get(i).getX(),networkPlayer.getWeapon().getBullets().get(i).getY(), networkPlayer.getWeapon().getBullets().get(i).getGunType(),networkPlayer.getWeapon().getBullets().get(i).getDirection()));
					}
					//System.out.println(player.getWeapon().getBullets().size());

					concurrentTurretFix = new ArrayList <Turret> ();
					// set all turrets for drawing
					for (int i = 0; i < networkPlayer.getWeapon().getTurrets().size(); i++){

						concurrentTurretFix.add(new Turret (null, networkPlayer.getWeapon().getTurrets().get(i).getX(), networkPlayer.getWeapon().getTurrets().get(i).getY(), networkPlayer.getWeapon().getTurrets().get(i).getType()));
						concurrentTurretFix.get(i).setAmmo(networkPlayer.getWeapon().getTurrets().get(i).getAmmo());
					}

					//player.getWeapon().setBullets(allBullets); // set all bullets for drawing



					itemDrops = sPack.getAllItems();

					//player.getWeapon().setBullets(new ArrayList <Bullet> ());
					//player.getWeapon().setTurrets(new ArrayList <Turret> ());
					
					
					

				}

				if (multiplayer){
					if (hosting){
						if(player.getHealth() <= 0){
							networkConnectedScreen = false;
							sPack.setCharacter(player);
							network.getServer().sendObject(sPack);
							delay (1500);
							network.getServer().closeServer();
							mainMenu = true;
							game = false;
							pauseMulti = false;
							stopMusic();
							playMusic ("Lone Wolf.mp3");
						}
					}
					else{
						if (networkPlayer.getHealth() <= 0){
							networkConnectedScreen = false;
							network.getClient().disconnect();
							mainMenu = true;
							game = false;
							pauseMulti = false;
							stopMusic();
							playMusic ("Lone Wolf.mp3");
						}
					}
				}
				else{
					if(player.getHealth() <= 0){
						if(main.isConnected()){
							if (currentScore > userProfile.getScore()){
								userProfile.setScore(currentScore);
							}
							if (level > userProfile.getLevelReached()){
								userProfile.setLevelReached(level);	
							}

							main.sendObject(SAVE_INFO);
							delay(10);
							main.sendObject(userProfile);
						}
						mainMenu = true;
						game = false;
						pauseSolo = false;
						gameOverScreen = true;
						buttons[RETURN_TO_MENU].setX(258+145);
						buttons[RETURN_TO_MENU].setY(200+220);


						stopMusic();
						playMusic ("Lone Wolf.mp3");/*****/
					}
				}

				if (pauseMulti){
					if (buttons [RETURN_TO_MENU].isClicked ()){
						game = false;
						mainMenu = true;
						pauseMulti = false;
						stopMusic();
						if (multiplayer){
							networkConnectedScreen = false;
							if (hosting){
								network.getServer().closeServer();
							}
							else{
								network.getClient().disconnect();
							}
						}
						playMusic ("Lone Wolf.mp3");
					}
					else if (esc)
					{
						pauseMulti = false;
						esc = false;
					}

					/*else if (buttons [OPTIONS].isClicked ())
				{
					optionScreen = true;
				}*/
				}


				if (esc){
					if (!multiplayer){
						pauseSolo = true;
					}
					else{
						pauseMulti = true;
					}
					//mousePressed = false;
					esc =false;
					buttons [RETURN_TO_MENU].setX(SCREEN_WIDTH/2 - 125);
					buttons [RETURN_TO_MENU].setY(100);
				}
			}
		

	}

	public boolean nickNameScreen = false;

	public void run() {


		initialization();
		while (!exit) {
			if (mainMenu) {

				checkOptions();
				delay(5);
			}
			else if (game) {
				try {
					gameplay();
				}
				catch (NullPointerException e){
					if (network != null){
						if(hosting){
							if (network.getServer().isConnected()){
								network.getServer().closeServer();
								mainMenu = true;
								game = false;
								networkConnectedScreen = false;
								stopMusic();
							}
						}
						else{
							if (network.getClient().isConnected()){
								network.getClient().disconnect();
								mainMenu = true;
								game = false;
								networkConnectedScreen = false;
								stopMusic();
							}
						}
					}
				}
				catch (ConcurrentModificationException e){
					e.printStackTrace();
				}

				/*if (multiplayer){
					if (hosting){
						delay (23);
					}
				}
				else {
					delay (23);
				}*/
				delay(20);
			}
			repaint();
		}
		while (true){
			repaint();
		}


		//System.exit(0);
	}


	public static void shotSound (int gunType){
		if (gunType == PISTOL){
			soundEffects[0].play();
		}
		else if (gunType == MACHINE){
			soundEffects[1].play();
		}
		else if (gunType == SHOTGUN){
			soundEffects[2].play();
		}
		else if (gunType == SNIPER){
			soundEffects[8].play();
		}
		else if (gunType == TURRET || gunType == RPG_TURRET){
			soundEffects[6].play();
		}
		else if (gunType == GRENADE){
			soundEffects[10].play();
		}
		else if (gunType == RPG){
			soundEffects[11].play();
		}
	}




	Thread th = new Thread(this);
	public void start() {


	}

	public void stop() {

	}

	public void destroy() {

		if (!activeBool){
			//File f2 = new File (PROGRAM_DIRECTORY + "active");
			//f2.delete();
		}

		try{
			signOut();
		}
		catch (NullPointerException e){
			System.out.println ("User close the program without signing in.");
		}

		//	System.out.println (PROGRAM_DIRECTORY.substring(0, PROGRAM_DIRECTORY.length() - 1) + " Temp/");
		try{
			//File f = new File (PROGRAM_DIRECTORY.substring(0, PROGRAM_DIRECTORY.length() - 1) + " Temp/");
			//File f1 = new File (PROGRAM_DIRECTORY.substring(0, PROGRAM_DIRECTORY.length() - 1) + " Temp/" + f.list()[0]);
			//f1.delete();
			//f.delete();


		}
		catch (Exception e){
		}



	}

	public void delay(int arg) {
		try {
			Thread.sleep(arg);

		} catch (Exception e) {

		}
	}

	public void update(Graphics g) {
		if (dbImage == null) {
			dbImage = createImage(this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics();
		}

		dbg.setColor(getBackground());
		dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);

		dbg.setColor(getForeground());

		try{
			paint(dbg);
		}
		catch (SecurityException e){
			e.printStackTrace();
		}
		catch (NullPointerException e){
			e.printStackTrace();
		}


		g.drawImage(dbImage, 0, 0, this);

	}


	public static int mouseDragX;
	public static int mouseDragY;
	public static int mouseX;
	public static int mouseY;
	public boolean dragging;

	public static int getMouseDragX(){
		return mouseDragX;
	}

	public static int getMouseDragY(){
		return mouseDragY;
	}



	public void mouseClicked(MouseEvent me) {
	}

	public void mouseMoved(MouseEvent me) {
		mouseMoveX = me.getX(); // get x cord of mouse position
		mouseMoveY = me.getY(); // get y cord of mouse position
		mouseX = me.getX();
		mouseY = me.getY();
	}


	static int mouseDraggedX = 0;
	static int mouseDraggedY = 0;

	public void mouseDragged (MouseEvent me)
	{
		dragging = true;
		mouseDraggedX = me.getX (); // get x cord of mouse position
		mouseDraggedY = me.getY (); // get y cord of mouse position


		mouseDragX = me.getX (); // get x cord of mouse position
		mouseDragY = me.getY (); // get y cord of mouse position

		mouseMoveX = me.getX (); // get x cord of mouse position
		mouseMoveY = me.getY (); // get y cord of mouse position
	}


	public static int getMouseDraggedX ()
	{
		return mouseDraggedX;

	}


	public static int getMouseDraggedY ()
	{
		return mouseDraggedY;
	}

	public static void setMouseDraggedY (int num)
	{
		mouseDraggedY = num;
	}


	public void mousePressed(MouseEvent me) {
		if(me.getButton() == MouseEvent.BUTTON1){// left click
			mousePressed = true;
			//System.out.println("left click");
		}
		for (int i = 0 ; i < chats.size(); i++){
			chats.get(i).setXprev(mouseX-chats.get(i).getX());
			chats.get(i).setYprev(mouseY-chats.get(i).getY());

			if(chats.get(i).isOffScreen()){
				System.out.println ("speed set");
				chats.get(i).setXspeed(1);
				chats.get(i).setYspeed(0);

			}
			else if (!(chats.get(i).isOffScreen())) {

				chats.get(i).setXspeed((Math.cos(Math.atan ((chats.get(i).getY())/(chats.get(i).getX()+250)))));
				chats.get(i).setYspeed((Math.sin(Math.atan ((chats.get(i).getY())/(chats.get(i).getX()+250)))));

			}
		}
		if (game){
			if (me.getButton() == MouseEvent.BUTTON3){// right click
				if (game){ // goes to strongest weapon
					player.getWeapon().chooseWeapon(0);
					player.getWeapon().rotateWeaponReverse(NUM_WEAPON_TYPES);
					System.out.println("Weapon #"
							+ player.getWeapon().getWeapon());
				}
				//System.out.println("right click");
			}
			else if (me.getButton() == MouseEvent.BUTTON2){
				if (game){ // goes to weakest weapon
					player.getWeapon().chooseWeapon(0);
					player.getWeapon().rotateWeapon(NUM_WEAPON_TYPES);
					System.out.println("Weapon #"
							+ player.getWeapon().getWeapon());
				}
				System.out.println("scroll click");
			}
		}
	}

	public void mouseReleased(MouseEvent me) {
		if(me.getButton() == MouseEvent.BUTTON1){// left click
			mousePressed = false;
			allowScroll = false;
			//System.out.println("left click");
		}

		dragging = false;

		for (int i = 0 ; i < chats.size(); i++){
			chats.get(i).setClicked(false);
			chats.get(i).setXprev(0);
			chats.get(i).setYprev(0);
		}


	}

	public static boolean getMouseClicked() {
		return mousePressed;
	}

	public static int getMouseX() {
		return mouseMoveX;

	}

	public static int getMouseY() {
		return mouseMoveY;

	}

	public static int getMouseMoveX() {
		return mouseX;

	}

	public static int getMouseMoveY() {
		return mouseY;

	}
	boolean rotateWeapon = false;
	boolean rotateWeaponReverse = false;

	public void keyPressed(KeyEvent ke) {
		int key = ke.getKeyCode(); // get keyboard character, convert to int

		if (mainMenu) {
			if (key == KeyEvent.VK_ESCAPE) {
				Toolkit.getDefaultToolkit().beep(); // make a beep
				esc = true;
			}
			else if (key == KeyEvent.VK_ENTER) {
				Toolkit.getDefaultToolkit().beep(); // make a beep
				enter = true;
			}
		} else if (game) {
			if (!pause) {
				if (key == KeyEvent.VK_W) {
					up = true;
				}
				else if (key == KeyEvent.VK_S) {
					down = true;
				}

				if (key == KeyEvent.VK_A) {
					left = true;
				}
				else if (key == KeyEvent.VK_D) {
					right = true;
				}
				else if (key == KeyEvent.VK_E) {
					rotateWeapon = true;
				}
				else if (key == KeyEvent.VK_Q) {
					rotateWeaponReverse = true;
				}
				else if (key == KeyEvent.VK_ESCAPE) {
					
					esc = true;
				}
				else if (key >= KeyEvent.VK_1 && key <= KeyEvent.VK_1 + MainApplet.NUM_WEAPON_TYPES){
					for (int i = KeyEvent.VK_1; i < KeyEvent.VK_1 + MainApplet.NUM_WEAPON_TYPES; i ++){
						if (key == i){
							player.getWeapon().chooseWeapon(i - KeyEvent.VK_1);
							System.out.println("Weapon #"
									+ player.getWeapon().getWeapon());
						}
					}
				}
			}
			else{
				if (key == KeyEvent.VK_ESCAPE) {
					esc = true;
				}
			}

		}
	}


	public void keyReleased(KeyEvent ke) { // May be used
		int key = ke.getKeyCode(); // get keyboard character, convert to int

		if (key == KeyEvent.VK_ENTER) {
			enter = false;
			allowEnter = false;
		}

		if (key == KeyEvent.VK_ESCAPE) {
			esc = false;
			allowEsc = false;
		}

		if (key == KeyEvent.VK_W) {
			up = false;
		}

		if (key == KeyEvent.VK_S) {
			down = false;
		}

		if (key == KeyEvent.VK_A) {
			left = false;
		}

		if (key == KeyEvent.VK_D) {
			right = false;
		}
		
		if (key == KeyEvent.VK_E) {
			rotateWeapon = false;
			
		}
		if (key == KeyEvent.VK_Q) {
			rotateWeaponReverse = false;
			
		}
		
	}

	public void keyTyped(KeyEvent ke) { // Unused
	}

	public void mouseEntered(MouseEvent me) { // Unused
	}

	public void mouseExited(MouseEvent me) { // Unused
	}

	public void mouseWheelMoved(MouseWheelEvent mw) {
		int notches = mw.getWheelRotation (); // get scroll
		// move playlists
		//System.out.println (friendList.getArrayList().size());
		// move songs
		if (friendsScreen){
			if (getMouseX () > 30 && getMouseX () < 30 + 500){
				if (getMouseY () > 110 && getMouseY () < 110 + 500){
					friendScroll.moveScrollBar(notches, currentlyClicked);// move cursor
					//System.out.println ("yo");
				}
			}
		}
		if (joinGameScreen){
			if (getMouseX () > 108 && getMouseX () < 108 + 900){
				if (getMouseY () > 108 && getMouseY () < 108 + 900){
					gameScroll.moveScrollBar(notches, currentlyClicked);// move cursor
					//System.out.println ("yo");
				}
			}
		}

		if (game){
			if (notches < 0){
				for (int i = 0; i > notches; i--){
					player.getWeapon().rotateWeaponReverse(NUM_WEAPON_TYPES);
				}
				System.out.println("Weapon #" + player.getWeapon().getWeapon());
			}
			else if (notches > 0){
				for (int i = 0; i < notches; i++){
					player.getWeapon().rotateWeapon(NUM_WEAPON_TYPES);
				}
				System.out.println("Weapon #" + player.getWeapon().getWeapon());
			}
		}
	}


}
