
public aspect Referee {
    private pointcut playerMove():
        execution(String TicTacToeGame.moveIsValid(int[], Board));

    private pointcut gameCompletion():
        call(String TicTacToeGame.isGameOver());     

    after() returning(String result): playerMove() {
        if (!result.equals("Valid")) {
            System.out.println("Invalid move: " + result + " Please try again.");
        } 
    }
    
    before() : execution(public static void main(String[])) {
    	nextMove();
    }

    after() returning(String result) : gameCompletion() {
        if (result.endsWith("wins!")) {
            System.out.println("Player " + result);
            TicTacToeGame.board.displayBoard();
            System.exit(0);
        } else if (result.equals("It's a draw!")) {
            System.out.println(result);
            TicTacToeGame.board.displayBoard();
            System.exit(0);
        } else {
        	nextMove();
        }
    }
    
    private void nextMove() {
    	TicTacToeGame.playerOneTurn = !TicTacToeGame.playerOneTurn;
    	System.out.println(TicTacToeGame.getCurrentPlayerName() + "'s turn.");
        TicTacToeGame.board.displayBoard();
    }
}
