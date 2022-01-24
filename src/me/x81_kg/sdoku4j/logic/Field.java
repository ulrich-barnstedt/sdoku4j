package me.x81_kg.sdoku4j.logic;

public class Field {
    private Cell3[][] cells;

    Field () {
        this.cells = new Cell3[3][3];
    }

    public boolean isFinished () {
        for (Cell3[] arr : cells) {
            for (Cell3 cell : arr) {
                if (!cell.isFinished()) return false;
            }
        }

        return true;
    }

    public void set (int x, int y, int value) {
        int cell_x = (int) Math.floor(x / 3F);
        int cell_y = (int) Math.floor(y / 3F);
        int in_cell_x = x - (cell_x * 3);
        int in_cell_y = y - (cell_y * 3);

        for (int at_y = 0; at_y < 3; at_y++) {
            if (at_y == cell_y) continue;

            this.cells[cell_x][at_y].columnContains(in_cell_y, value);
        }

        for (int at_x = 0; at_x < 3; at_x++) {
            if (at_x == cell_x) continue;

            this.cells[at_x][cell_y].rowContains(in_cell_x, value);
        }

        this.cells[x][y].set(in_cell_x, in_cell_y, value);
    }
}
