package application;
import java.util.HashMap;
import java.util.Vector;
	
public class Solution {	

	/******************************************   Implementation Here  ***************************************/
	public static boolean[] visited= new boolean[9];
	private static int[] edgeTo = new int[9];
	private static int[] distTo = new int[9];
	/*			Implementation here: you need to implement the Breadth First Search Method				 				*/
	/*			Please refer the instruction document for this function in details								     	*/
	public static void breadthFirstSearch(int[] num, int m, Vector solution)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		PuzzleGrid newPuzzle = new PuzzleGrid(num, m);
		q.add(m);
		visited[m] = true;
		distTo[m] = 0;
		while(!q.isEmpty()) {
			int a = q.remove();
			for(int b : newPuzzle.grid) {
				if(!visited[b]) {
					if(newPuzzle.topNeighbor() != null)
						q.add(b);
					if(newPuzzle.bottomNeighbor() != null)
						q.add(b);
					if(newPuzzle.leftNeighbor() != null)
						q.add(b);
					if(newPuzzle.rightNeighbor() != null)
						q.add(b);
					//q.add(b);
					visited[b] = true;
					edgeTo[b] = a;
					distTo[b] = distTo[a]+1;
					solution.add(a);
				}
			}	
		}
       		// Initialize vector called "solution"
        	Vector<Integer> solution = new Vector<>();
		
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
