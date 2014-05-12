import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class LabelTile extends JButton implements ActionListener {
	
	public static axis free= new axis(2,2);
	public axis coordinates;
	
	public LabelTile(axis c,int x)
	{
		coordinates=c;
		this.setBounds(coordinates.x*80, coordinates.y*80, 80, 80);
		this.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/"+x+".jpg"))));
		this.addActionListener(this);
	}
	
	public void setTile(axis c)
	{
		coordinates=c;
		this.setBounds(coordinates.x*80, coordinates.y*80, 80, 80);
	}

	public void moveTile() {
		if(checkMove())
		{
			session.clicked();
			
			axis temp= new axis(free.x, free.y);
			free=coordinates;
			coordinates=temp;
			this.setBounds(coordinates.x*80, coordinates.y*80, 80, 80);			
			if((free.x==2)&&(free.y==2))
				if(PuzzleFrame.checkFinish())
					session.newSession();
		}
	}
	
	public boolean checkMove() {
		
		int x= LabelTile.free.x-this.coordinates.x;
		int y= LabelTile.free.y-this.coordinates.y;
		if((((x==1)||(x==-1))&&(y==0))||(((y==1)||(y==-1))&&(x==0))) return true;
		
		return false;
	}
	
	//click listener-------------------------------------------------------------------------------------------------------

	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		LabelTile L= (LabelTile)o;
		L.moveTile();
		
	}


}
