
/**
 * Write a description of class GameOfLife here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
public class GameOfLife extends JFrame implements ActionListener, MouseListener
{
    // instance variables - replace the example below with your own

    JButton myButton;
    int width=900;
    int height=900;
    int sqrSize=15;
    int gridSize = 50;
    int total;
    boolean [][] grid= new boolean [gridSize+1][gridSize+1];

    /**
     * Constructor for objects of class GameOfLife
     */
    public GameOfLife()
    {
        // initialise instance variables


        // setSize(900, 900);
        // setVisible(true);

        myButton = new JButton();
        myButton.setText("clear");
        myButton.setBounds (650,300, 200,30);
        myButton.setFocusable(false);
        myButton.addActionListener(this);
        this.add(myButton);

        
        addMouseListener(this);
        this.getContentPane().setPreferredSize(new Dimension(width,height));
        this.getContentPane().setLayout(null);        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.toFront();
        this.setVisible(true);


        for (int x = 0; x <= gridSize; x ++){
            for (int y = 0; y <= gridSize; y ++){
                grid [x][y] = false;
            }
        }
    }

    public void paint(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(20, 40, 600, 580);
        for (int x = 50; x <= 750; x += sqrSize){
            for (int y = 50; y <= 750; y += sqrSize){
                int squareX= x/sqrSize;
                int squareY = y/sqrSize;
                if (grid[squareX][squareY]==true){
                    g.setColor(Color.BLUE);
                    g.fillRect(x, y, sqrSize, sqrSize);
                }else{
                    g.setColor(Color.black);
                    g.drawRect(x, y, sqrSize, sqrSize);
                }
            }
        }

    }

    public void actionPerformed(ActionEvent e){
        String cmd=e.getActionCommand();
        System.out.println(cmd);
        repaint();
        if(e.getSource()==myButton){
            for (int x = 0; x <= gridSize; x ++){
            for (int y = 0; y <= gridSize; y ++){
                grid [x][y] = false;
            }
        }
        repaint();
        }
    }

    public void mouseExited(MouseEvent e){System.out.println("exit");}
    public void mouseEntered(MouseEvent e){System.out.println("enter");}
    public void mouseReleased(MouseEvent e){System.out.println("release");}
    public void mousePressed(MouseEvent e){System.out.println("press");}

    public void mouseClicked(MouseEvent e){
        int mousex=e.getX();
        int mousey=e.getY();
        int col;
        int row;

        System.out.println("click at"+mousex+", "+mousey);
        if (mousey>50&&mousey<750
        &&mousex>50&&mousex<750){
            col = mousex/sqrSize;
            row = mousey/sqrSize;
            grid [col][row]=!grid[col][row];
            repaint();
        }
    }
}
