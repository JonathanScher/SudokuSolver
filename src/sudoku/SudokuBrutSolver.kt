package sudoku

class SudokuBrutSolver(private val sudoku: Sudoku) {

    private var currentSudoku: Sudoku = sudoku

    constructor(sudoku: Sudoku, currentSudoku: Sudoku) : this(sudoku) {
        this.currentSudoku = currentSudoku
    }

    fun nextSudoku(): Sudoku {
        var nextSudoku = currentSudoku
        var finished = false
        var row = 8
        var column = 8
        while (!finished) {
            val value = nextSudoku.valueAt(row, column) + 1
            if (value < 10) {
                nextSudoku = nextSudoku.sudokuWithValueAt(row, column, value)
                finished = true
            } else {
                nextSudoku = nextSudoku.sudokuWithValueAt(row, column, 1)
                val pair = nextPosition(column, row)
                column = pair.first
                row = pair.second
            }
        }
        return nextSudoku
    }

    private fun nextPosition(column: Int, row: Int): Pair<Int, Int> {
        var column1 = column
        var row1 = row
        column1--
        if (column1 < 0) {
            row1--
            column1 = 8
        }
        return Pair(column1, row1)
    }

    fun bruteForceASolution(): Sudoku {
        var solved = currentSudoku
        var counter = 0
        while (!(solved.isComplete() && solved.isValid())) {

            solved = SudokuBrutSolver(solved).nextSudoku()
            if (counter % 1000000 == 0) {
                System.out.println(solved)
                System.out.println("-----------")
            }
            counter++
        }
        return solved
    }

}
