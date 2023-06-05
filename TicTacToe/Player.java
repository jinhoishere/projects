import java.util.ArrayList;

public class Player {
    private String playerName;
    private char playerLetter; // X or O

    public Player(String name, char letter) {
        this.playerName = name;
        this.playerLetter = letter;
    }

    public String getPlayerName() {
        return this.playerName;
    }
    public char getLetter() {
        return this.playerLetter;
    }

    //TODO
    public boolean isValid(char position, ArrayList<String> cells) {
        for (int i = 0; i < cells.size(); i++) {
            if (cells.get(i).charAt(0) == position) {
                return true;
            }
        }
        return false;
    }
    public char[][] moveTo(char position, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
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
