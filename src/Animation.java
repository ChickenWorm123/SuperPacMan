import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;


public class Animation extends JPanel implements Runnable
{
    SuperPacMan_Maze structure= new SuperPacMan_Maze();

	public Animation()
	{
		setBackground(Color.WHITE);

		new Thread(this).start();
	}

	public void paint( Graphics window )
	{
		window.setColor(Color.WHITE);

		window.fillRect(0,0,1500,1800);
        window.setColor(Color.BLUE);

        for(int i=0; i<structure.getR(); i+=1){
            for(int y=0; y<structure.getC(); y+=1){
                if(structure.getGrid()[i][y]=='0'){
                    window.fillRect((y)*48, (i)*48,48,48);
                }
                if(structure.getGrid()[i][y]=='w'){
                    window.setColor(Color.PINK);
                    window.fillRect((y)*48,(i)*48,48,48);
                }
                if(structure.getGrid()[i][y]=='g'){
                    window.setColor(Color.ORANGE);
                    Graphics2D g2 = (Graphics2D) window;
                    Image img1 = Toolkit.getDefaultToolkit().getImage("OrangeGhost.png"); /*the image cannot be in the SRC folder*/
                    g2.drawImage(img1, (y)*48 , (i)*48 , 40 , 60 , this);
                }
                if(structure.getGrid()[i][y]=='.'){
                    window.setColor(Color.YELLOW);
                    window.fillOval(y*48+7,i*48+7,25,25);
                }
                window.setColor(Color.BLUE);


            }


        }








        //window.setColor(Color.yellow);

        //window.fillOval(300,400,50,50);
        //int[] x2points={325,375,375};
        //int[] y2points={425,435,415};
        //window.setColor(Color.WHITE);
        //window.fillPolygon(x2points,y2points,3);

/*
        window.setColor(Color.RED);
        Graphics2D h2 = (Graphics2D) window;
        Image img2 = Toolkit.getDefaultToolkit().getImage("RedGhost.png"); /*the image cannot be in the SRC folder*/
        /*h2.drawImage(img2, 50 , 0 , 40 , 60 , this);

        window.setColor(Color.PINK);
        Graphics2D j2 = (Graphics2D) window;
        Image img3 = Toolkit.getDefaultToolkit().getImage("PinkGhost.png"); /*the image cannot be in the SRC folder*/
        /*j2.drawImage(img3, 100, 0 , 40 , 60 , this);

        window.setColor(Color.BLUE);
        Graphics2D k2 = (Graphics2D) window;
        Image img4 = Toolkit.getDefaultToolkit().getImage("BlueGhost.png"); /*the image cannot be in the SRC folder*/
        //k2.drawImage(img4, 150 , 0 , 40 , 60 , this);

		//x = x + 10;
		//y = y + 10;

		//if( x > 2600)
			//x = 0;
		//if( y > 800)
			//y = 0;




	}

    public class Background extends JPanel
    {


        public void paintComponent( Graphics window )
        {





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