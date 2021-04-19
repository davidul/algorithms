package davidul.utils;

public class Sudoku {

    public static void main(String[] args) {
        final Sudoku sudoku = new Sudoku();
        /*final int[][] a = sudoku.create(9, 9);
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            String line = in.nextLine();
            String [] b = line.split("");
            for(int j = 0; j < b.length; j++){
                a[i][j] = Integer.valueOf(b[j]);
            }
        }*/

        for(int i = 1; i < 10; i++){
            final int i1 = i / 3;
            System.out.println(i1);
        }

        final int[][] ints = sudoku.create(9, 9);
        int[][] sample = new int[][]{
                {0, 0, 6, 0, 0, 0, 7, 5, 1},
                {2, 0, 0, 7, 0, 0, 0, 9, 0},
                {0, 5, 0, 0, 0, 6, 4, 8, 0},
                {9, 0, 2, 0, 7, 0, 0, 0, 4},
                {3, 7, 4, 0, 0, 0, 8, 0, 0},
                {1, 8, 5, 4, 2, 9, 0, 0, 7},
                {0, 0, 1, 9, 0, 0, 0, 7, 0},
                {0, 0, 9, 0, 5, 0, 1, 0, 0},
                {0, 2, 7, 6, 0, 3, 0, 4, 5}};

        int [][] sample1 = new int[][]{
                {1, 2, 0, 0, 7, 0, 5, 6, 0},
                {5, 0, 7, 9, 3, 2, 0, 8, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 2, 4, 0, 0, 5, 0},
                {3, 0, 8, 0, 0, 0, 4, 0, 2},
                {0, 7, 0, 0, 8, 5, 0, 1, 0},
                {0, 0, 0, 7, 0, 0, 0, 0, 0},
                {0, 8, 0, 4, 2, 3, 7, 0, 1},
                {0, 3, 4, 0, 1, 0, 0, 2, 8}
        };

        sudoku.solve(sample1, 9, 9);
        sudoku.print(sample1);
    }

    private int width;
    private int height;

    /**
     * The "main" method to solve sudoku.
     * @param a 9x9 grid
     * @return
     */
    public boolean solve(int[][] a, int width, int height) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (a[x][y] == 0) {
                    for (int i = 9; i > 0; i--) {
                        a[x][y] = i;
                        if (isValid(a, x, y) && solve(a, width, height)) {
                            return true;
                        }else {
                            a[x][y] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks the validity of the grid according to sudoku rules.
     * @param a grid
     * @param r row
     * @param c column
     * @return validity
     */
    public boolean isValid(int [][] a, int r, int c){
        final int[] row = row(a, r);
        final int[] col = col(a, c);
        final int[][] square = square(a, r, c);
        System.out.println(duplicate(row));
        System.out.println(duplicate(col));
        System.out.println(duplicate(square));


        return duplicate(row) && duplicate(col) && duplicate(square);
    }

    /**
     * Checks for duplicate item row or column (1d-array)
     * @param a
     * @return
     */
    public boolean duplicate(int[] a){
        int [] counter = new int[a.length];
        for(int i = 0; i < a.length; i++){
            final int item = a[i] - 1;
            if(item >= 0) {
                int count = counter[item];
                ++count;
                if (count > 1) {
                    return false;
                }
                counter[item] = count;
            }
        }
        return true;
    }

    /**
     * Checks for duplicate item in a square
     * @param a square
     * @return
     */
    public boolean duplicate(int [][] a){
        final int[] ints = new int[a.length * a[0].length];
        for(int i = 0; i < a.length; i++){
            final int[] ints1 = a[i];
            for(int j = 0; j < ints1.length; j++){
                if(i == 0) {
                    ints[j] = ints1[j];
                }
                ints[i * j] = ints1[j];
            }

        }

        return duplicate(ints);

    }

    public boolean canPlaceNumber(int[][] a, int row, int col, int n) {
        final boolean b = containsRow(a, row, n);
        final boolean b1 = containsCol(a, col, n);
        final boolean b2 = containsSquare(a, row, col, n);
        return !b && !b1 && !b2;
    }

    public boolean containsRow(int[][] a, int row, int n) {
        final int[] r = row(a, row);
        for (int x : r) {
            if (x == n) {
                return true;
            }
        }
        return false;
    }

    public boolean containsCol(int[][] a, int col, int n) {
        int[] c = col(a, col);
        for (int x : c) {
            if (x == n) {
                return true;
            }
        }

        return false;
    }

    /**
     * Extracts a square of size 3x3 for given coordinates.
     * In the grid 9x9 there are 9 squares.
     *
     * @param a
     * @param row
     * @param col
     * @return
     */
    public int[][] square(int [][] a, int row, int col){
        int xr = row / 3;
        int xc = col / 3;
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        int [][] square = new int[3][3];

        for (int i = startRow; xr == i / 3; i++) {
            for (int k = startCol; xc == k / 3; k++) {
                square[i%3][k%3] = a[i][k];
            }
        }

        return square;
    }

    public boolean containsSquare(int[][] a, int row, int col, int n) {
        int xr = row / 3;
        int xc = col / 3;
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = startRow; xr == i / 3; i++) {
            for (int k = startCol; xc == k / 3; k++) {
                if (a[i][k] == n) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Allocate x*y grid.
     * @param x width
     * @param y height
     * @return allocated grid
     */
    public int[][] create(int x, int y) {
        return new int[x][y];
    }

    /**
     * Extracts a row from a grid
     * @param a grid
     * @param row row
     * @return a row
     */
    public int[] row(int[][] a, int row) {
        return a[row];
    }

    /**
     * Extracts a column from a grid
     * @param a grid
     * @param col
     * @return
     */
    public int[] col(int[][] a, int col) {
        int[] colArray = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            colArray[i] = a[i][col];
        }

        return colArray;
    }

    public void print(int [][] a){
        for(int i = 0; i < a.length; i++){
            final int[] items = a[i];
            for(int j = 0; j < items.length; j++){
                System.out.print(items[j] + " ");
            }
            System.out.println("");
        }
    }
}
