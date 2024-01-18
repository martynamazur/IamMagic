package com.example.immagic.nawigation.categories.shop.boosts

data class BoostersItemModel (

    val boostId: Int,
    val boostType: String,
    val boostName: String,
    val boostMultiplier: Int,

    val boostInformation: String, // when user click on , short explanation
    val boostIcon: Int,
    val boostPrice: String,
    val boostDuration: String

)
