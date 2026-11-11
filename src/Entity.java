import java.awt.*;
public class Entity extends Canvas {

    private int x,y,speed;

    public Entity(int xx, int yy, int sspeed){
        xx=x;
        yy=y;
        sspeed=speed;

    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int newspeed){
        speed=newspeed;
    }
    public void setY(int newy){
        y=newy;
    }
    public void setX(int newx){
        x=newx;
    }

    public boolean intersects(Entity other){

    }


























}
