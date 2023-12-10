import kotlin.random.Random

data class Nagroda(val nazwa: String, val ilosc: Int = 1)

class WeightedRandomPicker<T : Nagroda> {
    private val itemsWithWeights = mutableListOf<Pair<T, Int>>()

    fun addItem(item: T, weight: Int) {
        itemsWithWeights.add(item to weight)
    }

    fun pickRandomItem(): T? {
        if (itemsWithWeights.isEmpty()) {
            return null
        }

        val totalWeight = itemsWithWeights.sumOf { it.second }
        var randomWeight = Random.nextInt(totalWeight)

        for ((item, weight) in itemsWithWeights) {
            if (randomWeight < weight) {
                return item
            }
            randomWeight -= weight
        }

        return null // In case of unexpected situation
    }
}

fun setUpChest() {


    val basicChestPicker = WeightedRandomPicker<Nagroda>()
    val rareChestPicker = WeightedRandomPicker<Nagroda>()
    val specialChestPicker = WeightedRandomPicker<Nagroda>()

    basicChestPicker.addItem(Nagroda("Puzzel", 1), 3)
    basicChestPicker.addItem(Nagroda("Puzzel", 2), 1)
    basicChestPicker.addItem(Nagroda("AlchemyCoins", 20), 5)
    basicChestPicker.addItem(Nagroda("AlchemyCoins", 30), 5)
    basicChestPicker.addItem(Nagroda("AlchemyCoins", 40), 5)
    basicChestPicker.addItem(Nagroda("AlchemyCoins", 50), 5)
    basicChestPicker.addItem(Nagroda("AlchemyCoins", 60), 5)
    basicChestPicker.addItem(Nagroda("AlchemyCoins", 90), 5)
    basicChestPicker.addItem(Nagroda("AlchemyCoins", 200), 5)
    basicChestPicker.addItem(Nagroda("Boost1x2min", 1), 3)
    basicChestPicker.addItem(Nagroda("Boost1x2min", 2), 3)
    basicChestPicker.addItem(Nagroda("Boost1x7min", 1), 3)
    basicChestPicker.addItem(Nagroda("Puzzel", 2), 1)

    rareChestPicker.addItem(Nagroda("Puzzel", 1), 3)
    rareChestPicker.addItem(Nagroda("Puzzel", 2), 1)
    rareChestPicker.addItem(Nagroda("AlchemyCoins", 20), 5)
    rareChestPicker.addItem(Nagroda("AlchemyCoins", 30), 5)
    rareChestPicker.addItem(Nagroda("AlchemyCoins", 40), 5)
    rareChestPicker.addItem(Nagroda("AlchemyCoins", 50), 5)
    rareChestPicker.addItem(Nagroda("AlchemyCoins", 60), 5)
    rareChestPicker.addItem(Nagroda("AlchemyCoins", 90), 5)
    rareChestPicker.addItem(Nagroda("AlchemyCoins", 200), 5)
    rareChestPicker.addItem(Nagroda("Boost1x2min", 1), 3)
    rareChestPicker.addItem(Nagroda("Boost1x2min", 2), 3)
    rareChestPicker.addItem(Nagroda("Boost1x7min", 1), 3)
    rareChestPicker.addItem(Nagroda("Puzzel", 2), 1)


// Teraz możesz użyć każdej z tych instancji w zależności od tego, jaką skrzynkę otwiera użytkownik
    val nagrodaZBasicChest = basicChestPicker.pickRandomItem()
    val nagrodaZPremiumChest = rareChestPicker.pickRandomItem()
    val nagrodaZSpecialChest = specialChestPicker.pickRandomItem()


}
