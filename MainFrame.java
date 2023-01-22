import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
	class FinishFrame extends JFrame{
		
		public FinishFrame() {
			setSize(300, 300);
			setLocation(620, 320);
			getContentPane().setBackground(Color.green);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JLabel label = new JLabel("Your score:  " + count);
			label.setFont(new Font("", Font.BOLD, 12));
			JLabel freeLabel1 = new JLabel(" ");
			JLabel freeLabel2 = new JLabel(" ");
			JLabel freeLabel3 = new JLabel(" ");
			JLabel freeLabel4 = new JLabel(" ");
			JLabel freeLabel5= new JLabel(" ");
			JLabel freeLabel6 = new JLabel(" ");
			JLabel freeLabel7= new JLabel(" ");
			
			
			setLayout(new GridLayout(3,3));
			add(freeLabel1);
			add(freeLabel2);
			add(freeLabel3);
			add(freeLabel4);
			add(label);
			add(freeLabel5);
			add(freeLabel6);
			add(freeLabel7);
			
			setVisible(true);
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	
		if(isFirstTime) {

			for(Rectangle r: rectangleList) {
			
				if(r.color.equals("yellow")) {
					g.setColor(Color.yellow);
					g.fillRect(locationOfRectangles[0], locationOfRectangles[1], 10, 10);
				}
			
				else if(r.color.equals("red")) {
					g.setColor(Color.red);
					g.fillRect(locationOfRectangles[2], locationOfRectangles[3], 10, 10);
				}
			
				else if(r.color.equals("blue")) {
					g.setColor(Color.blue);
					g.fillRect(locationOfRectangles[4], locationOfRectangles[5], 10, 10);
				}
			
				else if(r.color.equals("orange")) {
					g.setColor(Color.orange);
					g.fillRect(locationOfRectangles[6], locationOfRectangles[7], 10, 10);
				}
			
				else if(r.color.equals("green")) {
					g.setColor(Color.green);
					g.fillRect(locationOfRectangles[8], locationOfRectangles[9], 10, 10);
				}
			}		
			
			//isFirstTime = false;
		}
		
	}
	
	public MainFrame() {
		setSize(515, 538);
		setLocation(500, 200);
		getContentPane().setBackground(Color.black);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(new KeyboardListener());
		addMouseListener(new MouseListener());
		
		setVisible(true);
	}

	
	static ArrayList<Rectangle> rectangleList = new ArrayList<Rectangle>();
	boolean isFirstTime = true;
	static int[] locationOfRectangles = new int[10]; // blackX,black - 
	boolean isContinued = true;
	int count = 0;
	
	public static void main(String[] args) {

		MainFrame object = new MainFrame();
		MainFrame.Rectangle blackObject = object.new Rectangle("yellow");
		MainFrame.Rectangle redObject = object.new Rectangle("red");
		MainFrame.	Rectangle blueObject = object.new Rectangle("blue");
		MainFrame.Rectangle orangeObject = object.new Rectangle("orange");
		MainFrame.Rectangle greenObject = object.new Rectangle("green");
		
		locationOfRectangles[0] = blackObject.locationX;
		locationOfRectangles[1] = blackObject.locationY;
		locationOfRectangles[2] = redObject.locationX;
		locationOfRectangles[3] = redObject.locationY;
		locationOfRectangles[4] = blueObject.locationX;
		locationOfRectangles[5] = blueObject.locationY;
		locationOfRectangles[6] = orangeObject.locationX;
		locationOfRectangles[7] = orangeObject.locationY;
		locationOfRectangles[8] = greenObject.locationX;
		locationOfRectangles[9] = greenObject.locationY;
		
	
		MainFrame.RedThread redThread = object.new RedThread();
		MainFrame.BlueThread blueThread = object.new BlueThread();
		MainFrame.OrangeThread orangeThread = object.new OrangeThread();
		MainFrame.GreenThread greenThread = object.new GreenThread();
		
		MainFrame.TimeThread timeThread = object.new TimeThread();
		
		timeThread.start();
		redThread.start();
		greenThread.start();
		blueThread.start();
		orangeThread.start();
		
		rectangleList.add(blackObject);
		rectangleList.add(redObject);
		rectangleList.add(blueObject);
		rectangleList.add(greenObject);
		rectangleList.add(orangeObject);
		
		
	}
	
	class MouseListener implements MouseInputListener,MouseMotionListener{

		@Override
		public void mouseClicked(MouseEvent e) {
		
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
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class KeyboardListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			 // left-37 up-38 right-39 down-40
		
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if(locationOfRectangles[0] == locationOfRectangles[2] && locationOfRectangles[1] == locationOfRectangles[3]) {
				isContinued = false;
				return;
			}
			
			if(locationOfRectangles[0] == locationOfRectangles[4] && locationOfRectangles[1] == locationOfRectangles[5]) {
				isContinued = false;
				return;
			}
			
			if(locationOfRectangles[0] == locationOfRectangles[6] && locationOfRectangles[1] == locationOfRectangles[7]) {
				isContinued = false;
				return;
				
			}
			
			if(locationOfRectangles[0] == locationOfRectangles[8] && locationOfRectangles[1] == locationOfRectangles[9]) {
				isContinued = false;
				return;
			}
			
			if(e.getKeyCode() == 37){
				
				if(locationOfRectangles[0] == 7) {
					return;
				}
				
				
				locationOfRectangles[0] =  locationOfRectangles[0] -10;
				repaint();
				
				if(locationOfRectangles[0] == locationOfRectangles[2] && locationOfRectangles[1] == locationOfRectangles[3]) {
					isContinued = false;
					return;
				}
				
				if(locationOfRectangles[0] == locationOfRectangles[4] && locationOfRectangles[1] == locationOfRectangles[5]) {
					isContinued = false;
					return;
				}
				
				if(locationOfRectangles[0] == locationOfRectangles[6] && locationOfRectangles[1] == locationOfRectangles[7]) {
					isContinued = false;
					return;
					
				}
				
				if(locationOfRectangles[0] == locationOfRectangles[8] && locationOfRectangles[1] == locationOfRectangles[9]) {
					isContinued = false;
					return;
				}
				
			}
			
			else if(e.getKeyCode() == 38){
				
				if(locationOfRectangles[1] == 30) {
					return;
				}
				
				locationOfRectangles[1] =  locationOfRectangles[1] -10;
				repaint();
				
				if(locationOfRectangles[0] == locationOfRectangles[2] && locationOfRectangles[1] == locationOfRectangles[3]) {
					isContinued = false;
					return;
				}
				
				if(locationOfRectangles[0] == locationOfRectangles[4] && locationOfRectangles[1] == locationOfRectangles[5]) {
					isContinued = false;
					return;
				}
				
				if(locationOfRectangles[0] == locationOfRectangles[6] && locationOfRectangles[1] == locationOfRectangles[7]) {
					isContinued = false;
					return;
					
				}
				
				if(locationOfRectangles[0] == locationOfRectangles[8] && locationOfRectangles[1] == locationOfRectangles[9]) {
					isContinued = false;
					return;
				}
				
			}
			
			else if(e.getKeyCode() == 39){
				
				if(locationOfRectangles[0] == 507-10) {
					return;
				}
				
				locationOfRectangles[0] =  locationOfRectangles[0] +10;
				repaint();
				
				if(locationOfRectangles[0] == locationOfRectangles[2] && locationOfRectangles[1] == locationOfRectangles[3]) {
					isContinued = false;
					return;
				}
				
				if(locationOfRectangles[0] == locationOfRectangles[4] && locationOfRectangles[1] == locationOfRectangles[5]) {
					isContinued = false;
					return;
				}
				
				if(locationOfRectangles[0] == locationOfRectangles[6] && locationOfRectangles[1] == locationOfRectangles[7]) {
					isContinued = false;
					return;
					
				}
				
				if(locationOfRectangles[0] == locationOfRectangles[8] && locationOfRectangles[1] == locationOfRectangles[9]) {
					isContinued = false;
					return;
				}
			}
			
			else if(e.getKeyCode() == 40){
				
				if(locationOfRectangles[1] == 530-10) {
					return;
				}
				
				locationOfRectangles[1] =  locationOfRectangles[1] +10;
				repaint();
				
				if(locationOfRectangles[0] == locationOfRectangles[2] && locationOfRectangles[1] == locationOfRectangles[3]) {
					isContinued = false;
					return;
				}
				
				if(locationOfRectangles[0] == locationOfRectangles[4] && locationOfRectangles[1] == locationOfRectangles[5]) {
					isContinued = false;
					return;
				}
				
				if(locationOfRectangles[0] == locationOfRectangles[6] && locationOfRectangles[1] == locationOfRectangles[7]) {
					isContinued = false;
					return;
					
				}
				
				if(locationOfRectangles[0] == locationOfRectangles[8] && locationOfRectangles[1] == locationOfRectangles[9]) {
					isContinued = false;
					return;
				}
				
			}
		}

	}
	
	class TimeThread extends Thread{
		public TimeThread(){
			
		}
		
		@SuppressWarnings("static-access")
		public void run() {
			
			while(isContinued) {
				if(locationOfRectangles[0] == locationOfRectangles[2] && locationOfRectangles[1] == locationOfRectangles[3]) {
					isContinued = false;
					break;
				}
				try {
					this.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				count += 1;
			}
			new FinishFrame();
			
		}
	}
	
	class RedThread extends Thread{
		public RedThread(){
			
		}
		
		@SuppressWarnings("static-access")
		public void run() {
			
			while(isContinued) {
				
				if(locationOfRectangles[1] == locationOfRectangles[3] && (locationOfRectangles[0] == locationOfRectangles[2])) {
					isContinued = false;
					return;
				}
				
				try {
					this.sleep(120);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// y coordinates are equal
				if(locationOfRectangles[1] == locationOfRectangles[3]) {
					
					// x coordinates are equal
					if(locationOfRectangles[0] == locationOfRectangles[2]) {
						isContinued = false;
					}
					
					//x coordinates are not equal
					else {
						
						if(locationOfRectangles[0] > locationOfRectangles[2]) {
							locationOfRectangles[2] = locationOfRectangles[2] + 10;
						}
						else if(locationOfRectangles[0] < locationOfRectangles[2]) {
							locationOfRectangles[2] = locationOfRectangles[2] - 10;
						}
					}
	
				}
				
				// y coordinates are not equal.
				else if(locationOfRectangles[1] != locationOfRectangles[3]) {
					
					if(locationOfRectangles[1] > locationOfRectangles[3]) {
						locationOfRectangles[3] = locationOfRectangles[3] + 10;
					}
					else if(locationOfRectangles[1] < locationOfRectangles[3]) {
						locationOfRectangles[3] = locationOfRectangles[3] - 10;
					}
					
				}
					
				repaint();
			}
			
		}
	}
	
	class BlueThread extends Thread{
		public BlueThread(){
		}
		
		@SuppressWarnings("static-access")
		public void run() {
			while(isContinued) {
				if(locationOfRectangles[0] == locationOfRectangles[4] && locationOfRectangles[1] == locationOfRectangles[5] ) {
					isContinued = false;
					return;
				}
				try {
					this.sleep(150);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// x coordinates are equal
				if(locationOfRectangles[0] == locationOfRectangles[4]) {
					
					// y coordinates are equal
					if(locationOfRectangles[1] == locationOfRectangles[5]) {
						isContinued = false;
					}
					
					//y coordinates are not equal
					else {
						
						if(locationOfRectangles[1] > locationOfRectangles[5]) {
							locationOfRectangles[5] = locationOfRectangles[5] + 10;
						}
						else if(locationOfRectangles[1] < locationOfRectangles[5]) {
							locationOfRectangles[5] = locationOfRectangles[5] - 10;
						}
					}
	
				}
				
				// x coordinates are not equal.
				else if(locationOfRectangles[0] != locationOfRectangles[4]) {
					
					if(locationOfRectangles[0] > locationOfRectangles[4]) {
						locationOfRectangles[4] = locationOfRectangles[4] + 10;
					}
					else if(locationOfRectangles[0] < locationOfRectangles[4]) {
						locationOfRectangles[4] = locationOfRectangles[4] - 10;
					}
					
				}
					
				repaint();
			}
			
			
		}
	}
	
	class OrangeThread extends Thread{
		public OrangeThread(){
			
		}
		
		@SuppressWarnings("static-access")
		public void run() {
			
			while(isContinued) {
				if(locationOfRectangles[0] == locationOfRectangles[6] && locationOfRectangles[1] == locationOfRectangles[7])
				{
					isContinued = false;
					return;
				}
				try {
					this.sleep(130);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// x coordinates are equal
				if(locationOfRectangles[0] == locationOfRectangles[6]) {
					
					// y coordinates are equal
					if(locationOfRectangles[1] == locationOfRectangles[7]) {
						isContinued = false;
					}
					
					//y coordinates are not equal
					else {
						
						if(locationOfRectangles[1] > locationOfRectangles[7]) {
							locationOfRectangles[7] = locationOfRectangles[7] + 10;
						}
						else if(locationOfRectangles[1] < locationOfRectangles[7]) {
							locationOfRectangles[7] = locationOfRectangles[7] - 10;
						}
					}
	
				}
				
				// x coordinates are not equal.
				else if(locationOfRectangles[0] != locationOfRectangles[6]) {
					
					if(locationOfRectangles[0] > locationOfRectangles[6]) {
						locationOfRectangles[6] = locationOfRectangles[6] + 10;
					}
					else if(locationOfRectangles[0] < locationOfRectangles[6]) {
						locationOfRectangles[6] = locationOfRectangles[6] - 10;
					}
					
				}
					
				repaint();
			}
			
		}
	}
	
	class GreenThread extends Thread{
		public GreenThread(){
			
		}
		
		@SuppressWarnings("static-access")
		public void run() {
			
			while(isContinued) {
				if(locationOfRectangles[1] == locationOfRectangles[9] && locationOfRectangles[0] == locationOfRectangles[8] )
				{
					isContinued = false;
					return ;
				}
					
					try {
					this.sleep(170);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// y coordinates are equal
				if(locationOfRectangles[1] == locationOfRectangles[9]) {
					
					// x coordinates are equal
					if(locationOfRectangles[0] == locationOfRectangles[8]) {
						isContinued = false;
					}
					
					//x coordinates are not equal
					else {
						
						if(locationOfRectangles[0] > locationOfRectangles[8]) {
							locationOfRectangles[8] = locationOfRectangles[8] + 10;
						}
						else if(locationOfRectangles[0] < locationOfRectangles[8]) {
							locationOfRectangles[8] = locationOfRectangles[8] - 10;
						}
					}
	
				}
				
				// y coordinates are not equal.
				else if(locationOfRectangles[1] != locationOfRectangles[9]) {
					
					if(locationOfRectangles[1] > locationOfRectangles[9]) {
						locationOfRectangles[9] = locationOfRectangles[9] + 10;
					}
					else if(locationOfRectangles[1] < locationOfRectangles[9]) {
						locationOfRectangles[9] = locationOfRectangles[9] - 10;
					}
					
				}
					
				repaint();
			}
			
		}
	}
	
	
	class Rectangle{
		int locationX,locationY;
		String color;
		
		public Rectangle(String c) {
			
		
			color = c;
			
			if(color.equals("yellow")) { // 250x250 at the middle
				locationX = 250+7;
				locationY = 250+30;
			}
			
			
			else if(color.equals("red")) { // left and up
				locationX = 7;
				locationY = 30;
			}
			
			else if(color.equals("blue")) { // right and up
				locationX = 500-10+7;
				locationY = 30;
			}
			
			else if(color.equals("orange")) { // left and down
				locationX = 7;
				locationY = 500+30-10;
			}
			
			else if(color.equals("green")) { // right and down
				locationX = 500-10+7;
				locationY = 500+30-10;
			}
		
			
		}
		
	}
	
}
