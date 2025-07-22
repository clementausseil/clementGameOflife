
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
    JButton startButton;

    
    int width=900;
    int height=800;
    int sqrSize=15;
    int gridSize = 50;
    int total;
    int cellx=0;
    int celly=0;
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

        startButton = new JButton();
        startButton.setText("start");
        startButton.setBounds (770,250, 100,30);
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        this.add(startButton);
        
        
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
        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                if (grid[x][y]) {
                    g.setColor(Color.BLUE);
                    g.fillRect(x * sqrSize + 50, y * sqrSize + 50, sqrSize, sqrSize);
                } else {
                    g.setColor(Color.GRAY);
                    g.fillRect(x * sqrSize + 50, y * sqrSize + 50, sqrSize, sqrSize);
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
        int mousex=e.getX()-50;
        int mousey=e.getY()-50;
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
        for (int x=1; x <= 50; x ++){
            for (int y = 1; y <= 50; y ++){
                cellx=x;
                celly=y;
                countNeighbours(x,y);
                
            }
        }
    }
    
    private int countNeighbours(int x, int y){
        int count =0;
        for (int dx = -1; dx <= 1; dx ++){
            for (int dy = -1; dy <= 1; dy ++){
                if (dx == 0 && dy == 0) continue;  // Skip the cell itself

                int nx = x+dx;
                int ny = y+dy;
                
                // if(grid[cellx+dx][celly]==true||grid[cellx][celly+dy]==true){
                     // count++;
                 // }
                if (nx >= 0 && ny >= 0 && nx < gridSize && ny < gridSize) {
                    if (grid[nx][ny]) {
                        count++;
                    }
                }
            }
        }
        
        System.out.println ("cell: "+cellx+","+celly+" has "+count+" neighbour(s)");
        return count;
    }
}
