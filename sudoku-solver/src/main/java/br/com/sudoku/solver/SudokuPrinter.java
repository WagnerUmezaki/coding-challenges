package br.com.sudoku.solver;

final class SudokuPrinter {

    private static final SudokuPrinter INSTANCE = new SudokuPrinter();

    public static SudokuPrinter instance() {
        return INSTANCE;
    }

    private SudokuPrinter() {
    }

    public String stringify(final Sudoku sudoku) {
        final StringBuilder builder = new StringBuilder();
        for(int row=0; row<Sudoku.HEIGHT; row++) {
            if(row % 3 == 0) {
                builder.append("-------------------------------\n");
            }
            for(int col=0; col<Sudoku.WIDTH; col++) {
                if(col % 3 == 0) {
                    builder.append("|");
                }
                Integer value = sudoku.get(row, col);
                if(value == null) {
                    builder.append("   ");
                } else {
                    builder.append(" ").append(value).append(" ");
                }
            }
            builder.append("|\n");
        }
        builder.append("-------------------------------\n");
        return builder.toString();
    }
}
