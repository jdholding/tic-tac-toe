import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args){
        System.out.println("\n\nWelcome to Tic-Tac-Toe");
        System.out.println("To start, choose the size of the board between 2 and 9:");
        Integer boardSize = getValidInteger(2, 9);
        playGame(boardSize, "X", "O");
    }

    public static void playGame(Integer boardSize, String player1, String player2) {
        var board = makeTheBoard(boardSize);
        System.out.println(formatBoardToString(board));
        var currentPlayer = player1;
        for (var i = 0; i < (boardSize * boardSize); i++) {
            move(board, currentPlayer);
            if (isWinner(board)) {
                System.out.println("Congratulations player " + currentPlayer + "! You win!");
                return;
            }
            currentPlayer = currentPlayer == player1 ? player2 : player1;
        }
        System.out.println("It's a draw! Good game!");
    }

    public static String[][] move(String[][] board, String player) {
        System.out.println("Player " + player + ", enter a row: ");
        Integer row = getValidInteger(1, board.length) - 1;
        System.out.println("Player " + player + ", enter a column: ");
        Integer column = getValidInteger(1, board.length) - 1;
        if (!board[row][column].equals(" ")) {
            System.out.println("This space is occupied, please try again");
            return move(board, player);
        } else {
            board[row][column] = player;
        }
        System.out.println(formatBoardToString(board));
        return board;

    }

    public static Integer getValidInteger(Integer min, Integer max) {
        while (true) {
            String userInput = getUserInput();
            try {
                var userNumber = Integer.parseInt(userInput);
                if (userNumber >= min && userNumber <= max) {
                    return userNumber;
                }
            } catch(NumberFormatException e){}
            System.out.println("Please enter a number between " + min + " and " + max);
        }
    }

    public static String[][] makeTheBoard(Integer size) {
        String[][] board = new String[size][size];
        for (var i = 0; i < size; i++) {
            for (var j = 0; j < size; j++) {
                board[i][j] = " ";
            }
        }
        return board;
    }

    public static String formatBoardToString(String[][] board) {
        Integer size = board[0].length;
        String[] divArray = new String[size];
        Arrays.fill(divArray, "-");
        String divider = "   " + String.join("+", divArray) + "\n";
        String topRow = "   ";
        for (var i = 0; i < size; i++) {
            topRow += String.valueOf(i + 1) + " ";
        }

        String theBoard = String.valueOf(topRow) + "\n";
        for (var i = 0; i < board.length; i++) {
            String st = String.join("|", (board[i]));
            st = String.valueOf(i + 1) + "  " + st + "\n" + (i < board.length - 1 ? divider : "");
            theBoard += st;
        }
        return theBoard;
    }

    public static boolean isWinningSequence(String[] sequence) {
        for (var i = 0; i < sequence.length - 1; i++) {
            if (sequence[i].equals(" ") || !sequence[i].equals(sequence[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasWinningRow(String[][] board) {
        for (var i = 0; i < board.length; i++) {
            if (isWinningSequence(board[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasWinningColumn(String[][] board) {
        for (var i = 0; i < board[0].length; i++) {
            String[] column = new String[board.length];
            for (var j = 0; j < board.length; j++) {
                column[j] = board[j][i];
            }
            if (isWinningSequence(column)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasWinningDiagonal(String[][] board) {
        String[] leftDown = new String[board.length];
        String[] rightDown = new String[board.length];
        for (var i = 0; i < board.length; i++) {
            leftDown[i] = board[i][i];
            rightDown[i] = board[i][board.length - 1 - i];
        }
        return isWinningSequence(leftDown) || isWinningSequence(rightDown);
    }

    public static boolean isWinner(String[][] board) {
        return hasWinningRow(board) || hasWinningColumn(board) || hasWinningDiagonal(board);
    }

    public static String getUserInput() {
        String theInput;
        Scanner s = new Scanner(System.in);
        theInput = s.nextLine();

        if (theInput.equalsIgnoreCase("quit") || (theInput.equalsIgnoreCase("exit"))) {
            s.close();
            System.exit(0);
        }
        return theInput;
    }
}