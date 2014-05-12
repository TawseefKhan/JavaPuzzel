import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PuzzleFrame extends JFrame implements ActionListener
{
	static LabelTile[][]tiles= new LabelTile[3][3];  
	
	JLabel labelClick;
	JLabel labelClick1;
	JLabel labelTimer;
	JLabel labelTimer1;
	JButton btnResstart;
	

	public PuzzleFrame(){
		
		int y=0;
		
		 for(int i=0;i<3;i++){
			 for(int j=0 ;j<3; j++)
			 {
				if(!((i==2)&&(j==2)))
				{
					int x=i*3+j;
					this.tiles[j][i]= new  LabelTile(new axis(j,i),x);
				 	this.add(tiles[j][i]);
				 	y++;
				}
			 }
		 }
		 
		 	this.btnResstart= new JButton("Restart");
		 	this.btnResstart.setBounds(250, 180, 80, 30);
		 	btnResstart.addActionListener(this);
			this.labelClick = new JLabel("Total You clicked");
			this.labelClick.setBounds(245, 40, 120, 20);
			this.labelClick1 = new JLabel("000");
			this.labelClick1.setBounds(280, 60, 120, 20);
			this.labelTimer = new JLabel("Counter");
			this.labelTimer.setBounds(265, 100, 120, 20);
			this.labelTimer1 = new JLabel("000");
			this.labelTimer1.setBounds(280, 120, 120, 20);
			
			this.add(btnResstart);
			this.add(labelClick);
			this.add(labelClick1);
			this.add(labelTimer);
			this.add(labelTimer1);
			
		    this.setSize(350, 270); 
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("Picture Puzzle ");
			this.setResizable(false);
			this.setLayout(null);
			this.setVisible(true);
			

	}

	public static void shuffel(int x) {
		session.L.setVisible(false);
		
		for(int i=0; i<x; i++)
		{
			Random rand= new Random();
			int r=rand.nextInt(Integer.MAX_VALUE);
			int r2= rand.nextInt(Integer.MAX_VALUE);
			session.time=-1;
			
			if(!((r%3==2)&&(r2%3==2)))
			{
				if(tiles[r%3][r2%3].checkMove())
				{
					axis temp= new axis(tiles[r%3][r2%3].free.x, tiles[r%3][r2%3].free.y);
					tiles[r%3][r2%3].free=tiles[r%3][r2%3].coordinates;
					tiles[r%3][r2%3].coordinates=temp;
				}
			}
			
		}
		
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
			{
				if(!((i==2)&&(j==2)))
				{
					tiles[i][j].setTile(tiles[i][j].coordinates);
				}
				
			}
		session.L.setVisible(true);
	}
	
	public static boolean checkFinish()
	{
		int j=0;
		for(int x=0; x<3; x++)
		{
			for(int y=0; y<3; y++)
			{
				if(!((x==2)&&(y==2)))
				{
					if((tiles[y][x].coordinates.y*3)+tiles[y][x].coordinates.x!=j) return false;
					j++;
				}
			}
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		session.newSession();
	}
	
}