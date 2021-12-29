package dev.lokeshbisht.minesweeper;

public interface GameStatus {

    static void printGameWonMessage() {
        System.out.printf("Congratulations! You found all the mines!%n%n");
    }

    static void printGameOverMessage() {
        System.out.printf("Game Over!. You stepped on a mine and failed!%n%n");
    }

    // Prints the current status of the hidden field.
    default void printField(int rows, int columns, char[][] hiddenMinesField) {

        System.out.print(" |");
        for (int i = 0; i < columns; ++i) {
            System.out.print(i+1);
        }
        System.out.println("|");
        System.out.print("-|");
        for (int i = 0; i < columns; ++i) {
            System.out.print('-');
        }
        System.out.println("|");

        for (int i = 0; i < rows; ++i) {
            System.out.print(i+1 + "|");
            for (int j = 0; j < columns; ++j) {
                System.out.print(hiddenMinesField[i][j]);
            }
            System.out.println("|");
        }

        System.out.print("-|");
        for (int i = 0; i < columns; ++i) {
            System.out.print('-');
        }
        System.out.println("|");
    }
}
