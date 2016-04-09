import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main extends JFrame implements KeyListener {
	int spot=(int) (Math.random()*1500+120);
	int spot2=(int) (Math.random()*1500+120);
	int spot3=(int) (Math.random()*1500+120);
	boolean gameStart=false;
	boolean bckground=false;
	boolean jumpDesc=false;
	boolean jump=false;
	String path2;
	String path;
	String path3;
    private BufferedImage background;
    private BufferedImage character;
    private BufferedImage obstacle;
    private int x = 30;
    private int y = 630;
    int z=y;
    private final int dim1=1800; 
    private final int dim2=768;
    int stepcounter=0;
    public Main() {
        setTitle("PTE-Worlds");
        setSize(dim1, dim2);
         load();
        setVisible(true);
    }
 
    public void load() {
        try {
        	path = "C:\\Users\\tseit_000\\Desktop\\HackDFW\\Puya\\sonic.png";
        	background = ImageIO.read(new File(path));
            path3 = "C:\\Users\\tseit_000\\Desktop\\HackDFW\\Puya\\spikes.png";
            obstacle = ImageIO.read(new File(path3));

        } catch (IOException ex) {}
        addKeyListener(this);
    }
    @Override
    public void paint(Graphics g) {
    	if(z>720)
    		System.exit(0);
    	if(x>=1800){
    		x=0;
    		 //g.drawImage(obstacle, 30,630,this);
    	}
    	if(!jump)
    	path2 = "C:\\Users\\tseit_000\\Desktop\\HackDFW\\Puya\\step"+stepcounter+".png";
    	try {
			character = ImageIO.read(new File(path2));
		} catch (IOException e) {}
    	if(stepcounter==11)
    		stepcounter=1;
    	stepcounter++;
        g.drawImage(background, 0, 0, this);
        g.drawImage(character, x, z, this);
        if(x==0){
        	spot=(int) (Math.random()*1500+140);
        	spot2=(int) (Math.random()*1500+140);
        	spot3=(int) (Math.random()*1500+140);
        }
        g.drawImage(obstacle,spot,670,this);
        g.drawImage(obstacle,spot3,670,this);
        g.drawImage(obstacle,spot2,670,this);       
        Toolkit.getDefaultToolkit().sync();
       	g.dispose();
       	if(gameStart)
       		loopRun();
       	if(jump)
       		jump();
       	if(jumpDesc)
       		fall();
       	if(x<=spot+35&&x>=spot-35&&z<=670&&z>=565 )
       		System.exit(0);
    	if(x<=spot2+35&&x>=spot2-35&&z<=670&&z>=565 )
    		System.exit(0);
    	if(x<=spot3+35&&x>=spot3-35&&z<=670&&z>=565 )
    		System.exit(0);  
    }
 
    public static void main(String args[]) {
        new Main();
    }
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W     : loopRun();gameStart=true;break;
            case KeyEvent.VK_SPACE: 
            if((!jump)&&(!jumpDesc)&&z!=510){
            	jump=true;
            	gameStart=true;
            	jump();
            }
           	break;
            case KeyEvent.VK_ESCAPE: System.exit(0);repaint();break;
        }
    }
    public void keyTyped(KeyEvent test) {}
    public void loopRun(){
    	while(x<dim1){
            	x=x+15;
            	try {
            		Thread.sleep(30);
            		} 
            	catch (InterruptedException e1) {}
            	repaint();
            	break;
            	}
    }
    public void jump(){
    	while(z>y-130){
    		z=z-10;
    		x=x+0;
    		try {
        		Thread.sleep(5);
        		} 
        	catch (InterruptedException e1) {}
        	repaint();
        	break;
    	}
    	if(z==y-130){
    		jumpDesc=true;
    		fall();
    		jump=false;
    	}
    }
    public void fall(){
    	jump=false;
    	while(z!=y){
    		z=z+10;
    		try {
        		Thread.sleep(0);
        		} 
        	catch (InterruptedException e1) {}
        	repaint();                            
        	break;
    	} 
    	if(z==y){
    		jumpDesc=false;
    	}
    }
    public void keyReleased(KeyEvent test) {}
}
