package sudoku

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SudokuBrutSolverTest {
    private val emptySudoku = Sudoku(Array(9) { Array(9) { 0 } })
    @Test
    fun `next grid for empty grid has a trailing 1`() {
        val grid = Array(9) { Array(9) { 0 } }
        val expectedGrid = arrayOf(
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1)
        )

        val solver = SudokuBrutSolver(emptySudoku, Sudoku(grid))
        val next = solver.nextSudoku()
        val expected = Sudoku(SudokuGrid(expectedGrid))

        assertEquals(expected, next)
    }

    @Test
    fun `next grid for trailing 1 has trailing 2`() {
        val grid = arrayOf(
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1)
        )

        val expectedGrid = arrayOf(
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 2)
        )

        val solver = SudokuBrutSolver(emptySudoku, Sudoku(grid))
        val next = solver.nextSudoku()
        val expected = Sudoku(SudokuGrid(expectedGrid))

        assertEquals(expected, next)
    }


    @Test
    fun `next grid for trailing 9 has trailing 1 1`() {
        val grid = arrayOf(
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 9)
        )

        val expectedGrid = arrayOf(
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1)
        )

        val solver = SudokuBrutSolver(emptySudoku, Sudoku(grid))
        val next = solver.nextSudoku()
        val expected = Sudoku(SudokuGrid(expectedGrid))

        assertEquals(expected, next)
    }

    // Carefull : building a solution from scratch is a lengthy operation
    //  @Test
    fun bruteForceASolution() {
        val grid = arrayOf(
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
        )
        val solver = SudokuBrutSolver(emptySudoku, Sudoku(grid))
        solver.bruteForceASolution()
    }


    @Test
    fun `Solving a simple Sudoku `() {
        val grid = arrayOf(
            arrayOf(4, 3, 5, 2, 6, 9, 7, 8, 1),
            arrayOf(6, 8, 2, 5, 7, 1, 4, 9, 3),
            arrayOf(1, 9, 7, 8, 3, 4, 5, 6, 2),
            arrayOf(8, 2, 6, 1, 9, 5, 3, 4, 7),
            arrayOf(3, 7, 4, 6, 8, 2, 9, 1, 5),
            arrayOf(9, 5, 1, 7, 4, 3, 6, 2, 8),
            arrayOf(5, 1, 9, 3, 2, 6, 8, 7, 4),
            arrayOf(2, 4, 8, 9, 5, 7, 1, 3, 6),
            arrayOf(7, 6, 3, 4, 1, 8, 2, 0, 9)
        )

        val solver = SudokuBrutSolver(emptySudoku, Sudoku(grid))
        solver.bruteForceASolution()
    }
}