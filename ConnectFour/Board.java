public class Board {

    private static final int BOARD_WIDTH = 7;
    private static final int BOARD_HEIGHT = 6;

    private enum EntryType {
        PLAYER_1, PLAYER_2, EMPTY;

        char symbol() {
            switch (this) {
                case PLAYER_1: return 'X';
                case PLAYER_2: return 'O';
                case EMPTY: return ' ';
            }
            return '?';
        }
    }

    public enum Player {
        PLAYER_1, PLAYER_2;

        char symbol() {
            switch (this) {
                case PLAYER_1: return 'X';
                case PLAYER_2: return 'O';
            }
            return '?';
        }
    }

    private EntryType[][] playingField = new EntryType[BOARD_WIDTH][BOARD_HEIGHT];

    public Board() {
        for (int col = 1; col <= BOARD_WIDTH; col++) {
            for (int row = 1; row <= BOARD_HEIGHT; row++) {
                playingField[col-1][row-1] = EntryType.EMPTY;
            }
        }
        /*for (EntryType[] col : playingField) {
            for (EntryType element : col) {
                element = EntryType.EMPTY;
            }
        }*/
    }

    // returns true on success (column to full) and false otherwise
    // Column has to be a value between 1 and BOARD_WIDTH (incl.).
    boolean placeToken(Player player, int column) {
        for (int row = 1; row <= BOARD_HEIGHT; row++) {
            if (playingField[column-1][row-1] == EntryType.EMPTY) {
                switch (player) {
                    case PLAYER_1: playingField[column-1][row-1] = EntryType.PLAYER_1; return true;
                    case PLAYER_2: playingField[column-1][row-1] = EntryType.PLAYER_2; return true;
                }
            }
        }
        return false;
    }

    boolean hasPlayerWon(Player player) {
        // ...
        return false;
    }

    // checks whether row r is full
    boolean probeFull(int r) {
        //...
        return false;
    }

    void printBoard() {
        // all rows of the board
        for (int row = BOARD_HEIGHT; row >= 1; row--) {
            for (int col = 1; col <= BOARD_WIDTH; col++) {
                System.out.print("+---");
            }
            System.out.println("+");

            for (int col = 1; col <= BOARD_WIDTH; col++) {
                System.out.print("| " + playingField[col-1][row-1].symbol() + " ");
            }
            System.out.println("|");
        }
        // bottom line
        for (int col = 1; col <= BOARD_WIDTH; col++) {
            System.out.print("+---");
        }
        System.out.println("+");
        // column numbers
        for (int col = 1; col <= BOARD_WIDTH; col++) {
            System.out.print("  " + col + " ");
        }
        System.out.println();
    }
}
