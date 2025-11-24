package K05_Arrays.ConnectFour;

import java.util.Scanner;

/**
 * A single field on the board. EMPTY means no coin.
 * RED and YELLOW represent the two players.
 */
enum Field {
    EMPTY, RED, YELLOW;

    @Override
    public String toString() {
        switch (this) {
            case EMPTY:  return " ";
            case RED:    return "O";
            case YELLOW: return "X";
            default:     return "?";
        }
    }
}

/**
 * A player. Can be converted to a value of type Field and can toggle to the other player.
 */
enum Player {
    RED, YELLOW;

    public Field toField() {
        switch (this) {
            case RED:    return Field.RED;
            case YELLOW: return Field.YELLOW;
            default:     return null;
        }
    }

    public Player toggled() {
        return this == RED ? YELLOW : RED;
    }

    @Override
    public String toString() {
        switch (this) {
            case RED:    return "O";
            case YELLOW: return "X";
        }
        return null;
    }
}

/**
 * Represents a complete game of Connect Four, including the game board,
 * the rules for inserting coins, win detection, and the main game loop.
 * <p>
 * The board is stored as a 2D array indexed as board[column][row], where
 * rows are counted downwards columns from left to right, starting with 0.
 * The number of rows and columns can be configured, the standard board is
 * of size 7x6.
 * A move inserts a player's coin into a column, automatically occupying
 * the lowest available row in that column.
 * <p>
 * The class provides:
 * <ul>
 *   <li>methods for updating the board state (insertIntoColumn),</li>
 *   <li>logic to check for a winning position (hasWon),</li>
 *   <li>text-based rendering of the game board (toString),</li>
 *   <li>and an interactive command-line game loop (run).</li>
 * </ul>
 * <p>
 * This class contains all game logic and acts as the central controller
 * for a Connect Four match.
 */
public class Game {

    private final int nrColumns;
    private final int nrRows;
    private final Field[][] board;

    private final Scanner scanner;

    public Game(int nrColumns, int nrRows) {
        this.nrColumns = nrColumns;
        this.nrRows    = nrRows;

        // Board is indexed as board[column][row]
        board = new Field[nrColumns][nrRows];

        // Initialize everything to EMPTY
        for (int col = 0; col < nrColumns; col++) {
            for (int row = 0; row < nrRows; row++)
                board[col][row] = Field.EMPTY;
        }

        // Also initialize a scanner to read user input
        scanner = new Scanner(System.in);
    }

    @Override
    public String toString() {
        // A StringBuilder is more efficient than using String concatenation
        StringBuilder resultBuilder = new StringBuilder();
        String separator = "+" + "---+".repeat(nrColumns) + "\n";
        resultBuilder.append(separator);
        for (int row = 0; row < nrRows; row++) {
            for (int col = 0; col < nrColumns; col++) {
                resultBuilder.append("| ").append(board[col][row]).append(" ");
            }
            resultBuilder.append("|\n");
            resultBuilder.append(separator);
        }


        // Footer (column numbers)
        for (int i = 0; i < nrColumns; i++) {
            resultBuilder.append("  ").append(i + 1).append(" ");
        }
        resultBuilder.append('\n');

        return resultBuilder.toString();
    }

    /**
     * Inserts the player's coin into the given column.
     *
     * @param p   The player whose coin is inserted.
     * @param col The column index (0…nrColumns-1).
     * @return The row where the coin lands (0…nrRows-1), or
     *         -1 if the column is full,
     *         -2 if the column index is invalid.
     */
    private int insertIntoColumn(Player p, int col) {
        if (col < 0 || col >= nrColumns) { return -2; }

        // Start at bottom row and move upward
        for (int row = nrRows - 1; row >= 0; row--) {
            if (board[col][row] == Field.EMPTY) {
                board[col][row] = p.toField();
                return row;
            }
        }

        return -1; // Column is full
    }

    /**
     * Counts how many consecutive fields (including the starting field)
     * contain the same player's coin when moving from (col, row) in the
     * direction specified by (colDelta, rowDelta).
     * <p>
     * The direction is given by a column delta (colDelta) and row delta (rowDelta):
     * <ul>
     *   <li>(1, 0)  → move right (increase column by one)</li>
     *   <li>(-1, 0) → move left (decrease column by one)</li>
     *   <li>(0, 1)  → move down</li>
     *   <li>(1, 1)  → move down-right (diagonal)</li>
     *   <li>(-1,-1) → move up-left (diagonal)</li>
     *   <li>etc.
     * </ul>
     * <p>
     * The method stops counting when it reaches:
     * <ul>
     *   <li>a different-colored field,</li>
     *   <li>an EMPTY field,</li>
     *   <li>or the edge of the board.</li>
     * </ul>
     * <p>
     * It is used by hasWon() to count connected coins in both directions
     * along a line (horizontal, vertical, or diagonal).
     *
     * @return Number of consecutive fields with the same color as board[col][row].
     */
    private int countDirection(int col, int row, int colDelta, int rowDelta) {
        Field target = board[col][row];
        int count = 0;
        int c = col;
        int r = row;

        while (c >= 0 && c < nrColumns && r >= 0 && r < nrRows
                && board[c][r] == target) {
            count++;
            c += colDelta;
            r += rowDelta;
        }
        return count;
    }

    /**
     * Checks whether the last move at (col,row) created a Connect-4.
     */
    private boolean hasWon(int col, int row) {
        // ----- Horizontal (left + right) -----
        int horizontal = countDirection(col, row, -1, 0) +    // left
                         countDirection(col, row, +1, 0) - 1; // right (minus double count)

        // ----- Vertical (down only, up is impossible to help) -----
        int vertical = countDirection(col, row, 0, +1); // only downward

        // ----- Diagonal "\" (up-left + down-right) -----
        int diagonal1 = countDirection(col, row, -1, -1) +
                        countDirection(col, row, +1, +1) - 1;

        // ----- Diagonal "/" (down-left + up-right) -----
        int diagonal2 = countDirection(col, row, -1, +1) +
                        countDirection(col, row, +1, -1) - 1;

        return horizontal >= 4 || vertical >= 4 || diagonal1 >= 4 || diagonal2 >= 4;
    }

    /**
     * Runs the interactive ConnectFour game.
     */
    public void run() {
        System.out.println("Welcome to Connect Four!");
        System.out.print(this);

        Player currentPlayer = Player.RED;
        boolean gameFinished = false;

        while (!gameFinished) {
            gameFinished = makeMove(currentPlayer);
            currentPlayer = currentPlayer.toggled();
        }
    }

    /**
     * Handles a single turn for the given player:
     * <ul>
     *  <li>repeatedly asks the user to select a column,</li>
     *  <li>validates the input,</li>
     *  <li>attempts to insert the coin,</li>
     *  <li>prints the board,</li>
     *  <li>checks whether the move wins the game.</li>
     * </ul>
     * <p>
     * @param player the player whose turn it is
     * @return true if this move wins the game, false otherwise
     */
    private boolean makeMove(Player player) {
        while (true) {
            System.out.print("Player " + player + ": Which column? ");
            int col = scanner.nextInt() - 1;  // Convert to 0-based index

            if (col < 0 || col >= nrColumns) {
                System.out.println("Invalid column, please try again!");
                continue;
            }

            // Insert column; if it fails, we get a negative value for 'row' back.
            int row = insertIntoColumn(player, col);
            if (row == -1) {
                System.out.println("Column is full! Try another one.");
            } else if (row == -2) {
                System.out.println("Invalid column index!");
            } else {
                // Successful move
                System.out.print(this); // print board
                if (hasWon(col, row)) {
                    System.out.println("Congratulations, Player " + player + "!");
                    System.out.println("You have won!");
                    return true;
                }
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Game(7, 6).run();
    }
}
