//package assets;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI extends Applet implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Button start;
	Button retry;
	Button exit;
	Button crazy;
	public static boolean play=true;
	
	
	public void init() {
		if(play==true) {
		start = new Button("START");
		exit = new Button("EXIT");
		crazy = new Button("CRAZY");
		setBackground(Color.black);
		Font font = new Font("Courier", Font.BOLD,25);
		setFont(font);
		start.setBackground(Color.yellow);
		start.setBounds(230, 350, 400, 80);
		exit.setBounds(230, 450, 400, 80);
		crazy.setBounds(230, 350, 400, 80);
		start.addActionListener((ActionListener) this);
		exit.addActionListener((ActionListener) this);
		crazy.addActionListener((ActionListener) this);
		
		add(start);
		add(exit);
		
		setSize(900, 820);
		setLayout(null); 
		System.out.println("Started");
		}
		else if(play==false) {
			retry = new Button("RETRY");
			exit = new Button("EXIT");
			
			setBackground(Color.black);
			Font font = new Font("Courier", Font.BOLD,25);
			setFont(font);
			retry.setBackground(Color.yellow);
			retry.setBounds(230, 450, 400, 80);
			exit.setBounds(230, 550, 400, 80);
			retry.addActionListener((ActionListener) this);
			exit.addActionListener((ActionListener) this);
			
			add(retry);
			add(exit);
			
			setSize(900, 820);
			setLayout(null); 
			System.out.println("Retry?");
		}
	}

	public void paint(Graphics grp) {
		if(play==true) {
		grp.setFont(new Font("Magneto", Font.CENTER_BASELINE,80));
		grp.setColor(Color.yellow);
		grp.drawString("Ping Pong Tennis", 63, 250);
		grp.setFont(new Font("Calibri", Font.PLAIN,20));
		grp.setColor(Color.white);
		grp.drawString("Made By Bhawesh Kr. Verma, Abhishek Kumar Yadav & Co. © 2019", 155, 770);
		grp.setColor(Color.red);
		grp.fillRect(0, 790, 900, 30);
		for(int i=0; i<=900; i+=50) {
		int xt[] = {i, i+50, i+25};
		int yt[] = {790, 790, 810};
		int nop = 3;
		grp.setColor(Color.black);
		grp.fillPolygon(xt, yt, nop);
		}
		grp.dispose();
		}
		
		if(play==false) {
			//GAME_OVER
			grp.setColor(Color.red);
			grp.fillRect(185, 100, 500, 250);
			grp.setFont(new Font("Courier", Font.BOLD,70));
			grp.setColor(Color.white);
			grp.drawString("GAME OVER!", 230, 200);
			
		}
		grp.dispose();
}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start){
			remove(start);
			remove(exit);
			BallBounce ob; 
			ob = new BallBounce();
			add(ob);
			try {
				Thread.sleep(3000);
				play = true;
				ob.init();
				}catch(Exception ex) {}
			}
			
		
		if(e.getSource() == retry){
			play = true;
			remove(retry);
			remove(exit);
			BallBounce ob = new BallBounce();
			ob.init();
			add(ob);
			}
			else if(e.getSource() == exit){
			System.out.println("Game Exit");
			play = false;
			System.exit(0);
			} 
	}
}


