package gomkupackage;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BoardListener extends MouseAdapter implements BoardProperties {
	private GameJudge judge;
	private Board board;
	private Graphics2D twodgraphics;
	private int locationx,locationy;
	private int num = 1;
	public BoardListener(Board board){
		this.board = board;
		twodgraphics = (Graphics2D)this.board.getGraphics();
	}
	public void mouseReleased(MouseEvent event){
		//extracting location of click
		locationx = event.getX();
		locationy = event.getY();
		int row = (locationy-Y+SIZE/2)/SIZE;
		int column = (locationx - X + SIZE/2)/SIZE;
		
		if(row < ROW && column < COLUMN)  
        {  
			//you can only go on places that don't already have a piece
            if(pieces[row][column] == 0)  
            {  
                locationx = X+column*SIZE-SIZE/2;  
                locationy = Y+row*SIZE-SIZE/2;      
                //current turn's color
                if(num%2 != 0 )  
                {  
                	twodgraphics.setColor(Color.black);  
                }else  
                {  
                	twodgraphics.setColor(Color.white);  
                }  
                pieces[row][column] = num;  
                twodgraphics.fillOval(locationx, locationy, SIZE, SIZE);  
                judge = new GameJudge(row,column);  
                judge.judge();  
                num++;  
                //setting the turn indicator piece to the next color
                if(num%2 != 0 )  
                {  
                	twodgraphics.setColor(Color.black);  
                }else  
                {  
                	twodgraphics.setColor(Color.white);  
                }  
                twodgraphics.fillOval(645, 310, SIZE, SIZE);
             }  
        }  
    }  
}
