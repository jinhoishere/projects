import java.util.ArrayList;
import java.util.Scanner;

//TODO3. Develop logic to check if a player wins
//TODO4. Create a loop to allow players to take turns
public class Main {
    public static ArrayList<String> assignPositions(char[][] board) {
        ArrayList<String> cells = new ArrayList<>(); // there are 9 numbers(1-9) in the list.
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
        Scanner scnr = new Scanner(System.in);
        Player p1 = new Player("Jinho", 'X');
        Player p2 = new Player("Abi", 'O');

        char[][] board = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
        };
        ArrayList<String> cells = assignPositions(board);
        
        boolean p2_turn = true;
        boolean p1_turn = true;
        char position;

        while (p2_turn) {
            while (p1_turn) {
                printBoard(board);
                System.out.print("Player 1, Where do you want to move to? ");
                position = scnr.next().charAt(0);
                if (p1.isValid(position, cells)) {
                    p1.moveTo(position, board);
                    cells.set(Character.getNumericValue(position-1), String.valueOf(p1.getLetter()));
                }
                else {
                    System.out.println("That is not a valid move. (Player 1)");
                    continue;
                }
                break;
            }
            printBoard(board);
            System.out.print("Player 2, Where do you want to move to? ");
            position = scnr.next().charAt(0);
            if (p2.isValid(position, cells)) {
                p2.moveTo(position, board);
                cells.set(Character.getNumericValue(position-1), String.valueOf(p2.getLetter()));
            }
            else {
                System.out.println("That is not a valid move. (Player 2)");
                continue;
            }
        }
        

    }
}