package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1 && monoVertical(board, i) || monoHorizontal(board, i)) {
                    rsl = true;
                    break;
            }
        }
        return rsl;
    }

    public static boolean monoHorizontal(int[][] board, int row) {
        boolean rsl = true;
        for (int cell = 0; cell < board[row].length; cell++) {
            if (board[row][cell] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean monoVertical(int[][] board, int cell) {
        boolean rsl = true;
        for (int[] ints : board) {
            if (ints[cell] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}