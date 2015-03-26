package jeff.view;

import javax.swing.*;

import jeff.controller.JeffSampleControl;

public class JeffSampleFrame extends JFrame
{
	private JeffSamplePanel appPanel;
	
	public JeffSampleFrame(JeffSampleControl baseControl)
	{
		appPanel = new JeffSamplePanel(baseControl);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setSize(700, 400);
		this.setContentPane(appPanel);
		this.setVisible(true);
	}
}
