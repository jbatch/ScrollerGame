import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Skeleton extends JFrame {
	Board myBoard;
	
    public Skeleton() {
    	myBoard = new Board();
        add(myBoard);
        setTitle("Scroller score: 0");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(32*myBoard.map[0][0].length + 16, 32*myBoard.map[0].length + 62);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
        
        JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem newGame = new JMenuItem("New Game");
		JMenuItem exitGame = new JMenuItem("Exit");
		newGame.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent event)
            {
            	myBoard.resetMap();           	
            }
        });
		exitGame.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent event)
            {
            	System.exit(0);           	
            }
        });
		file.add(newGame);
		file.add(exitGame);
		menubar.add(file);
		setJMenuBar(menubar);

    }
    public static void main(String[] args) {
        new Skeleton();
    }
}