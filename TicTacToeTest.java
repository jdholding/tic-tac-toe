import java.util.List;

import org.junit.Test;

public class TicTacToeTest {
    @Test
    public void isWinningSequenceReturnsFalseWhenBothPresent() {
        String[] testArray = {"X", "X", "O", "X"}; 
        assert !TicTacToe.isWinningSequence(testArray); 
    }

    @Test
    public void isWinningSequenceReturnsFalseWhenContainsBlank() {
        String[] testArray = {"X", "X", "X", " "}; 
        assert !TicTacToe.isWinningSequence(testArray); 
    }

    @Test
    public void isWinningSequenceReturnsTrueWhenTrue() {
        String[] testArray = {"B", "B", "B"}; 
        assert TicTacToe.isWinningSequence(testArray); 
    }

    @Test
    public void hasWinningColumnReturnsTrueWhenTrue() {
        String[][] testBoard = {
            {"S", "M", " ", "S"}, 
            {"M", "M", " ", "S"},  
            {"S", "S", " ", "S"},  
            {"S", "M", " ", "S"} 
        };
        assert TicTacToe.hasWinningColumn(testBoard); 
        
    }

    @Test
    public void hasWinningColumnReturnsFalseWhenFalse() {
        String[][] testBoard = {
            {"S", "M", " ", "S"}, 
            {"M", "M", " ", "X"},  
            {"S", "S", " ", "S"},  
            {"S", "M", " ", "S"} 
        };
        assert !TicTacToe.hasWinningColumn(testBoard); 
        
    }

    @Test
    public void hasWinningDiagonalReturnsTrueWhenTrueRightDown() {
        String[][] testBoard = {
            {"S", "M", " ", "S", " ", "S"}, 
            {"M", "R", " ", "S", "S", "T"},  
            {"S", "S", " ", "S", " ", "S"},  
            {"S", "G", "S", "S", " ", "E"},
            {"S", "S", " ", " ", " ", "S"},  
            {"S", "M", " ", "S", " ", "S"}  
        };
        assert TicTacToe.hasWinningDiagonal(testBoard);
    }    

    @Test
    public void hasWinningDiagonalReturnsTrueWhenTrueLeftDown() {
        String[][] testBoard = {
            {"R", "M", " ", "S", " ", " "}, 
            {"M", "R", " ", "S", "S", "T"},  
            {"S", "S", "R", "S", " ", "S"},  
            {"N", "G", "S", "R", " ", "E"},
            {"S", "Q", " ", " ", "R", "S"},  
            {"S", "M", " ", "S", " ", "R"}  
        };
        assert TicTacToe.hasWinningDiagonal(testBoard);
    }   

    @Test
    public void hasWinningDiagonalReturnsFalseWhenFalse() {
        String[][] testBoard = {
            {"R", "M", " ", "S", " "}, 
            {"M", "O", " ", "S", "S"},  
            {"S", "S", "R", "S", " "},  
            {"N", "G", "S", "R", " "},
            {"S", "Q", " ", " ", "X"}
        };
        assert !TicTacToe.hasWinningDiagonal(testBoard);
    }   

    @Test
    public void hasWinningRowReturnsTrueWhenTrue() {
        String[][] testBoard = {
            {"S", "M", " ", "S", " ", "S"}, 
            {"M", "R", " ", "S", "S", "T"},  
            {"S", "S", " ", "S", " ", "S"},  
            {"S", "G", "S", "S", " ", "E"},
            {"S", "S", "S", "S", "S", "S"},  
            {"S", "M", " ", "S", " ", "S"}  
        };

        assert TicTacToe.hasWinningRow(testBoard); 
    }

    @Test
    public void hasWinningRowReturnsFalseWhenFalse() {
        String[][] testBoard = {
            {"S", "M", " ", "S", " ", "S"}, 
            {" ", " ", " ", " ", " ", " "},  
            {"S", "S", " ", "S", " ", "S"},  
            {"S", "G", "S", "S", " ", "E"},
            {"S", "S", " ", "S", "X", "S"},  
            {"S", "M", " ", "S", " ", "S"}  
        };

        assert !TicTacToe.hasWinningRow(testBoard); 
    }
}
