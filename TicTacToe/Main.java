import java.util.ArrayList;
import java.util.Scanner;

//TODO1. Design the game board as a two-dimensional array
//TODO2. Write code to draw the game board in console
//TODO3. Develop logic to check if a player wins
//TODO4. Create a loop to allow players to take turns
public class Main {
    public static ArrayList<String> divideCells(char[][] board) {
        ArrayList<String> cells = new ArrayList<>(); // there are 9 cells(1-9) in the list.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                String currentCell = String.valueOf(board[i][j]);
                cells.add(currentCell);
            }
        }
        return cells;
    }
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println("---------------");
            for (int j = 0; j < board.length; j++) {
                System.out.print("| " + board[i][j] + " |");
            }
            System.out.println("");
        }
        System.out.println("---------------");
    }
    public static void main(String args[]) {
        Player p1 = new Player("Jinho", 'X');
        Player p2 = new Player("Abi", 'O');

        char[][] board = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
        };
        
        while (p1.isWinner || p2.isWinner) {
            printBoard(board);
        }
        


    }
}