

fun main() {
    val executor = MatrixExecutor()
    val aMatrix = executor.initMatrix("A")
    println("matrix a: $aMatrix")
    val bMatrix = executor.initMatrix("B")
    println("matrix b: $bMatrix")
    val cMatrix = executor.addMatrices(aMatrix, bMatrix)
    println("matrix c: $cMatrix")
    executor.calculateElementsSum(cMatrix)
}
