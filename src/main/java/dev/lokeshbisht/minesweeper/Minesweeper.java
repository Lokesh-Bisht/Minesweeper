package dev.lokeshbisht.minesweeper;

import java.util.Random;
import java.util.Scanner;

class Minesweeper implements GameStatus {

    private final Scanner scanner = new Scanner(System.in);

    private final int rows;
    private final int columns;
    private int mines;
    private int safeCellsExplored;

    private final char[][] field = new char[9][9];              // the real field
    private final char[][] hiddenMinesField = new char[9][9];   // the hidden field which is shown to the user

    // All 8 moves to move inside the board i.e., top, bottom, right, top-right, etc
    private final int[] directionX = {1, 1, 0, -1, -1, -1, 0, 1};
    private final int[] directionY = {0, 1, 1, 1, 0, -1, -1, -1};

    public Minesweeper(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    // Initializes the mines count for the game.
    private void getMinesCount() {
        while (true) {
            System.out.println("How many mines do you want on the field?");
            final String minesCount = scanner.next();
            try {
                mines = Integer.parseInt(minesCount);
                if (mines < 1 || mines > 81) {
                    throw new Exception();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.printf("Please enter a valid input! Input can " +
                        "only be an integer. %s %n%n", e.getMessage());
            } catch (Exception e) {
                System.out.printf("Mines can't be less than 1 or greater " +
                        "than 81 (total cells).%n%n");
            }
        }
    }

    // Shuffle mines and spread them across the board.
    private void shuffleMines() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                final int x = random.nextInt(rows);
                final int y = random.nextInt(columns);
                char temp = field[i][j];
                field[i][j] = field[x][y];
                field[x][y] = temp;
            }
        }
    }

    // Place mines on the field / board.
    private void placeMines() {
        final int temp = mines;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (mines > 0) {
                    field[i][j] = 'X';
                    mines--;
                } else {
                    field[i][j] = '.';
                }
            }
        }
        mines = temp;
        shuffleMines();
    }

    /**
     * Check if the current move is valid move i.e.,
     * check the current (x, y) co-ordinates
     */
    private boolean isAValidMove(int x, int y) {
        return (x >= 0 && x < rows && y >= 0 && y < columns);
    }


    /**
     * Add clues to the original field / board;
     * to do this check the number of mines that surround a cell,
     * and display that number on the cell.
     * field[cell] = minesThatSurroundIt
     * 'X' : mine
     * '.' : safe cell
     * '1': clue        (any number from 1 to 8)
     */
    private void addCluesForFindingMines() {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                for (int moves = 0; moves < 8; ++moves) {
                    int x = i + directionX[moves];
                    int y = j + directionY[moves];
                    char cell = field[i][j];
                    if (cell == 'X' && isAValidMove(x, y)) {
                        char nextCell = field[x][y];
                        if (nextCell == '.') {
                            field[x][y] = '1';
                        } else if (nextCell != 'X'){
                            int value = (nextCell-'0')+1;
                            field[x][y] = (char)(value+'0');
                        }
                    }
                }
            }
        }
    }

    // Sets the original field with mines, safe cells and clues.
    public void setField() {
        getMinesCount();
        placeMines();
        addCluesForFindingMines();
    }

    /**
     * Sets the hidden field which is shown to the user.
     * '.' => denotes unmarked cell
     * '/' => denotes a safe cell (marked)
     * '*' => may be a mine (marked)
     * '1' => clue  (marked)
     */
    public void setHiddenMinesField() {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                hiddenMinesField[i][j] = '.';
            }
        }
    }

    // Explores the hidden field until a cell with mine is found
    private void exploreHiddenField(int x, int y) {

        for (int moves = 0; moves < 8; ++moves) {
            int x2 = x + directionX[moves], y2 = y + directionY[moves];
            if (isAValidMove(x2, y2) && hiddenMinesField[x2][y2] == '.') {
                char nextCell = field[x2][y2];
                // Safe cell
                if (nextCell != 'X') {
                    safeCellsExplored++;
                    if (nextCell == '.') {  // Cell is not surrounded by mines
                        hiddenMinesField[x2][y2] = '/';
                        exploreHiddenField(x2, y2);
                    } else {    // Cell is surrounded by mines. Do not explore any further.
                        hiddenMinesField[x2][y2] = nextCell;
                    }
                }
            }
        }
    }

    private String[] getInput() {
        String[] input = new String[3];

        while (true) {
            System.out.print("Set/unset mines marks or claim a cell as free:");
            input[0] = scanner.next();
            input[1] = scanner.next();
            input[2] = scanner.next();
            System.out.println("");
            try {
                final int x =  Integer.parseInt(input[0]);
                final int y = Integer.parseInt(input[1]);

                if (x < 1 || x > rows || y < 1 || y > columns) {
                    throw new IndexOutOfBoundsException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.printf("Please enter valid (x, y) co-ordinates! %s%n%n", e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                System.out.printf("Both 'x' and 'y' co-ordinates must be > 0 and < 10. %n%n");
            }
        }
        return input;
    }

    /**
     * Start playing the game.
     * User plays the game until it is over i.e.,
     * until either the player wins or looses the game,
     */
    public void startGame() {
        int minesFound = 0;
        final int totalCells = rows * columns;
        boolean isGameOver = false;

        printField(rows, columns, hiddenMinesField);


        while (!isGameOver) {

            final String[] input = getInput();
            final int x = Integer.parseInt(input[0]) - 1;
            final int y = Integer.parseInt(input[1]) - 1;
            final String action = input[2];

            switch (action) {
                case "free":
                        if (field[x][y] == 'X') {   // Player stepped on a mine. Game Over!
                            isGameOver = true;
                            hiddenMinesField[x][y] = 'X';
                            GameStatus.printGameOverMessage();
                        } else {    // Safe cell, continue exploring the field.
                            safeCellsExplored++;
                            if (field[x][y] == '.') {  // Cell is not surrounded by mines
                                hiddenMinesField[x][y] = '/';
                                exploreHiddenField(x, y);
                            } else {  // Cell is surrounded by mines
                                hiddenMinesField[x][y] = field[x][y];
                            }
                        }
                    break;
                case "mine":
                        if (hiddenMinesField[x][y] == '.') {
                            hiddenMinesField[x][y] = '*';
                            minesFound++;
                        } else {
                            hiddenMinesField[x][y] = '.';
                            minesFound--;
                        }
                    break;
                default:
                    System.out.println("Invalid action! You can only use actions:");
                    System.out.println("1. 'mine' to set/unset a mine mark;");
                    System.out.printf("2. 'free' to claim a cell as free. %n %n");
                    continue;
            }

            printField(rows, columns, hiddenMinesField);

            if (minesFound == mines || safeCellsExplored == totalCells - mines) {
                isGameOver = true;
                GameStatus.printGameWonMessage();
            }
        }

    }
}