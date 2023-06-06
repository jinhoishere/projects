import java.util.ArrayList;

public class Player {
    private String playerName;
    private char playerLetter; // X or O

    // a constructor
    public Player(String name, char letter) {
        this.playerName = name;
        this.playerLetter = letter;
    }

    // get method to get a player's name
    public String getPlayerName() {
        return this.playerName;
    }
    // get method to get a player's letter
    public char getLetter() {
        return this.playerLetter;
    }

    // a method to check if a player's move is valid or not
    public boolean isValidMove(char position, ArrayList<String> cells) {
        for (int i = 0; i < cells.size(); i++) {
            if (cells.get(i).charAt(0) == position) {
                return true;
            }
        }
        return false;
    }
    // a method to move by a player's choice
    public char[][] moveTo(char position, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == position) {
                    board[i][j] = this.playerLetter;
                    // System.out.println(board[i][j]);
                }
            }
        }
        return board;
    }

    // public boolean isWinner() {
    //     return false;
    // }
}
