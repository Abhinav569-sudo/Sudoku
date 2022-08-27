package Sudoku;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class Cell extends JTextField {
    // Prevent Serial Warning.
    @Serial
    private static final long serialVersionUID = 1L;

    // Define named constants for JTextField's colors and fonts.
    // To be chosen based on cell status.
    public static final Color BG_GIVEN = new Color(240, 240, 240);
    public static final Color FG_GIVEN = Color.BLACK;
    public static final Color FG_NOT_GIVEN = Color.GRAY;
    public static final Color BG_TO_GUESS = Color.YELLOW;
    public static final Color BG_CORRECT_GUESS = new Color(0, 216, 0);
    public static final Color BG_WRONG_GUESS = new Color(216, 0, 0);
    public static final Font FONT_NUMBERS = new Font("OCR A Extended", Font.PLAIN, 28);

    // Cell Definitions.
    // The row and column number [0-8] of this cell.
    int row, col;
    // The puzzle number [0-9] for this cell.
    int number;
    // The status of these cells defined in enum CellStatus.
    CellStatus status;

    // Constructor
    public Cell(int row, int col){
        super(); //JTextField
        this.row = row;
        this.col = col;

        // Inherited from JTextField: Beautify all the cells once for all
        super.setHorizontalAlignment(JTextField.CENTER);
        super.setFont(FONT_NUMBERS);
    }

    // Reset this cell for a new game, given the puzzle number and isGiven.
    public void newGame(int number, boolean isGiven){
        this.number = number;
        status = isGiven ? CellStatus.Given : CellStatus.To_Guess;
        paint();
    }

    // This Cell (JTextField) paints itself based on its status.
    void paint() {
        if(status == CellStatus.Given){
            //Inherited from JTextField: set display properties
            super.setText(number + "");
            super.setEditable(false);
            super.setBackground(BG_GIVEN);
            super.setForeground(FG_GIVEN);
        }else if (status == CellStatus.To_Guess){
            //Inherited from JTextField: set display properties
            super.setText("");
            super.setEditable(true);
            super.setBackground(BG_TO_GUESS);
            super.setForeground(FG_NOT_GIVEN);
        } else if (status == CellStatus.Correct_Guess) {
            //From TO_GUESS
            super.setBackground(BG_CORRECT_GUESS);
        } else if (status == CellStatus.Wrong_Guess) {
            //From TO_GUESS
            super.setBackground(BG_WRONG_GUESS);
        }
    }
}
