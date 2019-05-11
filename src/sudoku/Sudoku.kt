package sudoku

class Sudoku(private val grid: SudokuGrid) {

    constructor(array2D: Array<Array<Int>>) : this(SudokuGrid(array2D))

    fun isValid(): Boolean {
        val rowDuplicate = HashSet<Int>()
        val columnDuplicate = HashSet<Int>()
        val squareDuplicate = HashSet<Int>()
        for (step in 0..80) {

            val row = rowProjection(step)
            val column = columnProjection(step)
            val squareProjectionRow = squareProjectionRow(step)
            val squareProjectionColumn = squareProjectionColumn(step)

            val rowProjectionValue = grid.valueAt(row, column)
            val columnProjectionValue = grid.valueAt(column, row)
            val squareProjectionValue = grid.valueAt(squareProjectionRow, squareProjectionColumn)


            if (!validate(rowDuplicate, step, rowProjectionValue)
                || !validate(columnDuplicate, step, columnProjectionValue)
                || !validate(squareDuplicate, step, squareProjectionValue)
            ) return false
        }

        return true
    }

    private fun validate(
        duplicate: HashSet<Int>,
        step: Int,
        value: Int
    ): Boolean {
        var valid = true

        if (step % 9 == 0) {
            duplicate.clear()
        }

        if (positiveValueAlreadySeen(value, duplicate)) valid = false

        duplicate.add(value)
        return valid
    }

    private fun positiveValueAlreadySeen(
        rowProjectionValue: Int,
        rowDuplicate: Set<Int>
    ) = rowProjectionValue != 0 && rowDuplicate.contains(rowProjectionValue)

    fun isComplete(): Boolean = grid.isComplete()

    fun sudokuWithValueAt(row: Int, column: Int, value: Int): Sudoku =
        Sudoku(grid.sudokuGridWithValueAt(row, column, value))

    fun valueAt(row: Int, column: Int): Int = grid.valueAt(row, column)

    fun rowProjection(index: Int): Int = index % 9

    fun columnProjection(index: Int): Int = index / 9
    fun squareProjectionRow(step: Int): Int = (step / 3) % 3 + 3 * (step / 27)
    fun squareProjectionColumn(step: Int): Int = (step % 3 + 3 * (step / 9)) % 9

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Sudoku

        if (grid != other.grid) return false

        return true
    }

    override fun hashCode(): Int = grid.hashCode()

    override fun toString(): String = "Sudoku(grid=$grid)"
}
