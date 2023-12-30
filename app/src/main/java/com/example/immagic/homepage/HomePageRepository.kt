package com.example.immagic.homepage

interface HomePageRepository {
    abstract fun getAlchemyBottles(): String?
    abstract fun getUserLevel(): String?
    abstract fun getEnergyLv(): String?
}