package gomkupackage;

import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;

//This judge goes through all of the possible winning cases to detect if the game is over 
public class GameJudge implements BoardProperties {
	private JFrame frame;  
    private int locationx,locationy;  
    private int count;  
      
    public GameJudge(int x,int y)  
    {  
        this.locationx = x;  
        this.locationy = y;  
        count = 1;  
        frame = new JFrame();  
        frame.setTitle("Game Ends");  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(3);  
        frame.setSize(450,300);  
    }  
      
    public void judge()  
    {  
        count = 1;  
        //vertical check
        for(int i = locationx+1; i < COLUMN; i++)  
        {  
            if(pieces[i][locationy] != 0 )  
            {  
                if((pieces[locationx][locationy]%2) == (pieces[i][locationy]%2))  
                {  
                    count++;  
                }else break;  
            }else break;  
        }  
        for(int i = locationx-1; i >= 0; i--)  
        {  
            if(pieces[i][locationy] != 0 )  
            {  
                if((pieces[locationx][locationy]%2) == (pieces[i][locationy]%2))  
                    count++;  
                else break;  
            }else break;  
        }  
        if(count>=5)  
        {  
            if(pieces[locationx][locationy]%2 != 0)  
            {  
                JLabel label = new JLabel("Black Wins!!!");  
                label.setPreferredSize(new Dimension(400,250));  
                label.setFont(new Font("Serif",1,50));  
                frame.add(label);  
                frame.setVisible(true);  
            }else   
            {  
                JLabel label = new JLabel("White Wins!!!");  
                label.setPreferredSize(new Dimension(400,250));  
                label.setFont(new Font("Serif",1,50));  
                frame.add(label);  
                frame.setVisible(true);  
            }  
            return ;  
        }  
        count = 1;  
        //horizontal check
        for(int i = locationy+1; i < ROW; i++)  
        {  
            if(pieces[locationx][i] != 0 )  
            {  
                if((pieces[locationx][locationy]%2) == (pieces[locationx][i])%2)  
                    count++;  
                else break;  
            }else break;  
        }  
        for(int i = locationy-1; i >= 0; i--)  
        {  
            if(pieces[locationx][i] != 0 )  
            {  
                if(pieces[locationx][locationy]%2 == pieces[locationx][i]%2)  
                    count++;  
                else break;  
            }else break;  
        }  
        if(count>=5)  
        {  
            if(pieces[locationx][locationy]%2 != 0)  
            {  
                JLabel label = new JLabel("Black Wins!!!");  
                label.setPreferredSize(new Dimension(400,250));  
                label.setFont(new Font("Serif",1,50));  
                frame.add(label);  
                frame.setVisible(true);  
            }else   
            {  
                JLabel label = new JLabel("White Wins!!!");  
                label.setPreferredSize(new Dimension(400,250));  
                label.setFont(new Font("Serif",1,50));  
                frame.add(label);  
                frame.setVisible(true);  
            }  
            return ;  
        }  
      
        count = 1;  
        //diagonal check - top left to bottom right
        for(int i = locationx-1,j = locationy-1;i>=0 && j>=0; --i,--j)  
        {  
            if(pieces[i][j] != 0 )  
            {  
                if((pieces[locationx][locationy]%2) == (pieces[i][j]%2))  
                    count++;  
                else break;  
            }else break;  
        }  
        for(int i = locationx+1,j = locationy+1;i<COLUMN&&j<ROW; i++,j++)  
        {  
            if(pieces[i][j] != 0 )  
            {  
                if((pieces[locationx][locationy]%2) == (pieces[i][j]%2))  
                    count++;  
                else break;  
            }else break;  
        }  
        if(count>=5)  
        {  
            if(pieces[locationx][locationy]%2 != 0)  
            {  
                JLabel label = new JLabel("Black Wins!!!");  
                label.setPreferredSize(new Dimension(400,250));  
                label.setFont(new Font("Serif",1,50));  
                frame.add(label);  
                frame.setVisible(true);  
            }else   
            {  
                JLabel label = new JLabel("White Wins!!!");  
                label.setPreferredSize(new Dimension(400,250));  
                label.setFont(new Font("Serif",1,50));  
                frame.add(label);  
                frame.setVisible(true);  
            }  
            return ;  
        }  
        count = 1;  
        //diagonal check - bottom left to top right
        for(int i = locationx-1,j = locationy+1;i>=0&&j<ROW; i--,j++)  
        {  
            if(pieces[i][j] != 0 )  
            {  
                if((pieces[locationx][locationy]%2) == (pieces[i][j]%2))  
                    count++;  
                else break;  
            }else break;  
        }  
        for(int i = locationx+1,j = locationy-1;i<COLUMN&&j>=0; i++,j--)  
        {  
            if(pieces[i][j] != 0 )  
            {  
                if((pieces[locationx][locationy]%2) == (pieces[i][j]%2))  
                    count++;  
                else break;  
            }else break;  
        }  
        if(count>=5)  
        {  
            if(pieces[locationx][locationy]%2 != 0)  
            {  
                JLabel label = new JLabel("Black Wins");  
                label.setPreferredSize(new Dimension(400,250));  
                label.setFont(new Font("Serif",1,50));  
                frame.add(label);  
                frame.setVisible(true);  
            }else   
            {  
                JLabel label = new JLabel("White Wins");  
                label.setPreferredSize(new Dimension(400,250));  
                label.setFont(new Font("Serif",1,50));  
                frame.add(label);  
                frame.setVisible(true);  
            }  
            return ;  
        }  
    }  
}
