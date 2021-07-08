package br.com.sudoku.solver;

public final class SudokuSolver {

    private final Sudoku sudoku;
    private final Sudoku originalSudoku;

    SudokuSolver(final Sudoku sudoku) {
        this.sudoku = new Sudoku(sudoku);
        this.originalSudoku = new Sudoku(sudoku);
    }

    public Sudoku solve() {
        return solve(0,0);
    }

    private Sudoku solve(final int row, final int col) {
        if (sudoku.isCompleted()) {
            return sudoku;
        }
        if(!sudoku.stillValid()) {
            return null;
        }

        boolean numberFound = false;
        for (int i = 1; i <= Sudoku.MAX_VALUE; i++) {

            if(canOverride(row, col)) {
                if (isValidPut(sudoku, row, col, i)) {
                    sudoku.put(row, col, i);
                    numberFound = true;
                }
            } else {
                numberFound = true;
            }

            if (numberFound) {
                if (sudoku.isCompleted()) {
                    return sudoku;
                }
                Sudoku solution = null;
                if (col < Sudoku.WIDTH - 1) {
                    solution = solve(row, col + 1);
                } else if (row < Sudoku.HEIGHT - 1) {
                    solution = solve(row + 1, 0);
                }

                if (solution == null) {
                    if(canOverride(row, col)) {
                        numberFound = false;
                        sudoku.remove(row, col);
                    } else {
                        return null;
                    }
                } else {
                    return solution;
                }
            }
        }

        return null;
    }

    private boolean isValidPut(final Sudoku sudoku, final int row, final int col, final int value) {
        if (sudoku.hasValueOnRow(row, value)) {
            return false;
        }

        if (sudoku.hasValueOnColumn(col, value)) {
            return false;
        }

        if (sudoku.hasValueOnSection(row, col, value)) {
            return false;
        }

        return true;
    }

    private boolean canOverride(final int row, final int col) {
        return originalSudoku.get(row, col) == null;
    }
}
