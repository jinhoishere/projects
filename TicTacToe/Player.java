public class Player {
    private String playerName;
    private char playerLetter; // O or X

    public Player(String name, char letter) {
        this.playerName = name;
        this.playerLetter = letter;
    }

    public int move(char[][] board) {

    }
    public boolean isValid(int move, char[][]board) {
        if (move <= 9 && move >= 1) {
            if (char[][]board ) {
                
            }
            else {
                return false;
            }
        }
        else {
            System.out.println("Out of number range 1-9");
            return false;
        }
    }

    public boolean isWinner() {
        return false;
    }

    // public char getLetter() {
    //     return this.playerLetter;
    // }
}
