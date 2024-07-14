
import java.util.Scanner;

public class Connect_Four {
     static final int ROWS = 6;
     static final int COLUMNS = 6;
     static final char EMPTY = '.';
    static final char PLAYER_ONE = 'X';
     static final char PLAYER_TWO = 'O';
     static char[][] board = new char[ROWS][COLUMNS];

    private static void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = EMPTY;
            }
        }
    }
private static void printBoard() {
        for (int i = 0; i < COLUMNS; i++) {
            System.out.print(i + " ");
             }
        System.out.println();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
 private static void makeMove(char player) {
        Scanner scanner = new Scanner(System.in);
        int column;
        while (true) {
            System.out.print("Enter column (0-5): ");
            column = scanner.nextInt();
            if (column >= 0 && column < COLUMNS && board[0][column] == EMPTY) {
                break;
            }
            System.out.println("Invalid move. Try again.");
        }

        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == EMPTY) {
                board[i][column] = player;
                break;
            }
        }
    }
private static boolean checkWin(char player) {
        // Check horizontally
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS - 3; col++) {
                if (board[row][col] == player && board[row][col + 1] == player &&
                    board[row][col + 2] == player && board[row][col + 3] == player) {
                    return true;
                }
            }
        }

        // Check vertically
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (board[row][col] == player && board[row + 1][col] == player &&
                    board[row + 2][col] == player && board[row + 3][col] == player) {
                    return true;
                }
            }
        }

        // Check diagonally: bottom left to top right
        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS - 3; col++) {
                if (board[row][col] == player && board[row - 1][col + 1] == player &&
                    board[row - 2][col + 2] == player && board[row - 3][col + 3] == player) {
                    return true;
                }
            }
        }

        // Check diagonally: top left-bottom right
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLUMNS - 3; col++) {
                if (board[row][col] == player && board[row + 1][col + 1] == player &&
                    board[row + 2][col + 2] == player && board[row + 3][col + 3] == player) {
                    return true;
                }
            }
        }

        return false;
    }
  // To check if the board is full or not 
    private static boolean isBoardFull() {
        for (int i = 0; i < COLUMNS; i++) {
            if (board[0][i] == EMPTY) {
                return false;
            }
        }
        return true;
    }
    // main method
    public static void main(String[] args) {
        initializeBoard();
        printBoard();

        boolean playerOneTurn = true;
        boolean gameWon = false;

        while (!gameWon && !isBoardFull()) {
            if (playerOneTurn) {
                System.out.println("Player One's turn (X):");
                makeMove(PLAYER_ONE);
            } else {
                System.out.println("Player Two's turn (O):");
                makeMove(PLAYER_TWO);
            }
            printBoard();
            gameWon = checkWin(playerOneTurn ? PLAYER_ONE : PLAYER_TWO);
            playerOneTurn = !playerOneTurn;
        }

        if (gameWon) {
            System.out.println("Player " + (playerOneTurn ? "Two" : "One") + " wins!");
      } else {
           System.out.println("The game is a draw!");
        }
    }
}
