package Sudoku;

public class Puzzle {
    // All variables have package access.
    // The numbers on the puzzle.
    int[][] numbers = new int[GameBoardPanel.GRID_SIZE][GameBoardPanel.GRID_SIZE];
    // The clues - isGiven (no need to guess) or need to guess.
    boolean[][] isGiven = new boolean[GameBoardPanel.GRID_SIZE][GameBoardPanel.GRID_SIZE];

    // Constructor
    public Puzzle(){
        super();
    }

    // Generate a new puzzle given the number of cells to be guessed, which can be used
    // to control the difficulty level.
    // This method shall set (or update) the arrays number and isGiven.
    public void newPuzzle(){
        // Hardcoded the puzzle for testing.
        int[][] hardCodedNumber =
                {{5, 3, 4, 6, 7, 8, 9, 1, 2},
                 {6, 7, 2, 1, 9, 5, 3, 4, 8},
                 {1, 9, 8, 3, 4, 2, 5, 6, 7},
                 {8, 5, 9, 7, 6, 1, 4, 2, 3},
                 {4, 2, 6, 8, 5, 3, 7, 9, 1},
                 {7, 1, 3, 9, 2, 4, 8, 5, 6},
                 {9, 6, 1, 5, 3, 7, 2, 8, 4},
                 {2, 8, 7, 4, 1, 9, 6, 3, 5},
                 {3, 4, 5, 2, 8, 6, 1, 7, 9}};
        // Copy from hardCodedNumbers into the array "numbers"
        for(int row = 0; row < GameBoardPanel.GRID_SIZE; ++row){
            System.arraycopy(hardCodedNumber[row], 0, numbers[row], 0, GameBoardPanel.GRID_SIZE);
        }

        // Need to use input parameter cellsToGuess!
        // HardCoded for testing, only 2 cells of "8" is not given
        boolean[][] hardcodedIsGiven =
                {{true, true, true, true, true, false, true, true, true},
                {true, true, true, true, true, true, true, true, false},
                {true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true}};

        // Copy from hardCodedIsGiven into array "isGiven"
        for(int row = 0; row < GameBoardPanel.GRID_SIZE; ++row){
            System.arraycopy(hardcodedIsGiven[row], 0, isGiven[row], 0, GameBoardPanel.GRID_SIZE);
        }
    }
}
