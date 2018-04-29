package application;
import java.util.HashMap;
import java.util.Vector;



	
public class Solution {
	

	/******************************************   Implementation Here  ***************************************/

	/*			Implementation here: you need to implement the Breadth First Search Method				 				*/
	/*			Please refer the instruction document for this function in details								     	*/
	public static void breadthFirstSearch(int[] num, int m, Vector solution)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(m);
		if(topNeighbor(m) != -1)
			swap(num, m, m+3);
		if(bottomNeighbor(m) != -1)
			swap(num, m, m-3);
		if(leftNeighbor(m) != -1)
			swap(num, m, m+1);
		if(rightNeighbor(m) != -1)
			swap(num, m, m-1);
		
	}
	
		//This method takes the current index of the empty space in the puzzle (m) and returns the index of the puzzle piece on top of it.
	//If the empty puzzle piece is on the top edge the method will return a -1
	public int topNeighbor(int m) {
		if (m < 2 || m > 7) return -1;
		else return m - 3;
	}//end topNeighbor
	
	//This method takes the current index of the empty space in the puzzle (m) and returns the index of the puzzle piece just below it.
	//If the empty puzzle piece is on the bottom edge the method will return a -1
	public int bottomNeighbor(int m) {
		if (m < 0 || m > 4) return -1;
		else return m + 3;
	}//end bottomNeighbor
	
	//This method takes the current index of the empty space in the puzzle (m) and returns the index of the puzzle piece to its left.
	//If the empty puzzle piece is on the left edge the method will return a -1
	public int leftNeighbor(int m){
		if (m % 3 == 1) return -1;
		else return m - 1;
	}//end leftNeighbor
	
	//This method takes the current index of the empty space in the puzzle (m) and returns the index of the puzzle piece to its right.
	//If the empty puzzle piece is on the right edge the method will return a -1
	public int rightNeighbor(int m) {
		if (m % 3 == 0) return -1;
		else return m + 1;
	}//end rightNeighbor
	public static void swap(int[] num, int m, int r) {
		int temp = num[m];
		num[m] = num[r];
		num[r] = temp;
	}
	
	//This method returns the integer of the neighbor that is closest to the index of the best piece to be swapped with the empty space to create a working path.
	//If the index of a neighbor is out of the puzzle (i.e index = -1) then the comparison will always be greater than m's current location and therefore not a valid swap.
	public static int bestSwitch(int top, int bottom, int left, int right, int m) {
		int[] neighbor = {top, bottom, left, right};
		int best = top;
		for (int i = 1; i == 3; i++) {
			if (Math.abs(m - neighbor[i]) < best) 
				best = neighbor[i];
		}//end for loop
		return best;
		
	}
	
	public static int indexOfM(int [] num, int m) {
		for (int count = 0; num[count] == m; count++) {
			if (num[count] == m) return count;
		}
		return -1;
	}
}
