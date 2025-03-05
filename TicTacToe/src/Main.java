import java.util.Scanner;

class TicTacToe {
    char[][] board = new char[3][3];
    int[][] numericBoard = new int[3][3]; //untuk cek menang
    char currentPlayer = 'O';
    int currentNumeric = 1; // O=1, X=-1
    int movesLeft = 9;
    boolean gameWon = false;
    Scanner scanner = new Scanner(System.in);

    void board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
                numericBoard[i][j] = 0;
            }
        }
    }

    void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (numericBoard[i][j] == 1) {
                    System.out.print("O ");
                } else if (numericBoard[i][j] == -1) {
                    System.out.print("X ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    void play() {
        board();
        printBoard();
        do {
            int row, col;
            do {
                System.out.print("Player " + currentPlayer + ", enter your column & row: ");
                row = scanner.nextInt();
                col = scanner.nextInt();
                if(row < 0 || row > 2 || col < 0 || col > 2 ||board[col][row] != '-'){
                    System.out.println("Invalid Move!!! Try Again.");
                }
            } while (row < 0 || row > 2 || col < 0 || col > 2 ||board[col][row] != '-');
            board[col][row] = currentPlayer;
            numericBoard[col][row] = currentNumeric;
            movesLeft--;
            //System.out.println(movesLeft);
            gameWon = checkWin();
            printBoard();
            if (gameWon) {
                System.out.println("Player " + currentPlayer + " WINS!"); return;
            }
            if (movesLeft == 0) {
                System.out.println("It's a draw!"); return;
            }
            if (currentPlayer == 'O') { //ini switch playernya
                currentPlayer = 'X';
                currentNumeric = -1;
            } else {
                currentPlayer = 'O';
                currentNumeric = 1;
            }
        } while (!gameWon && movesLeft > 0);
    }

    boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (Math.abs(numericBoard[i][0] + numericBoard[i][1] + numericBoard[i][2]) == 3 ||
                    Math.abs(numericBoard[0][i] + numericBoard[1][i] + numericBoard[2][i]) == 3) {
                return true;
            }
        }
        if (Math.abs(numericBoard[0][0] + numericBoard[1][1] + numericBoard[2][2]) == 3 ||
                Math.abs(numericBoard[0][2] + numericBoard[1][1] + numericBoard[2][0]) == 3) {
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}
