package gomkupackage;

import java.awt.*;
import javax.swing.*;

//this is the actual board
public class Board extends JPanel implements BoardProperties {
	public void launch(){
		//setting frame
		JFrame frame = new JFrame();
		frame.setTitle("Gomoku Game!");
		frame.setResizable(false);//one window size
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(3);
		frame.setSize(850, 700);
		frame.setLayout(new BorderLayout());
		this.setBackground(new Color(213, 176,146));
		frame.add(this, BorderLayout.CENTER);
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.DARK_GRAY);
		panel1.setPreferredSize(new Dimension(150, 0));
		JLabel la2 = new JLabel
				("<html>Player vs Player<br>Gomoku Game!"
						+ "<br><br><br><br>Author:"
						+ "<br>Jesse Meng"
						+ "<br><br><br><br>Click anywhere to"
						+ "<br>place piece"
						+ "<br>current player's "
						+ "<br>colour is indicated"
						+ "<br>to the left of this"
						+ "<br><br><br><br>word :)</html>");
		la2.setFont(new Font("Verdana",5,14));
		la2.setForeground(new Color(213, 176,146));
		panel1.add(la2);
		frame.add(panel1, BorderLayout.EAST);
		frame.setVisible(true);
		//Mouse detection
		BoardListener blistener = new BoardListener(this);
		this.addMouseListener(blistener);
	}
	public void paint(Graphics graphics){
		super.paint(graphics);
		Graphics2D twodGraphics = (Graphics2D) graphics;
		//drawing the board lines
		for(int i = 0; i < ROW; ++i){
			twodGraphics.drawLine(X, Y+i*SIZE, X+SIZE*(COLUMN-1), Y+i*SIZE);
		}
		for(int i = 0; i < COLUMN; ++i){
			twodGraphics.drawLine(X+i*SIZE,Y,X+i*SIZE, Y+SIZE*(ROW-1));
		}
		//drawing the pieces
		for(int i = 0; i < pieces.length; i++){
            for(int j = 0; j < pieces[i].length; j++)  
            {  
                if(pieces[i][j] != 0)  
                {  
                    if(pieces[i][j]%2 != 0)  
                    {  
                        graphics.setColor(Color.black);  
                    }else  
                    {  
                        graphics.setColor(Color.white);  
                    }  
                    int x = Y+j*SIZE-SIZE/2;  
                    int y = X+i*SIZE-SIZE/2;  
                    twodGraphics.fillOval(x, y, SIZE, SIZE); 
                }  
            }
		}
		//black starts first
		graphics.setColor(Color.black); 
		twodGraphics.fillOval(645, 310, SIZE, SIZE);
	}
	public static void main(String[] args){
		Board theBoard = new Board();
		theBoard.launch();
	}
}
