package application;
import java.util.HashMap;
import java.util.Vector;
	
public class Solution {	

/******************************************   Implementation Here  ***************************************/
public static boolean[] visited= new boolean[9];//Creates an array that will hold the values that have been visited
private static int[] edgeTo = new int[9];//Creates an array that will hold the values with edges connected to the missing value
private static int[] distTo = new int[9];//Creates an array that will holds the path to each value

/*		Implementation here: you need to implement the Breadth First Search Method				 				*/
/*		Please refer the instruction document for this function in details								     	*/

public static void breadthFirstSearch(int[] num, int m, Vector solution)
{
	Queue<Integer> q = new LinkedList<Integer>(); //Creates a queue to perform the breadth first search 
	PuzzleGrid newPuzzle = new PuzzleGrid(num, m); //Creates an object of the class PuzzleGrid
	q.add(m);
	visited[m] = true;
	distTo[m] = 0;
	while(!q.isEmpty()) { //Checks if the queue is empty. If it isn't it performs the breadth first search
		int a = q.remove();
		for(int b : newPuzzle.grid) {//Checks to see if there are adjacent tiles to the missing tile
			if(!visited[b]) {//Checks if the adjacent tiles have already been visited or not
				
				//Check to see the values that are adjacent to the missing value
				//Swaps the array values
				if(newPuzzle.topNeighbor() != null)//If there is a topNeighbor, add that value to the queue
					q.add(b);
				if(newPuzzle.bottomNeighbor() != null)//If there is a bottomNeighbor, add that value to the queue
					q.add(b);
				if(newPuzzle.leftNeighbor() != null)//If there is a leftNeighbor, add that value to the queue
					q.add(b);
				if(newPuzzle.rightNeighbor() != null)//If there is a RightNeighbor, add that value to the queue
					q.add(b);
				
				visited[b] = true;
				edgeTo[b] = a;
				distTo[b] = distTo[a]+1;
				
				// Add all the values from the queue into the vector "solution"
				solution.add(q.poll());
		
	//sill needs th breadth first search
		
       	// Add all the values from the queue into the vector "solution"
		while (!q.isEmpty()) {
           		solution.add(q.poll());
        	}
		
		
    	}//end breadthFirstSearch
}//end class Solution


	//We don't need these two to get it to work. We just need to figure out how the switch with puzzle grid works


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
		
	}//end bestSwitch
	
	public static int indexOfM(int [] num, int m) {
		for (int count = 0; num[count] == m; count++) {
			if (num[count] == m) return count;
		}
		return -1;
	}//end IndexOfM
}//end methods class 
