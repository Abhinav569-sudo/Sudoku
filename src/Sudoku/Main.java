/*
    reference to: https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaGame_Sudoku.html#:~:text=Start%20with%20a%20solved%20puzzle,of%20values%20with%20a%20solver.
 */

package Sudoku;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class Main extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;

    // Private variables
    GameBoardPanel board = new GameBoardPanel();
    JButton btnNewGame = new JButton("New Game");

    // Constructor
    public Main(){
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(board, BorderLayout.CENTER);

        //Add a button to restart game via board.newGame()
        // ..........
        // Initialize the game board to start the game.
        board.newGame();

        pack();   // Pack the UI components, instead of using setSize()
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sudoku");
        setVisible(true);
    }
    public static void main(String[] args){
        new Main();
    }
}
