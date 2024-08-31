package br.com.sudoku.solver;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SudokuSolverTest {

    @Test
    public void emptySudoku(){
        final Sudoku solution = new SudokuSolver(new Sudoku()).solve();
        Assert.assertNotNull(solution);
        Assert.assertTrue(solution.isCompleted());
    }

    /**
     * -------------------------------
     * |       1 |         |         |
     * |       2 |    3    |       4 |
     * |         | 5       | 6     7 |
     * -------------------------------
     * | 5       | 1  4    |         |
     * |    7    |         |    2    |
     * |         |    7  8 |       9 |
     * -------------------------------
     * | 8     7 |       9 |         |
     * | 4       |    6    | 3       |
     * |         |         | 5       |
     * -------------------------------
     */
    @Test
    public void initializedValidSudoku(){
        final Sudoku sudoku = new Sudoku();
        sudoku.put(0, 2, 1);
        sudoku.put(1, 2, 2);
        sudoku.put(1, 4, 3);
        sudoku.put(1, 8, 4);
        sudoku.put(2, 3, 5);
        sudoku.put(2, 6, 6);
        sudoku.put(2, 8, 7);
        sudoku.put(3, 0, 5);
        sudoku.put(3, 3, 1);
        sudoku.put(3, 4, 4);
        sudoku.put(4, 1, 7);
        sudoku.put(4, 7, 2);
        sudoku.put(5, 4, 7);
        sudoku.put(5, 5, 8);
        sudoku.put(5, 8, 9);
        sudoku.put(6, 0, 8);
        sudoku.put(6, 2, 7);
        sudoku.put(6, 5, 9);
        sudoku.put(7, 0, 4);
        sudoku.put(7, 4, 6);
        sudoku.put(7, 6, 3);
        sudoku.put(8, 6, 5);
        System.out.println("Problem");
        System.out.println(sudoku);
        final Sudoku solution = new SudokuSolver(sudoku).solve();
        System.out.println(solution);
        Assert.assertNotNull(solution);
        Assert.assertTrue(solution.isCompleted());

        Assert.assertEquals(solution.get(0, 2), sudoku.get(0,2));
        Assert.assertEquals(solution.get(1, 2), sudoku.get(1,2));
        Assert.assertEquals(solution.get(1, 4), sudoku.get(1,4));
        Assert.assertEquals(solution.get(1, 8), sudoku.get(1,8));
        Assert.assertEquals(solution.get(2, 3), sudoku.get(2,3));
        Assert.assertEquals(solution.get(2, 6), sudoku.get(2, 6));
        Assert.assertEquals(solution.get(2, 8), sudoku.get(2, 8));
        Assert.assertEquals(solution.get(3, 0), sudoku.get(3, 0));
        Assert.assertEquals(solution.get(3, 3), sudoku.get(3, 3));
        Assert.assertEquals(solution.get(3, 4), sudoku.get(3, 4));
        Assert.assertEquals(solution.get(4, 1), sudoku.get(4, 1));
        Assert.assertEquals(solution.get(4, 7), sudoku.get(4, 7));
        Assert.assertEquals(solution.get(5, 4), sudoku.get(5, 4));
        Assert.assertEquals(solution.get(5, 5), sudoku.get(5, 5));
        Assert.assertEquals(solution.get(5, 8), sudoku.get(5, 8));
        Assert.assertEquals(solution.get(6, 0), sudoku.get(6, 0));
        Assert.assertEquals(solution.get(6, 2), sudoku.get(6, 2));
        Assert.assertEquals(solution.get(6, 5), sudoku.get(6, 5));
        Assert.assertEquals(solution.get(7, 0), sudoku.get(7, 0));
        Assert.assertEquals(solution.get(7, 4), sudoku.get(7, 4));
        Assert.assertEquals(solution.get(7, 6), sudoku.get(7, 6));
        Assert.assertEquals(solution.get(8, 6), sudoku.get(8, 6));
    }

    /**
     * -------------------------------
     * |         |         |         |
     * |         |         |         |
     * |         |         |         |
     * -------------------------------
     * |         |         |         |
     * |         |         |         |
     * |         |         |         |
     * -------------------------------
     * |         |         |         |
     * |         |         |         |
     * | 1     2 |         |         |
     * -------------------------------
     */
    @Test
    public void initializedValidSudoku2(){
        final Sudoku sudoku = new Sudoku();
        sudoku.put(8, 0, 1);
        sudoku.put(8, 2, 2);
        System.out.println("Problem");
        System.out.println(sudoku);
        final Sudoku solution = new SudokuSolver(sudoku).solve();
        System.out.println(solution);
        Assert.assertNotNull(solution);
        Assert.assertTrue(solution.isCompleted());

        Assert.assertEquals(solution.get(8, 0), sudoku.get(8, 0));
        Assert.assertEquals(solution.get(8, 2), sudoku.get(8, 2));
    }

    @Test
    public void invalidSudoku() {
        final Sudoku sudoku = new Sudoku();
        sudoku.put(0, 2, 1);
        sudoku.put(1, 2, 1);
        final Sudoku solution = new SudokuSolver(sudoku).solve();
        Assert.assertNull(solution);
    }

    @Test
    public void initializedInvalidSudoku2(){
        final Sudoku sudoku = new Sudoku();
        sudoku.put(0, 0, 2);
        sudoku.put(0, 3, 9);
        sudoku.put(1, 7, 6);
        sudoku.put(2, 5, 1);
        sudoku.put(3, 0, 5);
        sudoku.put(3, 2, 2);
        sudoku.put(3, 3, 6);
        sudoku.put(3, 6, 4);
        sudoku.put(3, 8, 7);
        sudoku.put(4, 5, 4);
        sudoku.put(4, 6, 1);
        sudoku.put(5, 4, 9);
        sudoku.put(5, 5, 8);
        sudoku.put(5, 7, 2);
        sudoku.put(5, 8, 3);
        sudoku.put(6, 5, 3);
        sudoku.put(6, 7, 8);
        sudoku.put(7, 2, 5);
        sudoku.put(7, 4, 1);
        sudoku.put(8, 2, 7);
        final Sudoku solution = new SudokuSolver(sudoku).solve();
        Assert.assertNull(solution);
    }
}
