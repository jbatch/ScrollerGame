import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Character {

    private String character = "characterRight.png";

    public int dx;
    public int dy;
    private int x;
    private int y;
    private Image image;
    public boolean standing;
    public int gravity;
    private int jumpTimer;
    public boolean walkingLeft;
    public boolean walkingRight;

    public Character() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(character));
        image = ii.getImage();
        x = 60;
        y = 50;
        gravity = 1;
    }
    
    public void setX(int inX)
    {
    	x = inX;
    }
    public void setY(int inY)
    {
    	y = inY;
    }

    public void setDY(int inY)
    {
    	dy = inY;
    }
    
    public void setDX(int inX)
    {
    	dx = inX;
    }
    
    public Rectangle getBounds()
    {
    	return new Rectangle(x+dx,y+dy,20,29);
    }

    public void move() {
    	if (jumpTimer/10 >= 4)
    		dy=0;
    	jumpTimer++;
    	x += dx;
        y += dy;
        if(!standing)
        	y += gravity;
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setImage(String newCharacter) 
    {
    	ImageIcon ii = new ImageIcon(this.getClass().getResource(newCharacter));
        image = ii.getImage();
    }
    
    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
            walkingRight =false;
            walkingLeft = true;
            setImage("characterLeft.png");

        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
            walkingLeft = false;
            walkingRight = true;
            setImage("characterRight.png");

        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }
        
        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
        
        if (key == KeyEvent.VK_SPACE) {
        	if (standing)
        		jumpTimer=0;
            dy = -4;
            standing = false;
            
        }

        
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
        	if(!walkingRight)
            	dx = 0;
            walkingLeft = false;
        }

        if (key == KeyEvent.VK_RIGHT) {
        	if (!walkingLeft)
        		dx = 0;
            walkingRight = false;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }
        
        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
        
        if (key == KeyEvent.VK_SPACE) {
            dy = 0;
            
        }

    }
}