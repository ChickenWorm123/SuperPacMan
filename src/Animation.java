import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;


public class Animation extends JPanel implements Runnable
{
    SuperPacMan_Maze structure= new SuperPacMan_Maze();
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

        for(int i=0; i<structure.)
        window.fillRect(, 48,89,48)





        //window.setColor(Color.yellow);

        //window.fillOval(300,400,50,50);
        //int[] x2points={325,375,375};
        //int[] y2points={425,435,415};
        //window.setColor(Color.WHITE);
        //window.fillPolygon(x2points,y2points,3);
        window.setColor(Color.ORANGE);
        Graphics2D g2 = (Graphics2D) window;
        Image img1 = Toolkit.getDefaultToolkit().getImage("OrangeGhost.png"); /*the image cannot be in the SRC folder*/
        g2.drawImage(img1, 0 , 0 , 40 , 60 , this);

        window.setColor(Color.RED);
        Graphics2D h2 = (Graphics2D) window;
        Image img2 = Toolkit.getDefaultToolkit().getImage("RedGhost.png"); /*the image cannot be in the SRC folder*/
        g2.drawImage(img2, 50 , 0 , 40 , 60 , this);

        window.setColor(Color.PINK);
        Graphics2D j2 = (Graphics2D) window;
        Image img3 = Toolkit.getDefaultToolkit().getImage("PinkGhost.png"); /*the image cannot be in the SRC folder*/
        g2.drawImage(img3, 100, 0 , 40 , 60 , this);

        window.setColor(Color.BLUE);
        Graphics2D k2 = (Graphics2D) window;
        Image img4 = Toolkit.getDefaultToolkit().getImage("BlueGhost.png"); /*the image cannot be in the SRC folder*/
        g2.drawImage(img4, 150 , 0 , 40 , 60 , this);


		//x = x + 10;
		//y = y + 10;

		//if( x > 2600)
			x = 0;
		//if( y > 800)
			y = 0;




	}

    public class Background extends JPanel
    {


        public void paintComponent( Graphics window )
        {

            //this allows us to put a png,jpg, or gif
            Graphics2D g2 = (Graphics2D) window;
            Image img1 = Toolkit.getDefaultToolkit().getImage("OrangeGhost.png"); /*the image cannot be in the SRC folder*/
            g2.drawImage(img1, 0 , 0 , 800 , 600 , this);

            Image img2 = Toolkit.getDefaultToolkit().getImage("bob.png"); /*the image cannot be in the SRC folder*/
            g2.drawImage(img2, 350, 50, 100 , 100 , this);

            Image img3 = Toolkit.getDefaultToolkit().getImage("fish.gif"); /*the image cannot be in the SRC folder*/
            g2.drawImage(img3, 400, 300, 100 , 100 , this);


        }


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