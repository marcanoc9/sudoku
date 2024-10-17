public class Sudoku {
  // this is a program to solve a pre-set sudoku puzzle using recursion
  // the program will print the unsolved puzzle and the solved puzzle
  // if the puzzle is unsolvable it will let the user know
  // *Christopher Marcano*
//***************************************************************************************************
    //here i set the size of the board, which will be 9 by 9,

    int puzzleSize = 9;

    // here i create the sudoku template, i chose a random arrangement that i found online.
    //this can be freely modified as long as each "spot" is filled with an integer between 0 and 9

    public static int[][] puzzle = {

            {0,0,0,0,9,1,4,0,0},

            {0,0,0,7,0,0,0,0,0},

            {5,0,3,0,0,4,9,0,0},

            {7,0,4,0,0,0,0,5,0},

            {9,0,0,0,2,0,0,0,1},

            {0,2,0,0,0,0,6,0,4},

            {0,0,6,3,0,0,5,0,7},

            {0,0,0,0,7,6,0,0,0},

            {0,0,7,8,1,0,0,0,0},
    };
    //this section takes the board size and further defines the array
    private int[][] sudokuPuzzle;

    public static final int eValue = 0;

    public Sudoku(int[][] sudokuPuzzle) {

        this.sudokuPuzzle = new int[puzzleSize][puzzleSize];

        for (int i1 = 0; i1 < puzzleSize; i1++) {

            for (int j1 = 0; j1 < puzzleSize; j1++) {

                this.sudokuPuzzle[i1][j1] = sudokuPuzzle[i1][j1];
            } } }
            // this section looks at the rows and checks values
    private boolean isRow(int row1, int n) {

        for (int i1 = 0; i1 < puzzleSize; i1++)

            if (sudokuPuzzle[row1][i1] == n)

                return true;



        return false;
    }
    // this does the same as above but for the columns
    private boolean isColumn(int col1, int n) {

        for (int i1 = 0; i1 < puzzleSize; i1++)

            if (sudokuPuzzle[i1][col1] == n)

                return true;

            return false;
    }
    // now the program will look at each 3 by 3 grid
    private boolean isGrid(int row1, int col1, int n) {

        int r1 = row1 - row1 % 3;

        int c1 = col1 - col1% 3;

        for (int i1 = r1; i1 < r1 + 3; i1++)

            for (int j1 = c1; j1 < c1 + 3; j1++)

                if (sudokuPuzzle[i1][j1] == n)

                    return true;

                return false;
    }
    // confirms whether row and column composition is correct

    private boolean isCorrect(int row1, int col1, int n) {

        return !isRow(row1, n) && !isColumn(col1, n) && !isGrid(row1, col1, n);
    }
    // this begins the recursive method of solving the puzzle
    public boolean solve() {

        for (int row1 = 0; row1 < puzzleSize; row1++) {

            for (int col1 = 0; col1 < puzzleSize; col1++) {
                // this finds the empty values (the zeros on the board)
                if (sudokuPuzzle[row1][col1] == eValue) {
                    // it then checks the possible values
                    for (int n = 1; n <= puzzleSize; n++) {

                        if (isCorrect(row1, col1, n)) {
                            // checks if they are correct

                            sudokuPuzzle[row1][col1] = n;

                            if (solve()) {

                                return true;

                            } else {

                                sudokuPuzzle[row1][col1] = eValue;

                            } } }

                    return false;

                } } }

        return true;
    }
    //this prints the board
    public void print() {

        for (int i1 = 0; i1 < puzzleSize; i1++) {

            for (int j1 = 0; j1 < puzzleSize; j1++) {

                System.out.print(" " + sudokuPuzzle[i1][j1]);
            }
            System.out.println();
        }
        System.out.println();
    }
// unsolved puzzle
    public static void main(String[] args) {

        Sudoku sudokuPuzzle1 = new Sudoku(puzzle);

        System.out.println("unsolved puzzle: ");

        sudokuPuzzle1.print();
        // solved puzzle

        if (sudokuPuzzle1.solve()) {

            System.out.println("solved puzzle: ");

            sudokuPuzzle1.print();
// tells the user if the puzzle can not be solved
        } else {

            System.out.println("This puzzle is not solvable.");
        }}}


