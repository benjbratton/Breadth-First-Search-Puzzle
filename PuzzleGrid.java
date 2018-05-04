package application;

public class PuzzleGrid {
	public static int[] grid;
	private static int m;
	public PuzzleGrid(int[] num, int a) {
		PuzzleGrid.grid = num;
		PuzzleGrid.m = a;
	}
	
	//This method takes the current index of the empty space in the puzzle (m) and returns the index of the puzzle piece on top of it.
	//If the empty puzzle piece is on the top edge the method will return a -1
	public int[] topNeighbor() {
		if (grid[m] != 0 || grid[m] != 1 || grid[m] != 2) {
			return swap(m-3);
		}
		return null;
	}//end topNeighbor
	
	//This method takes the current index of the empty space in the puzzle (m) and returns the index of the puzzle piece just below it.
	//If the empty puzzle piece is on the bottom edge the method will return a -1
	public int[] bottomNeighbor() {
		if (grid[m] != 6 || grid[m] != 7 || grid[m] != 8) {
			return swap(grid[m+3]);
		}
		return null;
	}//end bottomNeighbor
	
	//This method takes the current index of the empty space in the puzzle (m) and returns the index of the puzzle piece to its left.
	//If the empty puzzle piece is on the left edge the method will return a -1
	public int[] leftNeighbor(){
		if (grid[m] != 0 || grid[m] != 3 || grid[m] != 6) {
			return swap(grid[m-1]);
		}
		return null;
	}//end leftNeighbor
		
	//This method takes the current index of the empty space in the puzzle (m) and returns the index of the puzzle piece to its right.
	//If the empty puzzle piece is on the right edge the method will return a -1
	public int[] rightNeighbor() {
		if (grid[m] != 2 || grid[m] != 5 || grid[m] != 8) {
			return swap(grid[m+1]);
		}
		return null;
	}//end rightNeighbor
	public int[] swap(int r) {
		int temp = grid[m];
		grid[m] = grid[r];
		grid[r] = temp;
		return grid;
	}
}
