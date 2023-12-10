package com.example.immagic.nawigation.categories.shop.treasurechest

interface  ChestDialogRepository {

    suspend fun getChestInformation(chestId: Int): TreasureChestModel
    suspend fun getInfAboutAmountOfOwnedChest(chestType: String): Int?
    suspend fun updateChestQuantity(chestType: String, newValue: Int)
}