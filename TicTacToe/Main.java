import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("<Set player 1 info>");
        Player p1 = setPlayerInfo();

        System.out.println("<Set player 2 info>");
        Player p2 = setPlayerInfo();

        // 3x3 Tic Tac Toe board
        char[][] board = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
        };

        ArrayList<String> cells = assignPositions(board); // an array list of each cell on the board
        boolean keepGoing = true; // a boolean variable for running while loops
        boolean p1_turn = true;
        boolean p2_turn = true;
        char position;

        while (keepGoing) {

            while (p1_turn) {
                printBoard(board);
                System.out.print("Player 1, Where do you want to move to? ");
                position = scnr.next().charAt(0);
                System.out.println("");
                // if p1 made a valid move
                if (p1.isValidMove(position, cells)) {
                    // then p1 moves to the position
                    p1.moveTo(position, board);
                    cells.set(Character.getNumericValue(position-1), String.valueOf(p1.getLetter()));
                    // if p1's move meets the win condition, print out winner messages and ends game
                    if (p1.isWinner(cells)) {
                        printBoard(board);
                        System.out.println("!! <Notice> Player 1, " + p1.getPlayerName() + " is a winner !!");
                        System.out.println("");
                        scnr.close();
                        System.exit(0);
                    }
                }
                // if p1 didn't make a valid move
                else {
                    System.out.println("** <Notice> That is not a valid move. Try again (Player 1) **");
                    System.out.println("");
                    continue;
                }
                break;
            }

            while (p2_turn) {

                while (keepGoing) {
                    // if there's no place to move
                    if (isTied(cells)) {
                        // then the game ends in tie
                        System.out.println("!! <Notice> The game ends in tie !!");
                        System.exit(0);
                    }
                    printBoard(board);
                    System.out.print("Player 2, Where do you want to move to? ");
                    position = scnr.next().charAt(0);
                    System.out.println("");
                    // if p2 made a valid move
                    if (p2.isValidMove(position, cells)) {
                        // then p2 moves to the position
                        p2.moveTo(position, board);
                        cells.set(Character.getNumericValue(position-1), String.valueOf(p2.getLetter()));
                        // if p2's move meets the win condition, print out winner messages and ends game
                        if (p2.isWinner(cells)) {
                            printBoard(board);
                            System.out.println("!! <Notice> Player 2, " + p2.getPlayerName() + " is a winner !!");
                            System.out.println("");
                            scnr.close();
                            System.exit(0);
                        }
                    }
                    // if p2 didn't make a valid move
                    else {
                        System.out.println("** <Notice> That is not a valid move. Try again (Player 2) **");
                        System.out.println("");
                        continue;
                    }
                    break;
                }

                break;
            }
        } 
        
    }

    // set players' names and letters
    public static Player setPlayerInfo() {
        Scanner in = new Scanner(System.in);
        System.out.print("Set a name: ");
        String name = in.nextLine();
        System.out.print("Set a letter (generally X or O): ");
        char letter = in.next().charAt(0);
        System.out.println("");

        return new Player(name, letter);
    }

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
    
    // print out the board
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

    // when the game ends in tie
    public static boolean isTied(ArrayList<String> cells) {
        char c;
        for (int i = 0; i < cells.size(); i++) {
            c = cells.get(i).charAt(0);
            switch (c) {
                case '1': 
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9': return false;
            }
        }
        return true;
    }
}