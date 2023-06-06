import java.util.ArrayList;
import java.util.Scanner;

// TODO1: think abt a win condition with the array list
public class Main {
    // create an array list of each cell on the board.
    public static ArrayList<String> assignPositions(char[][] board) {
        ArrayList<String> cells = new ArrayList<>(); // there are 9 numbers(1-9) in the list.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                String currentCell = String.valueOf(board[i][j]);
                cells.add(currentCell);
            }
        }
        return cells;
    }

    // print out board
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println("-------------");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.print("|");
            System.out.println("");
        }
        System.out.println("-------------");
    }

    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        Player p1 = new Player("Jinho", 'X');
        Player p2 = new Player("Abi", 'O');

        // 3X3 Tic Tac Toe board
        char[][] board = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
        };

        ArrayList<String> cells = assignPositions(board); // an array list of each cell on the board
        boolean keepGoing = true; // a boolean variable for while loops
        boolean p1_turn = true;
        boolean p2_turn = true;
        char position;

        while (keepGoing) {

            while (p1_turn) {
                printBoard(board);
                System.out.print("Player 1, Where do you want to move to? ");
                position = scnr.next().charAt(0);
                System.out.println("");
                if (p1.isValidMove(position, cells)) {
                    p1.moveTo(position, board);
                    cells.set(Character.getNumericValue(position-1), String.valueOf(p1.getLetter()));
                }
                else {
                    System.out.println("** That is not a valid move. (Player 1) **");
                    System.out.println("");
                    continue;
                }
                break;
            }

            while (p2_turn) {

                while (keepGoing) {
                    printBoard(board);
                    System.out.print("Player 2, Where do you want to move to? ");
                    position = scnr.next().charAt(0);
                    System.out.println("");
                    if (p2.isValidMove(position, cells)) {
                        p2.moveTo(position, board);
                        cells.set(Character.getNumericValue(position-1), String.valueOf(p2.getLetter()));
                    }
                    else {
                        System.out.println("** That is not a valid move. (Player 2) **");
                        System.out.println("");
                        continue;
                    }
                    break;
                }

                break;
            }
            
        } 
        
    }
}