package Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

public class GameBoardPanel extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;

    //Define named constants for the game board properties.
    public static final int GRID_SIZE = 9;      // Size of the board.
    public static final int SUBGRID_SIZE = 3;   // Size of the sub-grid.
    //Define named constants for UI sizes.
    public static final int CELL_SIZE = 60;     // Cell width/height in pixels.
    public static final int BOARD_WIDTH = CELL_SIZE * GRID_SIZE;
    public static final int BOARD_HEIGHT = CELL_SIZE * GRID_SIZE;
                                                // Board width/height in pixels.

    private Cell[][] cells = new Cell[GRID_SIZE][GRID_SIZE];
    private Puzzle puzzle = new Puzzle();

    // Constructor
    public GameBoardPanel(){
        super.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));

        // Allocate the 2D array of Cell, and added into JPanel.
        for(int row = 0; row < GRID_SIZE; ++row){
            for(int col = 0; col < GRID_SIZE; ++col){
                cells[row][col] = new Cell(row, col);
                super.add(cells[row][col]);     // JPanel
            }
        }
        // Allocate a common listener as the ActionEvent Listener for all
        // Cells (JTextFields)
        CellInputListener listener = new CellInputListener();
        // Adds this common listener to all editable cells.
        for(int row = 0; row < GRID_SIZE; ++row){
            for(int col = 0; col < GRID_SIZE; ++col){
                if(cells[row][col].isEditable()){
                    cells[row][col].addActionListener(listener);
                }
            }
        }
        super.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
    }
    // Generate a new Puzzle.
    public void newGame(){
        puzzle.newPuzzle();

        // Initialize all 9x9 cells, based on the puzzle.
        for(int row = 0; row < GRID_SIZE; ++row){
            for (int col = 0; col <GRID_SIZE; ++col){
                cells[row][col].newGame(puzzle.numbers[row][col], puzzle.isGiven[row][col]);
            }
        }
    }

    // Return true if puzzle is solved.
    // i.e. none of the cells have status of TO_GUESS or WRONG_GUESS.
    public boolean isSolved(){
        for(int row = 0; row < GRID_SIZE; ++row){
            for (int col = 0; col <GRID_SIZE; ++col){
                if(cells[row][col].status == CellStatus.To_Guess || cells[row][col].status == CellStatus.Wrong_Guess){
                    return false;
                }
            }
        }
        return true;
    }

    // Define a Listener Inner Class for all the editable Cells.
    private class CellInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            // Get a reference of the JTextField that trigger this action event
            Cell sourceCell = (Cell)e.getSource();

            // Retrieve the int entered.
            int numberIn = Integer.parseInt(sourceCell.getText());
            // For Debugging
            System.out.println("You entered " + numberIn);

            /*
              Check the numberIn against sourceCell.number.
              update the cell status sourceCell.status,
              and re-paint the cell via sourceCell.paint().
             */
            if(numberIn == sourceCell.number){
                sourceCell.status = CellStatus.Correct_Guess;
            }else {
                sourceCell.status = CellStatus.Wrong_Guess;
            }
            sourceCell.paint();

            if(isSolved()){
                JOptionPane.showMessageDialog(null, "Congratulations!");
            }
        }
    }
}
