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

    // check if a player's move is valid or not
    public boolean isValidMove(char position, ArrayList<String> cells) {
        for (int i = 0; i < cells.size(); i++) {
            if (cells.get(i).charAt(0) == position) {
                return true;
            }
        }
        return false;
    }

    // move as the player's choice
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

    // find who is a winner
    public boolean isWinner(ArrayList<String> cells) {
        // win cases - horizontal
        if ((cells.get(0).charAt(0) == this.getLetter() && 
            cells.get(1).charAt(0) == this.getLetter() && 
            cells.get(2).charAt(0) == this.getLetter())) {
            return true;
        }
        else if (cells.get(3).charAt(0) == this.getLetter() &&
                cells.get(4).charAt(0) == this.getLetter() &&
                cells.get(5).charAt(0) == this.getLetter()) {
            return true;
        }
        else if (cells.get(6).charAt(0) == this.getLetter() &&
                cells.get(7).charAt(0) == this.getLetter() &&
                cells.get(8).charAt(0) == this.getLetter()) {
            return true;
        }
        // win cases - vertical
        else if (cells.get(0).charAt(0) == this.getLetter() &&
                cells.get(3).charAt(0) == this.getLetter() &&
                cells.get(6).charAt(0) == this.getLetter()) {
            return true;
        }
        else if (cells.get(1).charAt(0) == this.getLetter() &&
                cells.get(4).charAt(0) == this.getLetter() &&
                cells.get(7).charAt(0) == this.getLetter()) {
            return true;
        }
        else if (cells.get(2).charAt(0) == this.getLetter() &&
                cells.get(5).charAt(0) == this.getLetter() &&
                cells.get(8).charAt(0) == this.getLetter()) {
            return true;
        }
        // win cases - diagonal
        else if (cells.get(0).charAt(0) == this.getLetter() &&
                cells.get(4).charAt(0) == this.getLetter() &&
                cells.get(8).charAt(0) == this.getLetter()) {
            return true;
        }
        else if (cells.get(2).charAt(0) == this.getLetter() &&
                cells.get(4).charAt(0) == this.getLetter() &&
                cells.get(6).charAt(0) == this.getLetter()) {
            return true;
        }
        // a winner hasn't been decided yet, keep playing
        else {
            return false;
        }
    }
}
