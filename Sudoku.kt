

fun sudoku(board: Array<IntArray>): Boolean {
    for (fil in 0 until 9) {
        for (col in 0 until 9) {
            if (board[fil][col] == 0) { 
                for (n in 1..9) {
                    if (esSolucion(board, fil, col, n)) {
                        board[fil][col] = n
                        
                        if (sudoku(board)) return true
                        
                    
                        board[fil][col] = 0
                    }
                }
                return false 
            }
        }
    }
    return true
}


fun esSolucion(board: Array<IntArray>, fil: Int, col: Int, n: Int): Boolean {

    for (i in 0 until 9) {
        if (board[fil][i] == n || board[i][col] == n) return false
    }

    val filaInicio:Int = (fil / 3) * 3
    val columnaInicio:Int = (col / 3) * 3
    for (i in 0 until 3) {
        for (j in 0 until 3) {
            if (board[filaInicio + i][columnaInicio + j] == n) return false
        }
    }
    return true
}

fun main(args: Array<String>) {
    val input = args[0]
    val board = Array(9) { fila ->
        IntArray(9) { col -> input[fila * 9 + col].digitToInt() }
    }

    if (sudoku(board)) {
        println(board.joinToString("") { fila -> fila.joinToString("") })
    } else {
        println("NOSOLUTION")
    }
}