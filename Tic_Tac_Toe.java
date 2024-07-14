
import java.util.Scanner; 
import java.util.Random;

class Tic_Tac_Toe {
//method for printing TicTacToe Board
    public static void printBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
   //Updating the board after player's/computer's turn
    public static void updateBoard(int position, int player, char[][] gameBoard) {

        char character;

        if (player == 1) {
            character = 'X';
        } else {
            character = 'O';
        }

        switch (position) {
            case 1:
                gameBoard[0][0] = character;
                break;
            case 2:
                gameBoard[0][2] = character;
                break;
            case 3:
                gameBoard[0][4] = character;
                break;
            case 4:
                gameBoard[1][0] = character;
                break;
            case 5:
                gameBoard[1][2] = character;
                break;
            case 6:
                gameBoard[1][4] = character;
                break;
            case 7:
                gameBoard[2][0] = character;
                break;
            case 8:
                gameBoard[2][2] = character;
                break;
            case 9:
                gameBoard[2][4] = character;
                break;
            default:
                break;
        }
        printBoard(gameBoard);
    }
//user input as player's move
    public static void playerMove(char[][] gameBoard, Scanner sc) {
        System.out.println("Please make a move. (1-9)");
        int move = sc.nextInt();

        while (!isValidMove(move, gameBoard)) {
            System.out.println("Sorry! Invalid Move. Try again");
            move = sc.nextInt();
        }

        System.out.println("Player moved at position " + move);
        updateBoard(move, 1, gameBoard);
    }
//checking if the player's move is valid or not
    public static boolean isValidMove(int move, char[][] gameBoard) {
        switch (move) {
            case 1:
                return gameBoard[0][0] == '_';
            case 2:
                return gameBoard[0][2] == '_';
            case 3:
                return gameBoard[0][4] == '_';
            case 4:
                return gameBoard[1][0] == '_';
            case 5:
                return gameBoard[1][2] == '_';
            case 6:
                return gameBoard[1][4] == '_';
            case 7:
                return gameBoard[2][0] == '_';
            case 8:
                return gameBoard[2][2] == '_';
            case 9:
                return gameBoard[2][4] == '_';
            default:
                return false;
        }
    }
//computer move using random class
    public static void computerMove(char[][] gameBoard) {
        Random r = new Random();
        int move = r.nextInt(9) + 1;

        while (!isValidMove(move, gameBoard)) {
            move = r.nextInt(9) + 1;
        }

        System.out.println("Computer moved at position " + move);
        updateBoard(move, 2, gameBoard);
    }
//method to declare the end of the game
    public static boolean isGameOver(char[][] gameBoard) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] == gameBoard[i][2] && gameBoard[i][2] == gameBoard[i][4] && gameBoard[i][0] != '_') {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 5; i += 2) {
            if (gameBoard[0][i] == gameBoard[1][i] && gameBoard[1][i] == gameBoard[2][i] && gameBoard[0][i] != '_') {
                return true;
            }
        }
        // Check diagonals
        if (gameBoard[0][0] == gameBoard[1][2] && gameBoard[1][2] == gameBoard[2][4] && gameBoard[0][0] != '_') {
            return true;
        }
        if (gameBoard[0][4] == gameBoard[1][2] && gameBoard[1][2] == gameBoard[2][0] && gameBoard[0][4] != '_') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
    	//3X3 game board 
        char[][] gameBoard = {
                {'_', '|', '_', '|', '_'},
                {'_', '|', '_', '|', '_'},
                {'_', '|', '_', '|', '_'}
        };

        Scanner sc = new Scanner(System.in);
        printBoard(gameBoard);
   //game continues until one of the player wins!
        while (true) {
            playerMove(gameBoard, sc);
            if (isGameOver(gameBoard)) {
                System.out.println("Player wins!");
                break;
            }
            computerMove(gameBoard);
            if (isGameOver(gameBoard)) {
                System.out.println("Computer wins!");
                break;
            }
        }
       
    } 
}  





























