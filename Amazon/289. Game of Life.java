import java.util.*;

public class gameOfLife {

	public static void main(String[] args) {
		int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		gameOfLife(board);
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

	static int[][] directions = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 },
			{ -1, -1 } };
	static int[][] ob;
	public static void gameOfLife(int[][] board) {
		 ob = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int ans = helper(board, i, j);
				System.out.println("for element " + i +" and " + j + " " + ans);
				if (board[i][j] == 0) {
					if (ans == 3) {
						ob[i][j] = 1;
					}
				} else {
					if (ans < 2) {
						ob[i][j] = 0;
					} else if (ans == 2 || ans == 3) {
						ob[i][j] = 1;
					} else if (ans > 3) {
						ob[i][j] = 0;
					}
				}
			}
		}
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				board[i][j] = ob[i][j];
			}
		}
	
	}

	public static int helper(int[][] board, int i, int j) {
		int liveCells = 0;
		for (int[] d : directions) {
			if (i + d[0] >= 0 && i + d[0] < board.length && j + d[1] >= 0 && j + d[1] < board[0].length
					&& board[i + d[0]][j + d[1]] == 1) {
				liveCells++;
			}
		}
		return liveCells;

	}

}
