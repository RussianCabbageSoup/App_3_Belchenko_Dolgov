class triangle {
    var x1 = 0
    var y1 = 0;

    fun getPoints(){
        println("X1: ${x1}, Y1: ${y1}")
    }
}

fun main() {

    while (true) {

        println("Choose the application (1-5)")
        val input = readln()
        val value = input.toIntOrNull()
        println()

        when (value) {
            1 -> {

            }

            2 -> {

            }

            3 -> {

            }

            4 -> {

            }

            5 -> {

            }

            else -> {
                println("Wrong exit")
                break;
            }
        }
        println();
    }
}