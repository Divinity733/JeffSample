package jeff.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import jeff.controller.JeffSampleControl;

public class JeffSamplePanel extends JPanel
{
	private JeffSampleControl baseControl;
	private SpringLayout baseLayout;
	private JScrollPane textPane;
	private JButton searchArray;
	private JButton randomColors;
	private JButton clearText;
	private JTextArea displayArea;
	private JTextField inputField;
	
	public JeffSamplePanel(JeffSampleControl baseControl)
	{
		this.baseControl = baseControl;
		
		searchArray = new JButton("Search");
		randomColors = new JButton("CLICK ME!");
		clearText = new JButton("Clear");
		inputField = new JTextField(20);
		baseLayout = new SpringLayout();
		displayArea = new JTextArea(15, 35);
		textPane = new JScrollPane(displayArea);
		
		setupPane();
		setupPanel();
		setupLayout();
		heyListen();
	}
	
	private void setupPane()
	{
		displayArea.setLineWrap(true);
		displayArea.setWrapStyleWord(true);
		displayArea.setEditable(false);
		displayArea.setBackground(Color.BLACK);
		displayArea.setForeground(Color.WHITE);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.YELLOW);
		this.add(textPane);
		this.setSize(700, 400);
		this.add(searchArray);
		this.add(randomColors);
		this.add(clearText);
		this.add(inputField);
		inputField.setBackground(Color.RED);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, 150, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, textPane, -100, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textPane, 270, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, searchArray, 41, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, searchArray, -500, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, searchArray, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, searchArray, -61, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, randomColors, -61, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, randomColors, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, randomColors, 195, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, randomColors, -323, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 98, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, searchArray);
		baseLayout.putConstraint(SpringLayout.SOUTH, inputField, 168, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, clearText, 1, SpringLayout.EAST, this);
	}
	
	private void heyListen()
	{
		searchArray.addActionListener(new ActionListener()
		{
			public void actionPerformed(
					ActionEvent click)
			{
				String currentInput = inputField.getText();
				if(currentInput.equalsIgnoreCase("Load"))
				{
					String rawArray = "";
					for (int number : baseControl.getArrayList())
					{
						rawArray += number + " ";
					}
					ArrayList<Integer> sortedIntegers = baseControl.getJeefs().arrayListSort(baseControl.getArrayList());
					
					rawArray = "";
					for(int number : sortedIntegers)
						rawArray += number + " ";
					displayArea.setText(rawArray);
					inputField.setText(null);
				}
				else
				{
					displayArea.setText("ERROR 404..."
							+"\nJeff is a dork!  LOL!  :)");
					inputField.setText(null);
				}
			}
		});
		
//		randomColors.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(
//					ActionEvent click)
//			{
//				int randomPosition = (int) (Math.random() * baseControl.getJeefs().colorList.size());
//				
//				baseLayout.setBackground(baseControl.getJeefs().colorList.get(randomPosition));
//			}
//		});
		
		clearText.addActionListener(new ActionListener()
		{
			public void actionPerformed(
					ActionEvent click)
			{
				displayArea.setText(null);
				inputField.setText(null);
			}
		});
	}
}