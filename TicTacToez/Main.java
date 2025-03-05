import java.util.Scanner;

class Board {
    char[][] board;
    int[][] numericBoard;

    Board() {
        board = new char[3][3];
        numericBoard = new int[3][3];
        initializeBoard();
    }

    void initializeBoard() {
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

    boolean makeMove(int row, int col, char player, int numericValue) {
        if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != '-') {
            return false;
        }
        board[row][col] = player;
        numericBoard[row][col] = numericValue;
        return true;
    }

    boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (Math.abs(numericBoard[i][0] + numericBoard[i][1] + numericBoard[i][2]) == 3 ||
                Math.abs(numericBoard[0][i] + numericBoard[1][i] + numericBoard[2][i]) == 3) {
                return true;
            }
        }
        return Math.abs(numericBoard[0][0] + numericBoard[1][1] + numericBoard[2][2]) == 3 ||
               Math.abs(numericBoard[0][2] + numericBoard[1][1] + numericBoard[2][0]) == 3;
    }
}

class Player {
    char symbol;
    int numericValue;

    Player(char symbol, int numericValue) {
        this.symbol = symbol;
        this.numericValue = numericValue;
    }

    void switchPlayer() {
        if (symbol == 'O') {
            symbol = 'X';
            numericValue = -1;
        } else {
            symbol = 'O';
            numericValue = 1;
        }
    }
}

class Game {
    Board board;
    Player player;
    int movesLeft;
    boolean gameWon;
    Scanner scanner;

    Game() {
        board = new Board();
        player = new Player('O', 1);
        movesLeft = 9;
        gameWon = false;
        scanner = new Scanner(System.in);
    }

    void play() {
        board.printBoard();
        while (!gameWon && movesLeft > 0) {
            int row, col;
            do {
                System.out.print("Player " + player.symbol + ", enter your row & column: ");
                row = scanner.nextInt();
                col = scanner.nextInt();
                if (!board.makeMove(row, col, player.symbol, player.numericValue)) {
                    System.out.println("Invalid Move!!! Try Again.");
                }
            } while (!board.makeMove(row, col, player.symbol, player.numericValue));
            
            movesLeft--;
            gameWon = board.checkWin();
            board.printBoard();
            
            if (gameWon) {
                System.out.println("Player " + player.symbol + " WINS!");
                return;
            }
            if (movesLeft == 0) {
                System.out.println("It's a draw!");
                return;
            }
            player.switchPlayer();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
