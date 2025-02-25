//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.*;
import static java.lang.System.*;

public class HistoList
{
	private HistoNode histoNode;

	public HistoList( )
	{
		histoNode = null;
	}

	//addLetter will add a new node to the front for let if let does not exist
	//addLetter will bump up the count if let already exists
	public void addLetter(char let)
	{
		// Check if the letter already exists in the list
		int index = indexOf(let);
		if (index != -1)
		{
			// If it exists, increment the count
			HistoNode node = nodeAt(index);
			node.setLetterCount(node.getLetterCount() + 1);
		}
		else
		{
			// If it doesn't exist, add a new node to the front
			histoNode = new HistoNode(let, 1, histoNode);
		}
	}

	//returns the index pos of let in the list if let exists
	public int indexOf(char let)
	{
		HistoNode currentHisto = histoNode;
		int index = 0;

		while (currentHisto != null)
		{
			if (currentHisto.getLetter() == let)
			{
				return index;
			}
			currentHisto = currentHisto.getNext();
			index++;
		}


		return -1;
	}

	//returns a reference to the node at spot
	private HistoNode nodeAt(int spot)
	{
		HistoNode currentHisto = histoNode;
		int index = 0;

		while (currentHisto != null && index < spot)
		{
			currentHisto = currentHisto.getNext();
			index++;
		}

		return currentHisto;
	}

	//returns a string will all values from list
	public String toString()
	{
		String output = "";
		HistoNode currentHisto = histoNode;

		while (currentHisto != null)
		{
			output += currentHisto.getLetter() + " - " + currentHisto.getLetterCount() + " ";
			currentHisto = currentHisto.getNext();
		}

		return output;
	}
}
