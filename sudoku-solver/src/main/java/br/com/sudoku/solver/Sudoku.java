package br.com.sudoku.solver;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

    public static int HEIGHT = 9;
    public static int WIDTH = 9;
    public static int MAX_VALUE = 9;

    private final Integer[][] grid;

    public Sudoku(){
        this.grid = new Integer[HEIGHT][WIDTH];
    }

    public Sudoku(final Sudoku sudoku) {
        this.grid = new Integer[HEIGHT][WIDTH];
        for(int i=0; i<HEIGHT; i++) {
            for(int j=0; j<WIDTH; j++) {
                this.grid[i][j] = sudoku.get(i, j);
            }
        }
    }

    public Integer get(final int row, final int col) {
        return grid[row][col];
    }

    public void put(final int row, final int col, final int value) {
        grid[row][col] = value;
    }

    public void remove(final int row, final int col) {
        grid[row][col] = null;
    }

    public boolean hasValueOnRow(final int row, final int value) {
        for (int i = 0; i < Sudoku.WIDTH; i++) {
            if (Integer.valueOf(value).equals(this.get(row, i))) {
                return true;
            }
        }
        return false;
    }

    public boolean hasValueOnColumn(final int column, final int value) {
        for (int i = 0; i < Sudoku.HEIGHT; i++) {
            if (Integer.valueOf(value).equals(this.get(i, column))) {
                return true;
            }
        }
        return false;
    }

    public boolean hasValueOnSection(final int row, final int column, final int value) {
        final int startRowIndex = (row / 3 * 3);
        final int startColIndex = (column / 3 * 3);
        for (int i = startRowIndex; i < startRowIndex + 3; i++) {
            for (int j = startColIndex; j < startColIndex + 3; j++) {
                if (Integer.valueOf(value).equals(this.get(i, j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCompleted() {
        // validate rows
        for(int i=0; i<HEIGHT; i++) {
            final Set<Integer> valuesOnRow = new HashSet<>();
            for(int j=0; j<WIDTH; j++) {
                if(get(i,j) != null){
                    valuesOnRow.add(get(i,j));
                }
            }
            if(valuesOnRow.size() != 9) {
                return false;
            }
        }
        // validate cols
        for(int i=0; i<WIDTH; i++) {
            final Set<Integer> valuesOnColumn = new HashSet<>();
            for(int j=0; j<HEIGHT; j++) {
                if(get(i,j) != null){
                    valuesOnColumn.add(get(i,j));
                }
            }
            if(valuesOnColumn.size() != MAX_VALUE) {
                return false;
            }
        }
        // validate section
        for(int i=0; i<WIDTH; i = i+3) {
            for(int j=0; j<HEIGHT; j = j+3) {
                final Set<Integer> valuesOnSection = new HashSet<>();
                for(int sectionI=i; sectionI<i+3; sectionI++){
                    for(int sectionJ=j; sectionJ<j+3; sectionJ++){
                        if(get(sectionI, sectionJ) != null) {
                            valuesOnSection.add(get(sectionI, sectionJ));
                        }
                    }
                }
                if(valuesOnSection.size() != MAX_VALUE) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean stillValid() {
        // validate rows
        for(int i=0; i<HEIGHT; i++) {
            final Set<Integer> valuesOnRow = new HashSet<>();
            for(int j=0; j<WIDTH; j++) {
                if(get(i,j) != null){
                    if(valuesOnRow.contains(get(i,j) )) {
                        return false;
                    }
                    valuesOnRow.add(get(i,j));
                }
            }
        }
        // validate cols
        for(int i=0; i<WIDTH; i++) {
            final Set<Integer> valuesOnColumn = new HashSet<>();
            for(int j=0; j<HEIGHT; j++) {
                if(get(i,j) != null){
                    if(valuesOnColumn.contains(get(i,j) )) {
                        return false;
                    }
                    valuesOnColumn.add(get(i,j));
                }
            }
        }
        // validate section
        for(int i=0; i<WIDTH; i = i+3) {
            for(int j=0; j<HEIGHT; j = j+3) {
                final Set<Integer> valuesOnSection = new HashSet<>();
                for(int sectionI=i; sectionI<i+3; sectionI++){
                    for(int sectionJ=j; sectionJ<j+3; sectionJ++){
                        if(get(sectionI, sectionJ) != null) {
                            if(valuesOnSection.contains(get(sectionI,sectionJ) )) {
                                return false;
                            }
                            valuesOnSection.add(get(sectionI, sectionJ));
                        }
                    }
                }
            }
        }
        return true;
    }


    @Override
    public String toString() {
        return SudokuPrinter.instance().stringify(this);
    }
}
