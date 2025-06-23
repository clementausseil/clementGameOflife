
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

    JButton clearButton;
    JButton nextButton;
    
    int width=900;
    int height=800;
    int sqrSize=15;
    int gridSize = 50;
    int total;
    boolean [][] grid= new boolean [60][60];

    /**
     * Constructor for objects of class GameOfLife
     */
    public GameOfLife()
    {
        // initialise instance variables


        // setSize(900, 900);
        // setVisible(true);

        clearButton = new JButton();
        clearButton.setText("clear");
        clearButton.setBounds (770,350, 100,30);
        clearButton.setFocusable(false);
        clearButton.addActionListener(this);
        this.add(clearButton);
        
        nextButton = new JButton();
        nextButton.setText("next");
        nextButton.setBounds (770,300, 100,30);
        nextButton.setFocusable(false);
        nextButton.addActionListener(this);
        this.add(nextButton);

        
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
        //g.setColor(Color.GRAY);
        //g.fillRect(50, 50, 500, 500);
        for (int x = 50; x <= 750; x += sqrSize){
            for (int y = 50; y <= 750; y += sqrSize){
                int squareX= x/sqrSize;
                int squareY = y/sqrSize;
                if (grid[squareX][squareY]==true){
                    g.setColor(Color.BLUE);
                    g.fillRect(x, y, sqrSize, sqrSize);
                }else{
                    g.setColor(Color.GRAY);
                    g.fillRect(x, y, sqrSize, sqrSize);
                }
            }
        }

    }

    public void actionPerformed(ActionEvent e){
        String cmd=e.getActionCommand();
        System.out.println(cmd);
        if(e.getSource()==clearButton){
            for (int x = 0; x <= 55; x ++){
            for (int y = 0; y <= 55; y ++){
                grid [x][y] = false;
            }
            }
            repaint();
        }
        
        if(e.getSource()==nextButton){
        nextGeneration();
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
    
    private void nextGeneration(){
        
    }
    
    private int countNeighbours(){
        int count =0;
        for (int dx = -1; dx <= 1; dx ++){
            for (int dy = -1; dy <= 1; dy ++){
                
            }
            }
        
        System.out.println (count);
        return count;
    }
}
