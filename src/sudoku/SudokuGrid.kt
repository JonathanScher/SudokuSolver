package sudoku

class SudokuGrid(private val grid: Array<Array<Int>>) {

    private fun Array<Array<Int>>.copy() = Array(size) { get(it).clone() }

    fun sudokuGridWithValueAt(row: Int, column: Int, value: Int): SudokuGrid {
        val newGrid = grid.copy()
        newGrid[row][column] = value
        return SudokuGrid(newGrid)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SudokuGrid

        if (!grid.contentDeepEquals(other.grid)) return false

        return true
    }

    override fun hashCode(): Int {
        return grid.contentDeepHashCode()
    }

    override fun toString(): String {
        val returned = StringBuilder("")
        grid.forEach {
            it.forEach { value -> returned.append(value) }
            returned.append("\n")
        }
        return returned.toString()
    }

    fun isComplete(): Boolean {
        grid.forEach {
            it.forEach { value -> if (value == 0) return false }
        }
        return true
    }

    fun valueAt(row: Int, column: Int): Int {
        return grid[row][column]
    }
}
