import java.applet.*;
import java.awt.*;
public class BallApplet extends Applet implements Runnable
{
	public void init()
	{
		
	}
	public void start()
	{
		//define a new thread
		Thread th = new Thread(this);
		//start the thread
		th.start();
	}
	public void stop()
	{
		//lower ThreadPriority
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		//run a long while(true) this means in our case ""always"
		while(true)
		{
			repaint();
			try
			{
				//Stop the thread for 20 milliseconds
				Thread.sleep(20);
			}
			catch(InterruptedException ex)
			{
				//do nothing
			}
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
	}
	public void run()
	{
		while(true)
		{
			x_pos++;
			
		}
	}
	public void paint(Graphics g)
	{
		//set color
		g.setColor(Color.red);
		//paint a filled colored circle
		g.fillOval(x_pos - radius, y_pos-radius, 2*radius, 2*radius);
	}
	int x_pos = 10;
	int y_pos = 100;
	int radius = 20;
	
}
