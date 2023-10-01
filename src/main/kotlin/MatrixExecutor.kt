
typealias  ByteMatrix = MutableList<MutableList<Byte>>
class MatrixExecutor {

    fun initMatrix(matrixName: String): ByteMatrix {
        print("Matrix $matrixName. Enter number of rows: ")
        var rows: Int
        while (true) {
            try {
                rows = readLine()!!.toInt()
                break
            } catch (e: Exception) {
                print("Incorrect data format. Enter again: ")
            }
        }
        print("Matrix $matrixName. Enter number of columns: ")
        var cols: Int
        while (true) {
            try {
                cols = readLine()!!.toInt()
                break
            } catch (e: Exception) {
                print("Incorrect data format. Enter again: ")
            }
        }
        val matrix = initEmptyMatrix(rows, cols)
        var i = 0
        var input = ""
        while (i < rows) {
            print("Enter row ${i + 1}: ")
            input = readLine()!!
            val rowData = parseLine(input, cols)
            if (rowData != null) {
                matrix[i++] = rowData
            } else {
                println("Incorrect data format. Try again")
            }
        }
        return matrix
    }

    private fun parseLine(input: String, cols: Int): MutableList<Byte>? {
        return try {
            val result = input.split(" ").map { it.toByte() }
            if (result.size != cols) return null
            result.toMutableList()
        } catch (e: Exception) {
            null
        }
    }

    fun addMatrices(aMatrix: ByteMatrix, bMatrix: ByteMatrix): ByteMatrix {
        val aRows = aMatrix.size
        val aCols = aMatrix[0].size
        val rowsCount = aRows + bMatrix.size
        val colsCount = aCols + bMatrix[0].size
        val resMatrix = initEmptyMatrix(rowsCount, colsCount)
        aMatrix.forEachIndexed { rowIdx, row ->
            row.forEachIndexed { colIdx, col ->
                resMatrix[rowIdx][colIdx] = col
            }
        }
        bMatrix.forEachIndexed { rowIdx, row ->
            row.forEachIndexed { colIdx, col ->
                resMatrix[rowIdx + aRows][colIdx + aCols] = col
            }
        }
        return resMatrix
    }

    private fun initEmptyMatrix(rows: Int, cols: Int) = MutableList(rows) { MutableList(cols) {0.toByte()} }

    fun calculateElementsSum(matrix: ByteMatrix) {
        var biggestElementsSum = 0
        for (i in 1 until matrix.size step 2) {
            biggestElementsSum += matrix[i].maxOf { it }
        }
        var smallestElementsSum = 0
        for (i in 0 until matrix.size step 2) {
            smallestElementsSum += matrix[i].minOf { it }
        }
        println("(5) biggest elements sum: $biggestElementsSum," +
                " smallest elements sum: $smallestElementsSum")
    }

}