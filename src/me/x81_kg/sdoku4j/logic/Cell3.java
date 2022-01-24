package me.x81_kg.sdoku4j.logic;

public class Cell3 {
    private int[][] matrix;

    Cell3 () {
        this.matrix = new int[3][3];
    }

    public void set (int x, int y, int value) {
        if (value < 0 || value > 9) return;
        for (int[] y_arr : this.matrix) {
            for (int arr_value : y_arr) {
                if (arr_value == value) return;
            }
        }

        this.matrix[x][y] = value;
    }

    public int get(int x, int y) {
        return this.matrix[x][y];
    }

    public boolean isFinished() {
        for (int[] y_arr : this.matrix) {
            for (int arr_value : y_arr) {
                if (arr_value == 0) return false;
            }
        }

        return true;
    }

    public boolean rowContains (int row, int value) {
        if (row < 0 || row > 2) return false;

        for (int is : matrix[row]) {
            if (value == is) return true;
        }

        return false;
    }

    public boolean columnContains (int column, int value) {
        if (column < 0 || column > 2 || value < 0 || value > 9) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            if (this.matrix[column][i] == value) {
                return true;
            }
        }

        return false;
    }
}
