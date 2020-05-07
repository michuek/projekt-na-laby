package OpcjeButtonWindow;

import javax.swing.JFrame;

public class OpcjeWindow extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public OpcjeWindow() 
	{
		super("Opcje");
		setSize(400, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.add(new SpeedOfSimulationSlider());
	}

}
