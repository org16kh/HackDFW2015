import javax.swing.JFrame;
import java.awt.event.*;
public class RType extends JFrame
{
	public RType()
	{
		boolean blah = true;
		while(blah == true)
		{
			KeyListener test = new KeyListener();
			add(new Board());
		
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(400,300);
			setLocationRelativeTo(null);
			setTitle("R- Type");
			setResizable(false);
			setVisible(true);
			if()
		}
	}
	public static void main(String [] args)
	{
		new RType();
	}
}
