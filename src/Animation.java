import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;

public class Animation extends JPanel implements Runnable
{
	int x = 0;
	int y = 0;
	public Animation()
	{
		setBackground(Color.WHITE);

		new Thread(this).start();
	}

	public void paint( Graphics window )
	{
		window.setColor(Color.WHITE);

		window.fillRect(0,0,2600,1800);



        window.setColor(Color.yellow);

        window.fillOval(400,400,50,50);
        int[] x1points={425,475,475};
        int[] y1points={425,455,395};
        window.setColor(Color.WHITE);
        window.fillPolygon(x1points,y1points,3);

        window.setColor(Color.yellow);

        window.fillOval(300,400,50,50);
        int[] x2points={325,375,375};
        int[] y2points={425,435,415};
        window.setColor(Color.WHITE);
        window.fillPolygon(x2points,y2points,3);


		x = x + 10;
		//y = y + 10;

		if( x > 2600)
			x = 0;
		//if( y > 800)
			y = 0;

		window.fillRect(x, y, 20, 20);

        window.setColor(Color.YELLOW);
        window.fillOval(x,400,50,50);
        int[] xpoints={x+25,x+75,x+75};
        int[] ypoints={425,475,375};
        window.setColor(Color.WHITE);
        window.fillPolygon(xpoints,ypoints,3);






        //GHOSTS

		
	}
	
	public void run()
	{

		try
		{
			while( true )
			{	
			   Thread.sleep(50);
			   repaint();
			}
		}
		catch( Exception e )
		{
			
		}

	}
}