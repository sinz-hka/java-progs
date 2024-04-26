import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        board.printBoard();

        Board.Player currentPlayer = Board.Player.PLAYER_1;
        while (true) {
            System.out.print("Player " + currentPlayer.symbol() + ": Which column? ");
            int col = scanner.nextInt();
            board.placeToken(currentPlayer, col);
            board.printBoard();
            currentPlayer = (currentPlayer == Board.Player.PLAYER_1 ? Board.Player.PLAYER_2 : Board.Player.PLAYER_1);
        }
    }
}