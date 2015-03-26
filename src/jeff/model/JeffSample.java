package jeff.model;

import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;

public class JeffSample
{
//	public ArrayList<Integer> colorList;
	private ArrayList<Integer> numbersList;
	
//	private void fillTheColors()
//	{
//		colorList.add(Color.BLACK);
//		colorList.add(Color.GREEN);
//		colorList.add(Color.RED);
//		colorList.add(Color.BLUE);
//		colorList.add(Color.YELLOW);
//		colorList.add(Color.ORANGE);
//		colorList.add(Color.GRAY);
//		
//	}
	
	public ArrayList<Integer> arrayListSort(
			ArrayList<Integer> sortedList)
	{
		int comparisonValueLeft;
		int maximumPosition;
		for (int position = 0; position < sortedList.size(); position++)
		{
			maximumPosition = position;
			comparisonValueLeft = sortedList.get(position);
			for (int next = position + 1; next < sortedList.size(); next++)
			{
				if (sortedList.get(next) < position)
				{
					comparisonValueLeft = sortedList.get(next);
					maximumPosition = next;
				}
			}
			if (maximumPosition != position)
			{
				arraySwap(sortedList, position, maximumPosition);
			}
		}

		return sortedList;
	}
	
	private void arraySwap(
			ArrayList<Integer> sortedList, int position, int maximumPosition)
	{
		int temp = sortedList.get(position);
		sortedList.set(position, sortedList.get(maximumPosition));
		sortedList.set(maximumPosition, temp);
	}
}
