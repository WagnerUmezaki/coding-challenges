package br.com.sudoku.solver;

public class Application {

    public static void main(final String... args) {
        final SudokuSolver sudokuSolver = new SudokuSolver(new Sudoku());
        final Sudoku solution = sudokuSolver.solve();
        System.out.println(solution);
    }
}
