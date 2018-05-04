package application;
import java.util.HashMap;
import java.util.Vector;
	
public class Solution {	

	/******************************************   Implementation Here  ***************************************/
	private static boolean[] marked;
	private static int[] edgeTo;
	private static int[] distTo;
	/*			Implementation here: you need to implement the Breadth First Search Method				 				*/
	/*			Please refer the instruction document for this function in details
	*/
	public static void breadthFirstSearch(int[] num, int m, Vector solution){
		// Initialize queue called "q"
		Queue<Integer> q = new LinkedList<Integer>();
		PuzzleGrid newPuzzle = new PuzzleGrid(num, m);
		q.add(m);
		System.out.println(newPuzzle.topNeighbor());
		while(!q.isEmpty()) {
			int a = q.remove();
			for(int b : newPuzzle.grid) {
				if(!marked[b]) {
					q.add(b);
					marked[b] = true;
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

public class methods(){ //this section being its own class may need to be reconsidered
		if(topNeighbor(m) != -1) {
			int a = swap(num, m, m+3);
			q.add(a);
			System.out.println("a = " + a + "\t m = " + m);
		}
	
		if(bottomNeighbor(m) != -1) {
			int b = swap(num, m, m-3);
			q.add(b);
			System.out.println("b = " + b);
		}
			
		if(leftNeighbor(m) != -1) {
			int c = swap(num, m, m+1);
			q.add(c);
			System.out.println("c = " + c);
		}
			
		if(rightNeighbor(m) != -1) {
			int d = swap(num, m, m-1);
			q.add(d);
			System.out.println("d = " + d);
		}
			
		//This method takes the current index of the empty space in the puzzle (m) and returns the index of the puzzle piece on top of it.
		//If the empty puzzle piece is on the top edge the method will return a -1
		public static int[] topNeighbor(int num[], int m) {
			if (m == 0 || m == 1 || m == 2) {
				num[0] = -1;
				return num;
			}
			else return swap(num, m, m+3);
		}//end topNeighbor
		
		//This method takes the current index of the empty space in the puzzle (m) and returns the index of the puzzle piece just below it.
		//If the empty puzzle piece is on the bottom edge the method will return a -1
		public static int[] bottomNeighbor(int num[], int m) {
			if (m == 6 || m == 7 || m == 8) {
				num[0] = -1;
				return num;
			}
			else return swap(num, m, m-3);
		}//end bottomNeighbor
		
		//This method takes the current index of the empty space in the puzzle (m) and returns the index of the puzzle piece to its left.
		//If the empty puzzle piece is on the left edge the method will return a -1
		public static int[] leftNeighbor(int num[], int m){
			if (m == 0 || m == 3 || m == 6) {
				num[0] = -1;
				return num;
			}
			else return swap(num, m, m+1);
		}//end leftNeighbor
		
		//This method takes the current index of the empty space in the puzzle (m) and returns the index of the puzzle piece to its right.
		//If the empty puzzle piece is on the right edge the method will return a -1
		public static int[] rightNeighbor(int num[], int m) {
			if (m == 2 || m == 5 || m == 8) {
				num[0] = -1;
				return num;
			}
			else return swap(num, m, m-1);
		}//end rightNeighbor
		public static int[] swap(int[] num, int m, int r) {
			int temp = num[m];
			num[m] = num[r];
			num[r] = temp;
			return num;
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
		
	}//end bestSwitch
	
	public static int indexOfM(int [] num, int m) {
		for (int count = 0; num[count] == m; count++) {
			if (num[count] == m) return count;
		}
		return -1;
	}//end IndexOfM
}//end methods class
