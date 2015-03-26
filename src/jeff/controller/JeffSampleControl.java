package jeff.controller;

import java.awt.Color;
import java.util.ArrayList;

import jeff.model.*;
import jeff.view.JeffSampleFrame;

public class JeffSampleControl
{	
	private JeffSample myJeefs;
	private JeffSampleFrame jeefsFrame;
	private int[] wholeNumbers;
	private ArrayList<Integer> numbersList;
	
	public JeffSampleControl()
	{
		myJeefs = new JeffSample();
		jeefsFrame = new JeffSampleFrame(this);
		numbersList = new ArrayList<Integer>();
		
	}
	
	public JeffSample getJeefs()
	{
		return myJeefs;
	}
	
	public JeffSampleFrame getJeefsFrame()
	{
		return jeefsFrame;
	}
	
	public int[] getWholeNumbers()
	{
		return wholeNumbers;
	}
	
	public void setWholeNumbers(
			int[] wholeNumbers)
	{
		this.wholeNumbers = wholeNumbers;
	}
	
	public ArrayList<Integer> getArrayList()
	{
		return numbersList;
	}
	
	public void setArrayList(
			ArrayList<Integer> numbersList)
	{
		this.numbersList = numbersList;
	}
	
	public void start()
	{
		fillTheArrays();
	}
	
	private void fillTheArrays()
	{
		randomArrayListArray();
	}
	
	private void randomArrayListArray()
	{
		wholeNumbers = new int[10];
		for (int spot = 0; spot < wholeNumbers.length; spot++)
		{
			int myRandom = (int) (Math.random() * 36000);
			wholeNumbers[spot] = myRandom;
			numbersList.add(myRandom);
		}
	}
}
