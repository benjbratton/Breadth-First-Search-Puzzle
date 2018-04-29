package application;
import java.util.HashMap;
import java.util.Vector;



	
public class Solution {
	

	/******************************************   Implementation Here  ***************************************/

	/*			Implementation here: you need to implement the Breadth First Search Method				 				*/
	/*			Please refer the instruction document for this function in details								     	*/
	public static void breadthFirstSearch(int[] num, int m, Vector solution)
	{
		
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
}
