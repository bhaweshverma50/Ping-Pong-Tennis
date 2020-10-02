//package assets;

import java.applet.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallBounce extends Applet implements Runnable, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int width,height,x,y,dx,dy,size,speed,widths,width2s,heights;
	final double GRAVITY = 0.5;
	//private int score=0;
	//private int totalTiles = 40;
	int inxBX = 0;
	int inxBY = 0;
    //int a[] = {5};
	//int b[] = {10};
	//int arr[] = new int[10];
	final double SPEED = .1;
	public boolean leftAccel = false;
	public boolean rightAccel = false;
	public boolean cleftAccel = false;
	public boolean crightAccel = false;
	double xps, yps, xVel, yVel, xcs, ycs, cxVel;
	public boolean timer = true;
	public boolean retry;
	//MainUI ob = new MainUI();
	Thread t1 = new Thread(this);
	
	public void init() {
		setSize(900, 785);
		t1.start();
	}
	
	
	public BallBounce(){
		System.out.println("Play");
		retry = false;
		speed=50;
		width=880;
		widths = 120;
		width2s = 60;
		heights = 15;
		height=770;
		x=430;
		xcs = 370;
		xps = 370;
		xVel = 0;
		cxVel=0;
		yVel = 0;
		y=350;
		yps = 770;
		ycs = 5;
		size=20;
		dx=3;
		dy=2;
		//for(int i = 0; i<10;i++) {
			//arr[i] = 20+inxBX;
			//inxBX += 86;
	//	}
		this.addKeyListener(this);
		
	}
	

public void paint(Graphics grp){
	/*if(timer == true) {
		
			try{
				//Slider o = new Slider();
				//o.init();
				//add(o);
				MainUI.play = false;
				grp.setFont(new Font("Courier", Font.BOLD,70));
				grp.setColor(Color.red);
				grp.drawString("3", 430, 350);
				Thread.sleep(1000);
				grp.setColor(Color.black);
				grp.drawString("3", 430, 350);
				grp.setColor(Color.red);
				grp.drawString("2", 430, 350); 
				Thread.sleep(1000);
				grp.setColor(Color.black);
				grp.drawString("2", 430, 350);
				grp.setColor(Color.red);
				grp.drawString("1", 430, 350);
				Thread.sleep(1000);
				grp.setColor(Color.black);
				grp.drawString("1", 430, 350);
				grp.setColor(Color.red);
				grp.drawString("START!", 330, 350);
				Thread.sleep(1000);
				grp.setColor(Color.black);
				grp.drawString("START!", 330, 350);
				timer=false;
				MainUI.play = true;
			}
			catch(InterruptedException e){}
		}*/
	
	
	if(MainUI.play == true) {
		grp.setColor(Color.green);
		grp.fillOval(x,y,size,size);
		grp.setColor(Color.blue);
		grp.fillRect((int)xps, (int)yps, widths, heights);
		grp.fillRect((int)xcs, (int)ycs, widths, heights);
		grp.setColor(Color.yellow);
		grp.fillRect(0, 400, 900, 5);
		grp.drawOval(350, 320, 180, 180);
		grp.setColor(Color.white);
		grp.setFont(new Font("Courier", Font.BOLD,18));
		grp.drawString("Player1: A(Left) & D(Right)", 5, 780);
		grp.drawString("Player2: Left(Left) & Right(Right)", 5, 13);
		//grp.setColor(Color.cyan);
		/*for(int i = 0; i<=9; i++) { 
			//System.out.println(arr[i]);
			grp.fillRect(arr[i], 20, 80, 25);
		}*/
		grp.dispose();
	}
	
	/*if(retry == true && MainUI.play == true) {						//RETRY
		System.out.println("Paint Retry: "+retry);
		grp.setColor(Color.green);
		grp.fillOval(x,y,size,size);
		//grp.setColor(Color.yellow);
		//grp.fillRect(0, 0, 900, 30);
		grp.setColor(Color.blue);
		grp.fillRect((int)xs, (int)ys, widths, heights);
		grp.setColor(Color.cyan);
		for(int i = 0; i<=9; i++) { 
			//System.out.println(arr[i]);
			grp.fillRect(arr[i], 20, 80, 25);
		}
	}*/
	
	/*if(MainUI.play == false) {										//GAME_OVER
		//retry=false;
		grp.setColor(Color.red);
		grp.fillRect(185, 200, 500, 250);
		grp.setFont(new Font("Courier", Font.BOLD,70));
		grp.setColor(Color.white);
		grp.drawString("GAME OVER!", 230, 300);
		for(size=20; size>=0; size--) {
			grp.setColor(Color.black);
			grp.fillOval(x, y, size, size);
			grp.setColor(Color.cyan);
			grp.fillOval(x, y, size-2, size-2);
			try{
				Thread.sleep(100);
			}
			catch(InterruptedException e){}
		}
	}*/
	try{
		Thread.sleep(5);
	}
	catch(InterruptedException e){}
	
}

public void keyPressed(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_A) {
		leftAccel = true;
	} else if (e.getKeyCode() == KeyEvent.VK_D) {
		rightAccel = true;
	} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		cleftAccel = true;
	} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		crightAccel = true;
	}
}


public void run(){

	while(MainUI.play){

		repaint();
		x+=dx;
		y+=dy;
		if(x<=0 || x>=width)
			dx*=-1;
		if(y>=heights+730 && x>=xps && x<=xps+widths) {
			dy*=-1;
			dx*=+1.5;
		}
		if(y<=heights && x>=xcs && x<=xcs+widths) {
			dy*=-1;
			dx*=-1.8;
		}
		
		
		if(y>=760 || y<=0) {
			dy*=0;
			dx*=0;
			MainUI.play = false;
			System.out.println("Game Over");
			MainUI ob = new MainUI();
			ob.init();
			add(ob);
		}
		
		
		try{
			Thread.sleep(100/speed);
		}
		catch(InterruptedException e){}
		
		
			if (!leftAccel && !rightAccel)
				xVel *= GRAVITY; 
			if (!cleftAccel && !crightAccel)
				cxVel *= GRAVITY; 
			if (leftAccel) {
				//System.out.println(xps+","+yps);
				xVel -= SPEED;
				}
			if (cleftAccel) {
				//System.out.println(xps+","+yps);
				cxVel -= SPEED;
				}
			if (rightAccel)
			{
				//System.out.println(xps+","+yps);
				xVel += SPEED;
			}
			if (crightAccel)
			{
				//System.out.println(xps+","+yps);
				cxVel += SPEED;
			}
			
			xps += xVel;
			xcs += cxVel;
			
			if (xps >= 760)
				xps -= 1;
			else if (xps <= 30)
				xps += 1;
			if (xcs >= 760)
				xcs -= 1;
			else if (xcs <= 30)
				xcs += 1;
		
	try{
		Thread.sleep(5);
	}
	catch(InterruptedException e){}
		}
	}





public void keyReleased(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_A) {
		leftAccel = false;
	} else if (e.getKeyCode() == KeyEvent.VK_D) {
		rightAccel = false;
	}
	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		cleftAccel = false;
	} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		crightAccel = false;
	}
}


@Override
public void keyTyped(KeyEvent arg0) {}
}
