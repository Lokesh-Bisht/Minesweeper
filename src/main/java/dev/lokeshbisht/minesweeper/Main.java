package dev.lokeshbisht.minesweeper;

public class Main {

    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper(9, 9);

        minesweeper.setField();
        minesweeper.setHiddenMinesField();
        minesweeper.startGame();
    }
}
