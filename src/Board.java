import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Image;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private static Character character;
    private Image[] ii = new Image[3];
    private int score;
    private int level = 0;

    
    
    public static int[][][] map =  
    	{	
    			{
    				{1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1},
    				{1 ,0 ,0 ,0 ,0 ,0 ,2 ,2 ,2 ,2, 2 ,2 ,2 ,0 ,0 ,0 ,0 ,0 ,1},
    				{1 ,0 ,0 ,0 ,0 ,0 ,1 ,1 ,1 ,1, 1 ,1 ,1 ,0 ,0 ,0 ,0 ,0 ,1},
    				{1 ,2 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0, 0 ,0 ,1 ,0 ,0 ,0 ,0 ,3 ,1},
    				{1 ,2 ,0 ,1 ,1 ,0 ,0 ,0 ,0 ,0, 0 ,0 ,1 ,0 ,0 ,0 ,0 ,1 ,1},
    				{1 ,2 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0, 0 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,1},
    				{1 ,0 ,0 ,2 ,0 ,0 ,0 ,0 ,1 ,1, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,1},
    				{1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0, 1 ,1 ,0 ,0 ,0 ,0 ,0 ,0 ,1},
    				{1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0, 2 ,0 ,0 ,0 ,0 ,0 ,0 ,2 ,1},
    				{1 ,0 ,0 ,0 ,0 ,2 ,0 ,0 ,1 ,1, 1 ,1 ,0 ,0 ,0 ,1 ,0 ,2 ,1},
    				{1 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0, 0 ,0 ,0 ,1 ,0 ,0 ,0 ,2 ,1},
    				{1 ,0 ,1 ,1 ,1 ,2 ,0 ,0 ,2 ,2, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,2 ,1},
    				{1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1, 1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1}
    			},
    			{
    				{1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1},
    				{1 ,3 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0, 0 ,2 ,2 ,1 ,2 ,0 ,0 ,0 ,1},
    				{1 ,1 ,1 ,1 ,0 ,0 ,0 ,0 ,0 ,0, 0 ,2 ,2 ,1 ,2 ,0 ,0 ,0 ,1},
    				{1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0, 0 ,1 ,1 ,1 ,2 ,0 ,0 ,0 ,1},
    				{1 ,0 ,2 ,0 ,1 ,2 ,2 ,2 ,1 ,1, 0 ,0 ,0 ,1 ,1,1 ,0 ,1 ,1},
    				{1 ,0 ,2 ,0 ,0 ,1 ,1 ,1 ,2 ,1, 0 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,1},
    				{1 ,0 ,2 ,0 ,0 ,0 ,0 ,0 ,0 ,0, 0 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,1},
    				{1 ,0 ,2 ,0 ,0 ,0 ,2 ,2 ,1 ,1, 1 ,1 ,1 ,0 ,0 ,0 ,0 ,0 ,1},
    				{1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0, 0 ,0 ,2 ,1 ,1 ,1 ,0 ,0 ,1},
    				{1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0, 1 ,1 ,0 ,0 ,0 ,1 ,0 ,1 ,1},
    				{1 ,2 ,0 ,2 ,1 ,0 ,0 ,0 ,0 ,0, 2 ,1 ,0 ,0 ,0 ,1 ,0 ,2 ,1},
    				{1 ,2 ,0 ,2 ,1 ,0 ,0 ,0 ,0 ,1, 2 ,1 ,0 ,2 ,2 ,2 ,0 ,2 ,1},
    				{1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1, 1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1}
    			}
    			
    
    	};
    
    public static int[][] originalMap =  {	
		{1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1},
		{1 ,0 ,0 ,0 ,0 ,0 ,2 ,2 ,2 ,2, 2 ,2 ,2 ,0 ,0 ,0 ,0 ,0 ,1},
		{1 ,0 ,0 ,0 ,0 ,0 ,1 ,1 ,1 ,1, 1 ,1 ,1 ,0 ,0 ,0 ,0 ,0 ,1},
		{1 ,2 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0, 0 ,0 ,1 ,0 ,0 ,0 ,0 ,3 ,1},
		{1 ,2 ,0 ,1 ,1 ,0 ,0 ,0 ,0 ,0, 0 ,0 ,1 ,0 ,0 ,0 ,0 ,1 ,1},
		{1 ,2 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0, 0 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,1},
		{1 ,0 ,0 ,2 ,0 ,0 ,0 ,0 ,1 ,1, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,1},
		{1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0, 1 ,1 ,0 ,0 ,0 ,0 ,0 ,0 ,1},
		{1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0, 2 ,0 ,0 ,0 ,0 ,0 ,0 ,2 ,1},
		{1 ,0 ,0 ,0 ,0 ,2 ,0 ,0 ,1 ,1, 1 ,1 ,0 ,0 ,0 ,1 ,0 ,2 ,1},
		{1 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0, 0 ,0 ,0 ,1 ,0 ,0 ,0 ,2 ,1},
		{1 ,0 ,1 ,1 ,1 ,2 ,0 ,0 ,2 ,2, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,2 ,1},
		{1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1, 1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1}};
    public Board() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        character = new Character();

        timer = new Timer(5, this);
        timer.start();
        ii[0] =  (new ImageIcon(this.getClass().getResource("block.png"))).getImage();
        ii[1] =  (new ImageIcon(this.getClass().getResource("coin.png"))).getImage();
        ii[2] =  (new ImageIcon(this.getClass().getResource("flag.png"))).getImage();

    }

    public void resetMap()
    {
    	for (int y=0;y<map[0].length;y++)
        {	
        	for (int x=0;x<map[0][0].length;x++)
        	{
        		map[0][y][x] = originalMap[y][x];	
        			
        	}
        }
    	character.setX(60);
    	character.setY(50);
    	score = 0;
    	level = 0;
		((JFrame)(this.getParent().getParent().getParent().getParent())).setTitle("Scroller Score: " + score);

    }
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        
        for (int y=0;y<map[0].length;y++)
        {	
        	for (int x=0;x<map[0][0].length;x++)
        	{
        		if (map[level][y][x] != 0)	
        			g2d.drawImage(ii[map[level][y][x] - 1], 0 + 32*x, 0 + 32*y, this);
        	}
        }
        
        
        
        g2d.drawImage(character.getImage(), character.getX(), character.getY(), this);
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
        checkCollision();
        character.move();
        repaint();  
    }

    public void checkCollision()
    {
    	Rectangle rCharacter = character.getBounds();
    	Rectangle rWall;
    	//check feet are over floor
    	if((map[level][(character.getY() + 29 + character.dy)/32][(character.getX() +1)/32] == 1) || (map[level][(character.getY() + 29 + character.dy)/32][(character.getX() + 19)/32] == 1))
    	{
    		character.setY(character.getY() + (-1 * character.dy));

    		character.setDY(0);
			character.standing = true;
    	}
    	//check feet are over air
    	else
    	{
			character.standing = false;
    	}
    	//if wall to your left
    	if((map[level][(character.getY() + 27)/32][(character.getX() + character.dx + 1)/32] ==   1) || (map[level][(character.getY())/32][(character.getX() + character.dx)/32] == 1))
    	{
    		character.setX(character.getX() + (-2 * character.dx));
    		character.setDX(0);
    	}
    	//if wall to your right
    	if((map[level][(character.getY() + 27)/32][(character.getX() + character.dx + 19)/32] == 1) || (map[level][(character.getY())/32][(character.getX() + 20 + character.dx)/32] == 1))
    	{
    		character.setX(character.getX() + (-2 * character.dx));
    		character.setDX(0);
    	}
    	//if wall above head
    	if((map[level][(character.getY() + 6)/32][(character.getX() + 1)/32] == 1) || (map[level][(character.getY() + 6)/32][(character.getX() + 19)/32] == 1))
    	{
    		character.setDY(0);
			character.standing = false;
    	}
    	
    	//if air to your left
    	if((map[level][(character.getY() + 28)/32][(character.getX() + character.dx)/32] == 0) && (map[level][(character.getY())/32][(character.getX() + character.dx)/32] == 0))
    	{
    		if (character.walkingLeft && !character.standing)
    			character.setDX(-1);
    	}
    	//if air to your right
    	if((map[level][(character.getY() + 28)/32][(character.getX() + character.dx + 20)/32] == 0) && (map[level][(character.getY())/32][(character.getX() + 20 + character.dx)/32] == 0))
    	{
    		if (character.walkingRight && !character.standing)
    			character.setDX(1);
    	}
    	
    	//coin collect
    	if((map[level][(character.getY() + 14)/32][(character.getX() + 10)/32] == 2))
    	{
    		map[level][(character.getY() + 14)/32][(character.getX() + 10)/32] = 0;
    		score++;
    		((JFrame)(this.getParent().getParent().getParent().getParent())).setTitle("Scroller Score: " + score);
    	}
    	
    	//flag
    	if((map[level][(character.getY() + 14)/32][(character.getX() + 10)/32] == 3))
    	{
    		level++;
    		if (level == map.length)
    			level = 0;
    	}
    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
        	character.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
        	character.keyPressed(e);
        }
    }

}