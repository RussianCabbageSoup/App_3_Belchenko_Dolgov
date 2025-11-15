import kotlin.system.exitProcess
interface CheckPhoto {
       fun showCheckPhoto()
}
interface Drink {
    fun drinkSale()
}
abstract class PizzaCity(
    val neapolitanPizzaPrice: Double, val romanPizzaPrice: Double,
    val sicilianPizzaPrice: Double, val tyroleanPizzaPrice: Double
) {
    var neapolitanPizzaCount = 0
    var romanPizzaCount = 0
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0

    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()
    fun showStatistic() {
        println("Sicilian pizza sold: $sicilianPizzaCount")
        println("Roman pizza sold: $romanPizzaCount")
        println("Neapolitan sold: $neapolitanPizzaCount")
        println("Tyrolean pizza sold: $tyroleanPizzaCount")

        println("General profit : ${neapolitanPizzaCount * neapolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice + tyroleanPizzaCount * tyroleanPizzaPrice}")
    }

}
class PizzaPeter(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), Drink {
    override fun drinkSale() {
        println("would you like some coffee?")
        println("1. Sure\n2. I wouldn't, thanks")
        if (readln() == "1") println("The price is 3$")
    }
    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("You got Neapolitan pizza from St.Peterburg")
    }
    override fun romanPizzaSale() {
        romanPizzaCount++
        println("You got Roman pizza from St.Peterburg")
    }
    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("You got Sicilian pizza from St.Peterburg")
    }
    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("You got Tyrolean pizza from St.Peterburg")
    }
}
class PizzaMoscow(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), CheckPhoto {
    override fun showCheckPhoto() {
        println("Do you have a check photo?")
        println("1. I do\n2. No")
        if (readln() == "1") println("You will have price down at 0.7$")
    }
    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("You got Neapolitan pizza from Moscow")
    }
    override fun romanPizzaSale() {
        romanPizzaCount++
        println("You got Roman pizza from Moscow")
    }
    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("You got Sicilian pizza from Moscow")
    }
    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("You got Tyrolean pizza from Moscow")
    }
}

fun main() {
    val pizzaPeter = PizzaPeter(
        175.0, 241.5,
        167.5, 215.0
    )
    val pizzaMoscow = PizzaMoscow(
        215.0, 250.5,
        180.5, 240.0
    )
    var currentPizzaCity: PizzaCity

    while (true) {
        println("Добрый день! Выбирете город")
        println("1. Москва \n2. Санкт-петербург")

        when (readln()) {
            "1" -> currentPizzaCity = pizzaMoscow
            "2" -> currentPizzaCity = pizzaPeter
            "0" -> break
            else -> {
                println("ERROR")
                continue
            }
        }

        println("Выберите пиццу:")
        println("1. Неополитанская пицца\n2. Римская пицца\n3. Сицилийская пицца\n4. Тирольская пицца\n0. Show statistic")

        selectPizza(currentPizzaCity)
    }
}

private fun selectPizza(currentPizzaCity: PizzaCity) {
    when (readln()) {
        "1" -> {
            currentPizzaCity.neapolitanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "2" -> {
            currentPizzaCity.romanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "3" -> {
            currentPizzaCity.sicilianPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "4" -> {
            currentPizzaCity.tyroleanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "0" -> currentPizzaCity.showStatistic()
        else -> {
            println("ERROR")
            exitProcess(1)
        }
    }
}

fun selectAddService(currentPizzaCity: PizzaCity){
    when (currentPizzaCity){
        is CheckPhoto -> currentPizzaCity.showCheckPhoto()
        is Drink -> currentPizzaCity.drinkSale()
    }
}

