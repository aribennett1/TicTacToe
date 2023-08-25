import java.util.Scanner;

public class TicTacToeGame {
	static Scanner scanner = new Scanner(System.in);
	static boolean playerOneTurn = false;
	static Board board = new Board();

	public static void main(String[] args) {
		char symbol;
		int[] move;
       while (true) {  
            move = getInput();

            if (moveIsValid(move, board).equals("Valid")) {            	
                symbol = (playerOneTurn) ? 'X' : 'O';
                board.updateBoard(move[0], move[1], symbol);
                isGameOver();
            }
        }
    }
	
	public static String getCurrentPlayerName() {
	    return playerOneTurn ? "Player X" : "Player O";
	}

	public static int[] getInput() {        
        int[] move = new int[2];
        
        System.out.print("Enter row (1-3): ");
        move[0] = scanner.nextInt() - 1;

        System.out.print("Enter column (1-3): ");
        move[1] = scanner.nextInt() - 1;
        return move;
    }

    public static String moveIsValid(int[] move, Board board) {
    	int row = move[0];
        int col = move[1];

        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return "Move is out of bounds.";
        }

        if (board.getBoard()[row][col] != ' ') {
            return "The chosen position is already occupied.";
        }

        return "Valid"; // Indicates the move is valid
    }

    public static String isGameOver() {
        char[][] cells = board.getBoard();

        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] != ' ' && cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]) {
                return cells[i][0] + " wins!";
            }
            if (cells[0][i] != ' ' && cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i]) {
                return cells[0][i] + " wins!";
            }
        }
        
        if (cells[0][0] != ' ' && cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) {
            return cells[0][0] + " wins!";
        }
        if (cells[0][2] != ' ' && cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]) {
            return cells[0][2] + " wins!";
        }

        // Check if the board is full (draw)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    return "Not over";
                }
            }
        }

        return "It's a draw!";
    }
}
