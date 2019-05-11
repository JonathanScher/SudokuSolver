package sudoku

import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SudokuTest {

    @Test
    fun `a grid filled with 0 is valid`() {
        val grid = Array(9) { Array(9) { 0 } }
        val sudoku = Sudoku(SudokuGrid(grid))
        assertTrue(sudoku.isValid())
    }


    @Test
    fun `a grid with two 1 on first line is invalid`() {
        val grid = arrayOf(
            arrayOf(1, 0, 0, 0, 0, 0, 0, 0, 1),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
        )

        val sudokuGrid = SudokuGrid(grid)
        val sudoku = Sudoku(sudokuGrid)
        assertFalse(sudoku.isValid())
    }

    @Test
    fun `a grid with two 1 on first column is invalid`() {
        val grid = arrayOf(
            arrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0)
        )

        val sudokuGrid = SudokuGrid(grid)
        val sudoku = Sudoku(sudokuGrid)
        assertFalse(sudoku.isValid())
    }

    @Test
    fun `a grid with two 1 on last square is invalid`() {
        val grid = arrayOf(
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 1, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1)
        )

        val sudokuGrid = SudokuGrid(grid)
        val sudoku = Sudoku(sudokuGrid)
        assertFalse(sudoku.isValid())
    }

    @Test
    fun `a real valid Sudoku is valid and complete`() {
        val grid = arrayOf(
            arrayOf(4, 3, 5, 2, 6, 9, 7, 8, 1),
            arrayOf(6, 8, 2, 5, 7, 1, 4, 9, 3),
            arrayOf(1, 9, 7, 8, 3, 4, 5, 6, 2),
            arrayOf(8, 2, 6, 1, 9, 5, 3, 4, 7),
            arrayOf(3, 7, 4, 6, 8, 2, 9, 1, 5),
            arrayOf(9, 5, 1, 7, 4, 3, 6, 2, 8),
            arrayOf(5, 1, 9, 3, 2, 6, 8, 7, 4),
            arrayOf(2, 4, 8, 9, 5, 7, 1, 3, 6),
            arrayOf(7, 6, 3, 4, 1, 8, 2, 5, 9)
        )

        val sudokuGrid = SudokuGrid(grid)
        val sudoku = Sudoku(sudokuGrid)
        assertTrue(sudoku.isValid())
        assertTrue(sudoku.isComplete())
    }

    @Test
    fun `a real Sudoku with a 0 is valid but not complete`() {
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

        val sudokuGrid = SudokuGrid(grid)
        val sudoku = Sudoku(sudokuGrid)
        assertTrue(sudoku.isValid())
        assertFalse(sudoku.isComplete())
    }

    @Test
    fun sudokuWithValueAt() {
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
        val sudoku = Sudoku(SudokuGrid(grid))
        val expected = Sudoku(SudokuGrid(expectedGrid))

        val actual = sudoku.sudokuWithValueAt(8, 8, 1)
        assertEquals(expected, actual)
    }

    @Test
    fun `rowProjection initial position returns 0`() {
        val sudoku = Sudoku(SudokuGrid(Array(9) { Array(9) { 0 } }))
        assertEquals(0, sudoku.rowProjection(0))
    }

    @Test
    fun `rowProjection beginning of line returns 0`() {
        val sudoku = Sudoku(SudokuGrid(Array(9) { Array(9) { 0 } }))
        assertEquals(0, sudoku.rowProjection(9))
    }

    @Test
    fun `columnProjection initial position returns 0`() {
        val sudoku = Sudoku(SudokuGrid(Array(9) { Array(9) { 0 } }))
        assertEquals(0, sudoku.columnProjection(0))
    }

    @Test
    fun `columnProjection beginning of column returns 0`() {
        val sudoku = Sudoku(SudokuGrid(Array(9) { Array(9) { 0 } }))
        assertEquals(0, sudoku.columnProjection(2))
    }

    private val sudoku = Sudoku(Array(9) { Array(9) { 0 } })

    @TestFactory
    fun `squareProjectionRow first squares`() = listOf(
        0 to 0,
        0 to 1,
        0 to 2,
        1 to 3,
        1 to 4,
        1 to 5,
        2 to 6,
        2 to 7,
        2 to 8
    ).map { (expected, input) ->
        dynamicTest("squareProjectionRow($input) -> $expected") {
            assertEquals(expected, sudoku.squareProjectionRow(input))
        }
    }

    @TestFactory
    fun `squareProjectionRow 2nd square`() = listOf(
        0 to 9,
        0 to 10,
        0 to 11,
        1 to 12,
        1 to 13,
        1 to 14,
        2 to 15,
        2 to 16,
        2 to 17
    ).map { (expected, input) ->
        dynamicTest("squareProjectionRow($input) -> $expected") {
            assertEquals(expected, sudoku.squareProjectionRow(input))
        }
    }


    @TestFactory
    fun `squareProjectionRow 4th square`() = listOf(
        3 to 27,
        3 to 28,
        3 to 29,
        4 to 30,
        4 to 31,
        4 to 32,
        5 to 33,
        5 to 34,
        5 to 35
    ).map { (expected, input) ->
        dynamicTest("squareProjectionRow($input) -> $expected") {
            assertEquals(expected, sudoku.squareProjectionRow(input))
        }
    }


    @Test
    fun `squareProjectionColumn first square`() {
        val sudoku = Sudoku(SudokuGrid(Array(9) { Array(9) { 0 } }))
        assertEquals(0, sudoku.squareProjectionColumn(0), "initial value")
        assertEquals(1, sudoku.squareProjectionColumn(1), "first step")
        assertEquals(0, sudoku.squareProjectionColumn(3), "second line")
    }


    @Test
    fun `squareProjectionColumn second and third square`() {
        val sudoku = Sudoku(SudokuGrid(Array(9) { Array(9) { 0 } }))
        assertEquals(3, sudoku.squareProjectionColumn(9), "initial problem")
        assertEquals(4, sudoku.squareProjectionColumn(10), "initial problem")
        assertEquals(5, sudoku.squareProjectionColumn(11), "initial problem")
        assertEquals(3, sudoku.squareProjectionColumn(12), "initial problem")
        assertEquals(6, sudoku.squareProjectionColumn(18), "initial problem")
        assertEquals(8, sudoku.squareProjectionColumn(26), "initial problem")

    }

    @Test
    fun `squareProjectionColumn fourth square`() {
        val sudoku = Sudoku(SudokuGrid(Array(9) { Array(9) { 0 } }))
        assertEquals(0, sudoku.squareProjectionColumn(27), "initial problem")
    }

}