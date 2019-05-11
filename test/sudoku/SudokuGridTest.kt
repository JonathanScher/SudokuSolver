package sudoku

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotSame

class SudokuGridTest {

    @Test
    fun `two SudokuGrids with same values are equals`() {
        val grid1 = arrayOf(
            arrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
        )

        val grid2 = arrayOf(
            arrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
        )

        val sudoku1 = SudokuGrid(grid1)
        val sudoku2 = SudokuGrid(grid2)

        assertEquals(sudoku1, sudoku2)
    }


    @Test
    fun `sudokuGridWithValueAt creates a new instance with the proper digit at the proper location`() {
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

        val grid = Array(9) { Array(9) { 0 } }
        val sudoku = SudokuGrid(grid)
        val expected = SudokuGrid(expectedGrid)

        val actual = sudoku.sudokuGridWithValueAt(8, 8, 1)
        assertEquals(expected, actual)
        assertNotSame(sudoku, actual)
    }
}