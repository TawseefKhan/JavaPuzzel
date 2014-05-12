import javax.swing.JOptionPane;


public class session extends Thread {
	static int time;
	static int clicks;
	static PuzzleFrame L;
	
	public session() {
		time=-1;
		L=new PuzzleFrame();
		Thread T= new Thread(this);
		T.start();
	}
	
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(1000);
				if(time>=0) 
				{
					time++;
					L.labelTimer1.setText(time+"");	
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void newSession()
	{
		int x=time;
		if(time!=-1)JOptionPane.showMessageDialog(L,"Your Time:  " + x + " \nYour Clicks:  " + clicks);
		L.shuffel(500);
		time=-1;
		time=0;
		clicks=0;
		L.labelTimer1.setText(time+"");
		L.labelClick1.setText("0");
	}

	public static void clicked() {
		clicks++;
		L.labelClick1.setText(clicks+"");
		
	}
}
